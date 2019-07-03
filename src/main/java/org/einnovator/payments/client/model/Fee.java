package org.einnovator.payments.client.model;

import java.math.BigDecimal;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Fee extends EntityBase {


	private Boolean visibleToBuyer = false;

	private Boolean visibleToSeller = false;
	
	private BigDecimal amountToBuyer;
	
	private BigDecimal amountToSeller;
	
	private String beneficiary;

	private PaymentStatus status;
	
	private Currency currency;
	
	private String name;

	private String errorMessage;
		
	private String description;
	

	public Fee() {
	}
	
	public Fee(BigDecimal amountToBuyer, BigDecimal amountToSeller) {
		this.amountToBuyer = amountToBuyer;
		this.amountToSeller = amountToSeller;
	}
	
	
	/**
	 * Get the value of property {@code visibleToBuyer}.
	 *
	 * @return the visibleToBuyer
	 */
	public Boolean getVisibleToBuyer() {
		return visibleToBuyer;
	}

	/**
	 * Set the value of property {@code visibleToBuyer}.
	 *
	 * @param visibleToBuyer the visibleToBuyer to set
	 */
	public void setVisibleToBuyer(Boolean visibleToBuyer) {
		this.visibleToBuyer = visibleToBuyer;
	}

	/**
	 * Get the value of property {@code visibleToSeller}.
	 *
	 * @return the visibleToSeller
	 */
	public Boolean getVisibleToSeller() {
		return visibleToSeller;
	}

	/**
	 * Set the value of property {@code visibleToSeller}.
	 *
	 * @param visibleToSeller the visibleToSeller to set
	 */
	public void setVisibleToSeller(Boolean visibleToSeller) {
		this.visibleToSeller = visibleToSeller;
	}

	/**
	 * Get the value of property {@code amountToBuyer}.
	 *
	 * @return the amountToBuyer
	 */
	public BigDecimal getAmountToBuyer() {
		return amountToBuyer;
	}

	/**
	 * Set the value of property {@code amountToBuyer}.
	 *
	 * @param amountToBuyer the amountToBuyer to set
	 */
	public void setAmountToBuyer(BigDecimal amountToBuyer) {
		this.amountToBuyer = amountToBuyer;
	}

	/**
	 * Get the value of property {@code amountToSeller}.
	 *
	 * @return the amountToSeller
	 */
	public BigDecimal getAmountToSeller() {
		return amountToSeller;
	}

	/**
	 * Set the value of property {@code amountToSeller}.
	 *
	 * @param amountToSeller the amountToSeller to set
	 */
	public void setAmountToSeller(BigDecimal amountToSeller) {
		this.amountToSeller = amountToSeller;
	}

	/**
	 * Get the value of property {@code beneficiary}.
	 *
	 * @return the beneficiary
	 */
	public String getBeneficiary() {
		return beneficiary;
	}

	/**
	 * Set the value of property {@code beneficiary}.
	 *
	 * @param beneficiary the beneficiary to set
	 */
	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}

	/**
	 * Get the value of property {@code status}.
	 *
	 * @return the status
	 */
	public PaymentStatus getStatus() {
		return status;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the status to set
	 */
	public void setStatus(PaymentStatus status) {
		this.status = status;
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
	 * Get the value of property {@code description}.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the value of property {@code description}.
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the value of property {@code errorMessage}.
	 *
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Set the value of property {@code errorMessage}.
	 *
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("name", name)
				.append("beneficiary", beneficiary)
				.append("amountToBuyer", amountToBuyer)
				.append("amountToSeller", amountToSeller)
				.append("status", status)
				.append("currency", currency)
				;
	}

}
