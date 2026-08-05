package id.go.ojk.metadata.submission.base;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.metadata.validation.ValidationConverter;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.metadata.validation.base.IBaseMetadataValidation;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseSubmissionConfig extends BaseMetadata {
    protected SubmissionFormat submissionFormat;
    protected List<SubmissionField> submissionFields = new ArrayList<>();
    protected List<SegmentValidation> segmentValidations = new ArrayList<>();
    protected ReferenceConfig referenceConfig;

    private final ExtensionType extensionType;

    public BaseSubmissionConfig(String reportCode, ExtensionType extensionType) {
        super(reportCode, extensionType.getType());
        this.extensionType = extensionType;
    }

    @Override
    public SubmissionFormat get() {
        if (extensionType.equals(ExtensionType.PDF)) {
            return submissionFormat;
        }

        setSubmissionConfigs(submissionFormat);

        List<SubmissionField> fs = submissionFormat.getFields();

        if (!segmentValidations.isEmpty()) segmentValidations.forEach(submissionFormat::addSegmentValidations);
        if (!submissionFields.isEmpty()) fs.addAll(submissionFields);

        return submissionFormat;
    }

    protected void setSubmissionConfigs(SubmissionFormat sf) {
        if (referenceConfig == null) return;

        if (referenceConfig.requiredPos() != null) {
            sf.setRequiredPos(referenceConfig);
        }

        if (referenceConfig.savePos() != null) {
            sf.setSavePos(referenceConfig);
        }

        if (referenceConfig.saveFieldPos() != null) {
            sf.setFieldSavePos(referenceConfig);
        }

        if (referenceConfig.savePosForm() != null) {
            sf.setSavePosForm(referenceConfig);
        }

        if (referenceConfig.uniquePos() != null) {
            sf.setUniquePos(referenceConfig);
        }
    }

    public <T extends Config<T>> Config<T> config() {
        return new Config<>();
    }

    public class Config<T extends Config<T>> {
        public Config<T> setSubmissionFormat(SubmissionFormat submissionFormat) {
            BaseSubmissionConfig.this.submissionFormat = submissionFormat;
            return this;
        }

        public Config<T> setSubmissionFormat(SubmissionFormatBuilder submissionFormatBuilder) {
            BaseSubmissionConfig.this.submissionFormat = new SubmissionFormat(submissionFormatBuilder);
            return this;
        }

        public Config<T> setSubmissionField(List<SubmissionField> submissionFields) {
            BaseSubmissionConfig.this.submissionFields = submissionFields;
            return this;
        }

        public <C extends ReferenceConfig> Config<T> setReferenceConfigs(C referenceConfigs) {
//            if (referenceConfigs == null) throw new IllegalStateException();

            BaseSubmissionConfig.this.referenceConfig = referenceConfigs;
            return this;
        }

        public <V extends Enum<V> & IBaseMetadataValidation> Config<T> setSegmentValidations(BaseMetadataValidation<V> validationMetadata) {
            BaseSubmissionConfig.this.segmentValidations = validationMetadata.getSegmentValidations();
            return this;
        }

        public <V extends Enum<V> & IBaseMetadataValidation> Config<T> setSegmentValidations(List<V> segmentValidations) {
            BaseSubmissionConfig.this.segmentValidations = segmentValidations.stream()
                    .map(v -> ValidationConverter.toValidation(v, SegmentValidation.class))
                    .collect(Collectors.toList());

            return this;
        }

        public Config<T> additionalSegmentValidations(List<SegmentValidation> segmentValidations) {
            BaseSubmissionConfig.this.segmentValidations.addAll(segmentValidations) ;

            return this;
        }

        // for testing to not using segment validations
        public Config<T> setSegmentValidations() {
            BaseSubmissionConfig.this.segmentValidations = new ArrayList<>();
            return this;
        }

        // x
        public BaseSubmissionConfig build() {
            if (BaseSubmissionConfig.this.submissionFormat == null) throw new IllegalStateException("SubmissionFormat is required");
            if (BaseSubmissionConfig.this.submissionFields == null && extensionType.equals(ExtensionType.TXT)) throw new IllegalStateException("SubmissionField is required for .txt file");


            return BaseSubmissionConfig.this;
        }
    }
}
