package com.jpa.basic.test.multi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Parent implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    // @Column(name="item_id")
    Long no;

    String parentItem;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    @ToString.Exclude
    List<Child> children;
    

    
}
