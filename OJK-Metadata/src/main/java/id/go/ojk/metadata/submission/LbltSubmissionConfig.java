package id.go.ojk.metadata.submission;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.metadata.submission.base.BaseSubmissionConfig;
import id.go.ojk.metadata.submission.reference.LbltReferenceConfig;

public class LbltSubmissionConfig extends BaseSubmissionConfig {
    private LbltReferenceConfig config;

    public LbltSubmissionConfig(String reportCode, ExtensionType extensionType) {
        super(reportCode, extensionType);
    }

    @Override
    protected void setSubmissionConfigs(SubmissionFormat sf) {
        super.setSubmissionConfigs(sf);
    }

    @Override
    public <T extends Config<T>> Config<T> config() {
        return new LbltConfig<>();
    }

    public class LbltConfig<T extends Config<T>> extends Config<T> {
        public <C extends LbltReferenceConfig> Config<T> setReferenceConfigs(C referenceConfigs) {
            LbltSubmissionConfig.this.config = referenceConfigs;
            return this;
        }
    }
}
