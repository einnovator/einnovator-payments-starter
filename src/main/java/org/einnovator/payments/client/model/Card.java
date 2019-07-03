package org.einnovator.payments.client.model;

import org.einnovator.util.model.Address;
import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Card extends EntityBase {
		
	private CardType cardType;

	private String number;

	private Integer expirationMonth;

	private Integer expirationYear;

	private String name;

	private Address address;

	private String cvc;
 
	private String last4;

	private Currency currency;

	private String brand;
	
	private Boolean _default;

	public Card() {
		
	}

	
	/**
	 * Get the value of property {@code cardType}.
	 *
	 * @return the cardType
	 */
	public CardType getCardType() {
		return cardType;
	}

	/**
	 * Set the value of property {@code cardType}.
	 *
	 * @param cardType the cardType to set
	 */
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	/**
	 * Get the value of property {@code number}.
	 *
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Set the value of property {@code number}.
	 *
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Get the value of property {@code expirationMonth}.
	 *
	 * @return the expirationMonth
	 */
	public Integer getExpirationMonth() {
		return expirationMonth;
	}

	/**
	 * Set the value of property {@code expirationMonth}.
	 *
	 * @param expirationMonth the expirationMonth to set
	 */
	public void setExpirationMonth(Integer expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	/**
	 * Get the value of property {@code expirationYear}.
	 *
	 * @return the expirationYear
	 */
	public Integer getExpirationYear() {
		return expirationYear;
	}

	/**
	 * Set the value of property {@code expirationYear}.
	 *
	 * @param expirationYear the expirationYear to set
	 */
	public void setExpirationYear(Integer expirationYear) {
		this.expirationYear = expirationYear;
	}

	/**
	 * Get the value of property {@code name}.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the value of property {@code address}.
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Set the value of property {@code address}.
	 *
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Get the value of property {@code cvc}.
	 *
	 * @return the cvc
	 */
	public String getCvc() {
		return cvc;
	}

	/**
	 * Set the value of property {@code cvc}.
	 *
	 * @param cvc the cvc to set
	 */
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	/**
	 * Get the value of property {@code last4}.
	 *
	 * @return the last4
	 */
	public String getLast4() {
		return last4;
	}

	/**
	 * Set the value of property {@code last4}.
	 *
	 * @param last4 the last4 to set
	 */
	public void setLast4(String last4) {
		this.last4 = last4;
	}

	/**
	 * Get the value of property {@code currency}.
	 *
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * Set the value of property {@code currency}.
	 *
	 * @param currency the currency to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	/**
	 * Get the value of property {@code brand}.
	 *
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Set the value of property {@code brand}.
	 *
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Get the value of property {@code Default}.
	 *
	 * @return the _default
	 */
	public Boolean getDefault() {
		return _default;
	}

	/**
	 * Set the value of property {@code Default}.
	 *
	 * @param _default the _default to set
	 */
	public void setDefault(Boolean _default) {
		this._default = _default;
	}
	

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("cardType", cardType)
				.append("number", number)
				.append("expirationMonth", expirationMonth)
				.append("expirationYear", expirationYear)
				.append("_default", _default)
				.append("name", name)
				.append("address", address)
				.append("cvc", cvc)
				.append("currency", currency)
				.append("last4", last4)
				;
	}

	
}
