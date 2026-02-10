package id.go.ojk.bptk.client.builder.field.lbbptkjht.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjht;
import id.go.ojk.bptk.client.builder.field.lbbptkjht.reference.EHeaderMetadataLbbptkjht;
import id.go.ojk.bptk.client.builder.field.lbbptkjht.reference.ER5601LAN;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLan extends BaseMetadata {
  public LbLan(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjht eEnum = EFormLbbptkjht.LAN;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 34, 34);

    res.setRequiredPos(ER5601LAN.genRequiredPos());
    res.setUniquePos(ER5601LAN.genUniquePos());
    res.setSavePos(ER5601LAN.genFieldSave());
    res.setSavePosForm(ER5601LAN.genFieldSave());

    res.addSegmentValidations(ER5601LAN.genRowValidation23());
    res.addSegmentValidations(ER5601LAN.genRowValidation26());
    res.addSegmentValidations(ER5601LAN.genRowValidation33());
    res.addSegmentValidations(ER5601LAN.genRowValidation34());
    res.addSegmentValidations(ER5601LAN.genRowValidation35());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkjht.R5601LAN.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
