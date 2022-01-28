package com.study.structure.domain.pocketmark.repository;

import java.util.List;

import com.study.structure.domain.pocketmark.Tag;
import com.study.structure.domain.pocketmark.ItemOnlyDto.IdOnlyRes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
    List<IdOnlyRes> findByTag(String tag);
}
