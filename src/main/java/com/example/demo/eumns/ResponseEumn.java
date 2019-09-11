package com.example.demo.eumns;

public enum ResponseEumn {
	/**成功*/
	SUCCESS(0, "成功"),
	
	/**失败*/
	ERROE(-1, "失败");
	private Integer code;
	
	private String desc;


	public Integer getCode() {
		return code;
	}


	public String getDesc() {
		return desc;
	}


	private ResponseEumn(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	
}
