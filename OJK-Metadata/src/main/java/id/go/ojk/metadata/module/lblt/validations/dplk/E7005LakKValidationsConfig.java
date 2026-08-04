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
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.reference.ER7003PosLtlbDppkNrc;
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

import static id.go.ojk.metadata.module.lblt.reference.ER7005PosLtlbDppkLak.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.DPLK;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7005LakKValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUM_POS_COL_EQUAL_1(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LAK0200000000.key,
                    UtilMetadata.genPlusRow(getObjects(DPLK), 0, 6),
                    UtilMetadata.genMessage(R_LAK0200000000.value, UtilMetadata.genPlusDesc(getObjects(DPLK), 0, 6)))),

    SG_SUM_POS_COL_EQUAL_2(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LAK0400000000.key,
                    UtilMetadata.genPlusRow(getObjects(DPLK), 8, 11),
                    UtilMetadata.genMessage(R_LAK0400000000.value, UtilMetadata.genPlusDesc(getObjects(DPLK), 8, 11)))),

    SG_SUM_POS_COL_EQUAL_3(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LAK0600000000.key,
                    UtilMetadata.genPlusRow(getObjects(DPLK), 13, 18),
                    UtilMetadata.genMessage(R_LAK0600000000.value, UtilMetadata.genPlusDesc(getObjects(DPLK), 13, 18)))),

    SG_SUM_POS_COL_EQUAL_4(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LAK0700000000.key,
                    UtilMetadata.genPlusRow(getObjects(DPLK), new int[]{7, 12, 19}),
                    UtilMetadata.genMessage(R_LAK0700000000.value, UtilMetadata.genPlusDesc(getObjects(DPLK), new int[]{7, 12, 19})))),

    SG_SUM_POS_COL_EQUAL_5(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 12), R_LAK0900000000.key,
                    UtilMetadata.genPlusRow(getObjects(DPLK), new int[]{20, 21}),
                    UtilMetadata.genMessage(R_LAK0900000000.value, UtilMetadata.genPlusDesc(getObjects(DPLK), new int[]{20, 21})))),

    GEN_VALIDATON_FORM_NRC(programs(DPLK), () -> {
        KeyValueString selectPosCode = R_LAK0900000000.getObject();
        int[] cols = {12};
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_NERACA.getCode();
        String comparatorColumn = UtilMetadata.genPlusColumn(cols);
        KeyValueString comparatorPosCode = ER7003PosLtlbDppkNrc.R_NRC0104010000.getObject();
        String comparatorPosCodeForm = comparatorPosCode.getKey();
        String errMsg = selectPosCode.getValue() + " | Total " + comparatorPosCode.getValue() + " pada form " + comparatorForm;
        return UtilSegmentValidationV2.genEqualsFormColumCalculation("12", selectPosCode.getKey(), comparatorColumn,
                comparatorPosCodeForm, comparatorForm, errMsg, 2);
    }),


    FV_SUM_COL_1(programs(DPLK), validationFields(12),
            () -> UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 11),
                    UtilMetadata.genPipeRow(getObjects(DPLK)))),

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

    public static final BaseMetadataValidation<E7005LakKValidationsConfig> VALIDATION_METADATA_DPLK =
            new LbltMetadataValidation<>(E7005LakKValidationsConfig.class, DPLK);

}
