package org.einnovator.payments.client.modelx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.einnovator.payments.client.model.PaymentStatus;
import org.einnovator.payments.client.model.PaymentType;
import org.einnovator.util.model.ToStringCreator;

public class PaymentFilter extends PaymentOptions {

	public static final List<PaymentStatus> STATUS_ACTIVE = Arrays.asList(PaymentStatus.SUBMITTED, PaymentStatus.FAILED, PaymentStatus.PENDING);
	
	public static final List<PaymentStatus> STATUS_HISTORY = Arrays.asList(PaymentStatus.CHARGED, PaymentStatus.COMPLETED, PaymentStatus.CANCELED);

	private PaymentType type;
	
	private List<PaymentStatus> status;
	
	private List<PaymentStatus> transferStatus;

	private String owner;
	
	private String account;
		
	private Boolean buyer;
	
	private Boolean seller;

	private List<String> buyers;
	
	private List<String> sellers;
	
	private String q;	

	private Long fromCreationDate;

	private Long toCreationDate;

	private Long fromPaymentDate;

	private Long toPaymentDate;

	/**
	 * Create instance of {@code PaymentFilter}.
	 *
	 */
	public PaymentFilter() {
	}
	
	/**
	 * Get the value of property {@code status}.
	 *
	 * @return the status
	 */
	public List<PaymentStatus> getStatus() {
		return status;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the status
	 */
	public void setStatus(List<PaymentStatus> status) {
		this.status = status;
	}

	/**
	 * Get the value of property {@code transferStatus}.
	 *
	 * @return the transferStatus
	 */
	public List<PaymentStatus> getTransferStatus() {
		return transferStatus;
	}

	/**
	 * Set the value of property {@code transferStatus}.
	 *
	 * @param transferStatus the transferStatus
	 */
	public void setTransferStatus(List<PaymentStatus> transferStatus) {
		this.transferStatus = transferStatus;
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
	 * Get the value of property {@code owner}.
	 *
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Set the value of property {@code owner}.
	 *
	 * @param owner the value of property owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Get the value of property {@code account}.
	 *
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * Set the value of property {@code account}.
	 *
	 * @param account the value of property account
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * Get the value of property {@code buyer}.
	 *
	 * @return the buyer
	 */
	public Boolean getBuyer() {
		return buyer;
	}

	/**
	 * Set the value of property {@code buyer}.
	 *
	 * @param buyer the buyer
	 */
	public void setBuyer(Boolean buyer) {
		this.buyer = buyer;
	}

	/**
	 * Get the value of property {@code seller}.
	 *
	 * @return the seller
	 */
	public Boolean getSeller() {
		return seller;
	}

	/**
	 * Set the value of property {@code seller}.
	 *
	 * @param seller the seller
	 */
	public void setSeller(Boolean seller) {
		this.seller = seller;
	}

	/**
	 * Get the value of property {@code buyers}.
	 *
	 * @return the buyers
	 */
	public List<String> getBuyers() {
		return buyers;
	}

	/**
	 * Set the value of property {@code buyers}.
	 *
	 * @param buyers the buyers
	 */
	public void setBuyers(List<String> buyers) {
		this.buyers = buyers;
	}

	/**
	 * Get the value of property {@code sellers}.
	 *
	 * @return the sellers
	 */
	public List<String> getSellers() {
		return sellers;
	}

	/**
	 * Set the value of property {@code sellers}.
	 *
	 * @param sellers the sellers
	 */
	public void setSellers(List<String> sellers) {
		this.sellers = sellers;
	}
	

	/**
	 * Get the value of property {@code q}.
	 *
	 * @return the q
	 */
	public String getQ() {
		return q;
	}

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the q
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * Get the value of property {@code fromCreationDate}.
	 *
	 * @return the fromCreationDate
	 */
	public Long getFromCreationDate() {
		return fromCreationDate;
	}

	/**
	 * Set the value of property {@code fromCreationDate}.
	 *
	 * @param fromCreationDate the fromCreationDate
	 */
	public void setFromCreationDate(Long fromCreationDate) {
		this.fromCreationDate = fromCreationDate;
	}

	/**
	 * Get the value of property {@code toCreationDate}.
	 *
	 * @return the toCreationDate
	 */
	public Long getToCreationDate() {
		return toCreationDate;
	}

	/**
	 * Set the value of property {@code toCreationDate}.
	 *
	 * @param toCreationDate the toCreationDate
	 */
	public void setToCreationDate(Long toCreationDate) {
		this.toCreationDate = toCreationDate;
	}

	/**
	 * Get the value of property {@code fromPaymentDate}.
	 *
	 * @return the fromPaymentDate
	 */
	public Long getFromPaymentDate() {
		return fromPaymentDate;
	}

	/**
	 * Set the value of property {@code fromPaymentDate}.
	 *
	 * @param fromPaymentDate the fromPaymentDate
	 */
	public void setFromPaymentDate(Long fromPaymentDate) {
		this.fromPaymentDate = fromPaymentDate;
	}

	/**
	 * Get the value of property {@code toPaymentDate}.
	 *
	 * @return the toPaymentDate
	 */
	public Long getToPaymentDate() {
		return toPaymentDate;
	}

	/**
	 * Set the value of property {@code toPaymentDate}.
	 *
	 * @param toPaymentDate the toPaymentDate
	 */
	public void setToPaymentDate(Long toPaymentDate) {
		this.toPaymentDate = toPaymentDate;
	}
	
	//


	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type 
	 * @return this
	 */
	public PaymentFilter withType(PaymentType type) {
		this.type = type;
		return this;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the status 
	 * @return this
	 */
	public PaymentFilter withStatus(PaymentStatus... status) {
		this.status = new ArrayList<>(Arrays.asList(status));
		return this;
	}

	/**
	 * Set the value of property {@code status}.
	 *
	 * @param status the status 
	 * @return this
	 */
	public PaymentFilter withStatus(List<PaymentStatus> status) {
		this.status = status;
		return this;
	}

	/**
	 * Set the value of property {@code transferStatus}.
	 *
	 * @param transferStatus the transferStatus 
	 * @return this
	 */
	public PaymentFilter withTransferStatus(PaymentStatus... transferStatus) {
		this.transferStatus = new ArrayList<>(Arrays.asList(transferStatus));
		return this;
	}


	/**
	 * Set the value of property {@code buyers}.
	 *
	 * @param buyers the buyers 
	 * @return this
	 */
	public PaymentFilter withBuyers(List<String> buyers) {
		this.buyers = buyers;
		return this;
	}

	/**
	 * Set the value of property {@code buyers}.
	 *
	 * @param buyers the buyers 
	 * @return this
	 */
	public PaymentFilter withBuyers(String... buyers) {
		if (this.buyers==null) {
			this.buyers = new ArrayList<>();
		}
		this.buyers.addAll(Arrays.asList(buyers));
		return this;
	}

	/**
	 * Set the value of property {@code sellers}.
	 *
	 * @param sellers the sellers 
	 * @return this
	 */
	public PaymentFilter withSellers(List<String> sellers) {
		this.sellers = sellers;
		return this;
	}
	
	/**
	 * Set the value of property {@code sellers}.
	 *
	 * @param sellers the sellers 
	 * @return this
	 */
	public PaymentFilter withSellers(String... sellers) {
		if (this.sellers==null) {
			this.sellers = new ArrayList<>();
		}
		this.sellers.addAll(Arrays.asList(sellers));
		return this;
	}

	/**
	 * Set the value of property {@code isBuyer}.
	 *
	 * @param buyer the buyer 
	 * @return this
	 */
	public PaymentFilter withBuyer(Boolean buyer) {
		this.buyer = buyer;
		return this;
	}

	/**
	 * Set the value of property {@code isSeller}.
	 *
	 * @param seller the seller 
	 * @return this
	 */
	public PaymentFilter withSeller(Boolean seller) {
		this.seller = seller;
		return this;
	}

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the q 
	 * @return this
	 */
	public PaymentFilter withQ(String q) {
		this.q = q;
		return this;		
	}


	/**
	 * Set the value of property {@code owner}.
	 *
	 * @param owner the owner 
	 * @return this
	 */
	public PaymentFilter withOwner(String owner) {
		this.owner = owner;
		return this;		
	}

	/**
	 * Set the value of property {@code account}.
	 *
	 * @param account the account to with
	 * @return this
	 */
	public PaymentFilter withAccount(String account) {
		this.account = account;
		return this;		
	}
	
	/**
	 * Set the value of property {@code fromCreationDate}.
	 *
	 * @param fromCreationDate the fromCreationDate 
	 * @return this
	 */
	public PaymentFilter withFromCreationDate(Long fromCreationDate) {
		this.fromCreationDate = fromCreationDate;
		return this;
	}

	/**
	 * Set the value of property {@code toCreationDate}.
	 *
	 * @param toCreationDate the toCreationDate 
	 * @return this
	 */
	public PaymentFilter withToCreationDate(Long toCreationDate) {
		this.toCreationDate = toCreationDate;
		return this;
	}


	/**
	 * Set the value of property {@code fromPaymentDate}.
	 *
	 * @param fromPaymentDate the fromPaymentDate 
	 * @return this
	 */
	public PaymentFilter withFromPaymentDate(Long fromPaymentDate) {
		this.fromPaymentDate = fromPaymentDate;
		return this;
	}

	/**
	 * Set the value of property {@code toPaymentDate}.
	 *
	 * @param toPaymentDate the toPaymentDate 
	 * @return this
	 */
	public PaymentFilter withToPaymentDate(Long toPaymentDate) {
		this.toPaymentDate = toPaymentDate;
		return this;
	}

	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator
				.append("type", type)
				.append("status", status)
				.append("transferStatus", transferStatus)
				.append("q", q)
				.append("owner", owner)
				.append("account", account)
				.append("buyer", buyer)
				.append("seller", seller)
				.append("buyers", buyers)
				.append("sellers", sellers)
				.append("fromCreationDate", fromCreationDate)
				.append("toCreationDate", toCreationDate)
				.append("fromPaymentDate", fromPaymentDate)
				.append("toPaymentDate", toPaymentDate)
				);
	}
}
