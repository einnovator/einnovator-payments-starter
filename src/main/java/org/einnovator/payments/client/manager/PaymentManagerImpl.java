package org.einnovator.payments.client.manager;

import java.net.URI;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.einnovator.payments.client.PaymentsClient;
import org.einnovator.payments.client.model.Account;
import org.einnovator.payments.client.model.CreditCard;
import org.einnovator.payments.client.model.Payment;
import org.einnovator.payments.client.model.Tax;
import org.einnovator.payments.client.modelx.PaymentsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class PaymentManagerImpl implements PaymentManager {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private PaymentsClient paymentsClient;
	
	public PaymentManagerImpl() {
	}
	
	@Override
	public URI submitPayment(Payment payment) {
		try {
			return paymentsClient.submitPayment(payment);	
		} catch (RuntimeException e) {
			logger.error("submitPayment:" + e + " " + payment);
			return null;
		}
	}

	@Override
	public Payment getPayment(String id) {
		try {
			Payment payment = paymentsClient.getPayment(id);		
			if (payment==null) {
				logger.error("getPayment:" + id);
			}
			return payment;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error("getPayment:" + id + "  " + e);				
			}
			return null;
		} catch (RuntimeException e) {
			logger.error("getPayment:" + id + "  " + e);
			return null;
		}
	}

	@Override
	public Page<Payment> listPayments(Pageable pageable, PaymentsFilter filter) {
		try {
			Page<Payment> payments = paymentsClient.listPayments(pageable, filter);		
			if (payments==null) {
				logger.error("listPayments:" + filter + " " + pageable);
			}
			return payments;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error("listPayments:" + filter + " " + pageable);				
			}
			return null;
		} catch (RuntimeException e) {
			logger.error("listPayments:" + filter + " " + pageable);
			return null;
		}
	}

	@Override
	public Payment updatePayment(Payment payment) {
		try {
			paymentsClient.updatePayment(payment);	
			return payment;
		} catch (RuntimeException e) {
			logger.error("updatePayment:" + e + " " + payment);
			return null;
		}
	}

	@Override
	public URI createUser(Account account) {
		try {
			return paymentsClient.createUser(account);	
		} catch (RuntimeException e) {
			logger.error("createUser:" + e + " " + account);
			return null;
		}
	}

	@Override
	public Account getUser(String username) {
		try {
			Account account = paymentsClient.getUser(username);		
			if (account==null) {
				logger.error("getUser:" + username);
			}
			return account;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error("getUser:" + username + "  " + e);				
			}
			return null;
		} catch (RuntimeException e) {
			logger.error("getUser:" + username + "  " + e);
			return null;
		}
	}

	@Override
	public Account getPrincipalUser() {
		try {
			Account account = paymentsClient.getPrincipalUser();		
			if (account==null) {
				logger.error("getPrincipalUser:");
			}
			return account;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error("getPrincipalUser:");				
			}
			return null;
		} catch (RuntimeException e) {
			logger.error("getPrincipalUser:" + e);
			return null;
		}
	}

	@Override
	public Account updateUser(Account user) {
		try {
			paymentsClient.updateUser(user);	
			return user;
		} catch (RuntimeException e) {
			logger.error("updateUser:" + e + " " + user);
			return null;
		}
	}

//	@Override
//	public Account updateUserFullState(Account user) {
//		try {
//			paymentsClient.updateUserFullState(user);	
//			return user;
//		} catch (RuntimeException e) {
//			logger.error("updateUserFullState:" + e + " " + user);
//			return null;
//		}
//	}

