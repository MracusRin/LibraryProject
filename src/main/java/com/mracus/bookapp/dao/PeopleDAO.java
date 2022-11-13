//package com.mracus.bookapp.dao;
//
//import com.mracus.bookapp.models.Book;
//import com.mracus.bookapp.models.Person;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class PeopleDAO {
//    private final JdbcTemplate jdbcTemplate;
//
//    public PeopleDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Person> index() {
//        String query = """
//                select person_id, full_name, year_of_birth
//                from person;""";
//        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Person.class));
//    }
//
//    public Person show(int id) {
//        String query = """
//                select person_id, full_name, year_of_birth
//                from person
//                where person_id = ?;""";
//        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Person.class), id)
//                .stream().findAny().orElse(null);
//    }
//
//    public void update(int id, Person person) {
//        String query = """
//                update person
//                set full_name = ?, year_of_birth = ?
//                where person_id = ?;""";
//        jdbcTemplate.update(query, person.getFullName(), person.getYearOfBirth(), id);
//    }
//
//    public void delete(int id) {
//        String query = """
//                delete from person
//                where person_id = ?;""";
//        jdbcTemplate.update(query, id);
//    }
//
//    public void save(Person person) {
//        String query = """
//                insert into person(full_name, year_of_birth)
//                values (?, ?);""";
//        jdbcTemplate.update(query, person.getFullName(), person.getYearOfBirth());
//    }
//
//
//    public Optional<Person> getPersonByFullName(String name) {
//    // для валидации уникальных имен
//        String query = """
//                select person_id, full_name, year_of_birth
//                from person
//                where full_name = ?;""";
//        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Person.class), name).stream().findAny();
//    }
//
//    public List<Book> getBookByPersonId(int personId) {
//        String query = """
//                select title, author, year
//                from book
//                where person_id = ?;""";
//        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Book.class), personId);
//    }
//
//}
