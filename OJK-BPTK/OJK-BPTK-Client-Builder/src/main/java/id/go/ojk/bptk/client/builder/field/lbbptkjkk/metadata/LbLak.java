package id.go.ojk.bptk.client.builder.field.lbbptkjkk.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjkk;
import id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference.EHeaderMetadataLbbptkjkk;
import id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference.ER5404LAK;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLak extends BaseMetadata {
  public LbLak(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjkk eEnum = EFormLbbptkjkk.LAK;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 25, 25);

    res.setRequiredPos(ER5404LAK.genRequiredPos());
    res.setUniquePos(ER5404LAK.genUniquePos());
    res.setSavePos(ER5404LAK.genFieldSave());

    res.addSegmentValidations(ER5404LAK.genRowValidation06());
    res.addSegmentValidations(ER5404LAK.genRowValidation10());
    res.addSegmentValidations(ER5404LAK.genRowValidation11());
    res.addSegmentValidations(ER5404LAK.genRowValidation14());
    res.addSegmentValidations(ER5404LAK.genRowValidation17());
    res.addSegmentValidations(ER5404LAK.genRowValidation18());
    res.addSegmentValidations(ER5404LAK.genRowValidation19());
    res.addSegmentValidations(ER5404LAK.genRowValidation21());
    res.addSegmentValidations(ER5404LAK.genRowValidation23());


    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkjkk.R5404LAK.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
