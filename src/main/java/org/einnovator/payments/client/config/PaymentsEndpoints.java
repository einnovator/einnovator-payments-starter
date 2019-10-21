package org.einnovator.payments.client.config;

import java.util.Collection;

import org.springframework.web.util.UriComponentsBuilder;

public class PaymentsEndpoints {

	public static String payments(PaymentsConfiguration config) {
		return config.getServer() + "/api/payment";
	}

	public static String payment(String id, PaymentsConfiguration config) {
		return payments(config) + "/" + id;
	}

	public static String charge(String id, PaymentsConfiguration config) {
		return payments(config) + "/" + id + "/charge";
	}

	public static String pay(String id, PaymentsConfiguration config) {
		return  config.getServer() + "/payment/" + id + "/pay";
	}

	public static String userAccount(PaymentsConfiguration config) {
		return config.getServer() + "/api/account/user";
	}

	public static String accounts(PaymentsConfiguration config) {
		return config.getServer() + "/api/account";
	}

	public static String account(String id, PaymentsConfiguration config) {
		return accounts(config) + "/" + id;
	}

	public static String cards(String accountId, PaymentsConfiguration config) {
		return config.getServer() + "/api/account/" + accountId + "/card";
	}

	public static String card(String accountId, String cardId, PaymentsConfiguration config) {
		return cards(accountId, config) + cardId;
	}

	public static String bankAccounts(String accountId, PaymentsConfiguration config) {
		return config.getServer() + "/api/account/" + accountId + "/bankaccount";
	}

	public static String bankAccount(String accountId, String bankAccountId, PaymentsConfiguration config) {
		return bankAccounts(accountId, config) + bankAccountId;
	}

	public static String taxes(PaymentsConfiguration config) {
		return config.getServer() + "/api/tax";
	}

	public static String tax(String id, PaymentsConfiguration config) {
		return taxes(config) + "/" + id;
	}

	public static String getTaxForCountries(String country, Collection<String> countryCodes, PaymentsConfiguration config) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString((config.getServer() + "/api/payment/tax/{country}")).queryParam("countries", String.join(",", countryCodes));
		return  builder.buildAndExpand(country).toUriString();
	}

}
