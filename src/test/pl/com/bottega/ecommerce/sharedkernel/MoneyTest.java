package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {
    @Test
    public void shouldCreateMoneyWithGivenCurrency() {
        Money money = new Money(new BigDecimal(100), Currency.getInstance("PLN"));

        assertThat(Currency.getInstance("PLN").getCurrencyCode(), is(money.getCurrencyCode()));
    }
}