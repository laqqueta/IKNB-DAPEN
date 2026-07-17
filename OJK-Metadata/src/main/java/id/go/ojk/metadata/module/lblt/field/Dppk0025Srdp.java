package id.go.ojk.metadata.module.lblt.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.header.*;
import id.go.ojk.metadata.module.lblt.reference.ER7025PosLtlbDppkSrdp;
import id.go.ojk.metadata.module.lblt.validations.E7025SrdpValidationsConfig;
import id.go.ojk.metadata.submission.SubmissionConfig;
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
public enum Dppk0025Srdp implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric)
                    .confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(1, null, "Kode Komponen", sv(M, 10, 10, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))),

    NAMA_BANK(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(2, null, "Nama Bank", sv(C, 1, 100, freeText))),

    CABANG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(3, null, "Cabang", sv(C, 1, 100, freeText))),

    KODE_BANK(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(4, null, "Kode Bank", sv(C, 1, 6, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataSharedLkbt.R011.getObject()))),

    TANGGAL_PEROLEHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(5, null, "Tanggal Perolehan", sv(C, 8, 8, date))),

    NILAI_NOMINAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(6, null, "Nilai Nominal", sv(M, 1, 18, numeric))),

    JANGKA_WAKTU_HARI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(7, null, "Jangka Waktu (Hari)", sv(C, 1, 3, numeric))),

    TINGKAT_BUNGA_NISBAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(8, null, "Tingkat Bunga/Nisbah (%)", sv(C, 4, 6, numericDot))),

    MANFAAT_PENSIUN_LAINNYA_LAIN_LCF(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(9, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF", sv(C, 1, 6, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataSharedLkbt.R009.getObject()))),

    PENGELOLAAN_SWAKELOLA_KPD(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(10, null, "Pengelolaan Swakelola/ KPD", sv(C, 1, 6, refTable)
                    .confRegex(SimpleValidation.patternAlfa)
                    .confReference(EHeaderMetadataSharedLkbt.R006.getObject()))),

    PENGELOLAAN_NAMA_MANAJER_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(11, null, "Pengelolaan Nama Manajer Investasi", sv(C, 1, 250, freeText))),

    KETERANGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(12, null, "Keterangan", sv(C, 1, 250, freeText))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7025Srdp.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7025Srdp.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataPpipk.R7025Srdp.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataPpipm.R7025Srdp.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkbtDplk.R7025Srdp.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0025Srdp> FIELD_METADATA = new LbltMetadataField<>(Dppk0025Srdp.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan SRDP_FORM = EFormLaporanBulananTahunan.LTLB_SRDP;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(SRDP_FORM.getCode())
                .name(SRDP_FORM.getName())
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

        BaseMetadataValidation<E7025SrdpValidationsConfig> metadataValidation = null;

        switch (programType) {
            case PPMPK:
                metadataValidation = E7025SrdpValidationsConfig.VALIDATION_METADATA_PPMPK;
                break;
            case PPMPM:
                metadataValidation = E7025SrdpValidationsConfig.VALIDATION_METADATA_PPMPM;
                break;
            case PPIPK:
                metadataValidation = E7025SrdpValidationsConfig.VALIDATION_METADATA_PPIPK;
                break;
            case PPIPM:
                metadataValidation = E7025SrdpValidationsConfig.VALIDATION_METADATA_PPIPM;
                break;
            case DPLK:
                metadataValidation = E7025SrdpValidationsConfig.VALIDATION_METADATA_DPLK;
                break;
            default:
                throw new IllegalStateException();

        }

        return new SubmissionConfig(programType)
                .config()
                .setReferenceConfigs(ER7025PosLtlbDppkSrdp.Configs.REF_CONFIG)
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType))
                .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
                .setSegmentValidations(metadataValidation)
                .build()
                .get();
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