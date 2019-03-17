package com.example.myboot.common;
/**
 * 判空
 */

import java.util.List;

public class Utils {

    public static boolean isEmpty(List<?> list){
        if(list!=null && list.size()>0){
            return true;
        }
        return false;
    }

}
