package com.jpa.basic.test.inheritance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface superRepo extends JpaRepository<Super,Long> {
    Super findBySuperField(String superField);
    
}
