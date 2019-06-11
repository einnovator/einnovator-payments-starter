package org.einnovator.payments.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

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
	
}
