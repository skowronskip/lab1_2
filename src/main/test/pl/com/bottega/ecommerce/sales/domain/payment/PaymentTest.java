package pl.com.bottega.ecommerce.sales.domain.payment;

import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.payment.Payment;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;

public class PaymentTest {

    @Test
    public void testPaymentRollBack() {
        Money money = new Money(new BigDecimal(20.0));
        Money moneySecond = new Money(new BigDecimal(-20.0));
        Id id = new Id("id");
        ClientData clientData = new ClientData(id, "name");

        Payment payment = new Payment(id, clientData, money);
        Payment paymentSecond = new Payment(id, clientData, moneySecond);
        payment = payment.rollBack();

        Assert.assertThat(payment.getAmount(), is(paymentSecond.getAmount()));
    }

}
