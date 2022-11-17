package com.mracus.bookapp.repositories;

import com.mracus.bookapp.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByTitleContainingIgnoreCase(String title);
}
