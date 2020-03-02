package org.einnovator.payments.client.manager;

import java.net.URI;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.payments.client.PaymentsClient;
import org.einnovator.payments.client.config.PaymentsClientContext;
import org.einnovator.payments.client.model.Tax;
import org.einnovator.payments.client.modelx.TaxFilter;
import org.einnovator.payments.client.modelx.TaxOptions;
import org.einnovator.util.web.RequestOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class TaxManagerImpl extends ManagerBase implements TaxManager {

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private PaymentsClient paymentsClient;
	
	public TaxManagerImpl() {
	}
	
	@Override
	public Page<Tax> listTaxes(TaxFilter filter, Pageable pageable, PaymentsClientContext context) {
		try {
			Page<Tax> taxs = paymentsClient.listTaxes(filter, pageable, context);		
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
	public Tax getTax(String id, TaxOptions options, PaymentsClientContext context) {
		try {
			Tax tax = paymentsClient.getTax(id, options, context);		
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
	public URI createTax(Tax tax, RequestOptions options, PaymentsClientContext context) {
		try {
			return paymentsClient.createTax(tax, options, context);	
		} catch (RuntimeException e) {
			logger.error("createTax:" + e + " " + tax);
			return null;
		}
	}

	@Override
	public Tax updateTax(Tax tax, RequestOptions options, PaymentsClientContext context) {
		try {
			paymentsClient.updateTax(tax, options, context);	
			return tax;
		} catch (RuntimeException e) {
			logger.error("updateTax:" + e + " " + tax);
			return null;
		}
	}

	@Override
	public boolean deleteTax(String id, RequestOptions options, PaymentsClientContext context) {
		try {
			paymentsClient.deleteTax(id, options, context);		
			return true;
		}  catch (RuntimeException e) {
			logger.error("deleteTax:" + id);
			return false;
		}
	}


}
