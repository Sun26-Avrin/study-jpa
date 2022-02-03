package com.study.structure.domain.first_class_collection;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.study.structure.domain.first_class_collection.embedded.VideoTags;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Video {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String videoName;
    // @OneToMany(mappedBy = "video")
    // List<VideoTag> videoTags;

    @Embedded
    private VideoTags videoTags = new VideoTags();

    public Video(String name){
        this.videoName= name;
    }

}
