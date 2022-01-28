package com.jpa.basic.test.multi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepo extends JpaRepository<Child,Long>{
    List<Child> findByParentId(Long parentId);
}
