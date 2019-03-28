import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Currency;

public class MoneyTest {

    @Test
    public void addTestRightValue() {
        Money money = new Money(100, Currency.getInstance("EUR"));
        Money part = new Money(100, Currency.getInstance("EUR"));
        Money resoult = new Money(200, Currency.getInstance("EUR"));
        money = money.add(part);
        Assertions.assertEquals(resoult, money);
    }

    @Test
    public void addTestWrongValue() {
        Money money = new Money(100, Currency.getInstance("EUR"));
        Money part = new Money(200, Currency.getInstance("USD"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> money.add(part));
    }

    @Test
    public void substractTestRightValue() {
        Money money = new Money(100, Currency.getInstance("EUR"));
        Money part = new Money(10, Currency.getInstance("EUR"));
        Money resoult = new Money(90, Currency.getInstance("EUR"));
        money = money.subtract(part);
        Assertions.assertEquals(resoult, money);
    }

    @Test
    public void substractTestWrongValue() {
        Money money = new Money(100, Currency.getInstance("EUR"));
        Money part = new Money(200, Currency.getInstance("USD"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> money.subtract(part));
    }



}
