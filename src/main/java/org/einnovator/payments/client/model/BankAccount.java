package org.einnovator.payments.client.model;

import org.einnovator.util.model.Address;
import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.OwnerType;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankAccount extends EntityBase {

	private OwnerType holderType;
	
	private String number;

	private String name;

	private Currency currency;
	
	private String routingNumber;

	private String bankName;

	private Address address = new Address();

	private Boolean defaultTransferAccount;
	
	private Boolean defaultChargeAccount;

	/**
	 * Get the value of property {@code holderType}.
	 *
	 * @return the holderType
	 */
	public OwnerType getHolderType() {
		return holderType;
	}

	/**
	 * Set the value of property {@code holderType}.
	 *
	 * @param holderType the holderType
	 */
	public void setHolderType(OwnerType holderType) {
		this.holderType = holderType;
	}

	/**
	 * Get the value of property {@code number}.
	 *
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Set the value of property {@code number}.
	 *
	 * @param number the number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Get the value of property {@code name}.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * Get the value of property {@code routingNumber}.
	 *
	 * @return the routingNumber
	 */
	public String getRoutingNumber() {
		return routingNumber;
	}

	/**
	 * Set the value of property {@code routingNumber}.
	 *
	 * @param routingNumber the routingNumber
	 */
	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	/**
	 * Get the value of property {@code bankName}.
	 *
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * Set the value of property {@code bankName}.
	 *
	 * @param bankName the bankName
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * Get the value of property {@code address}.
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Set the value of property {@code address}.
	 *
	 * @param address the address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Get the value of property {@code defaultTransferAccount}.
	 *
	 * @return the defaultTransferAccount
	 */
	public Boolean getDefaultTransferAccount() {
		return defaultTransferAccount;
	}

	/**
	 * Set the value of property {@code defaultTransferAccount}.
	 *
	 * @param defaultTransferAccount the defaultTransferAccount
	 */
	public void setDefaultTransferAccount(Boolean defaultTransferAccount) {
		this.defaultTransferAccount = defaultTransferAccount;
	}

	/**
	 * Get the value of property {@code defaultChargeAccount}.
	 *
	 * @return the defaultChargeAccount
	 */
	public Boolean getDefaultChargeAccount() {
		return defaultChargeAccount;
	}

	/**
	 * Set the value of property {@code defaultChargeAccount}.
	 *
	 * @param defaultChargeAccount the defaultChargeAccount
	 */
	public void setDefaultChargeAccount(Boolean defaultChargeAccount) {
		this.defaultChargeAccount = defaultChargeAccount;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("number", number)
				.append("name", name)
				.append("holderType", holderType)
				.append("currency", currency)
				.append("routingNumber", routingNumber)
				.append("bankName", bankName)
				.append("address", address)
				;
	}

}