//	@Override
//	public Account updateUser(Account user, boolean fullState) {
//		try {
//			paymentsClient.updateUser(user, fullState);	
//			return user;
//		} catch (RuntimeException e) {
//			logger.error("updateUser:" + e + " " + user);
//			return null;
//		}
//	}

	@Override
	public Account updatePrincipalUser(Account user) {
		try {
			paymentsClient.updatePrincipalUser(user);	
			return user;
		} catch (RuntimeException e) {
			logger.error("updatePrincipalUser:" + e + " " + user);
			return null;
		}
	}

	@Override
	public boolean deleteUser(String id) {
		try {
			paymentsClient.deleteUser(id);		
			return true;
		}  catch (RuntimeException e) {
			logger.error("deleteUser:" + id);
			return false;
		}
	}

	@Override
	public URI addUserCard(CreditCard card, String id) {
		try {
			return paymentsClient.addUserCard(card, id);	
		} catch (RuntimeException e) {
			logger.error("addUserCard:" + e + " " + card + " " + id);
			return null;
		}
	}

	@Override
	public CreditCard[] getUserCard(String id) {
		try {
			CreditCard[] cards = paymentsClient.getUserCard(id);		
			if (cards==null) {
				logger.error("getUserCard:" + id);
			}
			return cards;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error("getUserCard:" + id);				
			}
			return null;
		} catch (RuntimeException e) {
			logger.error("getUserCard:" + id);
			return null;
		}
	}

	@Override
	public boolean deleteUserCard(String cardId) {
		try {
			paymentsClient.deleteUserCard(cardId);		
			return true;
		}  catch (RuntimeException e) {
			logger.error("deleteUserCard:" + cardId);
			return false;
		}
	}

	@Override
	public URI addOrganizationCard(CreditCard card, String orgId) {
		try {
			return paymentsClient.addOrganizationCard(card, orgId);	
		} catch (RuntimeException e) {
			logger.error("addOrganizationCard:" + e + " " + card);
			return null;
		}
	}

	@Override
	public Account getOrganization(String id) {
		try {
			Account account = paymentsClient.getOrganization(id);		
			if (account==null) {
				logger.error("getOrganization:" + id);
			}
			return account;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error("getOrganization:" + id + "  " + e);				
			}
			return null;
		} catch (RuntimeException e) {
			logger.error("getOrganization:" + id + "  " + e);
			return null;
		}
	}

	@Override
	public URI createOrganization(Account account) {
		try {
			return paymentsClient.createOrganization(account);	
		} catch (RuntimeException e) {
			logger.error("createOrganization:" + e + " " + account);
			return null;
		}
	}

	@Override
	public Account updateOrganization(Account account) {
		try {
			paymentsClient.updateOrganization(account);	
			return account;
		} catch (RuntimeException e) {
			logger.error("updateOrganization:" + e + " " + account);
			return null;
		}
	}

	@Override
	public boolean deleteOrganization(String id) {
		try {
			paymentsClient.deleteOrganization(id);		
			return true;
		}  catch (RuntimeException e) {
			logger.error("deleteOrganization:" + id);
			return false;
		}
	}

	@Override
	public CreditCard[] getOrganizationCard(String orgId) {
		try {
			CreditCard[] cards = paymentsClient.getOrganizationCard(orgId);		
			if (cards==null) {
				logger.error("getOrganizationCard:" + orgId);
			}
			return cards;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error("getOrganizationCard:" + orgId + "  " + e);				
			}
			return null;
		} catch (RuntimeException e) {
			logger.error("getOrganizationCard:" + orgId + "  " + e);
			return null;
		}
	}

	@Override
	public List<Tax> getTaxForCountries(String countryCode, Collection<String> otherCountryCodes) {
		try {
			List<Tax> taxes = paymentsClient.getTaxForCountries(countryCode, otherCountryCodes);		
			if (taxes==null) {
				logger.error("getTaxForCountries:" + countryCode + " " + otherCountryCodes);
			}
			return taxes;
		} catch (HttpStatusCodeException e) {
			if (e.getStatusCode()!=HttpStatus.NOT_FOUND) {
				logger.error("getTaxForCountries:" + countryCode + "  " + otherCountryCodes + " " + e);				
			}
			return null;
		} catch (RuntimeException e) {
			logger.error("getTaxForCountries:" + countryCode + "  " + otherCountryCodes + " " + e);
			return null;
		}
	}

}
