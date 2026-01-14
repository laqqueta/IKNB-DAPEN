package id.go.ojk.bpks.client.builder.field.lbbpkslpp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternAddress2;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.client.model.config.SimpleValidation.patternName;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.EHeaderMetadataLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbKwkc extends BaseMetadata {
  public LbKwkc(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslpp eEnum = EFormLbbpkslpp.KWKC;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 0, null);

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 14, 14, refTable)
        .confReference(EHeaderMetadataLbbpkslpp.R5204KWKC.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Jenis Kantor", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.JENIS_KANTOR.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(3, null, "Alamat Lengkap", sv(M, 1, 100, all).confRegex(patternAddress2)));
    fs.add(sf(4, null, "Lokasi Kantor", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.LOKASI_DATI_2.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(5, null, "Sandi Kantor", sv(M, 1, 20, alfaNumeric)));
    fs.add(sf(6, null, "Nama", sv(M, 1, 100, all).confRegex(patternName)));
    fs.add(sf(7, null, "Kode Pos ", sv(M, 1, 5, numeric)));
    fs.add(sf(8, null, "Telepon", sv(M, 1, 15, all)));
    fs.add(sf(9, null, "Total Pegawai", sv(M, 1, 8, numeric)));
    return res;
  }
}
