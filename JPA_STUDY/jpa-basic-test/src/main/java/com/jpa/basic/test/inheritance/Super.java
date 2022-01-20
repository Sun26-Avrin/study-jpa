package com.jpa.basic.test.inheritance;

import javax.annotation.Generated;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
// @DiscriminatorColumn
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class Super {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String superField;
}
