package org.einnovator.payments.client.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PaymentBuilder {

	private String uuid;

	private Currency currency;

	private Payable payable;  

	protected PaymentType type;

	private PaymentStatus status;

	private PaymentStatus transferStatus;

	private BigDecimal amount;

	private BigDecimal discount;

	private BigDecimal totalAmount;

	private BigDecimal tax;

	private Date paymentDate;

	private Date transferDate;

	private Date startDate;

	private Date expireDate;

	private String statement;
	
	private Account buyer;

	private Account seller;

	private List<Fee> fees;


	public PaymentBuilder() {
	}

	public PaymentBuilder uuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	public PaymentBuilder payable(Payable payable) {
		this.payable = payable;
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

	public PaymentBuilder currency(Currency currency) {
		this.currency = currency;
		return this;
	}

	public PaymentBuilder amount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	public PaymentBuilder discount(BigDecimal discount) {
		this.discount = discount;
		return this;
	}

	public PaymentBuilder totalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
		return this;
	}

	public PaymentBuilder tax(BigDecimal tax) {
		this.tax = tax;
		return this;
	}


	public PaymentBuilder statement(String statement) {
		this.statement = statement;
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

	public PaymentBuilder fees(List<Fee> fees) {
		this.fees = fees;
		return this;
	}

	public Payment build() {
		Payment payment = new Payment();
		payment.setUuid(uuid);
		payment.setStatus(status);
		payment.setCurrency(currency);		
		payment.setAmount(amount);
		payment.setDiscount(discount);
		payment.setTax(tax);		
		payment.setTotalAmount(totalAmount);
		payment.setFees(fees);
		payment.setBuyer(buyer);
		payment.setExpireDate(expireDate);
		payment.setPayable(payable);
		payment.setPaymentDate(paymentDate);
		payment.setSeller(seller);
		payment.setStartDate(startDate);
		payment.setStatement(statement);
		payment.setTransferDate(transferDate);
		payment.setTransferStatus(transferStatus);
		return payment;
	}


}
