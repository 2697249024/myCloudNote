package com.example.demo.vo;

import java.util.ArrayList;
import java.util.List;

/**
 *  wangEditor3 标准图片返回接口
 *  注意返回参数必须为字符串数组  故对传参做了处理
 * @author 80004198
 *
 */
public class editorPictureResoonseDTO {
	
	public static final int SUCCESS_NO = 0;
	public static final int FAILURE_NO =-1;
	
	/**即错误代码，0 表示没有错误*/
	private Integer errno;
	/**data 是一个数组，返回若干图片的线上地址*/
	private String[] data;
	
	
	public Integer getErrno() {
		return errno;
	}
	public void setErrno(Integer errno) {
		this.errno = errno;
	}
	public String[] getData() {
		return data;
	}
	public void setData(String[] data) {
		this.data = data;
	}
	
	/**提示成功信息*/
	public static editorPictureResoonseDTO uploadSuccess(List<String> PictureUrls) {
		editorPictureResoonseDTO response = new editorPictureResoonseDTO();
		response.errno =SUCCESS_NO;
		//集合转换成数组
		String[] dataUrls =new String[PictureUrls.size()];
		PictureUrls.toArray(dataUrls);
		response.data =dataUrls;
		return response;
	}
	/**提示失败信息*/
	public static editorPictureResoonseDTO uploadFailure() {
		editorPictureResoonseDTO response = new editorPictureResoonseDTO();
		response.errno =FAILURE_NO;
		return response;
	}
	
	
	
}
