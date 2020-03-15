package org.einnovator.payments.client.manager;

import java.net.URI;


import org.einnovator.payments.client.model.Tax;
import org.einnovator.payments.client.modelx.TaxFilter;
import org.einnovator.payments.client.modelx.TaxOptions;
import org.einnovator.util.web.RequestOptions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaxManager {

	Page<Tax> listTaxes(TaxFilter filter, Pageable pageable);
	
	Tax getTax(String id, TaxOptions options);

	URI createTax(Tax tax, RequestOptions options);
	
	Tax updateTax(Tax user, RequestOptions options);
	
	boolean deleteTax(String id, RequestOptions options);
}
