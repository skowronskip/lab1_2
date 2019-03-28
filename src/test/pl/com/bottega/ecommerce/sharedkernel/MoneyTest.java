package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyTest {
    private Money money;

    @Before
    public void init() {
        money = new Money(50);
    }

    @Test
    public void shouldMultiplyBy() {
        assertEquals(new Money(25), money.multiplyBy(0.5));
        assertEquals(new Money(10), money.multiplyBy(0.2));
        assertEquals(new Money(100), money.multiplyBy(2));
        assertEquals(new Money(5), money.multiplyBy(0.1));
    }

    @Test
    public void shouldAdd() {
        assertEquals(new Money(60), money.add(new Money(10)));
        assertEquals(new Money(75), money.add(new Money(25)));
    }

    @Test
    public void subtract() {
    }

    @Test
    public void greaterThan() {
    }

    @Test
    public void lessThan() {
    }

    @Test
    public void lessOrEquals() {
    }
}
