package com.subrutin.lingkar.catalog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.subrutin.lingkar.catalog.domain.Publisher;
import com.subrutin.lingkar.catalog.dto.PublisherCreateRequestDTO;
import com.subrutin.lingkar.catalog.dto.PublisherListDTO;
import com.subrutin.lingkar.catalog.dto.PublisherUpdateRequestDTO;
import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;
import com.subrutin.lingkar.catalog.exception.ResourceNotFoundException;
import com.subrutin.lingkar.catalog.repository.PublisherRepository;
import com.subrutin.lingkar.catalog.service.PublisherService;
import com.subrutin.lingkar.catalog.util.PaginationUtil;

import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public ResultPageResponseDTO<PublisherListDTO> findPublisherList(Integer pages, Integer limit, String sortBy,
            String direction, String publisherName) {

        publisherName = StringUtil.isNullOrEmpty(publisherName) ? "%" : publisherName + "%";
        Sort sort = Sort.by(new Sort.Order(PaginationUtil.getSortBy(direction), sortBy));
        Pageable pageable = PageRequest.of(pages, limit, sort);
        Page<Publisher> pageResult = publisherRepository.findByNameLikeIgnoreCase(publisherName, pageable);
        List<PublisherListDTO> dtos = pageResult.stream().map((p) -> {
            PublisherListDTO dto = new PublisherListDTO(p.getId(), p.getName(), p.getDescription());
            return dto;
        }).collect(Collectors.toList());
        return PaginationUtil.createResultPageDTO(dtos, pageResult.getTotalElements(), pageResult.getTotalPages());
    }

    @Override
    public void createPublisher(PublisherCreateRequestDTO dto) {
        Publisher publisher = new Publisher();
        publisher.setName(dto.name());
        publisher.setDescription(dto.description());

        publisherRepository.save(publisher);

    }

    @Override
    public void updatePublisher(Long id, PublisherUpdateRequestDTO dto) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("publisher.notfound"));
        publisher.setName(dto.name());
        publisher.setDescription(dto.description());

        publisherRepository.save(publisher);
    }

}
