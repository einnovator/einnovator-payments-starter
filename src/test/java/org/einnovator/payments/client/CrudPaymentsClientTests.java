package org.einnovator.payments.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.util.GregorianCalendar;

import org.einnovator.payments.client.PaymentsClient;
import org.einnovator.payments.client.config.PaymentsClientConfig;
import org.einnovator.payments.client.model.Account;
import org.einnovator.payments.client.model.Currency;
import org.einnovator.payments.client.model.MonetaryAmount;
import org.einnovator.payments.client.model.Payable;
import org.einnovator.payments.client.model.PayableBuilder;
import org.einnovator.payments.client.model.Payment;
import org.einnovator.payments.client.model.PaymentBuilder;
import org.einnovator.payments.client.model.PaymentStrategy;
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



@RunWith(SpringRunner.class)
@SpringBootTest(classes= {CrudPaymentsClientTests.TestConfig.class, PaymentsClientConfig.class}, webEnvironment=WebEnvironment.MOCK)
public class CrudPaymentsClientTests extends SsoTestHelper {

	@Autowired
	PaymentsClient client;

	public static final String TEST_SELLER = "jsimao71@gmail.com";
	public static final String TEST_BUYER = "tdd@einnovator.org";
	public static final String TEST_USER_FAIL = "fake@test.org";
	
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
				.strategy(PaymentStrategy.DIRECT)
				.statementDescriptor("descriptor text:" + n)
//				.endDate(new GregorianCalendar(2020, 12, 31).getTime())
				.startDate(GregorianCalendar.getInstance().getTime())
				.build();
		return payment;
	}
	
	private Payment makeSitePayment(Account buyer) {
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
				.payable(payable)
				.strategy(PaymentStrategy.SITE)
				.statementDescriptor("descriptor text:" + n)
				.startDate(GregorianCalendar.getInstance().getTime())
				.build();
		return payment;
	}
	
	public String paymentSubmit() {
		Payment payment = makePayment();
		System.out.println(payment);
		URI uri = client.submitPayment(payment);
		String id = PaymentsClient.extractId(uri);
		return id;
	}
	
	public String paymentSiteSubmit() {
		Payment payment = makeSitePayment(client.getUser(TEST_BUYER));
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
		Page<Payment> payments0 = client.listPayments(new PageRequest(0, 10), null);
		assertNotNull(payments0);
		assertTrue(payments0.getSize() > 0);
		
		if(payments0.getTotalPages() == 1) {
			System.out.println(MappingUtils.toJson(payments0.getContent()));
			return;
		}
		
		Page<Payment> payments1 = client.listPayments(new PageRequest(1, 10), null);
		
		assertNotNull(payments1);
		assertTrue(payments1.getSize() > 0);
		
		assertNotEquals(payments0.getContent().get(0).getId(), payments1.getContent().get(0).getId());
		assertEquals(payments0.getSize(), 10);
		
		System.out.println(MappingUtils.toJson(payments0.getContent()));
		System.out.println(MappingUtils.toJson(payments1.getContent()));
	}
}

