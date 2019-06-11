package org.einnovator.payments.client.manager;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.einnovator.payments.client.PaymentsClient;
import org.einnovator.payments.client.model.Tax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class TaxManagerImpl implements TaxManager {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private PaymentsClient paymentsClient;
	
	public TaxManagerImpl() {
	}
	
	@Override
	public List<Tax> listTaxForCountries(String countryCode, Collection<String> otherCountryCodes) {
		try {
			List<Tax> taxes = paymentsClient.listTaxForCountries(countryCode, otherCountryCodes);		
			if (taxes==null) {
				logger.error("getTaxForCountries:" + countryCode + " " + otherCountryCodes);
			}
			return taxes;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error("getTaxForCountries:" + countryCode + "  " + otherCountryCodes + " " + e);				
			}
			return null;
		} catch (RuntimeException e) {
			logger.error("getTaxForCountries:" + countryCode + "  " + otherCountryCodes + " " + e);
			return null;
		}
	}

}
