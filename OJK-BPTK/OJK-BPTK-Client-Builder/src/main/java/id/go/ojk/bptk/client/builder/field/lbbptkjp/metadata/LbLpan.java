package id.go.ojk.bptk.client.builder.field.lbbptkjp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjp;
import id.go.ojk.bptk.client.builder.field.lbbptkjp.reference.EHeaderMetadataLbbptkjp;
import id.go.ojk.bptk.client.builder.field.lbbptkjp.reference.ER5802LPAN;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLpan extends BaseMetadata {
  public LbLpan(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjp eEnum = EFormLbbptkjp.LPAN;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 23, 23);

    res.setRequiredPos(ER5802LPAN.genRequiredPos());
    res.setUniquePos(ER5802LPAN.genUniquePos());
    res.setSavePos(ER5802LPAN.genFieldSave());

    res.addSegmentValidations(ER5802LPAN.genRowValidation04());
    res.addSegmentValidations(ER5802LPAN.genRowValidation15());
    res.addSegmentValidations(ER5802LPAN.genRowValidation21());
    res.addSegmentValidations(ER5802LPAN.genRowValidation22());
    res.addSegmentValidations(ER5802LPAN.genRowValidation24());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
        .confReference(EHeaderMetadataLbbptkjp.R5802LPAN.getObject())
        .confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
