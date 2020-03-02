package org.einnovator.payments.client.manager;

import java.net.URI;

import org.einnovator.payments.client.config.PaymentsClientContext;
import org.einnovator.payments.client.model.Payment;
import org.einnovator.payments.client.modelx.PaymentFilter;
import org.einnovator.payments.client.modelx.PaymentOptions;
import org.einnovator.util.web.RequestOptions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentManager {

	Payment getPayment(String id, PaymentOptions options, PaymentsClientContext context);

	Page<Payment> listPayments(PaymentFilter filter, Pageable pageable, PaymentsClientContext context);

	URI submitPayment(Payment payment, PaymentOptions options, PaymentsClientContext context);

	Payment chargePayment(Payment payment, RequestOptions options, PaymentsClientContext context);

	Payment updatePayment(Payment payment, RequestOptions options, PaymentsClientContext context);

	boolean deletePayment(String id, RequestOptions options, PaymentsClientContext context);

}
