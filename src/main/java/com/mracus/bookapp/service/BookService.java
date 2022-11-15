package com.mracus.bookapp.service;

import com.mracus.bookapp.models.Book;
import com.mracus.bookapp.models.Person;
import com.mracus.bookapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(int page, int bookPerPage, boolean sort) {
        if (sort) {
            return bookRepository.findAll(PageRequest.of(page, bookPerPage, Sort.by("year"))).getContent();
        } else {
            return bookRepository.findAll(PageRequest.of(page, bookPerPage)).getContent();
        }
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    public List<Book> findAllByTitleStartsWithIgnoreCase(String title) {
        if (title != null) {
            return bookRepository.findAllByTitleContainingIgnoreCase(title);
        } else {
            return null;
        }
    }

    @Transactional
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void update(Book updatedBook, int id) {
        updatedBook.setBookId(id);
        bookRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public void setPerson(int bookId, Person person) {
        Optional<Book> book = bookRepository.findById(bookId);
        book.orElseThrow().setPerson(person);
    }

    @Transactional
    public void leavePerson(int bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        book.orElseThrow().setPerson(null);
    }

    public Person getPersonByBookId(int id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow().getPerson();
    }

    public List<Book> findBookByPersonId(Person person) {
        return bookRepository.findAllByPerson(person);
    }
}
