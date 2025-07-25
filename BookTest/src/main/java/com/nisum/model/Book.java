package com.nisum.model;

public class Book {
    private Long id;
    private String title;

    // Constructors, getters, setters
    public Book() {}
    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
