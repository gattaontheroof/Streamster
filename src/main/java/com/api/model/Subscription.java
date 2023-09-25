package com.api.model;

public enum Subscription {
BASIC("B"),
PREMIUM("P"),
ADMIN("A");

	
	private final String subscriptionCode;
	
	Subscription(String subscriptionCode){
		this.subscriptionCode = subscriptionCode;
	}
	public String getsubscriptionCode() {
		return subscriptionCode;
	}


}
