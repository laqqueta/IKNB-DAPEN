package id.go.ojk.client.model.config.validation.segmen.v2.params;

import lombok.Getter;

@Getter
public class SumIfMultiCriteriaParams extends SumIfBaseParams {
    private String additionalCriteria;

    public SumIfMultiCriteriaParams(String[] criteriaConditions, String rangeField, String additionalCriteria) {
        super(criteriaConditions, rangeField);
        this.additionalCriteria = additionalCriteria;
    }

    public SumIfMultiCriteriaParams() {
    }
}
