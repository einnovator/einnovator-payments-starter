package org.einnovator.payments.client;

import static org.einnovator.util.UriUtils.extractId;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.einnovator.payments.client.config.PaymentsClientConfig;
import org.einnovator.payments.client.model.Account;
import org.einnovator.payments.client.model.Card;
import org.einnovator.payments.client.model.CardType;
import org.einnovator.payments.client.model.Currency;
import org.einnovator.payments.client.model.Payable;
import org.einnovator.payments.client.model.Payment;
import org.einnovator.sso.client.SsoTestHelper;
import org.einnovator.util.UriUtils;
import org.einnovator.util.model.Address;
import org.einnovator.util.model.Phone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {PaymentsClientTests.TestConfig.class, PaymentsClientConfig.class}, webEnvironment=WebEnvironment.MOCK)
public class PaymentsClientTests extends SsoTestHelper {

	@Autowired
	PaymentsClient client;

	public static final String TEST_ORG = "EInnovator";
	public static final String TEST_ORG_EMAIL = "tdd@einnovator.org";
	
	public static final String TEST_SELLER = "tdd@einnovator.org";
	public static final String TEST_SELLER_ORG = "testseller";
	public static final String TEST_BUYER = "tdd@einnovator.org";
	public static final String TEST_BUYER_ORG = "test";
	public static final String TEST_USER_FAIL = "test@test.org";
	
	public static final String TEST_PASSWORD = "Einnovator123!";
	private static final String CLIENT_ID = "application";
	private static final String CLIENT_SECRET = "application$123";
	
	@Configuration
	static class TestConfig extends SsoTestHelper.TestConfig {
		
		public TestConfig(ApplicationContext context) {
			super(TEST_SELLER, TEST_PASSWORD, CLIENT_ID, CLIENT_SECRET, context);
		}
	}
	
	private Account makeAccount(String username, String email) {
		Address address = new Address()
				.withCountry("PT").withCity("Lisbon").withLine1("Line1").withLine2("line2").withState("Lisbon").withPostalCode("2815");
		Account account = new Account()
				.withUsername(username)
				.withPhone(new Phone("99999999"))
				.withAddress(address)
				.withCurrency(Currency.USD)
				.withEmail(email)
				.withVatNumber("12345678")
				;
		
		return account;
		
	}
	
	private Payment makePayment() {
		Account buyer = client.getAccount(TEST_BUYER, null, null);
		Account seller = client.getAccount(TEST_SELLER, null, null);
		return makePayment(buyer, seller);
	}

	private Payment makePayment(Account buyer, Account seller) {
		long n = Math.round(Math.random()*100);
		Payable payable = new Payable()
				.withName("product:"+n)
				.withCategory("category:"+n)
				.withDescription("description:"+n)
				.withImg("https://www.iconexperience.com/_img/v_collection_png/256x256/shadow/book_green.png")
				;

		Payment payment = new Payment()
				.withAmount(BigDecimal.TEN)
				.withCurrency(Currency.USD)
				.withBuyer(buyer)
				.withSeller(seller)
				.withPayable(payable)
				.withStatement(payable.getName())
				;
		return payment;
	}
	
	@Test
	public void createAndDeleteUserTest() {
		String username = "tdd-" + UUID.randomUUID().toString();
		URI uri = client.createAccount(makeAccount(username, username), null, null);
		assertNotNull(uri);
		String id = extractId(uri);
		assertNotNull(id);
		client.deleteAccount(id, null, null);
	}
	
	@Test
	public void getOrCreateTestUsers() {
		Account buyer0 = makeAccount(TEST_BUYER, TEST_BUYER);
		Account seller0 = makeAccount(TEST_SELLER, TEST_SELLER);
		
		Account account = makeAccount(TEST_ORG, TEST_ORG_EMAIL);
		
		Account buyer1 = null, seller1 = null;
		try {
			buyer1 = client.getAccount(buyer0.getName(), null, null);
		} catch (HttpClientErrorException e) {
			client.createAccount(buyer0, null, null);
			buyer1 = client.getAccount(buyer0.getName(), null, null);
		}

		try {
			seller1 = client.getAccount(seller0.getName(), null, null);
		} catch (HttpClientErrorException e) {
			client.createAccount(seller0, null, null);
			seller1 = client.getAccount(seller0.getName(), null, null);
		}
		
		try {
			client.getAccount(account.getName(), null, null);
		} catch (HttpClientErrorException e) {
			client.createAccount(account, null, null);			
		}

		assertNotNull(buyer1);
		assertNotNull(seller1);
	}
	
