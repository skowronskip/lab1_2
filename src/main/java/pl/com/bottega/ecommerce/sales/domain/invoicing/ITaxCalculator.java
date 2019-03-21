package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.math.BigDecimal;

public interface ITaxCalculator {
	Tax calculateTax(RequestItem item);
}
