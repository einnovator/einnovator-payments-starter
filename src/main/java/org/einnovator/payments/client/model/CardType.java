package org.einnovator.payments.client.model;

public enum CardType {

	VISA("Visa"), 
	VISA_CREDIT("Visa"), 
	VISA_DEBIT("Visa"),
	MASTERCARD_CREDIT("MasterCard"),
	MASTERCARD_DEBIT("MasterCard"), 
	MASTERCARD("MasterCard"), 
	AMEX("Amex"), 
	JCB("JCB"), 
	DISCOVER("Discover"), 
	DINERSCLUB("DinnerClub");

	private String brand;

	private CardType(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
