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
import id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference.ER5401LPK;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLpk extends BaseMetadata {
  public LbLpk(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjkk eEnum = EFormLbbptkjkk.LPK;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 34, 34);

    res.setRequiredPos(ER5401LPK.genRequiredPos());
    res.setUniquePos(ER5401LPK.genUniquePos());
    res.setSavePos(ER5401LPK.genFieldSave());
    res.setSavePosForm(ER5401LPK.genFieldSave());

    res.addSegmentValidations(ER5401LPK.genRowValidation18());
    res.addSegmentValidations(ER5401LPK.genRowValidation20());
    res.addSegmentValidations(ER5401LPK.genRowValidation24());
    res.addSegmentValidations(ER5401LPK.genRowValidation30());
    res.addSegmentValidations(ER5401LPK.genRowValidation34());
    res.addSegmentValidations(ER5401LPK.genRowValidation35());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkjkk.R5401LPK.getObject())
        .confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
