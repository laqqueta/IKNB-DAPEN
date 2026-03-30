package id.go.ojk.client.model.config.validation.segmen.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
public class SumIfData {

    private Map<String, BigDecimal> mappedData;
    private BigDecimal sum;

    public SumIfData() {
    }

    public SumIfData(Map<String, BigDecimal> mappedData, BigDecimal sum) {
        this.mappedData = mappedData;
        this.sum = sum;
    }
}
