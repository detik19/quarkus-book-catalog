package com.subrutin.lingkar.catalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subrutin.lingkar.catalog.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {

    List<Category> findByNameLikeIgnoreCase(String name);
}
