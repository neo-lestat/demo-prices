package com.example.demoprices.rest.controller;

import com.example.demoprices.model.Brand;
import com.example.demoprices.model.Price;
import com.example.demoprices.model.Product;
import com.example.demoprices.repository.PriceRepository;
import com.example.demoprices.rest.dto.PriceResponse;
import com.example.demoprices.rest.mapper.PriceMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PriceResource.class)
class PriceResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PriceRepository repository;

    @MockBean
    private PriceMapper priceMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findPriceIsFound() throws Exception {
        Price price = buildPrice();
        Optional<Price> priceOptional = Optional.of(price);
        given(repository.findPrices(anyLong(), anyLong(), any(LocalDateTime.class))).willReturn(priceOptional);
        given(priceMapper.map(price)).willReturn(buildPriceResponse(price));
        mvc.perform(post("/api/prices/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", equalTo(1)))
                .andExpect(jsonPath("$.brandId", equalTo(1)))
                .andExpect(jsonPath("$.priceId", equalTo(1)))
                .andExpect(jsonPath("$.startDate", equalTo(price.getStartDate().toString())))
                .andExpect(jsonPath("$.endDate", equalTo(price.getEndDate().toString())))
                .andExpect(jsonPath("$.price", equalTo(35.5)))
                .andExpect(jsonPath("$.currency", equalTo("EUR")));
    }

    @Test
    void findPriceIsNotFound() throws Exception {
        Optional<Price> priceOptional = Optional.empty();
        given(repository.findPrices(anyLong(), anyLong(), any(LocalDateTime.class))).willReturn(priceOptional);
        mvc.perform(post("/api/prices/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.statusCode", equalTo(404)))
                .andExpect(jsonPath("$.message", containsString("Price not found with")));
    }

    private String jsonBody() {
        return """
                {
                	"applicationDate" : "2020-06-14T13:00:00",
                	"brandId": 1,
                	"productId": 1
                }
                """;
    }

    private Price buildPrice(){
        Price price = new Price();
        price.setId(1L);
        LocalDateTime localDateTime = LocalDateTime.now();
        price.setStartDate(localDateTime);
        price.setEndDate(localDateTime.plusDays(5));
        price.setPriority(1);
        price.setPrice(35.5);
        price.setCurrency("EUR");
        Brand brand = new Brand();
        brand.setId(1L);
        price.setBrand(brand);
        Product product = new Product();
        product.setId(1L);
        price.setProduct(product);

        return price;
    }

    private PriceResponse buildPriceResponse(Price price) {
        return new PriceResponse(
                price.getProduct().getId(),
                price.getBrand().getId(),
                price.getId(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPrice(),
                price.getCurrency());
    }

}