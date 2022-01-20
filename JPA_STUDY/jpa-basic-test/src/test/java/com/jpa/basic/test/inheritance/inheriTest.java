package com.jpa.basic.test.inheritance;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class inheriTest {
    @Autowired
    subRepo subRepo;
    @Autowired
    superRepo superRepo;
    @Autowired
    EntityManager em;

    @Test
    @org.springframework.transaction.annotation.Transactional
    void test(){
        Sub sub = new Sub();
        sub.setSubfield("Subfield");
        sub.setSuperField("Superfield");
        subRepo.save(sub);

        em.flush();
        em.clear();

        sub = new Sub();
        sub.setSubfield("Subfield22");
        sub.setSuperField("Superfield22");
        subRepo.save(sub);

        em.flush();
        em.clear();

        superRepo.findAll().forEach(System.out::println);

        em.flush();
        em.clear();

        System.out.println( superRepo.findBySuperField("Superfield"));
        
        em.flush();
        em.clear();
        
        System.out.println("출력문 왜 무시함?");
        
        Super s = em.find(Super.class, sub.getId());
        System.out.println(s);
        em.flush();
        em.clear();



        subRepo.findAll().forEach(System.out::println);
        
    }
}
