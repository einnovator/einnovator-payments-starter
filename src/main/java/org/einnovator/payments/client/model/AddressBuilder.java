package org.einnovator.payments.client.model;


public class AddressBuilder {
	
	private String country;
	
	private String countryCode2;
	
	private String countryCode3;
	
	private String postalCode;
	
	private String city;
	
	private String line1;

	private String line2;

	private String state;
	
	private String town;

	public AddressBuilder() {
	}
	
	public AddressBuilder country(String country) {
		this.country = country;
		return this;
	}

	public AddressBuilder postalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public AddressBuilder city(String city) {
		this.city = city;
		return this;
	}
	
	public AddressBuilder line1(String line1) {
		this.line1 = line1;
		return this;
	}

	public AddressBuilder line2(String line2) {
		this.line2 = line2;
		return this;
	}
	
	public AddressBuilder state(String state) {
		this.state = state;
		return this;
	}

	public AddressBuilder town(String town) {
		this.town = town;
		return this;
	}

	public AddressBuilder countryCode2(String countryCode2) {
		this.countryCode2 = countryCode2;
		return this;
	}

	public AddressBuilder countryCode3(String countryCode3) {
		this.countryCode3 = countryCode3;
		return this;
	}

	
	public Address build() {
		Address address = new Address();
		address.setCountry(country);
		address.setCountryCode2(countryCode2);
		address.setCountryCode3(countryCode3);
		address.setCity(city);
		address.setState(state);
		address.setTown(town);
		address.setLine1(line1);
		address.setLine2(line2);
		address.setPostalCode(postalCode);
		return address;
	}

}
