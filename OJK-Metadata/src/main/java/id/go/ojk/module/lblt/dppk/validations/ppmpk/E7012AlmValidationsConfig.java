package id.go.ojk.module.lblt.dppk.validations.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.module.lblt.dppk.reference.ER7012PosLtlbDppkAlm;
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
import static id.go.ojk.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
public enum E7012AlmValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA_1(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    ER7012PosLtlbDppkAlm.R_ALM0121000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK), 0, 19),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0121000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK), 0, 19)))),

    SG_EQUAL_FORMULA_2(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    ER7012PosLtlbDppkAlm.R_ALM0211000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK), 21, 30),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0211000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK), 21, 30)))),

    SG_EQUAL_FORMULA_3(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    ER7012PosLtlbDppkAlm.R_ALM0306000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK), 32, 36),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0306000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK), 32, 36)))),

    SG_EQUAL_FORMULA_4(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 16),
                    ER7012PosLtlbDppkAlm.R_ALM0908000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK), 41, 47),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0908000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK), 41, 47)))),

    SG_EQUAL_FORMULA_5(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("16",
                    ER7012PosLtlbDppkAlm.R_ALM0500000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK), new int[]{20, 31, 37, 38}),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0500000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK), new int[]{20, 31, 37, 38})))),

    SG_EQUAL_FORMULA_6(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("16",
                    ER7012PosLtlbDppkAlm.R_ALM0800000000.getObject().getKey(),
                    UtilMetadata.genPlusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK), new int[]{40, 48}),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0800000000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK), new int[]{40, 48})))),

    SG_EQUAL_FORMULA_7(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("16",
                    ER7012PosLtlbDppkAlm.R_ALM0900000000.getObject().getKey(),
                    UtilMetadata.genMinusRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK), new int[]{39, 49}),
                    UtilMetadata.genMessage(ER7012PosLtlbDppkAlm.R_ALM0900000000.getObject().getValue(),
                            UtilMetadata.genMinusDesc(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK), new int[]{39, 49})))),

    FV_TOTAL1_EQUAL(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("2+5+8+11",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK),
                            new int[]{20, 31, 37, 38, 39, 40, 48, 49, 50, 51}))),

    FV_TOTAL2_EQUAL(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("3+6+9+12",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK),
                            new int[]{20, 31, 37, 38, 39, 40, 48, 49, 50, 51}))),

    FV_TOTAL3_EQUAL(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("14+15",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK),
                            new int[]{20, 31, 37, 38, 39, 40, 48, 49, 50, 51}))),

    FV_JTD_EQUAL(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("11+12",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK),
                            new int[]{20, 31, 37, 38, 39, 40, 48, 49, 50, 51}))),

    FV_JTC_EQUAL(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("8+9",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK),
                            new int[]{20, 31, 37, 38, 39, 40, 48, 49, 50, 51}))),

    FV_JTB_EQUAL(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("5+6",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK),
                            new int[]{20, 31, 37, 38, 39, 40, 48, 49, 50, 51}))),

    FV_JTA_EQUAL(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("2+3",
                    UtilMetadata.genPipeRow(ER7012PosLtlbDppkAlm.getObjects(ProgramType.PPMPK),
                            new int[]{20, 31, 37, 38, 39, 40, 48, 49, 50, 51}))),

    CR_PERCENTAGE(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "M", ER7012PosLtlbDppkAlm.R_ALM1000000000.getObject().getKey()))
    
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

    public static final BaseMetadataValidation<E7012AlmValidationsConfig> VALIDATION_METADATA =
            new LbltMetadataValidation<>(E7012AlmValidationsConfig.class, PPMPK);

}
