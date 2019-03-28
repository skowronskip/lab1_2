package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Currency;

public class DefaultTaxCalculatorTest {
    @Test
    public void TaxCalculatorDRUGTest() {
        ProductData productData = new ProductData();
        productData.setType(ProductType.DRUG);
        Money money = new Money(100, Currency.getInstance("EUR"));
        RequestItem item = new RequestItem(productData, 10, money);
        DefaultTaxCalculator calculator = new DefaultTaxCalculator();
        Tax resoult = calculator.calculate(item);
        Money expected=new Money(5, Currency.getInstance("EUR"));
        Assertions.assertEquals(expected,resoult.getAmount());
    }


}
