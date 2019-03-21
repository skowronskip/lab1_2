package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;

public interface TaxCalculator {

    TaxType calculate(ProductType productType);

}
