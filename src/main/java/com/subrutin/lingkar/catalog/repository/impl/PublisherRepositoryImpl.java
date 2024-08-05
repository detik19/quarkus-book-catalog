package com.subrutin.lingkar.catalog.repository.impl;

import java.util.List;
import java.util.Optional;

import com.subrutin.lingkar.catalog.domain.Publisher;
import com.subrutin.lingkar.catalog.dto.ResultPageResponseDTO;
import com.subrutin.lingkar.catalog.repository.PublisherRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PublisherRepositoryImpl implements  PublisherRepository, PanacheRepositoryBase<Publisher,Long>{

    @Override
    public List<Publisher> findAllPublisher() {
        return this.findAll().list();
    }

    @Override
    public void createPublisher(Publisher publisher) {
       this.persist(publisher);
    }

    @Override
    public Optional<Publisher> findPublisherById(Long id) {
       return this.findByIdOptional(id);
        
    }

    @Override
    public ResultPageResponseDTO<Publisher> findPublisherList(String publisherName, Sort sort, Page page) {
        PanacheQuery<Publisher> publisherQuery = this.find("WHERE name LIKE ?1", sort, publisherName);
        ResultPageResponseDTO<Publisher> result = new ResultPageResponseDTO<>();
        List<Publisher> publishers = publisherQuery.page(page).list();
        result.setElements(publisherQuery.count());
        result.setPages(publisherQuery.pageCount());
        result.setResult(publishers);
        return result;
    }


}
