package com.example.demoprices.rest.controller;

import com.example.demoprices.rest.dto.PriceResponse;
import com.example.demoprices.rest.dto.PriceSearch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceResourceAcceptanceTest {

    private static final Long PRODUCT_ID = 35455L;
    private static final Long BRAND_ID = 1L;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getSearchPriceUrl() {
        return "http://localhost:%s/api/prices/search".formatted(port);
    }

    @Test
    void testFindPriceDay14At10Hours() {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T10:00:00");
        PriceSearch priceSearch = new PriceSearch(applicationDate, PRODUCT_ID, BRAND_ID);
        ResponseEntity<PriceResponse> response = restTemplate.postForEntity(getSearchPriceUrl(),
                priceSearch,
                PriceResponse.class);
        assertThat(response.getStatusCode().value(), is(200));
        PriceResponse priceResponse = response.getBody();
        assertThat(priceResponse, notNullValue());
        assertThat(priceResponse.priceId(), is(1L));
        assertThat(priceResponse.productId(), is(35455L));
        assertThat(priceResponse.brandId(), is(1L));
        assertThat(priceResponse.startDate(), is(LocalDateTime.parse("2020-06-14T00:00:00")));
        assertThat(priceResponse.endDate(), is(LocalDateTime.parse("2020-12-31T23:59:59")));
        assertThat(priceResponse.price(), is(35.5));
        assertThat(priceResponse.currency(), is("EUR"));
    }

    @Test
    void testFindPriceDay14At16Hours() {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T16:00:00");
        PriceSearch priceSearch = new PriceSearch(applicationDate, PRODUCT_ID, BRAND_ID);
        ResponseEntity<PriceResponse> response = restTemplate.postForEntity(getSearchPriceUrl(),
                priceSearch,
                PriceResponse.class);
        assertThat(response.getStatusCode().value(), is(200));
        PriceResponse priceResponse = response.getBody();
        assertThat(priceResponse, notNullValue());
        assertThat(priceResponse.priceId(), is(2L));
        assertThat(priceResponse.productId(), is(35455L));
        assertThat(priceResponse.brandId(), is(1L));
        assertThat(priceResponse.startDate(), is(LocalDateTime.parse("2020-06-14T15:00:00")));
        assertThat(priceResponse.endDate(), is(LocalDateTime.parse("2020-06-14T18:30:00")));
        assertThat(priceResponse.price(), is(25.45));
        assertThat(priceResponse.currency(), is("EUR"));
    }

    @Test
    void testFindPriceDay14At21Hours() {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14T21:00:00");
        PriceSearch priceSearch = new PriceSearch(applicationDate, PRODUCT_ID, BRAND_ID);
        ResponseEntity<PriceResponse> response = restTemplate.postForEntity(getSearchPriceUrl(),
                priceSearch,
                PriceResponse.class);
        assertThat(response.getStatusCode().value(), is(200));
        PriceResponse priceResponse = response.getBody();
        assertThat(priceResponse, notNullValue());
        assertThat(priceResponse.priceId(), is(1L));
        assertThat(priceResponse.productId(), is(35455L));
        assertThat(priceResponse.brandId(), is(1L));
        assertThat(priceResponse.startDate(), is(LocalDateTime.parse("2020-06-14T00:00:00")));
        assertThat(priceResponse.endDate(), is(LocalDateTime.parse("2020-12-31T23:59:59")));
        assertThat(priceResponse.price(), is(35.5));
        assertThat(priceResponse.currency(), is("EUR"));
    }

    @Test
    void testFindPriceDay15At10Hours() {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-15T10:00:00");
        PriceSearch priceSearch = new PriceSearch(applicationDate, PRODUCT_ID, BRAND_ID);
        ResponseEntity<PriceResponse> response = restTemplate.postForEntity(getSearchPriceUrl(),
                priceSearch,
                PriceResponse.class);
        assertThat(response.getStatusCode().value(), is(200));
        PriceResponse priceResponse = response.getBody();
        assertThat(priceResponse, notNullValue());
        assertThat(priceResponse.priceId(), is(3L));
        assertThat(priceResponse.productId(), is(35455L));
        assertThat(priceResponse.brandId(), is(1L));
        assertThat(priceResponse.startDate(), is(LocalDateTime.parse("2020-06-15T00:00:00")));
        assertThat(priceResponse.endDate(), is(LocalDateTime.parse("2020-06-15T11:00:00")));
        assertThat(priceResponse.price(), is(30.5));
        assertThat(priceResponse.currency(), is("EUR"));
    }

    @Test
    void testFindPriceDay16At21Hours() {
        LocalDateTime applicationDate = LocalDateTime.parse("2020-06-16T21:00:00");
        PriceSearch priceSearch = new PriceSearch(applicationDate, PRODUCT_ID, BRAND_ID);
        ResponseEntity<PriceResponse> response = restTemplate.postForEntity(getSearchPriceUrl(),
                priceSearch,
                PriceResponse.class);
        assertThat(response.getStatusCode().value(), is(200));
        PriceResponse priceResponse = response.getBody();
        assertThat(priceResponse, notNullValue());
        assertThat(priceResponse.priceId(), is(4L));
        assertThat(priceResponse.productId(), is(35455L));
        assertThat(priceResponse.brandId(), is(1L));
        assertThat(priceResponse.startDate(), is(LocalDateTime.parse("2020-06-15T16:00:00")));
        assertThat(priceResponse.endDate(), is(LocalDateTime.parse("2020-12-31T23:59:59")));
        assertThat(priceResponse.price(), is(38.95));
        assertThat(priceResponse.currency(), is("EUR"));
    }

}