package com.subrutin.lingkar.catalog.service;

import java.util.List;

import com.subrutin.lingkar.catalog.dto.CategoryRequestDTO;
import com.subrutin.lingkar.catalog.dto.CategoryResponseDTO;

public interface CategoryService {

    public void createAndUpdateCategory(CategoryRequestDTO dto);

    public void deleteCategory(String code);

    public List<CategoryResponseDTO>  findAllCategory(String name);
}
