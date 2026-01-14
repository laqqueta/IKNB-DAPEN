package id.go.ojk.bptk.client.builder.field.lbbptkjkp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjkp;
import id.go.ojk.bptk.client.builder.field.lbbptkjkp.reference.EHeaderMetadataLbbptkjkp;
import id.go.ojk.bptk.client.builder.field.lbbptkjkp.reference.ER5704LAK;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLak extends BaseMetadata {
  public LbLak(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjkp eEnum = EFormLbbptkjkp.LAK;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 27, 27);

    res.setRequiredPos(ER5704LAK.genRequiredPos());
    res.setUniquePos(ER5704LAK.genUniquePos());
    res.setSavePos(ER5704LAK.genFieldSave());

    res.addSegmentValidations(ER5704LAK.genRowValidation08());
    res.addSegmentValidations(ER5704LAK.genRowValidation12());
    res.addSegmentValidations(ER5704LAK.genRowValidation13());
    res.addSegmentValidations(ER5704LAK.genRowValidation16());
    res.addSegmentValidations(ER5704LAK.genRowValidation19());
    res.addSegmentValidations(ER5704LAK.genRowValidation20());
    res.addSegmentValidations(ER5704LAK.genRowValidation21());
    res.addSegmentValidations(ER5704LAK.genRowValidation23());
    res.addSegmentValidations(ER5704LAK.genRowValidation25());
    res.addSegmentValidations(ER5704LAK.genRowValidation26());
    res.addSegmentValidations(ER5704LAK.genRowValidation28());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkjkp.R5704LAK.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
