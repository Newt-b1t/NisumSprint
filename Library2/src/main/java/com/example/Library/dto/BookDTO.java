package com.example.Library.dto;


import lombok.Data;

import java.time.LocalDate;
@Data
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private LocalDate publishedDate;
    private String isbn;
}

