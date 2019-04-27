package org.einnovator.payments.client.config;

import org.einnovator.payments.client.PaymentsClient;
import org.einnovator.payments.client.manager.PaymentManager;
import org.einnovator.payments.client.manager.PaymentManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

@Configuration
@EnableConfigurationProperties(PaymentsConfiguration.class)
public class PaymentsClientConfig {
	
	@Autowired
	private PaymentsConfiguration config;

	@Autowired
	private OAuth2ClientContext oauth2ClientContext;

	@Autowired
	private OAuth2ProtectedResourceDetails oauth2ResourceDetails;
	
	@Autowired
	public PaymentsClientConfig() {
	}

	public PaymentsClientConfig(PaymentsConfiguration config) {
		this.config = config;
	}

	private ClientHttpRequestFactory clientHttpRequestFactory() {
		ConnectionConfiguration connectionConf = config.getConnection();
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		
		if(connectionConf.getTimeout() != null) {
			clientHttpRequestFactory.setConnectTimeout(connectionConf.getTimeout());
		}
		if(connectionConf.getRequestTimeout() != null) {
		clientHttpRequestFactory.setConnectionRequestTimeout(connectionConf.getRequestTimeout());
		}
		if(connectionConf.getReadTimeout() != null) {
		clientHttpRequestFactory.setReadTimeout(connectionConf.getReadTimeout());
		}
		return clientHttpRequestFactory;
	}

	@Bean
	public OAuth2RestTemplate paymentsRestTemplate() {
		OAuth2RestTemplate template = new OAuth2RestTemplate(oauth2ResourceDetails, oauth2ClientContext);			
		template.setRequestFactory(clientHttpRequestFactory());
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
}
