package id.go.ojk.module.lblt.dppk.validations.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1250Properti;
import id.go.ojk.conf.client.field.reference.ER1255JenisManfaat;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.reference.*;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.metadata.validation.ValidationConverter;
import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.function.Supplier;

import static id.go.ojk.util.FieldUtil.programs;
import static id.go.ojk.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
public enum E7003NrcValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUMIF_DOC(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101010000.getObject().getKey(), "6", "9",
                    EFormLaporanBulananTahunan.LTLB_DOC.getCode(),
                    ER7022PosLtlbDppkDoc.R_DOC010000.getObject().getKey(),
                    "DOC|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SRDP(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101030000.getObject().getKey(), "6", "9",
                    EFormLaporanBulananTahunan.LTLB_SRDP.getCode(),
                    ER7025PosLtlbDppkSrdp.R_SRDP010000.getObject().getKey(),
                    "SRDP|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SBI(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101040000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_SBI.getCode(),
                    ER7026PosLtlbDppkSbi.R_SBI010000.getObject().getKey(),
                    "SBI|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SHM(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101060000.getObject().getKey(), "6", "11",
                    EFormLaporanBulananTahunan.LTLB_SHM.getCode(),
                    ER7028PosLtlbDppkShm.R_SHM010000.getObject().getKey(),
                    "SHM|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_RSBN(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101050000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_RSBN.getCode(),
                    ER7027PosLtlbDppkRsbn.R_RSBN010000.getObject().getKey(),
                    "RSBN|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF"
            )),

    SG_SUMIF_SUKUK(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101080000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_SUKUK.getCode(),
                    ER7030PosLtlbDppkSukuk.R_SUKUK010000.getObject().getKey(),
                    "SUKUK|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_OBLI(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101070000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_OBLI.getCode(),
                    ER7029PosLtlbDppkObli.R_OBLI010000.getObject().getKey(),
                    "OBLI|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_OBSUD(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101090000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_OBSUD.getCode(),
                    ER7031PosLtlbDppkObsud.R_OBSUD010000.getObject().getKey(),
                    "OBSUD|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_RKSD(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101100000.getObject().getKey(), "8", "12",
                    EFormLaporanBulananTahunan.LTLB_RKSD.getCode(),
                    ER7032PosLtlbDppkRksd.R_RKSD010000.getObject().getKey(),
                    "RKSD|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_MTN(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101110000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_MTN.getCode(),
                    ER7033PosLtlbDppkMtn.R_MTN010000.getObject().getKey(),
                    "MTN|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_EBA(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101120000.getObject().getKey(), "11", "16",
                    EFormLaporanBulananTahunan.LTLB_EBA.getCode(),
                    ER7034PosLtlbDppkEba.R_EBA010000.getObject().getKey(),
                    "EBA|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_DIRE(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101130000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_DIRE.getCode(),
                    ER7035PosLtlbDppkDire.R_DIRE010000.getObject().getKey(),
                    "DIRE|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_DNFRA(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101140000.getObject().getKey(), "7", "11",
                    EFormLaporanBulananTahunan.LTLB_DNFRA.getCode(),
                    ER7036PosLtlbDppkDnfra.R_DNFRA010000.getObject().getKey(),
                    "DNFRA|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_KOKB(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101150000.getObject().getKey(), "6", "10",
                    EFormLaporanBulananTahunan.LTLB_KOKB.getCode(),
                    ER7037PosLtlbDppkKokb.R_KOKB010000.getObject().getKey(),
                    "KOKB|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_REPO(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101160000.getObject().getKey(), "10", "17",
                    EFormLaporanBulananTahunan.LTLB_REPO.getCode(),
                    ER7038PosLtlbDppkRepo.R_REPO010000.getObject().getKey(),
                    "REPO|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PNYL(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0101170000.getObject().getKey(), "11", "19",
                    EFormLaporanBulananTahunan.LTLB_PNYL.getCode(),
                    ER7039PosLtlbDppkPnyl.R_PNYL010000.getObject().getKey(),
                    "PNYL|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PPIN(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0103000000.getObject().getKey(), "3", "5",
                    EFormLaporanBulananTahunan.LTLB_PPIN.getCode(),
                    ER7060PosLtlbDppkPpin.R_PPIN010000.getObject().getKey(),
                    "PPIN|Nilai Nominal|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_PROP(programs(PPMPK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                        + "$" + ER1250Properti.getPipedReferenceKeys(ER1250Properti.R_PR2);
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3|ML1|ML2|ML3|ML4|ML5|ML6")
                        + "$" + ER1250Properti.getPipedReferenceKeyValues(ER1250Properti.R_PR2);
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidation.genMultiCriteriaSumIf(
                        UtilMetadata.genPipeColumn(2, 11), UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 17, 20),
                        EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                        ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                        "8", "17|2", "2", criteriaCondition, sumCriteriaCondition,
                        "PROP|Nilai Perolehan|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain|Jenis Objek (Tanah/Bangunan/Tanah&Bangunan)",
                        criteriaConditionErr, sumCriteriaConditionErr, "0");
            }),

    SG_SUMIF_PIUT(programs(PPMPK),
            () -> {
                String criteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
                String criteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MPL1|MPL2|MPL3||ML1|ML2|ML3|ML4|ML5|ML6");
                String sumCriteriaCondition = ER1255JenisManfaat.getPipedReferenceKeys("MP1|MP2|MP3");
                String sumCriteriaConditionErr = ER1255JenisManfaat.getPipedReferenceKeyValues("MP1|MP2|MP3");
                return UtilSegmentValidation.genSumIf(
                        UtilMetadata.genPipeColumn(2, 11), UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 24, 26),
                        EFormLaporanBulananTahunan.LTLB_PIUT.getCode(),
                        ER7042PosLtlbDppkPiut.R_PIUT010000.getObject().getKey(),
                        "5|8|12", "13", "2", criteriaCondition, sumCriteriaCondition,
                        "PIUT|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                        criteriaConditionErr, sumCriteriaConditionErr,
                        "Piutang Iuran Peserta Total|Piutang Iuran Pemberi Kerja Total|Piutang Iuran Tambahan Total");
            }),

    SG_SUMIF_ASLN(programs(PPMPK),
            () -> sumIfValidationHelper(
                    ER7003PosLtlbDppkNrc.R_NRC0108000000.getObject().getKey(), "5", "7",
                    EFormLaporanBulananTahunan.LTLB_ASLN.getCode(),
                    ER7053PosLtlbDppkAsln.R_ASLN010000.getObject().getKey(),
                    "ASLN|Nilai Aset|Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain"
            )),

    SG_SUMIF_DPJKA_DPJKV(programs(PPMPK),
            () -> {
                String comparatorForms = EFormLaporanBulananTahunan.LTLB_DPJKA.getCode() + "|"
                        + EFormLaporanBulananTahunan.LTLB_DPJKV.getCode();
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
            }),

    SG_EQUALS_FORMULA_1(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0102000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 0, 20),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0102000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 0, 20)))),

    SG_EQUALS_FORMULA_2(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0105000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 23, 31),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0105000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 23, 32)))),

    SG_EQUALS_FORMULA_3(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0107000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 34, 39),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0107000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 34, 39)))),

    SG_EQUALS_FORMULA_4(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0116000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 45, 51),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0116000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), 45, 51)))),

    SG_EQUALS_FORMULA_5(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), new int[]{21, 22, 33, 40, 41}),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0109000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), new int[]{21, 22, 33, 40, 41})))),

    SG_EQUALS_FORMULA_6(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12),
                    ER7003PosLtlbDppkNrc.R_NRC0118000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), new int[]{43, 44, 52}),
                    UtilMetadata.genMessage(ER7003PosLtlbDppkNrc.R_NRC0118000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), new int[]{43, 44, 52})))),

    SG_EQUALS_FORM_FORMULA_LAN_1(programs(PPMPK), () -> genEqualsForm("2", "3")),
    SG_EQUALS_FORM_FORMULA_LAN_2(programs(PPMPK), () -> genEqualsForm("3", "4")),
    SG_EQUALS_FORM_FORMULA_LAN_3(programs(PPMPK), () -> genEqualsForm("4", "5")),
    SG_EQUALS_FORM_FORMULA_LAN_4(programs(PPMPK), () -> genEqualsForm("5", "6")),
    SG_EQUALS_FORM_FORMULA_LAN_5(programs(PPMPK), () -> genEqualsForm("6", "7")),
    SG_EQUALS_FORM_FORMULA_LAN_6(programs(PPMPK), () -> genEqualsForm("7", "8")),
    SG_EQUALS_FORM_FORMULA_LAN_7(programs(PPMPK), () -> genEqualsForm("8", "9")),
    SG_EQUALS_FORM_FORMULA_LAN_8(programs(PPMPK), () -> genEqualsForm("9", "10")),
    SG_EQUALS_FORM_FORMULA_LAN_9(programs(PPMPK), () -> genEqualsForm("10", "11")),
    SG_EQUALS_FORM_FORMULA_LAN_10(programs(PPMPK), () -> genEqualsForm("11", "12")),

    FV_EQUALS_EXCEPT(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula(
                    UtilMetadata.genPlusColumn(2, 11),
                    UtilMetadata.genPipeRow(ER7003PosLtlbDppkNrc.getObjects(ProgramType.PPMPK), new int[]{21, 33, 40, 42}),
                    2))

    ;

    private final EnumSet<ProgramType> programTypes;
    private final Supplier<? extends IValidation> supplier;

    @Override
    public Supplier<? extends IValidation> getSupplier() {
        return supplier;
    }

    @Override
    public EnumSet<ProgramType> getProgramTypes() {
        return programTypes;
    }

    @Override
    public SegmentValidation toSegmentValidation() {
        return ValidationConverter
                .toValidation(this, SegmentValidation.class);
    }

    @Override
    public FieldValidation toFieldValidation() {
        return ValidationConverter
                .toValidation(this, FieldValidation.class);
    }

    @Override
    public ConditionalRequired toFieldConditional() {
        return ValidationConverter
                .toValidation(this, ConditionalRequired.class);
    }

    public static final BaseMetadataValidation<E7003NrcValidationsConfig> VALIDATION_METADATA =
            new LbltMetadataValidation<>(E7003NrcValidationsConfig.class, PPMPK);

    private static SegmentValidation genEqualsForm(String selectField, String formComparatorField) {
        return UtilSegmentValidation.genEqualsForm(selectField, ER7003PosLtlbDppkNrc.R_NRC0104010000.getObject().getKey(),
                EFormLaporanBulananTahunan.LTLB_LAN.getCode(), formComparatorField,
                ER7003PosLtlbDppkNrc.R_NRC0104010000.getObject().getKey());
    }

    private static SegmentValidation sumIfValidationHelper(String posCode, String rangeField, String criteriaField, String formCode,
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

}
