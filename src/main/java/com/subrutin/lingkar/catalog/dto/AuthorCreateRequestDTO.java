package com.subrutin.lingkar.catalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record AuthorCreateRequestDTO(String name,
    String birthPlace, 
    Long birthDate,
    String description
    ) {

}
