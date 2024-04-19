package com.atlas.auth.models;

import java.io.Serializable;

public class UserResponse implements Serializable{
	
	private String message;
	private String data;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}