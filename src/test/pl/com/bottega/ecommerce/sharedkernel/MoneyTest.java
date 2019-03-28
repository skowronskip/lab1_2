package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void shouldUseDefaultCurrencyWhenNotSpecified() {
        Money money = new Money(0);
        assertThat(money.getCurrency(), is(Money.DEFAULT_CURRENCY));
    }

}
