package id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkbdn;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbSp extends BaseMetadata {
  public LbSp(String reportCode) {
    super(reportCode, ".pdf");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkbdn eEnum = EFormLbbptkbdn.SP;
    return new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, extension);
  }
}
