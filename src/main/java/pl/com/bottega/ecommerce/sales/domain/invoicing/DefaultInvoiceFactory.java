package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

import java.util.List;

public class DefaultInvoiceFactory implements IInvoiceFactory {

    @Override
    public Invoice makeInvoice(ClientData data, List<InvoiceLine> lines) {
        Invoice invoice = new Invoice(Id.generate(), data);
        for(InvoiceLine line : lines){
            invoice.addItem(line);
        }
        return invoice;
    }
}
