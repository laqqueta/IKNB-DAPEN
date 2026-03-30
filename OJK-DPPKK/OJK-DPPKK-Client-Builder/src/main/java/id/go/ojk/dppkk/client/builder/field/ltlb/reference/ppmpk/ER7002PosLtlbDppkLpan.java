package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1255JenisManfaat;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7002PosLtlbDppkLpan implements IObject<KeyValueString> {

    R_LPAN0101010000("LPAN0101010000", "Bunga/Bagi Hasil"),
    R_LPAN0101020000("LPAN0101020000", "Dividen"),
    R_LPAN0101030000("LPAN0101030000", "Sewa"),
    R_LPAN0101040000("LPAN0101040000", "Laba (Rugi) Pelepasan Investasi"),
    R_LPAN0101050000("LPAN0101050000", "Pendapatan Investasi Lain"),
    R_LPAN0102000000("LPAN0102000000", "Total Pendapatan Investasi"),
    R_LPAN0103000000("LPAN0103000000", "Peningkatan (Penurunan) Nilai Investasi"),
    R_LPAN0104010000("LPAN0104010000", "- Iuran Normal Pemberi Kerja"),
    R_LPAN0104020000("LPAN0104020000", "- Iuran Normal Peserta"),
    R_LPAN0104030000("LPAN0104030000", "- Iuran Sukarela Peserta"),
    R_LPAN0104040000("LPAN0104040000", "- Iuran Tambahan"),
    R_LPAN0105000000("LPAN0105000000", "Pendapatan di Luar Investasi"),
    R_LPAN0106000000("LPAN0106000000", "Pengalihan Dana dari Dana Pensiun Lain"),
    R_LPAN0107000000("LPAN0107000000", "Jumlah Penambahan"),
    R_LPAN0201000000("LPAN0201000000", "Beban Investasi"),
    R_LPAN0202000000("LPAN0202000000", "Beban Operasional"),
    R_LPAN0203000000("LPAN0203000000", "Beban di Luar Investasi dan Operasional"),
    R_LPAN0204000000("LPAN0204000000", "Manfaat Pensiun dan Manfaat Lain"),
    R_LPAN0205000000("LPAN0205000000", "Pajak Penghasilan"),
    R_LPAN0206000000("LPAN0206000000", "Pengalihan Dana ke Dana Pensiun Lain"),
    R_LPAN0207000000("LPAN0207000000", "Pengalihan Dana ke Balai Harta Peninggalan"),
    R_LPAN0208000000("LPAN0208000000", "Jumlah Pengurangan"),
    R_LPAN0300000000("LPAN0300000000", "KENAIKAN (PENURUNAN) ASET NETO"),
    R_LPAN0400000000("LPAN0400000000", "ASET NETO AWAL PERIODE"),
    R_LPAN0500000000("LPAN0500000000", "ASET NETO AKHIR PERIODE");

    private final String key;
    private final String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[] {});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7002PosLtlbDppkLpan eEnum : ER7002PosLtlbDppkLpan.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7002PosLtlbDppkLpan.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7002PosLtlbDppkLpan.class.getSimpleName().substring(2, 6));
    }

    public static String genFieldSave() {
        return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 12), getObjects());
    }

    public static String getRequiredPos() {
        return UtilMetadata.genPipeRow(getObjects());
    }

    public static final List<SegmentValidation> SEGMENT_VALIDATIONS = Arrays.asList(
            genValidationSegment1(),
            genValidationSegment2(),
            genValidationSegment3(),
            genValidationSegment4(),
            genValidationSegment5(),

            genRowValidation6A(),
            genRowValidation6B(),
            genRowValidation6C(),
            genRowValidation6D(),
            genRowValidation6E(),

            genValidationSumIfFormPpin(),
            genValidationSumIfFormIur(),
            genValidationSumIfFormBinv(),
            genValidationSumIfFormBopr(),
            genValidationSumIfFormPdin(),
            genValidationSumIfFormBipr(),
            genValidationSumIfFormPph(),
            genValidationSumIfFormPkpl(),
            genValidationSumIfFormPdpl()
    );

    private static SegmentValidation genValidationSumIfFormPpin() {
        return genSumIfValidation(R_LPAN0103000000.key, "4", "5",
                EFormLaporanTahunanLaporanBulanan.LTLB_PPIN.getCode(), ER7060PosLtlbDppkPpin.R_PPIN010000.getObject().getKey(),
                "PPIN|Peningkatan/Penurunan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain");
    }

    private static SegmentValidation genValidationSumIfFormIur() {
        return genSumIfValidation(UtilMetadata.genPipeRow(getObjects(), 7, 10), "6|5|7|8", "17",
                EFormLaporanTahunanLaporanBulanan.LTLB_IUR.getCode(), ER7061PosLtlbDppkIur.R_IUR010000.getObject().getKey(),
                "IUR|Iuran Jatuh Tempo - Iuran Normal Pemberi Kerja Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain");
    }

    private static SegmentValidation genValidationSumIfFormPdin() {
        return genSumIfValidation(R_LPAN0105000000.key, "3", "4",
                EFormLaporanTahunanLaporanBulanan.LTLB_PDIN.getCode(), ER7062PosLtlbDppkPdin.R_PDIN010000.getObject().getKey(),
                "PDIN|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain");
    }

    private static SegmentValidation genValidationSumIfFormPdpl() {
        return genSumIfValidation(R_LPAN0106000000.key, "3", "4",
                EFormLaporanTahunanLaporanBulanan.LTLB_PDPL.getCode(), ER7063PosLtlbDppkPdpl.R_PDPL010000.getObject().getKey(),
                "PDPL|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain");
    }

    private static SegmentValidation genValidationSumIfFormBinv() {
        return genSumIfValidation(R_LPAN0201000000.key, "3", "4",
                EFormLaporanTahunanLaporanBulanan.LTLB_BINV.getCode(), ER7064PosLtlbDppkBinv.R_BINV010000.getObject().getKey(),
                "BINV|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain");
    }

    private static SegmentValidation genValidationSumIfFormBopr() {
        return genSumIfValidation(R_LPAN0202000000.key, "3", "4",
                EFormLaporanTahunanLaporanBulanan.LTLB_BOPR.getCode(), ER7065PosLtlbDppkBopr.R_BOPR010000.getObject().getKey(),
                "BOPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain");
    }

    private static SegmentValidation genValidationSumIfFormBipr() {
        return genSumIfValidation(R_LPAN0203000000.key, "3", "4",
                EFormLaporanTahunanLaporanBulanan.LTLB_BIPR.getCode(), ER7066PosLtlbDppkBipr.R_BIPR010000.getObject().getKey(),
                "BIPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain");
    }

    private static SegmentValidation genValidationSumIfFormPph() {
        return genSumIfValidation(R_LPAN0205000000.key, "3", "4",
                EFormLaporanTahunanLaporanBulanan.LTLB_PPH.getCode(), ER7067PosLtlbDppkPph.R_PPH010000.getObject().getKey(),
                "PPH|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain");
    }

    private static SegmentValidation genValidationSumIfFormPkpl() {
        return genSumIfValidation(R_LPAN0206000000.key, "3", "4",
                EFormLaporanTahunanLaporanBulanan.LTLB_PKPL.getCode(), ER7068PosLtlbDppkPkpl.R_PKPL010000.getObject().getKey(),
                "PKPL|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain");
    }

    private static SegmentValidation genSumIfValidation(String posCode, String rangeField, String criteriaField, String formCode,
                                                        String formObjects, String errMsg) {
        String sumField = "2";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidation.genSumIf(UtilMetadata.genPipeColumn(2, 11), posCode,
                formCode, formObjects,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }

    private static SegmentValidation genValidationSegment1() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPAN0102000000.key, UtilMetadata.genPlusRow(getObjects(), 0, 4),
                UtilMetadata.genMessage(R_LPAN0102000000.value, UtilMetadata.genPlusDesc(getObjects(), 0, 4)));
    }

    private static SegmentValidation genValidationSegment2() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPAN0107000000.key, UtilMetadata.genPlusRow(getObjects(), 6, 12),
                UtilMetadata.genMessage(R_LPAN0107000000.value, UtilMetadata.genPlusDesc(getObjects(), 6, 12)));
    }

    private static SegmentValidation genValidationSegment3() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPAN0208000000.key, UtilMetadata.genPlusRow(getObjects(), 14, 20),
                UtilMetadata.genMessage(R_LPAN0208000000.value, UtilMetadata.genPlusDesc(getObjects(), 14, 20)));
    }

    private static SegmentValidation genValidationSegment4() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPAN0300000000.key, UtilMetadata.genPlusRow(getObjects(), new int[] { 5, 13 }) + "-LPAN0208000000",
                UtilMetadata.genMessage(R_LPAN0300000000.value, UtilMetadata.genPlusDesc(getObjects(), new int[] { 5, 13 }) + "-LPAN0208000000"));
    }

    private static SegmentValidation genValidationSegment5() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPAN0500000000.key, UtilMetadata.genMinusRow(getObjects(), new int[] { 23, 22 }),
                UtilMetadata.genMessage(R_LPAN0500000000.value, UtilMetadata.genMinusDesc(getObjects(), new int[] { 23, 22 })));
    }

    public static SegmentValidation genRowValidation6A() {
        return genRowValidation(R_LPAN0101010000.key, "2");
    }

    public static SegmentValidation genRowValidation6B() {
        return genRowValidation(R_LPAN0101020000.key, "3");
    }

    public static SegmentValidation genRowValidation6C() {
        return genRowValidation(R_LPAN0101030000.key, "4");
    }

    public static SegmentValidation genRowValidation6D() {
        return genRowValidation(R_LPAN0101040000.key, "5");
    }

    public static SegmentValidation genRowValidation6E() {
        return genRowValidation(R_LPAN0101050000.key, "6");
    }

    private static SegmentValidation genRowValidation(String posCode, String comparatorField) {
        return UtilSegmentValidation.genEqualsForm("2", posCode,
                EFormLaporanTahunanLaporanBulanan.LTLB_ROI.getCode(), comparatorField,
                ER7009PosLtlbDppkRoi.R_ROI2100000000.getObject().getKey());
    }

    public static FieldValidation genFieldValidation1() {
        return UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(2, 11),
                UtilMetadata.genPipeRow(getObjects(), new int[]{5, 13, 22, 24}), 2);
    }
}
