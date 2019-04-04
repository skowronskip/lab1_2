package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

public class DefaultTaxCalculator implements TaxCalculator {

    @Override public Tax calculateTax(RequestItem invoiceRequestItem) {
        Money net = invoiceRequestItem.getTotalCost();
        BigDecimal ratio = null;
        String desc = null;

        switch (invoiceRequestItem.getProductData().getType()) {
            case FOOD:
                ratio = BigDecimal.valueOf(0.07);
                desc = "7% (F)";
                break;
            case STANDARD:
                ratio = BigDecimal.valueOf(0.23);
                desc = "23%";
                break;
            case DRUG:
                ratio = BigDecimal.valueOf(0.05);
                desc = "5% (D)";
                break;
            default:
                throw new IllegalArgumentException(invoiceRequestItem.getProductData().getType() + " not handled");
        }

        Money taxValue = net.multiplyBy(ratio);

        return new Tax(taxValue, desc);
    }
}
