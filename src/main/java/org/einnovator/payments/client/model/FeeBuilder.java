package org.einnovator.payments.client.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FeeBuilder {
	private Boolean visibleToBuyer = false;

	private Boolean visibleToSeller = false;

	private BigDecimal totalAmountToBuyer;

	private BigDecimal totalAmountToSeller;

	private String beneficiary;

	private PaymentStatus status;

	private String refId;

	private String documentId;
	
	private boolean noProof;
	
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

	public FeeBuilder totalAmountToBuyer(BigDecimal totalAmountToBuyer) {
		this.totalAmountToBuyer = totalAmountToBuyer;
		return this;
	}

	public FeeBuilder totalAmountToSeller(BigDecimal totalAmountToSeller) {
		this.totalAmountToSeller = totalAmountToSeller;
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

	public FeeBuilder refId(String refId) {
		this.refId = refId;
		return this;
	}

	public FeeBuilder documentId(String documentId) {
		this.documentId = documentId;
		return this;
	}
	
	public FeeBuilder noProof(boolean noProof) {
		this.noProof = noProof;
		return this;
	}

	public FeeBuilder currency(Currency currency) {
		this.currency = currency;
		return this;
	}
	
	public Fee build() {
		totalAmountToBuyer = totalAmountToBuyer.setScale(2, RoundingMode.HALF_UP);
		totalAmountToSeller = totalAmountToSeller.setScale(2, RoundingMode.HALF_UP);
		Fee fee = new Fee();
		fee.setBeneficiary(beneficiary);
		fee.setDocumentId(documentId);
		fee.setRefId(refId);
		fee.setStatus(status);
		fee.setTotalAmountToBuyer(totalAmountToBuyer);
		fee.setTotalAmountToSeller(totalAmountToSeller);
		fee.setVisibleToBuyer(visibleToBuyer);
		fee.setVisibleToSeller(visibleToSeller);
		fee.setNoProof(noProof);
		fee.setCurrency(currency);
		return fee;
	}

	@Override
	public String toString() {
		return "FeeBuilder [" + (visibleToBuyer != null ? "visibleToBuyer=" + visibleToBuyer + ", " : "")
				+ (visibleToSeller != null ? "visibleToSeller=" + visibleToSeller + ", " : "")
				+ (totalAmountToBuyer != null ? "totalAmountToBuyer=" + totalAmountToBuyer + ", " : "")
				+ (totalAmountToSeller != null ? "totalAmountToSeller=" + totalAmountToSeller + ", " : "") + (beneficiary != null ? "beneficiary=" + beneficiary + ", " : "")
				+ (status != null ? "status=" + status + ", " : "") + (refId != null ? "refId=" + refId + ", " : "") + (documentId != null ? "documentId=" + documentId + ", " : "")
				+ "noProof=" + noProof + ", " + (currency != null ? "currency=" + currency : "") + "]";
	}

}
