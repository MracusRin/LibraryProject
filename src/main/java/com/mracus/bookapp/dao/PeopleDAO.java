package com.mracus.bookapp.dao;

import com.mracus.bookapp.models.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PeopleDAO {
    private final JdbcTemplate jdbcTemplate;

    public PeopleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        String query = """
                select person_id, name, year_born
                from person;""";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        String query = """
                select person_id, name, year_born
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

    public Person showPerson(int id) {
        String query = """
                select p.name
                from book b
                join person p on p.person_id = b.person_id
                where book_id = ?;""";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Person.class), id).stream().findAny().orElse(null);
    }

}
