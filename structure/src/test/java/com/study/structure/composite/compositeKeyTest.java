package com.study.structure.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.persistence.EntityManager;

import com.study.structure.config.JpaConfig;
import com.study.structure.domain.composite.Book;
import com.study.structure.domain.composite.cBook;
import com.study.structure.domain.composite.cBook.CompId;
import com.study.structure.domain.composite.repository.BookRepository;
import com.study.structure.domain.composite.repository.cBookRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(JpaConfig.class)
public class compositeKeyTest {

    
    @Autowired BookRepository bookRepository;
    @Autowired cBookRepository cBookRepository;
    @Autowired EntityManager em;

    @Test
    void showSchema(){

    }

    @Test
    void showQuery(){
        List<Book> books = new ArrayList<>();
        List<cBook> cBooks = new ArrayList<>();
        String[] authors = {"Brian","Matt","Sun","Torr","SpiderMan"}; 
        String[] names = {"사탕과함께사라지다","진격의노인","레프트오버","투피스","아이엠넘버포"};
        //5개
        for(int i=0; i<5; i++){
            books.add(
                Book.builder().name(names[i%5]).author(authors[i%5]).detail("KK").idx(i).build()
            );
            cBooks.add(
                cBook.builder().name(names[i%5]).author(authors[i%5]).detail("KK").idx(i).build()
            );
        }
        bookRepository.saveAll(books);
        cBookRepository.saveAll(cBooks);

        em.flush(); em.clear();
        Long startTime= System.currentTimeMillis();
        System.out.println("#Start! : "+ (startTime/1000));
        System.out.println("#Start! : "+ (startTime/(1000*60)));
        System.out.println("#Start! : "+ (startTime/(1000*60*60)));

        System.out.println("#BookmarkRepository Item Count : "+bookRepository.count());
        em.flush(); em.clear();
        System.out.println("#cBookmarkRepository Item Count :"+cBookRepository.count());
        em.flush(); em.clear();

        bookRepository.findByAuthor("Sun");
        em.flush(); em.clear();
        
        cBookRepository.findByAuthor("Sun");
        em.flush(); em.clear();
        
        bookRepository.findByAuthorAndName("Sun","레프트오버");
        em.flush(); em.clear();

        
        cBookRepository.findByAuthorAndName("Sun","레프트오버");
        em.flush(); em.clear();
        
        CompId pk = new CompId("Sun", "레프트오버");
        em.find(cBook.class, pk);
        em.flush(); em.clear();

        bookRepository.findByDetail("KK");
        em.flush(); em.clear();

        cBookRepository.findByDetail("KK");
        em.flush(); em.clear();

        bookRepository.findByIdx(2);
        em.flush(); em.clear();
        cBookRepository.findByIdx(2);
        em.flush(); em.clear();
    }


