package com.mracus.bookapp.repositories;

import com.mracus.bookapp.models.Book;
import com.mracus.bookapp.models.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findAll(Pageable pageable);

    List<Book> findAllByPerson(Person person);

}
