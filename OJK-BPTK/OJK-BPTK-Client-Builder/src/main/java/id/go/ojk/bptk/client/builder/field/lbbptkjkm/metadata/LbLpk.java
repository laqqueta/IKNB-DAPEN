package id.go.ojk.bptk.client.builder.field.lbbptkjkm.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjkm;
import id.go.ojk.bptk.client.builder.field.lbbptkjkm.reference.EHeaderMetadataLbbptkjkm;
import id.go.ojk.bptk.client.builder.field.lbbptkjkm.reference.ER5501LPK;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLpk extends BaseMetadata {
  public LbLpk(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjkm eEnum = EFormLbbptkjkm.LPK;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 33, 33);

    res.setRequiredPos(ER5501LPK.genRequiredPos());
    res.setUniquePos(ER5501LPK.genUniquePos());
    res.setSavePos(ER5501LPK.genFieldSave());
    res.setSavePosForm(ER5501LPK.genFieldSave());

    res.addSegmentValidations(ER5501LPK.genRowValidation18());
    res.addSegmentValidations(ER5501LPK.genRowValidation20());
    res.addSegmentValidations(ER5501LPK.genRowValidation24());
    res.addSegmentValidations(ER5501LPK.genRowValidation30());
    res.addSegmentValidations(ER5501LPK.genRowValidation33());
    res.addSegmentValidations(ER5501LPK.genRowValidation34());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkjkm.R5501LPK.getObject())
        .confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
