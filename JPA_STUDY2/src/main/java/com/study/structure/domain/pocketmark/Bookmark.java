package com.study.structure.domain.pocketmark;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
public class Bookmark extends Item {
    
    private String url;
    private String comment;

    public Bookmark(
        String name, Long itemId, Long parentId,
        Long userId, String url, String comment
    ){
        super(itemId, userId, parentId, name);
        this.url=url;
        this.comment=comment;
    }

    
}
