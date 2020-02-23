package org.einnovator.payments.client;

import static org.einnovator.util.UriUtils.appendQueryParameters;
import static org.einnovator.util.UriUtils.encodeId;
import static org.einnovator.util.UriUtils.makeURI;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

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
import org.einnovator.util.web.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.client.RestClientException;

public class PaymentsClient {

	@Autowired
	private PaymentsConfiguration config;

	@Autowired
	@Qualifier("paymentsRestTemplate")
	private OAuth2RestTemplate restTemplate;

	private OAuth2ClientContext oauth2ClientContext0 = new DefaultOAuth2ClientContext();

	private OAuth2RestTemplate restTemplate0;

	@Autowired(required = false)
	private ClientHttpRequestFactory clientHttpRequestFactory;
	
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

	
	
	/**
	 * Get the value of property {@code config}.
	 *
	 * @return the config
	 */
	public PaymentsConfiguration getConfig() {
		return config;
	}


	/**
	 * Set the value of property {@code config}.
	 *
	 * @param config the value of property config
	 */
	public void setConfig(PaymentsConfiguration config) {
		this.config = config;
	}


	/**
	 * Get the value of property {@code restTemplate}.
	 *
	 * @return the restTemplate
	 */
	public OAuth2RestTemplate getRestTemplate() {
		return restTemplate;
	}


	/**
	 * Set the value of property {@code restTemplate}.
	 *
	 * @param restTemplate the value of property restTemplate
	 */
	public void setRestTemplate(OAuth2RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}


	/**
	 * Get the value of property {@code clientHttpRequestFactory}.
	 *
	 * @return the clientHttpRequestFactory
	 */
	public ClientHttpRequestFactory getClientHttpRequestFactory() {
		return clientHttpRequestFactory;
	}


	/**
	 * Set the value of property {@code clientHttpRequestFactory}.
	 *
	 * @param clientHttpRequestFactory the value of property clientHttpRequestFactory
	 */
	public void setClientHttpRequestFactory(ClientHttpRequestFactory clientHttpRequestFactory) {
		this.clientHttpRequestFactory = clientHttpRequestFactory;
	}


	/**
	 * Get the value of property {@code oauth2ClientContext0}.
	 *
	 * @return the oauth2ClientContext0
	 */
	public OAuth2ClientContext getOauth2ClientContext0() {
		return oauth2ClientContext0;
	}


	/**
	 * Set the value of property {@code oauth2ClientContext0}.
	 *
	 * @param oauth2ClientContext0 the value of property oauth2ClientContext0
	 */
	public void setOauth2ClientContext0(OAuth2ClientContext oauth2ClientContext0) {
		this.oauth2ClientContext0 = oauth2ClientContext0;
	}


	/**
	 * Get the value of property {@code restTemplate0}.
	 *
	 * @return the restTemplate0
	 */
	public OAuth2RestTemplate getRestTemplate0() {
		return restTemplate0;
	}


	/**
	 * Set the value of property {@code restTemplate0}.
	 *
	 * @param restTemplate0 the value of property restTemplate0
	 */
	public void setRestTemplate0(OAuth2RestTemplate restTemplate0) {
		this.restTemplate0 = restTemplate0;
	}


	@PostConstruct
	public void init() {
		if (clientHttpRequestFactory==null) {
			clientHttpRequestFactory = config.getConnection().makeClientHttpRequestFactory();
		}
	}
	
	public OAuth2RestTemplate makeOAuth2RestTemplate(OAuth2ProtectedResourceDetails resource, OAuth2ClientContext oauth2ClientContext) {
		OAuth2RestTemplate template = new OAuth2RestTemplate(resource, oauth2ClientContext);			
		template.setRequestFactory(clientHttpRequestFactory);
		return template;
	}
	
	public OAuth2RestTemplate makeOAuth2RestTemplate(OAuth2ClientContext oauth2ClientContext, ClientCredentialsResourceDetails resource) {
		OAuth2RestTemplate template = new OAuth2RestTemplate(resource, oauth2ClientContext);			
		template.setRequestFactory(clientHttpRequestFactory);
		return template;
	}
	
	public OAuth2RestTemplate setupClientOAuth2RestTemplate(ClientCredentialsResourceDetails resource) {
		if (restTemplate0==null) {
			restTemplate0 = makeOAuth2RestTemplate(oauth2ClientContext0, resource);
		}
		return restTemplate0;
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
		URI uri = makeURI(PaymentsEndpoints.payment(payment.getUuid(), config));
		RequestEntity<Void> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Payment.class);
	}

	public void chargePayment(Payment payment) {
		URI uri = makeURI(PaymentsEndpoints.charge(payment.getUuid(), config));
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
		OAuth2RestTemplate restTemplate = this.restTemplate;
		if (WebUtil.getHttpServletRequest()==null && this.restTemplate0!=null) {
			restTemplate = this.restTemplate0;
		}
		return exchange(restTemplate, request, responseType);
	}

	protected <T> ResponseEntity<T> exchange(OAuth2RestTemplate restTemplate, RequestEntity<?> request, Class<T> responseType) throws RestClientException {
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
