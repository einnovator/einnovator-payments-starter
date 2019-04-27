package org.einnovator.payments.client.model;

public class CreditCardBuilder {

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


	public CreditCardBuilder() {
	}
	public CreditCardBuilder id(String id) {
		this.id=id;
		return this;
	}
	public CreditCardBuilder cardType(CardType cardType) {
		this.cardType = cardType;
		return this;
	}
	public CreditCardBuilder number(String number) {
		this.number = number;
		return this;
	}
	public CreditCardBuilder expirationMonth(Integer expirationMonth) {
		this.expirationMonth = expirationMonth;
		return this;
	}
	public CreditCardBuilder expirationYear(Integer expirationYear) {
		this.expirationYear = expirationYear;
		return this;
	}
	public CreditCardBuilder name(String name) {
		this.name = name;
		return this;
	}
	public CreditCardBuilder address(Address address) {
		this.address = address;
		return this;
	}
	public CreditCardBuilder cvc(String cvc) {
		this.cvc = cvc;
		return this;
	}
	public CreditCardBuilder last4(String last4) {
		this.last4 = last4;
		return this;
	}
	public CreditCardBuilder currency(Currency currency) {
		this.currency = currency;
		return this;
	}
	public CreditCardBuilder brand(String brand) {
		this.brand = brand;
		return this;
	}


	public CreditCard  build() {
		CreditCard ccard = new CreditCard();
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
