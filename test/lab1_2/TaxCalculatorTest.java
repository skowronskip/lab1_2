package lab1_2;
import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.RequestItem;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;


public class TaxCalculatorTest {
	
	RequestItem requestItem;
	
	@Before
	public void setupItems() {
		Id id = Id.generate();
		Money price = new Money(new BigDecimal(1200));
		Date date = new Date();
		String name = "Product";
		ProductData productData = new ProductData(id,price, name, ProductType.valueOf(Integer.toString(2)), date);
		Money totalCost = new Money(new BigDecimal(1200).multiply(new BigDecimal(2)));
		requestItem = new RequestItem(productData, 2, totalCost);
	}
	

	@Test
	public void taxCalculatorShouldReturnValidTaxWhenValidItemIsGiven() {
		
	}
}
