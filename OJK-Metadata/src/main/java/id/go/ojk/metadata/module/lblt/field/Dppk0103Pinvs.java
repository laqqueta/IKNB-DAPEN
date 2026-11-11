package id.go.ojk.metadata.module.lblt.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataLkdpDplk;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataLkdpPpipk;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataLkdpPpipm;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataLkdpPpmpppipk;
import id.go.ojk.metadata.module.lblt.reference.ER7103PosLtlbDppkPinvs;
import id.go.ojk.metadata.module.lblt.validations.E7103PinvsValidationsConfig;
import id.go.ojk.metadata.module.lblt.validations.gabungan.E7103PinvsGabunganValidationsConfig;
import id.go.ojk.metadata.submission.SubmissionConfig;
import id.go.ojk.metadata.submission.base.BaseSubmissionConfig;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.util.constants.SectorType;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0103Pinvs implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric)
                    .confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(1, null, "Kode Komponen", sv(M, 15, 15, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
                    .confUnique(UniqueType.U)),

    KODE_KOMPONEN_GABUNGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
            sf(1, null, "Kode Komponen", sv(M, 15, 15, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))),

    PAKET_A(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(2, null, "Paket Konvensional - Paket A", sv(M, 1, 18, numeric))),

    PAKET_B(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(3, null, "Paket Konvensional - Paket B", sv(M, 1, 18, numeric))),

    PAKET_C(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(4, null, "Paket Konvensional - Paket C", sv(M, 1, 18, numeric))),

    PAKET_D(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(5, null, "Paket Konvensional - Paket D", sv(M, 1, 18, numeric))),

    /* Gabungan Additional Field */

    JENIS_PROGRAM(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
            sf(1000, null, "Jenis Program", sv(M, 4, 4, alfa)
                    .confConstant("PPMP|PPIP"))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataLkdpPpipk.R7021Pinvs.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataLkdpPpipm.R7021Pinvs.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkdpDplk.R7021Pinvs.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPPPIPK, EHeaderMetadataLkdpPpmpppipk.R7022Pinvs.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private static final LbltMetadataField<Dppk0103Pinvs> FIELD_METADATA = new LbltMetadataField<>(Dppk0103Pinvs.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    private static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan form = EFormLaporanBulananTahunan.LTLB_PINVS;
        return SubmissionFormatBuilder.builder()
                .code(form.getCode())
                .name(form.getName())
                .extension(ExtensionType.TXT)
                .reportCode(programType.toString())
                .minRow(ER7103PosLtlbDppkPinvs.getRowSize(programType))
                .maxRow(ER7103PosLtlbDppkPinvs.getRowSize(programType))
                .fields(new ArrayList<>())
                .build();
    }

    public static SubmissionFormat formMetadata(SectorType sectorType, ProgramType programType) {
        FIELD_METADATA.setProgramType(programType);
        BaseMetadataValidation<?> metadataValidation = E7103PinvsValidationsConfig.getValidationMetadata(programType);
        ReferenceConfig referenceConfig = ER7103PosLtlbDppkPinvs.getRefConfig(programType);
        BaseSubmissionConfig.Config<?> submissionConfig = new SubmissionConfig(programType)
                .config()
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType))
                .setReferenceConfigs(referenceConfig);

        switch (programType) {
            case PPIPK:
            case PPIPM:
            case DPLK:
                submissionConfig
                        .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
                        .setSegmentValidations(metadataValidation);
                break;
            case PPMPPPIPK:
                metadataValidation = E7103PinvsGabunganValidationsConfig.VALIDATION_METADATA_PPMPPPIPK;
                List<Integer> gabunganFields = Arrays.asList(0, 1, 1000, 2, 3, 4, 5);
                submissionConfig
                        .setSubmissionField(FIELD_METADATA.getReindexFields(gabunganFields, metadataValidation.getFieldValidations()))
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