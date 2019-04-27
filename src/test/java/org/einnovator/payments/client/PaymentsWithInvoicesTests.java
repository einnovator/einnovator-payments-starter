package org.einnovator.payments.client;

import static org.junit.Assert.assertNotNull;

import java.util.GregorianCalendar;

import org.einnovator.payments.client.PaymentsClient;
import org.einnovator.payments.client.config.PaymentsClientConfig;
import org.einnovator.payments.client.model.Account;
import org.einnovator.payments.client.model.AccountBuilder;
import org.einnovator.payments.client.model.Address;
import org.einnovator.payments.client.model.AddressBuilder;
import org.einnovator.payments.client.model.Currency;
import org.einnovator.payments.client.model.MonetaryAmount;
import org.einnovator.payments.client.model.Payable;
import org.einnovator.payments.client.model.PayableBuilder;
import org.einnovator.payments.client.model.Payment;
import org.einnovator.payments.client.model.PaymentBuilder;
import org.einnovator.sso.client.support.SsoTestHelper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;



@RunWith(SpringRunner.class)
@SpringBootTest(classes= {PaymentsClientTests.TestConfig.class, PaymentsClientConfig.class}, webEnvironment=WebEnvironment.MOCK)
public class PaymentsWithInvoicesTests extends SsoTestHelper {

	@Autowired
	PaymentsClient client;

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
	
	public void getOrCreateTestUsers() {
		Account buyer0 = makeAccount(TEST_BUYER, TEST_BUYER);
		Account seller0 = makeAccount(TEST_SELLER, TEST_SELLER);
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

		assertNotNull(buyer1);
		assertNotNull(seller1);
	}

	
}

