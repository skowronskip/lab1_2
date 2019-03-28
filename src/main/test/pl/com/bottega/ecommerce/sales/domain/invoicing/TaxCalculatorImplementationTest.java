package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.hamcrest.Matchers;
import org.junit.Test;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.junit.Assert.*;

public class TaxCalculatorImplementationTest {

        @Test
        public void taxCalculatorForFoodShouldReturnSevenPercent() {

            TaxCalculator taxCalculator = new TaxCalculatorImplementation();
            Money money = new Money(100);
            Money moneyShouldBeReturned = new Money(7);
            Tax tax = taxCalculator.calculate(ProductType.FOOD, money);

            assertThat(tax.getAmount(), Matchers.equalTo(moneyShouldBeReturned));
        }
    }
