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
import org.einnovator.payments.client.model.AccountBuilder;
import org.einnovator.payments.client.model.CardType;
import org.einnovator.payments.client.model.Card;
import org.einnovator.payments.client.model.CardBuilder;
import org.einnovator.payments.client.model.Currency;
import org.einnovator.payments.client.model.Payable;
import org.einnovator.payments.client.model.PayableBuilder;
import org.einnovator.payments.client.model.Payment;
import org.einnovator.payments.client.model.PaymentBuilder;
import org.einnovator.sso.client.support.SsoTestHelper;
import org.einnovator.util.UriUtils;
import org.einnovator.util.model.Address;
import org.einnovator.util.model.AddressBuilder;
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
	
	public static final String TEST_PASSWORD = "Einnovator123!!";
	private static final String CLIENT_ID = "application";
	private static final String CLIENT_SECRET = "application$123";
	
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
				.phone(new Phone("99999999"))
				.address(address)
				.currency(Currency.USD)
				.email(email)
//				.vatNumber("12345678")
//				.taxNumber("12345678")
				.build();
		
		return account;
		
	}
	
	private Payment makePayment() {
		Account buyer = client.getAccount(TEST_BUYER);
		Account seller = client.getAccount(TEST_SELLER);
		return makePayment(buyer, seller);
	}

	private Payment makePayment(Account buyer, Account seller) {
		long n = Math.round(Math.random()*100);
		Payable payable = new PayableBuilder()
				.name("product:"+n)
				.category("category:"+n)
				.description("description:"+n)
				.img("https://www.iconexperience.com/_img/v_collection_png/256x256/shadow/book_green.png")
				.build();

		Payment payment = new PaymentBuilder()
				.amount(BigDecimal.TEN)
				.currency(Currency.USD)
				.buyer(buyer)
				.seller(seller)
				.payable(payable)
				.statement(payable.getName())
				.build();
		return payment;
	}
	
	@Test
	public void createAndDeleteUserTest() {
		String username = "tdd-" + UUID.randomUUID().toString();
		URI uri = client.createAccount(makeAccount(username, username));
		assertNotNull(uri);
		String id = extractId(uri);
		assertNotNull(id);
		client.deleteAccount(id);
	}
	
	@Test
	public void getOrCreateTestUsers() {
		Account buyer0 = makeAccount(TEST_BUYER, TEST_BUYER);
		Account seller0 = makeAccount(TEST_SELLER, TEST_SELLER);
		
		Account account = makeAccount(TEST_ORG, TEST_ORG_EMAIL);
		
		Account buyer1 = null, seller1 = null;
		try {
			buyer1 = client.getAccount(buyer0.getName());
		} catch (HttpClientErrorException e) {
			client.createAccount(buyer0);
			buyer1 = client.getAccount(buyer0.getName());
		}

		try {
			seller1 = client.getAccount(seller0.getName());
		} catch (HttpClientErrorException e) {
			client.createAccount(seller0);
			seller1 = client.getAccount(seller0.getName());
		}
		
		try {
			client.getAccount(account.getName());
		} catch (HttpClientErrorException e) {
			client.createAccount(account);			
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
			Account buyer = client.getAccount(TEST_BUYER);
			Account seller = new AccountBuilder().username(TEST_USER_FAIL).build();
			Payment payment = makePayment(buyer, seller);
			System.out.println(payment);
			client.submitPayment(payment);
			fail();
		}catch(HttpClientErrorException e)
		{
			assertEquals(HttpStatus.NOT_FOUND.value(), e.getRawStatusCode());
		}
	}


	public String paymentSubmit() {
		Payment payment = makePayment();
		System.out.println(payment);
		URI uri = client.submitPayment(payment);
		String id = extractId(uri);
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
	public void getInexistingAccountTest() {
		try {
			client.getAccount(UUID.randomUUID().toString());
			fail();
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND.value(), e.getRawStatusCode());
		}
	}


	@Test
	public void getExistingAccountTest() {
		Account account = client.getAccount(TEST_SELLER);
		assertNotNull(account);
		assertEquals(TEST_SELLER, account.getName());
	}

	@Test
	public void updateExistingUserPartialTest() {
		String username = TEST_SELLER;
		Account account = client.getAccount(username);
		assertNotNull(account);
		assertEquals(username, account.getName());
		Address address = new Address();		
		address.setLine1("Street " + UUID.randomUUID().toString());
		address.setCity("City-" + UUID.randomUUID().toString());
		account.setAddress(address);
		account.setWebsite("http://website.test.org");
		client.updateAccount(account);
		Account account2 = client.getAccount(username);
		assertNotNull(account2);
		assertEquals(username, account2.getName());
		assertEquals(account.getWebsite(), account2.getWebsite());
		assertEquals(account.getAddress().getCity(), account2.getAddress().getCity());
		assertEquals(account.getAddress().getLine1(), account2.getAddress().getLine1());

		account.setWebsite("http://website2.test.org");
		account.getAddress().setLine1(null);
		account.getAddress().setCity("City-" + UUID.randomUUID().toString());
		client.updateAccount(account);
		Account account3 = client.getAccount(username);
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
		Account user = client.getAccount(TEST_BUYER);
		Card card = new CardBuilder()
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

		URI uri = client.addAccountCard(card,user.getId());
		String id = extractId(uri);
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
		URI uri = client.createAccount(account);
		assertNotNull(uri);
		String id = extractId(uri);
		assertNotNull(id);
		
		Account user = client.getAccount(username);
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
		Account user = client.getAccount(TEST_SELLER);
		Card card = new CardBuilder()
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

		URI uri = client.addAccountCard(card,user.getId());
		String id = extractId(uri);
		assertNotNull(id);

	}
	@Test
	public void addNonExistingUserCard() {
		try {
			String id =UUID.randomUUID().toString();
			Card card = new CardBuilder()
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
			URI uri =client.addAccountCard(card, id);
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
			List<Card> cardList =client.getAccountCards(id);
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
		List<Card> cards =client.getAccountCards(accountId);
		assertNotNull(cards);
		for (Card card: cards) {
			client.deleteAccountCard(accountId, card.getNumber());				
		}
	}
	
	@Test
	public void addAccountCard() {
		String id="5a130467f50980288a148f97";
		
		Card card = new CardBuilder()
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

		URI uri = client.addAccountCard(card,id);
		String orgCardId = extractId(uri);
		assertNotNull(orgCardId);
	}
	
	@Test
	public void addFalseAccountCard() {
		try {
		Account user = client.getAccount(TEST_SELLER);
		Card card = new CardBuilder()
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

		URI uri = client.addAccountCard(card,user.getId());
		String orgCardId = extractId(uri);
		assertNotNull(orgCardId);
		fail();
		}catch(HttpClientErrorException ex) {
			assertEquals(HttpStatus.BAD_REQUEST.value(), ex.getRawStatusCode());
		}
	}
	
	
	/*@Test
	public void */
	
	
	
}

