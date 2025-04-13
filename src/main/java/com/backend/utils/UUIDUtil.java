package com.backend.utils;


import java.util.UUID;

public class UUIDUtil {

    public static String getUUID(String fileName){
        // 1.这个suffix的意思是将文件的属性后缀保存下来方便识别文件属性
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        return UUID.randomUUID().toString().replace("-","")+suffix;
    }
}