	@Test
	public void paymentSubmitTest() {
		try {
			Payment payment = makePayment();
			System.out.println(payment);
			URI uri = client.submitPayment(payment, null, null);
			assertNotNull(uri);
			String uuid = UriUtils.extractId(uri);
			assertNotNull(uuid);
			client.chargePayment(payment, null, null);
		}catch(HttpClientErrorException e)
		{
			assertEquals(HttpStatus.NOT_FOUND.value(), e.getRawStatusCode());
		}
	}

	@Test
	public void paymentSubmitAndChargeTest() {
		try {
			Payment payment = makePayment();
			URI uri = client.submitPayment(payment, null, null);
			assertNotNull(uri);
			String id = UriUtils.extractId(uri);
			assertNotNull(id);
			payment.setUuid(id);
			client.chargePayment(payment, null, null);
		}catch(HttpClientErrorException e) {
		}
	}
	
	@Test
	public void paymentSubmitWithBadAccountSellerTest() {
		try {
			Account buyer = client.getAccount(TEST_BUYER, null, null);
			Account seller = new Account().withUsername(TEST_USER_FAIL);
			Payment payment = makePayment(buyer, seller);
			System.out.println(payment);
			client.submitPayment(payment, null, null);
			fail();
		}catch(HttpClientErrorException e)
		{
			assertEquals(HttpStatus.NOT_FOUND.value(), e.getRawStatusCode());
		}
	}


	public String paymentSubmit() {
		Payment payment = makePayment();
		System.out.println(payment);
		URI uri = client.submitPayment(payment, null, null);
		String id = extractId(uri);
		return id;
	}

	@Test
	public void getPaymentTest() {
		String id = paymentSubmit();
		Payment payment = client.getPayment(id, null, null);
		assertNotNull(payment);
		assertEquals(id, payment.getId());
	}


