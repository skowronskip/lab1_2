package pl.com.bottega.ecommerce.sharedkernel;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyTest {

    @Test public void testMultiplyingByInMoney() {
        Money ten = new Money(10);
        Money oneHundred = new Money(100);
        Money moneyResult = ten.multiplyBy(10);

        assertThat(moneyResult, Matchers.equalTo(oneHundred));
    }




}
