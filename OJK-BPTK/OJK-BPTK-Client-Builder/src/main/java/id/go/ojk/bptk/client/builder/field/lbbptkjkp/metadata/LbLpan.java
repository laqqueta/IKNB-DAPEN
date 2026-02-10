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
import id.go.ojk.bptk.client.builder.field.lbbptkjkp.reference.ER5703LPAN;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLpan extends BaseMetadata {
  public LbLpan(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjkp eEnum = EFormLbbptkjkp.LPAN;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 17, 17);

    res.setRequiredPos(ER5703LPAN.genRequiredPos());
    res.setUniquePos(ER5703LPAN.genUniquePos());
    res.setSavePos(ER5703LPAN.genFieldSave());
    res.setSavePosForm(ER5703LPAN.genFieldSave());

    res.addSegmentValidations(ER5703LPAN.genRowValidation05());
    res.addSegmentValidations(ER5703LPAN.genRowValidation08());
    res.addSegmentValidations(ER5703LPAN.genRowValidation09());
    res.addSegmentValidations(ER5703LPAN.genRowValidation13());
    res.addSegmentValidations(ER5703LPAN.genRowValidation16());
    res.addSegmentValidations(ER5703LPAN.genRowValidation17());
    res.addSegmentValidations(ER5703LPAN.genRowValidation18());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
        .confReference(EHeaderMetadataLbbptkjkp.R5703LPAN.getObject())
        .confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
