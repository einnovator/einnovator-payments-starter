package org.einnovator.payments.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.net.URI;
import java.util.GregorianCalendar;
import java.util.UUID;

import org.einnovator.payments.client.PaymentsClient;
import org.einnovator.payments.client.config.PaymentsClientConfig;
import org.einnovator.payments.client.model.Account;
import org.einnovator.payments.client.model.AccountBuilder;
import org.einnovator.payments.client.model.Address;
import org.einnovator.payments.client.model.AddressBuilder;
import org.einnovator.payments.client.model.CardType;
import org.einnovator.payments.client.model.CreditCard;
import org.einnovator.payments.client.model.CreditCardBuilder;
import org.einnovator.payments.client.model.Currency;
import org.einnovator.payments.client.model.MonetaryAmount;
import org.einnovator.payments.client.model.Payable;
import org.einnovator.payments.client.model.PayableBuilder;
import org.einnovator.payments.client.model.Payment;
import org.einnovator.payments.client.model.PaymentBuilder;
import org.einnovator.sso.client.support.SsoTestHelper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import org.einnovator.util.UriUtils;



@RunWith(SpringRunner.class)
@SpringBootTest(classes= {PaymentsClientTests.TestConfig.class, PaymentsClientConfig.class}, webEnvironment=WebEnvironment.MOCK)
public class PaymentsClientTests extends SsoTestHelper {

	@Autowired
	PaymentsClient client;

	public static final String GREENFENCE = "greenfence";
	public static final String GREENFENCE_EMAIL = "greenfence@test.com";
	public static final String AUDITONE = "auditOne";
	public static final String AUDITONE_EMAIL = "auditOne@test.com";
	
	public static final String TEST_SELLER = "jsimao71@gmail.com";
	public static final String TEST_SELLER_ORG = "testorg";
	public static final String TEST_BUYER = "valter.balegas@einnovator.org";
	public static final String TEST_BUYER_ORG = "testorg";
	public static final String TEST_USER_FAIL = "Wronguser@WromngEmail.com";
	
	public static final String TEST_PASSWORD = "Einnovator123!!";
	private static final String CLIENT_ID = "greenfence";
	private static final String CLIENT_SECRET = "greenfence$123";
	
	@Configuration
	static class TestConfig extends SsoTestHelper.TestConfig {
		
		public TestConfig(ApplicationContext context) {
			super(TEST_SELLER, TEST_PASSWORD, CLIENT_ID, CLIENT_SECRET, context);
		}
	}
	
	private Account makeAccount(String username, String email) {
		Address address = new AddressBuilder()
				.country("PT")
				.city("Lisbon")
				.line1("Line1")
				.line2("line2")
				.state("Lisbon")
				.postalCode("2815")
				.build();
		Account account = new AccountBuilder()
				.username(username)
				.phone("99999999")
				.address(address)
				.currency(Currency.USD)
				.email(email)
//				.vatNumber("12345678")
//				.taxNumber("12345678")
				.build();
		
		return account;
		
	}
	
	private Payment makePayment() {
		Account buyer = client.getUser(TEST_BUYER);
		Account seller = client.getUser(TEST_SELLER);
		return makePayment(buyer, seller);
	}

	private Payment makePayment(Account buyer, Account seller) {
		long n = Math.round(Math.random()*100);
		Payable payable = new PayableBuilder()
				.name("product:"+n)
				.category("category:"+n)
				.description("description:"+n)
				.imgUri("https://www.iconexperience.com/_img/v_collection_png/256x256/shadow/book_green.png")
				.build();

		Payment payment = new PaymentBuilder()
				.amount(new MonetaryAmount(100.0 + n, Currency.USD))
				.buyer(buyer)
				.seller(seller)
				.payable(payable)
				.statementDescriptor("descriptor text:" + n)
//				.endDate(new GregorianCalendar(2020, 12, 31).getTime())
				.startDate(GregorianCalendar.getInstance().getTime())
				.build();
		return payment;
	}
	
	//	TODO: add delete user endpoint.
	@Test
	public void createAndDeleteUserTest() {
		try {
			String username = "tdd-" + UUID.randomUUID().toString();
			URI uri = client.createUser(makeAccount(username, username));
			assertNotNull(uri);
			String id = PaymentsClient.extractId(uri);
			assertNotNull(id);
			client.deleteUser(id);
			fail();
		}catch(HttpClientErrorException ex) {
			assertEquals(HttpStatus.METHOD_NOT_ALLOWED.value(), ex.getRawStatusCode());
		}
	}
	
