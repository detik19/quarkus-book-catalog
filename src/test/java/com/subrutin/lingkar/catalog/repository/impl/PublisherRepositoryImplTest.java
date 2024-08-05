package com.subrutin.lingkar.catalog.repository.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.subrutin.lingkar.catalog.domain.Publisher;
import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;
import com.subrutin.lingkar.catalog.repository.PublisherRepository;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
@TestTransaction
public class PublisherRepositoryImplTest {

    @Inject
    PublisherRepository publisherRepository;

    @Test
    void testFindAllPublisher() {
        List<Publisher> publisherList = publisherRepository.findAllPublisher();
        Assertions.assertEquals(2, publisherList.size());
    }

    @Test
    void testCreatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Manning Publications");
        publisher.setDescription("Manning Publications is an American independent publisher specializing in technical books, videos, and live projects aimed at software developers and professionals");
        publisherRepository.createPublisher(publisher);

        List<Publisher> publisherList = publisherRepository.findAllPublisher();
        Assertions.assertEquals(3, publisherList.size());

    }

    @ParameterizedTest
    @ValueSource(longs = {1,2})
    void testFindPublisherById(Long id) {
        Optional<Publisher> publisherOptional = publisherRepository.findPublisherById(id);
        assertEquals(true, publisherOptional.isPresent());
    }

    @Test
    void testFindPublisherList() {
        ResultPageResponseDTO<Publisher> publisherList = publisherRepository.findPublisherList("%", Sort.by("name"), Page.of(0, 10));
        assertEquals(2, publisherList.getResult().size());
    }   
}
