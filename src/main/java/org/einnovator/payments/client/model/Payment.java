package org.einnovator.payments.client.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.einnovator.util.MappingUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment {

	private String id;
	
	private PaymentStrategy strategy;
	
	private PaymentStatus status;

	private PaymentStatus transferStatus;

//	private PaymentFeeType feeType;

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

	private Fee fee; // Site fee for Market Place

	private String transferId;

//	private String sourceNumber;
//
//	private String sourceType;

	private Charge charge;
	
	private String documentURI;

	private String errorMessage;

	private String transferErrorMessage;

	private String refId;

	private Map<String, Object> meta;

	private List<Fee> beneficiaries;

	private String sourceId;

	private boolean autoInvoice;

	private PaymentStatus feeStatus;

//	private PaymentMode mode;
//
//	private PaymentMode sellerMode;

	private String transferAccountId;
	
	private MonetaryAmount tax;
	
	private Map<String, BigDecimal> feeDistribution;

	public Payment() {
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public MonetaryAmount getAmount() {
		return amount;
	}

	public void setAmount(MonetaryAmount amount) {
		this.amount = amount;
	}

	public String getStatementDescriptor() {
		return statementDescriptor;
	}

	public void setStatementDescriptor(String statementDescriptor) {
		this.statementDescriptor = statementDescriptor;
	}

	public Account getBuyer() {
		return buyer;
	}

	public void setBuyer(Account buyer) {
		this.buyer = buyer;
	}

	public Account getSeller() {
		return seller;
	}

	public void setSeller(Account seller) {
		this.seller = seller;
	}

	public Payable getPayable() {
		return payable;
	}

	public void setPayable(Payable payable) {
		this.payable = payable;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public Map<String, Object> getMeta() {
		return meta;
	}

	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}

	public static Payment makePayment(Object payment) {
		return MappingUtils.convert(payment, Payment.class);
	}

	public Charge getCharge() {
		return charge;
	}

	public void setCharge(Charge charge) {
		this.charge = charge;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public PaymentStatus getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(PaymentStatus transferStatus) {
		this.transferStatus = transferStatus;
	}

//	public PaymentFeeType getFeeType() {
//		return feeType;
//	}
//
//	public void setFeeType(PaymentFeeType feeType) {
//		this.feeType = feeType;
//	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public Fee getFee() {
		return fee;
	}

	public void setFee(Fee fee) {
		this.fee = fee;
	}

	public String getTransferId() {
		return transferId;
	}

	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}

//	public String getSourceNumber() {
//		return sourceNumber;
//	}
//
//	public void setSourceNumber(String sourceNumber) {
//		this.sourceNumber = sourceNumber;
//	}
//
//	public String getSourceType() {
//		return sourceType;
//	}
//
//	public void setSourceType(String sourceType) {
//		this.sourceType = sourceType;
//	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getTransferErrorMessage() {
		return transferErrorMessage;
	}

	public void setTransferErrorMessage(String transferErrorMessage) {
		this.transferErrorMessage = transferErrorMessage;
	}

	public List<Fee> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<Fee> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public boolean isAutoInvoice() {
		return autoInvoice;
	}

	public void setAutoInvoice(boolean autoInvoice) {
		this.autoInvoice = autoInvoice;
	}

	public PaymentStatus getFeeStatus() {
		return feeStatus;
	}

	public void setFeeStatus(PaymentStatus feeStatus) {
		this.feeStatus = feeStatus;
	}

//	public PaymentMode getMode() {
//		return mode;
//	}
//
//	public void setMode(PaymentMode mode) {
//		this.mode = mode;
//	}
//
//	public void setSellerMode(PaymentMode sellerMode) {
//		this.sellerMode = sellerMode;
//	}
//
//	public PaymentMode getSellerMode() {
//		return sellerMode;
//	}

	public String getTransferAccountId() {
		return transferAccountId;
	}

	public void setTransferAccountId(String transferAccountId) {
		this.transferAccountId = transferAccountId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public MonetaryAmount getTax() {
		return tax;
	}

	public PaymentStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(PaymentStrategy strategy) {
		this.strategy = strategy;
	}

	public void setTax(MonetaryAmount tax) {
		this.tax = tax;
	}

	public Map<String, BigDecimal> getFeeDistribution() {
		return feeDistribution;
	}

	public void setFeeDistribution(Map<String, BigDecimal> feeDistribution) {
		this.feeDistribution = feeDistribution;
	}

	public String getDocumentURI() {
		return documentURI;
	}

	public void setDocumentURI(String documentId) {
		this.documentURI = documentId;
	}

	@Override
	public String toString() {
		return "Payment [" + (id != null ? "id=" + id + ", " : "") + (strategy != null ? "strategy=" + strategy + ", " : "") + (status != null ? "status=" + status + ", " : "")
				+ (transferStatus != null ? "transferStatus=" + transferStatus + ", " : "") /* + (feeType != null ? "feeType=" + feeType + ", " : "") */
				+ (createdDate != null ? "createdDate=" + createdDate + ", " : "") + (transferDate != null ? "transferDate=" + transferDate + ", " : "")
				+ (paymentDate != null ? "paymentDate=" + paymentDate + ", " : "") + (startDate != null ? "startDate=" + startDate + ", " : "")
				+ (expireDate != null ? "expireDate=" + expireDate + ", " : "") + (amount != null ? "amount=" + amount + ", " : "")
				+ (statementDescriptor != null ? "statementDescriptor=" + statementDescriptor + ", " : "") + (payable != null ? "payable=" + payable + ", " : "")
				+ (buyer != null ? "buyer=" + buyer + ", " : "") + (seller != null ? "seller=" + seller + ", " : "") + (fee != null ? "fee=" + fee + ", " : "")
				+ (transferId != null ? "transferId=" + transferId + ", " : "") /*+ (sourceNumber != null ? "sourceNumber=" + sourceNumber + ", " : "")
				+ (sourceType != null ? "sourceType=" + sourceType + ", " : "")*/ + (charge != null ? "charge=" + charge + ", " : "")
				+ (errorMessage != null ? "errorMessage=" + errorMessage + ", " : "") + (transferErrorMessage != null ? "transferErrorMessage=" + transferErrorMessage + ", " : "")
				+ (refId != null ? "refId=" + refId + ", " : "") + (meta != null ? "meta=" + meta + ", " : "")
				+ (beneficiaries != null ? "beneficiaries=" + beneficiaries + ", " : "") + (sourceId != null ? "sourceId=" + sourceId + ", " : "") + "autoInvoice=" + autoInvoice
				+ ", " + (feeStatus != null ? "feeStatus=" + feeStatus + ", " : "") + (transferAccountId != null ? "transferAccountId=" + transferAccountId + ", " : "")
				+ (tax != null ? "tax=" + tax + ", " : "") + (feeDistribution != null ? "feeDistribution=" + feeDistribution : "") + "]";
	}
	
	public void flattenFees() {
		Map<String, Fee> feesPerBeneficiary = new HashMap<String, Fee>();
		for(Fee fee : beneficiaries) {
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

	public boolean isPaid() {
		if (status != null && status.containsOne(PaymentStatus.CHARGED, PaymentStatus.COMPLETED)) {
			return true;
		}
		return false;
	}

}