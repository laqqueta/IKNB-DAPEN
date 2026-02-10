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
import id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference.ER5403LPAN;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLpan extends BaseMetadata {
  public LbLpan(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjkk eEnum = EFormLbbptkjkk.LPAN;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 17, 17);

    res.setRequiredPos(ER5403LPAN.genRequiredPos());
    res.setUniquePos(ER5403LPAN.genUniquePos());
    res.setSavePos(ER5403LPAN.genFieldSave());
    res.setSavePosForm(ER5403LPAN.genFieldSave());

    res.addSegmentValidations(ER5403LPAN.genRowValidation07());
    res.addSegmentValidations(ER5403LPAN.genRowValidation11());
    res.addSegmentValidations(ER5403LPAN.genRowValidation18());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
        .confReference(EHeaderMetadataLbbptkjkk.R5403LPAN.getObject())
        .confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
