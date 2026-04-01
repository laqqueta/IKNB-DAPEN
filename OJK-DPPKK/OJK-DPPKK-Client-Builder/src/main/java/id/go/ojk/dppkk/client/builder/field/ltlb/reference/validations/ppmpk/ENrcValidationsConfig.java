package id.go.ojk.dppkk.client.builder.field.ltlb.reference.validations.ppmpk;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1250Properti;
import id.go.ojk.conf.client.field.reference.ER1255JenisManfaat;
import id.go.ojk.dppkk.client.builder.constant.JenisProgram;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.function.Supplier;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ENrcValidationsConfig {

    SG_SUMIF_DOC(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0101010000.getObject().getKey(), "6", "9",
            EFormLaporanTahunanLaporanBulanan.LTLB_DOC.getCode(),
            ER7022PosLtlbDppkDoc.R_DOC010000.getObject().getKey(),
            "DOC|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
    ), () -> null),

    SG_SUMIF_SRDP(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0101030000.getObject().getKey(), "6", "9",
            EFormLaporanTahunanLaporanBulanan.LTLB_SRDP.getCode(),
            ER7025PosLtlbDppkSrdp.R_SRDP010000.getObject().getKey(),
            "SRDP|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
    ), () -> null),

    SG_SUMIF_SBI(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0101040000.getObject().getKey(), "7", "11",
            EFormLaporanTahunanLaporanBulanan.LTLB_SBI.getCode(),
            ER7026PosLtlbDppkSbi.R_SBI010000.getObject().getKey(),
            "SBI|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
    ), () -> null),

    SG_SUMIF_SHM(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0101060000.getObject().getKey(), "6", "11",
            EFormLaporanTahunanLaporanBulanan.LTLB_SHM.getCode(),
            ER7028PosLtlbDppkShm.R_SHM010000.getObject().getKey(),
            "SHM|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
    ), () -> null),

    SG_SUMIF_RSBN(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0101050000.getObject().getKey(), "7", "11",
            EFormLaporanTahunanLaporanBulanan.LTLB_RSBN.getCode(),
            ER7027PosLtlbDppkRsbn.R_RSBN010000.getObject().getKey(),
            "RSBN|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
    ), () -> null),

    SG_SUMIF_SUKUK(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0101080000.getObject().getKey(), "11", "16",
            EFormLaporanTahunanLaporanBulanan.LTLB_SUKUK.getCode(),
            ER7030PosLtlbDppkSukuk.R_SUKUK010000.getObject().getKey(),
            "SUKUK|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
    ), () -> null),

    SG_SUMIF_OBLI(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0101070000.getObject().getKey(), "11", "16",
            EFormLaporanTahunanLaporanBulanan.LTLB_OBLI.getCode(),
            ER7029PosLtlbDppkObli.R_OBLI010000.getObject().getKey(),
            "OBLI|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
    ), () -> null),

    SG_SUMIF_OBSUD(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0101090000.getObject().getKey(), "11", "16",
            EFormLaporanTahunanLaporanBulanan.LTLB_OBSUD.getCode(),
            ER7031PosLtlbDppkObsud.R_OBSUD010000.getObject().getKey(),
            "OBSUD|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
    ), () -> null),

    SG_SUMIF_RKSD(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0101100000.getObject().getKey(), "8", "12",
            EFormLaporanTahunanLaporanBulanan.LTLB_RKSD.getCode(),
            ER7032PosLtlbDppkRksd.R_RKSD010000.getObject().getKey(),
            "RKSD|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
    ), () -> null),

    SG_SUMIF_MTN(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0101110000.getObject().getKey(), "11", "16",
            EFormLaporanTahunanLaporanBulanan.LTLB_MTN.getCode(),
            ER7033PosLtlbDppkMtn.R_MTN010000.getObject().getKey(),
            "MTN|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
    ), () -> null),

    SG_SUMIF_EBA(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0101120000.getObject().getKey(), "11", "16",
            EFormLaporanTahunanLaporanBulanan.LTLB_EBA.getCode(),
            ER7034PosLtlbDppkEba.R_EBA010000.getObject().getKey(),
            "EBA|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
    ), () -> null),

    SG_SUMIF_DIRE(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0101130000.getObject().getKey(), "7", "11",
            EFormLaporanTahunanLaporanBulanan.LTLB_DIRE.getCode(),
            ER7035PosLtlbDppkDire.R_DIRE010000.getObject().getKey(),
            "DIRE|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
    ), () -> null),

    SG_SUMIF_DNFRA(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0101140000.getObject().getKey(), "7", "11",
            EFormLaporanTahunanLaporanBulanan.LTLB_DNFRA.getCode(),
            ER7036PosLtlbDppkDnfra.R_DNFRA010000.getObject().getKey(),
            "DNFRA|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
    ), () -> null),

    SG_SUMIF_KOKB(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0101150000.getObject().getKey(), "6", "10",
            EFormLaporanTahunanLaporanBulanan.LTLB_KOKB.getCode(),
            ER7037PosLtlbDppkKokb.R_KOKB010000.getObject().getKey(),
            "KOKB|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
    ), () -> null),

    SG_SUMIF_REPO(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0101160000.getObject().getKey(), "10", "17",
            EFormLaporanTahunanLaporanBulanan.LTLB_REPO.getCode(),
            ER7038PosLtlbDppkRepo.R_REPO010000.getObject().getKey(),
            "REPO|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
    ), () -> null),

    SG_SUMIF_PNYL(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0101170000.getObject().getKey(), "11", "19",
            EFormLaporanTahunanLaporanBulanan.LTLB_PNYL.getCode(),
            ER7039PosLtlbDppkPnyl.R_PNYL010000.getObject().getKey(),
            "PNYL|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
    ), () -> null),

    SG_SUMIF_PPIN(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0103000000.getObject().getKey(), "3", "5",
            EFormLaporanTahunanLaporanBulanan.LTLB_PPIN.getCode(),
            ER7060PosLtlbDppkPpin.R_PPIN010000.getObject().getKey(),
            "PPIN|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
    ), () -> null),

    SG_SUMIF_PROP(() -> {
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                + "$" + ER1250Properti.getPipedReferenceKeys(ER1250Properti.R_PR2);
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                + "$" + ER1250Properti.getPipedReferenceKeyValues(ER1250Properti.R_PR2);
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
        return UtilSegmentValidation.genMultiCriteriaSumIf(
                UtilMetadata.genPipeColumn(2, 11), UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(JenisProgram.PPMPK), 17, 20),
                EFormLaporanTahunanLaporanBulanan.LTLB_PROP.getCode(),
                ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                "8", "17|2", "2", criteriaCondition, sumCriteriaCondition,
                "PROP|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Objek (Tanah/Bangunan/Tanah&Bangunan)",
                criteriaConditionErr, sumCriteriaConditionErr, "0");
    }, () -> null),

    SG_SUMIF_PIUT(() -> {
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
        return UtilSegmentValidation.genSumIf(
                UtilMetadata.genPipeColumn(2, 11), UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(JenisProgram.PPMPK), 24, 26),
                EFormLaporanTahunanLaporanBulanan.LTLB_PIUT.getCode(),
                ER7042PosLtlbDppkPiut.R_PIUT010000.getObject().getKey(),
                "5|8|12", "13", "2", criteriaCondition, sumCriteriaCondition,
                "PIUT|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                criteriaConditionErr, sumCriteriaConditionErr,
                "Piutang Iuran Peserta Total|Piutang Iuran Pemberi Kerja Total|Piutang Iuran Tambahan Total");
    }, () -> null),

    SG_SUMIF_ASLN(() -> ER7003PosLtlbDppkNrc.genSumIfValidation(
            ER7003PosLtlbDppkNrc.R_NRC0108000000.getObject().getKey(), "5", "7",
            EFormLaporanTahunanLaporanBulanan.LTLB_ASLN.getCode(),
            ER7053PosLtlbDppkAsln.R_ASLN010000.getObject().getKey(),
            "ASLN|Nilai Aset|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
    ), () -> null),

    SG_SUMIF_DPJKA_DPJKV(() -> {
        String comparatorForms = EFormLaporanTahunanLaporanBulanan.LTLB_DPJKA.getCode() + "|"
                + EFormLaporanTahunanLaporanBulanan.LTLB_DPJKV.getCode();
        String comparatorRows = ER7023PosLtlbDppkDpjka.R_DPJKA010000.getObject().getKey() + "|"
                + ER7024PosLtlbDppkDpjkv.R_DPJKV010000.getObject().getKey();
        String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String sumCriteriaCond = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
        String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6");
        String sumConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
        return UtilSegmentValidation.genMultiFormSumIf(
                UtilMetadata.genPipeColumn(2, 11), ER7003PosLtlbDppkNrc.R_NRC0101020000.getObject().getKey(),
                comparatorForms, comparatorRows,
                "6|6", "9|12", "2", criteriaCondition, sumCriteriaCond,
                "DPJKA|DPJKV|Jumlah Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                criteriaConditionErr, sumConditionErr);
    }, () -> null),

    SG_EQUALS_FORMULA_1(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), ER7003PosLtlbDppkNrc.R_NRC0102000000.getObject().getKey(),
            UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(JenisProgram.PPMPK), 0, 20),
            UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0102000000.getObject().getValue(),
                    UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(JenisProgram.PPMPK), 0, 20))),
            () -> null),

    SG_EQUALS_FORMULA_2(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), ER7003PosLtlbDppkNrc.R_NRC0105000000.getObject().getKey(),
            UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(JenisProgram.PPMPK), 23, 31),
            UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0105000000.getObject().getValue(),
                    UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(JenisProgram.PPMPK), 23, 32))),
            () -> null),

    SG_EQUALS_FORMULA_3(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), ER7003PosLtlbDppkNrc.R_NRC0107000000.getObject().getKey(),
            UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(JenisProgram.PPMPK), 34, 39),
            UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0107000000.getObject().getValue(),
                    UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(JenisProgram.PPMPK), 34, 39))),
            () -> null),

    SG_EQUALS_FORMULA_4(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), ER7003PosLtlbDppkNrc.R_NRC0116000000.getObject().getKey(),
            UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(JenisProgram.PPMPK), 45, 51),
            UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0116000000.getObject().getValue(),
                    UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(JenisProgram.PPMPK), 45, 51))),
            () -> null),

    SG_EQUALS_FORMULA_5(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject().getKey(),
            UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(JenisProgram.PPMPK), new int[]{21, 22, 33, 40, 41}),
            UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject().getValue(),
                    UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(JenisProgram.PPMPK), new int[]{21, 22, 33, 40, 41}))),
            () -> null),

    SG_EQUALS_FORMULA_6(() -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), ER7003PosLtlbDppkNrc.R_NRC0118000000.getObject().getKey(),
            UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(JenisProgram.PPMPK), new int[]{43, 44, 52}),
            UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0118000000.getObject().getValue(),
                    UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(JenisProgram.PPMPK), new int[]{43, 44, 52}))),
            () -> null),

    SG_EQUALS_FORM_FORMULA_LAN_1(() -> genEqualsForm("2", "3"), () -> null),
    SG_EQUALS_FORM_FORMULA_LAN_2(() -> genEqualsForm("3", "4"), () -> null),
    SG_EQUALS_FORM_FORMULA_LAN_3(() -> genEqualsForm("4", "5"), () -> null),
    SG_EQUALS_FORM_FORMULA_LAN_4(() -> genEqualsForm("5", "6"), () -> null),
    SG_EQUALS_FORM_FORMULA_LAN_5(() -> genEqualsForm("6", "7"), () -> null),
    SG_EQUALS_FORM_FORMULA_LAN_6(() -> genEqualsForm("7", "8"), () -> null),
    SG_EQUALS_FORM_FORMULA_LAN_7(() -> genEqualsForm("8", "9"), () -> null),
    SG_EQUALS_FORM_FORMULA_LAN_8(() -> genEqualsForm("9", "10"), () -> null),
    SG_EQUALS_FORM_FORMULA_LAN_9(() -> genEqualsForm("10", "11"), () -> null),
    SG_EQUALS_FORM_FORMULA_LAN_10(() -> genEqualsForm("11", "12"), () -> null),

    FV_EQUALS_EXCEPT(() -> null,
            () -> UtilFieldValidation.genEqualsExceptPosFormula(UtilMetadata.genPlusColumn(2, 11),
                    UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(JenisProgram.PPMPK), new int[]{21, 33, 40, 42}), 2));

    private final Supplier<SegmentValidation> segmentSupplier;
    private final Supplier<FieldValidation> fieldSupplier;

    public SegmentValidation toSegmentValidation() {
        if (segmentSupplier.get() == null) {
            throw new UnsupportedOperationException("Segment Validation is null");
        }
        return segmentSupplier.get();
    }

    public FieldValidation toFieldValidation() {
        if (fieldSupplier.get() == null) {
            throw new UnsupportedOperationException("Field Validation is null");
        }
        return fieldSupplier.get();
    }

    public static boolean isSegment(ENrcValidationsConfig eConfig) {
        return eConfig.segmentSupplier.get() != null;
    }

    public static boolean isField(ENrcValidationsConfig eConfig) {
        return eConfig.fieldSupplier.get() != null;
    }

    private static SegmentValidation genEqualsForm(String selectField, String comparatorField) {
        return UtilSegmentValidation.genEqualsForm(selectField, ER7003PosLtlbDppkNrc.R_NRC0104010000.getObject().getKey(),
                EFormLaporanTahunanLaporanBulanan.LTLB_LAN.getCode(), comparatorField,
                ER7001PosLtlbDppkLan.R_LAN0103010000.getObject().getKey());
    }

}