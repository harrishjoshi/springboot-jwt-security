package com.harxsh.jwt.security.book;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    List<BookResponse> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    BookResponse addBook(@Valid @RequestBody BookRequest bookRequest) {
        return bookService.addBook(bookRequest);
    }

    @GetMapping("{id}")
    BookResponse getBook(@PathVariable Integer id) {
        return bookService.getBook(id);
    }

    @PutMapping("{id}")
    BookResponse updateBook(@PathVariable Integer id, @Valid @RequestBody BookRequest bookRequest) {
        return bookService.updateBook(id, bookRequest);
    }

    @DeleteMapping("{id}")
    void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }
}
