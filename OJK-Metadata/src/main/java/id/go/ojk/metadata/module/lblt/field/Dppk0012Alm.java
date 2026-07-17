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
import id.go.ojk.metadata.module.lblt.header.*;
import id.go.ojk.metadata.module.lblt.reference.ER7012PosLtlbDppkAlm;
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
import static id.go.ojk.metadata.module.lblt.validations.dplk.E7012AlmKValidationsConfig.VALIDATION_METADATA_DPLK;
import static id.go.ojk.metadata.module.lblt.validations.ppipik.E7012AlmKValidationsConfig.VALIDATION_METADATA_PPIPK;
import static id.go.ojk.metadata.module.lblt.validations.ppipm.E7012AlmMValidationsConfig.VALIDATION_METADATA_PPIPM;
import static id.go.ojk.metadata.module.lblt.validations.ppmpk.E7012AlmKValidationsConfig.VALIDATION_METADATA_PPMPK;
import static id.go.ojk.metadata.module.lblt.validations.ppmpm.E7012AlmMValidationsConfig.VALIDATION_METADATA_PPMPM;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0012Alm implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(1, null, "Kode Komponen", sv(M, 13, 13, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
                    .confUnique(UniqueType.U)),

    JT_LT_1_TAHUN_RUPIAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(2, null, "Jatuh tempo < 1 tahun - Rupiah", sv(M, 1, 18, numeric))),

    JT_LT_1_TAHUN_NON_RUPIAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(3, null, "Jatuh tempo < 1 tahun - Non Rupiah", sv(M, 1, 18, numeric))),

    JT_LT_1_TAHUN_TOTAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(4, null, "Jatuh tempo < 1 tahun - Total", sv(C, 1, 18, numeric))),

    JT_LT_1_TAHUN_TOTAL_PPIPK(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(4, null, "Jatuh tempo < 1 tahun - Total", sv(M, 1, 18, numeric))),

    JT_1_5_TAHUN_RUPIAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(5, null, "1 tahun <= jatuh tempo < 5 tahun - Rupiah", sv(M, 1, 18, numeric))),

    JT_1_5_TAHUN_NON_RUPIAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(6, null, "1 tahun <= jatuh tempo < 5 tahun - Non Rupiah", sv(M, 1, 18, numeric))),

    JT_1_5_TAHUN_TOTAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(7, null, "1 tahun <= jatuh tempo < 5 tahun - Total", sv(C, 1, 18, numeric))),

    JT_1_5_TAHUN_TOTAL_PPIPK(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(7, null, "1 tahun <= jatuh tempo < 5 tahun - Total", sv(M, 1, 18, numeric))),

    JT_5_10_TAHUN_RUPIAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(8, null, "5 tahun <= jatuh tempo < 10 tahun - Rupiah", sv(M, 1, 18, numeric))),

    JT_5_10_TAHUN_NON_RUPIAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(9, null, "5 tahun <= jatuh tempo < 10 tahun - Non Rupiah", sv(M, 1, 18, numeric))),

    JT_5_10_TAHUN_TOTAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(10, null, "5 tahun <= jatuh tempo < 10 tahun - Total", sv(C, 1, 18, numeric))),

    JT_5_10_TAHUN_TOTAL_PPIPK(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(10, null, "5 tahun <= jatuh tempo < 10 tahun - Total", sv(M, 1, 18, numeric))),

    JT_GTE_10_TAHUN_RUPIAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(11, null, "Jatuh Tempo >= 10 Tahun - Rupiah", sv(M, 1, 18, numeric))),

    JT_GTE_10_TAHUN_NON_RUPIAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(12, null, "Jatuh Tempo >= 10 - Non Rupiah", sv(M, 1, 18, numeric))),

    JT_GTE_10_TAHUN_TOTAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(13, null, "Jatuh Tempo >= 10 - Total", sv(C, 1, 18, numeric))),

    JT_GTE_10_TAHUN_TOTAL_PPIPK(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(13, null, "Jatuh Tempo >= 10 - Total", sv(M, 1, 18, numeric))),

    TOTAL_RUPIAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(14, null, "Total - Rupiah", sv(M, 1, 18, numeric))),

    TOTAL_NON_RUPIAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(15, null, "Total - Non Rupiah", sv(M, 1, 18, numeric))),

    TOTAL_TOTAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(16, null, "Total - Total", sv(C, 1, 18, numeric))),

    TOTAL_TOTAL_PPIPK(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(16, null, "Total - Total", sv(M, 1, 18, numeric))),
    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7012Alm.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7012Alm.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataPpipk.R7012Alm.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataPpipm.R7012Alm.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkbtDplk.R7012Alm.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0012Alm> FIELD_METADATA = new LbltMetadataField<>(Dppk0012Alm.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan ALM_FORM = EFormLaporanBulananTahunan.LTLB_ALM;
        int minMaxRow = ER7012PosLtlbDppkAlm.getRowSize(programType);
        return SubmissionFormatBuilder.builder()
                .code(ALM_FORM.getCode())
                .name(ALM_FORM.getName())
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
        ReferenceConfig referenceConfig = null;

        switch (programType) {
            case PPMPK:
                metadataValidation = VALIDATION_METADATA_PPMPK;
                referenceConfig = ER7012PosLtlbDppkAlm.Configs.REF_CONFIG_PPMPK;
                break;
            case PPMPM:
                metadataValidation = VALIDATION_METADATA_PPMPM;
                referenceConfig = ER7012PosLtlbDppkAlm.Configs.REF_CONFIG_PPMPM;
                break;
            case PPIPK:
                metadataValidation = VALIDATION_METADATA_PPIPK;
                referenceConfig = ER7012PosLtlbDppkAlm.Configs.REF_CONFIG_PPIPK;
                break;
            case PPIPM:
                metadataValidation = VALIDATION_METADATA_PPIPM;
                referenceConfig = ER7012PosLtlbDppkAlm.Configs.REF_CONFIG_PPIPM;
                break;
            case DPLK:
                referenceConfig = ER7012PosLtlbDppkAlm.Configs.REF_CONFIG_DPLK;
                metadataValidation = VALIDATION_METADATA_DPLK;
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