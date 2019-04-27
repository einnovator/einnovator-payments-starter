package org.einnovator.payments.client.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
	private String id;
	
	private String username;

	private String email;

	private String title;

	private String name;

	private String logo; // biz logo or user avatar URL

	private String avatarURL;
	
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
	
	public Account() {
	}
	
	public Account(String id) {
		super();
		this.id = id;
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public String getAvatarURL() {
		return avatarURL;
	}

	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}

	public String getProfileURL() {
		return profileURL;
	}

	public void setProfileURL(String profileURL) {
		this.profileURL = profileURL;
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

	public String getLegalNameKana() {
		return legalNameKana;
	}

	public void setLegalNameKana(String legalNameKana) {
		this.legalNameKana = legalNameKana;
	}

	public String getLegalNameKanji() {
		return legalNameKanji;
	}

	public void setLegalNameKanji(String legalNameKanji) {
		this.legalNameKanji = legalNameKanji;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
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

	public Address getAddressKana() {
		return addressKana;
	}

	public void setAddressKana(Address addressKana) {
		this.addressKana = addressKana;
	}

	public Address getAddressKanji() {
		return addressKanji;
	}

	public void setAddressKanji(Address addressKanji) {
		this.addressKanji = addressKanji;
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

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getFirstNameKanji() {
		return firstNameKanji;
	}

	public void setFirstNameKanji(String firstNameKanji) {
		this.firstNameKanji = firstNameKanji;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastNameKana() {
		return lastNameKana;
	}

	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}

	public String getLastNameKanji() {
		return lastNameKanji;
	}

	public void setLastNameKanji(String lastNameKanji) {
		this.lastNameKanji = lastNameKanji;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Account [" + (id != null ? "id=" + id + ", " : "")
				+ (username != null ? "username=" + username + ", " : "")
				+ (email != null ? "email=" + email + ", " : "")
				+ (title != null ? "title=" + title + ", " : "")
				+ (name != null ? "name=" + name + ", " : "")				
				+ (logo != null ? "logo=" + logo + ", " : "") + (color != null ? "color=" + color + ", " : "")
				+ (legalName != null ? "legalName=" + legalName + ", " : "")
				+ (legalNameKana != null ? "legalNameKana=" + legalNameKana + ", " : "")
				+ (legalNameKanji != null ? "legalNameKanji=" + legalNameKanji + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (mobilePhone != null ? "mobilePhone=" + mobilePhone + ", " : "")
				+ (phone != null ? "phone=" + phone + ", " : "")
				+ (website != null ? "website=" + website + ", " : "")
				+ (currency != null ? "currency=" + currency + ", " : "")
				+ (taxNumber != null ? "taxNumber=" + taxNumber + ", " : "")
				+ (vatNumber != null ? "vatNumber=" + vatNumber + ", " : "")
				+ (taxRegistrar != null ? "taxRegistrar=" + taxRegistrar + ", " : "")
				+ (address != null ? "address=" + address + ", " : "")
				+ (addressKana != null ? "addressKana=" + addressKana + ", " : "")
				+ (addressKanji != null ? "addressKanji=" + addressKanji + ", " : "")
				+ (birthdate != null ? "birthdate=" + birthdate + ", " : "") + (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (firstNameKana != null ? "firstNameKana=" + firstNameKana + ", " : "")
				+ (firstNameKanji != null ? "firstNameKanji=" + firstNameKanji + ", " : "")
				+ (lastName != null ? "lastName=" + lastName + ", " : "")
				+ (lastNameKana != null ? "lastNameKana=" + lastNameKana + ", " : "")
				+ (lastNameKanji != null ? "lastNameKanji=" + lastNameKanji + ", " : "")
				+ (gender != null ? "gender=" + gender + ", " : "") 
				+ (ownerId != null ? "ownerId=" + ownerId : "")
				+ "]";
	}

}
