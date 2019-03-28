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
}
