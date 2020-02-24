package org.einnovator.payments.client.manager;

import java.net.URI;
import java.util.List;

import org.einnovator.payments.client.config.PaymentsClientContext;
import org.einnovator.payments.client.model.Account;
import org.einnovator.payments.client.model.Card;

public interface AccountManager {

	Account getUserAccount(PaymentsClientContext context);
	
	URI createUserAccount(Account account, PaymentsClientContext context);

	Account updateUserAccount(Account account, PaymentsClientContext context);
	
	Account getAccount(String id, PaymentsClientContext context);
	
	URI createAccount(Account account, PaymentsClientContext context);
	
	Account updateAccount(Account user, PaymentsClientContext context);
	
	boolean deleteAccount(String id, PaymentsClientContext context);

	List<Card> getAccountCards(String accountId, PaymentsClientContext context);

	URI addAccountCard(Card card, String accountId, PaymentsClientContext context);
	
	boolean deleteAccountCard(String accountId, String cardId, PaymentsClientContext context);
	
}
