package org.einnovator.payments.client.manager;

import java.net.URI;

import org.einnovator.payments.client.model.Payment;
import org.einnovator.payments.client.modelx.PaymentFilter;
import org.einnovator.payments.client.modelx.PaymentOptions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentManager {

	Payment getPayment(String id, PaymentOptions options);

	Page<Payment> listPayments(PaymentFilter filter, Pageable pageable);

	URI submitPayment(Payment payment, PaymentOptions options);

	Payment chargePayment(Payment payment, PaymentOptions options);

	Payment updatePayment(Payment payment, PaymentOptions options);

	boolean deletePayment(String id, PaymentOptions options);

}
