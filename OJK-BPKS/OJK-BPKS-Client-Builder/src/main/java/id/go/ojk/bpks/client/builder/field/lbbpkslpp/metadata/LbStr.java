package id.go.ojk.bpks.client.builder.field.lbbpkslpp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.EHeaderMetadataLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.ER5206STR;
import id.go.ojk.bpks.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbStr extends BaseMetadata {
  public LbStr(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslpp eEnum = EFormLbbpkslpp.STR;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 1, null);

    res.setRequiredPos(ER5206STR.genRequiredPos());
    res.setUniquePos(ER5206STR.genUniquePos());
    res.setSavePos(ER5206STR.genFieldSave());

    res.addSegmentValidations(ER5206STR.genValidationTotal());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpkslpp.R5206STR.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Bidang Keahlian", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.BIDANG_KEAHLIAN.getObject())
        .confRegex(patternAlfaNumeric)
        .confConditionalRequired(ER5206STR.genConditionalExistA())));
    fs.add(sf(3, null, "Kualifikasi", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.KUALIFIKASI_TENAGA_AHLI.getObject())
        .confRegex(patternAlfaNumeric)
        .confConditionalRequired(ER5206STR.genConditionalExistA())));
    fs.add(sf(4, null, "Jumlah Tenaga Ahli", sv(M, 1, 10, numeric)));
    return res;
  }
}
