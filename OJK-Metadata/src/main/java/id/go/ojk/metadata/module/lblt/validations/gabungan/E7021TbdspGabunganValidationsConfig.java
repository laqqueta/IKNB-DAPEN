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
import id.go.ojk.metadata.module.lblt.field.Dppk0021Tbdsp;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.validation.ValidationConverter;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;

import static id.go.ojk.metadata.module.lblt.reference.ER7021PosLtlbDppkTbdsp.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7021TbdspGabunganValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUM_MITRA(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula("4", R_TBDSP0202020000.key, R_TBDSP0202010000.key,
                    "2", "PPMP|PPIP",
                    UtilMetadata.genMessageTotal(R_TBDSP0202020000.value, R_TBDSP0202010000.value), 2)),

    SG_SUM_PENERIMA(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula("4", R_TBDSP0303000000.key, R_TBDSP0301000000.key,
                    "2", "PPMP|PPIP",
                    UtilMetadata.genMessageTotal(R_TBDSP0303000000.value, R_TBDSP0301000000.value), 2)),

    SG_SALDO_AKHIR(programs(PPMPPPIPK),
            () -> UtilSegmentValidation.genFilterEqualsFormula("4", R_TBDSP0400000000.key,
                    UtilMetadata.genPlusRow(getObjects(PPMPPPIPK), new int[]{0, 4, 9}),
                    "2", "PPMP|PPIP",
                    UtilMetadata.genMessageTotal(R_TBDSP0400000000.value, UtilMetadata.genPlusDesc(getObjects(PPMPPPIPK), new int[]{0, 4, 9})), 2)),

    CR_EMPTY_1(programs(PPMPPPIPK), validationFields(Dppk0021Tbdsp.URAIAN_RINCIAN),
            () -> {
                List<KeyValueString> except = Arrays.asList(R_TBDSP0202010000.getObject(), R_TBDSP0301000000.getObject());
                String pipeExcept = UtilMetadata.genDelimitedRowExcept(getObjects(PPMPPPIPK), except, "|");
                return UtilFieldConditional.genExistPos("N", "M", pipeExcept);
            }),

    CR_EMPTY_2(programs(PPMPPPIPK), validationFields(Dppk0021Tbdsp.KETERANGAN),
            () -> UtilFieldConditional.genExistPos("N", "O", R_TBDSP0400000000.key)),

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

    public static final BaseMetadataValidation<E7021TbdspGabunganValidationsConfig> VALIDATION_METADATA_PPMPPPIPK =
            new LbltMetadataValidation<>(E7021TbdspGabunganValidationsConfig.class, PPMPPPIPK);
}
