package org.einnovator.payments.client.model;

public class CreditCard {
	
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
	
	public CreditCard() {}

	public CreditCard(CardType cardType, String number, Integer expirationMonth, Integer expirationYear, String name,
			Address address, String cvc, String last4, Currency currency, String brand) {
		this.cardType = cardType;
		this.number = number;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
		this.name = name;
		this.address = address;
		this.cvc = cvc;
		this.last4 = last4;
		this.currency = currency;
		this.brand = brand;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(Integer expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public Integer getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(Integer expirationYear) {
		this.expirationYear = expirationYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public String getLast4() {
		return last4;
	}

	public void setLast4(String last4) {
		this.last4 = last4;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	

	@Override
	public String toString() {
		return "CreditCard [cardType=" + cardType + ", number=" + number + ", expirationMonth=" + expirationMonth
				+ ", expirationYear=" + expirationYear + ", name=" + name + ", address=" + address + ", cvc=" + cvc
				+ ", last4=" + last4 + ", currency=" + currency + ", brand=" + brand + "]";
	}
	
	
	
	
}
