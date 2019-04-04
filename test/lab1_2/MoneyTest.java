package lab1_2;

import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import java.math.BigDecimal;
import java.util.Currency;


public class MoneyTest {
	
	Money firstMoneyObject;
	Money secondMoneyObject;
	Money diffrentCurrencyMoneyObject;
	
	@Before
	public void setupObjects() {
		firstMoneyObject = new Money(new BigDecimal(1200));
		secondMoneyObject = new Money(new BigDecimal(800));
		diffrentCurrencyMoneyObject = new Money(new BigDecimal(800), Currency.getInstance("GBP"));
	}
	
	@Test
	public void addMethodShouldReturnValidResultWhenAddedMoneyWithTheSameCurrency() {
		assertThat(firstMoneyObject.add(secondMoneyObject).getCurrencyCode(), is("EUR"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addMethodShouldThrowExceptionWhenAddedMoneyHasDiffrentCurrency() {
		firstMoneyObject.add(diffrentCurrencyMoneyObject);
	}
	
	@Test
	public void subtractMethodShouldReturnValidResultWhenAddedMoneyWithTheSameCurrency() {
		assertThat(firstMoneyObject.subtract(secondMoneyObject).getCurrencyCode(), is("EUR"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void subtractMethodShouldThrowExceptionWhenAddedMoneyHasDiffrentCurrency() {
		firstMoneyObject.subtract(diffrentCurrencyMoneyObject);
	}
	
	@Test
	public void greaterThanReturnsTrueIfDenominationIsGreater() {
		assertThat(firstMoneyObject.greaterThan(secondMoneyObject), is(true));
	}
	
	@Test
	public void lessThanReturnsTrueIfDenominationIsSmaller() {
		assertThat(secondMoneyObject.lessThan(firstMoneyObject), is(true));
	}
	
}
