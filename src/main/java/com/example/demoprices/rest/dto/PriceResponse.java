package com.example.demoprices.rest.dto;

import java.time.LocalDateTime;

public record PriceResponse(Long productId,
                            Long brandId,
                            Long priceId,
                            LocalDateTime startDate,
                            LocalDateTime endDate,
                            Double price,
                            String currency){
}
