package id.go.ojk.fink.client.builder.field.tpp.metadata;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.fink.client.builder.field.tpp.EFormTpp;

public class TppForm99 extends BaseMetadata {

    private EFormTpp form;

    public TppForm99(String reportCode, EFormTpp formTpp) {
        super(reportCode, ".pdf");
        this.form = formTpp;
    }

    @Override
    public SubmissionFormat get() {
        return new SubmissionFormat(form.getCode(), form.getName(), reportCode, extension);
    }
}
