package id.go.ojk.module.lblt.dppk.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.reference.ER7008PosLtlbDppkRekinv;
import id.go.ojk.module.lblt.dppk.reference.ER7009PosLtlbDppkRoi;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.metadata.validation.IValidationConverter;
import id.go.ojk.util.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.ILbltMetadataValidation;
import id.go.ojk.util.metadata.validation.lblt.LbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.function.Supplier;

import static id.go.ojk.module.lblt.dppk.reference.ER7009PosLtlbDppkRoi.R_ROI2100000000;
import static id.go.ojk.util.FieldUtil.programs;
import static id.go.ojk.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
public enum E7009RoiValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    FV_FIELD_VALIDATION_1(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(2, 7) + "-8")),

    FV_FIELD_VALIDATION_2(programs(PPMPK),
            () -> UtilFieldValidation.genEqualsExceptPosFormula("9/10", R_ROI2100000000.key, 2)),

    SG_GEO_MEAN(programs(PPMPK),
            () -> {
                String errMsg = UtilMetadata.genDelimitedColumn(2, 13, "*") + "|3|14|" + "REKINV kode baris ";
                String formRow = UtilMetadata.genPipeRow(ER7008PosLtlbDppkRekinv.getObjects(ProgramType.PPMPK), 0, 19);
                return UtilSegmentValidation.genGeoMeanInvestasi("10",
                        UtilMetadata.genPipeRow(ER7009PosLtlbDppkRoi.getObjects(), 0, 19),
                        EFormLaporanBulananTahunan.LTLB_REKINV.getCode(), formRow,
                        UtilMetadata.genPipeColumn(2, 13), errMsg, formRow);
            }),

    SG_SUM_POS_COL_EQUAL(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula(
                    UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 5, 6, 7, 8, 10, 11}), R_ROI2100000000.key,
                    UtilMetadata.genPlusRow(ER7009PosLtlbDppkRoi.getObjects(), 0, 19),
                    UtilMetadata.genMessage(R_ROI2100000000.value, UtilMetadata.genPlusDesc(ER7009PosLtlbDppkRoi.getObjects(), 0, 19)))),

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

    public static final BaseMetadataValidation<E7009RoiValidationsConfig> METADATA =
            new LbltMetadataValidation<>(E7009RoiValidationsConfig.class, PPMPK);

}
