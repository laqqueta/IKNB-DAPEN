package id.go.ojk.bpks.client.builder.field.lbbpkslk.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.EHeaderMetadataLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.ER5003LAK;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLak extends BaseMetadata {
  public LbLak(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslk eEnum = EFormLbbpkslk.LAK;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 30, 30, null, null);

    res.setRequiredPos(ER5003LAK.genRequiredPos());
    res.setUniquePos(ER5003LAK.genUniquePos());
    res.setSavePos(ER5003LAK.genFieldSave());

    res.addSegmentValidations(ER5003LAK.genRowValidation4());
    res.addSegmentValidations(ER5003LAK.genRowValidation7());
    res.addSegmentValidations(ER5003LAK.genRowValidation8());
    res.addSegmentValidations(ER5003LAK.genRowValidation13());
    res.addSegmentValidations(ER5003LAK.genRowValidation18());
    res.addSegmentValidations(ER5003LAK.genRowValidation19());
    res.addSegmentValidations(ER5003LAK.genRowValidation23());
    res.addSegmentValidations(ER5003LAK.genRowValidation27());
    res.addSegmentValidations(ER5003LAK.genRowValidation28());
    res.addSegmentValidations(ER5003LAK.genRowValidation29());
    res.addSegmentValidations(ER5003LAK.genRowValidation31());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpkslk.R5003LAK.getObject()).confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
