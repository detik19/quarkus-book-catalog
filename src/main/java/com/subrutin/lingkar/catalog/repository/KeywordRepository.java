package com.subrutin.lingkar.catalog.repository;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.subrutin.lingkar.catalog.domain.Keyword;

public interface KeywordRepository extends JpaRepository<Keyword, String> {

    Page<Keyword> findAllByCodeLikeIgnoreCase(String code, Pageable pageable);

    Set<Keyword> findAllByCodeIn(Set<String> names);
}
