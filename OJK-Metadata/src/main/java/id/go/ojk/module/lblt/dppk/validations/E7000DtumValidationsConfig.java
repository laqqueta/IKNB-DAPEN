package id.go.ojk.module.lblt.dppk.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.module.lblt.dppk.reference.ER7000PosLtlbDppkDtum;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.util.metadata.validation.ValidationConverter;
import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.function.Supplier;

import static id.go.ojk.util.FieldUtil.programs;
import static id.go.ojk.util.constants.ProgramType.ALL;
import static id.go.ojk.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
public enum E7000DtumValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_REGEX_ALL(programs(ALL),
            () -> UtilSegmentValidation.genRegexAll("2",
                    UtilMetadata.genPipeRowExcept(ER7000PosLtlbDppkDtum.getObjects(), new int[] {6, 13}))),

    SG_REGEX_DATE(programs(ALL),
            () -> UtilSegmentValidation.genRegexDate("2",
                    UtilMetadata.genPipeRow(ER7000PosLtlbDppkDtum.getObjects(), new int[] {6, 13}))),

    SG_REGEX_DATA_LEN_1(programs(ALL),
            () -> UtilSegmentValidation.genLength("2",
                    UtilMetadata.genPipeRow(ER7000PosLtlbDppkDtum.getObjects(), new int[] {4, 5}), 1, 20)),

    SG_REGEX_DATA_LEN_2(programs(ALL),
            () -> UtilSegmentValidation.genLength("2",
                    UtilMetadata.genPipeRow(ER7000PosLtlbDppkDtum.getObjects(), new int[] {0}),1, 500)),

    SG_REGEX_DATA_LEN_3(programs(ALL),
            () -> UtilSegmentValidation.genLength("2",
                    UtilMetadata.genPipeRow(ER7000PosLtlbDppkDtum.getObjects(), new int[] {6, 13}), 8, 10)),

    SG_REGEX_DATA_LEN_4(programs(ALL),
            () -> UtilSegmentValidation.genLength("2",
                    UtilMetadata.genPipeRowExcept(ER7000PosLtlbDppkDtum.getObjects(), new int[] {0, 4, 5, 6, 13}),1, 100)),

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

    public static final BaseMetadataValidation<E7000DtumValidationsConfig> VALIDATION_METADATA =
            new LbltMetadataValidation<>(E7000DtumValidationsConfig.class, PPMPK);

}
