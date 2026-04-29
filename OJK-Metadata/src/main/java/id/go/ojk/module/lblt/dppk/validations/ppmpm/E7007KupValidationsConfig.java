package id.go.ojk.module.lblt.dppk.validations.ppmpm;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataSharedLkbt;
import id.go.ojk.module.lblt.dppk.reference.ER7001PosLtlbDppkLan;
import id.go.ojk.module.lblt.dppk.reference.ER7007PosLtlbDppkKup;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.metadata.validation.ValidationConverter;
import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.function.Supplier;

import static id.go.ojk.module.lblt.dppk.reference.ER7007PosLtlbDppkKup.*;
import static id.go.ojk.util.FieldUtil.programs;
import static id.go.ojk.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
public enum E7007KupValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

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
            () -> UtilSegmentValidation.genEqualsForm("3|4|5",
                    R_KUP0100000000.getObject().getKey(),
                    EFormLaporanBulananTahunan.LTLB_LAN.getCode(),
                    "3",
                    ER7001PosLtlbDppkLan.R_LAN0110000000.getObject().getKey())),

    SG_REF_KODE_PENDANAAN(programs(PPMPK),
            () -> UtilSegmentValidation.genReference("3|4|5",
                    UtilMetadata.genPipeRow(getObjects(ProgramType.PPMPK), new int[]{19}),
                    EHeaderMetadataSharedLkbt.R023.getNumber())),

    SG_VALIDATION_PROYEKSI_PENDANAAN(programs(PPMPK),
            () -> UtilSegmentValidation.genOperatorProyeksi("3|4|5",
                    R_KUP0209000000.getObject().getKey(),
                    String.format("%1$s<%2$s|%1$s>%3$s",
                            R_KUP0200000200.getObject().getKey(),
                            R_KUP0206000000.getObject().getKey(),
                            R_KUP0207000000.getObject().getKey()),
                    "III|I", "II",
                    "msgErr", "defaultValueErr")),
    
    CR_URAIAN(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("M", "N",
                    UtilMetadata.genPipeRow(ER7007PosLtlbDppkKup.getObjects(ProgramType.PPMPK), new int[] { 1,7,9,11 })))

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

    public static final BaseMetadataValidation<E7007KupValidationsConfig> VALIDATION_METADATA =
            new LbltMetadataValidation<>(E7007KupValidationsConfig.class, PPMPK);

}
