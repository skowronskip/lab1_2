package pl.com.bottega.ecommerce.sales.domain.invoicing;

public interface TaxCalculationStrategy {

    Tax calculate(RequestItem item);

}
