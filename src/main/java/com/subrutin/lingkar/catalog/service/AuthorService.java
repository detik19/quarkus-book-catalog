package com.subrutin.lingkar.catalog.service;

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




}
