package id.go.ojk.bpks.client.builder.field.lbbpksdjs.metadata;

import id.go.ojk.bpks.client.builder.field.EFormLbbpksdjs;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbSpd extends BaseMetadata {
  public LbSpd(String reportCode) {
    super(reportCode, ".pdf");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpksdjs eEnum = EFormLbbpksdjs.SPD;
    return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
  }
}
