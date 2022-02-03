package com.study.structure.domain.composite.repository;

import com.study.structure.domain.composite.cBook2;
import com.study.structure.domain.composite.cBook.cBookPk;

import org.springframework.data.jpa.repository.JpaRepository;

public interface cBook2Repository extends JpaRepository<cBook2, cBookPk> {
    
}
