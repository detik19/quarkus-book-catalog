package com.subrutin.lingkar.catalog.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.subrutin.lingkar.catalog.domain.Publisher;
import com.subrutin.lingkar.catalog.util.PaginationUtil;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
@TestTransaction
public class PublisherRepositoryTest {

    @Inject
    private PublisherRepository publisherRepository;

    @Test
    void testFindByNameLikeIgnoreCase() {
        Sort sort = Sort.by(new Sort.Order(PaginationUtil.getSortBy("ASC"),"id"));
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<Publisher> publisherPage = publisherRepository.findByNameLikeIgnoreCase("%", pageable);
        assertEquals(2, publisherPage.getTotalElements());
    }
}
