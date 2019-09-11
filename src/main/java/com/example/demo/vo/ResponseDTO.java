package com.example.demo.vo;

import org.springframework.util.StringUtils;

/**
 *  接口返回格式
 * @author 80004198
 *
 */
public class ResponseDTO<D> {
	public static final int STATUS_SUCCESS = 1;
	public static final int STATUS_FAILURE = -1;
	private Integer status;
	
	private String msg;
	
	private D data;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public D getData() {
		return data;
	}

	public void setData(D data) {
		this.data = data;
	}
	public static <D> ResponseDTO<D> buildSuccess(D d) {
		ResponseDTO<D> response = new ResponseDTO<>();
		response.status = STATUS_SUCCESS;
		response.data = d;
		return response;
	}
	/**提示成功信息/
	 * 
	 * @param <D>
	 * @param d D
	 * @param msg null或空时默认 成功 可自定义内容
	 * @return
	 */
	public static <D> ResponseDTO<D> buildSuccessMsg(D d,String msg) {
		ResponseDTO<D> response = new ResponseDTO<>();
		response.status = STATUS_SUCCESS;
		response.data = d;
		if(StringUtils.isEmpty(msg)) {
			response.msg = "成功";
		}else {
			response.msg = msg;
		}
		return response;
	}
	
	public static <D> ResponseDTO<D> buildFailure(String msg) {
		ResponseDTO<D> response = new ResponseDTO<>();
		response.status = STATUS_FAILURE;
		response.msg = msg;
		return response;
	}
	
}
