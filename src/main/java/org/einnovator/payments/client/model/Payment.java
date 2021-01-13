package org.einnovator.payments.client.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payment extends EntityBase {

	protected PaymentType type;

	private PaymentStatus status;

	private Payable payable;  
	
	private Currency currency;

	private BigDecimal amount;

	private BigDecimal discount;

	private BigDecimal totalAmount;

	private BigDecimal chargedAmount;

	private BigDecimal tax;

	private Date paymentDate;

	private Date lastTryDate;

	private Date transferDate;

	private Date startDate;

	private Date expireDate;

	private String statement;
	
	private Account buyer;

	private String documentURI;

	private String errorMessage;

	private Account seller;
	
	private PaymentStatus transferStatus;

	private String transferErrorMessage;

	private List<Fee> fees;

	public Payment() {
	}
	/**
	 * Get the value of property {@code payable}.
	 *
	 * @return the payable
	 */
	public Payable getPayable() {
		return payable;
	}

	/**
	 * Set the value of property {@code payable}.
	 *
	 * @param payable the payable
	 */
	public void setPayable(Payable payable) {
		this.payable = payable;
	}

	/**
	 * Get the value of property {@code amount}.
	 *
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Set the value of property {@code amount}.
	 *
	 * @param amount the amount
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
	 * @param status the status
	 */
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public PaymentType getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type
	 */
	public void setType(PaymentType type) {
		this.type = type;
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
	 * @param currency the currency
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	/**
	 * Get the value of property {@code tax}.
	 *
	 * @return the tax
	 */
	public BigDecimal getTax() {
		return tax;
	}

	/**
	 * Set the value of property {@code tax}.
	 *
	 * @param tax the tax
	 */
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	/**
	 * Get the value of property {@code discount}.
	 *
	 * @return the discount
	 */
	public BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * Set the value of property {@code discount}.
	 *
	 * @param discount the discount
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	/**
	 * Get the value of property {@code totalAmount}.
	 *
	 * @return the totalAmount
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * Set the value of property {@code totalAmount}.
	 *
	 * @param totalAmount the totalAmount
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * Get the value of property {@code chargedAmount}.
	 *
	 * @return the chargedAmount
	 */
	public BigDecimal getChargedAmount() {
		return chargedAmount;
	}

	/**
	 * Set the value of property {@code chargedAmount}.
	 *
	 * @param chargedAmount the chargedAmount
	 */
	public void setChargedAmount(BigDecimal chargedAmount) {
		this.chargedAmount = chargedAmount;
	}

	/**
	 * Get the value of property {@code transferStatus}.
	 *
	 * @return the transferStatus
	 */
	public PaymentStatus getTransferStatus() {
		return transferStatus;
	}

	/**
	 * Set the value of property {@code transferStatus}.
	 *
	 * @param transferStatus the transferStatus
	 */
	public void setTransferStatus(PaymentStatus transferStatus) {
		this.transferStatus = transferStatus;
	}

	/**
	 * Get the value of property {@code transferDate}.
	 *
	 * @return the transferDate
	 */
	public Date getTransferDate() {
		return transferDate;
	}

	/**
	 * Set the value of property {@code transferDate}.
	 *
	 * @param transferDate the transferDate
	 */
	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	/**
	 * Get the value of property {@code paymentDate}.
	 *
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * Set the value of property {@code paymentDate}.
	 *
	 * @param paymentDate the paymentDate
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * Get the value of property {@code startDate}.
	 *
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Set the value of property {@code startDate}.
	 *
	 * @param startDate the startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Get the value of property {@code expireDate}.
	 *
	 * @return the expireDate
	 */
	public Date getExpireDate() {
		return expireDate;
	}

	/**
	 * Set the value of property {@code expireDate}.
	 *
	 * @param expireDate the expireDate
	 */
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	/**
	 * Get the value of property {@code statement}.
	 *
	 * @return the statement
	 */
	public String getStatement() {
		return statement;
	}

	/**
	 * Set the value of property {@code statement}.
	 *
	 * @param statement the statement
	 */
	public void setStatement(String statement) {
		this.statement = statement;
	}

	/**
	 * Get the value of property {@code buyer}.
	 *
	 * @return the buyer
	 */
	public Account getBuyer() {
		return buyer;
	}

	/**
	 * Set the value of property {@code buyer}.
	 *
	 * @param buyer the buyer
	 */
	public void setBuyer(Account buyer) {
		this.buyer = buyer;
	}

	/**
	 * Get the value of property {@code seller}.
	 *
	 * @return the seller
	 */
	public Account getSeller() {
		return seller;
	}

	/**
	 * Set the value of property {@code seller}.
	 *
	 * @param seller the seller
	 */
	public void setSeller(Account seller) {
		this.seller = seller;
	}

	/**
	 * Get the value of property {@code documentURI}.
	 *
	 * @return the documentURI
	 */
	public String getDocumentURI() {
		return documentURI;
	}

	/**
	 * Set the value of property {@code documentURI}.
	 *
	 * @param documentURI the documentURI
	 */
	public void setDocumentURI(String documentURI) {
		this.documentURI = documentURI;
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
	 * @param errorMessage the errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Get the value of property {@code transferErrorMessage}.
	 *
	 * @return the transferErrorMessage
	 */
	public String getTransferErrorMessage() {
		return transferErrorMessage;
	}

	/**
	 * Set the value of property {@code transferErrorMessage}.
	 *
	 * @param transferErrorMessage the transferErrorMessage
	 */
	public void setTransferErrorMessage(String transferErrorMessage) {
		this.transferErrorMessage = transferErrorMessage;
	}

	/**
	 * Get the value of property {@code lastTryDate}.
	 *
	 * @return the lastTryDate
	 */
	public Date getLastTryDate() {
		return lastTryDate;
	}

	/**
	 * Set the value of property {@code lastTryDate}.
	 *
	 * @param lastTryDate the lastTryDate
	 */
	public void setLastTryDate(Date lastTryDate) {
		this.lastTryDate = lastTryDate;
	}

	/**
	 * Get the value of property {@code fees}.
	 *
	 * @return the fees
	 */
	public List<Fee> getFees() {
		return fees;
	}

	/**
	 * Set the value of property {@code fees}.
	 *
	 * @param fees the fees
	 */
	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}
	
	//
	// With
	//
	
	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of property type
	 * @return this {@code Payment}
	 */
	public Payment withType(PaymentType type) {
		this.type = type;
		return this;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the value of property status
	 * @return this {@code Payment}
	 */
	public Payment withStatus(PaymentStatus status) {
		this.status = status;
		return this;
	}

	/**
	 * Set the value of property {@code payable}.
	 *
	 * @param payable the value of property payable
	 * @return this {@code Payment}
	 */
	public Payment withPayable(Payable payable) {
		this.payable = payable;
		return this;
	}

	/**
	 * Set the value of property {@code currency}.
	 *
	 * @param currency the value of property currency
	 * @return this {@code Payment}
	 */
	public Payment withCurrency(Currency currency) {
		this.currency = currency;
		return this;
	}

	/**
	 * Set the value of property {@code amount}.
	 *
	 * @param amount the value of property amount
	 * @return this {@code Payment}
	 */
	public Payment withAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	/**
	 * Set the value of property {@code discount}.
	 *
	 * @param discount the value of property discount
	 * @return this {@code Payment}
	 */
	public Payment withDiscount(BigDecimal discount) {
		this.discount = discount;
		return this;
	}

	/**
	 * Set the value of property {@code totalAmount}.
	 *
	 * @param totalAmount the value of property totalAmount
	 * @return this {@code Payment}
	 */
	public Payment withTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
		return this;
	}

	/**
	 * Set the value of property {@code chargedAmount}.
	 *
	 * @param chargedAmount the value of property chargedAmount
	 * @return this {@code Payment}
	 */
	public Payment withChargedAmount(BigDecimal chargedAmount) {
		this.chargedAmount = chargedAmount;
		return this;
	}

	/**
	 * Set the value of property {@code tax}.
	 *
	 * @param tax the value of property tax
	 * @return this {@code Payment}
	 */
	public Payment withTax(BigDecimal tax) {
		this.tax = tax;
		return this;
	}

	/**
	 * Set the value of property {@code paymentDate}.
	 *
	 * @param paymentDate the value of property paymentDate
	 * @return this {@code Payment}
	 */
	public Payment withPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
		return this;
	}

	/**
	 * Set the value of property {@code lastTryDate}.
	 *
	 * @param lastTryDate the value of property lastTryDate
	 * @return this {@code Payment}
	 */
	public Payment withLastTryDate(Date lastTryDate) {
		this.lastTryDate = lastTryDate;
		return this;
	}

	/**
	 * Set the value of property {@code transferDate}.
	 *
	 * @param transferDate the value of property transferDate
	 * @return this {@code Payment}
	 */
	public Payment withTransferDate(Date transferDate) {
		this.transferDate = transferDate;
		return this;
	}

	/**
	 * Set the value of property {@code startDate}.
	 *
	 * @param startDate the value of property startDate
	 * @return this {@code Payment}
	 */
	public Payment withStartDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}

	/**
	 * Set the value of property {@code expireDate}.
	 *
	 * @param expireDate the value of property expireDate
	 * @return this {@code Payment}
	 */
	public Payment withExpireDate(Date expireDate) {
		this.expireDate = expireDate;
		return this;
	}

	/**
	 * Set the value of property {@code statement}.
	 *
	 * @param statement the value of property statement
	 * @return this {@code Payment}
	 */
	public Payment withStatement(String statement) {
		this.statement = statement;
		return this;
	}

	/**
	 * Set the value of property {@code buyer}.
	 *
	 * @param buyer the value of property buyer
	 * @return this {@code Payment}
	 */
	public Payment withBuyer(Account buyer) {
		this.buyer = buyer;
		return this;
	}

	/**
	 * Set the value of property {@code documentURI}.
	 *
	 * @param documentURI the value of property documentURI
	 * @return this {@code Payment}
	 */
	public Payment withDocumentURI(String documentURI) {
		this.documentURI = documentURI;
		return this;
	}

	/**
	 * Set the value of property {@code errorMessage}.
	 *
	 * @param errorMessage the value of property errorMessage
	 * @return this {@code Payment}
	 */
	public Payment withErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

	/**
	 * Set the value of property {@code seller}.
	 *
	 * @param seller the value of property seller
	 * @return this {@code Payment}
	 */
	public Payment withSeller(Account seller) {
		this.seller = seller;
		return this;
	}

	/**
	 * Set the value of property {@code transferStatus}.
	 *
	 * @param transferStatus the value of property transferStatus
	 * @return this {@code Payment}
	 */
	public Payment withTransferStatus(PaymentStatus transferStatus) {
		this.transferStatus = transferStatus;
		return this;
	}

	/**
	 * Set the value of property {@code transferErrorMessage}.
	 *
	 * @param transferErrorMessage the value of property transferErrorMessage
	 * @return this {@code Payment}
	 */
	public Payment withTransferErrorMessage(String transferErrorMessage) {
		this.transferErrorMessage = transferErrorMessage;
		return this;
	}

	/**
	 * Set the value of property {@code fees}.
	 *
	 * @param fees the value of property fees
	 * @return this {@code Payment}
	 */
	public Payment withFees(List<Fee> fees) {
		this.fees = fees;
		return this;
	}

	public boolean isPaid() {
		if (status != null && status.isPaid()) {
			return true;
		}
		return false;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("status", status)
				.append("transferStatus", transferStatus)
				.append("amount", amount)
				.append("discount", discount)
				.append("tax", tax)				
				.append("totalAmount", totalAmount)
				.append("chargedAmount", chargedAmount)
				.append("buyer", buyer)
				.append("seller", seller)
				.append("statement", statement)
				.append("paymentDate", paymentDate)
				.append("lastTryDate", lastTryDate)
				.append("startDate", startDate)
				.append("expireDate", expireDate)
				.append("transferDate", transferDate)
				.append("errorMessage", errorMessage)
				.append("transferErrorMessage", transferErrorMessage)
				.append("fees", fees)
				;
	}
	

}