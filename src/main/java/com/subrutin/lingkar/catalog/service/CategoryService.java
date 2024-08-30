package com.subrutin.lingkar.catalog.service;

import java.util.List;
import java.util.Set;

import com.subrutin.lingkar.catalog.domain.Category;
import com.subrutin.lingkar.catalog.dto.CategoryRequestDTO;
import com.subrutin.lingkar.catalog.dto.CategoryResponseDTO;

public interface CategoryService {

    public void createAndUpdateCategory(CategoryRequestDTO dto);

    public void deleteCategory(String code);

    public List<CategoryResponseDTO>  findAllCategory(String name);

    public Set<Category> findAllCategory(Set<String> codes);
}
