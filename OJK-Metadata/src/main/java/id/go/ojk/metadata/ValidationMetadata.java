package id.go.ojk.metadata;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.metadata.validation.base.IBaseMetadataValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class ValidationMetadata<T extends Enum<T> & IBaseMetadataValidation> {

    @Setter
    @Getter
    private List<SegmentValidation> segmentValidations;

    @Setter
    @Getter
    private Map<Integer, List<T>> fieldValidations;



}
