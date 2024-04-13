package com.atlas.auth.constants;

public enum AccessLevel {
	
	ReadOnly(1),
	ReadCreate(2),
	ReadCreateUpdate(3),
	ReadCreateUpdateDelete(4);
	
	public final int access;

	private AccessLevel(int access) {
        this.access = access;
    }
}
