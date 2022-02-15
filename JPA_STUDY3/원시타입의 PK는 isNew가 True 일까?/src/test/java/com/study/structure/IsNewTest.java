package com.study.structure;

import javax.persistence.EntityManager;

import com.study.structure.config.JpaConfig;
import com.study.structure.domain.User;
import com.study.structure.domain.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(JpaConfig.class)
public class IsNewTest {

    @Autowired
    EntityManager em;
    @Autowired
    UserRepository userRepository;

    @Test
    void isNewTest(){
        User user = new User(0L);
        userRepository.save(user);
        em.flush(); em.clear();

        user = new User(1L);
        // em.merge(user);
        userRepository.save(user);
        em.flush(); em.clear();
    }
}
