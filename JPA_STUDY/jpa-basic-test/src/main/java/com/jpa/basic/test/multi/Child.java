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
import javax.persistence.ManyToOne;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id", insertable = false, updatable = false,
                // foreignKey = @ForeignKey(value=ConstraintMode.NO_CONSTRAINT),
                referencedColumnName = "no")
    @ToString.Exclude
    Parent parent;
}
