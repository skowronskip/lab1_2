package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Test;

import java.util.Currency;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MoneyTest {

    private Money someMoney = new Money(100, Currency.getInstance("USD"));
    private Money zeroMoney = new Money(0, Currency.getInstance("EUR"));

    @Test
    public void add_compatibleCurrency_shouldAdd() {
        Money moneyToAdd = new Money(10, Currency.getInstance("USD"));
        Money actualAdded = someMoney.add(moneyToAdd);
        Money expected = new Money(110, Currency.getInstance("USD"));

        assertThat(actualAdded, is(expected));

    }

    @Test (expected = IllegalArgumentException.class)
    public void add_incompatibleCurrency_shouldThrowException() {
        Money moneyToAdd = new Money(10, Currency.getInstance("EUR"));
        someMoney.add(moneyToAdd);
    }

    @Test
    public void add_incompatibleCurrencyButFirstAddendIsZero_shouldAdd() {
        Money actualAdded = zeroMoney.add(someMoney);
        Money expected = new Money(100, Currency.getInstance("USD"));

        assertThat(actualAdded, is(expected));
    }

    @Test
    public void add_incompatibleCurrencyButSecondAddendIsZero_shouldAdd() {
        Money actualAdded = someMoney.add(zeroMoney);
        Money expected = new Money(100, Currency.getInstance("USD"));

        assertThat(actualAdded, is(expected));
    }

    @Test
    public void subtract_compatibleCurrency_shouldSubtract() {
        Money moneyToSubtract = new Money(10, Currency.getInstance("USD"));
        Money actualSubtracted = someMoney.subtract(moneyToSubtract);
        Money expected = new Money(90, Currency.getInstance("USD"));

        assertThat(actualSubtracted, is(expected));
    }

    @Test (expected = IllegalArgumentException.class)
    public void subtract_incompatibleCurrency_shouldThrowException() {
        Money moneyToSubtract = new Money(10, Currency.getInstance("EUR"));
        someMoney.subtract(moneyToSubtract);
    }

    @Test
    public void subtract_incompatibleCurrencyButMinuendIsZero_shouldSubtract() {
        Money actualSubtracted = zeroMoney.subtract(someMoney);
        Money expected = new Money(-100, Currency.getInstance("USD"));

        assertThat(actualSubtracted, is(expected));
    }

    @Test
    public void subtract_incompatibleCurrencyButSecondSubtrahendIsZero_shouldSubtract() {
        Money actualSubtracted = someMoney.subtract(zeroMoney);
        Money expected = new Money(100, Currency.getInstance("USD"));

        assertThat(actualSubtracted, is(expected));
    }

}