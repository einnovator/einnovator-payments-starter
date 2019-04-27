package org.einnovator.payments.client.model;

public enum AccountType {
	INDIVIDUAL("Individual"),
	
	ORGANIZATION("Organization");
	 
	private final String displayName;

	AccountType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
