package com.lyy.note.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lyy.note.service.GoodsImgService;
import com.lyy.note.service.impl.NoticeServiceImpl;
import com.lyy.note.vo.LayUiResponseDTO;
import com.lyy.note.vo.editorPictureResoonseDTO;

/**
 **author:lyy
 */
@RestController
public class GoodsImgController {
    @Autowired
    private GoodsImgService goodsImgService;
    private static final Logger log =LoggerFactory.getLogger(NoticeServiceImpl.class);
    /**
     **author:lyy
     **date:2019-08-09
                * 上传以base64编码格式图片  返回LayUi 要求封装的参数
     */
    @CrossOrigin(allowCredentials="true") //跨域请求
    @RequestMapping(value = "/addGoodsImg",method = RequestMethod.POST)
    public LayUiResponseDTO<Map<String,String>> addGoodsImg(@RequestParam("file") MultipartFile upfile){
    	if (upfile != null){
	            //上传文件
	            Map<String,String> map = goodsImgService.uploadGoodsImg(upfile);
	            if (map.get("res").equals("success")){
	            	log.info("addGoodsImg-->上传成功");
	            	//上传成功返回图片URL
	                return LayUiResponseDTO.buildSuccess(map);
	            }else{
	            	log.error("addGoodsImg--->上传失败");
	                return LayUiResponseDTO.buildFailure("eror");
	            }
    		}
    	log.error("addGoodsImg--->文件不存在");
		return LayUiResponseDTO.buildFailure("文件不存在");
    }
    /**
     **author:lyy
     **date:2019-08-09
                * 上传以base64编码格式图片  返回editor 要求封装的参数
     */
    @CrossOrigin(allowCredentials="true") //跨域请求
    @RequestMapping(value = "/addGoodsImgEditor",method = RequestMethod.POST)
    public editorPictureResoonseDTO addGoodsImgeEditor(@RequestParam("file") MultipartFile upfile){
    	if (upfile != null){
	            //上传文件
	            Map<String,String> map = goodsImgService.uploadGoodsImg(upfile);
	            if (map.get("res").equals("success")){
	            	//上传成功返回图片URL
	            	List<String> PictureUrls = new ArrayList<String>();
	            	String path = map.get("path");
	            	System.out.println("path:"+path);
	            	PictureUrls.add(path);
	            	editorPictureResoonseDTO uploadSuccess = editorPictureResoonseDTO.uploadSuccess(PictureUrls);
	            	log.info("addGoodsImgEditor--->上传成功");
	                return uploadSuccess;
	            }else{
	            	log.error("addGoodsImgEditor--->上传失败");
	                return editorPictureResoonseDTO.uploadFailure();
	            }
    		}
		return editorPictureResoonseDTO.uploadFailure();
    }
    /**
     *
     * IO流读取图片
     * @param imgUrl 图片url 即图片保存在服务器上的名称
     */
    @CrossOrigin
    @RequestMapping(value = "/showImg",method = RequestMethod.GET)
    public void IoReadImage(String imgUrl,HttpServletResponse response)throws IOException {
        goodsImgService.IoReadImage(imgUrl,response);
    }

    
    
}
