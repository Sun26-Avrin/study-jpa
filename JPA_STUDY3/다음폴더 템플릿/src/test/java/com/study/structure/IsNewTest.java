package com.study.structure;

import com.study.structure.config.JpaConfig;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(JpaConfig.class)
public class IsNewTest {
    
}
