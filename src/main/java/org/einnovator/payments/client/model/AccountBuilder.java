package org.einnovator.payments.client.model;

import java.util.Date;

public class AccountBuilder {

	private String id;
	
	private String username;

	private String email;

	private String title;

	private String name;
	
	private String avatarURL;

	private String logo; // biz logo or user avatar URL

	private String color;

	private String legalName;

	private String legalNameKana;

	private String legalNameKanji;

	private String description;

	private String phone;
	
	private String mobilePhone;

	private String website;

	private String profileURL;

	private Currency currency;
	
	private String taxNumber;

	private String vatNumber;

	private String taxRegistrar;

	private Address address;

	private Address addressKana;

	private Address addressKanji;

	private Date birthdate;

	private String firstName;

	private String firstNameKana;

	private String firstNameKanji;

	private String lastName;

	private String lastNameKana;

	private String lastNameKanji;

	private GenderType gender;

	private String ownerId;

	private AccountType type;

	public AccountBuilder() {
	}
	
	public AccountBuilder id(String id) {
		this.id = id;
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

	public AccountBuilder logo(String logo) {
		this.logo = logo;
		return this;
	}
	
	public AccountBuilder avatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
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

	public AccountBuilder legalNameKana(String legalNameKana) {
		this.legalNameKana = legalNameKana;
		return this;
	}

	public AccountBuilder legalNameKanji(String legalNameKanji) {
		this.legalNameKanji = legalNameKanji;
		return this;
	}

	public AccountBuilder description(String description) {
		this.description = description;
		return this;
	}

	public AccountBuilder phone(String phone) {
		this.phone = phone;
		return this;
	}
	
	public AccountBuilder mobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public AccountBuilder website(String website) {
		this.website = website;
		return this;
	}
	
	public AccountBuilder profileURL(String profileURL) {
		this.profileURL = profileURL;
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

	public AccountBuilder addressKana(Address addressKana) {
		this.addressKana = addressKana;
		return this;
	}

	public AccountBuilder addressKanji(Address addressKanji) {
		this.addressKanji = addressKanji;
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

	public AccountBuilder firstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
		return this;
	}

	public AccountBuilder firstNameKanji(String firstNameKanji) {
		this.firstNameKanji = firstNameKanji;
		return this;
	}

	public AccountBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public AccountBuilder lastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
		return this;
	}

	public AccountBuilder lastNameKanji(String lastNameKanji) {
		this.lastNameKanji = lastNameKanji;
		return this;
	}

	public AccountBuilder gender(GenderType gender) {
		this.gender = gender;
		return this;

	}

	public AccountBuilder ownerId(String ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public AccountBuilder type(AccountType type) {
		this.type = type;
		return this;
	}

	public Account build() {
		Account account = new Account();
		account.setId(id);
		account.setUsername(username);
		account.setEmail(email);
		account.setTitle(title);
		account.setName(name);
		account.setAvatarURL(avatarURL);
		account.setLogo(logo);
		account.setColor(color);
		account.setLegalName(legalName);
		account.setLegalNameKana(legalNameKana);
		account.setLegalNameKanji(legalNameKanji);
		account.setDescription(description);
		account.setMobilePhone(mobilePhone);
		account.setPhone(phone);
		account.setWebsite(website);
		account.setProfileURL(profileURL);
		account.setCurrency(currency);
		account.setTaxNumber(taxNumber);
		account.setVatNumber(vatNumber);
		account.setTaxRegistrar(taxRegistrar);
		account.setAddress(address);
		account.setAddressKana(addressKana);
		account.setAddressKanji(addressKanji);
		account.setBirthdate(birthdate);
		account.setFirstName(firstName);
		account.setFirstNameKana(firstNameKana);
		account.setFirstNameKanji(firstNameKanji);
		account.setLastName(lastName);
		account.setLastNameKana(lastNameKana);
		account.setLastNameKanji(lastNameKanji);
		account.setGender(gender);
		account.setOwnerId(ownerId);
		account.setType(type);
		return account;
	}

}
