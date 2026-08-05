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
import id.go.ojk.metadata.module.lblt.reference.ER7002PosLtlbDppkLpan;
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
import static id.go.ojk.metadata.module.lblt.validations.dplk.E7002LpanKValidationsConfig.VALIDATION_METADATA_DPLK;
import static id.go.ojk.metadata.module.lblt.validations.ppipik.E7002LpanKValidationsConfig.VALIDATION_METADATA_PPIPK;
import static id.go.ojk.metadata.module.lblt.validations.ppipm.E7002LpanMValidationsConfig.VALIDATION_METADATA_PPIPM;
import static id.go.ojk.metadata.module.lblt.validations.ppmpk.E7002LpanKValidationsConfig.VALIDATION_METADATA_PPMPK;
import static id.go.ojk.metadata.module.lblt.validations.ppmpm.E7002LpanMValidationsConfig.VALIDATION_METADATA_PPMPM;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.ProgramType.PPIPK;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0002Lpan implements ILbltFieldMetadata {

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

    MANFAAT_PENSIUN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(2, null, "Manfaat Pensiun", sv(M, 1, 18, numericNegatif))),

    MANFAAT_PENSIUN_LAINNYA_MANFAAT_TAMBAHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(3, null, "Manfaat Pensiun Lainnya Manfaat Tambahan", sv(M, 1, 18, numericNegatif))),

    MANFAAT_PENSIUN_LAINNYA_KOMPENSASI_PASCAKERJA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(4, null, "Manfaat Pensiun Lainnya Kompensasi Pascakerja", sv(M, 1, 18, numericNegatif))),

    MANFAAT_PENSIUN_LAINNYA_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(5, null, "Manfaat Pensiun Lainnya Lainnya", sv(M, 1, 18, numericNegatif))),

    MANFAAT_LAIN_KOMPENSASI_PASCAKERJA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(6, null, "Manfaat Lain Kompensasi Pascakerja", sv(M, 1, 18, numericNegatif))),

    MANFAAT_LAIN_KESEHATAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(7, null, "Manfaat Lain Kesehatan", sv(M, 1, 18, numericNegatif))),

    MANFAAT_LAIN_SANTUNAN_KEMATIAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(8, null, "Manfaat Lain Santunan Kematian", sv(M, 1, 18, numericNegatif))),

    MANFAAT_LAIN_IBADAH_KEAGAMAAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(9, null, "Manfaat Lain Ibadah Keagamaan", sv(M, 1, 18, numericNegatif))),

    MANFAAT_LAIN_PENDIDIKAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(10, null, "Manfaat Lain Pendidikan", sv(M, 1, 18, numericNegatif))),

    MANFAAT_LAIN_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(11, null, "Manfaat Lain Lainnya", sv(M, 1, 18, numericNegatif))),

    GABUNGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(12, null, "Gabungan", sv(M, 1, 18, numericNegatif))),

    UUS_MANFAAT_PENSIUN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPMPPPIPK),
            sf(13, null, "UUS - Manfaat Pensiun", sv(M, 1, 18, numericNegatif))),

    UUS_MANFAAT_PENSIUN_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPMPPPIPK),
            sf(14, null, "UUS - Manfaat Pensiun Lainnya", sv(M, 1, 18, numericNegatif))),

    UUS_MANFAAT_LAIN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPMPPPIPK),
            sf(15, null, "UUS - Manfaat Lain", sv(M, 1, 18, numericNegatif))),

    TOTAL(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPMPPPIPK),
            sf(16, null, "Total", sv(M, 1, 18, numericNegatif))),

    /* Gabungan Additional Field */

    JENIS_PROGRAM(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
            sf(1000, null, "Jenis Program", sv(M, 5, 5, alfa))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataLkdpPpmpk.R7002Lpan.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataLkdpPpmpm.R7002Lpan.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataLkdpPpipk.R7002Lpan.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataLkdpPpipm.R7002Lpan.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkdpDplk.R7002Lpan.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0002Lpan> FIELD_METADATA =
            new LbltMetadataField<>(Dppk0002Lpan.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan LPAN_FORM = EFormLaporanBulananTahunan.LTLB_LPAN;
        int minMaxRow = ER7002PosLtlbDppkLpan.getRowSize(programType);
        SubmissionFormatBuilder sf = SubmissionFormatBuilder.builder()
                .code(LPAN_FORM.getCode())
                .name(LPAN_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(programType.toString())
                .maxRow(minMaxRow)
                .minRow(minMaxRow)
                .fields(new ArrayList<>())
                .build();

        if (programType == PPMPPPIPK) {
            sf.setMaxRow(null);
            sf.setMinRow(0);
        }

        return sf;
    }

    public static SubmissionFormat formMetadata(SectorType sectorType, ProgramType programType) {
        FIELD_METADATA.setProgramType(programType);

        BaseMetadataValidation<? extends ILbltMetadataValidation> metadataValidation = null;
        ReferenceConfig referenceConfig = ER7002PosLtlbDppkLpan.getRefConfig(programType);

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
//                .setReferenceConfigs(referenceConfig)
//                .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
//                .setSegmentValidations(metadataValidation)
                ;

        if (programType == PPMPPPIPK) {
            List<Integer> gabunganField = Arrays.asList(0, 1, 1000, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
            submissionConfig
                    .setSubmissionField(FIELD_METADATA.getReindexClearedFields(gabunganField, true))
                    .setSegmentValidations();
        } else {
            submissionConfig
                    .setReferenceConfigs(referenceConfig)
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

    public static void main(String[] args) {
        FIELD_METADATA.setProgramType(DPLK);

        FIELD_METADATA.getFields().forEach(v -> {
            System.out.println(v.getName());
        });
    }

}