package com.subrutin.lingkar.catalog.domain;

import java.util.Set;

import com.subrutin.lingkar.catalog.domain.enums.Type;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.ManyToOne;
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

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;

    @ManyToOne
    @JoinColumn(name = "edition_of")
    private Book editionOf;


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "book_category", joinColumns = {
            @JoinColumn(name = "book_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "category_code", referencedColumnName = "code")
    })
    private Set<Category> categories;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "book_keyword", joinColumns = {
            @JoinColumn(name = "book_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "keyword_code", referencedColumnName = "code")
    })
    private Set<Keyword> keywords;

    public void addKeyword(Keyword keyword) {
        this.keywords.add(keyword);
        keyword.getBooks().add(this);
    }

    public void removeKeyword(Keyword keyword) {
        this.keywords.remove(keyword);
        keyword.getBooks().remove(this);
    }

    public void addCategory(Category category) {
        this.categories.add(category);
        category.getBooks().add(this);
        
    }

    public void removeCategory(Category category){
        this.categories.remove(category);
        category.getBooks().remove(this);
    }

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

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }

    public Book getEditionOf() {
        return editionOf;
    }

    public void setEditionOf(Book editionOf) {
        this.editionOf = editionOf;
    }


    

}
