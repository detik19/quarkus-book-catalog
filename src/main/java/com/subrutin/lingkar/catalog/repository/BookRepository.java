package com.subrutin.lingkar.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.subrutin.lingkar.catalog.domain.Book;
import jakarta.transaction.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {

    // @Query("SELECT new com.subrutin.lingkar.catalog.dto.BookQueryDTO(b.id, b.title, b.description, b.publisher.name)"
    //         +" FROM Book b")
    // public List<BookQueryDTO> findBookList();

}
