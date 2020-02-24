package org.einnovator.payments.client.manager;

import java.net.URI;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.payments.client.PaymentsClient;
import org.einnovator.payments.client.config.PaymentsClientContext;
import org.einnovator.payments.client.model.Account;
import org.einnovator.payments.client.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class AccountManagerImpl extends ManagerBase implements AccountManager {

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private PaymentsClient paymentsClient;
	
	public AccountManagerImpl() {
	}
	
	@Override
	public URI createUserAccount(Account account, PaymentsClientContext context) {
		try {
			return paymentsClient.createUserAccount(account, context);	
		} catch (RuntimeException e) {
			logger.error("createUser:" + e + " " + account);
			return null;
		}
	}

	@Override
	public Account getUserAccount(PaymentsClientContext context) {
		try {
			Account account = paymentsClient.getUserAccount(context);		
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
	public Account updateUserAccount(Account account, PaymentsClientContext context) {
		try {
			paymentsClient.updateUserAccount(account, context);	
			return account;
		} catch (RuntimeException e) {
			logger.error("updateUser:" + e + " " + account);
			return null;
		}
	}

	@Override
	public Account getAccount(String id, PaymentsClientContext context) {
		try {
			Account account = paymentsClient.getAccount(id, context);		
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
	public URI createAccount(Account account, PaymentsClientContext context) {
		try {
			return paymentsClient.createAccount(account, context);	
		} catch (RuntimeException e) {
			logger.error("createAccount:" + e + " " + account);
			return null;
		}
	}

	@Override
	public Account updateAccount(Account account, PaymentsClientContext context) {
		try {
			paymentsClient.updateAccount(account, context);	
			return account;
		} catch (RuntimeException e) {
			logger.error("updateAccount:" + e + " " + account);
			return null;
		}
	}

	@Override
	public boolean deleteAccount(String id, PaymentsClientContext context) {
		try {
			paymentsClient.deleteAccount(id, context);		
			return true;
		}  catch (RuntimeException e) {
			logger.error("deleteAccount:" + id);
			return false;
		}
	}

	@Override
	public List<Card> getAccountCards(String accountId, PaymentsClientContext context) {
		try {
			List<Card> cards = paymentsClient.getAccountCards(accountId, context);		
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
	public URI addAccountCard(Card card, String accountId, PaymentsClientContext context) {
		try {
			return paymentsClient.addAccountCard(card, accountId, context);	
		} catch (RuntimeException e) {
			logger.error("addUserCard:" + e + " " + card + " " + accountId);
			return null;
		}
	}

	@Override
	public boolean deleteAccountCard(String accountId, String cardId, PaymentsClientContext context) {
		try {
			paymentsClient.deleteAccountCard(accountId, cardId, context);		
			return true;
		}  catch (RuntimeException e) {
			logger.error("deleteUserCard:" + cardId);
			return false;
		}
	}


}
