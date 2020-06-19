package com.lyy.note.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyy.note.dao.FileImportMapper;
import com.lyy.note.entity.pojo.FileImport;
import com.lyy.note.service.FileImportService;

@Service
public class FileImportServiceImpl implements FileImportService{
	
	@Autowired
	FileImportMapper fileImportMapper;
	
	@Override
	public int insertSelective(FileImport record) {
		int insertSelective = fileImportMapper.insertSelective(record);
		return insertSelective;
	}

}
