package com.atlas.auth.model;

public class JWTRequest {

	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
	private JWTRequest(Builder builder) {
		this.email=builder.email;
		this.password=builder.password;
	}
	
	//Builder Class
	public static class Builder{
			
		private String email;
		private String password;

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}

		public JWTRequest build(){
			return new JWTRequest(this);
		}
			
	}
	
}
