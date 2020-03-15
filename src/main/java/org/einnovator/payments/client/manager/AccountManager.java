package org.einnovator.payments.client.manager;

import java.net.URI;
import java.util.List;


import org.einnovator.payments.client.model.Account;
import org.einnovator.payments.client.model.Card;
import org.einnovator.payments.client.modelx.AccountOptions;
import org.einnovator.util.web.RequestOptions;

public interface AccountManager {
	
	//
	// Accounts
	//
	
	Account getAccount(String id, AccountOptions options);
	
	URI createAccount(Account account, RequestOptions options);
	
	Account updateAccount(Account account, RequestOptions options);
	
	boolean deleteAccount(String id, RequestOptions options);

	//
	// Cards
	//
	
	List<Card> getAccountCards(String accountId, AccountOptions options);

	URI addAccountCard(Card card, String accountId, RequestOptions options);
	
	boolean deleteAccountCard(String accountId, String cardId, RequestOptions options);
	
}
