package com.technostorms.bank.utill;

public class CustomErrorType {
	
	private String message;
	private Object data;
	
	public String getMessage() {
		return message;
	}
	public CustomErrorType(String message){
		this.message = message;
	}

	public CustomErrorType(String message,Object dataObject){
		this.data = dataObject;
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
