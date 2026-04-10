package id.go.ojk.module.lblt.dppk.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1255JenisManfaat;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.reference.ER7001PosLtlbDppkLan;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.function.Supplier;

import static id.go.ojk.module.lblt.dppk.reference.ER7016PosLtlbDppkSbn.*;
import static id.go.ojk.util.FieldUtil.programs;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;

@AllArgsConstructor
public enum E7016SbnValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("10", R_SBN000000.key, R_SBN010000.key,
                    UtilMetadata.genMessageTotal(R_SBN000000.value, R_SBN010000.value))),

    SG_EQUAL_SBN_RATION(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsSbnRatio("9", R_SBN020000.key,
                    R_SBN000000.key, "10", EFormLaporanBulananTahunan.LTLB_LAN.getCode(),
                    ER7001PosLtlbDppkLan.R_LAN0102000000.getObject().getKey(), "13",
                    UtilMetadata.genMessage(R_SBN020000.value, R_SBN020000.value + "/Total Investasi (Gabungan) pada form LAN"), 2)),

    SG_EQUAL_SBN_RATION_1(programs(PPMPM),
            () -> UtilSegmentValidation.genEqualsSbnRatio("9", R_SBN020000.key,
                    R_SBN000000.key, "10", EFormLaporanBulananTahunan.LTLB_LAN.getCode(),
                    ER7001PosLtlbDppkLan.R_LAN0102000000.getObject().getKey(), "13",
                    UtilMetadata.genMessage(R_SBN020000.value, R_SBN020000.value + "/Total Investasi (Gabungan) pada form LAN"), 2)),

    CR_FOR_SALDO(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "M", R_SBN000000.key)),

    CR_FOR_SBN(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "M", R_SBN020000.key)),

    CR_FOR_TOTAL(programs(PPMPK),
            () -> UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 1, 2 }))),

    CR_MANFAAT_LAIN(programs(PPMPK),
            () -> UtilFieldConditional.genEquals("M", "N", "4",
                    ER1255JenisManfaat.getReferenceIndex(11))),

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
        return METADATA.toSegmentValidation(this);
    }

    @Override
    public FieldValidation toFieldValidation() {
        return METADATA.toFieldValidation(this);
    }

    @Override
    public ConditionalRequired toFieldConditional() {
        return METADATA.toFieldConditional(this);
    }

    public static final BaseMetadataValidation<E7016SbnValidationsConfig> METADATA =
            new LbltMetadataValidation<>(E7016SbnValidationsConfig.class, PPMPK);

}
