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
import id.go.ojk.bptk.client.builder.field.lbbptkjkp.reference.ER5702LPKOMP;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLpkomp extends BaseMetadata {
  public LbLpkomp(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjkp eEnum = EFormLbbptkjkp.LPKOMP;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 25, 25);

    res.setRequiredPos(ER5702LPKOMP.genRequiredPos());
    res.setUniquePos(ER5702LPKOMP.genUniquePos());
    res.setSavePos(ER5702LPKOMP.genFieldSave());
    res.setSavePosForm(ER5702LPKOMP.genFieldSave());

    res.addSegmentValidations(ER5702LPKOMP.genRowValidation09());
    res.addSegmentValidations(ER5702LPKOMP.genRowValidation12());
    res.addSegmentValidations(ER5702LPKOMP.genRowValidation14());
    res.addSegmentValidations(ER5702LPKOMP.genRowValidation22());
    res.addSegmentValidations(ER5702LPKOMP.genRowValidation23());
    res.addSegmentValidations(ER5702LPKOMP.genRowValidation26());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 16, 16, refTable)
        .confReference(EHeaderMetadataLbbptkjkp.R5702LPKOMP.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
