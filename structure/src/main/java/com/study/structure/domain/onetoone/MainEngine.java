package com.study.structure.domain.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class MainEngine {
    
    @Id 
    private Long id;
    private String engineInfo;

    @MapsId
    @OneToOne
    @JoinColumn(name="id")
    @ToString.Exclude
    Car car;

}
