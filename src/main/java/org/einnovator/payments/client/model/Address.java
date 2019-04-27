package org.einnovator.payments.client.model;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
	
	private String country;
	
	private String countryCode2;
	
	private String countryCode3;
	
	private String postalCode;
	
	private String city;
	
	private String line1;

	private String line2;

	private String state;
	
	private String town;

	public Address() {
	}
	
	public Address(String country, String postalCode, String city, String line1, String line2, String state, String town) {
		this.country = country;
		this.postalCode = postalCode;
		this.city = city;
		this.line1 = line1;
		this.line2 = line2;
		this.state = state;
		this.town = town;
	}

	public Address(String country, String state) {
		this.country = country;
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCountryCode2() {
		return countryCode2;
	}

	public void setCountryCode2(String countryCode2) {
		this.countryCode2 = countryCode2;
	}

	public String getCountryCode3() {
		return countryCode3;
	}

	public void setCountryCode3(String countryCode3) {
		this.countryCode3 = countryCode3;
	}

	@Override
	public String toString() {
		return "Address [" + (country != null ? "country=" + country + ", " : "")
				+ (countryCode2 != null ? "countryCode2=" + countryCode2 + ", " : "")
				+ (countryCode3 != null ? "countryCode3=" + countryCode3 + ", " : "")
				+ (postalCode != null ? "postalCode=" + postalCode + ", " : "")
				+ (city != null ? "city=" + city + ", " : "") 
				+ (town != null ? "town=" + town + ", " : "") 
				+ (line1 != null ? "line1=" + line1 + ", " : "")
				+ (line2 != null ? "line2=" + line2 + ", " : "") 
				+ (state != null ? "state=" + state : "") + "]";
	}

	@JsonIgnore
	public boolean isEmpty() {
		return !StringUtils.hasText(country) && !StringUtils.hasText(postalCode) && 
				!StringUtils.hasText(city) && !StringUtils.hasText(line1) && 
				!StringUtils.hasText(line2) && !StringUtils.hasText(state) &&
				!StringUtils.hasText(postalCode) &&
				!StringUtils.hasText(countryCode2) && !StringUtils.hasText(countryCode3);
	}
	

}
