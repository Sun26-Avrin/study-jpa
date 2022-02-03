package com.study.structure.domain.first_class_collection.repository;

import com.study.structure.domain.first_class_collection.Video;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long>{
    
}
