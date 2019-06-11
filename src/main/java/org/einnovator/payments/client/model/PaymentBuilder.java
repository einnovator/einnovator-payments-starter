package org.einnovator.payments.client.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PaymentBuilder {

	private String id;

	private String uuid;

	private PaymentStatus status;

	private PaymentStatus transferStatus;

	private Date transferDate;

	private Date paymentDate;

	private Date startDate;

	private Date expireDate;

	private MonetaryAmount amount;

	private String statementDescriptor;

	private Payable payable; 

	private Account buyer;

	private Account seller;

	private Charge charge;

	private String errorMessage;

	private String transferErrorMessage;

	private PaymentStrategy strategy;

	private List<Fee> beneficiaries;

	private PaymentStatus feeStatus;

	private MonetaryAmount tax;

	private Map<String, BigDecimal> feeDistribution;

	public PaymentBuilder() {
	}
	
	public PaymentBuilder id(String id) {
		this.id = id;
		return this;
	}
	
	public PaymentBuilder uuid(String uuid) {
		this.uuid = uuid;
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

	public PaymentBuilder beneficiaries(List<Fee> beneficiaries) {
		this.beneficiaries = beneficiaries;
		return this;
	}

	public PaymentBuilder feeStatus(PaymentStatus feeStatus) {
		this.feeStatus = feeStatus;
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
		payment.setId(id);
		payment.setUuid(uuid);
		payment.setAmount(amount);
		payment.setBeneficiaries(beneficiaries);
		payment.setBuyer(buyer);
		payment.setCharge(charge);
		payment.setErrorMessage(errorMessage);
		payment.setExpireDate(expireDate);
		payment.setFeeStatus(feeStatus);
		payment.setPayable(payable);
		payment.setPaymentDate(paymentDate);
		payment.setStrategy(strategy);
		payment.setSeller(seller);
		payment.setStartDate(startDate);
		payment.setStatementDescriptor(statementDescriptor);
		payment.setStatus(status);
		payment.setTransferDate(transferDate);
		payment.setTransferErrorMessage(transferErrorMessage);
		payment.setTransferStatus(transferStatus);
		payment.setTax(tax);
		payment.setFeeDistribution(feeDistribution);
		
		return payment;
	}


}
