package org.einnovator.payments.client.config;

import org.einnovator.util.config.ConnectionConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.util.StringUtils;

@ConfigurationProperties("payments")
public class PaymentsConfiguration {

	private String server = "http://localhost:2060";
	
	@NestedConfigurationProperty
	private ConnectionConfiguration connection = new ConnectionConfiguration();
	
	
	public PaymentsConfiguration() {
	}

	/**
	 * Get the value of property {@code server}.
	 *
	 * @return the server
	 */
	public String getServer() {
		return server;
	}

	/**
	 * Set the value of property {@code server}.
	 *
	 * @param server the server to set
	 */
	public void setServer(String server) {
		this.server = server;
	}

	/**
	 * Get the value of property {@code connection}.
	 *
	 * @return the connection
	 */
	public ConnectionConfiguration getConnection() {
		return connection;
	}

	/**
	 * Set the value of property {@code connection}.
	 *
	 * @param connection the connection to set
	 */
	public void setConnection(ConnectionConfiguration connection) {
		this.connection = connection;
	}
	
	public String payEnpoint(String paymentId, String redirectUri, String state) {
		StringBuilder sb = new StringBuilder();
		sb.append(PaymentsEndpoints.pay(paymentId, this));
		if (StringUtils.hasText(redirectUri)) {
			sb.append("?");
			sb.append("redirect_uri=");
			sb.append(redirectUri);
			if (StringUtils.hasText(state)) {
				sb.append("&");
				sb.append("state=");
				sb.append(state);
			}
		}
		return sb.toString();
	}
	
	public String payEnpoint(String paymentId, String redirectUri) {
		return payEnpoint(paymentId, redirectUri, null);
	}

}
