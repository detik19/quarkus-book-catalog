package com.subrutin.lingkar.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subrutin.lingkar.catalog.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{


}