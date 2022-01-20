package com.jpa.basic.test.inheritance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface subRepo extends JpaRepository<Sub,Long> {
    
}
