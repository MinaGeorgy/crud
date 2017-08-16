package com.app.Exception;
/**
 * @auther Mina.Georgy
 */
public class SystemException extends Exception {
	/**
	 * serial 1L
	 */
	private static final long serialVersionUID = 1L;
	
	private final String errorCode = "9000";
	
	public String getErrorCode() {
		return errorCode;
	}

	public  String getErrorcode() {
		return errorCode;
	}

	/**
	 * Construct new SystemException Exception and pass the msg as the parameter
	 * @param msg
	 * 
	 */
	public SystemException(String msg){
		super(msg);
	}
	
}
