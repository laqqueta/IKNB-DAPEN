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
import id.go.ojk.bptk.client.builder.field.lbbptkjkm.reference.ER5502LPKOMP;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLpkomp extends BaseMetadata {
  public LbLpkomp(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjkm eEnum = EFormLbbptkjkm.LPKOMP;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 24, 24);

    res.setRequiredPos(ER5502LPKOMP.genRequiredPos());
    res.setUniquePos(ER5502LPKOMP.genUniquePos());
    res.setSavePos(ER5502LPKOMP.genFieldSave());
    res.setSavePosForm(ER5502LPKOMP.genFieldSave());

    res.addSegmentValidations(ER5502LPKOMP.genRowValidation03());
    res.addSegmentValidations(ER5502LPKOMP.genRowValidation12());
    res.addSegmentValidations(ER5502LPKOMP.genRowValidation14());
    res.addSegmentValidations(ER5502LPKOMP.genRowValidation23());
    res.addSegmentValidations(ER5502LPKOMP.genRowValidation24());
    res.addSegmentValidations(ER5502LPKOMP.genRowValidation25());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 16, 16, refTable)
        .confReference(EHeaderMetadataLbbptkjkm.R5502LPKOMP.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
