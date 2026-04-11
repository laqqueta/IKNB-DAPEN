package id.go.ojk.util.metadata.submission.base;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.util.metadata.validation.base.IBaseMetadataValidation;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseSubmissionConfig extends BaseMetadata {
    protected SubmissionFormat submissionFormat;
    protected String requiredPos = null;
    protected String uniquePos = null;
    protected String savePos = null;
    protected String saveField = null;
    protected String savePosForm = null;
    protected List<SubmissionField> submissionFields = new ArrayList<>();
    protected List<SegmentValidation> segmentValidations = new ArrayList<>();

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

        List<SubmissionField> fs = submissionFormat.getFields();

        setSubmissionConfigs(submissionFormat);

        if (!segmentValidations.isEmpty()) segmentValidations.forEach(submissionFormat::addSegmentValidations);
        if (!submissionFields.isEmpty()) fs.addAll(submissionFields);

        return submissionFormat;
    }

    protected void setSubmissionConfigs(SubmissionFormat sf) {
        if (requiredPos != null) {
            sf.setRequiredPos(requiredPos);
        }

        if (savePos != null) {
            sf.setSavePos(savePos);
        }

        if (saveField != null) {
            sf.setFieldSavePos(saveField);
        }

        if (savePosForm != null) {
            sf.setSavePosForm(savePosForm);
        }

        if (uniquePos != null) {
            sf.setUniquePos(uniquePos);
        }
    }

    public Config config() {
        return new Config();
    }

    public class Config {
        public Config setSubmissionFormat(SubmissionFormat submissionFormat) {
            BaseSubmissionConfig.this.submissionFormat = submissionFormat;
            return this;
        }

        public Config setSubmissionFormat(SubmissionFormatBuilder submissionFormatBuilder) {
            BaseSubmissionConfig.this.submissionFormat = new SubmissionFormat(submissionFormatBuilder);
            return this;
        }

        public Config setRequiredPos(String requiredPos) {
            BaseSubmissionConfig.this.requiredPos = requiredPos;
            return this;
        }

        public Config setUniquePos(String uniquePos) {
            BaseSubmissionConfig.this.uniquePos = uniquePos;
            return this;
        }

        public Config setSavePos(String savePos) {
            BaseSubmissionConfig.this.savePos = savePos;
            return this;
        }

        public Config setSaveField(String saveField) {
            BaseSubmissionConfig.this.saveField = saveField;
            return this;
        }

        public Config setSavePosForm(String savePosForm) {
            BaseSubmissionConfig.this.savePosForm = savePosForm;
            return this;
        }

        public Config setSubmissionField(List<SubmissionField> submissionFields) {
            BaseSubmissionConfig.this.submissionFields = submissionFields;
            return this;
        }

        public <T extends Enum<T> & IBaseMetadataValidation> Config setSegmentValidations(BaseMetadataValidation<T> validationMetadata) {
            BaseSubmissionConfig.this.segmentValidations = validationMetadata.getSegmentValidations();
            return this;
        }

        public BaseSubmissionConfig build() {
            if (BaseSubmissionConfig.this.submissionFormat == null) throw new IllegalStateException("SubmissionFormat is required");

            return BaseSubmissionConfig.this;
        }
    }
}
