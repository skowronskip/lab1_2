package pl.com.bottega.ecommerce.sales.domain.taxcalculator;

import pl.com.bottega.ecommerce.sales.domain.invoicing.RequestItem;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Tax;

public interface ITaxCalculator {
    Tax calculate(RequestItem requestItem);
}
