package org.einnovator.payments.client.model;

import java.util.Date;

import org.einnovator.util.model.Address;
import org.einnovator.util.model.OwnerType;
import org.einnovator.util.model.Phone;

public class AccountBuilder {

	private String id;

	private String uuid;

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

	private Address personalAddress;

	private Address address3;

	private Date birthdate;

	private String firstName;

	private String firstName2;

	private String firstName3;

	private String lastName;

	private String lastName2;

	private String lastName3;

	private String owner;

	private OwnerType type;

	public AccountBuilder() {
	}
	
	public AccountBuilder id(String id) {
		this.id = id;
		return this;
	}
	
	public AccountBuilder uuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	public AccountBuilder name(String name) {
		this.name = name;
		return this;
	}

	public AccountBuilder username(String username) {
		this.username = username;
		return this;
	}
	public AccountBuilder email(String email) {
		this.email = email;
		return this;
	}
	public AccountBuilder title(String title) {
		this.title = title;
		return this;
	}

	public AccountBuilder avatar(String avatar) {
		this.avatar = avatar;
		return this;
	}

	public AccountBuilder color(String color) {
		this.color = color;
		return this;
	}

	public AccountBuilder legalName(String legalName) {
		this.legalName = legalName;
		return this;
	}

	public AccountBuilder legalName2(String legalName2) {
		this.legalName2 = legalName2;
		return this;
	}

	public AccountBuilder legalName3(String legalName3) {
		this.legalName3 = legalName3;
		return this;
	}

	public AccountBuilder description(String description) {
		this.description = description;
		return this;
	}

	public AccountBuilder phone(Phone phone) {
		this.phone = phone;
		return this;
	}
	
	public AccountBuilder mobilePhone(Phone mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public AccountBuilder website(String website) {
		this.website = website;
		return this;
	}
	
	public AccountBuilder currency(Currency currency) {
		this.currency = currency;
		return this;
	}

	public AccountBuilder taxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
		return this;
	}

	public AccountBuilder vatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
		return this;
	}

	public AccountBuilder taxRegistrar(String taxRegistrar) {
		this.taxRegistrar = taxRegistrar;
		return this;
	}

	public AccountBuilder address(Address address) {
		this.address = address;
		return this;
	}

	public AccountBuilder personalAddress(Address personalAddress) {
		this.personalAddress = personalAddress;
		return this;
	}

	public AccountBuilder address3(Address address3) {
		this.address3 = address3;
		return this;
	}

	public AccountBuilder birthdate(Date birthdate) {
		this.birthdate = birthdate;
		return this;
	}

	public AccountBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public AccountBuilder firstName2(String firstName2) {
		this.firstName2 = firstName2;
		return this;
	}

	public AccountBuilder firstName3(String firstName3) {
		this.firstName3 = firstName3;
		return this;
	}

	public AccountBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public AccountBuilder lastName2(String lastName2) {
		this.lastName2 = lastName2;
		return this;
	}

	public AccountBuilder lastName3(String lastName3) {
		this.lastName3 = lastName3;
		return this;
	}

	public AccountBuilder owner(String owner) {
		this.owner = owner;
		return this;
	}

	public AccountBuilder type(OwnerType type) {
		this.type = type;
		return this;
	}

	public Account build() {
		Account account = new Account();
		account.setId(id);
		account.setType(type);
		account.setUuid(uuid);
		account.setOwner(owner);
		account.setUsername(username);
		account.setEmail(email);
		account.setTitle(title);
		account.setName(name);
		account.setAvatar(avatar);
		account.setColor(color);
		account.setLegalName(legalName);
		account.setLegalName2(legalName2);
		account.setLegalName3(legalName3);
		account.setDescription(description);
		account.setMobilePhone(mobilePhone);
		account.setPhone(phone);
		account.setWebsite(website);
		account.setCurrency(currency);
		account.setTaxNumber(taxNumber);
		account.setVatNumber(vatNumber);
		account.setTaxRegistrar(taxRegistrar);
		account.setAddress(address);
		account.setPersonalAddress(personalAddress);
		account.setAddress3(address3);
		account.setBirthdate(birthdate);
		account.setFirstName(firstName);
		account.setFirstName2(firstName2);
		account.setFirstName3(firstName3);
		account.setLastName(lastName);
		account.setLastName2(lastName2);
		account.setLastName3(lastName3);
		return account;
	}

}
