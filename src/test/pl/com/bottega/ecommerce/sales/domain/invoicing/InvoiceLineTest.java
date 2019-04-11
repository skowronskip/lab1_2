package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;

public class InvoiceLineTest {
    @Test
    public void shouldReturnGrosValueBaseOnTaxAndNetValues() {
        Money net = new Money(100);
        Money tax = new Money(50);
        InvoiceLine invoiceLine = new InvoiceLine(null,1, net, new Tax(tax, "desc"));

        Money gros = net.add(tax);
        assertThat(gros, is(invoiceLine.getGros()));
    }
}