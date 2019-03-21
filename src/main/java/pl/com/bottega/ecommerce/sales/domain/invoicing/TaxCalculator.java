package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.math.BigDecimal;

public interface TaxCalculator {
	Tax calculateTax(RequestItem item, BigDecimal ratio, String desc);
}
