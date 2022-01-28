package com.study.structure.pocketmark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import com.study.structure.config.JpaConfig;
import com.study.structure.config.QueryDslConfig;
import com.study.structure.domain.onetoone.MainEngine;
import com.study.structure.domain.pocketmark.Bookmark;
import com.study.structure.domain.pocketmark.Folder;
import com.study.structure.domain.pocketmark.Item;
import com.study.structure.domain.pocketmark.Tag;
import com.study.structure.domain.pocketmark.repository.BookmarkRepository;
import com.study.structure.domain.pocketmark.repository.FolderRepository;
// import com.study.structure.domain.pocketmark.repository.ItemOnlyRepository;
import com.study.structure.domain.pocketmark.repository.ItemQueryRepository;
import com.study.structure.domain.pocketmark.repository.ItemRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Commit;

@DataJpaTest
@Import({JpaConfig.class,ItemQueryRepository.class, QueryDslConfig.class})
public class structureTest {
    
    Folder makeFolder(
        String name, Long itemId, Long parentId, 
        Long userId
    ){
        Folder folder = new Folder(name, itemId, parentId, userId);
        // for(Tag tag : tags){
        //     tag.setItem(folder);
        // }
        // folder.setTags(tags);
        return folder;
        

    }
    Bookmark makeBookmark(
        String name, Long itemId, Long parentId, Long userId,
        String url, String comment  
    ){
        Bookmark mark = new Bookmark(name, itemId, parentId, userId, url, comment);
        
        return mark;


    }


    @Autowired ItemRepository itemRepository;
    @Autowired FolderRepository folderRepository;
    @Autowired BookmarkRepository bookmarkRepository;
    // @Autowired TagRepository tagRepository;
    @Autowired EntityManager em;
    @Autowired ItemQueryRepository itemQueryRepository;
    // @Autowired ItemOnlyRepository itemOnlyRepository;

    @Test
    void showSchema(){

    }


    @Test
    void test(){
        Long user1ItemId = 0L;
        List<Tag> tags = new ArrayList<>();
        Tag tag; 
        

        Folder rootfolder = makeFolder("ROOT폴더", user1ItemId++, null, 1L);
        tag = Tag.builder().tag("Animal").item(rootfolder).build(); tags.add(tag);
        tag=Tag.builder().tag("Funny").item(rootfolder).build(); tags.add(tag);
        rootfolder.setTags(tags); 
        // tags= new ArrayList<>();

        Folder afolder = makeFolder("aFolder", user1ItemId++, 0L, 1L);
        Folder bfolder = makeFolder("bFolder", user1ItemId++, 0L, 1L);

        Bookmark aMark = makeBookmark("aMark", user1ItemId++, rootfolder.getItemId(), 1L, "aMarkUrl", "Acomment");
        Bookmark bMark = makeBookmark("bMark", user1ItemId++, rootfolder.getItemId(), 1L, "bMarkUrl", "Bcomment");
        Bookmark cMark = makeBookmark("aFolderMark", user1ItemId++, afolder.getItemId(), 1L, "cMarkUrl", "Ccomment");

        folderRepository.saveAll(Arrays.asList(rootfolder, afolder,bfolder));
        bookmarkRepository.saveAll(Arrays.asList(aMark, bMark,cMark));

        

        em.flush();
        em.clear();
        // System.out.println(">>>>>>>>>>>");
        // System.out.println("# Folder");
        folderRepository.findAll().forEach(System.out::println);
        em.flush();
        em.clear();
        // System.out.println("# Bookmark");
        bookmarkRepository.findAll().forEach(System.out::println);
        // em.flush();
        // em.clear();
        // // System.out.println("# TAG");
        // // tagRepository.findAll().forEach(System.out::println);
        // // em.flush();
        // // em.clear();
        // System.out.println("# Item");
        // itemRepository.findAll().forEach(System.out::println);

        em.flush(); em.clear();
        
        em.find(Item.class, 1L);


        // itemQueryRepository.selectAll().forEach(System.out::println);
        // itemOnlyRepository.findAll().forEach(System.out::println);
    }
}
