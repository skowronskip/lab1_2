package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

public class InvoiceFactory {

    public Invoice createInvoice(String type, Id invoiceId, ClientData client) {
        if(type.equals("Invoice"))
            return new Invoice(invoiceId, client);
        else
            throw new NullPointerException();
    }
}
