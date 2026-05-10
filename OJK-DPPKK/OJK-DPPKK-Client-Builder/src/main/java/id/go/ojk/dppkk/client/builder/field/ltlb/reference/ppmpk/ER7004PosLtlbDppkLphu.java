package id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1255JenisManfaat;
import id.go.ojk.conf.client.field.reference.ER1263BebanInvestasi;
import id.go.ojk.conf.client.field.reference.ER1264BebanOperasinal;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7004PosLtlbDppkLphu implements IObject<KeyValueString> {

    R_LPHU0101000000("LPHU0101000000", "Bunga/Bagi Hasil"),
    R_LPHU0102000000("LPHU0102000000", "Dividen"),
    R_LPHU0103000000("LPHU0103000000", "Sewa"),
    R_LPHU0104000000("LPHU0104000000", "Laba (Rugi) Pelepasan Investasi"),
    R_LPHU0105000000("LPHU0105000000", "Pendapatan Investasi Lain"),
    R_LPHU0106000000("LPHU0106000000", "Total Pendapatan Investasi"),
    R_LPHU0201000000("LPHU0201000000", "Beban Transaksi"),
    R_LPHU0202000000("LPHU0202000000", "Beban Pemeliharaan Tanah dan Bangunan"),
    R_LPHU0203000000("LPHU0203000000", "Beban Penyusutan Bangunan"),
    R_LPHU0204000000("LPHU0204000000", "Beban Manajer Investasi"),
    R_LPHU0205000000("LPHU0205000000", "Beban Kustodi"),
    R_LPHU0206000000("LPHU0206000000", "Beban Investasi Lain"),
    R_LPHU0300000000("LPHU0300000000", "Total Beban Investasi"),
    R_LPHU0400000000("LPHU0400000000", "HASIL USAHA INVESTASI"),
    R_LPHU0501000000("LPHU0501000000", "Gaji/Honor Karyawan, Pengurus, dan Dewan Pengawas"),
    R_LPHU0502000000("LPHU0502000000", "Beban Kantor"),
    R_LPHU0503000000("LPHU0503000000", "Beban Pemeliharaan"),
    R_LPHU0504000000("LPHU0504000000", "Beban Penyusutan"),
    R_LPHU0505000000("LPHU0505000000", "Beban Jasa Pihak Ketiga"),
    R_LPHU0506000000("LPHU0506000000", "Beban Pendidikan dan Pelatihan"),
    R_LPHU0507000000("LPHU0507000000", "Beban Operasional Lain"),
    R_LPHU0508000000("LPHU0508000000", "Total Beban Operasional"),
    R_LPHU0601000000("LPHU0601000000", "Bunga Keterlambatan Iuran"),
    R_LPHU0602000000("LPHU0602000000", "Laba (Rugi) Penjualan Aset Operasional"),
    R_LPHU0603000000("LPHU0603000000", "Laba (Rugi) Penjualan Aset Lain-Lain"),
    R_LPHU0604000000("LPHU0604000000", "Pendapatan Lain di Luar Investasi"),
    R_LPHU0605000000("LPHU0605000000", "Beban Lain di Luar Investasi dan Operasional"),
    R_LPHU0606000000("LPHU0606000000", "Total Pendapatan dan Beban Lain-Lain"),
    R_LPHU0700000000("LPHU0700000000", "HASIL USAHA SEBELUM PAJAK"),
    R_LPHU0800000000("LPHU0800000000", "PAJAK PENGHASILAN"),
    R_LPHU0900000000("LPHU0900000000", "HASIL USAHA SETELAH PAJAK"),

    ;

    private final String key;
    private final String value;

    public KeyValueString getObject() {
        return new KeyValueString(key, value, new String[]{});
    }

    public static List<KeyValueString> getObjects() {
        List<KeyValueString> res = new ArrayList<>();
        for (ER7004PosLtlbDppkLphu eEnum : ER7004PosLtlbDppkLphu.values()) {
            res.add(eEnum.getObject());
        }
        return res;
    }

    public static String getName() {
        return ER7004PosLtlbDppkLphu.class.getSimpleName().substring(6);
    }

    public static int getRefNumber() {
        return Integer.parseInt(ER7004PosLtlbDppkLphu.class.getSimpleName().substring(2, 6));
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
            genValidationSegment6(),
            genValidationSegment7(),

            genRowValidation8A(),
            genRowValidation8B(),
            genRowValidation8C(),
            genRowValidation8D(),
            genRowValidation8E(),

            genValidationSumIfFormBinv(),
            genValidationSumIfFormBopr(),
            genValidationSumIfFormPdin(),
            genValidationSumIfFormBipr(),
            genValidationSumIfFormPph()
    );


    private static SegmentValidation genValidationSumIfFormBinv() {
        return genValidationSumIfMultiCriteria(UtilMetadata.genPipeRow(getObjects(), 6, 7),
                EFormLaporanTahunanLaporanBulanan.LTLB_BINV.getCode(), ER7064PosLtlbDppkBinv.R_BINV010000.getObject().getKey(),
                ER1263BebanInvestasi.getPipedReferenceKeys(), ER1263BebanInvestasi.getPipedReferenceKeyValues(),
                "BINV|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Beban Investasi");
    }

    private static SegmentValidation genValidationSumIfFormBopr() {
        return genValidationSumIfMultiCriteria(UtilMetadata.genPipeRow(getObjects(), 14, 20),
                EFormLaporanTahunanLaporanBulanan.LTLB_BOPR.getCode(), ER7065PosLtlbDppkBopr.R_BOPR010000.getObject().getKey(),
                ER1264BebanOperasinal.getPipedReferenceKeys(), ER1264BebanOperasinal.getPipedReferenceKeyValues(),
                "BOPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Beban Operasional");
    }

    private static SegmentValidation genValidationSumIfFormPdin() {
        return genValidationSumIf(R_LPHU0604000000.key,
                EFormLaporanTahunanLaporanBulanan.LTLB_PDIN.getCode(), ER7062PosLtlbDppkPdin.R_PDIN010000.getObject().getKey(),
                "PDIN|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain");
    }

    private static SegmentValidation genValidationSumIfFormBipr() {
        return genValidationSumIf(R_LPHU0605000000.key,
                EFormLaporanTahunanLaporanBulanan.LTLB_BIPR.getCode(), ER7066PosLtlbDppkBipr.R_BIPR010000.getObject().getKey(),
                "BIPR|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain");
    }

    private static SegmentValidation genValidationSumIfFormPph() {
        return genValidationSumIf(R_LPHU0800000000.key,
                EFormLaporanTahunanLaporanBulanan.LTLB_PPH.getCode(), ER7067PosLtlbDppkPph.R_PPH010000.getObject().getKey(),
                "PPH|Jumlah|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain");
    }

    private static SegmentValidation genValidationSegment1() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPHU0106000000.key, UtilMetadata.genPlusRow(getObjects(), 0, 4),
                UtilMetadata.genMessage(R_LPHU0106000000.value, UtilMetadata.genPlusDesc(getObjects(), 0, 4)));
    }

    private static SegmentValidation genValidationSegment2() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPHU0300000000.key, UtilMetadata.genPlusRow(getObjects(), 6, 11),
                UtilMetadata.genMessage(R_LPHU0300000000.value, UtilMetadata.genPlusDesc(getObjects(), 6, 11)));
    }

    private static SegmentValidation genValidationSegment3() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPHU0400000000.key, UtilMetadata.genMinusRow(getObjects(), new int[]{5, 12}),
                UtilMetadata.genMessage(R_LPHU0400000000.value, UtilMetadata.genMinusDesc(getObjects(), new int[]{5, 12})));
    }

    private static SegmentValidation genValidationSegment4() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPHU0508000000.key, UtilMetadata.genPlusRow(getObjects(), 14, 20),
                UtilMetadata.genMessage(R_LPHU0508000000.value, UtilMetadata.genPlusDesc(getObjects(), 14, 20)));
    }

    private static SegmentValidation genValidationSegment5() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPHU0606000000.key, UtilMetadata.genPlusRow(getObjects(), 22, 25) + "-LPHU0605000000",
                UtilMetadata.genMessage(R_LPHU0606000000.value, UtilMetadata.genPlusDesc(getObjects(), 22, 25) + "-LPHU0605000000"));
    }

    private static SegmentValidation genValidationSegment6() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPHU0700000000.key, UtilMetadata.genDelimitedRowArr(getObjects(), new int[]{13, 21, 27}, "-|+"),
                UtilMetadata.genMessage(R_LPHU0700000000.value, UtilMetadata.genDelimitedDescArr(getObjects(), new int[]{13, 21, 27}, "-|+")));
    }

    private static SegmentValidation genValidationSegment7() {
        return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LPHU0900000000.key, UtilMetadata.genMinusRow(getObjects(), new int[]{28, 29}),
                UtilMetadata.genMessage(R_LPHU0900000000.value, UtilMetadata.genMinusDesc(getObjects(), new int[]{28, 29})));
    }

    public static SegmentValidation genRowValidation8A() {
        return genRowValidation(R_LPHU0101000000.key, "2");
    }

    public static SegmentValidation genRowValidation8B() {
        return genRowValidation(R_LPHU0102000000.key, "3");
    }

    public static SegmentValidation genRowValidation8C() {
        return genRowValidation(R_LPHU0103000000.key, "4");
    }

    public static SegmentValidation genRowValidation8D() {
        return genRowValidation(R_LPHU0104000000.key, "5");
    }

    public static SegmentValidation genRowValidation8E() {
        return genRowValidation(R_LPHU0105000000.key, "6");
    }

    private static SegmentValidation genRowValidation(String posCode, String comparatorField) {
        return UtilSegmentValidation.genEqualsForm("2", posCode,
                EFormLaporanTahunanLaporanBulanan.LTLB_ROI.getCode(), comparatorField,
                ER7009PosLtlbDppkRoi.R_ROI2100000000.getObject().getKey());
    }

    private static SegmentValidation genValidationSumIf(String row, String comparatorForm, String comparatorRow, String errMsg) {
        String sumField = "2";
        String rangeField = "3";
        String criteriaField = "4";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3|ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3|ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidation.genSumIf(UtilMetadata.genPipeColumn(2, 11), row,
                comparatorForm, comparatorRow,
                rangeField, criteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                errMsg, criteriaConditionErr, sumCriteriaConditionErr);
    }

    private static SegmentValidation genValidationSumIfMultiCriteria(String row, String formComparator, String comparatorRow, String additionalCriteria, String additionalCriteriaErr, String errMsg) {
        String sumField = "2";
        String comparatorRangeField = "3";
        String comparatorCriteriaField = "4|2";
        String criteriaKey = "0";
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3|ML1|ML2|ML3|ML4|ML5|ML6") + "$" + additionalCriteria;
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3|ML1|ML2|ML3|ML4|ML5|ML6") + "$" + additionalCriteriaErr;
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");

        return UtilSegmentValidation.genMultiCriteriaSumIf(UtilMetadata.genPipeColumn(2, 11), row,
                formComparator, comparatorRow,
                comparatorRangeField, comparatorCriteriaField, sumField, criteriaCondition, sumCriteriaCondition,
                errMsg, criteriaConditionErr, sumCriteriaConditionErr, criteriaKey);
    }

    public static FieldValidation genFieldValidation1() {
        return UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(2, 11),
                UtilMetadata.genPipeRow(getObjects(), new int[]{5, 12, 13, 21, 27, 28, 30}), 2);
    }

}
