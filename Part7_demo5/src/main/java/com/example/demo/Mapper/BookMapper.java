package com.example.demo.Mapper;

import com.example.demo.DTO.BookDTO;
import com.example.demo.Model.Book;

public class BookMapper {

    public static BookDTO toDTO(Book book){
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitel(book.getTitle());
        dto.setAuthor(book.getTitle());

        return  dto;
    }

    public static  Book toEntity (BookDTO dto){
        return new Book(dto.getId(), dto.getTitel(), dto.getAuthor());
    }
}
