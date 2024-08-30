package com.subrutin.lingkar.catalog.repository;

import java.util.List;

import com.subrutin.lingkar.catalog.dto.BookQueryDTO;
import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

public interface BookPanacheRepository {

    public List<BookQueryDTO> findBookList();

    public ResultPageResponseDTO<BookQueryDTO> findBookList(Sort sort, Page page, String bookTitle);

}
