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
import id.go.ojk.metadata.module.lblt.reference.ER7009PosLtlbDppkRoi;
import id.go.ojk.metadata.module.lblt.validations.E7009RoiValidationsConfig;
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
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0009Roi implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(1, null, "Kode Komponen", sv(M, 13, 13, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
                    .confUnique(UniqueType.U)),

    HASIL_INVESTASI_TEREALISASI_BUNGA_BAGI_HASIL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(2, null, "Hasil investasi yang terealisasi Bunga/ Bagi Hasil", sv(M, 1, 18, numeric))),

    HASIL_INVESTASI_TEREALISASI_DIVIDEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(3, null, "Hasil investasi yang terealisasi Dividen", sv(M, 1, 18, numeric))),

    HASIL_INVESTASI_TEREALISASI_SEWA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(4, null, "Hasil investasi yang terealisasi Sewa", sv(M, 1, 18, numeric))),

    HASIL_INVESTASI_TEREALISASI_LABA_RUGI_PELEPASAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(5, null, "Hasil investasi yang terealisasi Laba/Rugi Pelepasan", sv(M, 1, 18, numeric))),

    HASIL_INVESTASI_TEREALISASI_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(6, null, "Hasil investasi yang terealisasi Lainnya", sv(M, 1, 18, numeric))),

    HASIL_INVESTASI_BELUM_TEREALISASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(7, null, "Hasil Investasi yang Belum Terealisasi", sv(M, 1, 18, numeric))),

    BEBAN_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(8, null, "Beban Investasi", sv(M, 1, 18, numeric))),

    HASIL_INVESTASI_BERSIH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(9, null, "Hasil investasi bersih", sv(M, 1, 18, numeric))),

    RATA_RATA_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(10, null, "Rata-rata Investasi", sv(M, 1, 18, all2))),

    ROI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(11, null, "ROI", sv(M, 3, 18, numericDot))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7009Roi.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7009Roi.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataPpipk.R7009Roi.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataPpipm.R7009Roi.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkbtDplk.R7009Roi.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0009Roi> FIELD_METADATA = new LbltMetadataField<>(Dppk0009Roi.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan ROI_FORM = EFormLaporanBulananTahunan.LTLB_ROI;
        return SubmissionFormatBuilder.builder()
                .code(ROI_FORM.getCode())
                .name(ROI_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(programType.toString())
                .maxRow(ER7009PosLtlbDppkRoi.getRowSize(programType))
                .minRow(ER7009PosLtlbDppkRoi.getRowSize(programType))
                .fields(new ArrayList<>())
                .build();
    }

    public static SubmissionFormat formMetadata(SectorType sectorType, ProgramType programType) {
        FIELD_METADATA.setProgramType(programType);

        BaseMetadataValidation<E7009RoiValidationsConfig> metadataValidation = E7009RoiValidationsConfig
                .getValidationMetadata(programType);

        ReferenceConfig referenceConfig = ER7009PosLtlbDppkRoi.Configs.REF_CONFIG;

        switch (programType) {
            case PPMPK:
            case PPMPM:
            case PPIPK:
            case PPIPM:
                break;
            case DPLK:
                referenceConfig = ER7009PosLtlbDppkRoi.Configs.REF_CONFIG_DPLK;
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
//                .setReferenceConfigs(ER7009PosLtlbDppkRoi.Configs.REF_CONFIG)
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
