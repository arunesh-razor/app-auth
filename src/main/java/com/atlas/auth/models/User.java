package com.atlas.auth.models;

public class User extends Entity {
	
	private String firstName;
	private String lastName;
	private String userName;
	private String emailId;
	private String passwordHash;
	private String phoneNumber;
	private boolean isVerified;
	private boolean is2StepVerificationSet;
	private boolean isPhoneVerified;
	private String jwtToken;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public boolean is2StepVerificationSet() {
		return is2StepVerificationSet;
	}
	public void set2StepVerificationSet(boolean is2StepVerificationSet) {
		this.is2StepVerificationSet = is2StepVerificationSet;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public boolean isPhoneVerified() {
		return isPhoneVerified;
	}
	public void setPhoneVerified(boolean isPhoneVerified) {
		this.isPhoneVerified = isPhoneVerified;
	}
	
	
}
