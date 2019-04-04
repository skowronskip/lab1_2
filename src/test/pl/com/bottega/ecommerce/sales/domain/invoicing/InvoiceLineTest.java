package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Random;

import static org.junit.Assert.*;

public class InvoiceLineTest {

    @Test
    public void shouldReturnProperGrossValue() {
        Random rand = new Random();
        for(int i = 10; i < 50; i++) {
            int tax = rand.nextInt(9) + 1;
            InvoiceLine invoiceLine = new InvoiceLine(null, 1, new Money(i), new Tax(new Money(tax), "test"));

            assertEquals(new Money(i + tax), invoiceLine.getGros());
        }
    }
}
