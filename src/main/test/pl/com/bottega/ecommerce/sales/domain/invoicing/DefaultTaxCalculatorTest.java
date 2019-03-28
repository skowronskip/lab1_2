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

//    private RequestItem item;
    private DefaultTaxCalculator defaultTaxCalculator = new DefaultTaxCalculator();

//    @BeforeClass
//    public void setUp() {
//        Money productPrice = new Money(new BigDecimal(100), Currency.getInstance("USD"));
//        ProductData productData = new ProductData(Id.generate(), productPrice, ProductType.DRUG, new Date());
//        item = new RequestItem(productData,10, new Money(new BigDecimal(1000), Currency.getInstance("USD")));
//
//    }

    @Test
    public void calculate_productTypeDRUG() {
        Money productPrice = new Money(new BigDecimal(10), Currency.getInstance("USD"));
        ProductData productData = new ProductData(Id.generate(), productPrice, "test product", ProductType.DRUG, new Date());
        RequestItem item = new RequestItem(productData,10, new Money(new BigDecimal(100), Currency.getInstance("USD")));

        Tax tax = defaultTaxCalculator.calculate(item);
        Tax expectedTax = new Tax(new Money(new BigDecimal(5), Currency.getInstance("USD")), "");
        Assert.assertThat(tax.getAmount(), is(expectedTax.getAmount()));
    }
}
