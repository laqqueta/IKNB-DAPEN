package id.go.ojk.metadata.module.lblt.dppk.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.metadata.module.lblt.dppk.field.Dppk0121Lcf;
import id.go.ojk.metadata.module.lblt.dppk.reference.ER7201PosLtlbDppkLcf;
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

import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7201PosLtlbDppkLcf.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7201LcfValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 5),
                    UtilMetadata.genPlusRow(ER7201PosLtlbDppkLcf.getObjects(), 0, 4), R_LCF0700000000.key,
                    UtilMetadata.genMessageTotal(UtilMetadata.genPlusDesc(ER7201PosLtlbDppkLcf.getObjects(), 0, 4), R_LCF0700000000.value))),

    CR_COL_EMPTY_1(programs(PPIPM),
            validationFields(Dppk0121Lcf.JUMLAH_PESERTA),
            () -> UtilFieldConditional.genExistPos("M", "N", R_LCF0100000000.key)),

    CR_COL_EMPTY_2(programs(PPIPM),
            validationFields(Dppk0121Lcf.HASIL_INVESTASI_TERLEASISASI, Dppk0121Lcf.HASIL_INVESTASI_BELUM_TERLEASISASI,
                    Dppk0121Lcf.BEBAN_INVESATASI),
            () -> UtilFieldConditional.genExistPos("N", "M", R_LCF0100000000.key)),

    CR_COL_EMPTY_3(programs(PPIPM),
            validationFields(Dppk0121Lcf.HASIL_INVESTASI_BERSIH, Dppk0121Lcf.RATA_RATA_INVESTASI, Dppk0121Lcf.ROI),
            () -> UtilFieldConditional.genExistPos("N", "M",
                    UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 6 }))),

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

    public static final BaseMetadataValidation<E7201LcfValidationsConfig> VALIDATION_METADATA_PPIPM =
            new LbltMetadataValidation<>(E7201LcfValidationsConfig.class, PPIPM);

}
