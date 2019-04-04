package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.hamcrest.CoreMatchers.is;

public class MoneyTest {

    @Test
    public void multiplyBy() {
        Money money = new Money(new BigDecimal(20));
        Money result = money.multiplyBy(new BigDecimal(5));

        Assert.assertThat(result, is(new Money(new BigDecimal(100))));
    }

    @Test
    public void caseThatAddProperlyIfCompatibleCurrency() {
        Money money = new Money(new BigDecimal(15), Currency.getInstance("PLN"));
        Money result = money.add(new Money(new BigDecimal(5), Currency.getInstance("PLN")));

        Assert.assertThat(result, is(new Money(new BigDecimal(20), Currency.getInstance("PLN"))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void caseThatThrowsExceptionIfNotCompatibleCurrency() {
        Money money = new Money(new BigDecimal(15), Currency.getInstance("USD"));
        money.add(new Money(new BigDecimal(5), Currency.getInstance("PLN")));

    }

    @Test()
    public void caseThatAddProperlyIfIncompatibleCurrencyButOneHasZeroValues() {
        Money money = new Money(new BigDecimal(0), Currency.getInstance("PLN"));
        Money result = money.add(new Money(new BigDecimal(5), Currency.getInstance("USD")));

        Assert.assertThat(result, is(new Money(new BigDecimal(5), Currency.getInstance("USD"))));
    }

    @Test()
    public void caseThatAddProperlyIfIncompatibleCurrencyButOneHasZeroValues2() {
        Money money = new Money(new BigDecimal(5), Currency.getInstance("PLN"));
        Money result = money.add(new Money(new BigDecimal(0), Currency.getInstance("USD")));

        Assert.assertThat(result, is(new Money(new BigDecimal(5), Currency.getInstance("PLN"))));
    }

    @Test()
    public void caseThatSubstractProperlyIfCompatibleCurrency() {
        Money money = new Money(new BigDecimal(15), Currency.getInstance("PLN"));
        Money result = money.subtract(new Money(new BigDecimal(5), Currency.getInstance("PLN")));

        Assert.assertThat(result, is(new Money(new BigDecimal(10), Currency.getInstance("PLN"))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void caseThatThrowsExceptionIfNotCompatibleCurrency_substract() {
        Money money = new Money(new BigDecimal(15), Currency.getInstance("USD"));
        money.subtract(new Money(new BigDecimal(5), Currency.getInstance("PLN")));

    }

    @Test()
    public void caseThatSubtractProperlyIfIncompatibleCurrencyButOneHasZeroValues() {
        Money money = new Money(new BigDecimal(15), Currency.getInstance("PLN"));
        Money result = money.add(new Money(new BigDecimal(0), Currency.getInstance("USD")));

        Assert.assertThat(result, is(new Money(new BigDecimal(15), Currency.getInstance("PLN"))));
    }

    @Test()
    public void caseThatSubstractProperlyIfIncompatibleCurrencyButOneHasZeroValues2() {
        Money money = new Money(new BigDecimal(0), Currency.getInstance("PLN"));
        Money result = money.add(new Money(new BigDecimal(5), Currency.getInstance("USD")));

        Assert.assertThat(result, is(new Money(new BigDecimal(5), Currency.getInstance("USD"))));
    }

}
