package pl.com.bottega.ecommerce.sales.domain.invoicing;

public interface ITaxCalculator {
	Tax calculateTax(RequestItem item);
}
