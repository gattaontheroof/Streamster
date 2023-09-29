package com.api.model;

public enum Certificate {
	VALUE_1("U"), 
	VALUE_2("PG"),
	VALUE_3("12"),
	VALUE_4("12A"),
	VALUE_5("15"),
	VALUE_6("18");

	private final String certificateCode;

	Certificate(String certificateCode) {
		this.certificateCode = certificateCode;
	}

	public String getCertificateCode() {
		return certificateCode;
	}

}