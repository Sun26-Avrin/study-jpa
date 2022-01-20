package com.jpa.basic.test.folder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepo extends JpaRepository<Folder,Long> {
    Folder findByFolderIdAndUserId(Long folderId, Long UserId);
    List<TreeItem> findByFolderId(Long folderId);
    TreeItem findByNo(String folderNo);

}
