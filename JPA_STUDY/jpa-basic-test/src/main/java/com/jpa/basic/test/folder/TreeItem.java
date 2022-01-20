package com.jpa.basic.test.folder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.BatchSize;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// @MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Getter
@NoArgsConstructor
@ToString(callSuper = false)
public class TreeItem implements Serializable {
    /* ---------------------------------------------------------------------------------*/ 
    // TableField
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    
    public String no;


    public String name;
    public BigDecimal visitCount;

    @Column(name="parent_id")
    public Long parentId;
    @Column(name="user_id", insertable = false, updatable = false)
    public Long userId;

    /* ---------------------------------------------------------------------------------*/ 
    // Non-TableField
    @BatchSize(size=100)
    @OneToMany(mappedBy = "parent",fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<TreeItem> childrenItems;

    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Folder folder;
    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Bookmark bookmarks;



    /* ---------------------------------------------------------------------------------*/ 
    //redundunt field

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="parent_id", insertable = false, updatable = false,
                foreignKey = @ForeignKey(value=ConstraintMode.NO_CONSTRAINT),
                unique = false,
                referencedColumnName = "no") 
    // @JoinColumns({
    //     // @JoinColumn(name="parent_id", referencedColumnName = "parent_id", insertable = false,updatable = false),
    //     // @JoinColumn(name="no",referencedColumnName = "no", insertable = false, updatable = false),
    //     @JoinColumn(name="no",referencedColumnName = "parent_id", insertable = false, updatable = false),
    //     @JoinColumn(name="no",referencedColumnName = "user_id", insertable = false, updatable = false)
    //     // @JoinColumn(name="user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    // })
    @ToString.Exclude
    private TreeItem parent;

    @ManyToOne(fetch = FetchType.LAZY,
                targetEntity = User.class)
    @JoinColumn(name="user_id") @ToString.Exclude
    public User user;

    




    public boolean visitCountUpdate(BigDecimal cnt){
        if(cnt.compareTo(this.visitCount)>0){
            this.visitCount=cnt;
            return true;
        }else{
            log.error("Unvalid VisitCntUpdate");
            return false;
        }
    } 
}
