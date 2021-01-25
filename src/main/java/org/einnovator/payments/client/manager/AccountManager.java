package org.einnovator.payments.client.manager;

import java.net.URI;
import java.util.List;

import org.einnovator.payments.client.model.Account;
import org.einnovator.payments.client.model.Card;
import org.einnovator.payments.client.modelx.AccountOptions;

public interface AccountManager {
	
	//
	// Accounts
	//
	
	Account getAccount(String id, AccountOptions options);
	
	URI createAccount(Account account, AccountOptions options);
	
	Account updateAccount(Account account, AccountOptions options);
	
	boolean deleteAccount(String id, AccountOptions options);

	//
	// Cards
	//
	
	List<Card> getAccountCards(String accountId, AccountOptions options);

	URI addAccountCard(String accountId, Card card, AccountOptions options);
	
	boolean deleteAccountCard(String accountId, String cardId, AccountOptions options);
	
}
