package pl.com.bottega.ecommerce.sales.domain.invoicing;

public interface TaxCalculator {

    Tax calculte(RequestItem item);

}
