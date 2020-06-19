package com.lyy.note.service;

import com.lyy.note.entity.pojo.FileImport;

public interface FileImportService {
	
	/**插入上传的文件信息*/
    int insertSelective(FileImport record);
}
