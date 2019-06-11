package org.einnovator.payments.client.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.einnovator.util.model.Address;
import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.Phone;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account extends EntityBase {

	private AccountType type;
	
	private String owner;

	private String username;

	private String email;

	private String title;

	private String name;

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

	private String vatNumber;

	private String taxRegistrar;

	private Address address;

	private Address address2;

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

	public Account() {
	}
	
	public Account(String id) {
		this.id = id;
	}

	public Account(Object obj) {
		super(obj);
	}

	public AccountType getType() {
		return type;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public void setType(AccountType type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getLegalName2() {
		return legalName2;
	}

	public void setLegalName2(String legalName2) {
		this.legalName2 = legalName2;
	}

	public String getLegalName3() {
		return legalName3;
	}

	public void setLegalName3(String legalName3) {
		this.legalName3 = legalName3;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	
	public Phone getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(Phone mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public String getTaxRegistrar() {
		return taxRegistrar;
	}

	public void setTaxRegistrar(String taxRegistrar) {
		this.taxRegistrar = taxRegistrar;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress2() {
		return address2;
	}

	public void setAddress2(Address address2) {
		this.address2 = address2;
	}

	public Address getAddress3() {
		return address3;
	}

	public void setAddress3(Address address3) {
		this.address3 = address3;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName2() {
		return firstName2;
	}

	public void setFirstName2(String firstName2) {
		this.firstName2 = firstName2;
	}

	public String getFirstName3() {
		return firstName3;
	}

	public void setFirstName3(String firstName3) {
		this.firstName3 = firstName3;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName2() {
		return lastName2;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	public String getLastName3() {
		return lastName3;
	}

	public void setLastName3(String lastName3) {
		this.lastName3 = lastName3;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("type", type)
				.append("owner", owner)
				.append("username", username)
				.append("email", email)
				.append("title", title)
				.append("color", color)
				.append("name", name)
				.append("phone", phone)
				.append("mobilePhone", mobilePhone)
				.append("website", website)
				.append("currency", currency)
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
