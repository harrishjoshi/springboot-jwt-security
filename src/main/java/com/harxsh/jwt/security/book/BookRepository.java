package com.harxsh.jwt.security.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("""
            SELECT new com.harxsh.jwt.security.book.BookResponse(b.id, b.title, b.description, b.createDate, b.lastModified, b.createdBy, b.lastModifiedBy)
            FROM Book b WHERE b.isDeleted = false""")
    List<BookResponse> findAllBy();
}
