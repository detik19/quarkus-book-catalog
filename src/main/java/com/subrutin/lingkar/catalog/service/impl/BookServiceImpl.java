package com.subrutin.lingkar.catalog.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;

import com.subrutin.lingkar.catalog.domain.Author;
import com.subrutin.lingkar.catalog.domain.Book;
import com.subrutin.lingkar.catalog.domain.Category;
import com.subrutin.lingkar.catalog.domain.Keyword;
import com.subrutin.lingkar.catalog.domain.Publisher;
import com.subrutin.lingkar.catalog.dto.BookCreateRequestDTO;
import com.subrutin.lingkar.catalog.dto.BookListResponseDTO;
import com.subrutin.lingkar.catalog.dto.BookQueryDTO;
import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;
import com.subrutin.lingkar.catalog.repository.BookPanacheRepository;
import com.subrutin.lingkar.catalog.repository.BookRepository;
import com.subrutin.lingkar.catalog.service.AuthorService;
import com.subrutin.lingkar.catalog.service.BookService;
import com.subrutin.lingkar.catalog.service.CategoryService;
import com.subrutin.lingkar.catalog.service.KeywordService;
import com.subrutin.lingkar.catalog.service.PublisherService;
import com.subrutin.lingkar.catalog.util.PaginationUtil;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.quarkus.panache.common.Sort.Direction;
import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BookServiceImpl implements BookService {

    private final AuthorService authorService;

    private final KeywordService keywordService;

    private final CategoryService categoryService;

    private final PublisherService publisherService;

    private final BookPanacheRepository bookPanacheRepository;

    private final BookRepository bookRepository;

    public BookServiceImpl(AuthorService authorService, KeywordService keywordService,
            CategoryService categoryService, PublisherService publisherService,
            BookPanacheRepository bookPanacheRepository, BookRepository bookRepository) {
        this.authorService = authorService;
        this.keywordService = keywordService;
        this.categoryService = categoryService;
        this.publisherService = publisherService;
        this.bookPanacheRepository = bookPanacheRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    @Override
    public void createBook(BookCreateRequestDTO dto) {
        Set<Author> authors = authorService.findAllAuthor(dto.authorIds());
        Set<Keyword> keywords = keywordService.findAllKeywords(dto.keywordCodes());
        Set<Category> categories = categoryService.findAllCategory(dto.categoryCodes());
        Publisher publisher = publisherService.findPublisherById(dto.publisherId());

        Book book = new Book();
        book.setTitle(dto.title());
        book.setDescription(dto.description());
        book.setBookType(dto.bookType());
        book.setPublisher(publisher);
        book.setAuthors(authors);
        book.setKeywords(keywords);
        book.setCategories(categories);
        bookRepository.save(book);

    }

    @Override
    public List<BookListResponseDTO> findBookList() {

        List<BookQueryDTO> result = bookPanacheRepository.findBookList();
        return result.stream().map(b -> {
            return new BookListResponseDTO(b.id(), b.title(), b.description(), b.publisherName());
        }).collect(Collectors.toList());

    }

    @Override
    public ResultPageResponseDTO<BookListResponseDTO> findBookList(Integer pages, Integer limit, String sortBy,
            String direction, String bookTitle) {
        bookTitle = StringUtil.isNullOrEmpty(bookTitle) ? "%" : bookTitle + "%";
        Sort sort = Sort.by(sortBy, PaginationUtil.getDirection(direction));
        Page page = Page.of(pages, limit);
        ResultPageResponseDTO<BookQueryDTO> bookList = bookPanacheRepository.findBookList(sort, page, bookTitle);
        List<BookListResponseDTO> dtos = bookList.getResult().stream().map(b -> {
            return new BookListResponseDTO(b.id(), b.title(), b.description(), b.publisherName());
        }).collect(Collectors.toList());
        return PaginationUtil.createResultPageDTO(dtos, bookList.getElements(), bookList.getPages());

    }

}
