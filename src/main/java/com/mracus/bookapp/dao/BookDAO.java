//package com.mracus.bookapp.dao;
//
//import com.mracus.bookapp.models.Book;
//import com.mracus.bookapp.models.Person;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@Component
//public class BookDAO {
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public BookDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Book> index() {
//        String query = """
//                select book_id, person_id, title, author, year
//                from book;""";
//        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Book.class));
//    }
//
//    public Book show(int id) {
//        String query = """
//                select book_id, person_id, title, author, year
//                from book
//                where book_id = ?;""";
//        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Book.class), id).stream().findAny().orElse(null);
//    }
//
//    public void save(Book book) {
//        String query = """
//                insert into book(title, author, year)
//                values (?, ?, ?);""";
//        jdbcTemplate.update(query, book.getTitle(), book.getAuthor(), book.getYear());
//    }
//
//    public void update(int id, Book book) {
//        String query = """
//                update book
//                set title = ?, author = ?, year = ?
//                where book_id = ?;""";
//        jdbcTemplate.update(query, book.getTitle(), book.getAuthor(), book.getYear(), id);
//    }
//
//    public void delete(int id) {
//        String query = """
//                delete from book
//                where book_id = ?;""";
//        jdbcTemplate.update(query, id);
//    }
//
//    public Optional<Person> getBookOwner(int bookId) {
//        String query = """
//                select p.person_id, p.full_name, p.year_of_birth
//                from book b
//                join person p on p.person_id = b.person_id
//                where b.book_id = ?;""";
//        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Person.class), bookId).stream().findAny();
//    }
//
//    public void setPerson(Person person, int bookId) {
//        String query = """
//                update book
//                set person_id = ?
//                where book_id = ?;""";
//        jdbcTemplate.update(query, person.getPersonId(), bookId);
//    }
//
//    public void leavePerson(int bookId) {
//        String query = """
//                update book
//                set person_id = null
//                where book_id = ?;""";
//        jdbcTemplate.update(query, bookId);
//    }
//}
