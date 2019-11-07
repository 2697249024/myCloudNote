package com.lyy.note.util;

import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;

/*
 **author:weijiakun
 *获取目录工具类
 */
public class GetServerRealPathUnit {

    public static String  getPath(String subdirectory){
        //获取跟目录---与jar包同级目录的upload目录下指定的子目录subdirectory
        File upload = null;
        try {
            //本地测试时获取到的是"工程目录D:\work\SpringToolSuiteWorkSpace\myCloud\target\classes 添加配置目录 /cloudResoure/picture
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists()) path = new File("");
            upload = new File(path.getAbsolutePath(),subdirectory);
            if(!upload.exists()) upload.mkdirs();//如果不存在则创建目录
            String realPath = upload + "/";
            return realPath;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("获取服务器路径发生错误！");
        }
    }
}

