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
import id.go.ojk.bptk.client.builder.field.lbbptkjp.reference.ER5803AI;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbAi extends BaseMetadata {
  public LbAi(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjp eEnum = EFormLbbptkjp.AI;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 14, 14);

    res.setRequiredPos(ER5803AI.genRequiredPos());
    res.setUniquePos(ER5803AI.genUniquePos());
    res.setSavePos(ER5803AI.genFieldSave());

    res.addSegmentValidations(ER5803AI.genRowValidation15());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
        .confReference(EHeaderMetadataLbbptkjp.R5803AI.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
