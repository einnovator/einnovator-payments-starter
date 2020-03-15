package org.einnovator.payments.client.model;

import java.math.BigDecimal;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tax extends EntityBase {

	private String name;

	private BigDecimal amount;

	private Currency currency;

	private String comment;
	
	private boolean feeTax = true;
	
	private Boolean sellerFeeTax; // seller pays fee tax
	
	private BigDecimal percentage;
	
	private boolean buyerTax;
	
	private String countryCode2;
		
	/**
	 * Create instance of {@code Tax}.
	 *
	 */
	public Tax() {
		
	}
	

	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the value of property name
	 * @return this {@code Tax}
	 */
	public Tax withName(String name) {
		this.name = name;
		return this;
	}


	/**
	 * Set the value of property {@code amount}.
	 *
	 * @param amount the value of property amount
	 * @return this {@code Tax}
	 */
	public Tax withAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}


	/**
	 * Set the value of property {@code currency}.
	 *
	 * @param currency the value of property currency
	 * @return this {@code Tax}
	 */
	public Tax withCurrency(Currency currency) {
		this.currency = currency;
		return this;
	}


	/**
	 * Set the value of property {@code comment}.
	 *
	 * @param comment the value of property comment
	 * @return this {@code Tax}
	 */
	public Tax withComment(String comment) {
		this.comment = comment;
		return this;
	}


	/**
	 * Set the value of property {@code feeTax}.
	 *
	 * @param feeTax the value of property feeTax
	 * @return this {@code Tax}
	 */
	public Tax withFeeTax(boolean feeTax) {
		this.feeTax = feeTax;
		return this;
	}


	/**
	 * Set the value of property {@code sellerFeeTax}.
	 *
	 * @param sellerFeeTax the value of property sellerFeeTax
	 * @return this {@code Tax}
	 */
	public Tax withSellerFeeTax(Boolean sellerFeeTax) {
		this.sellerFeeTax = sellerFeeTax;
		return this;
	}


	/**
	 * Set the value of property {@code percentage}.
	 *
	 * @param percentage the value of property percentage
	 * @return this {@code Tax}
	 */
	public Tax withPercentage(BigDecimal percentage) {
		this.percentage = percentage;
		return this;
	}


	/**
	 * Set the value of property {@code buyerTax}.
	 *
	 * @param buyerTax the value of property buyerTax
	 * @return this {@code Tax}
	 */
	public Tax withBuyerTax(boolean buyerTax) {
		this.buyerTax = buyerTax;
		return this;
	}


	/**
	 * Set the value of property {@code countryCode2}.
	 *
	 * @param countryCode2 the value of property countryCode2
	 * @return this {@code Tax}
	 */
	public Tax withCountryCode2(String countryCode2) {
		this.countryCode2 = countryCode2;
		return this;
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("name", name)
				.append("amount", amount)
				.append("currency", currency)
				.append("percentage", percentage)
				.append("feeTax", feeTax)
				.append("sellerFeeTax", sellerFeeTax)
				.append("buyerTax", buyerTax)
				.append("countryCode2", countryCode2)
				.append("comment", comment)
				;
	}

	
}
