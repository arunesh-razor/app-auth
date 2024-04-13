package com.atlas.auth.model;

public class JWTResponse {
	
	private String jwtToken;
	private String userName;
	
	public String getJwtToken() {
		return jwtToken;
	}
	public String getUserName() {
		return userName;
	}
	
	private JWTResponse(Builder builder) {
		this.jwtToken=builder.jwtToken;
		this.userName=builder.userName;
	}
	
	//Builder Class
	public static class Builder{
				
		private String jwtToken;
		private String userName;

		public Builder setJwtToken(String jwtToken) {
			this.jwtToken = jwtToken;
			return this;
		}


		public Builder setUserName(String userName) {
			this.userName = userName;
			return this;
		}

		public JWTResponse build(){
			return new JWTResponse(this);
		}
				
	}

}
