package org.einnovator.payments.client.model;

import org.einnovator.util.model.Address;

public class CardBuilder {

	private String id;
	private CardType cardType;

	@javax.validation.constraints.Pattern(regexp = "\\d{13,16}")
	private String number;

	private Integer expirationMonth;

	private Integer expirationYear;

	private String name;

	private Address address;

	private String cvc;

	private String last4;

	private Currency currency;

	private String brand;


	public CardBuilder() {
	}
	public CardBuilder id(String id) {
		this.id=id;
		return this;
	}
	public CardBuilder cardType(CardType cardType) {
		this.cardType = cardType;
		return this;
	}
	public CardBuilder number(String number) {
		this.number = number;
		return this;
	}
	public CardBuilder expirationMonth(Integer expirationMonth) {
		this.expirationMonth = expirationMonth;
		return this;
	}
	public CardBuilder expirationYear(Integer expirationYear) {
		this.expirationYear = expirationYear;
		return this;
	}
	public CardBuilder name(String name) {
		this.name = name;
		return this;
	}
	public CardBuilder address(Address address) {
		this.address = address;
		return this;
	}
	public CardBuilder cvc(String cvc) {
		this.cvc = cvc;
		return this;
	}
	public CardBuilder last4(String last4) {
		this.last4 = last4;
		return this;
	}
	public CardBuilder currency(Currency currency) {
		this.currency = currency;
		return this;
	}
	public CardBuilder brand(String brand) {
		this.brand = brand;
		return this;
	}


	public Card  build() {
		Card ccard = new Card();
		ccard.setId(id);
		ccard.setCardType(cardType);
		ccard.setAddress(address);
		ccard.setBrand(brand);
		ccard.setCurrency(currency);
		ccard.setCvc(cvc);
		ccard.setExpirationMonth(expirationMonth);
		ccard.setExpirationYear(expirationYear);
		ccard.setLast4(last4);
		ccard.setName(name);
		ccard.setNumber(number);
		return ccard;
	}




}
