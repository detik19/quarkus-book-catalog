package com.subrutin.lingkar.catalog.web;

import java.net.URI;
import java.util.List;

import org.jboss.resteasy.reactive.RestResponse;

import com.subrutin.lingkar.catalog.dto.BookCreateRequestDTO;
import com.subrutin.lingkar.catalog.dto.BookListResponseDTO;
import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;
import com.subrutin.lingkar.catalog.service.BookService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/v1/books")
public class BookResource {

    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @RolesAllowed("ADMIN")
    @POST
    public RestResponse<Void> createBook(BookCreateRequestDTO dto) {
        bookService.createBook(dto);
        return RestResponse.created(URI.create("/v1/book"));
    }

    @GET
    public RestResponse<ResultPageResponseDTO<BookListResponseDTO>> findBook(
            @DefaultValue("0") @QueryParam("pages") Integer pages,
            @DefaultValue("10") @QueryParam("limit") Integer limit,
            @DefaultValue("id") @QueryParam("sortBy") String sortBy,
            @DefaultValue("asc") @QueryParam("direction") String direction,
            @QueryParam("bookTitle") String bookTitle) {
        return RestResponse.ok(bookService.findBookList(pages, limit, sortBy, direction, bookTitle));
    }
}
