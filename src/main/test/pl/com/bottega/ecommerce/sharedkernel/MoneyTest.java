package pl.com.bottega.ecommerce.sharedkernel;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MoneyTest {

    @Test public void checkMultiplicationMethodInMoney() {
        Money hundred = new Money(100);
        Money expected = new Money(2000);
        Money result = hundred.multiplyBy(20);

        Assert.assertThat(result, Matchers.equalTo(expected));
    }

    @Test public void checkAddMethodInMoney() {
        Money hundred = new Money(100);
        Money expected = new Money(300);
        Money result = hundred.add(new Money(200));

        Assert.assertThat(result, Matchers.equalTo(expected));
    }


    @Test public void checkSubstractMethodInMoney() {
        Money hundred = new Money(100);
        Money expected = new Money(70);
        Money result = hundred.subtract(new Money(30));

        Assert.assertThat(result, Matchers.equalTo(expected));
    }
}
