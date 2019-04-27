package org.einnovator.payments.client;

import static org.einnovator.payments.client.config.PaymentsEndpoints.makeURI;
import static org.einnovator.util.UriUtils.appendQueryParameters;

import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.einnovator.payments.client.config.PaymentsConfiguration;
import org.einnovator.payments.client.config.PaymentsEndpoints;
import org.einnovator.payments.client.model.Account;
import org.einnovator.payments.client.model.CreditCard;
import org.einnovator.payments.client.model.Payment;
import org.einnovator.payments.client.model.Tax;
import org.einnovator.payments.client.modelx.PaymentsFilter;
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Page<Payment> listPayments(Pageable pageable, PaymentsFilter filter) {
		URI uri = makeURI(PaymentsEndpoints.listPayments(config));
		
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

	public URI createUser(Account account) {
		URI uri = makeURI(PaymentsEndpoints.users(config));
		RequestEntity<Account> request = RequestEntity.post(uri).body(account);
		ResponseEntity<Void> response = exchange(request, Void.class);
		return response.getHeaders().getLocation();
	}

	public Account getUser(String username) {
		URI uri = makeURI(PaymentsEndpoints.user(username, config));
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<Account> response = exchange(request, Account.class);
		return response.getBody();
	}

	public Account getPrincipalUser() {
		URI uri = makeURI(PaymentsEndpoints.users(config));
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<Account> response = exchange(request, Account.class);
		return response.getBody();
	}

	public void updateUser(Account user) {
		updateUser(user, false);
	}

	public void updateUserFullState(Account user) {
		updateUser(user, true);
	}

	public void updateUser(Account user, boolean fullState) {
		URI uri = makeURI(PaymentsEndpoints.user(user.getId(), config));
		RequestEntity<Account> request = fullState ? RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(user)
				: RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(user);

		exchange(request, Account.class);
	}

	public void updatePrincipalUser(Account user) {
		URI uri = makeURI(PaymentsEndpoints.users(config));
		RequestEntity<Account> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(user);

		exchange(request, Account.class);
	}

	public void deleteUser(String id) {
		URI uri = makeURI(PaymentsEndpoints.user(id, config));
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();

		exchange(request, Void.class);
	}

	public Account getOrganization(String id) {
		URI uri = makeURI(PaymentsEndpoints.organization(id, config));
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<Account> response = exchange(request, Account.class);
		return response.getBody();
	}

	public URI createOrganization(Account account) {
		URI uri = makeURI(PaymentsEndpoints.organizations(config));
		RequestEntity<Account> request = RequestEntity.post(uri).body(account);
		ResponseEntity<Void> response = exchange(request, Void.class);
		return response.getHeaders().getLocation();
	}

	public void updateOrganization(Account user) {
		URI uri = makeURI(PaymentsEndpoints.organization(user.getId(), config));
		RequestEntity<Account> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(user);

		exchange(request, Account.class);
	}

	public void deleteOrganization(String id) {
		URI uri = makeURI(PaymentsEndpoints.organization(id, config));
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();

		exchange(request, Void.class);
	}

	public URI addUserCard(CreditCard card, String id) {
		URI uri = makeURI(PaymentsEndpoints.userCard(id, config));
		RequestEntity<CreditCard> request = RequestEntity.post(uri).body(card);
		ResponseEntity<Void> response = exchange(request, Void.class);
		return response.getHeaders().getLocation();
	}

	public CreditCard[] getUserCard(String id) {
		URI uri = makeURI(PaymentsEndpoints.userCard(id, config));
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<CreditCard[]> response = exchange(request, CreditCard[].class);
		return response.getBody();
	}

	public void deleteUserCard(String cardId) {
		URI uri = makeURI(PaymentsEndpoints.userCardDelete(cardId, config));
		RequestEntity<Void> request = RequestEntity.delete(uri).accept(MediaType.APPLICATION_JSON).build();

		exchange(request, Void.class);
	}

	public URI addOrganizationCard(CreditCard card, String orgId) {
		URI uri = makeURI(PaymentsEndpoints.organizationCard(orgId, config));
		RequestEntity<CreditCard> request = RequestEntity.post(uri).body(card);
		ResponseEntity<Void> response = exchange(request, Void.class);
		return response.getHeaders().getLocation();
	}

	public CreditCard[] getOrganizationCard(String orgId) {
		URI uri = makeURI(PaymentsEndpoints.organizationCard(orgId, config));
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<CreditCard[]> response = exchange(request, CreditCard[].class);
		return response.getBody();
	}

	public static String extractId(URI uri) {
		return uri.toString().substring(uri.toString().lastIndexOf("/") + 1);
	}

	protected <T> ResponseEntity<T> exchange(RequestEntity<?> request, Class<T> responseType) throws RestClientException {
		return restTemplate.exchange(request, responseType);
	}


	public void updatePayment(Payment payment) {
		URI uri = makeURI(PaymentsEndpoints.updatePayment(payment.getId(), config));
		RequestEntity<Void> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Payment.class);
	}
	
//	public Tax getTaxForCountry(String countryCode) {
//		URI uri = makeURI(PaymentsEndpoints.getTaxForCountry(countryCode, config));
//		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
//		return exchange(request, Tax.class).getBody();
//	}

	public URI makeURIFromId(String buyerPaymentId) {
		return makeURI(PaymentsEndpoints.payment(buyerPaymentId, config));
	}


	public List<Tax> getTaxForCountries(String countryCode, Collection<String> otherCountryCodes) {
		URI uri = makeURI(PaymentsEndpoints.getTaxForCountries(countryCode, otherCountryCodes, config));
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		return Arrays.asList(exchange(request, Tax[].class).getBody());
	}

}
