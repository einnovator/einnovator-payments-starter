package org.einnovator.payments.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.net.URI;
import java.util.GregorianCalendar;

import org.einnovator.payments.client.PaymentsClient;
import org.einnovator.payments.client.config.PaymentsClientConfig;
import org.einnovator.payments.client.model.Account;
import org.einnovator.payments.client.model.Currency;
import org.einnovator.payments.client.model.Payable;
import org.einnovator.payments.client.model.Payment;
import org.einnovator.sso.client.support.SsoTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import org.einnovator.util.MappingUtils;

import static org.einnovator.util.UriUtils.extractId;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {AccountPaymentsClientTests.TestConfig.class, PaymentsClientConfig.class}, webEnvironment=WebEnvironment.MOCK)
public class AccountPaymentsClientTests extends SsoTestHelper {

	@Autowired
	PaymentsClient client;

	public static final String TEST_SELLER = "jsimao71@gmail.com";
	public static final String TEST_BUYER = "tdd@einnovator.org";
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
	
	private Payment makePayment() {
		Account buyer = client.getAccount(TEST_BUYER);
		Account seller = client.getAccount(TEST_SELLER);
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
	
	private Payment makeSitePayment(Account buyer) {
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
				.withPayable(payable)
				.withStatement(payable.getName())
				.withStartDate(GregorianCalendar.getInstance().getTime())
				;
		return payment;
	}
	
	public String paymentSubmit() {
		Payment payment = makePayment();
		System.out.println(payment);
		URI uri = client.submitPayment(payment);
		String id = extractId(uri);
		return id;
	}
	
	public String paymentSiteSubmit() {
		Payment payment = makeSitePayment(client.getAccount(TEST_BUYER));
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
		System.out.println(MappingUtils.toJson(payment));
	}
	
	@Test
	public void getPaymentSiteTest() {
		String id = paymentSiteSubmit();
		Payment payment = client.getPayment(id);
		assertNotNull(payment);
		assertEquals(id, payment.getId());
		System.out.println(MappingUtils.toJson(payment));
	}
	
	@Test
	public void listPaymentsTest() {
		paymentSubmit();
		Page<Payment> payments0 = client.listPayments(null, new PageRequest(0, 10));
		assertNotNull(payments0);
		assertTrue(payments0.getSize() > 0);
		
		if(payments0.getTotalPages() == 1) {
			System.out.println(MappingUtils.toJson(payments0.getContent()));
			return;
		}
		
		Page<Payment> payments1 = client.listPayments(null, new PageRequest(1, 10));
		
		assertNotNull(payments1);
		assertTrue(payments1.getSize() > 0);
		
		assertNotEquals(payments0.getContent().get(0).getId(), payments1.getContent().get(0).getId());
		assertEquals(payments0.getSize(), 10);
		
		System.out.println(MappingUtils.toJson(payments0.getContent()));
		System.out.println(MappingUtils.toJson(payments1.getContent()));
	}
}

