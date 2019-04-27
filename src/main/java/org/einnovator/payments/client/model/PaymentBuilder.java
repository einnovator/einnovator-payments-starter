package org.einnovator.payments.client.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentBuilder {
	
	private PaymentFeeType feeType;

	private PaymentStatus status;

	private PaymentStatus transferStatus;

	private Date createdDate;

	private Date transferDate;

	private Date paymentDate;

	private Date startDate;

	private Date expireDate;

	private MonetaryAmount amount;

	private String statementDescriptor;

	private Payable payable; // Further describes the item/order being purchase/traded

	private Account buyer;

	private Account seller;

	private String transferAccountId;

	private String transferId;

	private Charge charge;

	private String errorMessage;

	private String transferErrorMessage;

	private String refId;
	
	private PaymentStrategy strategy;

	private Map<String, Object> meta = new HashMap<>();

	private List<Fee> beneficiaries;

	private boolean autoInvoice;

	private PaymentStatus feeStatus;

	private String sourceId;
	
	private MonetaryAmount tax;

	private Map<String, BigDecimal> feeDistribution;

	public PaymentBuilder() {
	}

	public PaymentBuilder feeType(PaymentFeeType feeType) {
		this.feeType = feeType;
		return this;
	}

	public PaymentBuilder status(PaymentStatus status) {
		this.status = status;
		return this;
	}

	public PaymentBuilder transferStatus(PaymentStatus transferStatus) {
		this.transferStatus = transferStatus;
		return this;
	}

	public PaymentBuilder createdDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public PaymentBuilder transferDate(Date transferDate) {
		this.transferDate = transferDate;
		return this;
	}

	public PaymentBuilder paymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
		return this;
	}

	public PaymentBuilder startDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}

	public PaymentBuilder expireDate(Date expireDate) {
		this.expireDate = expireDate;
		return this;
	}

	public PaymentBuilder amount(MonetaryAmount amount) {
		this.amount = amount;
		return this;
	}

	public PaymentBuilder statementDescriptor(String statementDescriptor) {
		this.statementDescriptor = statementDescriptor;
		return this;
	}

	public PaymentBuilder payable(Payable payable) {
		this.payable = payable;
		return this;
	}

	public PaymentBuilder buyer(Account buyer) {
		this.buyer = buyer;
		return this;
	}

	public PaymentBuilder seller(Account seller) {
		this.seller = seller;
		return this;
	}

	public PaymentBuilder transferAccountId(String transferAccountId) {
		this.transferAccountId = transferAccountId;
		return this;
	}

	public PaymentBuilder transferId(String transferId) {
		this.transferId = transferId;
		return this;
	}

	public PaymentBuilder charge(Charge charge) {
		this.charge = charge;
		return this;
	}

	public PaymentBuilder errorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

	public PaymentBuilder transferErrorMessage(String transferErrorMessage) {
		this.transferErrorMessage = transferErrorMessage;
		return this;
	}

	public PaymentBuilder refId(String refId) {
		this.refId = refId;
		return this;
	}

	public PaymentBuilder meta(String key, Object value) {
		meta.put(key, value);
		return this;
	}

	public PaymentBuilder beneficiaries(List<Fee> beneficiaries) {
		this.beneficiaries = beneficiaries;
		return this;
	}

	public PaymentBuilder autoInvoice(boolean autoInvoice) {
		this.autoInvoice = autoInvoice;
		return this;
	}

	public PaymentBuilder feeStatus(PaymentStatus feeStatus) {
		this.feeStatus = feeStatus;
		return this;
	}

	public PaymentBuilder sourceId(String sourceId) {
		this.sourceId = sourceId;
		return this;
	}
	
	public PaymentBuilder strategy(PaymentStrategy strategy) {
		this.strategy = strategy;
		return this;
	}
	
	public PaymentBuilder tax(MonetaryAmount tax) {
		this.tax = tax;
		return this;
	}
	
	public PaymentBuilder feeDistribution(Map<String, BigDecimal> feeDistribution) {
		this.feeDistribution = feeDistribution;
		return this;
	}
	
	public Payment build() {
		Payment payment = new Payment();
//		payment.setFeeType(feeType);
		payment.setAmount(amount);
		payment.setAutoInvoice(autoInvoice);
		payment.setBeneficiaries(beneficiaries);
		payment.setBuyer(buyer);
		payment.setCharge(charge);
		payment.setCreatedDate(createdDate);
		payment.setErrorMessage(errorMessage);
		payment.setExpireDate(expireDate);
		payment.setFeeStatus(feeStatus);
		payment.setMeta(meta);
		payment.setPayable(payable);
		payment.setPaymentDate(paymentDate);
		payment.setRefId(refId);
		payment.setStrategy(strategy);
		payment.setSeller(seller);
		payment.setSourceId(sourceId);
//		payment.setSourceNumber(sourceNumber);
//		payment.setSourceType(sourceType);
		payment.setStartDate(startDate);
		payment.setStatementDescriptor(statementDescriptor);
		payment.setStatus(status);
		payment.setTransferAccountId(transferAccountId);
		payment.setTransferDate(transferDate);
		payment.setTransferErrorMessage(transferErrorMessage);
		payment.setTransferId(transferId);
		payment.setTransferStatus(transferStatus);
		payment.setTax(tax);
		payment.setFeeDistribution(feeDistribution);
		
		return payment;
	}


}
