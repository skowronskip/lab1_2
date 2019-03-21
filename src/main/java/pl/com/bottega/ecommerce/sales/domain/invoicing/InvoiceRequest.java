package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;

public class InvoiceRequest {

    private ClientData client;
    private List<RequestItem> items = new ArrayList<>();
    private ITaxCalculator taxCalculator;

    public InvoiceRequest(ClientData client, ITaxCalculator taxCalculator) {
        this.client = client;
        this.taxCalculator = taxCalculator;
    }

    public void add(RequestItem item) {
        items.add(item);
    }

    public ClientData getClient() {
        return client;
    }

    public ITaxCalculator getTaxCalculator() {
        return taxCalculator;
    }

    public Collection<RequestItem> getItems() {
        return Collections.unmodifiableCollection(items);
    }
}
