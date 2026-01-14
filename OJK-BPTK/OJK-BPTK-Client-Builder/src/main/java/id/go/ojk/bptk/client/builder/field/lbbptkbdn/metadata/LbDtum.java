package id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.EHeaderMetadataLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.ER5300DTUM;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbDtum extends BaseMetadata {
  public LbDtum(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkbdn eEnum = EFormLbbptkbdn.DTUM;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 16, 16);

    res.setRequiredPos(ER5300DTUM.genRequiredPos());
    res.setUniquePos(ER5300DTUM.genUniquePos());
    res.setFieldSavePos(ER5300DTUM.genFieldSave());

    res.addSegmentValidations(ER5300DTUM.genReferenceValidationA());

    res.addSegmentValidations(ER5300DTUM.genLengthValidation05());
    res.addSegmentValidations(ER5300DTUM.genLengthValidation15());
    res.addSegmentValidations(ER5300DTUM.genLengthValidation40());
    res.addSegmentValidations(ER5300DTUM.genLengthValidation50());
    res.addSegmentValidations(ER5300DTUM.genLengthValidation100());
    res.addSegmentValidations(ER5300DTUM.genLengthValidation200());

    res.addSegmentValidations(ER5300DTUM.genValidationTypeReference());
    res.addSegmentValidations(ER5300DTUM.genValidationTypePhone());
    res.addSegmentValidations(ER5300DTUM.genValidationAlfaNumeric());
    res.addSegmentValidations(ER5300DTUM.genValidationTypeAll());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
        .confReference(EHeaderMetadataLbbptkbdn.R5300DTUM.getObject())
        .confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Keterangan", sv(M, 1, Integer.MAX_VALUE, all2)));
    return res;
  }
}
