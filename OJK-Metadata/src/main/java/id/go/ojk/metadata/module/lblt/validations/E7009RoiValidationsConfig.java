package id.go.ojk.metadata.module.lblt.validations;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.UtilSegmentValidationV2;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.field.Dppk0009Roi;
import id.go.ojk.metadata.module.lblt.reference.ER7008PosLtlbDppkRekinv;
import id.go.ojk.metadata.module.lblt.reference.ER7009PosLtlbDppkRoi;
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

import static id.go.ojk.metadata.module.lblt.reference.ER7009PosLtlbDppkRoi.R_ROI2100000000;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.*;

@RequiredArgsConstructor
@AllArgsConstructor
public enum E7009RoiValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    FV_FIELD_VALIDATION_1(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(9),
            () -> UtilFieldValidation.genEqualsFormula(UtilMetadata.genPlusColumn(2, 7) + "-8")),

    FV_FIELD_VALIDATION_2(programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK), validationFields(Dppk0009Roi.ROI),
            () -> UtilFieldValidation.genEqualsPosFormula3("9/10", 2,
                    UtilMetadata.genPipeRowExcept(ER7009PosLtlbDppkRoi.getObjects(), new int[] { 20 }))),

    SG_GEO_MEAN_PPMPK(programs(PPMPK),
            () -> {
                String colNames = "Jan*Feb*Mar*Apr*Mei*Jun*Jul*Agu*Sep*Okt*Nov*Des";
                String errMsg = colNames + "|Jan|Des|" + "REKINV Baris ";
                String formRow = UtilMetadata.genPipeRow(ER7008PosLtlbDppkRekinv.getObjects(ProgramType.PPMPK), 0, 19);
                String formRowDesc = UtilMetadata.genDelimitedDesc(ER7008PosLtlbDppkRekinv.getObjects(ProgramType.PPMPK), 0, 19, "|");
                return UtilSegmentValidationV2.genGeoMeanInvestasi("10",
                        UtilMetadata.genPipeRow(ER7009PosLtlbDppkRoi.getObjects(), 0, 19),
                        EFormLaporanBulananTahunan.LTLB_REKINV.getCode(), formRow,
                        UtilMetadata.genPipeColumn(2, 13), errMsg, formRowDesc);
            }),

    SG_GEO_MEAN_PPMPM(programs(PPMPM),
            () -> {
                String colNames = "Jan*Feb*Mar*Apr*Mei*Jun*Jul*Agu*Sep*Okt*Nov*Des";
                String errMsg = colNames + "|Jan|Des|" + "REKINV Baris ";
                String formRow = UtilMetadata.genPipeRow(ER7008PosLtlbDppkRekinv.getObjects(PPMPM), 0, 19);
                String formRowDesc = UtilMetadata.genDelimitedDesc(ER7008PosLtlbDppkRekinv.getObjects(PPMPM), 0, 19, "|");
                return UtilSegmentValidationV2.genGeoMeanInvestasi("10",
                        UtilMetadata.genPipeRow(ER7009PosLtlbDppkRoi.getObjects(), 0, 19),
                        EFormLaporanBulananTahunan.LTLB_REKINV.getCode(), formRow,
                        UtilMetadata.genPipeColumn(2, 13), errMsg, formRowDesc);
            }),

    SG_GEO_MEAN_PPIPK(programs(PPIPK),
            () -> {
                String colNames = "Jan*Feb*Mar*Apr*Mei*Jun*Jul*Agu*Sep*Okt*Nov*Des";
                String errMsg = colNames + "|Jan|Des|" + "REKINV Baris ";
                String formRow = UtilMetadata.genPipeRow(ER7008PosLtlbDppkRekinv.getObjects(PPIPK), 0, 19);
                String formRowDesc = UtilMetadata.genDelimitedDesc(ER7008PosLtlbDppkRekinv.getObjects(PPIPK), 0, 19, "|");
                return UtilSegmentValidationV2.genGeoMeanInvestasi("10",
                        UtilMetadata.genPipeRow(ER7009PosLtlbDppkRoi.getObjects(), 0, 19),
                        EFormLaporanBulananTahunan.LTLB_REKINV.getCode(), formRow,
                        UtilMetadata.genPipeColumn(2, 13), errMsg, formRowDesc);
            }),

    SG_GEO_MEAN_PPIPM(programs(PPIPM),
            () -> {
                String colNames = "Jan*Feb*Mar*Apr*Mei*Jun*Jul*Agu*Sep*Okt*Nov*Des";
                String errMsg = colNames + "|Jan|Des|" + "REKINV Baris ";
                String formRow = UtilMetadata.genPipeRow(ER7008PosLtlbDppkRekinv.getObjects(PPIPM), 0, 19);
                String formRowDesc = UtilMetadata.genDelimitedDesc(ER7008PosLtlbDppkRekinv.getObjects(PPIPM), 0, 19, "|");
                return UtilSegmentValidationV2.genGeoMeanInvestasi("10",
                        UtilMetadata.genPipeRow(ER7009PosLtlbDppkRoi.getObjects(), 0, 19),
                        EFormLaporanBulananTahunan.LTLB_REKINV.getCode(), formRow,
                        UtilMetadata.genPipeColumn(2, 13), errMsg, formRowDesc);
            }),

    SG_GEO_MEAN_DPLK(programs(DPLK),
            () -> {
                String colNames = "Jan*Feb*Mar*Apr*Mei*Jun*Jul*Agu*Sep*Okt*Nov*Des";
                String errMsg = colNames + "|Jan|Des|" + "REKINV Baris ";
                String formRow = UtilMetadata.genPipeRow(ER7008PosLtlbDppkRekinv.getObjects(DPLK), 0, 19);
                String formRowDesc = UtilMetadata.genDelimitedDesc(ER7008PosLtlbDppkRekinv.getObjects(DPLK), 0, 19, "|");
                return UtilSegmentValidationV2.genGeoMeanInvestasi("10",
                        UtilMetadata.genPipeRow(ER7009PosLtlbDppkRoi.getObjects(DPLK), 0, 19),
                        EFormLaporanBulananTahunan.LTLB_REKINV.getCode(), formRow,
                        UtilMetadata.genPipeColumn(2, 13), errMsg, formRowDesc);
            }),

    SG_SUM_POS_COL_EQUAL(programs(PPMPK, PPMPM, PPIPK, PPIPM),
            () -> UtilSegmentValidation.genEqualsFormula(
                    UtilMetadata.genPipeColumn(2, 11), R_ROI2100000000.key,
                    UtilMetadata.genPlusRow(ER7009PosLtlbDppkRoi.getObjects(), 0, 19),
                    UtilMetadata.genMessage(R_ROI2100000000.value, UtilMetadata.genPlusDesc(ER7009PosLtlbDppkRoi.getObjects(), 0, 19)))),

    SG_SUM_POS_COL_EQUAL_DPL(programs(DPLK),
            () -> UtilSegmentValidation.genEqualsFormula(
                    UtilMetadata.genPipeColumn(2, 11), R_ROI2100000000.key,
                    UtilMetadata.genPlusRow(ER7009PosLtlbDppkRoi.getObjects(DPLK), 0, 19),
                    UtilMetadata.genMessage(R_ROI2100000000.value, UtilMetadata.genPlusDesc(ER7009PosLtlbDppkRoi.getObjects(DPLK), 0, 19)))),

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

    public static BaseMetadataValidation<E7009RoiValidationsConfig> getValidationMetadata(ProgramType programType) {
        return new LbltMetadataValidation<>(E7009RoiValidationsConfig.class, programType);
    }

}
