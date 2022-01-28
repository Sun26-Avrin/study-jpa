package com.jpa.basic.test.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "F")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class folder {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    
    @OneToOne(fetch = FetchType.LAZY, targetEntity = item.class,
    cascade = CascadeType.PERSIST)
    @JoinColumn(name="item_id")
    @ToString.Exclude
    item it;
}
