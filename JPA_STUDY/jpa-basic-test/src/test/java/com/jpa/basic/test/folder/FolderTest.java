package com.jpa.basic.test.folder;

import com.jpa.basic.test.folder.Folder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.*;

@SpringBootTest
public class FolderTest {

    @Autowired
    FolderRepo folderRepository;
    @Autowired
    UserRepo userRepository;
    @Autowired
    BookmarkRepo bookmarkRepository;
    @Autowired
    TreeRepo treeRepository;


    @Autowired
    EntityManager em;


    @Test
    @Transactional
    @Commit
    void relTest(){
        User user = User.builder().build();
        userRepository.save(user);
        Folder aFolder = Folder.builder().name("aFolder").folderId(String.valueOf(user.getId())+0).parentId(null).user(user).build();
        Folder bFolder = Folder.builder().name("bFolder").folderId(String.valueOf(user.getId())+1).parentId(10L).user(user).build();
        Folder cFolder = Folder.builder().name("cFolder").folderId(String.valueOf(user.getId())+2).parentId(10L).user(user).build();
        Folder dFolder = Folder.builder().name("dFolder").folderId(String.valueOf(user.getId())+3).parentId(11L).user(user).build();
        Folder eFolder = Folder.builder().name("eFolder").folderId(String.valueOf(user.getId())+4).parentId(11L).user(user).build();
        Bookmark aBookmark = Bookmark.builder().name("aBookmark").parentId(10L).user(user).build();

        folderRepository.saveAll(Arrays.asList(aFolder,bFolder,cFolder,dFolder,eFolder));
        bookmarkRepository.save(aBookmark);
        
        em.flush();
        em.clear();
        
        user = User.builder().build();
        userRepository.save(user);
        Folder a2Folder = Folder.builder().name("a2Folder").folderId(String.valueOf(user.getId())+0).parentId(null).user(user).build();
        Folder b2Folder = Folder.builder().name("b2Folder").folderId(String.valueOf(user.getId())+1).parentId(20L).user(user).build();
        Folder c2Folder = Folder.builder().name("c2Folder").folderId(String.valueOf(user.getId())+2).parentId(22L).user(user).build();
        folderRepository.saveAll(Arrays.asList(a2Folder,b2Folder,c2Folder));

        em.flush();
        em.clear();

        System.out.println("1 1 - T @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        // treeRepository.findAll().forEach(System.out::println);
        for (TreeItem a  :treeRepository.findAll()){
            System.out.println(a);
        }
        // System.out.println("2 2 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        // TreeItem treeItem = folderRepository.findByFolderIdAndUserId(0L,1L);
        // System.out.println(treeItem);
        System.out.println("1 1 - F @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        folderRepository.findAll().forEach(System.out::println);
        
        em.flush();
        em.clear();

        System.out.println("2 2 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        TreeItem treeItem = folderRepository.findByNo(String.valueOf(1)+0);
        System.out.println(treeItem.getClass().getName());

        System.out.println("3 3 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        treeItem.getChildrenItems().forEach(System.out::println);


    }
}
