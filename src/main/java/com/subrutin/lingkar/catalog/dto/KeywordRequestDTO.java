package com.subrutin.lingkar.catalog.dto;

import jakarta.validation.constraints.NotBlank;

public record KeywordRequestDTO(
    @NotBlank String code, 
    @NotBlank String name, 
    String description
) {

}
