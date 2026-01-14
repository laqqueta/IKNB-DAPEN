package id.go.ojk.bpks.client.builder.field.lbbpkslpp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_NAME;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.EHeaderMetadataLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.ER5212RPKAP;
import id.go.ojk.bpks.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbRpkap extends BaseMetadata {
  public LbRpkap(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslpp eEnum = EFormLbbpkslpp.RPKAP;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 1, null);

    res.setRequiredPos(ER5212RPKAP.genRequiredPos());
    res.setUniquePos(ER5212RPKAP.genUniquePos());
    res.setSavePos(ER5212RPKAP.genFieldSave());

    res.addSegmentValidations(ER5212RPKAP.genValidationTotal());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 15, 15, refTable)
        .confReference(EHeaderMetadataLbbpkslpp.R5212RPKAP.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Sandi Lokasi", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.LOKASI_DATI_2.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5212RPKAP.genConditionalExistA())));
    fs.add(sf(3, null, "Nama Lokasi", sv(C, 1, 100, all)
        .confRegex(PATTERN_NAME)
        .confConditionalRequired(ER5212RPKAP.genConditionalExistA())));
    fs.add(sf(4, null, "Jenis Fasilitas Kesehatan", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.JENIS_FASILITAS_KESEHATAN.getObject())
        .confRegex(patternAlfaNumeric)
        .confConditionalRequired(ER5212RPKAP.genConditionalExistA())));
    fs.add(sf(5, null, "Jumlah Peserta Terdaftar", sv(M, 1, 10, numeric)));
    fs.add(sf(6, null, " Total Nilai Kapitasi yang Dibayarkan ", sv(M, 1, 20, numeric)));
    return res;
  }
}
