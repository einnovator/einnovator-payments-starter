package org.einnovator.payments.client.model;

public enum PaymentStatus {
	PENDING("Pending"),
	
	SUBMITTED("Submitted"),
	
	COMPLETED("Completed"),
	
	CANCELED("Canceled"),
	
	CANCELED_BY_SITE("Canceled by Site"),
	
	FAILED("Failed"), 
	
	CHARGED("Charged");
	
	private final String displayName;

	PaymentStatus(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public boolean containsAny(PaymentStatus... status) {
		for (PaymentStatus s : status) {
			if (this == s) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isSuccess() {
		switch (this) {
		case COMPLETED: case CANCELED: case CANCELED_BY_SITE:
			return false;
		default:
			return true;
		}
	}
}
