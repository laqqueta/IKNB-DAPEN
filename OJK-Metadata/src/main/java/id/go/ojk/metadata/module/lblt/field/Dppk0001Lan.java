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
import java.util.stream.Stream;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
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

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric)
                    .confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(1, null, "Kode Komponen", sv(M, 13, 13, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
                    .confUnique(UniqueType.U)),

    PERSENTASE_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(2, null, "Persentase Investasi", sv(C, 4, 6, numericDot))),

    MANFAAT_PENSIUN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(3, null, "Manfaat Pensiun", sv(M, 1, 18, numeric))),

    MANFAAT_PENSIUN_LAINNYA_MANFAAT_TAMBAHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK),
            sf(4, null, "Manfaat Pensiun Lainnya Manfaat Tambahan", sv(M, 1, 18, numeric))),

    MANFAAT_PENSIUN_LAINNYA_KOMPENSASI_PASCAKERJA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK),
            sf(5, null, "Manfaat Pensiun Lainnya Kompensasi Pascakerja", sv(M, 1, 18, numeric))),

    MANFAAT_PENSIUN_LAINNYA_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK),
            sf(6, null, "Manfaat Pensiun Lainnya Lainnya", sv(M, 1, 18, numeric))),

    MANFAAT_LAIN_KOMPENSASI_PASCAKERJA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK),
            sf(7, null, "Manfaat Lain Kompensasi Pascakerja", sv(M, 1, 18, numeric))),

    MANFAAT_LAIN_KESEHATAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK),
            sf(8, null, "Manfaat Lain Kesehatan", sv(M, 1, 18, numeric))),

    MANFAAT_LAIN_SANTUNAN_KEMATIAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK),
            sf(9, null, "Manfaat Lain Santunan Kematian", sv(M, 1, 18, numeric))),

    MANFAAT_LAIN_IBADAH_KEAGAMAAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK),
            sf(10, null, "Manfaat Lain Ibadah Keagamaan", sv(M, 1, 18, numeric))),

    MANFAAT_LAIN_PENDIDIKAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK),
            sf(11, null, "Manfaat Lain Pendidikan", sv(M, 1, 18, numeric))),

    MANFAAT_LAIN_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK),
            sf(12, null, "Manfaat Lain Lainnya", sv(M, 1, 18, numeric))),

    GABUNGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK),
            sf(13, null, "Gabungan", sv(M, 1, 18, numeric))),

    UUS_MANFAAT_PENSIUN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK),
            sf(14, null, "UUS - Manfaat Pensiun", sv(M, 1, 18, all2))),

    UUS_MANFAAT_PENSIUN_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK),
            sf(15, null, "UUS - Manfaat Pensiun Lainnya", sv(M, 1, 18, all2))),

    UUS_MANFAAT_LAIN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK),
            sf(16, null, "UUS - Manfaat Lain", sv(M, 1, 18, all2))),

    TOTAL(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK),
            sf(17, null, "Total", sv(M, 1, 18, all2))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7001Lan.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7001Lan.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataPpipk.R7001Lan.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataPpipm.R7001Lan.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkbtDplk.R7001Lan.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0001Lan> FIELD_METADATA = new LbltMetadataField<>(Dppk0001Lan.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan LAN_FORM = EFormLaporanBulananTahunan.LTLB_LAN;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(LAN_FORM.getCode())
                .name(LAN_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(programType.toString())
                .maxRow(49)
                .fields(new ArrayList<>())
                .build();

        if (sectorType.equals(KONVENSIONAL) || sectorType.equals(SYARIAH)) {
            sfConfig.setMinRow(49);
            return sfConfig;
        }

        throw new IllegalArgumentException("Unknown sector type: " + sectorType);
    }

    public static SubmissionFormat formMetadata(SectorType sectorType, ProgramType programType) {
        FIELD_METADATA.setProgramType(programType);

        BaseMetadataValidation<? extends ILbltMetadataValidation> metadataValidation = null;
        ReferenceConfig referenceConfig = null;

        switch (programType) {
            case PPMPK:
                metadataValidation = VALIDATION_METADATA_PPMPK;
                referenceConfig = ER7001PosLtlbDppkLan.Configs.REF_CONFIG_PPMPK;
                break;
            case PPMPM:
                metadataValidation = VALIDATION_METADATA_PPMPM;
                referenceConfig = ER7001PosLtlbDppkLan.Configs.REF_CONFIG_PPMPM;
                break;
            case PPIPK:
                metadataValidation = VALIDATION_METADATA_PPIPK;
                referenceConfig = ER7001PosLtlbDppkLan.Configs.REF_CONFIG_PPIPK;
                break;
            case PPIPM:
                metadataValidation = VALIDATION_METADATA_PPIPM;
                referenceConfig = ER7001PosLtlbDppkLan.Configs.REF_CONFIG_PPIPM;
                break;
            case DPLK:
                referenceConfig = ER7001PosLtlbDppkLan.Configs.REF_CONFIG_DPLK;
                break;
            default:
                throw new IllegalStateException();
        }

        BaseSubmissionConfig.Config<?> submissionConfig = new SubmissionConfig(programType).config()
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
//                .setReferenceConfigs(referenceConfig)
//                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType))
//                .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
//                .setSegmentValidations(metadataValidation).build()
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