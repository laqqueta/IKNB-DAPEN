package id.go.ojk.metadata.module.lblt.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataPpipk;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataPpipm;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataPpmpk;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataPpmpm;
import id.go.ojk.metadata.module.lblt.reference.ER7017PosLtlbDppkRas1;
import id.go.ojk.metadata.submission.SubmissionConfig;
import id.go.ojk.metadata.submission.base.BaseSubmissionConfig;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.util.constants.SectorType;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.metadata.validation.lblt.ILbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.metadata.module.lblt.validations.ppipik.E7017Ras1KValidationsConfig.VALIDATION_METADATA_PPIPK;
import static id.go.ojk.metadata.module.lblt.validations.ppipik.E7017Ras1KValidationsConfig.genAllValidationRatioAB_PPIPK;
import static id.go.ojk.metadata.module.lblt.validations.ppipm.E7017Ras1MValidationsConfig.VALIDATION_METADATA_PPIPM;
import static id.go.ojk.metadata.module.lblt.validations.ppipm.E7017Ras1MValidationsConfig.genAllValidationRatioAB_PPIPM;
import static id.go.ojk.metadata.module.lblt.validations.ppmpk.E7017Ras1KValidationsConfig.VALIDATION_METADATA_PPMPK;
import static id.go.ojk.metadata.module.lblt.validations.ppmpk.E7017Ras1KValidationsConfig.genAllValidationRatioAB_PPMPK;
import static id.go.ojk.metadata.module.lblt.validations.ppmpm.E7017Ras1MValidationsConfig.VALIDATION_METADATA_PPMPM;
import static id.go.ojk.metadata.module.lblt.validations.ppmpm.E7017Ras1MValidationsConfig.genAllValidationRatioAB_PPMPM;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0017Ras1 implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(1, null, "Kode Komponen", sv(M, 14, 14, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
                    .confUnique(UniqueType.U)),

    MANFAAT_PENSIUN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK),
            sf(2, null, "Manfaat Pensiun", sv(M, 1, 18, freeText))),

    MANFAAT_PENSIUN_PPMPM_PPIPM(sectors(KONVENSIONAL, SYARIAH), programs(PPMPM, PPIPM),
            sf(2, null, "Manfaat Pensiun", sv(C, 1, 18, freeText))),

    MANFAAT_PENSIUN_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(3, null, "Manfaat Pensiun Lainnya", sv(M, 1, 18, freeText))),

    MANFAAT_LAIN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(4, null, "Manfaat lain", sv(M, 1, 18, freeText))),

    TOTAL_PPMP(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(5, null, "Total", sv(C, 1, 18, freeText))),

    TOTAL_PPIP(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK),
            sf(5, null, "Total", sv(M, 1, 18, freeText))),

    ;


    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7017Ras1.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7017Ras1.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataPpipk.R7017Ras1.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataPpipm.R7017Ras1.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0017Ras1> FIELD_METADATA =
            new LbltMetadataField<>(Dppk0017Ras1.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan RAS1_FORM = EFormLaporanBulananTahunan.LTLB_RAS_1;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(RAS1_FORM.getCode())
                .name(RAS1_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(reportCode)
                .maxRow(null)
                .fields(new ArrayList<>())
                .build();

        if (sectorType.equals(KONVENSIONAL) || sectorType.equals(SYARIAH)) {
            sfConfig.setMinRow(0);
            return sfConfig;
        }


        throw new IllegalArgumentException("Unknown sector type: " + sectorType);
    }

    public static SubmissionFormat formMetadata(SectorType sectorType, ProgramType programType) {
        FIELD_METADATA.setProgramType(programType);

        BaseMetadataValidation<? extends ILbltMetadataValidation> metadataValidation = null;
        List<SegmentValidation> additionalSegment = new ArrayList<>();
        ReferenceConfig referenceConfig = null;
        BaseSubmissionConfig.Config<? extends BaseSubmissionConfig.Config<?>> submssionConfig =
                new SubmissionConfig(programType.toString()).config();

        switch (programType) {
            case PPMPK:
                metadataValidation = VALIDATION_METADATA_PPMPK;
                referenceConfig = ER7017PosLtlbDppkRas1.Configs.REF_CONFIG_PPMPK;
                additionalSegment = genAllValidationRatioAB_PPMPK();
                break;
            case PPMPM:
                metadataValidation = VALIDATION_METADATA_PPMPM;
                referenceConfig = ER7017PosLtlbDppkRas1.Configs.REF_CONFIG_PPMPM;
                additionalSegment = genAllValidationRatioAB_PPMPM();
                break;
            case PPIPK:
                metadataValidation = VALIDATION_METADATA_PPIPK;
                referenceConfig = ER7017PosLtlbDppkRas1.Configs.REF_CONFIG_PPIPK;
                additionalSegment = genAllValidationRatioAB_PPIPK();
                break;
            case PPIPM:
                metadataValidation = VALIDATION_METADATA_PPIPM;
                referenceConfig = ER7017PosLtlbDppkRas1.Configs.REF_CONFIG_PPIPM;
                additionalSegment = genAllValidationRatioAB_PPIPM();;
                break;
            case DPLK:
                referenceConfig = ER7017PosLtlbDppkRas1.Configs.REF_CONFIG_DPLK;
                break;
            default:
                throw new IllegalStateException();
        }

        BaseSubmissionConfig.Config<?> submissionConfig = new SubmissionConfig(programType.toString()).config()
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType.toString()))
                .setReferenceConfigs(referenceConfig);

        if (programType == DPLK) {
            submissionConfig
                    .setSubmissionField(FIELD_METADATA.getClearedFields())
                    .setSegmentValidations();
        } else {
            submissionConfig
                    .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
                    .setSegmentValidations(metadataValidation)
                    .additionalSegmentValidations(additionalSegment);
        }

        return submissionConfig.build().get();

//        return new SubmissionConfig(programType.toString()).config()
//                .setReferenceConfigs(referenceConfig)
//                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType.toString()))
//                .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
//                .setSegmentValidations(metadataValidation)
//                .additionalSegmentValidations(additionalSegment)
//                .build().get();
    }

    @Override
    public SubmissionField getField() {
        return field;
    }

    @Override
    public EnumSet<SectorType> getSectorTypes() {
        return sectorType;
    }

    @Override
    public EnumSet<ProgramType> getProgramType() {
        return programType;
    }
}