	@Test
	public void getOrCreateTestUsers() {
		Account buyer0 = makeAccount(TEST_BUYER, TEST_BUYER);
		Account seller0 = makeAccount(TEST_SELLER, TEST_SELLER);
		
		Account greenfence = makeAccount(GREENFENCE, GREENFENCE_EMAIL);
		Account auditOne = makeAccount(AUDITONE, AUDITONE_EMAIL);
		
		Account buyer1 = null, seller1 = null;
		try {
			buyer1 = client.getUser(buyer0.getUsername());
		} catch (HttpClientErrorException e) {
			client.createUser(buyer0);
			buyer1 = client.getUser(buyer0.getUsername());
		}

		try {
			seller1 = client.getUser(seller0.getUsername());
		} catch (HttpClientErrorException e) {
			client.createUser(seller0);
			seller1 = client.getUser(seller0.getUsername());
		}
		
		try {
			client.getUser(greenfence.getUsername());
		} catch (HttpClientErrorException e) {
			client.createUser(greenfence);			
		}
		
		try {
			client.getUser(auditOne.getUsername());
		} catch (HttpClientErrorException e) {
			client.createUser(auditOne);			
		}

		assertNotNull(buyer1);
		assertNotNull(seller1);
	}
	
	@Test
	public void paymentSubmitTest() {
		try {
			Payment payment = makePayment();
			System.out.println(payment);
			URI uri = client.submitPayment(payment);
			assertNotNull(uri);
			String uuid = UriUtils.extractId(uri);
			assertNotNull(uuid);
		}catch(HttpClientErrorException e)
		{
			assertEquals(HttpStatus.NOT_FOUND.value(), e.getRawStatusCode());
		}
	}

	@Test
	public void paymentSubmitWithBadAccountSellerTest() {
		try {
			Account buyer = client.getUser(TEST_BUYER);
			Account seller = new AccountBuilder().username(TEST_USER_FAIL).build();
			Payment payment = makePayment(buyer, seller);
			System.out.println(payment);
			client.submitPayment(payment);
			fail();
			//		assertNotNull(uri);
		}catch(HttpClientErrorException e)
		{
			assertEquals(HttpStatus.NOT_FOUND.value(), e.getRawStatusCode());
		}
	}


	public String paymentSubmit() {
		Payment payment = makePayment();
		System.out.println(payment);
		URI uri = client.submitPayment(payment);
		String id = PaymentsClient.extractId(uri);
		return id;
	}

	@Test
	public void getPaymentTest() {
		String id = paymentSubmit();
		Payment payment = client.getPayment(id);
		assertNotNull(payment);
		assertEquals(id, payment.getId());
	}

	@Test
	@Ignore
	public void getUserTest() {
		//Account account = new AccountBuilder().username("Jorge Simao").build();
	}

	@Test
	public void getInexistingAccountTest() {
		try {
			client.getUser(UUID.randomUUID().toString());
			fail();
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND.value(), e.getRawStatusCode());
		}
	}


	@Test
	public void getExistingAccountTest() {
		Account account = client.getUser(TEST_SELLER);
		assertNotNull(account);
		assertEquals(TEST_SELLER, account.getUsername());
	}


//	@Test
//	public void updateExistingUserTest() {
//		String username = TEST_SELLER;
//		Account account = client.getUser(username);
//		assertNotNull(account);
//		assertEquals(username, account.getUsername());
//		account.getAddress().setCity("City-" + UUID.randomUUID().toString());
//		account.getAddress().setCountry("United States");
//		account.setPhone("+35191663191" + new Random().nextInt(10));
//		client.updateUserFullState(account);
//		Account account2 = client.getUser(username);
//		assertNotNull(account2);
//		assertEquals(username, account2.getUsername());
//		assertEquals(account.getAddress().getCity(), account2.getAddress().getCity());
//	}

	@Test
	public void updateExistingUserPartialTest() {
		String username = TEST_SELLER;
		Account account = client.getUser(username);
		assertNotNull(account);
		assertEquals(username, account.getUsername());
		Address address = new Address();		
		address.setLine1("Street " + UUID.randomUUID().toString());
		address.setCity("City-" + UUID.randomUUID().toString());
		account.setAddress(address);
		account.setWebsite("http://website.test.org");
		account.setProfileURL("http://social.test.org");
		client.updateUser(account);
		Account account2 = client.getUser(username);
		assertNotNull(account2);
		assertEquals(username, account2.getUsername());
		assertEquals(account.getWebsite(), account2.getWebsite());
		assertEquals(account.getProfileURL(), account2.getProfileURL());
		assertEquals(account.getAddress().getCity(), account2.getAddress().getCity());
		assertEquals(account.getAddress().getLine1(), account2.getAddress().getLine1());

		account.setWebsite("http://website2.test.org");
		account.setProfileURL(null);
		account.getAddress().setLine1(null);
		account.getAddress().setCity("City-" + UUID.randomUUID().toString());
		client.updateUser(account);
		Account account3 = client.getUser(username);
		assertNotNull(account3);
		assertEquals(username, account3.getUsername());
		assertEquals(account.getWebsite(), account3.getWebsite());
		assertEquals(account2.getProfileURL(), account3.getProfileURL());
		assertEquals(account.getAddress().getCity(), account3.getAddress().getCity());
		assertEquals(account.getAddress().getLine1(), account3.getAddress().getLine1());
	}

