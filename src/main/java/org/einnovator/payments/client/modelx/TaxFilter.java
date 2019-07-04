package org.einnovator.payments.client.modelx;

import org.einnovator.util.model.ToStringCreator;

public class TaxFilter extends TaxOptions {
	
	private String q;	

	private String countryCode2;

	public TaxFilter() {
	}


	/**
	 * Get the value of property {@code q}.
	 *
	 * @return the q
	 */
	public String getQ() {
		return q;
	}

	/**
	 * Set the value of property {@code q}.
	 *
	 * @param q the q to set
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * Get the value of property {@code countryCode2}.
	 *
	 * @return the countryCode2
	 */
	public String getCountryCode2() {
		return countryCode2;
	}

	/**
	 * Set the value of property {@code countryCode2}.
	 *
	 * @param countryCode2 the countryCode2 to set
	 */
	public void setCountryCode2(String countryCode2) {
		this.countryCode2 = countryCode2;
	}

	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator
				.append("q", q)
				.append("countryCode2", countryCode2)
				);
	}

}
