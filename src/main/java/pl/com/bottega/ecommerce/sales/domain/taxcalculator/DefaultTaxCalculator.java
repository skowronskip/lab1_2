package pl.com.bottega.ecommerce.sales.domain.taxcalculator;

import pl.com.bottega.ecommerce.sales.domain.invoicing.RequestItem;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Tax;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

public class DefaultTaxCalculator implements ITaxCalculator {

    @Override
    public Tax calculate(RequestItem requestItem) {
        Money net = requestItem.getTotalCost();
        BigDecimal ratio = null;
        String desc = null;

        switch (requestItem.getProductData()
                    .getType()) {
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
                throw new IllegalArgumentException(requestItem.getProductData()
                                                       .getType()
                        + " not handled");
        }
        Money taxValue = net.multiplyBy(ratio);
        return new Tax(taxValue, desc);
    }
}
