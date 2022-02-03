package com.study.structure.domain.onetoone.reposiotry;

import java.util.List;

import com.study.structure.domain.onetoone.Car;
import com.study.structure.domain.onetoone.MainEngine;
import com.study.structure.domain.pocketmark.Dto.IdOnlyRes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarReposiotry extends JpaRepository<Car,Long> {
    // List<IdOnlyRes> findByMainEngine(MainEngine mainEngine);
}
