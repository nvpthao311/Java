package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private Long id;

    @NotBlank( message = "Tên không được để trống")
    private String titel;

    private String author;

}
