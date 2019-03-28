import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Currency;

public class MoneyTest {

    @Test
    public void successfulAddTest(){

        Money money1 = new Money(10, Currency.getInstance("EUR"));
        Money money2 = new Money(20, Currency.getInstance("EUR"));

        Money afterAddMoney = money1.add(money2);
        final Money EXPECTED_VALUE = new Money(30,Currency.getInstance("EUR"));

        Assertions.assertEquals(EXPECTED_VALUE,afterAddMoney);


    }

    @Test
    public void unsuccessfulAddTest(){

        Money money1 = new Money(10, Currency.getInstance("EUR"));
        Money money2 = new Money(20, Currency.getInstance("USD"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> money1.add(money2));

    }

    @Test
    public void successfulSubstracTest(){

        Money money1 = new Money(20, Currency.getInstance("EUR"));
        Money money2 = new Money(10, Currency.getInstance("EUR"));

        Money afterAddMoney = money1.subtract(money2);
        final Money EXPECTED_VALUE = new Money(10,Currency.getInstance("EUR"));

        Assertions.assertEquals(EXPECTED_VALUE,afterAddMoney);

    }

    @Test
    public void unsuccessfulTest(){

        Money money1 = new Money(20, Currency.getInstance("EUR"));
        Money money2 = new Money(10, Currency.getInstance("USD"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> money1.subtract(money2));

    }


}
