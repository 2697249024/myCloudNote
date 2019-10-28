package com.lyy.note.vo;

import org.springframework.util.StringUtils;

/**
 *  接口返回格式
 * @author liuyueyang
 *
 */
public class LayUiResponseDTO<D> {
	public static final int STATUS_SUCCESS = 0;
	public static final int STATUS_FAILURE = -1;
	private Integer code;
	
	private String msg;
	
	private D data;

	

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
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
	public static <D> LayUiResponseDTO<D> buildSuccess(D d) {
		LayUiResponseDTO<D> response = new LayUiResponseDTO<>();
		response.code = STATUS_SUCCESS;
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
	public static <D> LayUiResponseDTO<D> buildSuccessMsg(D d,String msg) {
		LayUiResponseDTO<D> response = new LayUiResponseDTO<>();
		response.code = STATUS_SUCCESS;
		response.data = d;
		if(StringUtils.isEmpty(msg)) {
			response.msg = "成功";
		}else {
			response.msg = msg;
		}
		return response;
	}
	
	public static <D> LayUiResponseDTO<D> buildFailure(String msg) {
		LayUiResponseDTO<D> response = new LayUiResponseDTO<>();
		response.code = STATUS_FAILURE;
		response.msg = msg;
		return response;
	}
	
}
