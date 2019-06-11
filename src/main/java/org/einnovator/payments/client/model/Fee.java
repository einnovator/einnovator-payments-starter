package org.einnovator.payments.client.model;

import java.math.BigDecimal;

import org.einnovator.util.model.EntityBase;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Fee extends EntityBase {

	private Boolean visibleToBuyer;

	private Boolean visibleToSeller;
	
	private BigDecimal totalAmountToBuyer;
	
	private BigDecimal totalAmountToSeller;
	
	private String beneficiary;
	
	private PaymentStatus status;
	
	private String transferId;

	private String refId;
	
	private String documentId;
	
	private Boolean noProof;
	
	private Currency currency;
	
	private String name;
	

	public Fee() {
	}
	
	public Fee(BigDecimal totalAmountToBuyer, BigDecimal totalAmountToSeller, Currency currency) {
		this.totalAmountToBuyer = totalAmountToBuyer;
		this.totalAmountToSeller = totalAmountToSeller;
		this.currency = currency;
	}

	public Fee(BigDecimal forBuyer, BigDecimal forSeller, Currency currency, String beneficiary, boolean noProof, boolean distributable) {
		this.totalAmountToBuyer = forBuyer;
		this.totalAmountToSeller = forSeller;
		this.beneficiary = beneficiary;
		this.noProof = noProof;
		this.currency = currency;
	}

	public Boolean getVisibleToBuyer() {
		return visibleToBuyer;
	}

	public void setVisibleToBuyer(Boolean visibleToBuyer) {
		this.visibleToBuyer = visibleToBuyer;
	}

	public Boolean getVisibleToSeller() {
		return visibleToSeller;
	}

	public void setVisibleToSeller(Boolean visibleToSeller) {
		this.visibleToSeller = visibleToSeller;
	}

	public BigDecimal getTotalAmountToBuyer() {
		return totalAmountToBuyer;
	}

	public void setTotalAmountToBuyer(BigDecimal totalAmountToBuyer) {
		this.totalAmountToBuyer = totalAmountToBuyer;
	}

	public BigDecimal getTotalAmountToSeller() {
		return totalAmountToSeller;
	}

	public void setTotalAmountToSeller(BigDecimal totalAmountToSeller) {
		this.totalAmountToSeller = totalAmountToSeller;
	}

	public String getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public boolean isNoProof() {
		return noProof;
	}

	public void setNoProof(boolean noProof) {
		this.noProof = noProof;
	}

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public boolean isDistributable() {
//		return distributable;
//	}
//
//	public void setDistributable(boolean distributable) {
//		this.distributable = distributable;
//	}

	@Override
	public String toString() {
		return "Fee [" + (visibleToBuyer != null ? "visibleToBuyer=" + visibleToBuyer + ", " : "") + (visibleToSeller != null ? "visibleToSeller=" + visibleToSeller + ", " : "")
				+ (totalAmountToBuyer != null ? "totalAmountToBuyer=" + totalAmountToBuyer + ", " : "")
				+ (totalAmountToSeller != null ? "totalAmountToSeller=" + totalAmountToSeller + ", " : "") + (beneficiary != null ? "beneficiary=" + beneficiary + ", " : "")
				+ (status != null ? "status=" + status + ", " : "") + (transferId != null ? "transferId=" + transferId + ", " : "") + (refId != null ? "refId=" + refId + ", " : "")
				+ (documentId != null ? "documentId=" + documentId + ", " : "") + "noProof=" + noProof + ", " + (currency != null ? "currency=" + currency + ", " : "")
				+ (name != null ? "name=" + name : "") + "]";
	}

}
