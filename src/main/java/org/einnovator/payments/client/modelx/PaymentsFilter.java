package org.einnovator.payments.client.modelx;

import java.util.List;

import org.einnovator.payments.client.model.PaymentStatus;


public class PaymentsFilter {
	
	private List<PaymentStatus> paymentStatus;

	public List<PaymentStatus> getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(List<PaymentStatus> paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "PaymentsFilter [" + (paymentStatus != null ? "paymentStatus=" + paymentStatus : "") + "]";
	}

}
