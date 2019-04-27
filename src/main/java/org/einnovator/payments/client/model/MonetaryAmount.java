package org.einnovator.payments.client.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MonetaryAmount implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal value;

	private Currency currency;

	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code MonetaryAmount}.
	 *
	 */
	public MonetaryAmount() {
	}
	
	/**
	 * Create instance of {@code MonetaryAmount}.
	 *
	 * @param value
	 * @param currency
	 */
	public MonetaryAmount(BigDecimal value, Currency currency) {
		super();
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Create instance of {@code MonetaryAmount}.
	 *
	 * @param value
	 * @param currency
	 */
	public MonetaryAmount(double value, Currency currency) {
		this(new BigDecimal(value), currency);
	}
	//
	// Getters an Setters
	//
	

	/**
	 * Get the value of property {@code value}.
	 *
	 * @return the {@code value}
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * Set the value of property {@code value}.
	 *
	 * @param value the {@code value} to set
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	
	
	/**
	 * Get the value of property {@code currency}.
	 *
	 * @return the {@code currency}
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * Set the value of property {@code currency}.
	 *
	 * @param currency the {@code currency} to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;			
		}
		if (getClass() != obj.getClass()) {
			return false;			
		}
		MonetaryAmount other = (MonetaryAmount) obj;
		if (currency != other.currency) {
			return false;			
		}
		if (value == null) {
			if (other.value != null) {
				return false;				
			}
		} else if (!value.equals(other.value)) {
			return false;			
		}
		return true;
	}
	
	public double toDouble() {
		return Double.parseDouble(value.toString());
	}


	@Override
	public String toString() {
		return "MonetaryAmount [" + (value != null ? "value=" + value + ", " : "")
				+ (currency != null ? "currency=" + currency : "") + "]";
	}

}
