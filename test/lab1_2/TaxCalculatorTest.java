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
	
	List<RequestItem> items = new ArrayList<>();
	
	@Before
	public void setupItems() {
		for(int i = 1; i< 4; i++) {
			Id id = Id.generate();
			Money price = new Money(new BigDecimal(1200/i));
			Date date = new Date();
			String name = "Product" + Integer.toString(i);
			ProductData productData = new ProductData(id,price, name, ProductType.valueOf(Integer.toString(i)), date);
			Money totalCost = new Money(new BigDecimal(1200/i).multiply(new BigDecimal(i)));
			RequestItem requestItem = new RequestItem(productData, i, totalCost);
			items.add(requestItem);
		}
	}
	
	@After
	public void removeItems() {
		items.clear();
	}
}
