package com.subrutin.lingkar.catalog.dto;

import java.util.Set;

import com.subrutin.lingkar.catalog.domain.enums.Type;

public record BookCreateRequestDTO(String title,
    String description,
    Type bookType,
    Set<Long> authorIds,
    Set<Long> categoryIds,
    Set<Long> keywordIds) {

}
