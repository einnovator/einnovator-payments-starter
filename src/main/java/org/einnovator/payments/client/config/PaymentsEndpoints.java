package org.einnovator.payments.client.config;

import java.util.Collection;

import org.springframework.web.util.UriComponentsBuilder;

public class PaymentsEndpoints {

	public static String payments(PaymentsClientConfiguration config) {
		return config.getServer() + "/api/payment";
	}

	public static String payment(String id, PaymentsClientConfiguration config) {
		return payments(config) + "/" + id;
	}

	public static String charge(String id, PaymentsClientConfiguration config) {
		return payments(config) + "/" + id + "/charge";
	}

	public static String pay(String id, PaymentsClientConfiguration config) {
		return  config.getServer() + "/payment/" + id + "/pay";
	}

	public static String userAccount(PaymentsClientConfiguration config) {
		return config.getServer() + "/api/account/user";
	}

	public static String accounts(PaymentsClientConfiguration config) {
		return config.getServer() + "/api/account";
	}

	public static String account(String id, PaymentsClientConfiguration config) {
		return accounts(config) + "/" + id;
	}

	public static String cards(String accountId, PaymentsClientConfiguration config) {
		return config.getServer() + "/api/account/" + accountId + "/card";
	}

	public static String card(String accountId, String cardId, PaymentsClientConfiguration config) {
		return cards(accountId, config) + cardId;
	}

	public static String bankAccounts(String accountId, PaymentsClientConfiguration config) {
		return config.getServer() + "/api/account/" + accountId + "/bankaccount";
	}

	public static String bankAccount(String accountId, String bankAccountId, PaymentsClientConfiguration config) {
		return bankAccounts(accountId, config) + bankAccountId;
	}

	public static String taxes(PaymentsClientConfiguration config) {
		return config.getServer() + "/api/tax";
	}

	public static String tax(String id, PaymentsClientConfiguration config) {
		return taxes(config) + "/" + id;
	}

	public static String getTaxForCountries(String country, Collection<String> countryCodes, PaymentsClientConfiguration config) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString((config.getServer() + "/api/payment/tax/{country}")).queryParam("countries", String.join(",", countryCodes));
		return  builder.buildAndExpand(country).toUriString();
	}

}
