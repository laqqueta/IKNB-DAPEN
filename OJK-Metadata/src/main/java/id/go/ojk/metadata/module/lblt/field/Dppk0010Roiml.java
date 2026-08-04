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
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataLkdpDplk;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataLkdpPpipk;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataLkdpPpmpk;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataLkdpPpmpm;
import id.go.ojk.metadata.module.lblt.reference.ER7010PosLtlbDppkRoiml;
import id.go.ojk.metadata.module.lblt.validations.E7010RoimlValidationsConfig;
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
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0010Roiml implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, PPIPM, DPLK),
            sf(1, null, "Kode Komponen", sv(M, 15, 15, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
                    .confUnique(UniqueType.U)),

    KODE_KOMPONEN_GABUNGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
            sf(1, null, "Kode Komponen", sv(M, 15, 15, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))),

    HASIL_INVESTASI_TEREALISASI_BUNGA_BAGI_HASIL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(2, null, "Hasil investasi yang terealisasi Bunga/ Bagi Hasil", sv(M, 1, 18, numeric))),

    HASIL_INVESTASI_TEREALISASI_DIVIDEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(3, null, "Hasil investasi yang terealisasi Dividen", sv(M, 1, 18, numeric))),

    HASIL_INVESTASI_TEREALISASI_SEWA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(4, null, "Hasil investasi yang terealisasi Sewa", sv(M, 1, 18, numeric))),

    HASIL_INVESTASI_TEREALISASI_LABA_RUGI_PELEPASAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(5, null, "Hasil investasi yang terealisasi Laba/Rugi Pelepasan", sv(M, 1, 18, numeric))),

    HASIL_INVESTASI_TEREALISASI_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(6, null, "Hasil investasi yang terealisasi Lainnya", sv(M, 1, 18, numeric))),

    HASIL_INVESTASI_BELUM_TEREALISASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(7, null, "Hasil Investasi yang Belum Terealisasi", sv(M, 1, 18, numeric))),

    BEBAN_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(8, null, "Beban Investasi", sv(M, 1, 18, numeric))),

    HASIL_INVESTASI_BERSIH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(9, null, "Hasil investasi bersih", sv(M, 1, 18, numericNegatif))),

    RATA_RATA_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(10, null, "Rata-rata Investasi", sv(M, 1, 18, numeric))),

    ROI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(11, null, "ROI", sv(M, 3, 18, numericDot))),

    /* Gabungan Additional Field */

    JENIS_PROGRAM(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
            sf(1000, null, "Jenis Program", sv(M, 5, 5, alfa))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataLkdpPpmpk.R7010Roiml.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataLkdpPpmpm.R7010Roiml.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataLkdpPpipk.R7010Roiml.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkdpDplk.R7010Roiml.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0010Roiml> FIELD_METADATA = new LbltMetadataField<>(Dppk0010Roiml.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan ROIML_FORM = EFormLaporanBulananTahunan.LTLB_ROI_ML;
        return SubmissionFormatBuilder.builder()
                .code(ROIML_FORM.getCode())
                .name(ROIML_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(programType.toString())
                .maxRow(ER7010PosLtlbDppkRoiml.getRowSize(programType))
                .minRow(ER7010PosLtlbDppkRoiml.getRowSize(programType))
                .fields(new ArrayList<>())
                .build();
    }

    public static SubmissionFormat formMetadata(SectorType sectorType, ProgramType programType) {
        FIELD_METADATA.setProgramType(programType);

        ReferenceConfig referenceConfig = ER7010PosLtlbDppkRoiml.Configs.REF_CONFIG;

        BaseMetadataValidation<? extends ILbltMetadataValidation> metadataValidation =
                E7010RoimlValidationsConfig.getValidationMetadata(programType);

        switch (programType) {
            case PPMPK:
            case PPMPM:
            case PPIPK:
            case DPLK:
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
//                .setReferenceConfigs(ER7010PosLtlbDppkRoiml.Configs.REF_CONFIG)
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
