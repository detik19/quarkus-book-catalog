package com.subrutin.lingkar.catalog.service.impl;

import java.time.LocalDate;

import com.subrutin.lingkar.catalog.domain.Author;
import com.subrutin.lingkar.catalog.dto.AuthorCreateRequestDTO;
import com.subrutin.lingkar.catalog.repository.AuthorRepository;
import com.subrutin.lingkar.catalog.service.AuthorService;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;


    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void createAuthor(AuthorCreateRequestDTO dto) {
        Author author = new Author();
        author.setName(dto.name());
        author.setBirthPlace(dto.birthPlace());
        author.setBirthDate(LocalDate.ofEpochDay(dto.birthDate()));
        author.setDescription(dto.description());

        authorRepository.save(author);

       
    }

}
