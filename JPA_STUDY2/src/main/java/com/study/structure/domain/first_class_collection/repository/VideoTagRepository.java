package com.study.structure.domain.first_class_collection.repository;

import com.study.structure.domain.first_class_collection.VideoTag;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoTagRepository extends JpaRepository<VideoTag,Long> {
    
}
