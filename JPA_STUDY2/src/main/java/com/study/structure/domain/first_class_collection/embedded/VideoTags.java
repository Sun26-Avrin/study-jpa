package com.study.structure.domain.first_class_collection.embedded;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.study.structure.domain.first_class_collection.VideoTag;

import lombok.ToString;

@Embeddable
@ToString
public class VideoTags {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "video")
    private List<VideoTag> tags = new ArrayList<>();
}
