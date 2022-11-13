package com.mracus.bookapp.service;

import com.mracus.bookapp.models.Book;
import com.mracus.bookapp.models.Person;
import com.mracus.bookapp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll(int page, int PersonPerPage, boolean sort) {
        if (sort) {
            return peopleRepository.findAll(PageRequest.of(page, PersonPerPage, Sort.by("fullName"))).getContent();
        } else {
            return peopleRepository.findAll(PageRequest.of(page, PersonPerPage)).getContent();
        }
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findById(int id) {
        Optional<Person> findPerson = peopleRepository.findById(id);
        return findPerson.orElse(null);
    }

    public Optional<Person> findByFullName(String name) {
        return peopleRepository.findByFullName(name);
    }

    @Transactional
    public void save(Person person) {
        peopleRepository.save(person);
    }

    @Transactional
    public void update(Person updatedPerson, int id) {
        updatedPerson.setPersonId(id);
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

    public List<Book> findBookByPersonId(int id) {
        Optional<Person> person = peopleRepository.findById(id);
        return person.orElseThrow().getBooks();
    }


}
