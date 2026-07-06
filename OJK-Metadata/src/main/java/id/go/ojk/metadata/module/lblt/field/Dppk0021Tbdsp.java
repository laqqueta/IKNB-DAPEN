package id.go.ojk.metadata.module.lblt.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.header.*;
import id.go.ojk.metadata.module.lblt.reference.ER7021PosLtlbDppkTbdsp;
import id.go.ojk.metadata.module.lblt.validations.E7021TbdspValidationsConfig;
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
public enum Dppk0021Tbdsp implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(1, null, "Kode Komponen", sv(M, 15, 15, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))),

    URAIAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(2, null, "Uraian", sv(C, 1, 100, freeText))),

    JUMLAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(3, null, "Jumlah", sv(M, 1, 18, numeric))),

    KETERANGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(4, null, "keterangan", sv(C, 1, 250, freeText))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7021Tbdsp.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7021Tbdsp.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataPpipk.R7021Tbdsp.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataPpipm.R7021Tbdsp.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkbtDplk.R7021Tbdsp.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0021Tbdsp> FIELD_METADATA = new LbltMetadataField<>(Dppk0021Tbdsp.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan TBDSP_FORM = EFormLaporanBulananTahunan.LTLB_TBDSP;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(TBDSP_FORM.getCode())
                .name(TBDSP_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(programType.toString())
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

        BaseMetadataValidation<E7021TbdspValidationsConfig> metadataValidation = null;
        ReferenceConfig referenceConfig = ER7021PosLtlbDppkTbdsp.Configs.REF_CONFIG;

        switch (programType) {
            case PPMPK:
                metadataValidation = E7021TbdspValidationsConfig.VALIDATION_METADATA_PPMPK;
                break;
            case PPMPM:
                metadataValidation = E7021TbdspValidationsConfig.VALIDATION_METADATA_PPMPM;
                break;
            case PPIPK:
                metadataValidation = E7021TbdspValidationsConfig.VALIDATION_METADATA_PPIPK;
                break;
            case PPIPM:
                metadataValidation = E7021TbdspValidationsConfig.VALIDATION_METADATA_PPIPM;
                break;
            case DPLK:
                referenceConfig = ER7021PosLtlbDppkTbdsp.Configs.REF_CONFIG_DPLK;
                break;
            default:
                throw new IllegalStateException();
        }

        BaseSubmissionConfig.Config<?> submissionConfig = new SubmissionConfig(programType)
                .config()
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType))
                .setReferenceConfigs(referenceConfig);

        if (programType == DPLK) {
            submissionConfig
                    .setSubmissionField(FIELD_METADATA.getClearedFields())
                    .setSegmentValidations();
        } else {
            submissionConfig
                    .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
                    .setSegmentValidations(metadataValidation);
        }

        return submissionConfig.build().get();

//        return new SubmissionConfig(programType)
//                .config()
//                .setReferenceConfigs(ER7021PosLtlbDppkTbdsp.Configs.REF_CONFIG)
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