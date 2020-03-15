package org.einnovator.payments.client.model;

/**
 * Enum for a {@code Payment} type.
 *
 * @see Payment
 * @author support@einnovator.org
 *
 */
public enum PaymentType {

	SOURCE("Source"),
	
	PLAID("Plaid"),
	
	STRIPE("Stripe"),
	
	CARD("Card"),

	BANK_TRANSFER("Bank Transfer"),
	
	BANK_CHECK("Bank Check");
	
	
	private final String displayName;

	PaymentType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
	
	public String getDisplayValue() {
		return displayName;
	}

	public boolean isCreditCard() {
		return this.equals(CARD);
	}
	
	
}
