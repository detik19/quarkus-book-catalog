package com.subrutin.lingkar.catalog.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record BookQueryDTO(
    Long id,
    String title,
    String description,
    String publisherName
) {

}
