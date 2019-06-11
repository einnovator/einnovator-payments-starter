package org.einnovator.payments.client.manager;

import java.net.URI;
import java.util.List;

import org.einnovator.payments.client.model.Account;
import org.einnovator.payments.client.model.Card;

public interface AccountManager {

	Account getUserAccount();
	
	URI createUserAccount(Account account);

	Account updateUserAccount(Account user);
	
	Account getAccount(String id);
	
	URI createAccount(Account account);
	
	Account updateAccount(Account user);
	
	boolean deleteAccount(String id);

	List<Card> getAccountCards(String accountId);

	URI addAccountCard(Card card, String accountId);
	
	boolean deleteAccountCard(String accountId, String cardId);
	
}
