package com.study.structure.domain.pocketmark.repository;

import com.study.structure.domain.pocketmark.Bookmark;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark,Long> {
    
}
