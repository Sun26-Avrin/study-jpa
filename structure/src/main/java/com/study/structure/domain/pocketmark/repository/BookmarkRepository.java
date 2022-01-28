package com.study.structure.domain.pocketmark.repository;

import java.util.List;

import com.study.structure.domain.pocketmark.Bookmark;
import com.study.structure.domain.pocketmark.ItemOnlyDto.IdOnlyRes;
import com.study.structure.domain.pocketmark.ItemOnlyDto.UrlOnlyRes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark,Long> {
    List<IdOnlyRes> findByComment(String comment);
}
