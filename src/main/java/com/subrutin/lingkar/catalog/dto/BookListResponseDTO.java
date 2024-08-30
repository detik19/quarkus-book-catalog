package com.subrutin.lingkar.catalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record BookListResponseDTO(
    Long id,
    String title,
    String description,
    String publisherName
    ) {

}
