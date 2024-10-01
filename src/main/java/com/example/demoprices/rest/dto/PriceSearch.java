package com.example.demoprices.rest.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PriceSearch(@NotNull LocalDateTime applicationDate,
                          @NotNull Long productId,
                          @NotNull Long brandId){
}
