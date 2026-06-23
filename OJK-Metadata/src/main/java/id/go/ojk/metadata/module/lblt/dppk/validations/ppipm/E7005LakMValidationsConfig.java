package id.go.ojk.metadata.module.lblt.dppk.validations.ppipm;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.module.lblt.dppk.EFormLaporanBulananTahunan;
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

import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7003PosLtlbDppkNrc.R_NRC0104010000;
import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7005PosLtlbDppkLak.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.constants.ProgramType.PPIPM;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7005LakMValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUM_POS_COL_EQUAL_1(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("2", R_LAK0200000000.key,
                    UtilMetadata.genPlusRow(getObjects(), 0, 6),
                    UtilMetadata.genMessage(R_LAK0200000000.value, UtilMetadata.genPlusDesc(getObjects(), 0, 6)))),

    SG_SUM_POS_COL_EQUAL_2(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("2", R_LAK0400000000.key,
                    UtilMetadata.genPlusRow(getObjects(), 8, 17),
                    UtilMetadata.genMessage(R_LAK0400000000.value, UtilMetadata.genPlusDesc(getObjects(), 8, 17)))),

    SG_SUM_POS_COL_EQUAL_3(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("2", R_LAK0600000000.key,
                    UtilMetadata.genPlusRow(getObjects(), 19, 26),
                    UtilMetadata.genMessage(R_LAK0600000000.value, UtilMetadata.genPlusDesc(getObjects(), 19, 26)))),

    SG_SUM_POS_COL_EQUAL_4(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("2", R_LAK0700000000.key,
                    UtilMetadata.genPlusRow(getObjects(), new int[]{7, 18, 27}),
                    UtilMetadata.genMessage(R_LAK0700000000.value, UtilMetadata.genPlusDesc(getObjects(), new int[]{7, 18, 27})))),

    SG_SUM_POS_COL_EQUAL_5(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("2", R_LAK0900000000.key,
                    UtilMetadata.genPlusRow(getObjects(), new int[]{28, 29}),
                    UtilMetadata.genMessage(R_LAK0900000000.value, UtilMetadata.genPlusDesc(getObjects(), new int[]{28, 29})))),

    GEN_VALIDATON_FORM_LAN(programs(PPIPM), () -> {
        KeyValueString selectPosCode = R_LAK0900000000.getObject();
        int[] cols = { 2 };
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_NERACA.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = R_NRC0104010000.getObject();
        String comparatorPosCodeForm = comparatorForm + comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidation.genEqualsFormColumCalculation("2", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, errMsg, 2);
    }),


    SG_NEGATIVE_NUM(programs(PPIPM),
            () -> UtilSegmentValidation.genRegexNumericNegative(
                    "2",
                    UtilMetadata.genPipeRowExcept(getObjects(), new int[]{7, 18, 27, 28, 29, 30}))),

    SG_POSITIVE_NUM(programs(PPIPM),
            () -> UtilSegmentValidation.genRegexNumeric(
                    "2",
                    UtilMetadata.genPipeRow(getObjects(), new int[]{7, 18, 27, 28, 29, 30}))),

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

    public static final BaseMetadataValidation<E7005LakMValidationsConfig> VALIDATION_METADATA_PPIPM =
            new LbltMetadataValidation<>(E7005LakMValidationsConfig.class, PPIPM);

}
