package id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.EHeaderMetadataLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.ER5302LKK;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLkk extends BaseMetadata {
  public LbLkk(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkbdn eEnum = EFormLbbptkbdn.LKK;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 47, 47);

    res.setRequiredPos(ER5302LKK.genRequiredPos());
    res.setUniquePos(ER5302LKK.genUniquePos());
    res.setSavePos(ER5302LKK.genFieldSave());
    
    res.addSegmentValidations(ER5302LKK.genRowValidation06());
    res.addSegmentValidations(ER5302LKK.genRowValidation10());
    res.addSegmentValidations(ER5302LKK.genRowValidation11());
    res.addSegmentValidations(ER5302LKK.genRowValidation19());
    res.addSegmentValidations(ER5302LKK.genRowValidation20());
    res.addSegmentValidations(ER5302LKK.genRowValidation25());
    res.addSegmentValidations(ER5302LKK.genRowValidation26());
    res.addSegmentValidations(ER5302LKK.genRowValidation31());
    res.addSegmentValidations(ER5302LKK.genRowValidation34());
    res.addSegmentValidations(ER5302LKK.genRowValidation35());
    res.addSegmentValidations(ER5302LKK.genRowValidation41());
    res.addSegmentValidations(ER5302LKK.genRowValidation42());
    res.addSegmentValidations(ER5302LKK.genRowValidation45());
    res.addSegmentValidations(ER5302LKK.genRowValidation48());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkbdn.R5302LKK.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
