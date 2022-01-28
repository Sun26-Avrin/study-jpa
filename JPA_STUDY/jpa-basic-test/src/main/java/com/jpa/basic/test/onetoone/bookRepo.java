package com.jpa.basic.test.onetoone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepo extends JpaRepository<bookmark,Long>{
    
}
