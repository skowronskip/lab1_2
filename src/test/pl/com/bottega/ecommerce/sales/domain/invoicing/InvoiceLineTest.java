package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class InvoiceLineTest {

    @Test
    public void shouldCalculateGros() {
        Money net = new Money(new BigDecimal(10));
        Tax tax = new Tax(new Money(5), "");
        InvoiceLine invoiceLine = new InvoiceLine(null, 1, net, tax);

        Money gros = net.add(tax.getAmount());
        assertThat(invoiceLine.getGros(), is(gros));
    }
}
