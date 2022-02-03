package com.study.structure.domain.pocketmark;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.study.structure.domain.onetoone.MainEngine;
import com.study.structure.domain.pocketmark.Item.PK;

import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;
import org.springframework.data.annotation.Immutable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="dtype")
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@IdClass(PK.class)
// @Table(indexes = @Index(name="i_parent_id", columnList = "parent_id"))
public class Item extends BaseEntity{
    
    @Id
    public Long itemId; //FolderId & BookmarkId
    @Id @Column(name="user_id")
    public Long userId;

    @Column(name="parent_id")
    public Long parentId;
    public String name;
    public BigDecimal visitCount;


    @ManyToOne(
        fetch = FetchType.LAZY,
        targetEntity = User.class)
    @JoinColumn(name="user_id",insertable = false, updatable = false)
    @ToString.Exclude
    protected User user;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = CascadeType.ALL)
    // @ToString.Exclude
    private List<Tag> tags;

    public void setTags(List<Tag> tags){
        this.tags=tags;
    }

    

    @AllArgsConstructor @NoArgsConstructor
    @EqualsAndHashCode
    public static class PK implements Serializable{
        private Long itemId;
        private Long userId;
    }
    
    public Item(
        Long itemId, Long userId,    
        Long parentId, String name
    ){
        this.itemId=itemId;
        // System.out.println(">>> Item Id >>> Con >>> "+ this.itemId);
        this.userId=userId;
        // new PK(itemId, user.getId());
        this.parentId=parentId;
        this.name=name;
        this.visitCount=BigDecimal.valueOf(0L);
    }

    /* Table Structure */

    //Item - 6(base) + 5 + 1(Discrimainator Column)

    //Folder - 0 + 1 (PK+FK)

    //Bookmark - 2 + 1(PK+FK)
    // private String url;
    // private String comment;


    // 기존 Folder 6(Base) + 5
    // 기존 Bookmark 6(Base) + 8


    // 폴더 100개 북마크 100개 insert 
    // Item(12*200)+Folder(1*100)+Bookmark(3*100) = 2400+100+300 = 2800
                //Discrimator 가 없다면        = 2200+100+300 = 2600
    // 기존 Folder(11*100)+ Bookmark(14*100) = 1100+1400 = 2500

    // tag 필드추가, 폴더100개 북마크100개 insert
    //Item(13*200)+Folder(1*100)+Bookmark(3*100) = 2600+100+300 = 3000
    // 기존 Folder(12*100)+ Bookmark(15*100) = 1200+1500=2700

}
