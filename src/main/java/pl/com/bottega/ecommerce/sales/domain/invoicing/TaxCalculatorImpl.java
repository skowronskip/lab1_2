package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;

import java.math.BigDecimal;

public class TaxCalculatorImpl implements TaxCalculator {

    @Override public TaxType calculate(ProductType productType) {
        switch (productType) {
            case FOOD:
                return new TaxType(BigDecimal.valueOf(0.07), "7% (F)");
            case STANDARD:
                return new TaxType(BigDecimal.valueOf(0.23), "23%");
            case DRUG:
                return new TaxType(BigDecimal.valueOf(0.05), "5% (D)");
            default:
                throw new IllegalArgumentException(productType + " not handled");
        }
    }
}
