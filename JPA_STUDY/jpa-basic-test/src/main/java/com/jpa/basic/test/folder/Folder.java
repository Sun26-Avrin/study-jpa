package com.jpa.basic.test.folder;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.springframework.boot.jackson.JsonObjectSerializer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = true)
@Where(clause = "deleted = false")
@Slf4j
// @Table(indexes = @Index(name="i_folder_id", columnList = "folder_id"))
public class Folder extends TreeItem {

    /* ---------------------------------------------------------------------------------*/ 
    // TableField

    @Column(name="folder_id")
    private Long folderId;



    /* ---------------------------------------------------------------------------------*/ 
    // Non-TableField

    // @BatchSize(size=100)
    // @OneToMany(mappedBy = "folder")
    // @ToString.Exclude
    // private List<Bookmark> childrenBookmarks;

    


    /* ---------------------------------------------------------------------------------*/ 
    //redundunt field
    

    


    @Builder
    public Folder(User user, String folderId, Long parentId, String name, BigDecimal visitCount){
        this.no=folderId;
        this.user=user;
        // this.folderId=folderId;
        this.parentId=parentId;
        this.name=name;
        this.visitCount=visitCount;
    }









    

}