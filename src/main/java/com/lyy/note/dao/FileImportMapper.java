package com.lyy.note.dao;
import org.apache.ibatis.annotations.Mapper;

import com.lyy.note.entity.pojo.FileImport;
import org.springframework.stereotype.Repository;

/**
 * @author lyy
 */
@Mapper
@Repository
public interface FileImportMapper {
	
	/**插入上传的文件信息*/
    int insertSelective(FileImport record);

   
}