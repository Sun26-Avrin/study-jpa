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

import lombok.extern.slf4j.Slf4j;

@DataJpaTest
@Import(JpaConfig.class)
@Slf4j
public class FirstClassCollectionTest {
    
    @Autowired VideoRepository videoRepository;
    @Autowired VideoTagRepository videoTagRepository;
    @Autowired EntityManager em;
    
    @Test
    void test(){
        Video video = new Video("재미있는 유튜브 영상");
        VideoTag videoTag1 = new VideoTag(video, "#애완동물");
        VideoTag videoTag2 = new VideoTag(video, "#고양이고장남");

        videoRepository.save(video);
        videoTagRepository.saveAll(Arrays.asList(videoTag1, videoTag2));

        em.flush(); em.clear();

        Video dbVideo = videoRepository.findById(1L).get();
        log.info(">>> dbVideo : {}",dbVideo);
        // log.info(">>> dbVideo.getTags() : {}",dbVideo.getVideoTags());

    }
}