    @Test
    void test(){

        List<Book> books = new ArrayList<>();
        List<cBook> cBooks = new ArrayList<>();

        String[] authors = {"Brian","Matt","Sun","Torr","SpiderMan"}; 
        String[] names = {"사탕과함께사라지다","진격의노인","레프트오버","투피스","아이엠넘버포"};
        //30만개
        int cnt =1;
        int size = 300_000;
        for(int i=0; i<0; i++){
            if(i%5==0){
                cnt++;
            }
            books.add(
                Book.builder().name(names[i%5]+cnt).author(authors[i%5]).detail("KK").idx(i).build()
            );
            cBooks.add(
                cBook.builder().name(names[i%5]+cnt).author(authors[i%5]).detail("KK").idx(i).build()
            );

        }

        bookRepository.saveAll(books);
        cBookRepository.saveAll(cBooks);

        em.flush(); em.clear();
        System.out.println("#BookmarkRepository Item Count : "+bookRepository.count());
        em.flush(); em.clear();
        System.out.println("#cBookmarkRepository Item Count :"+cBookRepository.count());
        em.flush(); em.clear();
        Long startTime;
        Long endTime; 
        Long result;

        Long[] sum= new Long[100];
        Arrays.fill(sum, 0L);
        Queue<Long> results= new LinkedList<>();
        cnt=0; int idx=0;
        while(cnt<20){ //20 회 평균
            idx = 0;

            //1
            startTime= System.currentTimeMillis();
            bookRepository.findByAuthor("Sun");
            endTime= System.currentTimeMillis();
            result = endTime-startTime;
            sum[idx++]+=result;
            em.flush(); em.clear();
            
            //2
            startTime= System.currentTimeMillis();
            cBookRepository.findByAuthor("Sun");
            endTime= System.currentTimeMillis();
            result = endTime-startTime;
            sum[idx++]+=result;
            em.flush(); em.clear();
            
            //3
            startTime= System.currentTimeMillis();
            bookRepository.findByAuthorAndName("Sun","레프트오버10");
            endTime= System.currentTimeMillis();
            result = endTime-startTime;
            sum[idx++]+=result;
            em.flush(); em.clear();
    
            //4
            startTime= System.currentTimeMillis();
            cBookRepository.findByAuthorAndName("Sun","레프트오버10");
            endTime= System.currentTimeMillis();    
            result = endTime-startTime;
            sum[idx++]+=result;     
            em.flush(); em.clear();
    
            //5
            startTime= System.currentTimeMillis();
            //엔티티 필드 ID순서(테이블필드순서)랑 복합키클래스이 필드순서가 일치해야 인덱스를 탄다.......................;;;;;; 
            CompId pk = new CompId("레프트오버10","Sun");
            em.find(cBook.class, pk);
            endTime= System.currentTimeMillis();
            result = endTime-startTime;
            sum[idx++]+=result;
            em.flush(); em.clear();
            
            //6
            startTime= System.currentTimeMillis();
            bookRepository.findByDetail("KK");
            endTime= System.currentTimeMillis();
            result = endTime-startTime;
            sum[idx++]+=result;
            em.flush(); em.clear();
            
            //7
            startTime= System.currentTimeMillis();
            cBookRepository.findByDetail("KK");
            endTime= System.currentTimeMillis();
            result = endTime-startTime;
            sum[idx++]+=result;
            em.flush(); em.clear();
            
            //8 insert 성능
            Book book = Book.builder().name(names[0]).author(authors[0]).detail("KK").build();
            startTime= System.currentTimeMillis();
            bookRepository.save(book);
            em.flush(); em.clear();
            endTime= System.currentTimeMillis();
            result = endTime-startTime;
            sum[idx++]+=result;
            
            //9
            cBook cbook = cBook.builder().name(names[0]).author(authors[0]).detail("KK").build();
            startTime= System.currentTimeMillis();
            cBookRepository.save(cbook);
            em.flush(); em.clear();
            endTime= System.currentTimeMillis();
            result = endTime-startTime;
            sum[idx++]+=result;
            
            //10
            book = Book.builder().name(names[0]).author(authors[0]).detail("KK").idx(150_000).build();
            startTime= System.currentTimeMillis();
            bookRepository.save(book);
            em.flush(); em.clear();
            endTime= System.currentTimeMillis();
            result = endTime-startTime;
            sum[idx++]+=result;
            
            //11
            cbook = cBook.builder().name(names[0]+"@").author(authors[0]).detail("KK").idx(150_000).build();
            startTime= System.currentTimeMillis();
            cBookRepository.save(cbook);
            em.flush(); em.clear();
            endTime= System.currentTimeMillis();
            result = endTime-startTime;
            sum[idx++]+=result;

            //12 Index 로 조회
            startTime= System.currentTimeMillis();
            bookRepository.findByIdx(13_000);
            endTime= System.currentTimeMillis();
            result = endTime-startTime;
            sum[idx++]+=result;
            em.flush(); em.clear();
            
            //13
            startTime= System.currentTimeMillis();
            cBookRepository.findByIdx(13_000);
            endTime= System.currentTimeMillis();
            result = endTime-startTime;
            sum[idx++]+=result;
            em.flush(); em.clear();


            cnt++;
        }

        for(int i=0; i<13; i++){
            results.add(sum[i]/cnt);
        }

        System.out.println("#1 GenralBook.findByAuthor >>> : " + (results.poll()));
        System.out.println("#2 CompositeBook.findByAuthor >>> : " + (results.poll()));
        System.out.println("#3 GenralBook.findByAuthorAndName >>> : " + (results.poll()));
        System.out.println("#4 CompositeBook.findByAuthorAndName >>> : " + (results.poll()));
        System.out.println("#5 CompositeBook.findByPK >>> : " + (results.poll()));
        System.out.println("#6 GeneralBook.findByDetail >>> : " + (results.poll()));
        System.out.println("#7 CompositeBook.findByDetail >>> : " + (results.poll()));
        System.out.println("#8 GeneralBook.insert >>> : " + (results.poll()));
        System.out.println("#9 CompositeBook.insert >>> : " + (results.poll()));
        System.out.println("#10 GeneralBook.insert >>> : " + (results.poll()));
        System.out.println("#11 CompositeBook.insert >>> : " + (results.poll()));
        System.out.println("#12 GeneralBook.findByIdx >>> : " + (results.poll()));
        System.out.println("#13 CompositeBook.findByIdx >>> : " + (results.poll()));

        System.out.println("Queue Size : "+ results.size());





    }
}
