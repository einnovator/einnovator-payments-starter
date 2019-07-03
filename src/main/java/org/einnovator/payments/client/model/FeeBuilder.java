package org.einnovator.payments.client.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FeeBuilder {
	private Boolean visibleToBuyer = false;

	private Boolean visibleToSeller = false;

	private BigDecimal amountToBuyer;

	private BigDecimal amountToSeller;

	private String beneficiary;

	private PaymentStatus status;

	private Currency currency;

	public FeeBuilder() {
	}

	public FeeBuilder visibleToBuyer(Boolean visibleToBuyer) {
		this.visibleToBuyer = visibleToBuyer;
		return this;
	}

	public FeeBuilder visibleToSeller(Boolean visibleToSeller) {
		this.visibleToSeller = visibleToSeller;
		return this;
	}

	public FeeBuilder amountToBuyer(BigDecimal amountToBuyer) {
		this.amountToBuyer = amountToBuyer;
		return this;
	}

	public FeeBuilder amountToSeller(BigDecimal amountToSeller) {
		this.amountToSeller = amountToSeller;
		return this;
	}

	public FeeBuilder beneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
		return this;
	}

	public FeeBuilder status(PaymentStatus status) {
		this.status = status;
		return this;
	}

	public FeeBuilder currency(Currency currency) {
		this.currency = currency;
		return this;
	}
	
	public Fee build() {
		amountToBuyer = amountToBuyer.setScale(2, RoundingMode.HALF_UP);
		amountToSeller = amountToSeller.setScale(2, RoundingMode.HALF_UP);
		Fee fee = new Fee();
		fee.setBeneficiary(beneficiary);
		fee.setStatus(status);
		fee.setAmountToBuyer(amountToBuyer);
		fee.setAmountToSeller(amountToSeller);
		fee.setVisibleToBuyer(visibleToBuyer);
		fee.setVisibleToSeller(visibleToSeller);
		fee.setCurrency(currency);
		return fee;
	}

}
