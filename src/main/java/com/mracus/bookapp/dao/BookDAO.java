package com.mracus.bookapp.dao;

import com.mracus.bookapp.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        String query = """
                select book_id, person_id, name, author, year
                from book;""";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        String query = """
                select book_id, person_id, name, author, year
                from book
                where book_id = ?;""";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Book.class), id).stream().findAny().orElse(null);
    }

    public void save(Book book) {
        String query = """
                insert into book(person_id, name, author, year)
                values (1, ?, ?, ?);""";
        jdbcTemplate.update(query, book.getName(), book.getAuthor(), book.getYear());
    }
    public void update(int id, Book book) {
        String query = """
                update book
                set name = ?, author = ?, year = ?
                where book_id = ?;""";
        jdbcTemplate.update(query, book.getName(), book.getAuthor(), book.getYear(), id);

    }

    public void delete(int id) {
        String query = """
                delete from book
                where book_id = ?;""";
        jdbcTemplate.update(query, id);
    }

}
