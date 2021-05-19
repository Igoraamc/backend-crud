package com.springboot.crud.controller;

import com.springboot.crud.model.Book;
import com.springboot.crud.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookRepository repository;

    BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    List<Book> all() {
        return repository.findAll();
    }

    @PostMapping("/books")
    Book newBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @GetMapping("/books/{id}")
    Book one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @PutMapping("/books/{id}")
    Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {
        return repository.findById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    book.setAuthor(newBook.getAuthor());
                    book.setResume(newBook.getResume());
                    book.setPublisher(newBook.getPublisher());
                    book.setLanguage(newBook.getLanguage());
                    book.setPrice(newBook.getPrice());
                    book.setReleaseDate(newBook.getReleaseDate());
                    return repository.save(book);
                }).orElseGet(() -> {
                    newBook.setId(id);
                    return repository.save(newBook);
                });
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
