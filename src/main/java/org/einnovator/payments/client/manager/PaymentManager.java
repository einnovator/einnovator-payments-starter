package org.einnovator.payments.client.manager;

import java.net.URI;

import org.einnovator.payments.client.config.PaymentsClientContext;
import org.einnovator.payments.client.model.Payment;
import org.einnovator.payments.client.modelx.PaymentFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentManager {

	URI submitPayment(Payment payment, PaymentsClientContext context);

	Payment chargePayment(Payment payment, PaymentsClientContext context);

	Payment getPayment(String id, PaymentsClientContext context);

	Page<Payment> listPayments(PaymentFilter filter, Pageable pageable, PaymentsClientContext context);

	Payment updatePayment(Payment payment, PaymentsClientContext context);

	boolean deletePayment(String id, PaymentsClientContext context);

}
