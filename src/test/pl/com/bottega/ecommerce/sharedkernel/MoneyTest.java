package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import java.util.Currency;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void shouldUseDefaultCurrencyWhenNotSpecified() {
        Money money = new Money(0);
        assertThat(money.getCurrency(), is(Money.DEFAULT_CURRENCY));
    }

    @Test
    public void multiplyBy() {
        Currency currency = Currency.getInstance("USD");
        Money money = new Money(2, currency);

        Money result = money.multiplyBy(2);
        Money expected = new Money(4, currency);
        assertThat(result, is(expected));
    }

    @Test
    public void shouldAddSameCurrencies() {
        Currency currency = Currency.getInstance("USD");
        Money money = new Money(2, currency);

        Money result = money.add(new Money(1, currency));
        Money expected = new Money(3, currency);
        assertThat(result, is(expected));
    }

    @Test
    public void shouldAddWhenCurrenciesAreDifferentButOneIsZero() {
        Money money = new Money(2, Currency.getInstance("USD"));

        Money result = money.add(new Money(0, Currency.getInstance("EUR")));
        Money expected = new Money(2, Currency.getInstance("USD"));
        assertThat(result, is(expected));
    }

    @Test
    public void shouldSubtractSameCurrencies() {
        Currency currency = Currency.getInstance("USD");
        Money money = new Money(2, currency);

        Money result = money.subtract(new Money(1, currency));
        Money expected = new Money(1, currency);
        assertThat(result, is(expected));
    }

    @Test
    public void shouldSubtractWhenCurrenciesAreDifferentButOneIsZero() {
        Money money = new Money(2, Currency.getInstance("USD"));

        Money result = money.subtract(new Money(0, Currency.getInstance("EUR")));
        Money expected = new Money(2, Currency.getInstance("USD"));
        assertThat(result, is(expected));
    }

    @Test
    public void greaterThan() {
        Money money = new Money(3);
        Money money2 = new Money(2);

        assertThat(money.greaterThan(money2), is(true));
    }

    @Test
    public void lessThan() {
        Money money = new Money(1);
        Money money2 = new Money(2);

        assertThat(money.lessThan(money2), is(true));
    }
}
