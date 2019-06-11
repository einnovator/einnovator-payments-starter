package org.einnovator.payments.client.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payment extends EntityBase {

	private PaymentStrategy strategy;
	
	private PaymentStatus status;

	private PaymentStatus transferStatus;

	private Date transferDate;

	private Date paymentDate;

	private Date startDate;

	private Date expireDate;

	private MonetaryAmount amount;

	private String statementDescriptor;
	
	private Payable payable;  // Describes the item/order being purchase/traded
	
	private Account buyer;

	private Account seller;
	
	private Charge charge;
	
	private String documentURI;

	private String errorMessage;

	private String transferErrorMessage;

	private PaymentStatus feeStatus;

	private Fee fee;  // Site fee for Marketplace

	private List<Fee> beneficiaries;

	private Map<String, BigDecimal> feeDistribution;

	private MonetaryAmount tax;
	
	public Payment() {
	}

	
	/**
	 * Get the value of property {@code strategy}.
	 *
	 * @return the strategy
	 */
	public PaymentStrategy getStrategy() {
		return strategy;
	}


	/**
	 * Set the value of property {@code strategy}.
	 *
	 * @param strategy the strategy to set
	 */
	public void setStrategy(PaymentStrategy strategy) {
		this.strategy = strategy;
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
	 * @param transferStatus the transferStatus to set
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
	 * @param transferDate the transferDate to set
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
	 * @param paymentDate the paymentDate to set
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
	 * @param startDate the startDate to set
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
	 * @param expireDate the expireDate to set
	 */
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}


	/**
	 * Get the value of property {@code amount}.
	 *
	 * @return the amount
	 */
	public MonetaryAmount getAmount() {
		return amount;
	}


	/**
	 * Set the value of property {@code amount}.
	 *
	 * @param amount the amount to set
	 */
	public void setAmount(MonetaryAmount amount) {
		this.amount = amount;
	}


	/**
	 * Get the value of property {@code statementDescriptor}.
	 *
	 * @return the statementDescriptor
	 */
	public String getStatementDescriptor() {
		return statementDescriptor;
	}


	/**
	 * Set the value of property {@code statementDescriptor}.
	 *
	 * @param statementDescriptor the statementDescriptor to set
	 */
	public void setStatementDescriptor(String statementDescriptor) {
		this.statementDescriptor = statementDescriptor;
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
	 * @param payable the payable to set
	 */
	public void setPayable(Payable payable) {
		this.payable = payable;
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
	 * @param buyer the buyer to set
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
	 * @param seller the seller to set
	 */
	public void setSeller(Account seller) {
		this.seller = seller;
	}


	/**
	 * Get the value of property {@code fee}.
	 *
	 * @return the fee
	 */
	public Fee getFee() {
		return fee;
	}

	/**
	 * Set the value of property {@code fee}.
	 *
	 * @param fee the fee to set
	 */
	public void setFee(Fee fee) {
		this.fee = fee;
	}

	/**
	 * Get the value of property {@code charge}.
	 *
	 * @return the charge
	 */
	public Charge getCharge() {
		return charge;
	}


	/**
	 * Set the value of property {@code charge}.
	 *
	 * @param charge the charge to set
	 */
	public void setCharge(Charge charge) {
		this.charge = charge;
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
	 * @param documentURI the documentURI to set
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
	 * @param errorMessage the errorMessage to set
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
	 * @param transferErrorMessage the transferErrorMessage to set
	 */
	public void setTransferErrorMessage(String transferErrorMessage) {
		this.transferErrorMessage = transferErrorMessage;
	}


	/**
	 * Get the value of property {@code beneficiaries}.
	 *
	 * @return the beneficiaries
	 */
	public List<Fee> getBeneficiaries() {
		return beneficiaries;
	}


	/**
	 * Set the value of property {@code beneficiaries}.
	 *
	 * @param beneficiaries the beneficiaries to set
	 */
	public void setBeneficiaries(List<Fee> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}



	/**
	 * Get the value of property {@code feeStatus}.
	 *
	 * @return the feeStatus
	 */
	public PaymentStatus getFeeStatus() {
		return feeStatus;
	}


	/**
	 * Set the value of property {@code feeStatus}.
	 *
	 * @param feeStatus the feeStatus to set
	 */
	public void setFeeStatus(PaymentStatus feeStatus) {
		this.feeStatus = feeStatus;
	}

	/**
	 * Get the value of property {@code tax}.
	 *
	 * @return the tax
	 */
	public MonetaryAmount getTax() {
		return tax;
	}


	/**
	 * Set the value of property {@code tax}.
	 *
	 * @param tax the tax to set
	 */
	public void setTax(MonetaryAmount tax) {
		this.tax = tax;
	}


	/**
	 * Get the value of property {@code feeDistribution}.
	 *
	 * @return the feeDistribution
	 */
	public Map<String, BigDecimal> getFeeDistribution() {
		return feeDistribution;
	}


	/**
	 * Set the value of property {@code feeDistribution}.
	 *
	 * @param feeDistribution the feeDistribution to set
	 */
	public void setFeeDistribution(Map<String, BigDecimal> feeDistribution) {
		this.feeDistribution = feeDistribution;
	}


	public boolean isPaid() {
		if (status != null && status.containsOne(PaymentStatus.CHARGED, PaymentStatus.COMPLETED)) {
			return true;
		}
		return false;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("status", status)
				.append("transferStatus", transferStatus)
				.append("strategy", strategy)
				.append("amount", amount)
				.append("tax", tax)
				.append("buyer", buyer)
				.append("statementDescriptor", statementDescriptor)
				.append("paymentDate", paymentDate)
				.append("expireDate", expireDate)
				.append("transferDate", transferDate)
				.append("errorMessage", errorMessage)
				.append("transferErrorMessage", transferErrorMessage)
				.append("seller", seller)
				.append("beneficiaries", beneficiaries)
				;
	}
	

	public void flattenFees() {
		Map<String, Fee> feesPerBeneficiary = new HashMap<String, Fee>();
		for (Fee fee : beneficiaries) {
			Fee b = feesPerBeneficiary.get(fee.getBeneficiary());
			if( b == null) {
				feesPerBeneficiary.put(fee.getBeneficiary(), fee);
			}else {
				b.setTotalAmountToBuyer(b.getTotalAmountToBuyer().add(fee.getTotalAmountToBuyer()));
			}			
		}
		List<Fee> fees = new LinkedList<>(feesPerBeneficiary.values());
		this.beneficiaries = fees;
	}

}