package com.subrutin.lingkar.catalog.service;

import java.util.Set;

import com.subrutin.lingkar.catalog.domain.Author;
import com.subrutin.lingkar.catalog.dto.AuthorCreateRequestDTO;
import com.subrutin.lingkar.catalog.dto.AuthorDetailResponseDTO;
import com.subrutin.lingkar.catalog.dto.AuthorListResponseDTO;
import com.subrutin.lingkar.catalog.dto.AuthorUpdateRequestDTO;
import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;

public interface AuthorService {

    public void createAuthor(AuthorCreateRequestDTO dto);

    public void updateAuthor(Long id, AuthorUpdateRequestDTO dto);

    public AuthorDetailResponseDTO findAuthorDetail(Long id);

    public ResultPageResponseDTO<AuthorListResponseDTO> findAuthorList(
        Integer pages, Integer limit, String direction, String sortBy,
        String name
    );

    public Set<Author> findAllAuthor(Set<Long> ids);




}
