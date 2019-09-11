package com.example.demo.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public interface GoodsImgService {
    /**
     **author:weijiakun
     * 上传商品图片
     */
    Map<String,String> uploadGoodsImg(MultipartFile file);
    void IoReadImage(String imgUrl,HttpServletResponse response);
}

