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
import id.go.ojk.metadata.module.lblt.reference.ER7001PosLtlbDppkLan;
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
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.metadata.module.lblt.validations.dplk.E7001LanKValidationsConfig.VALIDATION_METADATA_DPLK;
import static id.go.ojk.metadata.module.lblt.validations.ppipik.E7001LanKValidationsConfig.VALIDATION_METADATA_PPIPK;
import static id.go.ojk.metadata.module.lblt.validations.ppipm.E7001LanMValidationsConfig.VALIDATION_METADATA_PPIPM;
import static id.go.ojk.metadata.module.lblt.validations.ppmpk.E7001LanKValidationsConfig.VALIDATION_METADATA_PPMPK;
import static id.go.ojk.metadata.module.lblt.validations.ppmpm.E7001LanMValidationsConfig.VALIDATION_METADATA_PPMPM;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0001Lan implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric)
                    .confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(1, null, "Kode Komponen", sv(M, 13, 13, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
                    .confUnique(UniqueType.U)),

    KODE_KOMPONEN_GABUNGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
            sf(1, null, "Kode Komponen", sv(M, 13, 13, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))),

    PERSENTASE_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(2, null, "Persentase Investasi", sv(C, 4, 6, freeText))),

    MANFAAT_PENSIUN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(3, null, "Manfaat Pensiun", sv(M, 1, 18, freeText))),

    MANFAAT_PENSIUN_LAINNYA_MANFAAT_TAMBAHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(4, null, "Manfaat Pensiun Lainnya Manfaat Tambahan", sv(M, 1, 18, freeText))),

    MANFAAT_PENSIUN_LAINNYA_KOMPENSASI_PASCAKERJA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(5, null, "Manfaat Pensiun Lainnya Kompensasi Pascakerja", sv(M, 1, 18, freeText))),

    MANFAAT_PENSIUN_LAINNYA_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(6, null, "Manfaat Pensiun Lainnya Lainnya", sv(M, 1, 18, freeText))),

    MANFAAT_LAIN_KOMPENSASI_PASCAKERJA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(7, null, "Manfaat Lain Kompensasi Pascakerja", sv(M, 1, 18, freeText))),

    MANFAAT_LAIN_KESEHATAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(8, null, "Manfaat Lain Kesehatan", sv(M, 1, 18, freeText))),

    MANFAAT_LAIN_SANTUNAN_KEMATIAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(9, null, "Manfaat Lain Santunan Kematian", sv(M, 1, 18, freeText))),

    MANFAAT_LAIN_IBADAH_KEAGAMAAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(10, null, "Manfaat Lain Ibadah Keagamaan", sv(M, 1, 18, freeText))),

    MANFAAT_LAIN_PENDIDIKAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(11, null, "Manfaat Lain Pendidikan", sv(M, 1, 18, freeText))),

    MANFAAT_LAIN_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(12, null, "Manfaat Lain Lainnya", sv(M, 1, 18, freeText))),

    GABUNGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(13, null, "Gabungan", sv(M, 1, 18, freeText))),

    /* Additional for PPIPK Program Type */

    UUS_MANFAAT_PENSIUN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPMPPPIPK),
            sf(14, null, "UUS - Manfaat Pensiun", sv(M, 1, 18, freeText))),

    UUS_MANFAAT_PENSIUN_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPMPPPIPK),
            sf(15, null, "UUS - Manfaat Pensiun Lainnya", sv(M, 1, 18, freeText))),

    UUS_MANFAAT_LAIN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPMPPPIPK),
            sf(16, null, "UUS - Manfaat Lain", sv(M, 1, 18, freeText))),

    TOTAL(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPMPPPIPK),
            sf(17, null, "Total", sv(M, 1, 18, freeText))),

    /* Additional GABUNGAN FIELDS */

    JENIS_PROGRAM(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
            sf(1000, null, "Jenis Program", sv(M, 5, 5, alfa))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataLkdpPpmpk.R7001Lan.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataLkdpPpmpm.R7001Lan.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataLkdpPpipk.R7001Lan.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataLkdpPpipm.R7001Lan.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkdpDplk.R7001Lan.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPPPIPK, EHeaderMetadataLkdpPpmpppipk.R7501Lan.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0001Lan> FIELD_METADATA = new LbltMetadataField<>(Dppk0001Lan.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan LAN_FORM = EFormLaporanBulananTahunan.LTLB_LAN;
        int minMaxRow = ER7001PosLtlbDppkLan.getRowSize(programType);
        return SubmissionFormatBuilder.builder()
                .code(LAN_FORM.getCode())
                .name(LAN_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(programType.toString())
                .maxRow(minMaxRow)
                .minRow(minMaxRow)
                .fields(new ArrayList<>())
                .build();
    }

    public static SubmissionFormat formMetadata(SectorType sectorType, ProgramType programType) {
        FIELD_METADATA.setProgramType(programType);

        BaseMetadataValidation<? extends ILbltMetadataValidation> metadataValidation = null;
        ReferenceConfig referenceConfig = ER7001PosLtlbDppkLan.getRefConfig(programType);

        switch (programType) {
            case PPMPK:
                metadataValidation = VALIDATION_METADATA_PPMPK;
                break;
            case PPMPM:
                metadataValidation = VALIDATION_METADATA_PPMPM;
                break;
            case PPIPK:
                metadataValidation = VALIDATION_METADATA_PPIPK;
                break;
            case PPIPM:
                metadataValidation = VALIDATION_METADATA_PPIPM;
                break;
            case DPLK:
                metadataValidation = VALIDATION_METADATA_DPLK;
                break;
            case PPMPPPIPK:
                break;
            default:
                throw new IllegalStateException();
        }

        BaseSubmissionConfig.Config<?> submissionConfig = new SubmissionConfig(programType).config()
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType))
                .setReferenceConfigs(referenceConfig);
//                .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
//                .setSegmentValidations(metadataValidation);

        if (programType == PPMPPPIPK) {
            // -> Ngambil field terbanyak
            List<Integer> gabunganField = Arrays.asList(0, 1, 1000, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
            submissionConfig
                    .setSubmissionField(FIELD_METADATA.getReindexClearedFields(gabunganField, true))
                    .setSegmentValidations();
        } else {
            submissionConfig
//                    .setReferenceConfigs(referenceConfig)
                    .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
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

    public static void main(String[] args) {
        FIELD_METADATA.setProgramType(DPLK);

        FIELD_METADATA.getFields().forEach(v -> {
            System.out.println(v.getName());
        });
    }

}