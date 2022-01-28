package com.study.structure.domain.pocketmark;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Dto {
    
    public interface IdOnlyRes{
        Long getId();
    }

    public interface UrlOnlyRes{
        Long getUrl();
    }


    public static interface ItemOnlyRes{
        Long getId();
        Long getItemId();
        String getName();
        Long getParentId();
        Long getUserId();

        default
        String toText(){
            return getId()+" "+getName(); 
        }
    }
}
