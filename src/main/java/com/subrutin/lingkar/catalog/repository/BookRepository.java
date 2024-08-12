package com.subrutin.lingkar.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subrutin.lingkar.catalog.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
