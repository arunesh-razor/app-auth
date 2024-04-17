package com.atlas.auth.entities;

import com.atlas.auth.constants.AccessLevel;
import com.atlas.auth.constants.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseEntity {
	
	private String firstName;
	private String LastName;
	private String userName;
	private String emailId;
	private String passwordHash;
	private String phoneNumber;
	private boolean isVerified;
	private boolean is2StepVerificationSet;
	private boolean isPhoneVerified;
	private String jwtToken;
	private Role role;
	private AccessLevel accessLevel;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public boolean isIs2StepVerificationSet() {
		return is2StepVerificationSet;
	}
	public void setIs2StepVerificationSet(boolean is2StepVerificationSet) {
		this.is2StepVerificationSet = is2StepVerificationSet;
	}
	public boolean isPhoneVerified() {
		return isPhoneVerified;
	}
	public void setPhoneVerified(boolean isPhoneVerified) {
		this.isPhoneVerified = isPhoneVerified;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public AccessLevel getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	
}
