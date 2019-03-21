package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

public class InvoiceFactory {

    Invoice createInvoiceInstance(ClientData client, String invoiceType){
        return new Invoice(Id.generate(),client);
    }

}
