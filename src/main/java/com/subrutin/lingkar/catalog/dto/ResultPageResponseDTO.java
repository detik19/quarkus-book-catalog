package com.subrutin.lingkar.catalog.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResultPageResponseDTO<T> implements Serializable {
    @JsonProperty
    private List<T> result;
    @JsonProperty
    private Integer pages;
    @JsonProperty
    private Long elements;

    public List<T> getResult() {
        return result;
    }
    public void setResult(List<T> result) {
        this.result = result;
    }
    public Integer getPages() {
        return pages;
    }
    public void setPages(Integer pages) {
        this.pages = pages;
    }
    public Long getElements() {
        return elements;
    }
    public void setElements(Long elements) {
        this.elements = elements;
    }

    
}
