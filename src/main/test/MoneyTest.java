import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;

public class MoneyTest {

    @Test public void testMoneyMultipliedByNumber() {
        Money money = new Money(new BigDecimal(20.0));
        Money moneyExpected = new Money(new BigDecimal(80.0));

        money = money.multiplyBy(4.0);
        Assert.assertThat(money, is(moneyExpected));
    }

    @Test
    public void testMoneyMultipliedByBigDecimal() {
        Money money = new Money(new BigDecimal(20.0));
        Money moneyExpected = new Money(new BigDecimal(80.0));

        money = money.multiplyBy(new BigDecimal(4.0));
        Assert.assertThat(money, is(moneyExpected));
    }

    @Test
    public void testMoneyAdd() {
        Money money = new Money(new BigDecimal(20.0));
        Money moneySecond = new Money(new BigDecimal(60.0));
        Money moneyExpected = new Money(new BigDecimal(80.0));

        money = money.add(moneySecond);
        Assert.assertThat(money, is(moneyExpected));
    }

    @Test
    public void testMoneySubtract() {
        Money money = new Money(new BigDecimal(90.0));
        Money moneySecond = new Money(new BigDecimal(10.0));
        Money moneyExpected = new Money(new BigDecimal(80.0));

        money = money.subtract(moneySecond);
        Assert.assertThat(money, is(moneyExpected));
    }

    @Test
    public void testMoneyGreaterThan() {
        Money money = new Money(new BigDecimal(20.0));
        Money moneySecond = new Money(new BigDecimal(10.0));

        Assert.assertThat(money.greaterThan(moneySecond), is(true));
    }

    @Test
    public void testMoneyLessThan() {
        Money money = new Money(new BigDecimal(20.0));
        Money moneySecond = new Money(new BigDecimal(10.0));

        Assert.assertThat(money.lessThan(moneySecond), is(false));
    }

    @Test
    public void testMoneyLessOrEquals() {
        Money money = new Money(new BigDecimal(20.0));
        Money moneySecond = new Money(new BigDecimal(20.0));

        Assert.assertThat(money.lessOrEquals(moneySecond), is(true));
    }
}
