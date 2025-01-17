package com.subrutin.lingkar.catalog.dto;

import java.util.Set;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.subrutin.lingkar.catalog.domain.enums.Type;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record BookCreateRequestDTO(String title,
    String description,
    Type bookType,
    Long publisherId,
    Set<Long> authorIds,
    Set<String> categoryCodes,
    Set<String> keywordCodes) {

}
