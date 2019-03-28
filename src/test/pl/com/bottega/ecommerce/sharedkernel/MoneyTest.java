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
}