//	@Test
//	public void createOrganizationAndGetOrganizationTest() {
//		String username = "tdd-" + UUID.randomUUID().toString();
//		Account account = new AccountBuilder().username(username)
//				.phone("99999999")
//				.address(new AddressBuilder().country("US").city("NY").line1("Line1").line2("line2").state("NY").postalCode("2815").build()).build();
//		URI userURI = client.createUser(account);
//		assertNotNull(userURI);
//		String userId = client.extractId(userURI);
//		Account org = new AccountBuilder().username(TEST_ORG_USERNAME)
//				.name(UUID.randomUUID().toString())
//				.phone("99999999")
//				.address(new AddressBuilder().country("US").city("NY").line1("Line1").line2("line2").state("NY").postalCode("2815").build())
//				.ownerId(userId)
//				.build();
//		URI uri = client.createOrganization(org);
//		assertNotNull(uri);
//		String id = PaymentsClient.extractId(uri);
//		assertNotNull(id);
//		Account org1 = client.getOrganization(id);
//		assertNotNull(org1);
//		assertEquals(TEST_ORG_USERNAME, org1.getUsername());
//
//	}

//	@Test
//	public void getExistingOrganizationTest() {
//
//		String orgId ="5a130467f50980288a148f97";   //// this is the demo organization created in createOrganizationTest() and using its OrgID for other tests
//		Account org =client.getOrganization(orgId);
//		assertNotNull(org);
//		assertNotNull(TEST_ORG_USERNAME,org.getUsername());
//	}

//	@Test
//	public void getInExistingOrganizationTest() {
//		try {
//			String orgId ="testOrg"+UUID.randomUUID().toString();
//			Account uri = client.getOrganization(orgId);
//			assertNull(uri);
//			fail();
//		}catch(HttpClientErrorException er)
//		{
//			assertEquals(HttpStatus.NOT_FOUND.value(), er.getRawStatusCode());
//
//		}
//
//	}

