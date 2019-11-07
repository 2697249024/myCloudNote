package com.lyy.note.exception;
/**
 * 自定义异常类
 */
public class ActualException extends Exception{

	private static final long serialVersionUID = -1744147062631341527L;

	public ActualException() {
		super();
	}

	public ActualException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ActualException(String message, Throwable cause) {
		super(message, cause);
	}

	public ActualException(String message) {
		super(message);
	}

	public ActualException(Throwable cause) {
		super(cause);
	}

}
