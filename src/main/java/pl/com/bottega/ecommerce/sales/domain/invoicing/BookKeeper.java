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

public class BookKeeper {

    private InvoiceFactory invoiceFactory;

    public BookKeeper(InvoiceFactory invoiceFactory) {
        this.invoiceFactory = invoiceFactory;
    }

    public Invoice issuance(InvoiceRequest invoiceRequest, TaxCalculator calculator) {
        Invoice invoice = invoiceFactory.getInvoice("default", Id.generate(), invoiceRequest.getClient());

        for (RequestItem requestItem : invoiceRequest.getItems()) {
            Tax tax = calculator.calculateValueOfTax(requestItem);
            InvoiceLine invoiceLine = new InvoiceLine(requestItem.getProductData(), requestItem.getQuantity(), requestItem.getTotalCost(), tax);
            invoice.addItem(invoiceLine);
        }
        return invoice;
    }
}
