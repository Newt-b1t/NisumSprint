package org.example.controller;


import org.example.dao.BookDAO;
import org.example.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HelloController {
    private BookDAO bookDAO;
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    @RequestMapping("/hello")
    public ModelAndView sayHello() {
        String mss = "hello world";
        return new ModelAndView("hello","message", mss);
    }
    @RequestMapping("/books")
    public ModelAndView listBooks() {
        List<Book> books = bookDAO.getAllBooks();
        return new ModelAndView("listBooks", "books", books);
    }
}