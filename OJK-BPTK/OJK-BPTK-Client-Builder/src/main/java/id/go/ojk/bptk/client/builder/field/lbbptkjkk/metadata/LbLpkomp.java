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
import id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference.ER5402LPKOMP;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLpkomp extends BaseMetadata {
  public LbLpkomp(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjkk eEnum = EFormLbbptkjkk.LPKOMP;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 27, 27);

    res.setRequiredPos(ER5402LPKOMP.genRequiredPos());
    res.setUniquePos(ER5402LPKOMP.genUniquePos());
    res.setSavePos(ER5402LPKOMP.genFieldSave());
    res.setSavePosForm(ER5402LPKOMP.genFieldSave());

    res.addSegmentValidations(ER5402LPKOMP.genRowValidation03());
    res.addSegmentValidations(ER5402LPKOMP.genRowValidation12());
    res.addSegmentValidations(ER5402LPKOMP.genRowValidation14());
    res.addSegmentValidations(ER5402LPKOMP.genRowValidation23());
    res.addSegmentValidations(ER5402LPKOMP.genRowValidation24());
    res.addSegmentValidations(ER5402LPKOMP.genRowValidation28());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 16, 16, refTable)
        .confReference(EHeaderMetadataLbbptkjkk.R5402LPKOMP.getObject()).confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
