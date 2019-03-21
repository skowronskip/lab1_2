package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.math.BigDecimal;

public class TaxInfo {
    BigDecimal ratio;
    String desc;

    public TaxInfo(BigDecimal ratio, String desc) {
        this.ratio = ratio;
        this.desc = desc;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
