package org.einnovator.payments.client;

import static org.einnovator.util.UriUtils.appendQueryParameters;
import static org.einnovator.util.UriUtils.makeURI;
import static org.einnovator.util.UriUtils.encode;
import static org.einnovator.util.UriUtils.encodeId;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.einnovator.payments.client.config.PaymentsConfiguration;
import org.einnovator.payments.client.config.PaymentsEndpoints;
import org.einnovator.payments.client.model.Account;
import org.einnovator.payments.client.model.Card;
import org.einnovator.payments.client.model.Payment;
import org.einnovator.payments.client.model.Tax;
import org.einnovator.payments.client.modelx.PaymentFilter;
import org.einnovator.payments.client.modelx.TaxFilter;
import org.einnovator.util.MappingUtils;
import org.einnovator.util.PageResult;
import org.einnovator.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.client.RestClientException;

public class PaymentsClient {

	@Autowired
	private PaymentsConfiguration config;

	@Autowired
	@Qualifier("paymentsRestTemplate")
	private OAuth2RestTemplate restTemplate;

	@Autowired
	public PaymentsClient() {
	}
	

	public PaymentsClient(PaymentsConfiguration config) {
		this.config = config;
	}

	public PaymentsClient(OAuth2RestTemplate restTemplate, PaymentsConfiguration config) {
		this.restTemplate = restTemplate;
		this.config = config;
	}

	public PaymentsConfiguration getConfig() {
		return config;
	}

	public void setConfig(PaymentsConfiguration config) {
		this.config = config;
	}
	
	public OAuth2RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(OAuth2RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}


	//
	// Payments
	//

	public URI submitPayment(Payment payment) {
		URI uri = makeURI(PaymentsEndpoints.payments(config));
		RequestEntity<Payment> request = RequestEntity.post(uri).body(payment);
		ResponseEntity<Void> response = exchange(request, Void.class);
		return response.getHeaders().getLocation();
	}

	public Payment getPayment(String id) {
		URI uri = makeURI(PaymentsEndpoints.payment(id, config));
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<Payment> response = exchange(request, Payment.class);
		return response.getBody();
	}
	
	@SuppressWarnings({ "rawtypes"})
	public Page<Payment> listPayments(PaymentFilter filter, Pageable pageable) {
		URI uri = makeURI(PaymentsEndpoints.payments(config));
		
		Map<String, String> params = new LinkedHashMap<>();
		if (pageable != null || filter != null) {
			if (pageable!=null) {
				params.putAll(MappingUtils.toMapFormatted(pageable));
			}
			if (filter!=null) {
				params.putAll(MappingUtils.toMapFormatted(filter));				
			}
		}
		
		uri = appendQueryParameters(uri, params);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<PageResult> result = exchange(request, PageResult.class);
		return PageUtil.create2(result.getBody(), Payment.class);
	}


	public void updatePayment(Payment payment) {
		URI uri = makeURI(PaymentsEndpoints.payment(payment.getId(), config));
		RequestEntity<Void> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Payment.class);
	}

	public void chargePayment(Payment payment) {
		URI uri = makeURI(PaymentsEndpoints.charge(payment.getId(), config));
		RequestEntity<Void> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Payment.class);
	}
	public void deletePayment(String id) {
		URI uri = makeURI(PaymentsEndpoints.payment(id, config));
		RequestEntity<Void> request = RequestEntity.delete(uri).build();
		exchange(request, Void.class);
	}

	//
	// User Account
	//
	
	public URI createUserAccount(Account account) {
		URI uri = makeURI(PaymentsEndpoints.userAccount(config));
		RequestEntity<Account> request = RequestEntity.post(uri).body(account);
		ResponseEntity<Void> response = exchange(request, Void.class);
		return response.getHeaders().getLocation();
	}

	public Account getUserAccount() {
		URI uri = makeURI(PaymentsEndpoints.userAccount(config));
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<Account> response = exchange(request, Account.class);
		return response.getBody();
	}

	public void updateUserAccount(Account user) {
		URI uri = makeURI(PaymentsEndpoints.userAccount(config));
		RequestEntity<Account> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(user);
		exchange(request, Account.class);
	}

	//
	// Account
	//

	public Account getAccount(String id) {
		URI uri = makeURI(PaymentsEndpoints.account(encodeId(id), config));
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<Account> response = exchange(request, Account.class);
		return response.getBody();
	}

	public URI createAccount(Account account) {
		URI uri = makeURI(PaymentsEndpoints.accounts(config));
		RequestEntity<Account> request = RequestEntity.post(uri).body(account);
		ResponseEntity<Void> response = exchange(request, Void.class);
		return response.getHeaders().getLocation();
	}

	public void updateAccount(Account user) {
		URI uri = makeURI(PaymentsEndpoints.account(user.getId(), config));
		RequestEntity<Account> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(user);

		exchange(request, Account.class);
	}

	public void deleteAccount(String id) {
		URI uri = makeURI(PaymentsEndpoints.account(id, config));
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();

		exchange(request, Void.class);
	}

	//
	// Cards
	//

	public URI addAccountCard(Card card, String accountId) {
		URI uri = makeURI(PaymentsEndpoints.cards(accountId, config));
		RequestEntity<Card> request = RequestEntity.post(uri).body(card);
		ResponseEntity<Void> response = exchange(request, Void.class);
		return response.getHeaders().getLocation();
	}

	public List<Card> getAccountCards(String accountId) {
		URI uri = makeURI(PaymentsEndpoints.cards(accountId, config));
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Card[]> response = exchange(request, Card[].class);
		return new ArrayList<>(Arrays.asList(response.getBody()));
	}

	public void deleteAccountCard(String accountId, String cardId) {
		URI uri = makeURI(PaymentsEndpoints.card(accountId, cardId, config));
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Void.class);
	}

	protected <T> ResponseEntity<T> exchange(RequestEntity<?> request, Class<T> responseType) throws RestClientException {
		return restTemplate.exchange(request, responseType);
	}

	//
	// Taxes
	//

	@SuppressWarnings({ "rawtypes"})
	public Page<Tax> listTaxes(TaxFilter filter, Pageable pageable) {
		URI uri = makeURI(PaymentsEndpoints.taxes(config));
		
		Map<String, String> params = new LinkedHashMap<>();
		if (pageable != null || filter != null) {
			if (pageable!=null) {
				params.putAll(MappingUtils.toMapFormatted(pageable));
			}
			if (filter!=null) {
				params.putAll(MappingUtils.toMapFormatted(filter));				
			}
		}
		
		uri = appendQueryParameters(uri, params);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<PageResult> result = exchange(request, PageResult.class);
		return PageUtil.create2(result.getBody(), Tax.class);
	}


	public Tax getTax(String id) {
		URI uri = makeURI(PaymentsEndpoints.tax(id, config));
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<Tax> response = exchange(request, Tax.class);
		return response.getBody();
	}

	public URI createTax(Tax tax) {
		URI uri = makeURI(PaymentsEndpoints.taxes(config));
		RequestEntity<Tax> request = RequestEntity.post(uri).body(tax);
		ResponseEntity<Void> response = exchange(request, Void.class);
		return response.getHeaders().getLocation();
	}

	public void updateTax(Tax user) {
		URI uri = makeURI(PaymentsEndpoints.tax(user.getId(), config));
		RequestEntity<Tax> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(user);

		exchange(request, Tax.class);
	}

	public void deleteTax(String id) {
		URI uri = makeURI(PaymentsEndpoints.tax(id, config));
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();

		exchange(request, Void.class);
	}
}
