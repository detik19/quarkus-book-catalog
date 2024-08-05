package com.subrutin.lingkar.catalog.repository;

import java.util.List;
import java.util.Optional;

import com.subrutin.lingkar.catalog.domain.Publisher;
import com.subrutin.lingkar.catalog.dto.PublisherListDTO;
import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

public interface PublisherRepository {

    public List<Publisher> findAllPublisher();

    public Optional<Publisher> findPublisherById(Long id);

    public void createPublisher(Publisher publisher);

    public ResultPageResponseDTO<Publisher> findPublisherList(String publisherName, Sort sort, Page page);

}
