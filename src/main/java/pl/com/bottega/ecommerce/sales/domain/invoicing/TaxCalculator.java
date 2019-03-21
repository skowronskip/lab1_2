package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;

public interface TaxCalculator {

    TaxInfo calculate(ProductType productType);
}
