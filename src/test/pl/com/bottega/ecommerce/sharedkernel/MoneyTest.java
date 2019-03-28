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
    public void shouldSubtract() {
        assertEquals(new Money(40), money.subtract(new Money(10)));
        assertEquals(new Money(25), money.subtract(new Money(25)));
    }

    @Test
    public void shouldBeGreaterThan() {
        assertTrue(money.greaterThan(new Money(25)));
        assertTrue(money.greaterThan(new Money(49)));
        assertFalse(money.greaterThan(new Money(50)));
        assertFalse(money.greaterThan(new Money(51)));
        assertFalse(money.greaterThan(new Money(100)));
    }

    @Test
    public void shouldBeLessThan() {
        assertFalse(money.lessThan(new Money(25)));
        assertFalse(money.lessThan(new Money(49)));
        assertFalse(money.lessThan(new Money(50)));
        assertTrue(money.lessThan(new Money(51)));
        assertTrue(money.lessThan(new Money(100)));
    }

    @Test
    public void lessOrEquals() {
    }
}
