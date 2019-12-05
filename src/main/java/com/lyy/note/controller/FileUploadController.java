package com.lyy.note.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lyy.note.service.impl.NoticeServiceImpl;
import com.lyy.note.vo.LayUiResponseDTO;
import com.lyy.note.vo.editorPictureResoonseDTO;

/**
 * 文件上传
 * @author 80004198
 *:C:\Users\80004198\AppData\Local\Temp\tomcat-docbase.9128568245686541399.8080\WEB-INF\classes\static\resource\Koala.jpg
 */
@Controller
public class FileUploadController {
	private static final Logger log =LoggerFactory.getLogger(NoticeServiceImpl.class);
	/***
	 * 获取 图片服务器地址
	 * @param flie
	 * @return
	 */
	
	@CrossOrigin //跨域请求
	@RequestMapping(value="/multipleFileUpload" ,method=RequestMethod.POST)
	@ResponseBody
	public LayUiResponseDTO<String> multipleFileUpload(@RequestParam("upfile")MultipartFile[] upfiles,HttpServletRequest request,HttpServletResponse response){
		//String ImageServer = ImageServerPath;
		response.setHeader("Access-Control-Allow-Origin","*");
		for(int i=0;i<upfiles.length;i++){
			MultipartFile uploadfile=upfiles[i];
			if(uploadfile.isEmpty()){
				//上传失败
				LayUiResponseDTO.buildFailure("错误");
			}
			//获取上传的文件名
			String OldFileName=uploadfile.getOriginalFilename();
			//生成文件路径
			//String FilePath = EasyUploadFiles.getNewFilePath();
			 //定义上传文件路径、文件名、文件格式
			// 以系统时间作为上传文件名称，设置上传文件的完整路径
			//保存文件路径
			//String path = "E:/fileadress/picture/";
			//String FilePath =path+OldFileName;
			// Linux系统
			//TODO 添加路径区分
			String FilePath = "/cloudResoure/picture/jpg/"+OldFileName;
			log.info("上传路径："+FilePath);
			System.out.println("FilePath:"+FilePath);
			//新的文件 
			File file = new File(FilePath); 
				try {
					uploadfile.transferTo(file);
				} catch (IllegalStateException | IOException e) {
					log.error("路径错误—————————");
					e.printStackTrace();
				}
		}
		return LayUiResponseDTO.buildSuccess("");
}
	
	//editor 图片上传
	
	@CrossOrigin //跨域
	@RequestMapping(value="/editorPictureUpload" ,method=RequestMethod.POST)
	@ResponseBody
	public editorPictureResoonseDTO editorPictureUpload(@RequestParam("upfiles")MultipartFile[] upfiles,HttpServletRequest request){
		List<String> PictureUrls = new ArrayList<>();
		for(int i=0;i<upfiles.length;i++){
			MultipartFile uploadfile=upfiles[i];
			//获取上传的文件名
			String OldFileName=uploadfile.getOriginalFilename();
			//生成文件路径
			String FilePath = EasyUploadFiles.getNewFilePath();
			System.out.println("路径："+FilePath+OldFileName);
			//新的文件 
			File file = new File(FilePath+OldFileName); 
			if(uploadfile.isEmpty()){
				//上传失败
				editorPictureResoonseDTO.uploadFailure();
			}
			try {
				//上传到文件服务器
				uploadfile.transferTo(file);
				//将图片路径存放到集合中
				PictureUrls.add(FilePath);
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			System.out.println("上传成功");
		}
		return editorPictureResoonseDTO.uploadSuccess(PictureUrls);
	}
}	
	
	
	

