package org.einnovator.payments.client.manager;

import java.net.URI;
import java.util.List;

import org.apache.log4j.Logger;
import org.einnovator.payments.client.PaymentsClient;
import org.einnovator.payments.client.model.Account;
import org.einnovator.payments.client.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class AccountManagerImpl implements AccountManager {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private PaymentsClient paymentsClient;
	
	public AccountManagerImpl() {
	}
	
	@Override
	public URI createUserAccount(Account account) {
		try {
			return paymentsClient.createUserAccount(account);	
		} catch (RuntimeException e) {
			logger.error("createUser:" + e + " " + account);
			return null;
		}
	}

	@Override
	public Account getUserAccount() {
		try {
			Account account = paymentsClient.getUserAccount();		
			if (account==null) {
				logger.error("getUserAccount:");
			}
			return account;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error("getUser:" + e);				
			}
			return null;
		} catch (RuntimeException e) {
			logger.error("getUser:" + e);
			return null;
		}
	}


	@Override
	public Account updateUserAccount(Account account) {
		try {
			paymentsClient.updateUserAccount(account);	
			return account;
		} catch (RuntimeException e) {
			logger.error("updateUser:" + e + " " + account);
			return null;
		}
	}

	@Override
	public Account getAccount(String id) {
		try {
			Account account = paymentsClient.getAccount(id);		
			if (account==null) {
				logger.error("getAccount:" + id);
			}
			return account;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error("getAccount:" + id + "  " + e);				
			}
			return null;
		} catch (RuntimeException e) {
			logger.error("getAccount:" + id + "  " + e);
			return null;
		}
	}

	@Override
	public URI createAccount(Account account) {
		try {
			return paymentsClient.createAccount(account);	
		} catch (RuntimeException e) {
			logger.error("createAccount:" + e + " " + account);
			return null;
		}
	}

	@Override
	public Account updateAccount(Account account) {
		try {
			paymentsClient.updateAccount(account);	
			return account;
		} catch (RuntimeException e) {
			logger.error("updateAccount:" + e + " " + account);
			return null;
		}
	}

	@Override
	public boolean deleteAccount(String id) {
		try {
			paymentsClient.deleteAccount(id);		
			return true;
		}  catch (RuntimeException e) {
			logger.error("deleteAccount:" + id);
			return false;
		}
	}

	@Override
	public List<Card> getAccountCards(String accountId) {
		try {
			List<Card> cards = paymentsClient.getAccountCards(accountId);		
			if (cards==null) {
				logger.error("getAccountCard:" + accountId);
			}
			return cards;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error("getAccountCard:" + accountId + "  " + e);				
			}
			return null;
		} catch (RuntimeException e) {
			logger.error("getAccountCard:" + accountId + "  " + e);
			return null;
		}
	}

	@Override
	public URI addAccountCard(Card card, String accountId) {
		try {
			return paymentsClient.addAccountCard(card, accountId);	
		} catch (RuntimeException e) {
			logger.error("addUserCard:" + e + " " + card + " " + accountId);
			return null;
		}
	}

	@Override
	public boolean deleteAccountCard(String accountId, String cardId) {
		try {
			paymentsClient.deleteAccountCard(accountId, cardId);		
			return true;
		}  catch (RuntimeException e) {
			logger.error("deleteUserCard:" + cardId);
			return false;
		}
	}


}
