package com.study.structure.domain.pocketmark.repository;

import java.util.List;

import com.study.structure.domain.pocketmark.Item;
import com.study.structure.domain.pocketmark.ItemOnlyDto;
import com.study.structure.domain.pocketmark.ItemOnlyDto.IdOnlyRes;
import com.study.structure.domain.pocketmark.ItemOnlyDto.ItemOnlyRes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
    List<ItemOnlyRes> findByItemId(Long itemId);
}
