package com.subrutin.lingkar.catalog.service.impl;

import com.subrutin.lingkar.catalog.dto.PublisherListDTO;
import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;
import com.subrutin.lingkar.catalog.repository.PublisherRepository;
import com.subrutin.lingkar.catalog.service.PublisherService;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PublisherServiceImpl implements PublisherService{

    private final PublisherRepository publisherRepository;


    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }


    @Override
    public ResultPageResponseDTO<PublisherListDTO> findPublisherList(Integer pages, Integer limit, String sortBy,
            String direction, String publisherName) {
        Page page = Page.of(pages,limit);
        Sort.by(sortBy, Sort.Direction.Ascending);
       return null;
    }

}
