package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.Currency;

public class MoneyTest {
    @Test void addMoneySameCurrency(){
        Money start = new Money(1.00, Currency.getInstance("USD"));
        Money adder = new Money(2.50, Currency.getInstance("USD"));
        Money result = new Money(3.50, Currency.getInstance("USD"));

        Assert.assertEquals(result, start.add(adder));
    }

    @Test void subtractMoneySameCurrency(){
        Money start = new Money(5.00, Currency.getInstance("EUR"));
        Money divider = new Money(2.50, Currency.getInstance("EUR"));
        Money result = new Money(2.50, Currency.getInstance("EUR"));

        Assert.assertEquals(result, start.subtract(divider));
    }

    @Test void addMoneyDifferentCurrency() {
        Money start = new Money(100.00, "USD");
        Money adder = new Money(250.50, "EUR");

        assertThrows(IllegalArgumentException.class, () -> start.add(adder));
    }

    @Test void subtractMoneyDifferentCurrency() {
        Money start = new Money(250.00, "USD");
        Money divider = new Money(100.50, "EUR");

        assertThrows(IllegalArgumentException.class, () -> start.subtract(divider));
    }
}