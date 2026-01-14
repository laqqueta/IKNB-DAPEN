package id.go.ojk.bpks.client.builder.field.lbbpkslpp.metadata;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslpp;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbSp extends BaseMetadata {
  public LbSp(String reportCode) {
    super(reportCode, ".pdf");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslpp eEnum = EFormLbbpkslpp.SP;
    return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
  }
}
