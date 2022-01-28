package com.jpa.basic.test.multi;

import javax.persistence.EntityManager;

import org.hibernate.Hibernate;
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
    @Transactional(readOnly=true)
    void tesT(){
        Parent parent = new Parent();
        parent.setParentItem("parentItem");
        parent.setNo(2L);
        Parent parent2 = new Parent();
        parent2.setParentItem("parentItem");
        parent2.setNo(3L);

        Child child = new Child();
        child.setChildItem("childItem");
        child.setParentId(parent.getNo());
        Child child2 = new Child();
        child2.setChildItem("childItem2");
        child2.setParentId(parent.getNo());
        Child child3 = new Child();
        child3.setChildItem("childItem3");
        child3.setParentId(parent2.getNo());

        parentRepo.save(parent);
        parentRepo.save(parent2);
        childRepo.save(child);
        childRepo.save(child2);
        childRepo.save(child3);

        em.flush();
        em.clear();

        // childRepo.getOne(id);

        // Child children1 =  childRepo.findById(1L).get();
        // System.out.println("####>>");
        // System.out.println("####>>");
        // // children1.getParent();
        // System.out.println("####<<");
        // System.out.println("####<<");

        // childRepo.getOne(1L).setParentId(2L);
        
        Parent resultParent = parentRepo.findById(1L).get();
        // childRepo.findByParentId(resultParent.getNo());
        System.out.println(resultParent);
        System.out.println(resultParent.getChildren());
        System.out.println("################");
        System.out.println("################");
        
        
        // System.out.println(">>>>>>>>>>>>>>>");
        // Parent resultParent2 = parentRepo.findById(2L).get();
        // System.out.println("################");
        // System.out.println("################");
        
        // // System.out.println(resultParent2.getChildren());
        // System.out.println("################");

        // childRepo.findAll().forEach(System.out::println);

    }
}
