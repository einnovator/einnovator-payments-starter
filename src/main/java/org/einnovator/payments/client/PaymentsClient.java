package org.einnovator.payments.client;

import static org.einnovator.util.UriUtils.encodeId;
import static org.einnovator.util.UriUtils.makeURI;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.einnovator.payments.client.config.PaymentsClientConfiguration;

import org.einnovator.payments.client.config.PaymentsEndpoints;
import org.einnovator.payments.client.model.Account;
import org.einnovator.payments.client.model.Card;
import org.einnovator.payments.client.model.Payment;
import org.einnovator.payments.client.model.Tax;
import org.einnovator.payments.client.modelx.AccountFilter;
import org.einnovator.payments.client.modelx.AccountOptions;
import org.einnovator.payments.client.modelx.PaymentFilter;
import org.einnovator.payments.client.modelx.PaymentOptions;
import org.einnovator.payments.client.modelx.TaxFilter;
import org.einnovator.payments.client.modelx.TaxOptions;
import org.einnovator.util.PageResult;
import org.einnovator.util.PageUtil;
import org.einnovator.util.UriUtils;
import org.einnovator.util.model.EntityBase;
import org.einnovator.util.web.RequestOptions;
import org.einnovator.util.web.Result;
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
	private PaymentsClientConfiguration config;

	@Autowired
	@Qualifier("paymentsRestTemplate")
	private OAuth2RestTemplate restTemplate;

	private OAuth2ClientContext oauth2ClientContext0 = new DefaultOAuth2ClientContext();

	private OAuth2RestTemplate restTemplate0;

	private ClientHttpRequestFactory clientHttpRequestFactory;
	
	@Autowired
	public PaymentsClient() {
	}
	

	public PaymentsClient(PaymentsClientConfiguration config) {
		this.config = config;
	}

	public PaymentsClient(OAuth2RestTemplate restTemplate, PaymentsClientConfiguration config) {
		this.restTemplate = restTemplate;
		this.config = config;
	}

	
	
	/**
	 * Get the value of property {@code config}.
	 *
	 * @return the config
	 */
	public PaymentsClientConfiguration getConfig() {
		return config;
	}


	/**
	 * Set the value of property {@code config}.
	 *
	 * @param config the value of property config
	 */
	public void setConfig(PaymentsClientConfiguration config) {
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
	
	//
	// Payments
	//

	
	/**
	 * List {@code Payment}s.
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param filter a {@code PaymentFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Payment}s
	 * @throws RestClientException if request fails
	 */
	@SuppressWarnings({ "rawtypes"})
	public Page<Payment> listPayments(PaymentFilter filter, Pageable pageable) {
		URI uri = makeURI(PaymentsEndpoints.payments(config));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(), Payment.class);
	}

	/**
	 * Get {@code Payment} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier
	 * @param options (optional) the {@code PaymentOptions} that tailor which fields are returned (projection)
	 * @return the {@code Payment}
	 * @throws RestClientException if request fails
	 */
	public Payment getPayment(String id, PaymentOptions options) {
		URI uri = makeURI(PaymentsEndpoints.payment(id, config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<Payment> response = exchange(request, Payment.class, options);
		return response.getBody();
	}

	/**
	 * Submit a new {@code Payment}.
	 * 
	 * <p><b>Required Security Credentials</b>: Any.
	 * 
	 * @param payment the {@code Payment}
	 * @param options optional {@code PaymentOptions}
	 * @return the location {@code URI} for the created {@code Payment}
	 * @throws RestClientException if request fails
	 */
	public URI submitPayment(Payment payment, PaymentOptions options) {
		URI uri = makeURI(PaymentsEndpoints.payments(config));
		uri = processURI(uri, options);
		RequestEntity<Payment> request = RequestEntity.post(uri).body(payment);
		ResponseEntity<Void> response = exchange(request, Void.class, options);
		return response.getHeaders().getLocation();
	}

	/**
	 * Update {@code Payment} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN).
	 * 
	 * @param id the identifier (id | uuid)
	 * @param payment the {@code Payment}
	 * @param options optional {@code PaymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void updatePayment(String id, Payment payment, PaymentOptions options) {
		URI uri = makeURI(PaymentsEndpoints.payment(payment.getUuid(), config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Payment.class, options);
	}

	/**
	 * Update {@code Payment}.
	 * 
	 * <p>ID is extracted from fields: UUID, ID.
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN).
	 * 
	 * @param payment the {@code Payment}
	 * @param options optional {@code PaymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void updatePayment(Payment payment, PaymentOptions options) {
		updatePayment(getId(payment), payment, options);
	}

	/**
	 * Charge {@code Payment} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier (id | uuid)
	 * @param payment the {@code Payment}
	 * @param options optional {@code PaymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void chargePayment(String id, Payment payment, RequestOptions options) {
		URI uri = makeURI(PaymentsEndpoints.charge(payment.getUuid(), config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).build();
		exchange(request, Payment.class, options);
	}
	
	/**
	 * Charge {@code Payment}.
	 * 
	 * <p>ID is extracted from fields: UUID, ID.
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param payment the {@code Payment}
	 * @param options optional {@code PaymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void chargePayment(Payment payment, PaymentOptions options) {
		chargePayment(getId(payment), payment, options);
	}

	/**
	 * Delete existing {@code Payment}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the {@code Payment} identifier (UUID | id)
	 * @param options optional {@code PaymentOptions}
	 * @throws RestClientException if request fails
	 */
	public void deletePayment(String id, PaymentOptions options) {
		URI uri = makeURI(PaymentsEndpoints.payment(id, config));
		uri = processURI(uri, options);
		RequestEntity<Void> request = RequestEntity.delete(uri).build();
		exchange(request, Void.class, options);
	}


	//
	// Account
	//

	/**
	 * List {@code Account}s.
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param filter a {@code AccountFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Account}s
	 * @throws RestClientException if request fails
	 */
	@SuppressWarnings({ "rawtypes"})
	public Page<Account> listAccounts(AccountFilter filter, Pageable pageable) {
		URI uri = makeURI(PaymentsEndpoints.accounts(config));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(), Account.class);
	}
	
	/**
	 * Get {@code Account} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier
	 * @param options (optional) the {@code AccountOptions} that tailor which fields are returned (projection)
	 * @return the {@code Account}
	 * @throws RestClientException if request fails
	 */
	public Account getAccount(String id, AccountOptions options) {
		URI uri = makeURI(PaymentsEndpoints.account(encodeId(id), config));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<Account> response = exchange(request, Account.class, options);
		return response.getBody();
	}

	/**
	 * Create a new {@code Account}.
	 * 
	 * <p><b>Required Security Credentials</b>: Any.
	 * 
	 * @param account the {@code Account}
	 * @param options optional {@code AccountOptions}
	 * @return the location {@code URI} for the created {@code Account}
	 * @throws RestClientException if request fails
	 */
	public URI createAccount(Account account, AccountOptions options) {
		URI uri = makeURI(PaymentsEndpoints.accounts(config));
		uri = processURI(uri, options);		
		RequestEntity<Account> request = RequestEntity.post(uri).body(account);
		ResponseEntity<Void> response = exchange(request, Void.class, options);
		return response.getHeaders().getLocation();
	}

	
	/**
	 * Update {@code Account} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN).
	 * 
	 * @param id the identifier (id | uuid)
	 * @param account the {@code Account}
	 * @param options optional {@code AccountOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateAccount(String id, Account account, AccountOptions options) {
		URI uri = makeURI(PaymentsEndpoints.account(id, config));
		uri = processURI(uri, options);		
		RequestEntity<Account> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(account);
		exchange(request, Account.class, options);
	}

	/**
	 * Update {@code Account}.
	 * 
	 * <p>ID is extracted from fields: UUID, ID.
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN).
	 * 
	 * @param account the {@code Account}
	 * @param options optional {@code AccountOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateAccount(Account account, AccountOptions options) {
		updateAccount(getId(account), account, options);
	}

	/**
	 * Delete existing {@code Account}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the {@code Account} identifier (UUID | id)
	 * @param options optional {@code AccountOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteAccount(String id, AccountOptions options) {
		URI uri = makeURI(PaymentsEndpoints.account(id, config));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).build();
		exchange(request, Void.class, options);
	}

	//
	// Cards
	//

	/**
	 * List {@code Card}s for {@code Account} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param accountId the {@code Account} identifier (UUID | id)
	 * @param options (optional) the {@code AccountOptions} that tailor which fields are returned (projection)
	 * @return the {@code Account}
	 * @throws RestClientException if request fails
	 */
	public List<Card> getAccountCards(String accountId, AccountOptions options) {
		URI uri = makeURI(PaymentsEndpoints.cards(accountId, config));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Card[]> response = exchange(request, Card[].class, options);
		return new ArrayList<>(Arrays.asList(response.getBody()));
	}
	
	/**
	 * Add new {@code Card} to {@code Account}.
	 * 
	 * <p><b>Required Security Credentials</b>: Any.
	 * 
	 * @param accountId the {@code Account} identifier (UUID | id)
	 * @param card the {@code Card}
	 * @param options optional {@code AccountOptions}
	 * @return the location {@code URI} for the created {@code Account}
	 * @throws RestClientException if request fails
	 */
	public URI addAccountCard(String accountId, Card card, AccountOptions options) {
		URI uri = makeURI(PaymentsEndpoints.cards(accountId, config));
		uri = processURI(uri, options);		
		RequestEntity<Card> request = RequestEntity.post(uri).body(card);
		ResponseEntity<Void> response = exchange(request, Void.class, options);
		return response.getHeaders().getLocation();
	}

	/**
	 * Delete {@code Card} for {@code Account}.
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param accountId the {@code Account} identifier (UUID | id)
	 * @param cardId the {@code Card} identifier (UUID | id)
	 * @param options optional {@code AccountOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteAccountCard(String accountId, String cardId, AccountOptions options) {
		URI uri = makeURI(PaymentsEndpoints.card(accountId, cardId, config));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).build();
		exchange(request, Void.class, options);
	}


	//
	// Taxes
	//

	/**
	 * Get {@code Tax} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the identifier
	 * @param options (optional) the {@code TaxOptions} that tailor which fields are returned (projection)
	 * @return the {@code Tax}
	 * @throws RestClientException if request fails
	 */
	public Tax getTax(String id, TaxOptions options) {
		URI uri = makeURI(PaymentsEndpoints.tax(id, config));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.get(uri).build();
		ResponseEntity<Tax> response = exchange(request, Tax.class, options);
		return response.getBody();
	}
	
	/**
	 * List {@code Tax}s.
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param filter a {@code TaxFilter}
	 * @param pageable a {@code Pageable} (optional)
	 * @throws RestClientException if request fails
	 * @return a {@code Page} with {@code Tax}s
	 * @throws RestClientException if request fails
	 */
	@SuppressWarnings({ "rawtypes"})
	public Page<Tax> listTaxes(TaxFilter filter, Pageable pageable) {
		URI uri = makeURI(PaymentsEndpoints.taxes(config));
		uri = processURI(uri, filter, pageable);
		RequestEntity<Void> request = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<PageResult> result = exchange(request, PageResult.class, filter);
		return PageUtil.create2(result.getBody(), Tax.class);
	}


	/**
	 * Create a new {@code Tax}.
	 * 
	 * <p><b>Required Security Credentials</b>: Any.
	 * 
	 * @param tax the {@code Tax}
	 * @param options optional {@code TaxOptions}
	 * @return the location {@code URI} for the created {@code Tax}
	 * @throws RestClientException if request fails
	 */
	public URI createTax(Tax tax, TaxOptions options) {
		URI uri = makeURI(PaymentsEndpoints.taxes(config));
		uri = processURI(uri, options);		
		RequestEntity<Tax> request = RequestEntity.post(uri).body(tax);
		ResponseEntity<Void> response = exchange(request, Void.class, options);
		return response.getHeaders().getLocation();
	}

	/**
	 * Update {@code Tax} with specified identifier.
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN).
	 * 
	 * @param id the identifier (id | uuid)
	 * @param tax the {@code Tax}
	 * @param options optional {@code TaxOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateTax(String id, Tax tax, TaxOptions options) {
		URI uri = makeURI(PaymentsEndpoints.tax(id, config));
		uri = processURI(uri, options);		
		RequestEntity<Tax> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(tax);
		exchange(request, Tax.class, options);		
	}

	/**
	 * Update {@code Tax}.
	 * 
	 * <p>ID is extracted from fields: UUID, ID.
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN).
	 * 
	 * @param tax the {@code Tax}
	 * @param options optional {@code TaxOptions}
	 * @throws RestClientException if request fails
	 */
	public void updateTax(Tax tax, TaxOptions options) {
		updateTax(getId(tax), tax, options);
	}

	/**
	 * Delete existing {@code Tax}
	 * 
	 * <p><b>Required Security Credentials</b>: Client, Admin (global role ADMIN), or owner.
	 * 
	 * @param id the {@code Tax} identifier (UUID | id)
	 * @param options optional {@code TaxOptions}
	 * @throws RestClientException if request fails
	 */
	public void deleteTax(String id, TaxOptions options) {
		URI uri = makeURI(PaymentsEndpoints.tax(id, config));
		uri = processURI(uri, options);		
		RequestEntity<Void> request = RequestEntity.delete(uri).build();
		exchange(request, Void.class, options);
	}
	
	//
	// HTTP transport
	//
	
	/**
	 * Submit HTTP request.
	 * 
	 * If {@code context} is not null, use provided {@code OAuth2RestTemplate} if any.
	 * Otherwise, use session scoped {@code OAuth2RestTemplate} if in web request thread. 
	 * Otherwise, use client credentials singleton (non thread-safe) @code OAuth2RestTemplate}.
	 * 
	 * @param <T> response type
	 * @param request the {@code RequestEntity}
	 * @param responseType the response type
	 * @param options optional {@code RequestOptions}
	 * @return result {@code ResponseEntity}
	 * @throws RestClientException if request fails
	 */
	protected <T> ResponseEntity<T> exchange(RequestEntity<?> request, Class<T> responseType, RequestOptions options) throws RestClientException {
		OAuth2RestTemplate restTemplate = getRequiredRestTemplate(options);
		try {
			return exchange(restTemplate, request, responseType);			
		} catch (RuntimeException e) {
			if (options!=null && !Boolean.TRUE.equals(options.getSingleton())) {
				options.setResult(new Result<Object>(e));
			}
			throw e;
		}
	}
	
	
	/**
	 * Submit HTTP request.
	 * 
	 * May be overriden by sub-classes for custom/advanced functionality.
	 * 
	 * @param <T> response type
	 * @param restTemplate the {@code OAuth2RestTemplate} to use
	 * @param request the {@code RequestEntity}
	 * @param responseType the response type
	 * @return the result {@code ResponseEntity}
	 * @throws RestClientException if request fails
	 */
	protected <T> ResponseEntity<T> exchange(OAuth2RestTemplate restTemplate, RequestEntity<?> request, Class<T> responseType) throws RestClientException {
		return restTemplate.exchange(request, responseType);
	}
	
	/**
	 * Get the {@code OAuth2RestTemplate} to use to perform a request.
	 * 
	 * Return the configured {@code OAuth2RestTemplate} in property {@link #restTemplate}.
	 * Check if current thread is bound to a web request with a session-scope. If not, fallback
	 * to {@code OAuth2RestTemplate} in property {@link #restTemplate0} if not null.
	 * 
	 * @param options optional {@code RequestOptions}
	 * @return the {@code OAuth2RestTemplate}
	 */
	protected OAuth2RestTemplate getRequiredRestTemplate(RequestOptions options) {
		OAuth2RestTemplate restTemplate = this.restTemplate;
		if (WebUtil.getHttpServletRequest()==null && this.restTemplate0!=null) {
			restTemplate = this.restTemplate0;
		}			
		return restTemplate;
	}
	//
	// RestTemplate util factory methods
	//

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
	// Other
	//

	/**
	 * Process URI by adding parameters from properties of specified objectes.
	 * 
	 * @param uri the {@code URI}
	 * @param objs a variadic array of objects
	 * @return the processed {@code URI}
	 */
	private static URI processURI(URI uri, Object... objs) {
		return UriUtils.appendQueryParameters(uri, objs);
	}
	
	
	private static String getId(EntityBase obj) {
		return EntityBase.getAnyId(obj);
	}

}
