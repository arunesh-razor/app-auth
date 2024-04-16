package com.atlas.auth.models;

import java.util.Date;
import java.util.UUID;

import com.atlas.auth.constants.AccessLevel;
import com.atlas.auth.constants.Role;

public abstract class Entity {
	
	private UUID id;
	private Role role;
	private AccessLevel accessLevel;
	private Date createdDate;
	private Date lastUpdatedDate;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Role geteType() {
		return role;
	}
	public void seteType(Role role) {
		this.role = role;
	}
	public AccessLevel getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
}