	@Test
	public void getInexistingAccountTest() {
		try {
			client.getAccount(UUID.randomUUID().toString(), null, null);
			fail();
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND.value(), e.getRawStatusCode());
		}
	}


	@Test
	public void getExistingAccountTest() {
		Account account = client.getAccount(TEST_SELLER, null, null);
		assertNotNull(account);
		assertEquals(TEST_SELLER, account.getName());
	}

	@Test
	public void updateExistingUserPartialTest() {
		String username = TEST_SELLER;
		Account account = client.getAccount(username, null, null);
		assertNotNull(account);
		assertEquals(username, account.getName());
		Address address = new Address();		
		address.setLine1("Street " + UUID.randomUUID().toString());
		address.setCity("City-" + UUID.randomUUID().toString());
		account.setAddress(address);
		account.setWebsite("http://website.test.org");
		client.updateAccount(account, null, null);
		Account account2 = client.getAccount(username, null, null);
		assertNotNull(account2);
		assertEquals(username, account2.getName());
		assertEquals(account.getWebsite(), account2.getWebsite());
		assertEquals(account.getAddress().getCity(), account2.getAddress().getCity());
		assertEquals(account.getAddress().getLine1(), account2.getAddress().getLine1());

		account.setWebsite("http://website2.test.org");
		account.getAddress().setLine1(null);
		account.getAddress().setCity("City-" + UUID.randomUUID().toString());
		client.updateAccount(account, null, null);
		Account account3 = client.getAccount(username, null, null);
		assertNotNull(account3);
		assertEquals(username, account3.getName());
		assertEquals(account.getWebsite(), account3.getWebsite());
		assertEquals(account.getAddress().getCity(), account3.getAddress().getCity());
		assertEquals(account.getAddress().getLine1(), account3.getAddress().getLine1());
	}

	//	cards test cases
	
	@Test
	public void addCard1Test()
	{
		Account user = client.getAccount(TEST_BUYER, null, null);
		Card card = (Card)new Card()
				.withAddress(new Address().withCountry("USA").withCity("NY").withState("NY").withPostalCode("12345").withLine1("Line1").withLine2("line2"))
				.withBrand("visa")
				.withCardType(CardType.VISA)
				.withCurrency(Currency.USD)
				.withCvc("123")
				.withNumber("4242424242424242")
				.withExpirationMonth(11)
				.withExpirationYear(2020)
				.withLast4("8765")
				.withName("name")
				.withUuid(UUID.randomUUID().toString());


		URI uri = client.addAccountCard(card,user.getId(), null, null);
		String id = extractId(uri);
		assertNotNull(id);

	}
	
	/*
	@Test
	public void addCard1Test()
	{
		String username = "tdd-" + UUID.randomUUID().toString();
		Account account = new Account().username(username)
				.phone("99999999")
				.address(new Address().country("USA").city("NY").line1("Line1").line2("line2").state("NY").postalCode("2815"));
		URI uri = client.createAccount(account);
		assertNotNull(uri);
		String id = extractId(uri);
		assertNotNull(id);
		
		Account user = client.getAccount(username);
		CreditCard card = new CreditCard()
				.id(UUID.randomUUID().toString())
				.address(new Address().country("US").city("NY").line1("Line1").line2("line2").state("NY").postalCode("2815"))
				.brand("visa")
				.cardType(CardType.VISA_DEBIT)
				.currency(Currency.USD)
				.cvc("123")
				.number("4000056655665556")
				.expirationMonth(11)
				.expirationYear(2020)
				.last4("5556")
				.name("visa-"+UUID.randomUUID().toString())
				;

		URI uriCard = client.addCard(card,user.getId());
		String cardId = client.extractId(uriCard);
		assertNotNull(id);

	}*/
	

	@Test
	public void addCard2Test()
	{
		Account user = client.getAccount(TEST_SELLER, null, null);
		Card card = (Card)new Card()
				.withAddress(new Address().withCountry("USA").withCity("NY").withState("NY").withPostalCode("12345").withLine1("Line1").withLine2("line2"))
				.withBrand("visa")
				.withCardType(CardType.MASTERCARD)
				.withCurrency(Currency.USD)
				.withCvc("123")
				.withNumber("5555555555554444")
				.withExpirationMonth(11)
				.withExpirationYear(2020)
				.withLast4("4444")
				.withName("name")
				.withUuid(UUID.randomUUID().toString());

		URI uri = client.addAccountCard(card, user.getId(), null, null);
		String id = extractId(uri);
		assertNotNull(id);

	}
	@Test
	public void addNonExistingUserCard() {
		try {
			String id =UUID.randomUUID().toString();
			Card card = (Card)new Card()
					.withAddress(new Address().withCountry("USA").withCity("NY").withState("NY").withPostalCode("12345").withLine1("Line1").withLine2("line2"))
					.withBrand("visa")
					.withCardType(CardType.VISA)
					.withCurrency(Currency.USD)
					.withCvc("123")
					.withNumber("4242424242424242")
					.withExpirationMonth(11)
					.withExpirationYear(2020)
					.withLast4("8765")
					.withName("name")
					.withUuid(UUID.randomUUID().toString());

			URI uri =client.addAccountCard(card, id, null, null);
			assertNotNull(uri);
			String uriid= extractId(uri);
			assertNotNull(uriid);
			fail();
		}catch(HttpClientErrorException ex) {
			assertEquals(HttpStatus.BAD_REQUEST.value(), ex.getRawStatusCode());
		}
	}

	

	@Test
	public void getNonExistUserCardTest() {
		try {
			String id ="tdd"+UUID.randomUUID().toString();
			List<Card> cardList =client.getAccountCards(id, null, null);
			assertNull(cardList);
			fail();
		}catch(HttpClientErrorException ex)
		{
			assertEquals(HttpStatus.NOT_FOUND.value(), ex.getRawStatusCode());
		}

	}
	
	@Test
	public void deleteExistingCard() {
		String accountId ="tdd-"+UUID.randomUUID().toString();
		List<Card> cards =client.getAccountCards(accountId, null, null);
		assertNotNull(cards);
		for (Card card: cards) {
			client.deleteAccountCard(accountId, card.getNumber(), null, null);				
		}
	}
	
	@Test
	public void addAccountCard() {
		Card card = (Card)new Card()
				.withAddress(new Address().withCountry("USA").withCity("NY").withState("NY").withPostalCode("12345").withLine1("Line1").withLine2("line2"))
				.withBrand("visa")
				.withCardType(CardType.VISA_DEBIT)
				.withCurrency(Currency.USD)
				.withCvc("123")
				.withNumber("4000056655665556")
				.withExpirationMonth(11)
				.withExpirationYear(2020)
				.withLast4("4444")
				.withName("name")
				.withUuid(UUID.randomUUID().toString());
		URI uri = client.addAccountCard(card, card.getUuid(), null, null);
		String orgCardId = extractId(uri);
		assertNotNull(orgCardId);
	}
	
	@Test
	public void addFalseAccountCard() {
		try {
			
		Account user = client.getAccount(TEST_SELLER, null, null);
		Card card = (Card)new Card()
				.withAddress(new Address().withCountry("USA").withCity("NY").withState("NY").withPostalCode("12345").withLine1("Line1").withLine2("line2"))
				.withBrand("visa")
				.withCardType(CardType.VISA_DEBIT)
				.withCurrency(Currency.USD)
				.withCvc("123")
				.withNumber("4000056655665556")
				.withExpirationMonth(11)
				.withExpirationYear(2020)
				.withLast4("4444")
				.withName("name")
				.withUuid(UUID.randomUUID().toString());


		URI uri = client.addAccountCard(card, user.getId(), null, null);
		String orgCardId = extractId(uri);
		assertNotNull(orgCardId);
		fail();
		}catch(HttpClientErrorException ex) {
			assertEquals(HttpStatus.BAD_REQUEST.value(), ex.getRawStatusCode());
		}
	}
	
	
	
}

