package com.study.structure.domain.pocketmark;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Folder extends Item{
    private String test;

    

    // @Builder
    public Folder(
        Long itemId, Long userId,    
        Long parentId, String name
        
    ){
        // 객체 메세지를 부모클래스에 전달한다. (SRP 원칙)
        // super();
        // 부모필드에 직접접근은 하면안됨 
        super(itemId, userId, parentId, name);
    }
}
