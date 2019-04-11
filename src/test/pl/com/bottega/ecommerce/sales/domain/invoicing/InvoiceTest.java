package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.junit.jupiter.api.Assertions.*;

public class InvoiceTest {
    @Test
    public void shouldHaveZeroValueAfterCreation() {
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        Invoice invoice = invoiceFactory.createInvoice(new ClientData(Id.generate(), "name"));

        assertEquals(new Money(0), invoice.getNet());
        assertEquals(new Money(0), invoice.getGros());
    }

    @Test
    public void shouldHaveProperNetAndGrosValuesWithItemAdded() {
        InvoiceFactory invoiceFactory = new InvoiceFactory();
        Invoice invoice = invoiceFactory.createInvoice(new ClientData(Id.generate(), "name"));
        InvoiceLine item = new InvoiceLine(null, 1, new Money(100), new Tax(new Money(20), "desc"));
        invoice.addItem(item);

        assertEquals(new Money(100), invoice.getNet());
        assertEquals(new Money(120), invoice.getGros());

    }
}