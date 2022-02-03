package com.study.structure.domain.composite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.study.structure.domain.composite.cBook.cBookPk;

import org.springframework.data.domain.Persistable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(cBookPk.class)
public class cBook2 implements Persistable<cBookPk>{
    @Id private String author;
    @Id private String name;

    @Transient
    private boolean isNew=true;


    @Override
    public cBookPk getId() {
        return new cBookPk(this.name, this.author);
    }

    @Override
    public boolean isNew() {
        // TODO Auto-generated method stub
        return this.isNew;
    }

    public void setIsNew(boolean isNew){
        this.isNew=isNew;
    }




    private String detail;
    private Integer idx;

    public cBook2(cBookPk pk){
        this.author = pk.getAuthor();
        this.name= pk.getName();
    }

    


    
}
