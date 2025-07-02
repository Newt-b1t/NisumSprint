package com.nisum.BookStore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void createBook_valid() throws Exception {
        String bookJson = "{\"title\":\"Test Book\",\"author\":\"Author\",\"price\":10.0}";
        mockMvc.perform(post(URI.create("/api/books"))
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(bookJson))
                .andExpect(status().isCreated());
    }
}

