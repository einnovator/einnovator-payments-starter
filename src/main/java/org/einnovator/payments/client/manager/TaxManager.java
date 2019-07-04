package org.einnovator.payments.client.manager;

import java.net.URI;

import org.einnovator.payments.client.model.Tax;
import org.einnovator.payments.client.modelx.TaxFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaxManager {

	Page<Tax> listTaxes(TaxFilter filter, Pageable pageable);
	
	Tax getTax(String id);

	URI createTax(Tax tax);
	
	Tax updateTax(Tax user);
	
	boolean deleteTax(String id);
}
