package com.subrutin.lingkar.catalog.repository.impl;

import java.util.List;

import com.subrutin.lingkar.catalog.domain.Book;
import com.subrutin.lingkar.catalog.dto.BookQueryDTO;
import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;
import com.subrutin.lingkar.catalog.repository.BookPanacheRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookRepositoryImpl implements BookPanacheRepository, PanacheRepositoryBase<Book, Long> {

    @Override
    public List<BookQueryDTO> findBookList() {
        PanacheQuery<BookQueryDTO> query = this
                .find("select b.id, b.title, b.description, b.publisher.name from Book b").project(BookQueryDTO.class);
        return query.list();
    }

    @Override
    public ResultPageResponseDTO<BookQueryDTO> findBookList(Sort sort, Page page, String bookTitle) {

        PanacheQuery<BookQueryDTO> query = this.find("SELECT b.id, b.title, b.description, b.publisher.name FROM Book b"
                + " WHERE b.title like ?1", sort, bookTitle)
                .project(BookQueryDTO.class);
        List<BookQueryDTO> queryList = query.page(page).list();
        ResultPageResponseDTO<BookQueryDTO> result = new ResultPageResponseDTO<>();
        result.setResult(queryList);
        result.setElements(query.count());
        result.setPages(query.pageCount());
        return result;
    }

}
