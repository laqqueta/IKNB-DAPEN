package id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata;

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

import id.go.ojk.bptk.client.builder.field.EFormLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.EHeaderMetadataLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.ER5310INVSB;
import id.go.ojk.bptk.client.builder.field.lbbptkjkm.metadata.MetadataLbbptkjkm;
import id.go.ojk.bptk.client.builder.field.ltbptk.metadata.MetadataLtbptkjkm;
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
    EFormLbbptkbdn eEnum = EFormLbbptkbdn.INVSB;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 0, null);
    
    String labelSyariahKonven = "Syariah/Konvensional";
    if(reportCode.equalsIgnoreCase(MetadataLbbptkjkm.REPORT_CODE) ||
        reportCode.equalsIgnoreCase(MetadataLtbptkjkm.REPORT_CODE)) {
      labelSyariahKonven = "Syariah/Non Syariah";
    }

    res.setSavePos(ER5310INVSB.genFieldSave());

    /* -- ANTAR FORM -- */
//    res.addSegmentValidations(ER5310INVSB.genRowValidation31(reportCode)); // uat #50: lepas validasi saldo

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 15, 15, refTable)
        .confReference(EHeaderMetadataLbbptkbdn.R5310INVSB.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Jenis Surat Berharga dan Penyertaan Langsung", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.JENIS_SURAT_BERHARGA.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(3, null, "Nama Surat Berharga", sv(M, 1, 100, all)));
    fs.add(sf(4, null, "Nama Penerbit/Nama Manajer Investasi", sv(M, 1, 100, all)));
    fs.add(sf(5, null, "Nomor Seri", sv(M, 1, 100, alfaNumeric)));
    fs.add(sf(6, null, "Kode Penerbit", sv(M, 1, 20, alfaNumeric)));

    //TODO: Yahya - Kolom 7 s/d 9 di templatenya = C tapi tidak ada kondisinya.
    fs.add(sf(7, null, "Golongan Penerbit", sv(O, 1, 10, all).confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(8, null, "Peringkat", sv(O, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.PERINGKAT_SURAT_BERHARGA.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(9, null, "Lembaga Pemeringkat", sv(O, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.LEMBAGA_PEMERINGKAT.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(10, null, "Jangka Waktu, Tanggal Mulai/Tanggal Penerbitan", sv(M, 8, 8, date))
        .addFieldValidations(ER5310INVSB.genFieldValidation11()));
    fs.add(sf(11, null, "Jangka Waktu, Tanggal Jatuh Tempo", sv(M, 8, 8, date))
        .addFieldValidations(ER5310INVSB.genFieldValidation12()));
    fs.add(sf(12, null, "Sektor Ekonomi", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.SEKTOR_EKONOMI.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5310INVSB.genConditionalBagianPenyertaan())));
    fs.add(sf(13, null, "Lokasi", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.LOKASI_DATI_2.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5310INVSB.genConditionalBagianPenyertaan())));
    fs.add(sf(14, null, "Tujuan Pemilikan", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.TUJUAN_KEPEMILIKAN.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5310INVSB.genConditionalBagianPenyertaan())));
    fs.add(sf(15, null, labelSyariahKonven, sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.SYARIAH_KONVENSIONAL.getObject())
        .confRegex(PATTERN_REFERENCE_1)));
    fs.add(sf(16, null, "Suku Bunga atau Kupon, Tingkat Suku Bunga/Nisbah atau Kupon", sv(M, 1, 6, numericDot))
        .addFieldValidations(ER5310INVSB.genFieldValidation17()));
    fs.add(sf(17, null, "Unit Penyertaan", sv(C, 1, 20, numeric)
        .confConditionalRequired(ER5310INVSB.genConditionalExist18())));
    fs.add(sf(18, null, "Nilai Aktiva Bersih (NAB) atau Harga Saham / Nilai Nominal", sv(C, 1, 20, numeric)
        .confConditionalRequired(ER5310INVSB.genConditionalExist18())));
    fs.add(sf(19, null, "Nilai Perolehan/Harga Perolehan", sv(C, 1, 20, numeric)
        .confConditionalRequired(ER5310INVSB.genConditionalBagianPenyertaan())));
    fs.add(sf(20, null, "Nilai Wajar/Harga Pasar", sv(C, 1, 20, numeric)
        .confConditionalRequired(ER5310INVSB.genConditionalBagianPenyertaan())));
    fs.add(sf(21, null, "Selisih Penilaian Investasi", sv(C, 1, 20, numeric)
        .confConditionalRequired(ER5310INVSB.genConditionalBagianPenyertaan()))
        .addFieldValidations(ER5310INVSB.genFieldValidation22()));
    fs.add(sf(22, null, "Hasil Investasi", sv(C, 1, 20, numeric)
        .confConditionalRequired(ER5310INVSB.genConditionalBagianPenyertaan())));

    //TODO: Yahya - Kolom 24 s/d 27 di templatenya = C tapi tidak ada kondisinya.
    fs.add(sf(23, null, "Saldo Amortisasi, Premium", sv(O, 1, 20, numeric)));
    fs.add(sf(24, null, "Saldo Amortisasi, Diskonto", sv(O, 1, 20, numeric)));
    fs.add(sf(25, null, "Saldo Amortisasi, Biaya Trans", sv(O, 1, 20, numeric)));
    fs.add(sf(26, null, "Saldo Amortisasi, Acc. Interest", sv(O, 1, 20, numeric)));
    fs.add(sf(27, null, "CKPN", sv(O, 1, 20, numeric)));
    fs.add(sf(28, null, "Hirarki Harga Pasar", sv(M, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.HIRARKI_HARGA_PASAR.getObject())
        .confRegex(PATTERN_REFERENCE_1)));

    fs.add(sf(29, null, "Bagian Penyertaan", sv(C, 1, 6, numericDot)
        .confConditionalRequired(ER5310INVSB.genConditionalBagianPenyertaan())));
    fs.add(sf(30, null, "Saldo", sv(M, 1, 20, numeric)));
    return res;
  }
}
