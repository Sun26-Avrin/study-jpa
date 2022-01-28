package com.study.structure.domain.onetoone.reposiotry;

import com.study.structure.domain.onetoone.Car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarReposiotry extends JpaRepository<Car,Long> {
    
}
