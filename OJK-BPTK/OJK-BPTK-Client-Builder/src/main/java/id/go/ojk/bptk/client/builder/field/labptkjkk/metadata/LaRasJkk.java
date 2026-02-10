package id.go.ojk.bptk.client.builder.field.labptkjkk.metadata;

import java.util.ArrayList;

import id.go.ojk.bptk.client.builder.field.IForm;
import id.go.ojk.bptk.client.builder.field.labptkjkk.reference.EHeaderMetadataLabptkjkk;
import id.go.ojk.bptk.client.builder.field.labptkjkk.reference.ER6402RAS;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

import static id.go.ojk.client.model.config.SimpleValidation.*;
import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;
import java.util.List;
import id.go.ojk.client.model.config.SubmissionField;

public class LaRasJkk extends BaseMetadata {

  private final IForm form;

  public LaRasJkk(IForm form) {
    super(form.getReportCode(), ".txt");
    this.form = form;
  }

  @Override
  public SubmissionFormat get() {
    SubmissionFormat res = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(),
        extension, 3, 3);

    res.setRequiredPos(ER6402RAS.genRequiredPos());
    res.setUniquePos(ER6402RAS.genUniquePos());
    res.setSavePos(ER6402RAS.genFieldSave());

    res.addSegmentValidations(ER6402RAS.genValidationTypeNumeric());
    res.addSegmentValidations(ER6402RAS.genValidationTypeDecimal());
    res.addSegmentValidations(ER6402RAS.genValidationLengthNumeric());
    res.addSegmentValidations(ER6402RAS.genValidationLengthDecimal());
    res.addSegmentValidations(ER6402RAS.genValidationRatio());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen", sv(M, 13, 20, refTable /* Huruf Angka */)
        .confRegex(patternAlfaNumeric)
        .confReference(EHeaderMetadataLabptkjkk.R6402RAS.getObject())));
    fs.add(sf(2, null, "Nilai Rasio", sv(M, 1, Integer.MAX_VALUE, all2)));
    return res;
  }
}
