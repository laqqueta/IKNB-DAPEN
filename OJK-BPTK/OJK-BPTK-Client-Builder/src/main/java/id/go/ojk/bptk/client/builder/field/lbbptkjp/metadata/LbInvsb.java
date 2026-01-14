package id.go.ojk.bptk.client.builder.field.lbbptkjp.metadata;

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
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjp;
import id.go.ojk.bptk.client.builder.field.lbbptkjp.reference.EHeaderMetadataLbbptkjp;
import id.go.ojk.bptk.client.builder.field.lbbptkjp.reference.ER5808INVSB;
import id.go.ojk.bptk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbInvsb extends BaseMetadata {
  public LbInvsb(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjp eEnum = EFormLbbptkjp.INVSB;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 0, null);

    res.setSavePos(ER5808INVSB.genFieldSave());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 15, 15, refTable)
        .confReference(EHeaderMetadataLbbptkjp.R5808INVSB.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Jenis Surat Berharga dan Penyertaan Langsung", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.JENIS_SURAT_BERHARGA.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(3, null, "Nama Surat Berharga", sv(M, 1, 100, all)));
    fs.add(sf(4, null, "Nama Penerbit/Nama Manajer Investasi", sv(M, 1, 100, all)));
    fs.add(sf(5, null, "Nomor Seri", sv(M, 1, 100, alfaNumeric)));
    fs.add(sf(6, null, "Kode Penerbit", sv(M, 1, 20, alfaNumeric)));

    //TODO: Yahya - Kolom 8 s/d 10 di templatenya = C tapi tidak ada kondisinya.
    fs.add(sf(7, null, "Golongan Penerbit", sv(O, 1, 10, all).confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(8, null, "Peringkat", sv(O, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.PERINGKAT_SURAT_BERHARGA.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(9, null, "Lembaga Pemeringkat", sv(O, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.LEMBAGA_PEMERINGKAT.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(10, null, "Jangka Waktu, Tanggal Mulai/Tanggal Penerbitan", sv(M, 1, 8, date))
        .addFieldValidations(ER5808INVSB.genFieldValidation11()));
    fs.add(sf(11, null, "Jangka Waktu, Tanggal Jatuh Tempo", sv(M, 1, 8, date))
        .addFieldValidations(ER5808INVSB.genFieldValidation12()));
    fs.add(sf(12, null, "Sektor Ekonomi", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.SEKTOR_EKONOMI.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5808INVSB.genConditionalBagianPenyertaan())));
    fs.add(sf(13, null, "Lokasi", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.LOKASI_DATI_2.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5808INVSB.genConditionalBagianPenyertaan())));
    fs.add(sf(14, null, "Tujuan Pemilikan", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.TUJUAN_KEPEMILIKAN.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5808INVSB.genConditionalBagianPenyertaan())));
    fs.add(sf(15, null, "Syariah/Non Syariah", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.SYARIAH_KONVENSIONAL.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(16, null, "Suku Bunga atau Kupon, Tingkat Suku Bunga/Nisbah atau Kupon", sv(M, 1, 6, numericDot))
        .addFieldValidations(ER5808INVSB.genFieldValidation17()));
    fs.add(sf(17, null, "Suku Bunga atau Kupon, Jenis Suku Bunga atau Kupon", sv(M, 1, 10, all)
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(18, null, "Unit Penyertaan", sv(C, 1, 20, numeric)
        .confConditionalRequired(ER5808INVSB.genConditionalBagianPenyertaan())));
    fs.add(sf(19, null, "Nilai Aktiva Bersih (NAB) atau Harga Saham / Nilai Nominal", sv(C, 1, 20, numeric)
        .confConditionalRequired(ER5808INVSB.genConditionalBagianPenyertaan())));
    fs.add(sf(20, null, "Nilai Perolehan/Harga Perolehan", sv(C, 1, 20, numeric)
        .confConditionalRequired(ER5808INVSB.genConditionalBagianPenyertaan())));
    fs.add(sf(21, null, "Nilai Wajar/Harga Pasar", sv(C, 1, 20, numeric)
        .confConditionalRequired(ER5808INVSB.genConditionalBagianPenyertaan())));
    fs.add(sf(22, null, "Selisih Penilaian Investasi", sv(C, 1, 20, numeric)
        .confConditionalRequired(ER5808INVSB.genConditionalBagianPenyertaan()))
        .addFieldValidations(ER5808INVSB.genFieldValidation23()));
    fs.add(sf(23, null, "Hasil Investasi", sv(M, 1, 20, numeric)));

    //TODO: Yahya - Kolom 25 s/d 29 di templatenya = C tapi tidak ada kondisinya.
    fs.add(sf(24, null, "Saldo Amortisasi, Premium", sv(O, 1, 20, numeric)));
    fs.add(sf(25, null, "Saldo Amortisasi, Diskonto", sv(O, 1, 20, numeric)));
    fs.add(sf(26, null, "Saldo Amortisasi, Biaya Trans", sv(O, 1, 20, numeric)));
    fs.add(sf(27, null, "Saldo Amortisasi, Acc. Interest", sv(O, 1, 20, numeric)));
    fs.add(sf(28, null, "CKPN", sv(O, 1, 20, numeric)));
    fs.add(sf(29, null, "Hirarki Harga Pasar", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.HIRARKI_HARGA_PASAR.getObject())
        .confRegex(PATTERN_REFERENCE_1)));

    fs.add(sf(30, null, "Bagian Penyertaan", sv(C, 1, 6, numericDot)
        .confConditionalRequired(ER5808INVSB.genConditionalBagianPenyertaan())));
    fs.add(sf(31, null, "Saldo", sv(M, 1, 20, numeric)));
    return res;
  }
}
