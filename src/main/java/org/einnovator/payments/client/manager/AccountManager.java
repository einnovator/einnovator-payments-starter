package org.einnovator.payments.client.manager;

import java.net.URI;
import java.util.List;

import org.einnovator.payments.client.config.PaymentsClientContext;
import org.einnovator.payments.client.model.Account;
import org.einnovator.payments.client.model.Card;
import org.einnovator.payments.client.modelx.AccountOptions;
import org.einnovator.util.web.RequestOptions;

public interface AccountManager {
	
	//
	// Accounts
	//
	
	Account getAccount(String id, AccountOptions options, PaymentsClientContext context);
	
	URI createAccount(Account account, RequestOptions options, PaymentsClientContext context);
	
	Account updateAccount(Account account, RequestOptions options, PaymentsClientContext context);
	
	boolean deleteAccount(String id, RequestOptions options, PaymentsClientContext context);

	//
	// Cards
	//
	
	List<Card> getAccountCards(String accountId, AccountOptions options, PaymentsClientContext context);

	URI addAccountCard(Card card, String accountId, RequestOptions options, PaymentsClientContext context);
	
	boolean deleteAccountCard(String accountId, String cardId, RequestOptions options, PaymentsClientContext context);
	
}
