package com.subrutin.lingkar.catalog.domain;

import java.util.List;

import com.subrutin.lingkar.catalog.domain.enums.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "book_type", nullable = false)
    private Type bookType;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(name = "book_author", joinColumns = {
            @JoinColumn(name = "book_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "author_id", referencedColumnName = "id")
    })
    private List<Author> authors;


    @ManyToMany
    @JoinTable(name = "book_category", joinColumns = {
            @JoinColumn(name = "book_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "category_code", referencedColumnName = "code")
    })
    private List<Category> categories;

    @ManyToMany
    @JoinTable(name = "book_keyword", joinColumns = {
            @JoinColumn(name = "book_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "keyword_code", referencedColumnName = "code")
    })
    private List<Keyword> keywords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getBookType() {
        return bookType;
    }

    public void setBookType(Type bookType) {
        this.bookType = bookType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }


    

}
