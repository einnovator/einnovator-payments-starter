package org.einnovator.payments.client.manager;

import java.net.URI;

import org.einnovator.payments.client.model.Payment;
import org.einnovator.payments.client.modelx.PaymentFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentManager {

	URI submitPayment(Payment payment);

	Payment chargePayment(Payment payment);

	Payment getPayment(String id);

	Page<Payment> listPayments(PaymentFilter filter, Pageable pageable);

	Payment updatePayment(Payment payment);

	boolean deletePayment(String id);

}
