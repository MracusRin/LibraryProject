package com.mracus.bookapp.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int bookId;
    private Integer personId;

    @NotEmpty(message = "Book name cannot be empty")
    @Size(min = 2, max = 100, message = "Name should by between 2 and 100 characters")
    private String name;

    @NotEmpty(message = "Author cannot be empty")
    @Size(min = 2, max = 100, message = "Author should by between 2 and 100 characters")
    private String author;

    @Min(value = 0, message = "Year should greater then 0")
    private int year;

    public Book(int bookId, Integer personId, String name, String author, int year) {
        this.bookId = bookId;
        this.personId = personId;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isFree() {
        return personId == null;
    }
}
