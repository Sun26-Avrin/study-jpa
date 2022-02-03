package com.study.structure.domain.pocketmark;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@MappedSuperclass
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
public abstract class BaseEntityWithId extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
