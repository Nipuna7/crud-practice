package com.example.crudapplication.service;

import com.example.crudapplication.model.BookModel;
import com.example.crudapplication.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // Add a new book
    public BookModel createBook(BookModel book) {
        return bookRepository.save(book);
    }

    // Get all books
    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get a book by ID
    public Optional<BookModel> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Update an existing book
    public BookModel updateBook(Long id, BookModel bookDetails) {
        BookModel book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());

        return bookRepository.save(book);
    }

    // Delete a book by ID
    public void deleteBook(Long id) {
        BookModel book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        bookRepository.delete(book);
    }
}
