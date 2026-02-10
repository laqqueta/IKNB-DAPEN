package id.go.ojk.bptk.client.builder.field.labptkjp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.IForm;
import id.go.ojk.bptk.client.builder.field.labptkjp.reference.EHeaderMetadataLabptkjp;
import id.go.ojk.bptk.client.builder.field.labptkjp.reference.ER6802RAS;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LaRasJp extends BaseMetadata {

  private final IForm form;

  public LaRasJp(IForm form) {
    super(form.getReportCode(), ".txt");
    this.form = form;
  }

  @Override
  public SubmissionFormat get() {
    SubmissionFormat res = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(),
        extension, 5, 5);

    res.setRequiredPos(ER6802RAS.genRequiredPos());
    res.setUniquePos(ER6802RAS.genUniquePos());
    res.setSavePos(ER6802RAS.genFieldSave());

    res.addSegmentValidations(ER6802RAS.genValidationTypeNumeric());
    res.addSegmentValidations(ER6802RAS.genValidationTypeDecimal());
    res.addSegmentValidations(ER6802RAS.genValidationLengthNumeric());
    res.addSegmentValidations(ER6802RAS.genValidationLengthDecimal());
    res.addSegmentValidations(ER6802RAS.genValidationRAS0103000000());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen", sv(M, 13, 20, refTable /* Huruf Angka */)
        .confRegex(patternAlfaNumeric)
        .confReference(EHeaderMetadataLabptkjp.R6802RAS.getObject())));
    fs.add(sf(2, null, "Nilai Rasio", sv(M, 1, Integer.MAX_VALUE, all2)));
    return res;
  }
}
