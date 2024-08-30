package com.subrutin.lingkar.catalog.repository;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.subrutin.lingkar.catalog.domain.Author;

import jakarta.transaction.Transactional;

@Transactional
public interface AuthorRepository extends JpaRepository<Author, Long>{

    Page<Author> findByNameLikeIgnoreCase(String name, Pageable pageable);

    Set<Author> findAllByIdIn(Set<Long> ids);


}
