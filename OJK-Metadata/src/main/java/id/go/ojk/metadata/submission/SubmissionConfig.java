package id.go.ojk.metadata.submission;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.metadata.submission.base.BaseSubmissionConfig;

public class SubmissionConfig extends BaseSubmissionConfig {

    public SubmissionConfig(String reportCode, ExtensionType extensionType) {
        super(reportCode, extensionType);
    }

    public SubmissionConfig(String reportCode) {
        super(reportCode, ExtensionType.TXT);
    }
}
