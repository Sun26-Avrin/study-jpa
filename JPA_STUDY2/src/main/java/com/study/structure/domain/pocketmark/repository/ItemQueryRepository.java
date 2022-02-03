package com.study.structure.domain.pocketmark.repository;

import java.util.List;

import com.querydsl.core.dml.UpdateClause;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.study.structure.domain.pocketmark.Item;
import com.study.structure.domain.pocketmark.QItem;
import com.study.structure.domain.pocketmark.Dto.ItemOnlyRes;

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



    public Long update(){
        UpdateClause<JPAUpdateClause> builder = queryFactory.update(qItem);

        builder.set(qItem.name, "바꿔땅!");
        return builder.where(qItem.itemId.eq(1L)).execute();

    }

}
