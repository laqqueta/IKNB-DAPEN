package id.go.ojk.metadata.module.lblt.validations.gabungan;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.metadata.module.lblt.reference.ER7018PosLtlbDppkRas2;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.validation.ValidationConverter;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;

import static id.go.ojk.metadata.module.lblt.reference.ER7018PosLtlbDppkRas2.*;
import static id.go.ojk.metadata.module.lblt.reference.ER7021PosLtlbDppkTbdsp.R_TBDSP0202010000;
import static id.go.ojk.metadata.module.lblt.reference.ER7021PosLtlbDppkTbdsp.R_TBDSP0301000000;
import static id.go.ojk.metadata.module.lblt.reference.ER7021PosLtlbDppkTbdsp.getObjects;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7018Ras2GabunganValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_NUMERIC_DOT(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genRegexNumericDot("4|5",
                    UtilMetadata.genPipeRow(ER7018PosLtlbDppkRas2.getObjects(PPMPPPIPK), new int[]{ 6 }))),

    SG_NUMERIC(programs(PPMPPPIPK),
            () -> {
                List<KeyValueString> except = Arrays.asList(R_RAS20103000000.getObject());
                String pipeExcept = UtilMetadata.genDelimitedRowExcept(getObjects(PPMPPPIPK), except, "|");
                return UtilSegmentValidation.genRegexNumeric("4|5", pipeExcept);
            }),

    SG_SUM_COL(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula("4|5", R_RAS20102000000.key,
                    UtilMetadata.genPlusRow(ER7018PosLtlbDppkRas2.getObjects(PPMPPPIPK), 1, 4),
                    "2", "PPMP|PPIP",
                    UtilMetadata.genMessageTotal(R_RAS20102000000.value,
                            UtilMetadata.genPlusDesc(ER7018PosLtlbDppkRas2.getObjects(PPMPPPIPK), 1, 4)), 2)),

    SG_RASIO(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genEqualsFilterRatio2(
                    "4|5", R_RAS20103000000.key, R_RAS20102000000.key,
                    "4|5", R_RAS20100000000.key, "3",
                    "2", "PPMP|PPIP",
                    UtilMetadata.genMessage(R_RAS20103000000.value,
                            UtilMetadata.genDevideDesc(ER7018PosLtlbDppkRas2.getObjects(PPMPPPIPK), new int[]{5, 0})), 2)),

    CR_EMPTY_1(programs(PPMPPPIPK), validationFields(2),
            () -> UtilFieldConditional.genExistPos("N", "M",
                    UtilMetadata.genPipeRow(ER7018PosLtlbDppkRas2.getObjects(PPMPPPIPK), 1, 6))),

    CR_EMPTY_2(programs(PPMPPPIPK), validationFields(3, 4),
            () -> UtilFieldConditional.genExistPos("N", "M",
                    UtilMetadata.genPipeRow(ER7018PosLtlbDppkRas2.getObjects(PPMPPPIPK), new int[]{0}))),
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

    public static final BaseMetadataValidation<E7018Ras2GabunganValidationsConfig> VALIDATION_METADATA_PPMPPPIPK =
            new LbltMetadataValidation<>(E7018Ras2GabunganValidationsConfig.class, PPMPPPIPK);

    public static void main(String[] args) {
        System.out.println(UtilMetadata.genPipeRow(ER7018PosLtlbDppkRas2.getObjects(PPMPPPIPK), new int[]{ 6 }));
    }
}
