package org.einnovator.payments.client.config;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import org.springframework.web.util.UriComponentsBuilder;

public class PaymentsEndpoints {

	public static String payments(PaymentsConfiguration config) {
		return config.getUri() + "/api/payment";
	}

	public static String payment(String id, PaymentsConfiguration config) {
		return config.getUri() + "/api/payment/" + id;
	}
	
	public static String updatePayment(String id, PaymentsConfiguration config) {
		return config.getUri() + "/api/payment/" + id;
	}

	public static String listPayments(PaymentsConfiguration config) {
		return config.getUri() + "/api/payment/list";
	}
	
	public static String userPayments(String id, PaymentsConfiguration config) {
		return config.getUri() + "/api/user/"+id+"/payments";
	}

	public static String users(PaymentsConfiguration config) {
		return config.getUri() + "/api/user";
	}

	public static String user(String id, PaymentsConfiguration config) {
		return config.getUri() + "/api/user/" + id;
	}

	public static String organizations(PaymentsConfiguration config) {
		return config.getUri() + "/api/organization";
	}

	public static String organization(String id, PaymentsConfiguration config) {
		return config.getUri() + "/api/organization/" + id;
	}

	public static String userCard(String accountId, PaymentsConfiguration config) {
		return config.getUri() + "/api/user/" + accountId + "/card";
	}

	public static String organizationCard(String orgId, PaymentsConfiguration config) {
		return config.getUri() + "/api/organization/" + orgId + "/card";
	}

	public static String userCardDelete(String cardId, PaymentsConfiguration config) {
		return config.getUri() + "/api/card/" + cardId;
	}
	
	public static String getTaxForCountry(String countryCode, PaymentsConfiguration config) {
		return config.getUri() + "/api/payment/tax/" + countryCode;
	}
	
	public static String getTaxForCountries(String country, Collection<String> countryCodes, PaymentsConfiguration config) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString((config.getUri() + "/api/payment/tax/{country}")).queryParam("countries", String.join(",", countryCodes));
		return  builder.buildAndExpand(country).toUriString();
	}
	
	public static URI makeURI(String uri) {
		try {
			return new URI(uri);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}		
	}

}
