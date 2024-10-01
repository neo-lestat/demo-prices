package com.example.demoprices.rest.controller;

import com.example.demoprices.model.Price;
import com.example.demoprices.repository.PriceRepository;
import com.example.demoprices.rest.dto.PriceResponse;
import com.example.demoprices.rest.dto.PriceSearch;
import com.example.demoprices.rest.exception.PriceNotFoundException;
import com.example.demoprices.rest.mapper.PriceMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/prices")
public class PriceResource {


    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    @Autowired
    public PriceResource(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;
        this.priceMapper = priceMapper;
    }

    @PostMapping(value = "/search", produces = "application/json")
    public PriceResponse findPrice(@Valid @RequestBody PriceSearch priceSearch) {
        Optional<Price> priceOptional = priceRepository.findPrices(priceSearch.productId(),
                        priceSearch.brandId(), priceSearch.applicationDate());
        Price price = priceOptional.orElseThrow(()-> new PriceNotFoundException("Price not found with %s".formatted(priceSearch)));
        return priceMapper.map(price);
    }

}
