package org.einnovator.payments.client.manager;

import java.net.URI;
import java.util.Collection;
import java.util.List;

import org.einnovator.payments.client.model.Account;
import org.einnovator.payments.client.model.CreditCard;
import org.einnovator.payments.client.model.Payment;
import org.einnovator.payments.client.model.Tax;
import org.einnovator.payments.client.modelx.PaymentsFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentManager {

	URI submitPayment(Payment payment);

	Payment getPayment(String id);

	Page<Payment> listPayments(Pageable pageable, PaymentsFilter filter);

	Payment updatePayment(Payment payment);

	URI createUser(Account account);
	
	Account getUser(String username);
	
	Account getPrincipalUser();
	
	Account updateUser(Account user);
	
//	Account updateUserFullState(Account user);

//	Account updateUser(Account user/*, boolean fullState*/);
	
	Account updatePrincipalUser(Account user);
	
	boolean deleteUser(String id);

	URI addUserCard(CreditCard card, String id);
	
	CreditCard[] getUserCard(String id);
	
	boolean deleteUserCard(String cardId);
	
	URI addOrganizationCard(CreditCard card, String orgId);
	
	Account getOrganization(String id);
	
	URI createOrganization(Account account);
	
	Account updateOrganization(Account user);
	
	boolean deleteOrganization(String id);

	CreditCard[] getOrganizationCard(String orgId);

	List<Tax> getTaxForCountries(String countryCode, Collection<String> otherCountryCodes);
}
