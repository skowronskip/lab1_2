package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;
import java.util.Random;

import static org.junit.Assert.*;

public class InvoiceTest {

    @Test
    public void shouldCalculateProperNetAndGrossValue() {
        Invoice invoice = new Invoice(Id.generate(), new ClientData(Id.generate(), "test"));

        double netSum = 0;
        double grossSum = 0;
        Random rand = new Random();
        for(int i = 0; i < 5; i++) {
            int net = rand.nextInt(50) + 10;
            int tax =  rand.nextInt(net - 5) + 1;
            invoice. addItem(new InvoiceLine(null, 1, new Money(net), new Tax(new Money(tax), "tax")));
            netSum += net;
            grossSum += tax + net;
        }

        assertEquals(new Money(netSum), invoice.getNet());
        assertEquals(new Money(grossSum), invoice.getGros());
    }
}
