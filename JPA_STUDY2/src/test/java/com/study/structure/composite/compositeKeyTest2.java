package com.study.structure.composite;

import javax.persistence.EntityManager;

import com.study.structure.config.JpaConfig;
import com.study.structure.domain.composite.cBook;
import com.study.structure.domain.composite.cBook2;
import com.study.structure.domain.composite.cBook.cBookPk;
import com.study.structure.domain.composite.repository.cBook2Repository;
import com.study.structure.domain.composite.repository.cBookRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@Import(JpaConfig.class)
public class compositeKeyTest2 {
    @Autowired cBookRepository cBookRepository;
    @Autowired cBook2Repository cBook2Repository;
    @Autowired EntityManager em;
    

    @DisplayName("PK를 DB에 위임하지 않았을 때 생기는 영속성문제 - save시 select+insert 쿼리")
    @Test
    void persistanceCheckTest(){
        //cBook은 name과 auther의 복합키로 PK가 구성되어있음
        cBook book= new cBook(new cBookPk("책 이름","작가 이름"));
        cBookRepository.save(book);
        em.flush(); em.clear();
    }

    @DisplayName("PK를 DB에 위임하지 않았을 때 생기는 영속성문제를 해결")
    @Test
    void persistanceSolveTest(){
        cBook2 book = new cBook2(new cBookPk("책 이름","작가 이름"));
        cBook2Repository.save(book);
        em.flush(); em.clear();
    }

    @DisplayName("readOnly는 영속성을 저장하지 않는다. 그럴때 isNew 로직이 발동할까? 발동하네...")
    @Test 
    @Transactional(readOnly = true)
    void persistanceCheckTest2(){
        cBook book= new cBook(new cBookPk("책 이름","작가 이름"));
        cBookRepository.save(book);
        em.flush(); em.clear();
    }
}
