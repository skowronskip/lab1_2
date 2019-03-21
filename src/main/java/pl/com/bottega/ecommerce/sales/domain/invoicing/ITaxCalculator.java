package pl.com.bottega.ecommerce.sales.domain.invoicing;

interface ITaxCalculator {
    Tax calculate(RequestItem item);
}
