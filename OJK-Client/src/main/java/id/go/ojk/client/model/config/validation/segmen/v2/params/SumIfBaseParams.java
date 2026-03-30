package id.go.ojk.client.model.config.validation.segmen.v2.params;

import lombok.Getter;
import lombok.Setter;

@Getter
public class SumIfBaseParams {
    @Setter
    private String[] criteriaConditions;
    private String rangeField;

    public SumIfBaseParams(String[] criteriaConditions, String rangeField) {
        this.criteriaConditions = criteriaConditions;
        this.rangeField = rangeField;
    }

    public SumIfBaseParams(String[] criteriaConditions) {
        this.criteriaConditions = criteriaConditions;
    }

    public SumIfBaseParams(String rangeField) {
        this.rangeField = rangeField;
    }

    public SumIfBaseParams() {
    }
}
