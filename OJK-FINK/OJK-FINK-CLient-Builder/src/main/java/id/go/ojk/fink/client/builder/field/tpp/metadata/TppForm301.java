package id.go.ojk.fink.client.builder.field.tpp.metadata;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.fink.client.builder.field.tpp.EFormTpp;

import java.util.ArrayList;

public class TppForm301 extends BaseMetadata {

    public TppForm301(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {
        EFormTpp form = EFormTpp.TPP_301;

        return new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(), extension, 0, 0, null);
    }
}
