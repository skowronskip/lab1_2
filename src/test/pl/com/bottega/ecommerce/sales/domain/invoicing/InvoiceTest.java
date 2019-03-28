package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class InvoiceTest {

    @Test
    public void shouldCreateEmptyInvoiceWithZeroNetAndGros() {
        Invoice invoice = new Invoice(new Id("Invoice0"), new ClientData(new Id("Client0"), "John Smith"));

        assertThat(invoice.getNet(), is(new Money(0)));
        assertThat(invoice.getGros(), is(new Money(0)));
    }


    @Test
    public void shouldIncreaseNetAndGrosWhenAddingAnItem() {
        Invoice invoice = new Invoice(new Id("Invoice0"), new ClientData(new Id("Client0"), "John Smith"));

        Money net = new Money(new BigDecimal(10));
        Tax tax = new Tax(new Money(5), "");
        InvoiceLine invoiceLine = new InvoiceLine(null, 1, net, tax);

        invoice.addItem(invoiceLine);

        assertThat(invoice.getNet(), is(net));
        assertThat(invoice.getGros(), is(invoiceLine.getGros()));
    }


    @Test
    public void shouldIncreaseNetAndGrosWhenAddingMultipleItems() {
        Invoice invoice = new Invoice(new Id("Invoice0"), new ClientData(new Id("Client0"), "John Smith"));

        Money net = new Money(new BigDecimal(10));
        Tax tax = new Tax(new Money(5), "");
        InvoiceLine invoiceLine = new InvoiceLine(null, 1, net, tax);

        Money net2= new Money(new BigDecimal(20));
        Tax tax2 = new Tax(new Money(2), "");
        InvoiceLine invoiceLine2 = new InvoiceLine(null, 1, net2, tax2);

        invoice.addItem(invoiceLine);
        invoice.addItem(invoiceLine2);

        assertThat(invoice.getNet(), is(net.add(net2)));
        assertThat(invoice.getGros(), is(invoiceLine.getGros().add(invoiceLine2.getGros())));
    }
}
