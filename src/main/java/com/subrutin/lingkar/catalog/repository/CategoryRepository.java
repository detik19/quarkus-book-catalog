package com.subrutin.lingkar.catalog.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subrutin.lingkar.catalog.domain.Category;

import jakarta.transaction.Transactional;

@Transactional
public interface CategoryRepository extends JpaRepository<Category, String> {

    List<Category> findByNameLikeIgnoreCase(String name);

    Set<Category> findAllByCodeIn(Set<String> codes);


}
