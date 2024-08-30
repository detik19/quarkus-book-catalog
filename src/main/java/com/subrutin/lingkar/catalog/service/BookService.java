package com.subrutin.lingkar.catalog.service;

import java.util.List;

import com.subrutin.lingkar.catalog.dto.BookCreateRequestDTO;
import com.subrutin.lingkar.catalog.dto.BookListResponseDTO;
import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;

public interface BookService {

    public void createBook(BookCreateRequestDTO dto);

    public List<BookListResponseDTO> findBookList();
    public ResultPageResponseDTO<BookListResponseDTO> findBookList(Integer pages, Integer limit,
            String sortBy, String direction, String bookTitle);

}
