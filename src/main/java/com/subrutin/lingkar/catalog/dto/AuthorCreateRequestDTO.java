package com.subrutin.lingkar.catalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotBlank;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record AuthorCreateRequestDTO(
    @NotBlank
    String name,
    String birthPlace, 
    Long birthDate,
    String description
    ) {

}
