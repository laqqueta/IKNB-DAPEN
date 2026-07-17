package id.go.ojk.metadata.module.lblt.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.header.*;
import id.go.ojk.metadata.module.lblt.reference.ER7018PosLtlbDppkRas2;
import id.go.ojk.metadata.module.lblt.validations.E7018Ras2ValidationsConfig;
import id.go.ojk.metadata.submission.base.BaseSubmissionConfig;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.util.constants.SectorType;
import id.go.ojk.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.metadata.submission.SubmissionConfig;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0018Ras2 implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric)
                    .confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(1, null, "Kode Komponen", sv(M, 14, 14, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
                    .confUnique(UniqueType.U)),

    REALISASI_TAHUN_SEBELUMNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(2, null, "Realisasi Tahun Sebelumnya", sv(C, 1, 18, numeric))),

    ANGGARAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(3, null, "Anggaran", sv(C, 1, 18, all2))),

    REALISASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(4, null, "Realisasi", sv(C, 1, 18, all2))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7018Ras2.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7018Ras2.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataPpipk.R7018Ras2.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataPpipm.R7018Ras2.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkbtDplk.R7018Ras2.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0018Ras2> FIELD_METADATA = new LbltMetadataField<>(Dppk0018Ras2.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan RAS2_FORM = EFormLaporanBulananTahunan.LTLB_RAS_2;
        return SubmissionFormatBuilder.builder()
                .code(RAS2_FORM.getCode())
                .name(RAS2_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(programType.toString())
                .maxRow(ER7018PosLtlbDppkRas2.getRowSize(programType))
                .minRow(ER7018PosLtlbDppkRas2.getRowSize(programType))
                .fields(new ArrayList<>())
                .build();
    }

    public static SubmissionFormat formMetadata(SectorType sectorType, ProgramType programType) {
        FIELD_METADATA.setProgramType(programType);

        BaseMetadataValidation<E7018Ras2ValidationsConfig> metadataValidation = null;
        ReferenceConfig referenceConfig = ER7018PosLtlbDppkRas2.Configs.REF_CONFIG;

        switch (programType) {
            case PPMPK:
                metadataValidation = E7018Ras2ValidationsConfig.VALIDATION_METADATA_PPMPK;
                break;
            case PPMPM:
                metadataValidation = E7018Ras2ValidationsConfig.VALIDATION_METADATA_PPMPM;
                break;
            case PPIPK:
                metadataValidation = E7018Ras2ValidationsConfig.VALIDATION_METADATA_PPIPK;
                break;
            case PPIPM:
                metadataValidation = E7018Ras2ValidationsConfig.VALIDATION_METADATA_PPIPM;
                break;
            case DPLK:
                referenceConfig = ER7018PosLtlbDppkRas2.Configs.REF_CONFIG_DPLK;
                metadataValidation = E7018Ras2ValidationsConfig.VALIDATION_METADATA_DPLK;
                break;
            default:
                throw new IllegalStateException();

        }

        BaseSubmissionConfig.Config<?> submissionConfig = new SubmissionConfig(programType).config()
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType))
                .setReferenceConfigs(referenceConfig)
                .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
                .setSegmentValidations(metadataValidation);

//        if (programType == DPLK) {
//            submissionConfig
//                    .setSubmissionField(FIELD_METADATA.getClearedFields())
//                    .setSegmentValidations();
//        } else {
//            submissionConfig
//                    .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
//                    .setSegmentValidations(metadataValidation);
//        }

        return submissionConfig.build().get();

//        return new SubmissionConfig(programType)
//                .config()
//                .setReferenceConfigs(ER7018PosLtlbDppkRas2.Configs.REF_CONFIG)
//                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType))
//                .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
//                .setSegmentValidations(metadataValidation)
//                .build()
//                .get();
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