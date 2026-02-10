package id.go.ojk.bptk.client.builder.field.labptkjkk.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.IForm;
import id.go.ojk.bptk.client.builder.field.labptkjkk.reference.EHeaderMetadataLabptkjkk;
import id.go.ojk.bptk.client.builder.field.labptkjkk.reference.ER6401DTUM;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LaDtumJkk extends BaseMetadata {

  private final IForm form;

  public LaDtumJkk(IForm form) {
    super(form.getReportCode(), ".txt");
    this.form = form;
  }

  @Override
  public SubmissionFormat get() {
    SubmissionFormat res = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(),
        extension, 19, 19);

    res.setRequiredPos(ER6401DTUM.genRequiredPos());
    res.setUniquePos(ER6401DTUM.genUniquePos());
    res.setFieldSavePos(ER6401DTUM.genFieldSave());

    res.addSegmentValidations(ER6401DTUM.genReferenceValidation());
    res.addSegmentValidations(ER6401DTUM.genValidationTypeAll());
    res.addSegmentValidations(ER6401DTUM.genValidationTypePhone());
    res.addSegmentValidations(ER6401DTUM.genValidationTypePostalCode());
    res.addSegmentValidations(ER6401DTUM.genValidationTypeDate());

    res.addSegmentValidations(ER6401DTUM.genLengthValidation05());
    res.addSegmentValidations(ER6401DTUM.genLengthValidation08());
    res.addSegmentValidations(ER6401DTUM.genLengthValidation15());
    res.addSegmentValidations(ER6401DTUM.genLengthValidation40());
    res.addSegmentValidations(ER6401DTUM.genLengthValidation50());
    res.addSegmentValidations(ER6401DTUM.genLengthValidation100());
    res.addSegmentValidations(ER6401DTUM.genLengthValidation200());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric)
        .confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen", sv(M, 14, 20, refTable /* Huruf Angka */)
        .confRegex(patternAlfaNumeric)
        .confReference(EHeaderMetadataLabptkjkk.R6401DTUM.getObject())));
    fs.add(sf(2, null, "Keterangan", sv(M, 1, Integer.MAX_VALUE, all2)));
    return res;
  }
}
