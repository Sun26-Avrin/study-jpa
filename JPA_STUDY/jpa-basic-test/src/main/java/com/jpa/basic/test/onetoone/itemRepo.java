package com.jpa.basic.test.onetoone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface itemRepo extends JpaRepository<item,Long>{
    
}
