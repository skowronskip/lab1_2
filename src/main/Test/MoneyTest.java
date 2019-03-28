import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Currency;

public class MoneyTest {
    @Test
    public void addTestRightValue(){
        Money money=new Money(100, Currency.getInstance("EUR"));
        Money part=new Money(100, Currency.getInstance("EUR"));
        Money resoult=new Money(200,Currency.getInstance("EUR"));
        money=money.add(part);
        Assertions.assertEquals(resoult,money);
    }

}
