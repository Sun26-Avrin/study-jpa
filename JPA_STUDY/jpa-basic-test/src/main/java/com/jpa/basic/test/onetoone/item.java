package com.jpa.basic.test.onetoone;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class item {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    Long item_id;

    Long parent_id;

    // String dType;

    // @BatchSize(size = 100)
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "it", optional = true)
    // @JoinColumn(name="dType")
    List<bookmark> bookmark;
    
    // @BatchSize(size = 100)
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "it", optional = true)
    // @JoinColumn(name="dType")
    List<folder> folder;

}
