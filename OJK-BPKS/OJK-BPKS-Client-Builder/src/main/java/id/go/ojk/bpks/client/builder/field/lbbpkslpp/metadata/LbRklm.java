package id.go.ojk.bpks.client.builder.field.lbbpkslpp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.*;
import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.EHeaderMetadataLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.ER5209RKLM;
import id.go.ojk.bpks.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbRklm extends BaseMetadata {
  public LbRklm(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslpp eEnum = EFormLbbpkslpp.RKLM;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 1, null);

    res.setRequiredPos(ER5209RKLM.genRequiredPos());
    res.setUniquePos(ER5209RKLM.genUniquePos());
    res.setSavePos(ER5209RKLM.genFieldSave());

    res.addSegmentValidations(ER5209RKLM.genValidationTotal());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 14, 14, refTable)
        .confReference(EHeaderMetadataLbbpkslpp.R5209RKLM.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Sandi Lokasi", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.LOKASI_DATI_2.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5209RKLM.genConditionalExistA())));
    fs.add(sf(3, null, "Nama Lokasi", sv(C, 1, 100, all)
        .confRegex(PATTERN_NAME)
        .confConditionalRequired(ER5209RKLM.genConditionalExistA())));
    fs.add(sf(4, null, "Jenis Fasilitas Kesehatan", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.JENIS_FASILITAS_KESEHATAN.getObject())
        .confRegex(patternAlfaNumeric)
        .confConditionalRequired(ER5209RKLM.genConditionalExistA())));
    fs.add(sf(5, null, "Kelas", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.KELAS_PESERTA_PROGRAM_JAMINAN.getObject())
        .confRegex(patternAlfaNumeric)
        .confConditionalRequired(ER5209RKLM.genConditionalExistA())));
    fs.add(sf(6, null, "Jenis Klaim", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.JENIS_KLAIM.getObject())
        .confRegex(patternAlfaNumeric)
        .confConditionalRequired(ER5209RKLM.genConditionalExistA())));
    fs.add(sf(7, null, "Detail Klaim", sv(C, 1, 100, alfaNumeric)
        .confConditionalRequired(ER5209RKLM.genConditionalExistA())));
    fs.add(sf(8, null, "Nilai Klaim - Jumlah Kasus", sv(M, 1, 10, numeric)));
    fs.add(sf(9, null, "Nilai Klaim - Nilai", sv(M, 1, 20, numeric)));
    return res;
  }
}
