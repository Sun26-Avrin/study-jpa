


package com.jpa.basic.test.folder;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


import org.hibernate.annotations.Where;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Where(clause = "deleted = false")
@Slf4j

public class Bookmark extends TreeItem{

    /* ---------------------------------------------------------------------------------*/ 
    // TableField
    private String url;
    private String comment;

    // @Column(name="folder_pk", insertable = false, updatable = false)
    // private Long folderPk;

    // private Long folderId;
    private Long bookmarkId;


    /* ---------------------------------------------------------------------------------*/ 
    // Non-TableField



    
    /* ---------------------------------------------------------------------------------*/ 
    //redundunt field
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name="folder_pk")
    // @ToString.Exclude
    // private Folder folder;





    /* ---------------------------------------------------------------------------------*/ 

    //bookmarkId 를 프론트단에서 관리하게끔 하는 이유 : 모든 변경로그를 남기고싶어서
    @Builder
    protected Bookmark(User user,Long bookmarkId, Long parentId, String name, String url, String comment, BigDecimal visitCount){
        this.user=user;
        this.bookmarkId = bookmarkId;
        this.parentId= parentId;
        this.name=name;
        this.url=url;
        this.comment=comment;
        this.visitCount=visitCount;
    }
    
    

    




    
    
}

















