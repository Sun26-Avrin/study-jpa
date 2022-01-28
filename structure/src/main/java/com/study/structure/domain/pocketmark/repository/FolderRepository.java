package com.study.structure.domain.pocketmark.repository;

import java.util.List;

import com.study.structure.domain.pocketmark.Folder;
import com.study.structure.domain.pocketmark.ItemOnlyDto;
import com.study.structure.domain.pocketmark.ItemOnlyDto.ItemOnlyRes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder,Long> {
    
}
