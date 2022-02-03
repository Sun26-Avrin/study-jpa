package com.study.structure.domain.pocketmark;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Dto {
    
    public interface IdOnlyRes{
        Long getItemId();
    }

    public interface UrlOnlyRes{
        Long getUrl();
    }


    public static interface ItemOnlyRes{
        Long getItemId();
        String getName();
        Long getParentId();
        Long getUserId();

        default
        String toText(){
            return getItemId()+" "+getName(); 
        }
    }

    public static interface BookmarkOnlyRes{
        String getName(); //ddd 는 안되넹 ㅎ 젠장 
        // String getUrl();

        default
        String toText(){
            return " "+getName(); 
        }
    }
}
