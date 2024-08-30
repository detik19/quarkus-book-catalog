package com.subrutin.lingkar.catalog.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequestDTO(@NotBlank String code, String name) {

}
