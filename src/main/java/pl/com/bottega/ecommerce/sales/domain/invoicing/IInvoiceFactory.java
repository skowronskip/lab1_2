package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;

import java.util.List;

public interface IInvoiceFactory {
    Invoice makeInvoice(ClientData data, List<InvoiceLine> lines);
}
