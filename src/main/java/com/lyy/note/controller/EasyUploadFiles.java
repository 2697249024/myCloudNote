package com.lyy.note.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class EasyUploadFiles {
	
	
	//生成文件路径
	public static String getDiyUploadFilePath(File flie) {
		
		String uuid = UUID.randomUUID().toString().replaceAll("-","");
		String imagePath = "E:\\fileadress\\picture"+File.separator+uuid+"jpg";
		System.out.println("imagePath"+imagePath);
		return imagePath;
	}
	
	/**生成新文件路径和文件名*/
	public static String getNewFilePath() {
		String FilePath = "ImageServerPath"+"imgs"+File.separator;
		return FilePath;
	}
	
	
}
