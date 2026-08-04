package id.go.ojk.metadata.module.lblt.validations.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.UtilSegmentValidationV2;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataSharedLblt;
import id.go.ojk.metadata.module.lblt.reference.ER7001PosLtlbDppkLan;
import id.go.ojk.metadata.module.lblt.reference.ER7007PosLtlbDppkKup;
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

import static id.go.ojk.metadata.module.lblt.reference.ER7007PosLtlbDppkKup.*;
import static id.go.ojk.metadata.module.lblt.reference.ER7007PosLtlbDppkKup.getObjects;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7007KupKValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_SUM_POS_1(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5),
                    R_KUP0201020000.getObject().getKey(),
                    R_KUP0201010000.getObject().getKey(),
                    UtilMetadata.genMessageTotal(R_KUP0201020000.getObject().getValue(),
                            R_KUP0201010000.getObject().getValue()))),

    SG_EQUAL_SUM_POS_2(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5),
                    R_KUP0203020000.getObject().getKey(),
                    R_KUP0203010000.getObject().getKey(),
                    UtilMetadata.genMessageTotal(R_KUP0203020000.getObject().getValue(),
                            R_KUP0203010000.getObject().getValue()))),

    SG_EQUAL_SUM_POS_3(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5),
                    R_KUP0204020000.getObject().getKey(),
                    R_KUP0204010000.getObject().getKey(),
                    UtilMetadata.genMessageTotal(R_KUP0204020000.getObject().getValue(),
                            R_KUP0204010000.getObject().getValue()))),

    SG_EQUAL_SUM_POS_4(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5),
                    R_KUP0205020000.getObject().getKey(),
                    R_KUP0205010000.getObject().getKey(),
                    UtilMetadata.genMessageTotal(R_KUP0205020000.getObject().getValue(),
                            R_KUP0205010000.getObject().getValue()))),

    SG_EQUAL_ROW_PLUS_1(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5),
                    R_KUP0202040000.getObject().getKey(),
                    UtilMetadata.genPlusRow(getObjects(ProgramType.PPMPK), 3, 5),
                    UtilMetadata.genMessage(R_KUP0202040000.getObject().getValue(),
                            UtilMetadata.genPlusDesc(getObjects(ProgramType.PPMPK), 3, 5)))),

    SG_EQUAL_ROW_PLUS_2(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5),
                    R_KUP0200000100.getObject().getKey(),
                    UtilMetadata.genPlusRow(getObjects(ProgramType.PPMPK), new int[]{2, 6, 8, 10, 12}),
                    UtilMetadata.genMessage(R_KUP0200000100.getObject().getValue(),
                            UtilMetadata.genPlusDesc(getObjects(ProgramType.PPMPK), new int[]{2, 6, 8, 10, 12})))),

    SG_EQUAL_ROW_MINUS_3(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5),
                    R_KUP0200000200.getObject().getKey(),
                    UtilMetadata.genMinusRow(getObjects(ProgramType.PPMPK), new int[]{0, 13}),
                    UtilMetadata.genMessage(R_KUP0200000200.getObject().getValue(),
                            UtilMetadata.genPlusDesc(getObjects(ProgramType.PPMPK), new int[]{0, 13})))),

    SG_EQUAL_FORM_LAN(programs(PPMPK),
            () -> UtilSegmentValidationV2.genEqualsForm("3|4|5",
                    R_KUP0100000000.getObject().getKey(), EFormLaporanBulananTahunan.LTLB_LAN.getCode(),
                    "3", ER7001PosLtlbDppkLan.R_LAN0111000000.getObject().getKey(),
                    UtilMetadata.genMessage(R_KUP0100000000.getObject().getValue(), ER7001PosLtlbDppkLan.R_LAN0111000000.getObject().getValue()) +
                            " pada for LAN")),

    SG_VALIDATION_PROYEKSI_PENDANAAN(programs(PPMPK),
            () -> UtilSegmentValidationV2.genOperatorProyeksi("3|4|5",
                    R_KUP0209000000.getObject().getKey(),
                    String.format("%1$s<%2$s|%1$s>%3$s",
                            R_KUP0200000200.getObject().getKey(),
                            R_KUP0206000000.getObject().getKey(),
                            R_KUP0207000000.getObject().getKey()),
                    "III|I", "II")),

    SG_REF_KODE_PENDANAAN(programs(PPMPK),
            () -> UtilSegmentValidation.genReference("3|4|5",
                    UtilMetadata.genPipeRow(getObjects(ProgramType.PPMPK), new int[]{19}),
                    EHeaderMetadataSharedLblt.R023.getNumber())),

    SG_ROW_DATA_TYPE_NUMERIC_1(programs(PPMPK), () ->
            UtilSegmentValidation.genRegexNumeric("3|4|5",
                    UtilMetadata.genPipeRow(getObjects(PPMPK), new int[] { 1, 7, 9, 11 }))),

    SG_ROW_DATA_TYPE_NUMERIC_2(programs(PPMPK), () ->
            UtilSegmentValidation.genRegexNumeric("3|4|5",
                    UtilMetadata.genPipeRowExcept(getObjects(PPMPK), new int[] { 0, 1, 7, 9, 11, 14, 18, 19}))),

    SG_ROW_DATA_TYPE_NUMERIC_NEGATIVE(programs(PPMPK), () ->
            UtilSegmentValidation.genRegexNumericNegative("3|4|5",
                    UtilMetadata.genPipeRow(getObjects(PPMPK), new int[] { 0, 14 }))),

    SG_ROW_DATA_TYPE_ALFA_NUMERIC(programs(PPMPK), () ->
            UtilSegmentValidation.genRegexAlfaNumeric("3|4|5",
                    UtilMetadata.genPipeRow(getObjects(PPMPK), new int[] { 19 }))),

    SG_ROW_DATA_TYPE_ALFA(programs(PPMPK), () ->
            UtilSegmentValidation.genRegexAlfa("3|4|5",
                    UtilMetadata.genPipeRow(getObjects(PPMPK), new int[] { 18 }))),

    CR_URAIAN(programs(PPMPK), validationFields(2),
            () -> UtilFieldConditional.genExistPos("M", "N",
                    UtilMetadata.genPipeRow(ER7007PosLtlbDppkKup.getObjects(ProgramType.PPMPK), new int[]{1, 7, 9, 11})));

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

    public static final BaseMetadataValidation<E7007KupKValidationsConfig> VALIDATION_METADATA_PPMPK =
            new LbltMetadataValidation<>(E7007KupKValidationsConfig.class, PPMPK);
}
