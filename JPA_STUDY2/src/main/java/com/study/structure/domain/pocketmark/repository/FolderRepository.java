package com.study.structure.domain.pocketmark.repository;

import java.util.List;

import com.study.structure.domain.pocketmark.Folder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder,Long> {
    
}
