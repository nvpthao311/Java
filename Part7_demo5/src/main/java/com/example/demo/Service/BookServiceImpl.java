package com.example.demo.Service;


import com.example.demo.DTO.BookDTO;
import com.example.demo.Mapper.BookMapper;
import com.example.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.Mapper.BookMapper.*;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;


    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        return toDTO(bookRepository.save(toEntity(bookDTO)));
    }

    @Override
    public BookDTO findById(Long id) {
        BookDTO bookDTO = toDTO(bookRepository.findById(id).orElse(null));
        return bookDTO;
    }

    @Override
    public List<BookDTO> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        return null;
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
