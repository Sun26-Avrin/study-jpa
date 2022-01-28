package com.study.structure.domain.pocketmark.repository;

import com.study.structure.domain.pocketmark.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
    
}
