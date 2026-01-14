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
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.ER5000LPK;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLpk extends BaseMetadata {
  public LbLpk(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslk eEnum = EFormLbbpkslk.LPK;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 50, 50);

    res.setRequiredPos(ER5000LPK.genRequiredPos());
    res.setUniquePos(ER5000LPK.genUniquePos());
    res.setSavePos(ER5000LPK.genFieldSave());
    res.setSavePosForm(ER5000LPK.genFieldSave());

    res.addSegmentValidations(ER5000LPK.genRowValidation16());
    res.addSegmentValidations(ER5000LPK.genRowValidation25());
    res.addSegmentValidations(ER5000LPK.genRowValidation26());
    res.addSegmentValidations(ER5000LPK.genRowValidation35());
    res.addSegmentValidations(ER5000LPK.genRowValidation41());
    res.addSegmentValidations(ER5000LPK.genRowValidation42());
    res.addSegmentValidations(ER5000LPK.genRowValidation50());
    res.addSegmentValidations(ER5000LPK.genRowValidation51a());
    res.addSegmentValidations(ER5000LPK.genRowValidation51b());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpkslk.R5000LPK.getObject()).confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
