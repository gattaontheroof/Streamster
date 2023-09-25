package com.api.model;

public enum UserType {
	ADMIN("A"),
	SUBSCRIBER("S");
	
	private final String userCode;
	
	UserType(String userCode){
		this.userCode = userCode;
	}
	public String getsubscriptionCode() {
		return userCode;
	}

}
