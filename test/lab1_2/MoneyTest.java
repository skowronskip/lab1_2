package lab1_2;

import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import java.math.BigDecimal;
import java.util.Currency;


public class MoneyTest {
	
	@Test
	public void addMethodShouldReturnValidResultWhenAddedMoneyWithTheSameCurrency() {
		Money firstMoneyObject = new Money(new BigDecimal(1200));
		Money secondMoneyObject = new Money(new BigDecimal(800));
		assertThat(firstMoneyObject.add(secondMoneyObject).getCurrencyCode(), is("EUR"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addMethodShouldThrowExceptionWhenAddedMoneyHasDiffrentCurrency() {
		Money firstMoneyObject = new Money(new BigDecimal(1200));
		Money secondMoneyObject = new Money(new BigDecimal(800), Currency.getInstance("GBP"));
		firstMoneyObject.add(secondMoneyObject);
	}
	
	@Test
	public void subtractMethodShouldReturnValidResultWhenAddedMoneyWithTheSameCurrency() {
		Money firstMoneyObject = new Money(new BigDecimal(1200));
		Money secondMoneyObject = new Money(new BigDecimal(800));
		assertThat(firstMoneyObject.subtract(secondMoneyObject).getCurrencyCode(), is("EUR"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void subtractMethodShouldThrowExceptionWhenAddedMoneyHasDiffrentCurrency() {
		Money firstMoneyObject = new Money(new BigDecimal(1200));
		Money secondMoneyObject = new Money(new BigDecimal(800), Currency.getInstance("GBP"));
		firstMoneyObject.subtract(secondMoneyObject);
	}
	
}
