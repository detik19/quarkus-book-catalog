package com.subrutin.lingkar.catalog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.subrutin.lingkar.catalog.domain.Category;
import com.subrutin.lingkar.catalog.dto.CategoryRequestDTO;
import com.subrutin.lingkar.catalog.dto.CategoryResponseDTO;
import com.subrutin.lingkar.catalog.repository.CategoryRepository;
import com.subrutin.lingkar.catalog.service.CategoryService;

import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createAndUpdateCategory(CategoryRequestDTO dto) {

        Category category;

        if (categoryRepository.existsById(dto.code())) {
            category = categoryRepository.findById(dto.code()).get();

        } else {
            category = new Category();
            category.setCode(dto.code());

        }
        category.setName(dto.name());
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(String code) {
        categoryRepository.deleteById(code);
    }

    @Override
    public List<CategoryResponseDTO> findAllCategory(String name) {
        name = StringUtil.isNullOrEmpty(name) ? "%" : name+"%";
        List<Category> categories = categoryRepository.findByNameLikeIgnoreCase(name.toUpperCase()); //jadi capslock
        return categories.stream().map((c) -> {
            CategoryResponseDTO dto = new CategoryResponseDTO(c.getCode(), c.getName());
            return dto;
        }).collect(Collectors.toList());
    }

}
