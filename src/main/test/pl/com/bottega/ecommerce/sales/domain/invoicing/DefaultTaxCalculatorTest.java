package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.Matchers.is;

public class DefaultTaxCalculatorTest {

    @Test
    public void testDefaultTaxCalculatorForStandardProductType() {
        TaxCalculator taxCalculator = new DefaultTaxCalculator();
        Money money = new Money(1);
        Money taxMoneyExpected = new Money(0.23);
        ProductData productData = new ProductData(new Id("id"), money, "product", ProductType.STANDARD, null);
        RequestItem requestItem = new RequestItem(productData, 1, money);

        Tax tax = taxCalculator.calculate(requestItem);
        Assert.assertThat(tax.getAmount(), is(taxMoneyExpected));
    }

    @Test
    public void testDefaultTaxCalculatorForFoodProductType() {
        TaxCalculator taxCalculator = new DefaultTaxCalculator();
        Money money = new Money(1);
        Money taxMoneyExpected = new Money(0.07);
        ProductData productData = new ProductData(new Id("id"), money, "product", ProductType.FOOD, null);
        RequestItem requestItem = new RequestItem(productData, 1, money);

        Tax tax = taxCalculator.calculate(requestItem);
        Assert.assertThat(tax.getAmount(), is(taxMoneyExpected));
    }

    @Test
    public void testDefaultTaxCalculatorForDrugProductType() {
        TaxCalculator taxCalculator = new DefaultTaxCalculator();
        Money money = new Money(1);
        Money taxMoneyExpected = new Money(0.05);
        ProductData productData = new ProductData(new Id("id"), money, "product", ProductType.DRUG, null);
        RequestItem requestItem = new RequestItem(productData, 1, money);

        Tax tax = taxCalculator.calculate(requestItem);
        Assert.assertThat(tax.getAmount(), is(taxMoneyExpected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDefaultTaxCalculatorForNotHandledProductType() {
        TaxCalculator taxCalculator = new DefaultTaxCalculator();
        Money money = new Money(1);
        ProductData productData = new ProductData(new Id("id"), money, "product", ProductType.valueOf("NotHandled"), null);
        RequestItem requestItem = new RequestItem(productData, 1, money);

        Tax tax = taxCalculator.calculate(requestItem);
    }
}
