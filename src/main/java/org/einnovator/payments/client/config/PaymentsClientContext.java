/**
 * 
 */
package org.einnovator.payments.client.config;

import org.einnovator.util.web.ClientContext;

/**
 *
 */
public class PaymentsClientContext extends ClientContext {
	
	private PaymentsClientConfiguration config;
	
	/**
	 * Create instance of {@code DocumentsClientContext}.
	 *
	 */
	public PaymentsClientContext() {
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
	
}
