package id.go.ojk.metadata.module.lblt.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.header.*;
import id.go.ojk.metadata.module.lblt.reference.ER7043PosLtlbDppkPiub;
import id.go.ojk.metadata.module.lblt.validations.E7043PiubValidationsConfig;
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
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0043Piub implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, PPMPPPIPK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric)
                    .confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, PPMPPPIPK),
            sf(1, null, "Kode Komponen", sv(M, 10, 10, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))),

    NAMA_PEMBERI_KERJA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, PPMPPPIPK),
            sf(2, null, "Nama Pemberi Kerja(Pendiri/Mitra Pendiri)", sv(C, 1, 100, freeText))),

    PIUTANG_BUNGA_IURAN_PESERTA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, PPMPPPIPK),
            sf(3, null, "Piutang Bunga Iuran Peserta", sv(M, 1, 18, numeric))),

    PIUTANG_BUNGA_IURAN_PEMBERI_KERJA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, PPMPPPIPK),
            sf(4, null, "Piutang Bunga Iuran Pemberi Kerja", sv(M, 1, 18, numeric))),

    PIUTANG_BUNGA_IURAN_TAMBAHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPMPPPIPK),
            sf(5, null, "Piutang Bunga Iuran Tambahan", sv(M, 1, 18, numeric))),

    MANFAAT_PENSIUN_LAINNYA_LAIN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, PPMPPPIPK),
            sf(6, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain", sv(C, 1, 6, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataSharedLblt.R009.getObject()))),

    KETERANGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, PPMPPPIPK),
            sf(7, null, "Keterangan", sv(C, 1, 250, freeText))),

    /* Gabungan Additional Field */

    JENIS_PROGRAM(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
            sf(1000, null, "Jenis Program", sv(M, 5, 5, alfa))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataLkdpPpmpk.R7043Piub.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataLkdpPpmpm.R7043Piub.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataLkdpPpipk.R7043Piub.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataLkdpPpipm.R7043Piub.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0043Piub> FIELD_METADATA = new LbltMetadataField<>(Dppk0043Piub.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan PIUB_FORM = EFormLaporanBulananTahunan.LTLB_PIUB;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(PIUB_FORM.getCode())
                .name(PIUB_FORM.getName())
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

        BaseMetadataValidation<E7043PiubValidationsConfig> metadataValidation = null;
        List<SubmissionField> submissionFields = null;
        ReferenceConfig referenceConfig = null;

        List<Integer> usedFieldIdx = Arrays.asList(0, 1, 2, 3, 4, 6, 7);

        switch (programType) {
            case PPMPK:
                metadataValidation = E7043PiubValidationsConfig.VALIDATION_METADATA_PPMPK;
                submissionFields = FIELD_METADATA.getFields(metadataValidation.getFieldValidations());
                referenceConfig = ER7043PosLtlbDppkPiub.Configs.REF_CONFIG_PPMP;
                break;
            case PPMPM:
                metadataValidation = E7043PiubValidationsConfig.VALIDATION_METADATA_PPMPM;
                submissionFields = FIELD_METADATA.getFields(metadataValidation.getFieldValidations());
                referenceConfig = ER7043PosLtlbDppkPiub.Configs.REF_CONFIG_PPMP;
                break;
            case PPIPK:
                metadataValidation = E7043PiubValidationsConfig.VALIDATION_METADATA_PPIPK;
                submissionFields = FIELD_METADATA.getReindexFields(usedFieldIdx, metadataValidation.getFieldValidations());
                referenceConfig = ER7043PosLtlbDppkPiub.Configs.REF_CONFIG_PPIP;
                break;
            case PPIPM:
                metadataValidation = E7043PiubValidationsConfig.VALIDATION_METADATA_PPIPM;
                submissionFields = FIELD_METADATA.getReindexFields(usedFieldIdx, metadataValidation.getFieldValidations());
                referenceConfig = ER7043PosLtlbDppkPiub.Configs.REF_CONFIG_PPIP;
                break;
            case PPMPPPIPK:
                break;
            default:
                throw new IllegalStateException();
        }

        BaseSubmissionConfig.Config<?> submissionConfig = new SubmissionConfig(programType).config()
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType))
//                .setSubmissionField(submissionFields)
//                .setSegmentValidations(metadataValidation)
                ;

        if (programType == PPMPPPIPK) {
            List<Integer> gabunganFields = Arrays.asList(0, 1, 1000, 2, 3, 4, 5, 6, 7);
            submissionConfig
                    .setSubmissionField(FIELD_METADATA.getReindexClearedFields(gabunganFields, true))
                    .setSegmentValidations();
        } else {
            submissionConfig
                    .setReferenceConfigs(referenceConfig)
                    .setSubmissionField(submissionFields)
                    .setSegmentValidations(metadataValidation);
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