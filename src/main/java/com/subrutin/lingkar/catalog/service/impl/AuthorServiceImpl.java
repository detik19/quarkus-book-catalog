package com.subrutin.lingkar.catalog.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.subrutin.lingkar.catalog.domain.Author;
import com.subrutin.lingkar.catalog.dto.AuthorCreateRequestDTO;
import com.subrutin.lingkar.catalog.dto.AuthorDetailResponseDTO;
import com.subrutin.lingkar.catalog.dto.AuthorListResponseDTO;
import com.subrutin.lingkar.catalog.dto.AuthorUpdateRequestDTO;
import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;
import com.subrutin.lingkar.catalog.exception.ResourceNotFoundException;
import com.subrutin.lingkar.catalog.repository.AuthorRepository;
import com.subrutin.lingkar.catalog.service.AuthorService;
import com.subrutin.lingkar.catalog.util.PaginationUtil;

import io.netty.util.internal.StringUtil;
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

    @Override
    public void updateAuthor(Long id, AuthorUpdateRequestDTO dto) {
        Author author = authorRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("author.id not found"));
        author.setName(dto.name());
        author.setBirthPlace(dto.birthPlace());
        author.setBirthDate(LocalDate.ofEpochDay(dto.birthDate()));
        author.setDescription(dto.description());
        authorRepository.save(author);
    }

    @Override
    public AuthorDetailResponseDTO findAuthorDetail(Long id) {
        Author author = authorRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("author.id not found"));
        AuthorDetailResponseDTO dto = new AuthorDetailResponseDTO(author.getId(), 
            author.getName(), 
            author.getBirthPlace(), 
            author.getBirthDate().toEpochDay(), 
            author.getDescription());
        return dto;
    }

    @Override
    public ResultPageResponseDTO<AuthorListResponseDTO> findAuthorList(Integer pages, Integer limit, String direction,
            String sortBy, String name) {
        name = StringUtil.isNullOrEmpty(name)?"%" :name +"%";
        Sort sort = Sort.by(new Sort.Order(PaginationUtil.getSortBy(direction), sortBy));
        Pageable pageable = PageRequest.of(pages, limit, sort);
        Page<Author> pageResult = authorRepository.findByNameLikeIgnoreCase(name.toUpperCase(), pageable);
        List<AuthorListResponseDTO> dtos = pageResult.stream().map((a)->{
            AuthorListResponseDTO dto = new AuthorListResponseDTO(a.getId(), a.getName());
            return dto;
        }).collect(Collectors.toList());
        return PaginationUtil.createResultPageDTO(dtos, pageResult.getTotalElements(), pageResult.getTotalPages());
    }

    @Override
    public Set<Author> findAllAuthor(Set<Long> ids) {
        Set<Author> authors = authorRepository.findAllByIdIn(ids);
        if(authors.size()!=ids.size()){
            throw new ResourceNotFoundException("author.id not found");
        }
        return authors;
    }

}
