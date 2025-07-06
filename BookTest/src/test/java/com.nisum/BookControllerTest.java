package com.nisum;
import com.nisum.controller.BookController;
import com.nisum.exception.BookNotFoundException;
import com.nisum.model.Book;
import com.nisum.service.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = BookController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    @DisplayName("Should return 200 and book JSON for valid ID")
    void getBook_validId_returnsBook() throws Exception {
        Book book = new Book(1L, "Spring in Action");
        given(bookService.getBook(1L)).willReturn(book);

        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/books/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Spring in Action"))
                .andDo(document("get-book-success"));
    }

    @Test
    @DisplayName("Should return 404 and problem details for missing ID")
    void getBook_missingId_returns404() throws Exception {
        given(bookService.getBook(99L)).willThrow(new BookNotFoundException(99L));

        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/books/{id}", 99L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.title").value("Book Not Found"))
                .andExpect(jsonPath("$.detail").value("Book not found: 99"))
                .andDo(document("get-book-notfound"));
    }
}
