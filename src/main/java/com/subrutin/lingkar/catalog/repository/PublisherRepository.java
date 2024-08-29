package com.subrutin.lingkar.catalog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.subrutin.lingkar.catalog.domain.Publisher;



public interface PublisherRepository extends JpaRepository<Publisher, Long>{

    public List<Publisher> findAll();

    public Optional<Publisher> findById(Long id);

    public Page<Publisher> findByNameLikeIgnoreCase(String publisherName, Pageable pageable);

    @Modifying
    @Query("UPDATE Publisher p SET p.deleted = true WHERE p.id = ?1")
    public void softDelete(Long id);

}
