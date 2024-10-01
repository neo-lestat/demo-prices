package com.example.demoprices.rest.mapper;

import com.example.demoprices.model.Price;
import com.example.demoprices.rest.dto.PriceResponse;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {

    public PriceResponse map(Price price) {
        return new PriceResponse(
                price.getProduct().getId(),
                price.getBrand().getId(),
                price.getId(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPrice(),
                price.getCurrency()
        );
    }
}
