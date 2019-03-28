package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.RequestItem;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class DefaultTaxCalculatorTest {

    @Test
    public void calculateDrugTest(){

        ProductData productData = new ProductData();

        Money money = new Money(100,"EUR");
        Money moneyForTax = new Money(5,"EUR");


        productData.setName("tempProduct");
        productData.setPrice(money);
        productData.setType(ProductType.DRUG);
        productData.setProductId(Id.generate());

        RequestItem requestItem = new RequestItem(productData,1,money);

        Tax tax = Tax.createTax(moneyForTax, "vat");

        DefaultTaxCalculator calculator = new DefaultTaxCalculator();

        Tax resultTax = calculator.calculate(requestItem);

        Assertions.assertEquals(tax.getAmount(),resultTax.getAmount());

    }

}
