package id.go.ojk.module.lblt.dppk.validations;

import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.module.lblt.dppk.reference.ER7000PosLtlbDppkDtum;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.metadata.reference.base.BaseMetadataReference;
import id.go.ojk.util.metadata.reference.lblt.ILbltReferenceValidation;
import id.go.ojk.util.metadata.reference.lblt.LbltMetadataReference;
import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.function.Supplier;

import static id.go.ojk.util.FieldBuilder.programs;
import static id.go.ojk.util.constants.ProgramType.*;

@AllArgsConstructor
public enum EDtumValidationsConfig implements ILbltReferenceValidation {

    SG_REGEX_ALL(programs(ALL), () -> UtilSegmentValidation.genRegexAll("2",
            UtilMetadata.genPipeRowExcept(ER7000PosLtlbDppkDtum.getObjects(), new int[] {6, 13}))),

    SG_REGEX_DATE(programs(ALL), () -> UtilSegmentValidation.genRegexDate("2",
            UtilMetadata.genPipeRow(ER7000PosLtlbDppkDtum.getObjects(), new int[] {6, 13}))),

    SG_REGEX_DATA_LEN_1(programs(ALL), () -> UtilSegmentValidation.genLength("2",
            UtilMetadata.genPipeRow(ER7000PosLtlbDppkDtum.getObjects(), new int[] {4, 5}), 1, 20)),

    SG_REGEX_DATA_LEN_2(programs(ALL), () -> UtilSegmentValidation.genLength("2",
            UtilMetadata.genPipeRow(ER7000PosLtlbDppkDtum.getObjects(), new int[] {0}),1, 500)),

    SG_REGEX_DATA_LEN_3(programs(ALL), () -> UtilSegmentValidation.genLength("2",
            UtilMetadata.genPipeRow(ER7000PosLtlbDppkDtum.getObjects(), new int[] {6, 13}), 8, 10)),

    SG_REGEX_DATA_LEN_4(programs(ALL), () -> UtilSegmentValidation.genLength("2",
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

    public static final BaseMetadataReference<EDtumValidationsConfig> METADATA =
            new LbltMetadataReference<>(EDtumValidationsConfig.class, ALL);
}
