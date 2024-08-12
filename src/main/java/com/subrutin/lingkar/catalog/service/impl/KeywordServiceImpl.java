package com.subrutin.lingkar.catalog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.subrutin.lingkar.catalog.domain.Keyword;
import com.subrutin.lingkar.catalog.dto.KeywordListResponseDTO;
import com.subrutin.lingkar.catalog.dto.KeywordRequestDTO;
import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;
import com.subrutin.lingkar.catalog.repository.KeywordRepository;
import com.subrutin.lingkar.catalog.service.KeywordService;
import com.subrutin.lingkar.catalog.util.PaginationUtil;

import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KeywordServiceImpl implements KeywordService {

    private final KeywordRepository keywordRepository;

    public KeywordServiceImpl(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    @Override
    public void createKeywords(KeywordRequestDTO dto) {
        Keyword keyword = new Keyword();
        keyword.setCode(dto.code());
        keyword.setName(dto.name());
        keyword.setDescription(dto.description());
        keywordRepository.save(keyword);

    }

    @Override
    public ResultPageResponseDTO<KeywordListResponseDTO> findKeywordsList(Integer pages, Integer limit, String sortBy,
            String direction, String code) {
        code = StringUtil.isNullOrEmpty(code) ? "%" : code + "%";
        Sort sort = Sort.by(new Sort.Order(PaginationUtil.getSortBy(direction), sortBy));
        Pageable pageable = PageRequest.of(pages, limit, sort);
        Page<Keyword> pageResult = keywordRepository.findAllByCodeLikeIgnoreCase(code.toUpperCase(), pageable);
        List<KeywordListResponseDTO> dtos = pageResult.stream().map((k) -> {
            return new KeywordListResponseDTO(k.getCode(), k.getName());
        }).collect(Collectors.toList());

        return PaginationUtil.createResultPageDTO(dtos, pageResult.getTotalElements(), pages);
    }

    @Override
    public void deleteKeyword(String code) {

        keywordRepository.deleteById(code);
    }

}
