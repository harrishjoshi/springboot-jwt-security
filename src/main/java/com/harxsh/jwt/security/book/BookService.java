package com.harxsh.jwt.security.book;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponse> getBooks() {
        return bookRepository.findAllBy();
    }

    public BookResponse addBook(BookRequest bookRequest) {
        var book = new Book();
        book.setTitle(bookRequest.title());
        book.setDescription(bookRequest.description());
        bookRepository.save(book);

        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                book.getCreateDate(),
                null,
                book.getCreatedBy(),
                null
        );
    }

    public BookResponse getBook(Integer id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id: " + id + " not found."));

        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                book.getCreateDate(),
                book.getLastModified(),
                book.getCreatedBy(),
                book.getLastModifiedBy()
        );
    }

    public BookResponse updateBook(Integer id, BookRequest bookRequest) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id: " + id + " not found."));

        book.setTitle(bookRequest.title());
        book.setDescription(bookRequest.description());
        bookRepository.save(book);

        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                book.getCreateDate(),
                book.getLastModified(),
                book.getCreatedBy(),
                book.getLastModifiedBy()
        );
    }

    public void deleteBook(Integer id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id: " + id + " not found."));

        book.setDeleted(true);
        bookRepository.save(book);
    }
}
