package com.mracus.bookapp.dao;

import com.mracus.bookapp.models.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        String query = """
                select name, year_born
                from person;""";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        String query = """
                select name, year_born
                from person
                where person_id = ?;""";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Person.class), id).stream().findAny().orElse(null);
    }

    public void update(int id, Person person) {
        String query = """
                update person
                set name = ?, year_born = ?
                where person_id = ?;""";
        jdbcTemplate.update(query, person.getName(), person.getYearBorn(), id);
    }

    public void delete(int id) {
        String query = """
                delete from person
                where person_id = ?;""";
        jdbcTemplate.update(query, id);
    }

    public void save(Person person) {
        String query = """
                insert into person(name, year_born) 
                values (?, ?);""";
        jdbcTemplate.update(query, person.getName(), person.getYearBorn());
    }

}
