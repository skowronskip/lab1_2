package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.util.Currency;

import static org.junit.Assert.*;

public class DefaultTaxCalculatorTest {

    private final Money price = new Money(new BigDecimal(10), Currency.getInstance("EUR"));

    private final DefaultTaxCalculator defaultTaxCalculator = new DefaultTaxCalculator();

    @Test
    public void calculateTaxForFood() {
        ProductData testProduct = new ProductData(Id.generate(), price, "testProduct", ProductType.FOOD, Date.from(Instant.now()));
        RequestItem requestItem = new RequestItem(testProduct, 10, price.multiplyBy(10));

        Tax calculatedTax = defaultTaxCalculator.calculateTax(requestItem);
        Tax expectedTax = new Tax(new Money(7), "7% (F)");

        Assert.assertThat(calculatedTax.getAmount(), Matchers.equalTo(expectedTax.getAmount()));
        Assert.assertThat(calculatedTax.getDescription(), Matchers.equalTo(expectedTax.getDescription()));
    }

    @Test
    public void calculateTaxForStandard() {
        ProductData testProduct = new ProductData(Id.generate(), price, "testProduct", ProductType.STANDARD, Date.from(Instant.now()));
        RequestItem requestItem = new RequestItem(testProduct, 10, price.multiplyBy(10));

        Tax calculatedTax = defaultTaxCalculator.calculateTax(requestItem);
        Tax expectedTax = new Tax(new Money(23), "23%");

        Assert.assertThat(calculatedTax.getAmount(), Matchers.equalTo(expectedTax.getAmount()));
        Assert.assertThat(calculatedTax.getDescription(), Matchers.equalTo(expectedTax.getDescription()));
    }

    @Test
    public void calculateTaxForDrug() {
        ProductData testProduct = new ProductData(Id.generate(), price, "testProduct", ProductType.DRUG, Date.from(Instant.now()));
        RequestItem requestItem = new RequestItem(testProduct, 10, price.multiplyBy(10));

        Tax calculatedTax = defaultTaxCalculator.calculateTax(requestItem);
        Tax expectedTax = new Tax(new Money(5), "5% (D)");

        Assert.assertThat(calculatedTax.getAmount(), Matchers.equalTo(expectedTax.getAmount()));
        Assert.assertThat(calculatedTax.getDescription(), Matchers.equalTo(expectedTax.getDescription()));
    }
}