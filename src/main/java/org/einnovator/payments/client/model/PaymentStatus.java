package org.einnovator.payments.client.model;

public enum PaymentStatus {
	SCHEDULED("Scheduled"),
	SUBMITTED("Submitted"),
	PENDING("Pending"),
	FAILED("Failed"), 
	CHARGED("Charged"),
	COMPLETED("Completed"),
	CANCELED("Canceled");	
	
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
	
	public boolean isPaid() {
		switch (this) {
		case COMPLETED: case CHARGED: case CANCELED:
			return true;
		default:
			return false;
		}
	}
}
