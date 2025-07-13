package com.example.Library.repository;

import com.example.Library.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryH2Test {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void saveAndFindByTitle() {
        Book book = new Book();
        book.setTitle("Container Testing");
        bookRepository.save(book);

        List<Book> found = bookRepository.findByTitleContainingIgnoreCase("container");
        assertFalse(found.isEmpty());
        assertEquals("Container Testing", found.get(0).getTitle());
    }
}
