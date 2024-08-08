package com.subrutin.lingkar.catalog.service;

import com.subrutin.lingkar.catalog.dto.AuthorCreateRequestDTO;
import com.subrutin.lingkar.catalog.dto.AuthorDetailResponseDTO;
import com.subrutin.lingkar.catalog.dto.AuthorUpdateRequestDTO;

public interface AuthorService {

    public void createAuthor(AuthorCreateRequestDTO dto);

    public void updateAuthor(Long id, AuthorUpdateRequestDTO dto);

    public AuthorDetailResponseDTO findAuthorDetail(Long id);




}
