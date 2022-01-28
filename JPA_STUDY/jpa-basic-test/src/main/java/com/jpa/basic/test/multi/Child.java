package com.jpa.basic.test.multi;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Reference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Child {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;


    String childItem;
    
    @Column(name="parent_id")
    Long parentId;

    // @ManyToOne(fetch = FetchType.LAZY, targetEntity= Parent.class )
    // @JoinColumn(name="parent_id", insertable = false, updatable = false,
    //             // foreignKey = @ForeignKey(value=ConstraintMode.NO_CONSTRAINT),
    //             referencedColumnName = "item_id")
    @ManyToOne(fetch = FetchType.LAZY, targetEntity= Parent.class )
    @JoinColumn(name="parent_id", insertable = false, updatable = false,
                foreignKey = @ForeignKey(value=ConstraintMode.NO_CONSTRAINT),
                referencedColumnName = "no")
    @ToString.Exclude
    Parent parent;



    // @Transient
    // @ToString.Exclude
    // @Autowired ParentRepo parentRepo;

    // public Parent getParent(){
    //     Parent parentProxy = parentRepo.getById(1L);
    //     parentProxy.setItemId(this.parentId);
    //     System.out.println(">>>>>> getter : "+parentProxy.itemId);
    //     return parentProxy;
    // }

    // public void setParent(){
    //     Parent parentProxy = parentRepo.getById(1L);
    //     parentProxy.setItemId(this.parentId);
    //     System.out.println(">>>>>> setter : "+parentProxy.itemId);
    //     this.parent= parentProxy;
    // }

    // Proxy 에 PK 값이 없어서 Select가 한번 호출됨 ㅇㅇ






}
