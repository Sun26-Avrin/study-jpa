package com.jpa.basic.test.onetoone;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import net.bytebuddy.matcher.BooleanMatcher;

import java.util.*;

import javax.persistence.EntityManager;

import com.jpa.basic.test.folder.BookmarkRepo;
import com.jpa.basic.test.folder.FolderRepo;

@SpringBootTest
public class OnetoOneTest {

    @Autowired itemRepo itemRepo;
    @Autowired folRepo folRepo;
    @Autowired bookRepo bookRepo;
    @Autowired EntityManager em;
    @Test
    @Transactional
    void test(){
        item it = item.builder().item_id(1L).build();
        item it2 = item.builder().item_id(1L).build();
        item it3 = item.builder().item_id(1L).build();
        item it4 = item.builder().item_id(1L).build();
        bookmark b1 = bookmark.builder().it(it).build();
        bookmark b2 = bookmark.builder().it(it2).build();
        bookmark b3 = bookmark.builder().it(it3).build();
        folder f1 = folder.builder().it(it4).build();
        bookRepo.saveAll(Arrays.asList(b1,b2,b3));
        folRepo.save(f1);

        // item it = item.builder().build();
        // bookmark b1 = bookmark.builder().it(it).build();
        // bookRepo.save(b1);

        // bookRepo.saveAll(Arrays.asList(b1,b2,b3));
        // itemRepo.findAll().forEach(System.out::println);
        // bookRepo.findAll().forEach(System.out::println);
        em.flush();
        em.clear();
        System.out.println("###>>");
        itemRepo.findAll().forEach(System.out::println);
        
    }
}
