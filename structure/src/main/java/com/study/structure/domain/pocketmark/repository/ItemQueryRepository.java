package com.study.structure.domain.pocketmark.repository;

import java.util.List;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.structure.domain.pocketmark.Item;
import com.study.structure.domain.pocketmark.QItem;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

// import com.study.structure.domain.pocketmark.QItem;
@RequiredArgsConstructor
@Repository
public class ItemQueryRepository {
    private final JPAQueryFactory queryFactory;
    private QItem qItem= QItem.item;

    public List<Item> selectAll(){
        List<Item> items = queryFactory.selectFrom(qItem)
                            .fetch();
                            return items;
    }
}
