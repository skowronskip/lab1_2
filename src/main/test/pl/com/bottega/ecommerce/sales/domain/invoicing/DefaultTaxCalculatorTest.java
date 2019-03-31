package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.hamcrest.Matchers;
import org.junit.Assert;
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

    @Test
    public void calculateTaxForFood() {
        Money price = new Money(new BigDecimal(10), Currency.getInstance("EUR"));
        ProductData testProduct = new ProductData(Id.generate(), price, "testProduct", ProductType.FOOD, Date.from(Instant.now()));
        RequestItem requestItem = new RequestItem(testProduct, 5, price.multiplyBy(5));

        DefaultTaxCalculator defaultTaxCalculator = new DefaultTaxCalculator();
        Tax calculatedTax = defaultTaxCalculator.calculateTax(requestItem);
        Tax expectedTax = new Tax(new Money(3.5), "7% (F)");
        Assert.assertThat(calculatedTax.getAmount(), Matchers.equalTo(expectedTax.getAmount()));
        Assert.assertThat(calculatedTax.getDescription(), Matchers.equalTo(expectedTax.getDescription()));
    }
}