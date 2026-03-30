package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7012PosLtlbDppkAlm implements IObject<KeyValueString> {

    R_ALM0101000000("ALM0101000000", "Deposito on call pada Bank"),
    R_ALM0102000000("ALM0102000000", "Deposito berjangka pada Bank"),
    R_ALM0103000000("ALM0103000000", "Sertifikat deposito pada Bank"),
    R_ALM0104000000("ALM0104000000", "Surat berharga yang diterbitkan oleh Bank Indonesia"),
    R_ALM0105000000("ALM0105000000", "Surat Berharga Negara"),
    R_ALM0106000000("ALM0106000000", "Saham yang tercatat di Bursa Efek di Indonesia"),
    R_ALM0107000000("ALM0107000000", "Obligasi korporasi yang tercatat di Bursa Efek di Indonesia"),
    R_ALM0108000000("ALM0108000000", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
    R_ALM0109000000("ALM0109000000", "Obligasi/Sukuk Daerah"),
    R_ALM0110000000("ALM0110000000", "Reksa Dana"),
    R_ALM0111000000("ALM0111000000", "MTN"),
    R_ALM0112000000("ALM0112000000", "Efek beragun aset"),
    R_ALM0113000000("ALM0113000000", "Dana investasi real estat berbentuk kontrak investasi kolektif"),
    R_ALM0114000000("ALM0114000000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
    R_ALM0115000000("ALM0115000000", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia"),
    R_ALM0116000000("ALM0116000000", "REPO"),
    R_ALM0117000000("ALM0117000000", "Penyertaan Langsung di Indonesia"),
    R_ALM0118000000("ALM0118000000", "Tanah di Indonesia"),
    R_ALM0119000000("ALM0119000000", "Bangunan di Indonesia"),
    R_ALM0120000000("ALM0120000000", "Tanah dan Bangunan di Indonesia"),
    R_ALM0121000000("ALM0121000000", "Total Investasi"),
    R_ALM0201000000("ALM0201000000", "Kas & Bank"),
    R_ALM0202000000("ALM0202000000", "Piutang Iuran"),
    R_ALM0203000000("ALM0203000000", "Iuran Normal Pemberi Kerja"),
    R_ALM0204000000("ALM0204000000", "Iuran Normal Peserta"),
    R_ALM0205000000("ALM0205000000", "Iuran Sukarela Peserta"),
    R_ALM0206000000("ALM0206000000", "Piutang Bunga Keterlambatan Iuran"),
    R_ALM0207000000("ALM0207000000", "Beban Dibayar di Muka"),
    R_ALM0208000000("ALM0208000000", "Piutang Investasi"),
    R_ALM0209000000("ALM0209000000", "Piutang Hasil Investasi"),
    R_ALM0210000000("ALM0210000000", "Piutang Lain-Lain"),
    R_ALM0211000000("ALM0211000000", "Total Aset Lancar di Luar Investasi"),
    R_ALM0301000000("ALM0301000000", "Tanah dan Bangunan"),
    R_ALM0302000000("ALM0302000000", "Kendaraan"),
    R_ALM0303000000("ALM0303000000", "Peralatan Komputer"),
    R_ALM0304000000("ALM0304000000", "Peralatan Kantor"),
    R_ALM0305000000("ALM0305000000", "Aset Operasional Lain"),
    R_ALM0306000000("ALM0306000000", "Total Aset Operasional"),
    R_ALM0400000000("ALM0400000000", "D. Aset  Lain-Lain"),
    R_ALM0500000000("ALM0500000000", "E. Total Aset  (A+B+C+D)"),
    R_ALM0600000000("ALM0600000000", "F. Nilai Kini Aktuarial"),
    R_ALM0701000000("ALM0701000000", "Utang Manfaat Pensiun dan Manfaat Lain Jatuh Tempo"),
    R_ALM0702000000("ALM0702000000", "Utang Manfaat Sukarela"),
    R_ALM0703000000("ALM0703000000", "Utang Investasi"),
    R_ALM0704000000("ALM0704000000", "Pendapatan Diterima di Muka"),
    R_ALM0705000000("ALM0705000000", "Beban yang Masih Harus Dibayar"),
    R_ALM0706000000("ALM0706000000", "Utang Lain-Lain"),
    R_ALM0707000000("ALM0707000000", "Utang Dana Ta'zir (bagi syariah)"),
    R_ALM0708000000("ALM0708000000", "Total Liabilitas Diluar Liabilitas Manfaat Pensiun"),
    R_ALM0800000000("ALM0800000000", "H. Total Liabilitas (F+G)"),
    R_ALM0900000000("ALM0900000000", "I. Selisih Total Aset dan Total Liabilitas  (E-H)"),
    R_ALM1000000000("ALM1000000000", "J. Persentase (%) Rasio Kecukupan Dana");

    private String key;
    private String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7012PosLtlbDppkAlm eEnum : ER7012PosLtlbDppkAlm.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7012PosLtlbDppkAlm.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7012PosLtlbDppkAlm.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 16), getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects());
    }

    private static final String pipeColumnValidation = UtilMetadata.genPipeColumn(2, 16);

    // Sum block of column

    public static SegmentValidation genValidationSumPosColEqual1() {
        return UtilSegmentValidation.genEqualsFormula(pipeColumnValidation, R_ALM0121000000.key, UtilMetadata.genPlusRow(getObjects(), 0, 19),
                UtilMetadata.genMessage(R_ALM0121000000.value, UtilMetadata.genPlusDesc(getObjects(), 0, 19)));
    }

    public static SegmentValidation genValidationSumPosColEqual2() {
        return UtilSegmentValidation.genEqualsFormula(pipeColumnValidation, R_ALM0211000000.key, UtilMetadata.genPlusRow(getObjects(), 21, 30),
                UtilMetadata.genMessage(R_ALM0211000000.value, UtilMetadata.genPlusDesc(getObjects(), 21, 30)));
    }

    public static SegmentValidation genValidationSumPosColEqual3() {
        return UtilSegmentValidation.genEqualsFormula(pipeColumnValidation, R_ALM0306000000.key, UtilMetadata.genPlusRow(getObjects(), 32, 36),
                UtilMetadata.genMessage(R_ALM0306000000.value, UtilMetadata.genPlusDesc(getObjects(), 32, 36)));
    }

    public static SegmentValidation genValidationSumPosColEqual4() {
        return UtilSegmentValidation.genEqualsFormula(pipeColumnValidation, R_ALM0708000000.key, UtilMetadata.genPlusRow(getObjects(), 41, 47),
                UtilMetadata.genMessage(R_ALM0708000000.value, UtilMetadata.genPlusDesc(getObjects(), 41, 47)));
    }

    // Sum of specific column

    public static SegmentValidation genValidationSumPosColEqual5() {
        return UtilSegmentValidation.genEqualsFormula("16", R_ALM0500000000.key, UtilMetadata.genPlusRow(getObjects(), new int[] { 20, 31, 37, 38 }),
                UtilMetadata.genMessage(R_ALM0500000000.value, UtilMetadata.genPlusDesc(getObjects(), new int[] { 20, 31, 37, 38 })));
    }

    public static SegmentValidation genValidationSumPosColEqual6() {
        return UtilSegmentValidation.genEqualsFormula("16", R_ALM0800000000.key, UtilMetadata.genPlusRow(getObjects(), new int[] { 40, 48 }),
                UtilMetadata.genMessage(R_ALM0800000000.value, UtilMetadata.genPlusDesc(getObjects(), new int[] { 40, 48 })));
    }

    public static SegmentValidation genValidationSumPosColEqual7() {
        return UtilSegmentValidation.genEqualsFormula("16", R_ALM0900000000.key, UtilMetadata.genMinusRow(getObjects(), new int[] { 39, 49 }),
                UtilMetadata.genMessage(R_ALM0900000000.value, UtilMetadata.genMinusDesc(getObjects(), new int[] { 39, 49 })));
    }

    // field validation

    public static FieldValidation genFieldTotal1Validation() {
        return UtilFieldValidation.genEqualsExceptPosFormula("2+5+8+11", UtilMetadata.genPipeRow(getObjects(), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }));
    }

    public static FieldValidation genFieldTotal2Validation() {
        return UtilFieldValidation.genEqualsExceptPosFormula("3+6+9+12", UtilMetadata.genPipeRow(getObjects(), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }));
    }

    public static FieldValidation genFieldTotal3Validation() {
        return UtilFieldValidation.genEqualsExceptPosFormula("14+15", UtilMetadata.genPipeRow(getObjects(), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }));
    }

    public static FieldValidation genFieldJtdValidation() {
        return UtilFieldValidation.genEqualsExceptPosFormula("11+12", UtilMetadata.genPipeRow(getObjects(), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }));
    }

    public static FieldValidation genFieldJtcValidation() {
        return UtilFieldValidation.genEqualsExceptPosFormula("8+9", UtilMetadata.genPipeRow(getObjects(), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }));
    }

    public static FieldValidation genFieldJtbValidation() {
        return UtilFieldValidation.genEqualsExceptPosFormula("5+6", UtilMetadata.genPipeRow(getObjects(), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }));
    }

    public static FieldValidation genFieldJtaValidation() {
        return UtilFieldValidation.genEqualsExceptPosFormula("2+3", UtilMetadata.genPipeRow(getObjects(), new int[] { 20, 31, 37, 38, 39, 40, 48, 49, 50, 51 }));
    }

    public static ConditionalRequired genConditionForPersentase() {
        return UtilFieldConditional.genExistPos("N", "M", R_ALM1000000000.key);
    }
}
