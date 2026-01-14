package id.go.ojk.bptk.client.builder.field.labptkjht.metadata;

import java.util.ArrayList;

import id.go.ojk.bptk.client.builder.field.IForm;
import id.go.ojk.bptk.client.builder.field.labptkjht.reference.EHeaderMetadataLabptkjht;
import id.go.ojk.bptk.client.builder.field.labptkjht.reference.ER6702RAS;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

import static id.go.ojk.client.model.config.SimpleValidation.*;
import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;
import java.util.List;
import id.go.ojk.client.model.config.SubmissionField;

public class LaRasJht extends BaseMetadata {

  private final IForm form;

  public LaRasJht(IForm form) {
    super(form.getReportCode(), ".txt");
    this.form = form;
  }

  @Override
  public SubmissionFormat get() {
    SubmissionFormat res = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(),
        extension, 6, 6);

    res.setRequiredPos(ER6702RAS.genRequiredPos());
    res.setUniquePos(ER6702RAS.genUniquePos());
    res.setSavePos(ER6702RAS.genFieldSave());

    res.addSegmentValidations(ER6702RAS.genValidationTypeNumeric());
    res.addSegmentValidations(ER6702RAS.genValidationTypeDecimal());
    res.addSegmentValidations(ER6702RAS.genValidationLengthNumeric());
    res.addSegmentValidations(ER6702RAS.genValidationLengthDecimal());
    res.addSegmentValidations(ER6702RAS.genRowValidation03());
    res.addSegmentValidations(ER6702RAS.genRowValidation07());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen", sv(M, 13, 20, refTable /* Huruf Angka */)
        .confRegex(patternAlfaNumeric)
        .confReference(EHeaderMetadataLabptkjht.R6702RAS.getObject())));
    fs.add(sf(2, null, "Nilai Rasio", sv(M, 1, Integer.MAX_VALUE, all2)));
    return res;
  }
}
