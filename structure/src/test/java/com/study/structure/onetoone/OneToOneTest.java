package com.study.structure.onetoone;

import javax.persistence.EntityManager;

import com.study.structure.config.JpaConfig;
import com.study.structure.domain.onetoone.Car;
import com.study.structure.domain.onetoone.MainEngine;
import com.study.structure.domain.onetoone.reposiotry.CarReposiotry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(JpaConfig.class)
public class OneToOneTest {
    
    @Autowired EntityManager em;
    @Autowired CarReposiotry carReposiotry;

    @DisplayName("@OneToOne 에서 @MapsId로 컬럼 갯수 하나 줄이기!")
    @Test
    void test(){
        //fk constraint 없음 
        Car car = new Car();
        MainEngine mainEngine = new MainEngine();
        car.setMainEngine(mainEngine);
        mainEngine.setCar(car);
        mainEngine.setEngineInfo("BMW 2022신형엔진");

        carReposiotry.save(car);

        em.flush(); em.clear();

        carReposiotry.findAll().forEach(System.out::println);
        

    }
}
