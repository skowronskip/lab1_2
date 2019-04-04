/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.invoicing;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class BookKeeper {
	
	public InvoiceFactory invoiceFactory;
	
	public BookKeeper(InvoiceFactory invoiceFactory) {
		this.invoiceFactory = invoiceFactory;
	}
	
    public Invoice issuance(InvoiceRequest invoiceRequest, TaxCalculator taxCalculator) {
        Invoice invoice = invoiceFactory.createInvoice(Id.generate(), invoiceRequest.getClient());

        for (RequestItem item : invoiceRequest.getItems()) {
        	Tax tax = taxCalculator.calculateTax(item);
        	Money net = item.getTotalCost();
            InvoiceLine invoiceLine = InvoiceLine.createInvoiceLine(item, net, tax);
            invoice.addItem(invoiceLine);
        }

        return invoice;
    }

}
