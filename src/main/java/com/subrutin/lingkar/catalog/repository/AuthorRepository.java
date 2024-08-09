package com.subrutin.lingkar.catalog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.subrutin.lingkar.catalog.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

    Page<Author> findByNameLikeIgnoreCase(String name, Pageable pageable);


}
