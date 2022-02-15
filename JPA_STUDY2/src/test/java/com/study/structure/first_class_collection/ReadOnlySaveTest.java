package com.study.structure.first_class_collection;

import java.util.Arrays;

import javax.persistence.EntityManager;

import com.study.structure.config.JpaConfig;
import com.study.structure.domain.first_class_collection.Video;
import com.study.structure.domain.first_class_collection.VideoTag;
import com.study.structure.domain.first_class_collection.repository.VideoRepository;
import com.study.structure.domain.first_class_collection.repository.VideoTagRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@Import(JpaConfig.class)
public class ReadOnlySaveTest {

    @Autowired VideoRepository videoRepository;
    @Autowired VideoTagRepository videoTagRepository;
    @Autowired EntityManager em;

    @Test
    @Transactional(readOnly = true)
    void readOnlySaveTest(){
        Video video = new Video("재미있는 유튜브 영상");
        VideoTag videoTag1 = new VideoTag(video, "#애완동물");
        VideoTag videoTag2 = new VideoTag(video, "#고양이고장남");

        videoRepository.save(video);
        videoTagRepository.saveAll(Arrays.asList(videoTag1, videoTag2));

        //영속성을 사용안하겠다는 거지, flush를 사용안하겠다는게 아님 ... (흠)
        em.flush(); em.clear(); 

        videoRepository.findAll().forEach(System.out::println);

        em.flush(); em.clear();

        
    }
}
