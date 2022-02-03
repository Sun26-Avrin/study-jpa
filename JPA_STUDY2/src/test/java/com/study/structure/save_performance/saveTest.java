package com.study.structure.save_performance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.study.structure.config.JpaConfig;
import com.study.structure.domain.save_performance.Member;
import com.study.structure.domain.save_performance.MemberRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@ActiveProfiles("nosql")
public class saveTest {

    @Test
    void showSchema(){

    }

    @Autowired EntityManager em;
    @Autowired MemberRepository memberRepository;

    @DisplayName("기존 트랜잭션이 없을 경우 - 트랜잭션 생성 오버헤드")
    @Test
    void saveTestWithNoTransactionExist(){
        Member member;
        Long startTime; Long endTime;
        startTime= System.currentTimeMillis();
        for(int i=0; i<10_000; i++){
            member = new Member("홍길동");
            memberRepository.save(member);
        }
        endTime = System.currentTimeMillis();
        log.info("기존트랜잭션이 없을 경우 save 10_000번 : {}",endTime-startTime);
        em.clear();
        
        
        List<Member> members= new ArrayList<>();
        startTime= System.currentTimeMillis();
        for(int i=0; i<10_000; i++){
            members.add(new Member("홍길동"));
        }
        memberRepository.saveAll(members);
        endTime = System.currentTimeMillis();
        log.info("기존트랜잭션이 없을 경우 saveAll 10_000개 : {}",endTime-startTime);
        em.clear();
        
    }

    @DisplayName("기존 트랜잭션이 있을 경우 - 다른인스턴스 호출로 인한 프록시로직 오버헤드")
    @Test
    @Transactional
    void saveTestWithExistingTransaction(){
        Member member;
        Long startTime; Long endTime;
        startTime= System.currentTimeMillis();
        for(int i=0; i<10_000; i++){
            member = new Member("홍길동");
            memberRepository.save(member);
        }
        em.flush(); em.clear();
        endTime = System.currentTimeMillis();
        log.info("기존트랜잭션이 존재할 경우 save 10_000번 : {}",endTime-startTime);
        
        
        List<Member> members= new ArrayList<>();
        startTime= System.currentTimeMillis();
        for(int i=0; i<10_000; i++){
            members.add(new Member("홍길동"));
        }
        memberRepository.saveAll(members);
        em.flush(); em.clear();
        endTime = System.currentTimeMillis();
        log.info("기존트랜잭션이 존재할 경우 saveAll 10_000개 : {}",endTime-startTime);

    }
    
}
