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
		
	public Tax() {
		
	}
	
	public boolean isFeeTax() {
		return feeTax;
	}

	public void setFeeTax(boolean feeTax) {
		this.feeTax = feeTax;
	}

	public Boolean getSellerFeeTax() {
		return sellerFeeTax;
	}

	public void setSellerFeeTax(Boolean sellerFeeTax) {
		this.sellerFeeTax = sellerFeeTax;
	}

	public boolean isBuyerTax() {
		return buyerTax;
	}

	public void setBuyerTax(boolean buyerTax) {
		this.buyerTax = buyerTax;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public BigDecimal getPercentage() {
		return percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	public String getCountryCode2() {
		return countryCode2;
	}

	public void setCountryCode2(String countryCode2) {
		this.countryCode2 = countryCode2;
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
