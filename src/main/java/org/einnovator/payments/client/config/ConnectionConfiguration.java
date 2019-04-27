package org.einnovator.payments.client.config;

public class ConnectionConfiguration {

	private Integer requestTimeout;
	
	private Integer timeout;
	
	private Integer readTimeout;
	
	public ConnectionConfiguration() {
	}
	
	public Integer getRequestTimeout() {
		return requestTimeout;
	}
	
	public void setRequestTimeout(Integer requestTimeout) {
		this.requestTimeout = requestTimeout;
	}
	
	public Integer getTimeout() {
		return timeout;
	}
	
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
	
	public Integer getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(Integer readTimeout) {
		this.readTimeout = readTimeout;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [" 
				+ (requestTimeout != null ? "requestTimeout=" + requestTimeout + ", " : "")
				+ (timeout != null ? "timeout=" + timeout + ", " : "")
				+ (readTimeout != null ? "readTimeout=" + readTimeout : "") + "]";
	}

	
}
