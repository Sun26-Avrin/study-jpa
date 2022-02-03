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
import com.study.structure.domain.pocketmark.User;
import com.study.structure.domain.pocketmark.repository.BookmarkRepository;
import com.study.structure.domain.pocketmark.repository.FolderRepository;
// import com.study.structure.domain.pocketmark.repository.ItemOnlyRepository;
import com.study.structure.domain.pocketmark.repository.ItemQueryRepository;
import com.study.structure.domain.pocketmark.repository.ItemRepository;
import com.study.structure.domain.pocketmark.repository.TagRepository;
import com.study.structure.domain.pocketmark.repository.UserRepository;

import org.junit.jupiter.api.DisplayName;
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
        Folder folder = new Folder(itemId, userId, parentId, name);
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
    @Autowired TagRepository tagRepository;
    @Autowired EntityManager em;
    @Autowired ItemQueryRepository itemQueryRepository;
    @Autowired UserRepository userRepository;
    // @Autowired ItemOnlyRepository itemOnlyRepository;

    @Test
    void showSchema(){

    }

    @Test
    void dslTest(){

    }


    @DisplayName("@Inheritance 슈퍼클래스만 조회 (Without Outer Join)")
    @Test
    void test(){
        //PK에 FK두니까 FK Update문은 안생김... 뭐지... 
        //FK연결도 되어있음(없는 유저 ID 입력시 violation)
        //FK Update 다시 공부해야할듯? 
        //복합키는 꼭 필드이름으로 insert 해야함
        // 연관관계맺은 엔티티 넣어봤자 안됨(그 필드만 되고, 다른필드는 null로 됨... 왜지)
        // 복합키 관련필드는 insertable=false, updatable=false 를 무시한다. 

        Long user1ItemId = 0L;
        List<Tag> tags = new ArrayList<>();
        Tag tag; 
        User user = User.builder().userName("Ping9").build();
        userRepository.save(user);

        Folder rootfolder = makeFolder("ROOT폴더", user1ItemId++, null, 1L);
        System.out.println(">>> Root Folder : "+ rootfolder);
        // folderRepository.save(rootfolder);
        em.flush(); em.clear();
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
        

        em.flush(); em.clear();
        // em.find(Item.class, 1L);
        // em.flush(); em.clear();
        itemRepository.findByItemId(1L);
        em.flush(); em.clear();

        itemQueryRepository.selectAll();



        // em.flush(); em.clear();
        // itemQueryRepository.update();
        
        // em.flush(); em.clear();
        // System.out.println(
        //      itemRepository.findByItemId(0L).get(0).getName());
        // em.flush(); em.clear();
        // itemRepository.findByItemId(0L).forEach(
        //     it->{System.out.println(it.toText());}
        // );

        // em.flush(); em.clear();
        // userRepository.findAll().forEach(System.out::println);

        // itemQueryRepository.selectAll().forEach(System.out::println);
        // itemOnlyRepository.findAll().forEach(System.out::println);
    }
}
