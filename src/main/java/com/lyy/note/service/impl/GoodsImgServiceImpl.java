package com.lyy.note.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lyy.note.service.GoodsImgService;
import com.lyy.note.util.GetServerRealPathUnit;
import com.lyy.note.util.SaveImgUnit;

/**
 **author:weijiakun
 */
@Service(value = "goodsImgService")
public class GoodsImgServiceImpl implements GoodsImgService {
    private static final Logger log = LoggerFactory.getLogger(GoodsImgServiceImpl.class); 
	
	//注入配置文件application.yml中设置的图片存放子目录名
    @Value("${web.uploadImgPath}")
    private String GOODS_IMG_PATH;
    
    /**
     **author:weijiakun
     * 上传以base64编码格式图片
     */
    @Override
    public Map<String,String> uploadGoodsImg(MultipartFile file){
        if (file != null){
            //上传文件
            SaveImgUnit saveImgUnit = new SaveImgUnit();
            Map<String,String> map = saveImgUnit.saveMultFile(file,GOODS_IMG_PATH);
            return map;
        }else {
            Map<String,String> map = new HashMap<>();
            map.put("res","error");
            return map;
        }
    }

    /**
     *author：weijiakun
     * IO流读取图片
     * @param imgUrl 图片url，即图片保存在服务器上的名称
     */
    @Override
    public void IoReadImage(String imgUrl, HttpServletResponse response) {
        ServletOutputStream out = null;
        FileInputStream ips = null;
        String upload = null;
        
        //获取商品图片目录
        upload = GetServerRealPathUnit.getPath(GOODS_IMG_PATH);
        
        try {
            //获取图片存放路径
            String imgPath = upload + "/" + imgUrl;
            ips = new FileInputStream(new File(imgPath));
            String type = imgUrl.substring(imgUrl.indexOf(".")+1);
            if (type.equals("png")){
                response.setContentType("image/png");
            }
            if (type.equals("jpeg")){
                response.setContentType("image/jpeg");
            }
            if (type.equals("jpg")){
                response.setContentType("image/jpg");
            }
            if (type.equals("gif")){
            	response.setContentType("image/gif");
            }
            if (type.equals("zip")){
            	response.setContentType("image/zip");
            }
            if (type.equals("txt")){
            	response.setContentType("image/txt");
            }
            if (type.equals("doc")){
            	response.setContentType("image/doc");
            }
            if (type.equals("exe")){
            	response.setContentType("image/exe");
            }

            out = response.getOutputStream();
            //读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = ips.read(buffer)) != -1){
                out.write(buffer,0,len);
            }
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
				out.close();
				ips.close();
			} catch (IOException e) {
				log.error("保存在服务器出错",e);
				//e.printStackTrace();
			}
            
        }
    }

}
