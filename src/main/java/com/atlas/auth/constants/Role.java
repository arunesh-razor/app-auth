package com.atlas.auth.constants;

public enum Role {
	
	EndUser("CUSTOMER"),
	Admin("ADMIN"),
	Ops("OPS");

	public final String type;
	
	private Role(String type) {
        this.type = type;
    }
	
}
