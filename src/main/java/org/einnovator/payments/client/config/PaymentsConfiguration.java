package org.einnovator.payments.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties("payments")
public class PaymentsConfiguration {

	private String uri = "http://localhost:9091";
	
	@NestedConfigurationProperty
	private ConnectionConfiguration connection = new ConnectionConfiguration();
	
	public PaymentsConfiguration() {
	}

	public String getUri() {
		return uri;
	}


	public void setUri(String uri) {
		this.uri = uri;
	}


	public ConnectionConfiguration getConnection() {
		return connection;
	}


	public void setConnection(ConnectionConfiguration connection) {
		this.connection = connection;
	}
	
}
