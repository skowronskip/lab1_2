package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class InvoiceTest {

    @Test
    public void shouldCreateEmptyInvoiceWithZeroNetAndGros() {
        Invoice invoice = new Invoice(new Id("Invoice0"), new ClientData(new Id("Client0"), "John Smith"));

        assertThat(invoice.getNet(), is(new Money(0)));
        assertThat(invoice.getGros(), is(new Money(0)));
    }
}
