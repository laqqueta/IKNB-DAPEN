package id.go.ojk.bptk.client.builder.field.labptkjkk.metadata;

import java.util.ArrayList;

import id.go.ojk.bptk.client.builder.field.IForm;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LaLampJkk extends BaseMetadata {

  private final IForm form;

  public LaLampJkk(IForm form) {
    super(form.getReportCode(), ".pdf");
    this.form = form;
  }

  @Override
  public SubmissionFormat get() {
    SubmissionFormat res = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(),
        extension, 0, null);
    return res;
  }
}
