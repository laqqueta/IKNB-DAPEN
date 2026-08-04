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
import id.go.ojk.metadata.module.lblt.reference.ER7005PosLtlbDppkLak;
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
import static id.go.ojk.metadata.module.lblt.validations.dplk.E7005LakKValidationsConfig.VALIDATION_METADATA_DPLK;
import static id.go.ojk.metadata.module.lblt.validations.ppipik.E7005LakKValidationsConfig.VALIDATION_METADATA_PPIPK;
import static id.go.ojk.metadata.module.lblt.validations.ppipm.E7005LakMValidationsConfig.VALIDATION_METADATA_PPIPM;
import static id.go.ojk.metadata.module.lblt.validations.ppmpk.E7005LakKValidationsConfig.VALIDATION_METADATA_PPMPK;
import static id.go.ojk.metadata.module.lblt.validations.ppmpm.E7005LakMValidationsConfig.VALIDATION_METADATA_PPMPM;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0005Lak implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(1, null, "Kode Komponen", sv(M, 13, 13, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
                    .confUnique(UniqueType.U)),

    KODE_KOMPONEN_GABUNGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
            sf(1, null, "Kode Komponen", sv(M, 13, 13, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))),

    AKUMULASI_MANFAAT_PENSIUN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(2, null, "Akumulasi s.d DD-MM-YYYY - Manfaat Pensiun", sv(M, 1, 18, all2))),

    AKUMULASI_MANFAAT_PENSIUN_LAINNYA_MANFAAT_TAMBAHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(3, null, "Akumulasi s.d DD-MM-YYYY - Manfaat Pensiun Lainnya Manfaat Tambahan", sv(M, 1, 18, all2))),

    AKUMULASI_MANFAAT_PENSIUN_LAINNYA_KOMPENSASI_PASCAKERJA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(4, null, "Akumulasi s.d DD-MM-YYYY - Manfaat Pensiun Lainnya Kompensasi Pascakerja", sv(M, 1, 18, all2))),

    AKUMULASI_MANFAAT_PENSIUN_LAINNYA_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(5, null, "Akumulasi s.d DD-MM-YYYY - Manfaat Pensiun Lainnya Lainnya", sv(M, 1, 18, all2))),

    AKUMULASI_MANFAAT_LAIN_KOMPENSASI_PASCAKERJA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(6, null, "Akumulasi s.d DD-MM-YYYY - Manfaat Lain Kompensasi Pascakerja", sv(M, 1, 18, all2))),

    AKUMULASI_MANFAAT_LAIN_KESEHATAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(7, null, "Akumulasi s.d DD-MM-YYYY - Manfaat Lain Kesehatan", sv(M, 1, 18, all2))),

    AKUMULASI_MANFAAT_LAIN_SANTUNAN_KEMATIAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(8, null, "Akumulasi s.d DD-MM-YYYY - Manfaat Lain Santunan Kematian", sv(M, 1, 18, all2))),

    AKUMULASI_MANFAAT_LAIN_IBADAH_KEAGAMAAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(9, null, "Akumulasi s.d DD-MM-YYYY - Manfaat Lain Ibadah Keagamaan", sv(M, 1, 18, all2))),

    AKUMULASI_MANFAAT_LAIN_PENDIDIKAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(10, null, "Akumulasi s.d DD-MM-YYYY - Manfaat Lain Pendidikan", sv(M, 1, 18, all2))),

    AKUMULASI_MANFAAT_LAIN_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(11, null, "Akumulasi s.d DD-MM-YYYY - Manfaat Lain Lainnya", sv(M, 1, 18, all2))),

    AKUMULASI_GABUNGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK, PPMPPPIPK),
            sf(12, null, "Akumulasi s.d DD-MM-YYYY - Gabungan", sv(M, 1, 18, all2))),

    UUS_MANFAAT_PENSIUN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPMPPPIPK),
            sf(13, null, "UUS - Manfaat Pensiun", sv(M, 1, 18, all2))),

    UUS_MANFAAT_PENSIUN_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPMPPPIPK),
            sf(14, null, "UUS - Manfaat Pensiun Lainnya", sv(M, 1, 18, all2))),

    UUS_MANFAAT_LAIN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPMPPPIPK),
            sf(15, null, "UUS - Manfaat Lain", sv(M, 1, 18, all2))),

    TOTAL(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPMPPPIPK),
            sf(16, null, "Total", sv(M, 1, 18, all2))),

    /* Gabungan Additional Field */

    JENIS_PROGRAM(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
            sf(1000, null, "Jenis Program", sv(M, 5, 5, alfa))),
    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataLkdpPpmpk.R7005Lak.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataLkdpPpmpm.R7005Lak.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataLkdpPpipk.R7005Lak.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataLkdpPpipm.R7005Lak.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkdpDplk.R7005Lak.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0005Lak> FIELD_METADATA = new LbltMetadataField<>(Dppk0005Lak.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan LAK_FORM = EFormLaporanBulananTahunan.LTLB_LAK;
        return SubmissionFormatBuilder.builder()
                .code(LAK_FORM.getCode())
                .name(LAK_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(programType.toString())
                .maxRow(ER7005PosLtlbDppkLak.getRowSize(programType))
                .minRow(ER7005PosLtlbDppkLak.getRowSize(programType))
                .fields(new ArrayList<>())
                .build();
    }

    public static SubmissionFormat formMetadata(SectorType sectorType, ProgramType programType) {
        FIELD_METADATA.setProgramType(programType);

        BaseMetadataValidation<? extends ILbltMetadataValidation> metadataValidation = null;
        ReferenceConfig referenceConfig = ER7005PosLtlbDppkLak.getRefConfig(programType);

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