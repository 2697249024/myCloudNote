package com.lyy.note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lyy.note.service.FileImportService;
import com.lyy.note.vo.ResponseDTO;

@Controller
public class FileImportController {
	
	@Autowired
	FileImportService fileImportService;
	
	//TODO  saveFileInfo
	public ResponseDTO<String> saveFileInfo(){
		
		return null;
	}
	
}
