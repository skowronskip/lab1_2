package lab1_2;
import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.RequestItem;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Tax;
import pl.com.bottega.ecommerce.sales.domain.invoicing.TaxCalculator;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;


public class TaxCalculatorTest {
	
	RequestItem requestItem;
	TaxCalculator taxCalculator;
	
	@Before
	public void setupItem() {
		Id id = Id.generate();
		Money price = new Money(new BigDecimal(1200));
		Date date = new Date();
		String name = "Product";
		ProductData productData = new ProductData(id,price, name, ProductType.FOOD, date);
		Money totalCost = new Money(new BigDecimal(1200).multiply(new BigDecimal(2)));
		requestItem = new RequestItem(productData, 1, totalCost);
		taxCalculator = new TaxCalculator();
	}
	

	@Test
	public void taxCalculatorShouldReturnValidTaxWhenValidItemIsGiven() {
		Tax tax = taxCalculator.calculateTax(requestItem);
		assertThat(tax.getAmount(), instanceOf(Money.class));
	}
	
	@Test(expected = NullPointerException.class)
	public void taxCalculatorShouldThrowExceptionWhenNoItemIsGiven() {
		Tax tax = taxCalculator.calculateTax(null);
	}
}
