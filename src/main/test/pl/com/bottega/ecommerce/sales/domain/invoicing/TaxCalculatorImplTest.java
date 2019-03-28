package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.hamcrest.Matchers;
import org.junit.Test;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.junit.Assert.*;

public class TaxCalculatorImplTest {

    @Test
    public void taxCalculatorForFoodShouldReturnSevenPercentOfMoney() {
        TaxCalculator calculator = new TaxCalculatorImpl();
        Money moneyGiven = new Money(100);
        Money taxExpected = new Money(7);
        Tax tax = calculator.calculate(ProductType.FOOD, moneyGiven);

        assertThat(tax.getAmount(), Matchers.equalTo(taxExpected));
    }
}
