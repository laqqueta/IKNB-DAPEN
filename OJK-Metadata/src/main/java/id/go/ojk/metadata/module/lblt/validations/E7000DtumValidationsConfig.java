package id.go.ojk.metadata.module.lblt.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.metadata.module.lblt.reference.ER7000PosLtlbDppkDtum;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.metadata.validation.ValidationConverter;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;

import static id.go.ojk.metadata.module.lblt.reference.ER7000PosLtlbDppkDtum.R_DTUM020000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;

@RequiredArgsConstructor
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

    SG_ROW_COUNT(programs(ALL),
            () -> UtilSegmentValidation.genPosCodeMinCount(UtilMetadata.genPipeRow(ER7000PosLtlbDppkDtum.getObjects(), new int[] { 24, 25 }), 2)),

    FV_EQUALS_JENIS_PENSIUN(programs(ALL), validationFields(2),
            () -> UtilFieldValidation.genEqualsJenisProgram(R_DTUM020000.key)),

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

    public static BaseMetadataValidation<E7000DtumValidationsConfig> getValidationMetadata(ProgramType programType) {
        return new LbltMetadataValidation<>(E7000DtumValidationsConfig.class, programType);
    }

}
