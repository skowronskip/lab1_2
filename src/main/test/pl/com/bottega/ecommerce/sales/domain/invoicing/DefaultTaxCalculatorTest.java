package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

import static org.hamcrest.Matchers.is;

public class DefaultTaxCalculatorTest {

    private DefaultTaxCalculator defaultTaxCalculator = new DefaultTaxCalculator();

    @Test
    public void calculate_productTypeDRUG_shouldReturn5Percent() {
        Money productPrice = new Money(new BigDecimal(10));
        ProductData productData = new ProductData(Id.generate(), productPrice, "test product", ProductType.DRUG, new Date());
        RequestItem item = new RequestItem(productData,10, new Money(new BigDecimal(100)));

        Tax tax = defaultTaxCalculator.calculate(item);
        Money expectedAmount = new Money(new BigDecimal(5));
        Assert.assertThat(tax.getAmount(), is(expectedAmount));
    }

    @Test
    public void calculate_productTypeSTANDARD__shouldReturn23Percent() {
        Money productPrice = new Money(new BigDecimal(10));
        ProductData productData = new ProductData(Id.generate(), productPrice, "test product", ProductType.STANDARD, new Date());
        RequestItem item = new RequestItem(productData,10, new Money(new BigDecimal(100)));

        Tax tax = defaultTaxCalculator.calculate(item);
        Money expectedAmount = new Money(new BigDecimal(23));
        Assert.assertThat(tax.getAmount(), is(expectedAmount));
    }

    @Test
    public void calculate_productTypeFOOD__shouldReturn7Percent() {
        Money productPrice = new Money(new BigDecimal(10));
        ProductData productData = new ProductData(Id.generate(), productPrice, "test product", ProductType.FOOD, new Date());
        RequestItem item = new RequestItem(productData,10, new Money(new BigDecimal(100)));

        Tax tax = defaultTaxCalculator.calculate(item);
        Money expectedAmount = new Money(new BigDecimal(7));
        Assert.assertThat(tax.getAmount(), is(expectedAmount));
    }

    @Test (expected = IllegalArgumentException.class)
    public void calculate_productTypeUnknown__shouldThrowException() {
        Money productPrice = new Money(new BigDecimal(10));
        ProductData productData = new ProductData(Id.generate(), productPrice, "test product", ProductType.valueOf("unknown"), new Date());
        RequestItem item = new RequestItem(productData,10, new Money(new BigDecimal(100)));

        defaultTaxCalculator.calculate(item);
    }


}
