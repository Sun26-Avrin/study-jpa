package com.study.structure.domain.pocketmark;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.study.structure.domain.onetoone.MainEngine;

import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;
import org.springframework.data.annotation.Immutable;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
// @Customizer(ItemCustomizer.class)
// @Polymorphism(type = PolymorphismType.EXPLICIT)
public class Item extends BaseEntityWithId{
    

    public Long itemId; //FolderId & BookmarkId
    public String name;
    public Long parentId;
    public BigDecimal visitCount;
    // public String tag;
    public Long userId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Tag> tags;

    public void setTags(List<Tag> tags){
        this.tags=tags;
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
