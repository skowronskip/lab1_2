package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.jupiter.api.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;
import org.junit.Assert;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DefaultTaxCalculatorTest {
    @Test void calculateTaxForDrug() {
        DefaultTaxCalculator defaultTaxCalculator = new DefaultTaxCalculator();
        Money price = new Money(10.00, Money.DEFAULT_CURRENCY);

        ProductData productData = new ProductData(new Id("1"), price, "test", ProductType.DRUG, new Date(100));
        RequestItem requestItem = new RequestItem(productData, 1, price);

        BigDecimal ratio = BigDecimal.valueOf(0.05);
        Money taxValue = price.multiplyBy(ratio);

        assertEquals(new Tax(taxValue, "5% (D)").getAmount(), defaultTaxCalculator.calculateTax(requestItem).getAmount());
    }

    @Test void calculateTaxForFood() {
        DefaultTaxCalculator defaultTaxCalculator = new DefaultTaxCalculator();
        Money price = new Money(10.00, Money.DEFAULT_CURRENCY);

        ProductData productData = new ProductData(new Id("1"), price, "test", ProductType.FOOD, new Date(100));
        RequestItem requestItem = new RequestItem(productData, 1, price);

        BigDecimal ratio = BigDecimal.valueOf(0.07);
        Money taxValue = price.multiplyBy(ratio);
        assertEquals(new Tax(taxValue, "7% (F)").getAmount(), defaultTaxCalculator.calculateTax(requestItem).getAmount());
    }

    @Test void calculateTaxForStandard() {
        DefaultTaxCalculator defaultTaxCalculator = new DefaultTaxCalculator();
        Money price = new Money(10.00, Money.DEFAULT_CURRENCY);

        ProductData productData = new ProductData(new Id("1"), price, "test", ProductType.STANDARD, new Date(100));
        RequestItem requestItem = new RequestItem(productData, 1, price);

        BigDecimal ratio = BigDecimal.valueOf(0.23);
        Money taxValue = price.multiplyBy(ratio);

        assertEquals(new Tax(taxValue, "23%").getAmount(), defaultTaxCalculator.calculateTax(requestItem).getAmount());

    }

}