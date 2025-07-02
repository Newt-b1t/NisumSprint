package com.nisum.BookStore;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class BookDTO {
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Author is mandatory")
    private String author;

    @Positive(message = "Price must be positive")
    private double price;


}
