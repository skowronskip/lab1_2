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

    @Test public void testAddingInMoney() {
        Money ten = new Money(10);
        Money twenty = new Money(20);
        Money moneyResult = ten.add(ten);

        assertThat(moneyResult, Matchers.equalTo(twenty));
    }

    @Test public void testSubtractingInMoney() {
        Money ten = new Money(10);
        Money twenty = new Money(20);
        Money moneyResult = twenty.subtract(ten);

        assertThat(moneyResult, Matchers.equalTo(ten));
    }






}
