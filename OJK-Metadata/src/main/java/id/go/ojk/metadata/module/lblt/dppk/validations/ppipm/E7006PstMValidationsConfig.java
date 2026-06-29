package id.go.ojk.metadata.module.lblt.dppk.validations.ppipm;

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
import id.go.ojk.metadata.module.lblt.dppk.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.dppk.reference.ER7001PosLtlbDppkLan;
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

import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7006PosLtlbDppkPst.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPIPM;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7006PstMValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    FV_SUM_ROW(programs(PPIPM), validationFields(5),
            () -> UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(2, 4))),

    SG_SEGMENT_1(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("2",
                    R_PST0100000000.key, UtilMetadata.genPlusRow(getObjects(), new int[]{1, 2}),
                    UtilMetadata.genMessage(R_PST0100000000.value, UtilMetadata.genPlusDesc(getObjects(), new int[]{1, 2})))),

    SG_SEGMENT_2(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("2", R_PST0200000000.key,
                    UtilMetadata.genPlusRow(getObjects(), new int[]{4, 9}),
                    UtilMetadata.genMessage(R_PST0200000000.value, UtilMetadata.genPlusDesc(getObjects(), new int[]{4, 9})))),

    SG_SEGMENT_3(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("2", R_PST0201000000.key,
                    UtilMetadata.genPlusRow(getObjects(), 5, 8),
                    UtilMetadata.genMessage(R_PST0201000000.value, UtilMetadata.genPlusDesc(getObjects(), 5, 8)))),

    SG_SEGMENT_4(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("2", R_PST0202000000.key,
                    UtilMetadata.genPlusRow(getObjects(), 10, 13),
                    UtilMetadata.genMessage(R_PST0202000000.value, UtilMetadata.genPlusDesc(getObjects(), 10, 13)))),

    SG_SEGMENT_5(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("2", R_PST0300000000.key,
                    UtilMetadata.genPlusRow(getObjects(), new int[]{15, 16}),
                    UtilMetadata.genMessage(R_PST0300000000.value, UtilMetadata.genPlusDesc(getObjects(), new int[]{15, 16})))),

    SG_SEGMENT_6(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula("2", R_PST0400000000.key,
                    UtilMetadata.genPlusRow(getObjects(), new int[]{0, 3, 14}),
                    UtilMetadata.genMessage(R_PST0400000000.value, UtilMetadata.genPlusDesc(getObjects(), new int[]{0, 3, 14})))),

    GEN_VALIDATON_FORM_LAN(programs(PPIPM), () -> {
        String selectExpr = "> 0";
        String comparatorForm = EFormLaporanBulananTahunan.LTLB_LAN.getCode();
        KeyValueString comparator = ER7001PosLtlbDppkLan.R_LAN0111000000.getObject();
        String comparatorExpr = "> 0";
        String errMsg = comparator.getValue() + "|" + R_PST0400000000.value;
        return UtilSegmentValidationV2.genEqualsFormConditionalExpression2("2", R_PST0400000000.key, selectExpr, comparatorForm, "3",
                comparator.getKey(), comparatorExpr, "e", 2, errMsg);
    }),

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

    public static final BaseMetadataValidation<E7006PstMValidationsConfig> VALIDATION_METADATA_PPIPM =
            new LbltMetadataValidation<>(E7006PstMValidationsConfig.class, PPIPM);

}
