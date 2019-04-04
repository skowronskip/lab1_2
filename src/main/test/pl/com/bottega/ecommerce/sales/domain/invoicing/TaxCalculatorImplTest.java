package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.hamcrest.Matchers;
import org.junit.Test;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.junit.Assert.*;

public class TaxCalculatorImplTest {

    @Test public void taxCalculatorForFoodShouldReturnSevenPercentOfMoney() {
        TaxCalculator calculator = new TaxCalculatorImpl();
        Money moneyGiven = new Money(100);
        Money taxExpected = new Money(7);
        Tax tax = calculator.calculate(ProductType.FOOD, moneyGiven);

        assertThat(tax.getAmount(), Matchers.equalTo(taxExpected));
    }

    @Test public void taxCalculatorForStandardShouldReturn23PercentOfMoney() {
        TaxCalculator calculator = new TaxCalculatorImpl();
        Money moneyGiven = new Money(100);
        Money taxExpected = new Money(23);
        Tax tax = calculator.calculate(ProductType.STANDARD, moneyGiven);

        assertThat(tax.getAmount(), Matchers.equalTo(taxExpected));

    }


    @Test
    public void taxCalculatorForDrugShouldReturn5PercentOfMoney(){
        TaxCalculator calculator = new TaxCalculatorImpl();
        Money moneyGiven = new Money(100);
        Money taxExpected = new Money(5);
        Tax tax = calculator.calculate(ProductType.DRUG, moneyGiven);

        assertThat(tax.getAmount(), Matchers.equalTo(taxExpected));


    }


    @Test (expected = IllegalArgumentException.class)
    public void taxCalculatorForUknownProductShouldReturnIllegalArgumentException(){
        TaxCalculator calculator = new TaxCalculatorImpl();
        Money moneyGiven = new Money(100);
        Money taxExpected = new Money(5);
        Tax tax = calculator.calculate(ProductType.valueOf("DRINK"), moneyGiven);

        assertThat(tax.getAmount(), Matchers.equalTo(taxExpected));


    }

}
