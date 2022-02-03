package com.study.structure.domain.composite.repository;

import java.util.List;

import com.study.structure.domain.composite.cBook;

import org.springframework.data.jpa.repository.JpaRepository;

public interface cBookRepository extends JpaRepository<cBook,Long>{
    List<cBook> findByAuthor(String author);
    List<cBook> findByAuthorAndName(String author, String name);
    List<cBook> findByDetail(String detail);
    List<cBook> findByIdx(Integer Idx);
}
