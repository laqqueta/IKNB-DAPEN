package id.go.ojk.client.model.config.validation.segmen.v2.params;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class SumIfMultiCriteriaParams extends SumIfBaseParams {
    private List<String> additionalCriteria;

    private String additionalCriteriaError;

    public SumIfMultiCriteriaParams(String[] criteriaConditions, String rangeField, List<String> additionalCriteria) {
        super(criteriaConditions, rangeField);
        this.additionalCriteria = additionalCriteria;
    }

    public SumIfMultiCriteriaParams(String[] criteriaConditions, String rangeField, String additionalCriteria) {
        super(criteriaConditions, rangeField);
        this.additionalCriteria = Collections.singletonList(additionalCriteria);
    }

    public SumIfMultiCriteriaParams() {
    }

}
