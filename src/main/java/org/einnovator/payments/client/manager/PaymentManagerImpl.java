package org.einnovator.payments.client.manager;

import java.net.URI;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.payments.client.PaymentsClient;
import org.einnovator.payments.client.model.Payment;
import org.einnovator.payments.client.modelx.PaymentFilter;
import org.einnovator.payments.client.modelx.PaymentOptions;
import org.einnovator.util.UriUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class PaymentManagerImpl extends ManagerBase implements PaymentManager {

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private PaymentsClient paymentsClient;
	
	public PaymentManagerImpl() {
	}
	
	@Override
	public URI submitPayment(Payment payment, PaymentOptions options) {
		try {
			URI uri = paymentsClient.submitPayment(payment, options);
			payment.setUuid(UriUtils.extractId(uri));
			return uri;
		} catch (RuntimeException e) {
			logger.error("submitPayment:" + e + " " + payment);
			return null;
		}
	}


	@Override
	public Payment chargePayment(Payment payment, PaymentOptions options) {
		try {
			paymentsClient.chargePayment(payment, options);	
			return payment;
		} catch (RuntimeException e) {
			logger.error("chargePayment:" + e + " " + payment);
			return null;
		}
	}
	
	@Override
	public Payment getPayment(String id, PaymentOptions options) {
		try {
			Payment payment = paymentsClient.getPayment(id, options);		
			if (payment==null) {
				logger.error("getPayment:" + id);
			}
			return payment;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error("getPayment:" + id + "  " + e);				
			}
			return null;
		} catch (RuntimeException e) {
			logger.error("getPayment:" + id + "  " + e);
			return null;
		}
	}

	@Override
	public Page<Payment> listPayments(PaymentFilter filter, Pageable pageable) {
		try {
			Page<Payment> payments = paymentsClient.listPayments(filter, pageable);		
			if (payments==null) {
				logger.error("listPayments:" + filter + " " + pageable);
			}
			return payments;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error("listPayments:" + filter + " " + pageable);				
			}
			return null;
		} catch (RuntimeException e) {
			logger.error("listPayments:" + filter + " " + pageable);
			return null;
		}
	}

	@Override
	public Payment updatePayment(Payment payment, PaymentOptions options) {
		try {
			paymentsClient.updatePayment(payment, options);	
			return payment;
		} catch (RuntimeException e) {
			logger.error("updatePayment:" + e + " " + payment);
			return null;
		}
	}


	@Override
	public boolean deletePayment(String id, PaymentOptions options) {
		try {
			paymentsClient.deletePayment(id, options);		
			return true;
		} catch (RuntimeException e) {
			logger.error("deletePayment:" + id + "  " + e);
			return false;
		}
	}

}
