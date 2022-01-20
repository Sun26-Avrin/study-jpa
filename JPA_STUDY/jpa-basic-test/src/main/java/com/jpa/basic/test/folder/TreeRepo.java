package com.jpa.basic.test.folder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TreeRepo extends JpaRepository<TreeItem, Long> {

    TreeItem findByParentId(Long parentId);
    
}
