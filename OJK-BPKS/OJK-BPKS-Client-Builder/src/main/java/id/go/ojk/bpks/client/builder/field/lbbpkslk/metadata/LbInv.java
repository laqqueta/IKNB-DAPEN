package id.go.ojk.bpks.client.builder.field.lbbpkslk.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.EHeaderMetadataLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.ER5009INV;
import id.go.ojk.bpks.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbInv extends BaseMetadata {
  public LbInv(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslk eEnum = EFormLbbpkslk.INV;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 1, null);

    res.setRequiredPos(ER5009INV.genRequiredPos());
    res.setUniquePos(ER5009INV.genUniquePos());
    res.setSavePos(ER5009INV.genFieldSave());

    res.addSegmentValidations(ER5009INV.genValidationTotal());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5009INV.genRowValidation23(reportCode));

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpkslk.R5009INV.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Kode Laporan", sv(C, 1, 20, all)
        .confConditionalRequired(ER5009INV.genConditionalExistB())));
    fs.add(sf(3, null, "Jenis Surat Berharga", sv(C, 1, 10, refTable)
        .confRegex(PATTERN_REFERENCE_1)
        .confReference(EHeaderMetadataShared.JENIS_SURAT_BERHARGA.getObject())
        .confConditionalRequired(ER5009INV.genConditionalExistA())));
    fs.add(sf(4, null, "Kategori Surat Berharga", sv(C, 1, 10, refTable)
        .confRegex(PATTERN_REFERENCE_1)
        .confReference(EHeaderMetadataShared.KATEGORI_SURAT_BERHARGA.getObject())
        .confConditionalRequired(ER5009INV.genConditionalExistA())));
    fs.add(sf(5, null, "Nama Penerbit", sv(C, 1, 100, all)
        .confConditionalRequired(ER5009INV.genConditionalExistA())));
    fs.add(sf(6, null, "Nomor Seri", sv(C, 1, 100, all).confConditionalRequired(ER5009INV.genConditional07())));
    fs.add(sf(7, null, "Nama Group", sv(C, 1, 100, all).confConditionalRequired(ER5009INV.genConditionalExistB())));
    fs.add(sf(8, null, "Nama Reksadana", sv(C, 1, 100, all).confConditionalRequired(ER5009INV.genConditional09())));
    fs.add(sf(9, null, "Kode Reksadana", sv(C, 1, 100, all).confConditionalRequired(ER5009INV.genConditional10())));
    fs.add(sf(10, null, "Golongan Penerbit", sv(C, 1, 10, refTable)
        .confRegex(PATTERN_REFERENCE_1)
        .confReference(EHeaderMetadataShared.GOLONGAN_PIHAK_LAWAN.getObject())
        .confConditionalRequired(ER5009INV.genConditionalExistA())));
    fs.add(sf(11, null, "Tanggal Perolehan", sv(C, 8, 8, date)
        .confConditionalRequired(ER5009INV.genConditionalExistA())));
    fs.add(sf(12, null, "Tanggal Mulai", sv(C, 8, 8, date)
        .confConditionalRequired(ER5009INV.genConditionalExistA())));
    fs.add(sf(13, null, "Tanggal Jatuh Tempo", sv(C, 8, 8, date)
        .confConditionalRequired(ER5009INV.genConditionalExistA())));
    fs.add(sf(14, null, "Sektor Ekonomi", sv(C, 1, 10, refTable)
        .confRegex(PATTERN_REFERENCE_1)
        .confReference(EHeaderMetadataShared.SEKTOR_EKONOMI.getObject())
        .confConditionalRequired(ER5009INV.genConditionalExistA())));
    fs.add(sf(15, null, "Lokasi", sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
        .confReference(EHeaderMetadataShared.LOKASI_DATI_2.getObject())
        .confConditionalRequired(ER5009INV.genConditionalExistA())));
    fs.add(sf(16, null, "Sandi BEI", sv(C, 1, 4, alfaNumeric).confConditionalRequired(ER5009INV.genConditional17())));
    fs.add(sf(17, null, "Tujuan Pemilikan", sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
        .confReference(EHeaderMetadataShared.TUJUAN_KEPEMILIKAN.getObject())
        .confConditionalRequired(ER5009INV.genConditionalExistA())));
    fs.add(sf(18, null, "Suku Bunga/Nisbah",sv(C, 1, 8, numericDot)
        .confConditionalRequired(ER5009INV.genConditionalExistA())));
    fs.add(sf(19, null, "Penurunan Nilai",sv(C, 1, 10, refTable)
        .confRegex(PATTERN_REFERENCE_1)
        .confReference(EHeaderMetadataShared.PENURUNAN_NILAI.getObject())
        .confConditionalRequired(ER5009INV.genConditionalExistA())));
    fs.add(sf(20, null, "Harga Perolehan", sv(M, 1, 20, numeric)));
    fs.add(sf(21, null, "Peringkat", sv(C, 1, 10, refTable)
        .confRegex(PATTERN_REFERENCE_1)
        .confReference(EHeaderMetadataShared.PERINGKAT_SURAT_BERHARGA.getObject())
        .confConditionalRequired(ER5009INV.genConditionalExistA())));
    fs.add(sf(22, null, "Hasil Investasi", sv(M, 1, 20, numeric)));
    fs.add(sf(23, null, "Harga Pasar", sv(M, 1, 20, numeric)));
    fs.add(sf(24, null, "Hirarki Harga Pasar", sv(C, 1, 10, refTable)
        .confRegex(PATTERN_REFERENCE_1)
        .confReference(EHeaderMetadataShared.HIRARKI_HARGA_PASAR.getObject())
        .confConditionalRequired(ER5009INV.genConditionalExistA())));
    fs.add(sf(25, null, "Bagian Penyertaan", sv(M, 1, 20, numeric)));
    fs.add(sf(26, null, "Saldo ", sv(M, 1, 20, numeric)));
    return res;
  }
}
