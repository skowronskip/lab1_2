package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.payment.Payment;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class PaymentFactory {
	public Payment createPayment(Id id, ClientData clientData, Money amount) {
		return new Payment(id, clientData, amount);
	}
}
