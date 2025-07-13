package com.example.Library.service;


import com.example.Library.dto.BookDTO;
import com.example.Library.model.Book;
import com.example.Library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class BookServiceSpringBootTest {

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    void getBookById_ValidId_ReturnsBookDTO() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Spring in Action");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        BookDTO dto = bookService.getBookById(1L);
        assertEquals("Spring in Action", dto.getTitle());
    }
}
