package com.atlas.auth.entities;

import java.util.Collection;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.atlas.auth.constants.AccessLevel;
import com.atlas.auth.constants.Role;

@Entity
@Table(name = "user")
public class User extends BaseEntity implements UserDetails {
	
	private String firstName;
	private String lastName;
	@Column(unique=true)
	private String userName;
	@Column(unique=true)
	private String emailId;
	private String passwordHash;
	private String phoneNumber;
	@Column(columnDefinition = "boolean default false")
	private boolean isVerified;
	@Column(columnDefinition = "boolean default false")
	private boolean is2StepVerificationSet;
	@Column(columnDefinition = "boolean default false")
	private boolean isPhoneVerified;
	private String jwtToken;
	@Column(length = 32, columnDefinition = "varchar(32) default 'EndUser'")
	@Enumerated(value = EnumType.STRING)
	private Role role = Role.EndUser;
	@Column(length = 32, columnDefinition = "varchar(32) default 'ReadOnly'")
	@Enumerated(value = EnumType.STRING)
	private AccessLevel accessLevel = AccessLevel.ReadOnly;
	
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
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		return this.passwordHash;
	}
	@Override
	public String getUsername() {
		return this.userName;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}

	
}
