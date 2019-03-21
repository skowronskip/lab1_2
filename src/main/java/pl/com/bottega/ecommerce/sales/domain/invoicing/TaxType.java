package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.math.BigDecimal;

public class TaxType {

    private BigDecimal ratio;
    private String desc;

    public TaxType(BigDecimal ratio, String desc) {
        this.ratio = ratio;
        this.desc = desc;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public String getDesc() {
        return desc;
    }
}
