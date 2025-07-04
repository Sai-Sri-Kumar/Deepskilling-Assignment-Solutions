package org.example.service;

import org.example.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter method used by Spring for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookName) {
        bookRepository.saveBook(bookName);
    }
}
