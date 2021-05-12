package com.example.distributedquartzdemo.repositories;

import com.example.distributedquartzdemo.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findAllByIsbnContaining(String isbn);
}
