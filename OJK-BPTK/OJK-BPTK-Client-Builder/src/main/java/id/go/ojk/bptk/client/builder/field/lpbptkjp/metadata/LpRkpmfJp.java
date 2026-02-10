package id.go.ojk.bptk.client.builder.field.lpbptkjp.metadata;

import java.util.ArrayList;

import id.go.ojk.bptk.client.builder.field.IForm;
import id.go.ojk.bptk.client.builder.field.lpbptkjp.reference.EHeaderMetadataLpbptkjp;
import id.go.ojk.bptk.client.builder.field.lpbptkjp.reference.ER6306RKPMF;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

import static id.go.ojk.client.model.config.SimpleValidation.*;
import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;
import java.util.List;
import id.go.ojk.client.model.config.SubmissionField;

public class LpRkpmfJp extends BaseMetadata {

  private final IForm form;

  public LpRkpmfJp(IForm form) {
    super(form.getReportCode(), ".txt");
    this.form = form;
  }

  @Override
  public SubmissionFormat get() {
    SubmissionFormat res = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(),
        extension, 15, 15);
    
    res.setRequiredPos(ER6306RKPMF.genRequiredPos());
    res.setUniquePos(ER6306RKPMF.genUniquePos());
    res.setSavePos(ER6306RKPMF.genFieldSave());

    res.addSegmentValidations(ER6306RKPMF.genValidationTotalJenisManfaat());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen", sv(M, 15, 20, refTable /*Huruf Angka*/)
        .confRegex(patternAlfaNumeric)
        .confReference(EHeaderMetadataLpbptkjp.R6306RKPMF.getObject())));
    fs.add(sf(2, null, "Pemberi Kerja Penerima Upah", sv(M, 1, 20, numeric)));
    fs.add(sf(3, null, "Peserta Penerima Upah", sv(M, 1, 20, numeric)));
    return res;
  }
}
