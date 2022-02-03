package com.study.structure.domain.pocketmark.repository;

import java.util.List;

import com.study.structure.domain.pocketmark.Item;
import com.study.structure.domain.pocketmark.Dto;
import com.study.structure.domain.pocketmark.Dto.BookmarkOnlyRes;
import com.study.structure.domain.pocketmark.Dto.IdOnlyRes;
import com.study.structure.domain.pocketmark.Dto.ItemOnlyRes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
    // List<BookmarkOnlyRes> findByItemId(Long itemId);
    List<ItemOnlyRes> findByItemId(Long itemId);
    List<ItemOnlyRes> findByUserId(Long userId);
}
