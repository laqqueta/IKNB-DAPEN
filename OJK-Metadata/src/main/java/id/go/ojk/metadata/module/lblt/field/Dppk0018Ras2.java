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
import id.go.ojk.metadata.module.lblt.validations.gabungan.E7018Ras2GabunganValidationsConfig;
import id.go.ojk.metadata.submission.base.BaseSubmissionConfig;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.util.constants.SectorType;
import id.go.ojk.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.metadata.submission.SubmissionConfig;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.metadata.validation.lblt.ILbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;
import static id.go.ojk.metadata.module.lblt.validations.dplk.E7018Ras2ValidationsConfig.VALIDATION_METADATA_DPLK;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0018Ras2 implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric)
                    .confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(1, null, "Kode Komponen", sv(M, 14, 14, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
                    .confUnique(UniqueType.U)),

    KODE_KOMPONEN_GABUNGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
            sf(1, null, "Kode Komponen", sv(M, 14, 14, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))),

    REALISASI_TAHUN_SEBELUMNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(2, null, "Realisasi Tahun Sebelumnya", sv(C, 1, 18, numeric))),

    ANGGARAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(3, null, "Anggaran", sv(C, 1, 18, freeText))),

    REALISASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(4, null, "Realisasi", sv(C, 1, 18, freeText))),

    /* Gabungan Additional Field */

    JENIS_PROGRAM(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
            sf(1000, null, "Jenis Program", sv(M, 4, 4, alfa)
                    .confConstant("PPMP|PPIP"))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataLkdpPpmpk.R7018Ras2.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataLkdpPpmpm.R7018Ras2.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataLkdpPpipk.R7018Ras2.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataLkdpPpipm.R7018Ras2.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkdpDplk.R7018Ras2.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPPPIPK, EHeaderMetadataLkdpPpmpppipk.R7020Ras2.getObject())
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

        BaseMetadataValidation<? extends ILbltMetadataValidation> metadataValidation = E7018Ras2ValidationsConfig.getValidationMetadata(programType);
        ReferenceConfig referenceConfig = ER7018PosLtlbDppkRas2.getRefConfig(programType);
        BaseSubmissionConfig.Config<?> submissionConfig = new SubmissionConfig(programType).config()
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType));

        switch (programType) {
            case PPMPK:
            case PPMPM:
            case PPIPK:
            case PPIPM:
            case DPLK:
                if (programType.equals(DPLK)) metadataValidation = VALIDATION_METADATA_DPLK;
                submissionConfig
                        .setReferenceConfigs(referenceConfig)
                        .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
                        .setSegmentValidations(metadataValidation);
                break;
            case PPMPPPIPK:
                List<Integer> gabunganField = Arrays.asList(0, 1, 1000, 2, 3, 4);
                metadataValidation = E7018Ras2GabunganValidationsConfig.VALIDATION_METADATA_PPMPPPIPK;
                submissionConfig
                        .setReferenceConfigs(referenceConfig)
                        .setSubmissionField(FIELD_METADATA.getReindexFields(gabunganField, metadataValidation.getFieldValidations()))
                        .setSegmentValidations(metadataValidation);
                break;
            default:
                throw new IllegalStateException();

        }

        return submissionConfig.build().get();
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