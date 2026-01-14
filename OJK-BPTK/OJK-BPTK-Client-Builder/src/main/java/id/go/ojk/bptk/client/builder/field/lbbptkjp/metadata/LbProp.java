package id.go.ojk.bptk.client.builder.field.lbbptkjp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfa;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjp;
import id.go.ojk.bptk.client.builder.field.lbbptkjp.reference.EHeaderMetadataLbbptkjp;
import id.go.ojk.bptk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbProp extends BaseMetadata {
  public LbProp(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjp eEnum = EFormLbbptkjp.PROP;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 0, null);

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
        .confReference(EHeaderMetadataLbbptkjp.R5809PROP.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Jenis Properti", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.JENIS_PROPERTI.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(3, null, "Bukti Pemilikan ", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.BUKTI_PEMILIKAN_TANAH_BANGUNAN.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(4, null, "Status Pemilikan Tanah & Bangunan", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.STATUS_PEMILIKAN_TANAH_BANGUNAN.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(5, null, "Tanggal Perolehan", sv(M, 8, 8, date)));
    fs.add(sf(6, null, "Luas (m2)", sv(M, 1, 16, numeric)));
    fs.add(sf(7, null, "Alamat", sv(M, 1, 250, all)));
    fs.add(sf(8, null, "Lokasi", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.LOKASI_DATI_2.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(9, null, "Atas Nama", sv(M, 1, 100, all)));
    fs.add(sf(10, null, "Hak Berlaku", sv(M, 1, 100, all)));
    fs.add(sf(11, null, "Harga Per M2", sv(M, 1, 20, numeric)));
    fs.add(sf(12, null, "Harga Perolehan", sv(M, 1, 20, numeric)));
    fs.add(sf(13, null, "Penyusutan", sv(M, 1, 20, numeric)));
    fs.add(sf(14, null, "Penurunan Nilai", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.PENURUNAN_NILAI.getObject())
        .confRegex(patternAlfa)));
    fs.add(sf(15, null, "Harga Pasar", sv(M, 1, 20, numeric)));
    fs.add(sf(16, null, "Hirarki Harga Pasar", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.HIRARKI_HARGA_PASAR.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(17, null, "Saldo", sv(M, 1, 20, numeric)));
    return res;
  }
}
