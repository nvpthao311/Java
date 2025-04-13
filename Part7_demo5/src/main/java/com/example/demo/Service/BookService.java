package com.example.demo.Service;

import com.example.demo.DTO.BookDTO;

import java.util.List;

public interface BookService {
    BookDTO createBook(BookDTO bookDTO);
    BookDTO findById(Long id);
    List<BookDTO> findAll();
    BookDTO updateBook(Long id, BookDTO bookDTO);
    void deleteBook(Long id);
}
