package id.go.ojk.metadata.module.lblt.dppk.validations.ppmpk;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.IValidation;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1268JenisInvestasi;
import id.go.ojk.metadata.module.lblt.dppk.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.dppk.reference.ER7001PosLtlbDppkLan;
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

import static id.go.ojk.metadata.module.lblt.dppk.reference.ER7016PosLtlbDppkSbn.*;
import static id.go.ojk.metadata.util.FieldUtil.programs;
import static id.go.ojk.metadata.util.FieldUtil.validationFields;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPK;

@AllArgsConstructor
@RequiredArgsConstructor
public enum E7016SbnKValidationsConfig implements ILbltMetadataValidation, IValidationConverter {

    SG_EQUAL_FORMULA(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsFormula("10", R_SBN000000.key, R_SBN010000.key,
                    UtilMetadata.genMessageTotal(R_SBN000000.value, R_SBN010000.value))),

    SG_EQUAL_SBN_RATION(programs(PPMPK),
            () -> UtilSegmentValidation.genEqualsSbnRatio("9", R_SBN020000.key,
                    R_SBN000000.key, "10", EFormLaporanBulananTahunan.LTLB_LAN.getCode(),
                    ER7001PosLtlbDppkLan.R_LAN0102000000.getObject().getKey(), "13",
                    UtilMetadata.genMessage(R_SBN020000.value, R_SBN020000.value + "/Total Investasi (Gabungan) pada form LAN"), 2)),

    CR_FOR_SALDO(programs(PPMPK), validationFields(10),
            () -> UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRow(getObjects(), new int[]{0, 1}))),

    CR_FOR_SBN(programs(PPMPK), validationFields(9),
            () -> UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRow(getObjects(), new int[]{0, 2}))),

    CR_FOR_TOTAL(programs(PPMPK), validationFields(2, 3, 8),
            () -> UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[]{1, 2}))),

//    CR_JENIS_INVESTASI_VALUE_OBLIGASI(programs(PPMPK),
//            () -> UtilFieldConditional.genEquals("M", "N", "2",
//                    ER1268JenisInvestasi.getReferenceIndex(1))),

    CR_JENIS_INVESTASI_VALUE_OBLIGASI(programs(PPMPK), validationFields(4, 5, 6),
            () -> UtilFieldConditional.genExistPosAndComparatorHasValueDapenVer("O", "M", "N",
                    R_SBN010000.key, "2", ER1268JenisInvestasi.getReferenceIndex(1))),

//    CR_JENIS_INVESTASI_VALUE_SBN(programs(PPMPK),
//            () -> UtilFieldConditional.genEquals("M", "N", "2",
//                    ER1268JenisInvestasi.getReferenceIndex(2))),

    CR_JENIS_INVESTASI_VALUE_SBN(programs(PPMPK), validationFields(7),
            () -> UtilFieldConditional.genExistPosAndComparatorHasValueDapenVer("O", "M", "N",
                    R_SBN010000.key, "2", ER1268JenisInvestasi.getReferenceIndex(2) + "|" + ER1268JenisInvestasi.getReferenceIndex(3))),

//    CR_JENIS_INVESTASI_VALUE_REKSADANA(programs(PPMPK),
//            () -> UtilFieldConditional.genEquals("M", "N", "2",
//                    ER1268JenisInvestasi.getReferenceIndex(3))),

    CR_JENIS_INVESTASI_VALUE_REKSADANA(programs(PPMPK), validationFields(11),
            () -> UtilFieldConditional.genExistPosAndComparatorHasValueDapenVer("O", "M", "N",
                    R_SBN010000.key, "2", ER1268JenisInvestasi.getReferenceIndex(3))),

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

    public static final BaseMetadataValidation<E7016SbnKValidationsConfig> VALIDATION_METADATA_PPMPK =
            new LbltMetadataValidation<>(E7016SbnKValidationsConfig.class, PPMPK);

}
