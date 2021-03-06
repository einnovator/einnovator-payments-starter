package org.einnovator.payments.client.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.einnovator.util.model.Address;
import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.OwnerType;
import org.einnovator.util.model.Phone;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account extends EntityBase {


	public static final String ROLE_ACCOUNT_MANAGER = "ACCOUNT_MANAGER";
	public static final String ROLE_ACCOUNT_AUDITOR = "ACCOUNT_AUDITOR";
	public static final String ROLE_PAYMENTS_MANAGER = "PAYMENTS_MANAGER";
	public static final String ROLE_PAYMENTS_AUDITOR = "PAYMENTS_AUDITOR";
	public static final String ROLE_SALES_MANAGER = "SALES_MANAGER";
	public static final String ROLE_SALES_AUDITOR = "SALES_AUDITOR";
	
	private OwnerType type;
	
	private String owner;

	private String username;

	private String name;
	
	private String email;

	private String title;

	private String avatar;
	
	private String color;

	private String legalName;

	private String legalName2;

	private String legalName3;

	private String description;

	private Phone phone;
	
	private Phone mobilePhone;
	
	private String website;
	
	private Currency currency;
	
	private String taxNumber;

	private String ssn;

	private String personalIdNumber;

	private String document;

	private String vatNumber;

	private String taxRegistrar;

	private Address address;

	private Address personalAddress;

	private Address address3;

	private Date birthdate;

	private String firstName;

	private String firstName2;

	private String firstName3;

	private String lastName;

	private String lastName2;

	private String lastName3;

	private List<Card> cards = new ArrayList<>();

	private List<BankAccount> bankAccounts = new ArrayList<>();

	private Boolean seller;
	
	private Boolean transferEnabled;

	public Account() {
	}
	
	public Account(String id) {
		this.id = id;
	}

	public Account(Object obj) {
		super(obj);
	}

	
	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public OwnerType getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type
	 */
	public void setType(OwnerType type) {
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
	 * @param owner the owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Get the value of property {@code username}.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set the value of property {@code username}.
	 *
	 * @param username the username
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * Get the value of property {@code email}.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the value of property {@code email}.
	 *
	 * @param email the email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the value of property {@code title}.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the value of property {@code title}.
	 *
	 * @param title the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the value of property {@code avatar}.
	 *
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * Set the value of property {@code avatar}.
	 *
	 * @param avatar the avatar
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * Get the value of property {@code color}.
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Set the value of property {@code color}.
	 *
	 * @param color the color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Get the value of property {@code legalName}.
	 *
	 * @return the legalName
	 */
	public String getLegalName() {
		return legalName;
	}

	/**
	 * Set the value of property {@code legalName}.
	 *
	 * @param legalName the legalName
	 */
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	/**
	 * Get the value of property {@code legalName2}.
	 *
	 * @return the legalName2
	 */
	public String getLegalName2() {
		return legalName2;
	}

	/**
	 * Set the value of property {@code legalName2}.
	 *
	 * @param legalName2 the legalName2
	 */
	public void setLegalName2(String legalName2) {
		this.legalName2 = legalName2;
	}

	/**
	 * Get the value of property {@code legalName3}.
	 *
	 * @return the legalName3
	 */
	public String getLegalName3() {
		return legalName3;
	}

	/**
	 * Set the value of property {@code legalName3}.
	 *
	 * @param legalName3 the legalName3
	 */
	public void setLegalName3(String legalName3) {
		this.legalName3 = legalName3;
	}

	/**
	 * Get the value of property {@code description}.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the value of property {@code description}.
	 *
	 * @param description the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the value of property {@code phone}.
	 *
	 * @return the phone
	 */
	public Phone getPhone() {
		return phone;
	}

	/**
	 * Set the value of property {@code phone}.
	 *
	 * @param phone the phone
	 */
	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	/**
	 * Get the value of property {@code mobilePhone}.
	 *
	 * @return the mobilePhone
	 */
	public Phone getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * Set the value of property {@code mobilePhone}.
	 *
	 * @param mobilePhone the mobilePhone
	 */
	public void setMobilePhone(Phone mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * Get the value of property {@code website}.
	 *
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * Set the value of property {@code website}.
	 *
	 * @param website the website
	 */
	public void setWebsite(String website) {
		this.website = website;
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
	 * Get the value of property {@code taxNumber}.
	 *
	 * @return the taxNumber
	 */
	public String getTaxNumber() {
		return taxNumber;
	}

	/**
	 * Set the value of property {@code taxNumber}.
	 *
	 * @param taxNumber the taxNumber
	 */
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	/**
	 * Get the value of property {@code ssn}.
	 *
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * Set the value of property {@code ssn}.
	 *
	 * @param ssn the ssn
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * Get the value of property {@code personalIdNumber}.
	 *
	 * @return the personalIdNumber
	 */
	public String getPersonalIdNumber() {
		return personalIdNumber;
	}

	/**
	 * Set the value of property {@code personalIdNumber}.
	 *
	 * @param personalIdNumber the personalIdNumber
	 */
	public void setPersonalIdNumber(String personalIdNumber) {
		this.personalIdNumber = personalIdNumber;
	}

	/**
	 * Get the value of property {@code document}.
	 *
	 * @return the document
	 */
	public String getDocument() {
		return document;
	}

	/**
	 * Set the value of property {@code document}.
	 *
	 * @param document the document
	 */
	public void setDocument(String document) {
		this.document = document;
	}

	/**
	 * Get the value of property {@code vatNumber}.
	 *
	 * @return the vatNumber
	 */
	public String getVatNumber() {
		return vatNumber;
	}

	/**
	 * Set the value of property {@code vatNumber}.
	 *
	 * @param vatNumber the vatNumber
	 */
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	/**
	 * Get the value of property {@code taxRegistrar}.
	 *
	 * @return the taxRegistrar
	 */
	public String getTaxRegistrar() {
		return taxRegistrar;
	}

	/**
	 * Set the value of property {@code taxRegistrar}.
	 *
	 * @param taxRegistrar the taxRegistrar
	 */
	public void setTaxRegistrar(String taxRegistrar) {
		this.taxRegistrar = taxRegistrar;
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
	 * Get the value of property {@code personalAddress}.
	 *
	 * @return the personalAddress
	 */
	public Address getPersonalAddress() {
		return personalAddress;
	}

	/**
	 * Set the value of property {@code personalAddress}.
	 *
	 * @param personalAddress the personalAddress
	 */
	public void setPersonalAddress(Address personalAddress) {
		this.personalAddress = personalAddress;
	}

	/**
	 * Get the value of property {@code address3}.
	 *
	 * @return the address3
	 */
	public Address getAddress3() {
		return address3;
	}

	/**
	 * Set the value of property {@code address3}.
	 *
	 * @param address3 the address3
	 */
	public void setAddress3(Address address3) {
		this.address3 = address3;
	}

	/**
	 * Get the value of property {@code birthdate}.
	 *
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * Set the value of property {@code birthdate}.
	 *
	 * @param birthdate the birthdate
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * Get the value of property {@code firstName}.
	 *
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set the value of property {@code firstName}.
	 *
	 * @param firstName the firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get the value of property {@code firstName2}.
	 *
	 * @return the firstName2
	 */
	public String getFirstName2() {
		return firstName2;
	}

	/**
	 * Set the value of property {@code firstName2}.
	 *
	 * @param firstName2 the firstName2
	 */
	public void setFirstName2(String firstName2) {
		this.firstName2 = firstName2;
	}

	/**
	 * Get the value of property {@code firstName3}.
	 *
	 * @return the firstName3
	 */
	public String getFirstName3() {
		return firstName3;
	}

	/**
	 * Set the value of property {@code firstName3}.
	 *
	 * @param firstName3 the firstName3
	 */
	public void setFirstName3(String firstName3) {
		this.firstName3 = firstName3;
	}

	/**
	 * Get the value of property {@code lastName}.
	 *
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set the value of property {@code lastName}.
	 *
	 * @param lastName the lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get the value of property {@code lastName2}.
	 *
	 * @return the lastName2
	 */
	public String getLastName2() {
		return lastName2;
	}

	/**
	 * Set the value of property {@code lastName2}.
	 *
	 * @param lastName2 the lastName2
	 */
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	/**
	 * Get the value of property {@code lastName3}.
	 *
	 * @return the lastName3
	 */
	public String getLastName3() {
		return lastName3;
	}

	/**
	 * Set the value of property {@code lastName3}.
	 *
	 * @param lastName3 the lastName3
	 */
	public void setLastName3(String lastName3) {
		this.lastName3 = lastName3;
	}

	/**
	 * Get the value of property {@code cards}.
	 *
	 * @return the cards
	 */
	public List<Card> getCards() {
		return cards;
	}

	/**
	 * Set the value of property {@code cards}.
	 *
	 * @param cards the cards
	 */
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	/**
	 * Get the value of property {@code bankAccounts}.
	 *
	 * @return the bankAccounts
	 */
	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	/**
	 * Set the value of property {@code bankAccounts}.
	 *
	 * @param bankAccounts the bankAccounts
	 */
	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
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
	 * Get the value of property {@code transferEnabled}.
	 *
	 * @return the transferEnabled
	 */
	public Boolean getTransferEnabled() {
		return transferEnabled;
	}

	/**
	 * Set the value of property {@code transferEnabled}.
	 *
	 * @param transferEnabled the transferEnabled
	 */
	public void setTransferEnabled(Boolean transferEnabled) {
		this.transferEnabled = transferEnabled;
	}

	// With
	
	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of property type
	 */
	public Account withType(OwnerType type) {
		this.type = type;
		return this;
	}

	/**
	 * Set the value of property {@code owner}.
	 *
	 * @param owner the value of property owner
	 */
	public Account withOwner(String owner) {
		this.owner = owner;
		return this;
	}

	/**
	 * Set the value of property {@code username}.
	 *
	 * @param username the value of property username
	 */
	public Account withUsername(String username) {
		this.username = username;
		return this;
	}

	/**
	 * Set the value of property {@code name}.
	 *
	 * @param name the value of property name
	 */
	public Account withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Set the value of property {@code email}.
	 *
	 * @param email the value of property email
	 */
	public Account withEmail(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Set the value of property {@code title}.
	 *
	 * @param title the value of property title
	 */
	public Account withTitle(String title) {
		this.title = title;
		return this;
	}

	/**
	 * Set the value of property {@code avatar}.
	 *
	 * @param avatar the value of property avatar
	 */
	public Account withAvatar(String avatar) {
		this.avatar = avatar;
		return this;
	}

	/**
	 * Set the value of property {@code color}.
	 *
	 * @param color the value of property color
	 */
	public Account withColor(String color) {
		this.color = color;
		return this;
	}

	/**
	 * Set the value of property {@code legalName}.
	 *
	 * @param legalName the value of property legalName
	 */
	public Account withLegalName(String legalName) {
		this.legalName = legalName;
		return this;
	}

	/**
	 * Set the value of property {@code legalName2}.
	 *
	 * @param legalName2 the value of property legalName2
	 */
	public Account withLegalName2(String legalName2) {
		this.legalName2 = legalName2;
		return this;
	}

	/**
	 * Set the value of property {@code legalName3}.
	 *
	 * @param legalName3 the value of property legalName3
	 */
	public Account withLegalName3(String legalName3) {
		this.legalName3 = legalName3;
		return this;
	}

	/**
	 * Set the value of property {@code description}.
	 *
	 * @param description the value of property description
	 */
	public Account withDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Set the value of property {@code phone}.
	 *
	 * @param phone the value of property phone
	 */
	public Account withPhone(Phone phone) {
		this.phone = phone;
		return this;
	}

	/**
	 * Set the value of property {@code mobilePhone}.
	 *
	 * @param mobilePhone the value of property mobilePhone
	 */
	public Account withMobilePhone(Phone mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	/**
	 * Set the value of property {@code website}.
	 *
	 * @param website the value of property website
	 */
	public Account withWebsite(String website) {
		this.website = website;
		return this;
	}

	/**
	 * Set the value of property {@code currency}.
	 *
	 * @param currency the value of property currency
	 */
	public Account withCurrency(Currency currency) {
		this.currency = currency;
		return this;
	}

	/**
	 * Set the value of property {@code taxNumber}.
	 *
	 * @param taxNumber the value of property taxNumber
	 */
	public Account withTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
		return this;
	}

	/**
	 * Set the value of property {@code ssn}.
	 *
	 * @param ssn the value of property ssn
	 */
	public Account withSsn(String ssn) {
		this.ssn = ssn;
		return this;
	}

	/**
	 * Set the value of property {@code personalIdNumber}.
	 *
	 * @param personalIdNumber the value of property personalIdNumber
	 */
	public Account withPersonalIdNumber(String personalIdNumber) {
		this.personalIdNumber = personalIdNumber;
		return this;
	}

	/**
	 * Set the value of property {@code document}.
	 *
	 * @param document the value of property document
	 */
	public Account withDocument(String document) {
		this.document = document;
		return this;
	}

	/**
	 * Set the value of property {@code vatNumber}.
	 *
	 * @param vatNumber the value of property vatNumber
	 */
	public Account withVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
		return this;
	}

	/**
	 * Set the value of property {@code taxRegistrar}.
	 *
	 * @param taxRegistrar the value of property taxRegistrar
	 */
	public Account withTaxRegistrar(String taxRegistrar) {
		this.taxRegistrar = taxRegistrar;
		return this;
	}

	/**
	 * Set the value of property {@code address}.
	 *
	 * @param address the value of property address
	 */
	public Account withAddress(Address address) {
		this.address = address;
		return this;
	}

	/**
	 * Set the value of property {@code personalAddress}.
	 *
	 * @param personalAddress the value of property personalAddress
	 */
	public Account withPersonalAddress(Address personalAddress) {
		this.personalAddress = personalAddress;
		return this;
	}

	/**
	 * Set the value of property {@code address3}.
	 *
	 * @param address3 the value of property address3
	 */
	public Account withAddress3(Address address3) {
		this.address3 = address3;
		return this;
	}

	/**
	 * Set the value of property {@code birthdate}.
	 *
	 * @param birthdate the value of property birthdate
	 */
	public Account withBirthdate(Date birthdate) {
		this.birthdate = birthdate;
		return this;
	}

	/**
	 * Set the value of property {@code firstName}.
	 *
	 * @param firstName the value of property firstName
	 */
	public Account withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * Set the value of property {@code firstName2}.
	 *
	 * @param firstName2 the value of property firstName2
	 */
	public Account withFirstName2(String firstName2) {
		this.firstName2 = firstName2;
		return this;
	}

	/**
	 * Set the value of property {@code firstName3}.
	 *
	 * @param firstName3 the value of property firstName3
	 */
	public Account withFirstName3(String firstName3) {
		this.firstName3 = firstName3;
		return this;
	}

	/**
	 * Set the value of property {@code lastName}.
	 *
	 * @param lastName the value of property lastName
	 */
	public Account withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * Set the value of property {@code lastName2}.
	 *
	 * @param lastName2 the value of property lastName2
	 */
	public Account withLastName2(String lastName2) {
		this.lastName2 = lastName2;
		return this;
	}

	/**
	 * Set the value of property {@code lastName3}.
	 *
	 * @param lastName3 the value of property lastName3
	 */
	public Account withLastName3(String lastName3) {
		this.lastName3 = lastName3;
		return this;
	}

	/**
	 * Set the value of property {@code cards}.
	 *
	 * @param cards the value of property cards
	 */
	public Account withCards(List<Card> cards) {
		this.cards = cards;
		return this;
	}

	/**
	 * Set the value of property {@code bankAccounts}.
	 *
	 * @param bankAccounts the value of property bankAccounts
	 */
	public Account withBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
		return this;
	}

	/**
	 * Set the value of property {@code seller}.
	 *
	 * @param seller the value of property seller
	 */
	public Account withSeller(Boolean seller) {
		this.seller = seller;
		return this;
	}

	/**
	 * Set the value of property {@code transferEnabled}.
	 *
	 * @param transferEnabled the value of property transferEnabled
	 */
	public Account withTransferEnabled(Boolean transferEnabled) {
		this.transferEnabled = transferEnabled;
		return this;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("type", type)
				.append("owner", owner)
				.append("username", username)
				.append("name", name)
				.append("currency", currency)
				.append("email", email)
				.append("title", title)
				.append("color", color)
				.append("email", email)
				.append("seller", seller)			
				.append("title", title)
				.append("color", color)
				.append("name", name)
				.append("phone", phone)
				.append("mobilePhone", mobilePhone)
				.append("website", website)
				.append("taxNumber", taxNumber)
				.append("firstName", firstName)
				.append("lastName", lastName)
				.append("avatar", avatar)
				.append("cards", cards)
				.append("bankAccounts", bankAccounts)
				.append("description", description)
				;
	}
	


}
