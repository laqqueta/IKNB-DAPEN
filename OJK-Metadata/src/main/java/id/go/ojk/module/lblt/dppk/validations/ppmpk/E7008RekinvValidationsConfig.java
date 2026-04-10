package id.go.ojk.module.lblt.dppk.validations.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.module.lblt.dppk.reference.ER7008PosLtlbDppkRekinv;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.function.Supplier;

import static id.go.ojk.module.lblt.dppk.reference.ER7008PosLtlbDppkRekinv.R_REKINV2100000000;
import static id.go.ojk.util.FieldUtil.programs;
import static id.go.ojk.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
public enum E7008RekinvValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_SUM_POS_EQUAL(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13),
            R_REKINV2100000000.getObject().getKey(),
            UtilMetadata.genPlusRow(ER7008PosLtlbDppkRekinv.getObjects(ProgramType.PPMPK), 0, 19),
            UtilMetadata.genMessage(R_REKINV2100000000.getObject().getValue(),
                    UtilMetadata.genPlusRow(ER7008PosLtlbDppkRekinv.getObjects(ProgramType.PPMPK), 0, 19))))

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

    public static final BaseMetadataValidation<E7008RekinvValidationsConfig> METADATA =
            new LbltMetadataValidation<>(E7008RekinvValidationsConfig.class, PPMPK);

}
