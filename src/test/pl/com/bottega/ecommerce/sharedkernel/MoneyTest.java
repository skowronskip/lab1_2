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

    @Test
    public void shouldCreateMoneyWithDefaultCurrency() {
        Money money = new Money(new BigDecimal(100));

        assertThat(Currency.getInstance("EUR").getCurrencyCode(), is(money.getCurrencyCode()));
    }

    @Test
    public void shouldAddMoneyWithTheSameCurrency() {
        Money money = new Money(new BigDecimal(100));
        Money money2 = new Money(new BigDecimal(50));
        money = money.add(money2);
        assertThat(new Money(new BigDecimal(150)), is(money));
    }

    @Test
    public void shouldSubtractMoneyWithTheSameCurrency() {
        Money money = new Money(new BigDecimal(100));
        Money money2 = new Money(new BigDecimal(50));
        money = money.subtract(money2);
        assertThat(new Money(new BigDecimal(50)), is(money));
    }

    @Test
    public void shouldMultiplyMoney() {
        Money money = new Money(new BigDecimal(100));
        money = money.multiplyBy(new BigDecimal(10));
        assertThat(new Money(new BigDecimal(1000)), is(money));
    }

    @Test
    public void shouldReturnProperValuesWhenGreaterThan() {
        Money base = new Money(new BigDecimal(100));
        Money greater = new Money(new BigDecimal(120));
        Money less = new Money(new BigDecimal(80));

        assertThat(base.greaterThan(greater), is(false));
        assertThat(base.greaterThan(less), is(true));
    }

    @Test
    public void shouldReturnProperValuesWhenLessThan() {
        Money base = new Money(new BigDecimal(100));
        Money greater = new Money(new BigDecimal(120));
        Money less = new Money(new BigDecimal(80));

        assertThat(base.lessThan(greater), is(true));
        assertThat(base.lessThan(less), is(false));
    }
}