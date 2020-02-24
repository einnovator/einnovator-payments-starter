package org.einnovator.payments.client.config;

import org.einnovator.payments.client.PaymentsClient;
import org.einnovator.payments.client.manager.AccountManager;
import org.einnovator.payments.client.manager.AccountManagerImpl;
import org.einnovator.payments.client.manager.PaymentManager;
import org.einnovator.payments.client.manager.PaymentManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

@Configuration
@EnableConfigurationProperties(PaymentsClientConfiguration.class)
public class PaymentsClientConfig {
	
	@Autowired
	private PaymentsClientConfiguration config;

	@Autowired
	private OAuth2ClientContext oauth2ClientContext;

	@Autowired
	private OAuth2ProtectedResourceDetails oauth2ResourceDetails;
	
	@Autowired
	public PaymentsClientConfig() {
	}

	public PaymentsClientConfig(PaymentsClientConfiguration config) {
		this.config = config;
	}


	@Bean
	public OAuth2RestTemplate paymentsRestTemplate() {
		OAuth2RestTemplate template = new OAuth2RestTemplate(oauth2ResourceDetails, oauth2ClientContext);			
		template.setRequestFactory(config.getConnection().makeClientHttpRequestFactory());
		return template;
	}
	
	@Bean
	public PaymentsClient paymentsClient() {
		return new PaymentsClient();
	}
	
	@Bean
	public PaymentManager paymentManager() {
		return new PaymentManagerImpl();
	}
	
	@Bean
	public AccountManager accountManager() {
		return new AccountManagerImpl();
	}
}