//	@Test
//	public void updateExistingOrganization() {
//		String orgId ="5a130467f50980288a148f97";   // this is the demo organization created in createOrganizationTest() and using its OrgID for other tests
//		String userName= TEST_ORG_USERNAME;
//		Account org = client.getOrganization(orgId);
//		assertNotNull(org);
//		assertEquals(userName, org.getUsername());
//		org.getAddress().setCity("City-" + UUID.randomUUID().toString());
//		org.getAddress().setCountry("United States");
//		org.setPhone("+35191663191" + new Random().nextInt(10));
//		client.updateOrganization(org);
//		Account org2 = client.getOrganization(orgId);
//		assertNotNull(org2);
//		assertEquals(userName, org2.getUsername());
//		assertEquals(org.getAddress().getCity(), org2.getAddress().getCity());
//
//	}
//
//	@Test
//	public void updatePartialOrganizationTest() {
//
//		String username = TEST_ORG_USERNAME;
//		String orgId ="5a130467f50980288a148f97";   // this is the demo organization created in createOrganizationTest() and using its OrgID for other tests
//		Account org = client.getOrganization(orgId);
//		assertNotNull(org);
//		assertEquals(username, org.getUsername());
//		Address address = new Address();		
//		address.setLine1("Street " + UUID.randomUUID().toString());
//		address.setCity("City-" + UUID.randomUUID().toString());
//		org.setAddress(address);
//		org.setWebsite("http://website.test.org");
//		org.setProfileURL("http://social.test.org");
//		client.updateOrganization(org);
//		Account org2 = client.getOrganization(orgId);
//		assertNotNull(org2);
//		assertEquals(username, org2.getUsername());
//		assertEquals(org.getWebsite(), org2.getWebsite());
//		assertEquals(org.getProfileURL(), org2.getProfileURL());
//		assertEquals(org.getAddress().getCity(), org2.getAddress().getCity());
//		assertEquals(org.getAddress().getLine1(), org2.getAddress().getLine1());
//
//		org.setWebsite("http://website2.test.org");
//		org.setProfileURL(null);
//		org.getAddress().setLine1(null);
//		org.getAddress().setCity("City-" + UUID.randomUUID().toString());
//		client.updateOrganization(org);
//		Account org3 = client.getOrganization(orgId);
//		assertNotNull(org3);
//		assertEquals(username, org3.getUsername());
//		assertEquals(org.getWebsite(), org3.getWebsite());
//		assertEquals(org2.getProfileURL(), org3.getProfileURL());
//		assertEquals(org.getAddress().getCity(), org3.getAddress().getCity());
//		assertEquals(org.getAddress().getLine1(), org3.getAddress().getLine1());
//	}
//
//	//	FIX ME : delete User functionality is not defined in rest controller hence expected response 405
//	@Test
//	public void createOrganizationAndDeleteOrganizationTest() {
//		try {
//			String username = "tdd-" + UUID.randomUUID().toString();
//			Account account = new AccountBuilder().username(username)
//					.phone("99999999")
//					.address(new AddressBuilder().country("US").city("NY").line1("Line1").line2("line2").state("NY").postalCode("2815").build()).build();
//			URI userURI = client.createUser(account);
//			assertNotNull(userURI);
//			String userId = client.extractId(userURI);
//			Account org = new AccountBuilder().username(TEST_ORG_USERNAME)
//					.name(UUID.randomUUID().toString())
//					.phone("99999999")
//					.address(new AddressBuilder().country("US").city("NY").line1("Line1").line2("line2").state("NY").postalCode("2815").build())
//					.ownerId(userId)
//					.build();
//			URI uri = client.createOrganization(org);
//			assertNotNull(uri);
//			String id = PaymentsClient.extractId(uri);
//			assertNotNull(id);
//			Account org1 = client.getOrganization(id);
//			assertNotNull(org1);
//			client.deleteOrganization(id);
//			fail();
//		}catch(HttpClientErrorException ex) {
//			assertEquals(HttpStatus.METHOD_NOT_ALLOWED.value(), ex.getRawStatusCode());
//		}
//	}

	//	cards test cases
	
	@Test
	public void addCard1Test()
	{
		Account user = client.getUser(TEST_BUYER);
		CreditCard card = new CreditCardBuilder()
				.id(UUID.randomUUID().toString())
				.address(new AddressBuilder().country("US").city("NY").line1("Line1").line2("line2").state("NY").postalCode("2815").build())
				.brand("visa")
				.cardType(CardType.VISA)
				.currency(Currency.USD)
				.cvc("123")
				.number("4242424242424242")
				.expirationMonth(11)
				.expirationYear(2017)
				.last4("8765")
				.name("vishal")
				.build();

		URI uri = client.addUserCard(card,user.getId());
		String id = PaymentsClient.extractId(uri);
		assertNotNull(id);

	}
	
	/*
	@Test
	public void addCard1Test()
	{
		String username = "tdd-" + UUID.randomUUID().toString();
		Account account = new AccountBuilder().username(username)
				.phone("99999999")
				.address(new AddressBuilder().country("USA").city("NY").line1("Line1").line2("line2").state("NY").postalCode("2815").build()).build();
		URI uri = client.createUser(account);
		assertNotNull(uri);
		String id = PaymentsClient.extractId(uri);
		assertNotNull(id);
		
		Account user = client.getUser(username);
		CreditCard card = new CreditCardBuilder()
				.id(UUID.randomUUID().toString())
				.address(new AddressBuilder().country("US").city("NY").line1("Line1").line2("line2").state("NY").postalCode("2815").build())
				.brand("visa")
				.cardType(CardType.VISA_DEBIT)
				.currency(Currency.USD)
				.cvc("123")
				.number("4000056655665556")
				.expirationMonth(11)
				.expirationYear(2017)
				.last4("5556")
				.name("visa-"+UUID.randomUUID().toString())
				.build();

		URI uriCard = client.addCard(card,user.getId());
		String cardId = client.extractId(uriCard);
		assertNotNull(id);

	}*/
	

	@Test
	public void addCard2Test()
	{
		Account user = client.getUser(TEST_SELLER);
		CreditCard card = new CreditCardBuilder()
				.id(UUID.randomUUID().toString())
				.address(new AddressBuilder().country("US").city("NY").line1("Line1").line2("line2").state("NY").postalCode("2815").build())
				.brand("visa")
				.cardType(CardType.MASTERCARD)
				.currency(Currency.USD)
				.cvc("123")
				.number("5555555555554444")
				.expirationMonth(11)
				.expirationYear(2017)
				.last4("4444")
				.name("vishal")
				.build();

		URI uri = client.addUserCard(card,user.getId());
		String id = PaymentsClient.extractId(uri);
		assertNotNull(id);

	}
	@Test
	public void addNonExistingUserCard() {
		try {
			String id =UUID.randomUUID().toString();
			CreditCard card = new CreditCardBuilder()
					.id(UUID.randomUUID().toString())
					.address(new AddressBuilder().country("US").city("NY").line1("Line1").line2("line2").state("NY").postalCode("2815").build())
					.brand("visa")
					.cardType(CardType.VISA)
					.currency(Currency.USD)
					.cvc("123")
					.number("4242424242424242")
					.expirationMonth(11)
					.expirationYear(2017)
					.last4("8765")
					.name("vishal")
					.build();
			URI uri =client.addUserCard(card, id);
			assertNotNull(uri);
			String uriid= PaymentsClient.extractId(uri);
			assertNotNull(uriid);
			fail();
		}catch(HttpClientErrorException ex) {
			assertEquals(HttpStatus.BAD_REQUEST.value(), ex.getRawStatusCode());
		}
	}

	
	/*@Test 
	public void getUserCardTest() {
		Account user = client.getUser(TEST_USER);
		CreditCard[] cardList= client.getCard(user.getId());
		assertNotNull(cardList);

		for(CreditCard card :cardList) {
			assertEquals("8765", card.getLast4());
		}
	}*/

	@Test
	public void getNonExistUserCardTest() {
		try {
			String id ="tdd"+UUID.randomUUID().toString();
			CreditCard[]  cardList =client.getUserCard(id);
			assertNull(cardList);
			fail();
		}catch(HttpClientErrorException ex)
		{
			assertEquals(HttpStatus.NOT_FOUND.value(), ex.getRawStatusCode());
		}

	}
	
	@Test
	public void deleteExistingCard() {
		String cardId ="691b9425-5a6f-484a-bcc3-2d57f3c063cc";
		client.deleteUserCard(cardId);
		
	}
	@Test
	public void addOrganizationCard() {
		String id="5a130467f50980288a148f97";
		
		CreditCard card = new CreditCardBuilder()
				.id(UUID.randomUUID().toString())
				.address(new AddressBuilder().country("US").city("NY").line1("Line1").line2("line2").state("NY").postalCode("2815").build())
				.brand("visa")
				.cardType(CardType.VISA_DEBIT)
				.currency(Currency.USD)
				.cvc("123")
				.number("4000056655665556")
				.expirationMonth(11)
				.expirationYear(2017)
				.last4("4444")
				.name("vishal-visa")
				.build();

		URI uri = client.addOrganizationCard(card,id);
		String orgCardId = PaymentsClient.extractId(uri);
		assertNotNull(orgCardId);
	}
	
	@Test
	public void addFalseOrganizationCard() {
		try {
		Account user = client.getUser(TEST_SELLER);
		CreditCard card = new CreditCardBuilder()
				.id(UUID.randomUUID().toString())
				.address(new AddressBuilder().country("US").city("NY").line1("Line1").line2("line2").state("NY").postalCode("2815").build())
				.brand("visa")
				.cardType(CardType.VISA_DEBIT)
				.currency(Currency.USD)
				.cvc("123")
				.number("4000056655665556")
				.expirationMonth(11)
				.expirationYear(2017)
				.last4("4444")
				.name("vishal-visa")
				.build();

		URI uri = client.addOrganizationCard(card,user.getId());
		String orgCardId = PaymentsClient.extractId(uri);
		assertNotNull(orgCardId);
		fail();
		}catch(HttpClientErrorException ex) {
			assertEquals(HttpStatus.BAD_REQUEST.value(), ex.getRawStatusCode());
		}
	}
	
	
	/*@Test
	public void */
	
	
	
}

