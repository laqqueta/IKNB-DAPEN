package id.go.ojk.metadata.submission;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.metadata.submission.base.BaseSubmissionConfig;
import id.go.ojk.metadata.util.constants.ProgramType;

public class SubmissionConfig extends BaseSubmissionConfig {

    public SubmissionConfig(String reportCode, ExtensionType extensionType) {
        super(reportCode, extensionType);
    }

    public SubmissionConfig(String reportCode) {
        super(reportCode, ExtensionType.TXT);
    }

    // DAPEN 2026
    public SubmissionConfig(ProgramType programType) {
        super(programType.toString(), ExtensionType.TXT);
    }
}
