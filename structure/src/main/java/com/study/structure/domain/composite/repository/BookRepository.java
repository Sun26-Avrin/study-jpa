package com.study.structure.domain.composite.repository;

import java.util.List;

import com.study.structure.domain.composite.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long>{
    List<Book> findByAuthor(String author);
    List<Book> findByAuthorAndName(String author, String name);
    List<Book> findByDetail(String detail);
    List<Book> findByIdx(Integer Idx);
}
