package id.go.ojk.metadata.module.lblt.validations.dplk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.UtilSegmentValidationV2;
import id.go.ojk.conf.client.dto.FormulaParserData;
import id.go.ojk.conf.client.field.reference.ER1250Properti;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.reference.*;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.validation.ValidationConverter;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;

import static id.go.ojk.conf.client.UtilMetadata.genFormulaParser;
import static id.go.ojk.metadata.module.lblt.field.Dppk0012Alm.*;
import static id.go.ojk.metadata.module.lblt.reference.ER7012PosLtlbDppkAlm.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.DPLK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7012AlmKValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA_1(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    ER7012PosLtlbDppkAlm.R_ALM0121000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), 0, 19),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0121000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), 0, 19)))),

    SG_EQUAL_FORMULA_2(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    ER7012PosLtlbDppkAlm.R_ALM0206000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), 21, 25),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0206000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), 21, 25)))),

    SG_EQUAL_FORMULA_3(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    ER7012PosLtlbDppkAlm.R_ALM0300000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), new int[] {20, 26}),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0300000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), new int[] {20, 26})))),

    SG_EQUAL_FORMULA_4(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    ER7012PosLtlbDppkAlm.R_ALM0404000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), 28, 30),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0404000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), 28, 30)))),

    SG_EQUAL_FORMULA_5(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula("16",
                    ER7012PosLtlbDppkAlm.R_ALM0507000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), 32, 37),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0507000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), 32, 37)))),

    SG_EQUAL_FORMULA_6(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula("16",
                    ER7012PosLtlbDppkAlm.R_ALM0600000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), new int[]{31, 38}),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0600000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), new int[]{31, 38})))),

    SG_EQUAL_FORMULA_7(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula("16",
                    ER7012PosLtlbDppkAlm.R_ALM0700000000.getObject().getKey(),
                    UtilMetadata.genMinusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), new int[]{27, 39}),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0700000000.getObject().getValue(),
                            UtilMetadata.genMinusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK), new int[]{27, 39})))),

    SG_FIELD_TOTAL_1(programs(DPLK), () -> genTotalValidation(R_ALM0101000000.key,
            EFormLaporanBulananTahunan.LTLB_DOC,
            ER7022PosLtlbDppkDoc.getObjects(),
            "6", "Nilai Nominal")),

    SG_FIELD_TOTAL_2(programs(DPLK), () -> genTotalValidation(R_ALM0102000000.key,
            EFormLaporanBulananTahunan.LTLB_DPJKA,
            ER7023PosLtlbDppkDpjka.getObjects(),
            "6", "Nilai Nominal")),

    SG_FIELD_TOTAL_3(programs(DPLK), () -> genTotalValidation(R_ALM0103000000.key,
            EFormLaporanBulananTahunan.LTLB_SRDP,
            ER7025PosLtlbDppkSrdp.getObjects(),
            "6", "Nilai Nominal")),

    SG_FIELD_TOTAL_4(programs(DPLK), () -> genTotalValidation(R_ALM0104000000.key,
            EFormLaporanBulananTahunan.LTLB_SBI,
            ER7026PosLtlbDppkSbi.getObjects(),
            "8", "Nilai Wajar")),

    SG_FIELD_TOTAL_5(programs(DPLK), () -> genTotalValidation(R_ALM0105000000.key,
            EFormLaporanBulananTahunan.LTLB_RSBN,
            ER7027PosLtlbDppkRsbn.getObjects(),
            "8", "Nilai Wajar")),

    SG_FIELD_TOTAL_6(programs(DPLK), () -> genTotalValidation(R_ALM0106000000.key,
            EFormLaporanBulananTahunan.LTLB_SHM,
            ER7028PosLtlbDppkShm.getObjects(),
            "6", "Nilai Perolehan")),

    SG_FIELD_TOTAL_7(programs(DPLK), () -> genTotalValidation(R_ALM0107000000.key,
            EFormLaporanBulananTahunan.LTLB_OBLI,
            ER7029PosLtlbDppkObli.getObjects(),
            "12", "Nilai Wajar")),

    SG_FIELD_TOTAL_8(programs(DPLK), () -> genTotalValidation(R_ALM0108000000.key,
            EFormLaporanBulananTahunan.LTLB_SUKUK,
            ER7030PosLtlbDppkSukuk.getObjects(),
            "12", "Nilai Wajar")),

    SG_FIELD_TOTAL_9(programs(DPLK), () -> genTotalValidation(R_ALM0109000000.key,
            EFormLaporanBulananTahunan.LTLB_OBSUD,
            ER7031PosLtlbDppkObsud.getObjects(),
            "12", "Nilai Wajar")),

    SG_FIELD_TOTAL_10(programs(DPLK), () -> genTotalValidation(R_ALM0110000000.key,
            EFormLaporanBulananTahunan.LTLB_RKSD,
            ER7032PosLtlbDppkRksd.getObjects(),
            "9", "Nilai Wajar")),

    SG_FIELD_TOTAL_11(programs(DPLK), () -> genTotalValidation(R_ALM0111000000.key,
            EFormLaporanBulananTahunan.LTLB_MTN,
            ER7033PosLtlbDppkMtn.getObjects(),
            "12", "Nilai Wajar")),

    SG_FIELD_TOTAL_12(programs(DPLK), () -> genTotalValidation(R_ALM0112000000.key,
            EFormLaporanBulananTahunan.LTLB_EBA,
            ER7034PosLtlbDppkEba.getObjects(),
            "12", "Nilai Wajar")),

    SG_FIELD_TOTAL_13(programs(DPLK), () -> genTotalValidation(R_ALM0113000000.key,
            EFormLaporanBulananTahunan.LTLB_DIRE,
            ER7035PosLtlbDppkDire.getObjects(),
            "8", "Nilai Perolehan")),

    SG_FIELD_TOTAL_14(programs(DPLK), () -> genTotalValidation(R_ALM0114000000.key,
            EFormLaporanBulananTahunan.LTLB_DNFRA,
            ER7036PosLtlbDppkDnfra.getObjects(),
            "7", "Nilai Perolehan")),

    SG_FIELD_TOTAL_15(programs(DPLK), () -> genTotalValidation(R_ALM0115000000.key,
            EFormLaporanBulananTahunan.LTLB_KOKB,
            ER7037PosLtlbDppkKokb.getObjects(),
            "7", "Nilai Wajar")),

    SG_FIELD_TOTAL_16(programs(DPLK), () -> genTotalValidation(R_ALM0116000000.key,
            EFormLaporanBulananTahunan.LTLB_REPO,
            ER7038PosLtlbDppkRepo.getObjects(),
            "10", "Nilai Perolehan")),

    SG_FIELD_TOTAL_17(programs(DPLK), () -> genTotalValidation(R_ALM0117000000.key,
            EFormLaporanBulananTahunan.LTLB_PNYL,
            ER7039PosLtlbDppkPnyl.getObjects(),
            "15", "Nilai Apprasial/wajar - Total")),

    SG_FIELD_TOTAL_18(programs(DPLK), () -> genTotalValidation(R_ALM0201000000.key,
            EFormLaporanBulananTahunan.LTLB_KASB,
            ER7041PosLtlbDppkKasb.getObjects(),
            "6", "Nominal")),

    SG_FIELD_TOTAL_19(programs(DPLK), () -> genTotalValidation(R_ALM0202000000.key,
            EFormLaporanBulananTahunan.LTLB_BBMK,
            ER7044PosLtlbDppkBbmk.getObjects(),
            "3", "Jumlah")),

    SG_FIELD_TOTAL_20(programs(DPLK), () -> genTotalValidation(R_ALM0203000000.key,
            EFormLaporanBulananTahunan.LTLB_PIUI,
            ER7045PosLtlbDppkPiui.getObjects(),
            "4", "Nominal")),

    SG_FIELD_TOTAL_21(programs(DPLK), () -> genTotalValidation(R_ALM0204000000.key,
            EFormLaporanBulananTahunan.LTLB_PIHI,
            ER7046PosLtlbDppkPihi.getObjects(),
            "4", "Nominal")),

    SG_FIELD_TOTAL_22(programs(DPLK), () -> genTotalValidation(R_ALM0205000000.key,
            EFormLaporanBulananTahunan.LTLB_PILL,
            ER7047PosLtlbDppkPill.getObjects(),
            "4", "Nominal")),

    SG_FIELD_TOTAL_29(programs(DPLK), () -> genTotalValidation(R_ALM0501000000.key,
            EFormLaporanBulananTahunan.LTLB_UMPJ,
            ER7054PosLtlbDppkUmpj.getObjects(),
            "4", "Jumlah - Total")),

    SG_FIELD_TOTAL_30(programs(DPLK), () -> genTotalValidation(R_ALM0502000000.key,
            EFormLaporanBulananTahunan.LTLB_UMPS,
            ER7055PosLtlbDppkUmps.getObjects(),
            "4", "Jumlah - Total")),

    SG_FIELD_TOTAL_31(programs(DPLK), () -> genTotalValidation(R_ALM0503000000.key,
            EFormLaporanBulananTahunan.LTLB_UTIN,
            ER7056PosLtlbDppkUtin.getObjects(),
            "4", "Nilai")),

    SG_FIELD_TOTAL_32(programs(DPLK), () -> genTotalValidation(R_ALM0504000000.key,
            EFormLaporanBulananTahunan.LTLB_PDDM,
            ER7057PosLtlbDppkPddm.getObjects(),
            "4", "Nilai")),

    SG_FIELD_TOTAL_33(programs(DPLK), () -> genTotalValidation(R_ALM0505000000.key,
            EFormLaporanBulananTahunan.LTLB_BMHB,
            ER7058PosLtlbDppkBmhb.getObjects(),
            "4", "Nilai")),

    SG_FIELD_TOTAL_34(programs(DPLK), () -> genTotalValidation(R_ALM0506000000.key,
            EFormLaporanBulananTahunan.LTLB_UTLN,
            ER7059PosLtlbDppkUtln.getObjects(),
            "4", "Nilai")),

    SG_SUMIF_PROP_ALM0118000000(programs(DPLK),
            () -> sumIfValidationHelper(
                    R_ALM0118000000.key, "8", "2",
                    EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                    ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                    "PROP|Nilai Appraisal/Nilai Wajar|Jenis Objek (Tanah/Bangunan/Tanah&Bangunan)", "2001"
            )),

    SG_SUMIF_PROP_ALM0119000000(programs(DPLK),
            () -> sumIfValidationHelper(
                    R_ALM0119000000.key, "8", "2",
                    EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                    ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                    "PROP|Nilai Appraisal/Nilai Wajar|Jenis Objek (Tanah/Bangunan/Tanah&Bangunan)", "2005"
            )),

    SG_SUMIF_PROP_ALM0120000000(programs(DPLK),
            () -> sumIfValidationHelper(
                    R_ALM0120000000.key, "8", "2",
                    EFormLaporanBulananTahunan.LTLB_PROP.getCode(),
                    ER7040PosLtlbDppkProp.R_PROP010000.getObject().getKey(),
                    "PROP|Nilai Appraisal/Nilai Wajar|Jenis Objek (Tanah/Bangunan/Tanah & Bangunan)", "2010"
            )),

    FV_TOTAL1_EQUAL(programs(DPLK), validationFields(JT_LT_1_TAHUN_TOTAL_PPIPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("2+3",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK),
                            new int[]{20, 26, 27, 31, 38, 39, 40, 41}))),

    FV_TOTAL2_EQUAL(programs(DPLK), validationFields(JT_1_5_TAHUN_TOTAL_PPIPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("5+6",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK),
                            new int[]{20, 26, 27, 31, 38, 39, 40, 41}))),

    FV_TOTAL3_EQUAL(programs(DPLK), validationFields(JT_5_10_TAHUN_TOTAL_PPIPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("8+9",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK),
                            new int[]{20, 26, 27, 31, 38, 39, 40, 41}))),

    FV_TOTAL4_EQUAL(programs(DPLK), validationFields(JT_GTE_10_TAHUN_TOTAL_PPIPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("11+12",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK),
                            new int[]{20, 26, 27, 31, 38, 39, 40, 41}))),

    FV_TOTAL5_EQUAL(programs(DPLK), validationFields(TOTAL_RUPIAH),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("2+5+8+11",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK),
                            new int[]{20, 26, 27, 31, 38, 39, 40, 41}))),

    FV_TOTAL6_EQUAL(programs(DPLK), validationFields(TOTAL_NON_RUPIAH),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("3+6+9+12",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK),
                            new int[]{20, 26, 27, 31, 38, 39, 40, 41}))),

    FV_TOTAL7_EQUAL(programs(DPLK), validationFields(TOTAL_TOTAL_PPIP_DPLK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("14+15",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.DPLK),
                            new int[]{20, 26, 27, 31, 38, 39, 40, 41}))),

    SG_ROW_DATA_TYPE_NUMERIC(programs(DPLK),
            () -> UtilSegmentValidation.genRegexNumeric(UtilMetadata.genPipeColumn(2, 16),
                    UtilMetadata.genPipeRowExcept(ER7012PosLtlbDppkAlm.getObjects(DPLK), new int[] { 40 }))),

    SG_ROW_DATA_TYPE_NUMERIC_NEGATIVE(programs(DPLK),
            () -> UtilSegmentValidation.genRegexNumericNegative(UtilMetadata.genPipeColumn(2, 16),
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(DPLK), new int[] { 40 }))),

    ;

    private final EnumSet<ProgramType> programTypes;
    private List<Integer> fieldIndexes;
    private final Supplier<? extends IValidation> supplier;

    @Override
    public Supplier<? extends IValidation> getSupplier() {
        return supplier;
    }

    @Override
    public List<Integer> getFieldsIndex() {
        return fieldIndexes;
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

    public static final BaseMetadataValidation<E7012AlmKValidationsConfig> VALIDATION_METADATA_DPLK =
            new LbltMetadataValidation<>(E7012AlmKValidationsConfig.class, DPLK);

    private static SegmentValidation genTotalValidation(String selectPosCode,
                                                        EFormLaporanBulananTahunan comparatorForm,
                                                        List<KeyValueString> formObject,
                                                        String comparatorFields, String fieldErrorMessage) {

        FormulaParserData operation2 = genFormulaParser(formObject,
                "0", /* 0 :: baris detail | 1 :: baris total
                                    kalo validasi lama ganti 1 biar langsung nembak ke baris total */
                comparatorFields, comparatorForm.getCode());

        String errMsg = "sama dengan 'Total'" + " Kolom '" + fieldErrorMessage + "' pada Form " + comparatorForm.getCode();

        return UtilSegmentValidationV2.genFormulaParserValidationV2("16", selectPosCode, operation2.getFormula(),
                errMsg);
    }

    private static SegmentValidation sumIfValidationHelper(String posCode, String rangeField, String criteriaField, String formCode,
                                                           String formObjects, String errMsg, String keys) {

        String criteriaCondition = ER1250Properti.getKey(keys);
        String criteriaConditionErr = ER1250Properti.getKeyValue(keys)
                .replace("&", "dan");

        return UtilSegmentValidationV2.genSumIf("16", posCode,
                formCode, formObjects,
                rangeField, criteriaField, criteriaCondition,
                errMsg, criteriaConditionErr);
    }
}
