package com.jpa.basic.test.multi;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class multiTest {
    @Autowired
    ChildRepo childRepo;
    @Autowired
    ParentRepo parentRepo;
    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void tesT(){
        Parent parent = new Parent();
        parent.setParentItem("parentItem");
        parent.setNo(2L);

        Child child = new Child();
        child.setChildItem("childItem");
        child.setParentId(2L);
        Child child2 = new Child();
        child2.setChildItem("childItem2");
        child2.setParentId(2L);

        parentRepo.save(parent);
        childRepo.save(child);
        childRepo.save(child2);

        em.flush();
        em.clear();

        Parent resultParent = parentRepo.findById(1L).get();
        System.out.println(resultParent);

        System.out.println(resultParent.getChildren());

        System.out.println(">>>>@@@@@@@@@");

        childRepo.findAll().forEach(System.out::println);

    }
}
