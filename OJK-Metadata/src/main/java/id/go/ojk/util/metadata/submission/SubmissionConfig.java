package id.go.ojk.util.metadata.submission;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.util.metadata.submission.base.BaseSubmissionConfig;

public class SubmissionConfig extends BaseSubmissionConfig {

    public SubmissionConfig(String reportCode, ExtensionType extensionType) {
        super(reportCode, extensionType);
    }

    public SubmissionConfig(String reportCode) {
        super(reportCode, ExtensionType.TXT);
    }
}
