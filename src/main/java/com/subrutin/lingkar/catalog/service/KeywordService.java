package com.subrutin.lingkar.catalog.service;

import java.util.Set;

import com.subrutin.lingkar.catalog.domain.Keyword;
import com.subrutin.lingkar.catalog.dto.KeywordListResponseDTO;
import com.subrutin.lingkar.catalog.dto.KeywordRequestDTO;
import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;

public interface KeywordService {

    public void createKeywords(KeywordRequestDTO dto);

    public ResultPageResponseDTO<KeywordListResponseDTO> findKeywordsList(Integer pages, Integer limit, String sortBy,
            String direction, String code);

    public void deleteKeyword(String code);

    public Set<Keyword> findAllKeywords(Set<String> codes);

}
