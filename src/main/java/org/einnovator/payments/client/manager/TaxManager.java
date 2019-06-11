package org.einnovator.payments.client.manager;

import java.util.Collection;
import java.util.List;

import org.einnovator.payments.client.model.Tax;

public interface TaxManager {

	List<Tax> listTaxForCountries(String countryCode, Collection<String> otherCountryCodes);
}
