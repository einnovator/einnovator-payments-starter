package org.einnovator.payments.client.manager;

import java.net.URI;

import org.apache.log4j.Logger;
import org.einnovator.payments.client.PaymentsClient;
import org.einnovator.payments.client.model.Tax;
import org.einnovator.payments.client.modelx.TaxFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class TaxManagerImpl implements TaxManager {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private PaymentsClient paymentsClient;
	
	public TaxManagerImpl() {
	}
	
	@Override
	public Page<Tax> listTaxes(TaxFilter filter, Pageable pageable) {
		try {
			Page<Tax> taxs = paymentsClient.listTaxes(filter, pageable);		
			if (taxs==null) {
				logger.error("listTaxes:" + filter + " " + pageable);
			}
			return taxs;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error("listTaxes:" + filter + " " + pageable);				
			}
			return null;
		} catch (RuntimeException e) {
			logger.error("listTaxes:" + e + " " + filter + " " + pageable);
			return null;
		}
	}

	@Override
	public Tax getTax(String id) {
		try {
			Tax tax = paymentsClient.getTax(id);		
			if (tax==null) {
				logger.error("getTax:" + id);
			}
			return tax;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error("getTax:" + id + "  " + e);				
			}
			return null;
		} catch (RuntimeException e) {
			logger.error("getTax:" + id + "  " + e);
			return null;
		}
	}

	@Override
	public URI createTax(Tax tax) {
		try {
			return paymentsClient.createTax(tax);	
		} catch (RuntimeException e) {
			logger.error("createTax:" + e + " " + tax);
			return null;
		}
	}

	@Override
	public Tax updateTax(Tax tax) {
		try {
			paymentsClient.updateTax(tax);	
			return tax;
		} catch (RuntimeException e) {
			logger.error("updateTax:" + e + " " + tax);
			return null;
		}
	}

	@Override
	public boolean deleteTax(String id) {
		try {
			paymentsClient.deleteTax(id);		
			return true;
		}  catch (RuntimeException e) {
			logger.error("deleteTax:" + id);
			return false;
		}
	}


}
