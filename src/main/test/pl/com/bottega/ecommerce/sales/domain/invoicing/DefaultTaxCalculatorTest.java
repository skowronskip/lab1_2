package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.jupiter.api.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

class DefaultTaxCalculatorTest {

    @Test
    void shouldCalculate7PercentageIfTypeIsFood() {

        RequestItem requestItem = new RequestItem(
                new ProductData(Id.generate(), new Money(new BigDecimal(20)), "kebab", ProductType.FOOD, Date.from(Instant.now())), 1,
                new Money(new BigDecimal(20)));

        Tax taxResult = new DefaultTaxCalculator().calculte(requestItem);
        Tax taxExpected = new Tax(new Money(new BigDecimal(1.4)), "7% (F)");
        assertThat(taxResult, is(taxExpected));

    }

    @Test
    void shouldCalculate23PercentageIfTypeIsStandard() {

        RequestItem requestItem = new RequestItem(
                new ProductData(Id.generate(), new Money(new BigDecimal(20)), "zeszyt", ProductType.STANDARD, Date.from(Instant.now())), 1,
                new Money(new BigDecimal(20)));

        Tax taxResult = new DefaultTaxCalculator().calculte(requestItem);
        Tax taxExpected = new Tax(new Money(new BigDecimal(4.6)), "23%");
        assertThat(taxResult, is(taxExpected));

    }

    @Test
    void shouldCalculate5PercentageIfTypeIsDrug() {

        RequestItem requestItem = new RequestItem(
                new ProductData(Id.generate(), new Money(new BigDecimal(20)), "apap", ProductType.DRUG, Date.from(Instant.now())), 1,
                new Money(new BigDecimal(20)));

        Tax taxResult = new DefaultTaxCalculator().calculte(requestItem);
        Tax taxExpected = new Tax(new Money(new BigDecimal(1)), "5% (D)");
        assertThat(taxResult, is(taxExpected));

    }



}
