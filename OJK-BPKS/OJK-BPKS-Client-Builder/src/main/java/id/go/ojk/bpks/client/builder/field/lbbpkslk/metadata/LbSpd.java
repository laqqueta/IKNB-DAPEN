package id.go.ojk.bpks.client.builder.field.lbbpkslk.metadata;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslk;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbSpd extends BaseMetadata {
  public LbSpd(String reportCode) {
    super(reportCode, ".pdf");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslk eEnum = EFormLbbpkslk.SPD;
    return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
  }
}
