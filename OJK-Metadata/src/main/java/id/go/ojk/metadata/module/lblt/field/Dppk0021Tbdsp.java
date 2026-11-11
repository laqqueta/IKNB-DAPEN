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
import id.go.ojk.metadata.module.lblt.validations.gabungan.E7021TbdspGabunganValidationsConfig;
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

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(1, null, "Kode Komponen", sv(M, 15, 15, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))),

    URAIAN_RINCIAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(2, null, "Uraian Rincian", sv(C, 1, 100, freeText))),

    JUMLAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(3, null, "Jumlah", sv(M, 1, 18, numeric))),

    KETERANGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(4, null, "keterangan", sv(C, 1, 250, freeText))),

    /* Gabungan Additional Field */

    JENIS_PROGRAM(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
            sf(1000, null, "Jenis Program", sv(M, 4, 4, alfa)
                    .confConstant("PPMP|PPIP"))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataLkdpPpmpk.R7021Tbdsp.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataLkdpPpmpm.R7021Tbdsp.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataLkdpPpipk.R7021Tbdsp.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataLkdpPpipm.R7021Tbdsp.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkdpDplk.R7021Tbdsp.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPPPIPK, EHeaderMetadataLkdpPpmpppipk.R7027Tbdsp.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0021Tbdsp> FIELD_METADATA = new LbltMetadataField<>(Dppk0021Tbdsp.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan TBDSP_FORM = EFormLaporanBulananTahunan.LTLB_TBDSP;
        return SubmissionFormatBuilder.builder()
                .code(TBDSP_FORM.getCode())
                .name(TBDSP_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(programType.toString())
                .minRow(7)
                .maxRow(null)
                .fields(new ArrayList<>())
                .build();
    }

    public static SubmissionFormat formMetadata(SectorType sectorType, ProgramType programType) {
        FIELD_METADATA.setProgramType(programType);

        BaseMetadataValidation<?> metadataValidation = E7021TbdspValidationsConfig.getValidationMetadata(programType);
        ReferenceConfig referenceConfig = ER7021PosLtlbDppkTbdsp.getRefConfig(programType);
        BaseSubmissionConfig.Config<?> submissionConfig = new SubmissionConfig(programType)
                .config()
                .setReferenceConfigs(referenceConfig)
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType));

        switch (programType) {
            case PPMPK:
            case PPMPM:
            case PPIPK:
            case PPIPM:
            case DPLK:
                submissionConfig
                        .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
                        .setSegmentValidations(metadataValidation);
                break;
            case PPMPPPIPK:
                List<Integer> gabunganField = Arrays.asList(0, 1, 1000, 2, 3, 4);
                metadataValidation = E7021TbdspGabunganValidationsConfig.VALIDATION_METADATA_PPMPPPIPK;
                submissionConfig
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