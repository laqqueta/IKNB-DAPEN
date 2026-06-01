package id.go.ojk.metadata.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.metadata.module.lblt.dppk.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.dppk.header.*;
import id.go.ojk.metadata.module.lblt.dppk.reference.ER7030PosLtlbDppkSukuk;
import id.go.ojk.metadata.module.lblt.dppk.validations.E7030SukukValidationsConfig;
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
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0030Sukuk implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(0, null, "Flag",
                    sv(M, 3, 3, alfaNumeric)
                            .confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(1, null, "Kode Komponen",
                    sv(M, 11, 11, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric))),

    NAMA_PENERBIT(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(2, null, "Nama Penerbit",
                    sv(C, 1, 100, freeText))),

    KODE_SUKUK(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(3, null, "Kode Sukuk",
                    sv(C, 1, 30, alfaNumeric))),

    NAMA_SUKUK(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(4, null, "Nama Sukuk",
                    sv(C, 1, 100, freeText))),

    TANGGAL_PEROLEHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(5, null, "Tanggal Perolehan",
                    sv(C, 8, 8, date))),

    NILAI_NOMINAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(6, null, "Nilai Nominal",
                    sv(M, 1, 18, numeric))),

    KUPON(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(7, null, "Kupon (%)",
                    sv(C, 4, 6, numericDot))),

    TANGGAL_JATUH_TEMPO(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(8, null, "Tanggal Jatuh Tempo",
                    sv(C, 8, 8, date))),

    PERINGKAT_AWAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(9, null, "Peringkat Awal",
                    sv(C, 1, 10, alfaNumeric))),

    PERINGKAT_AKHIR(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(10, null, "Peringkat Akhir",
                    sv(C, 1, 10, alfaNumeric))),

    NILAI_PEROLEHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(11, null, "Nilai Perolehan",
                    sv(M, 1, 18, numeric))),

    NILAI_WAJAR(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(12, null, "Nilai Wajar",
                    sv(M, 1, 18, numeric))),

    SELISIH_PENILAIAN_INVESTASI_NILAI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(13, null, "Selisih Penilaian Investasi Nilai",
                    sv(M, 1, 18, numeric))),

    SELISIH_PENILAIAN_INVESTASI_PERSEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(14, null, "Selisih Penilaian Investasi %",
                    sv(C, 4, 6, numericDot))),

    SEKTOR_EKONOMI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(15, null, "Sektor Ekonomi",
                    sv(C, 1, 6, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataSharedLkbt.R007.getObject()))),

    MANFAAT_PENSIUN_LAINNYA_LAIN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(16, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                    sv(C, 1, 6, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataSharedLkbt.R009.getObject()))),

    METODE_PENCATATAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(17, null, "Metode Pencatatan",
                    sv(C, 1, 6, refTable)
                            .confRegex(SimpleValidation.patternAlfa)
                            .confReference(EHeaderMetadataSharedLkbt.R005.getObject()))),

    PENGELOLAAN_SWAKELOLA_KPD(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(18, null, "Pengelolaan Swakelola/ KPD",
                    sv(C, 1, 6, refTable)
                            .confRegex(SimpleValidation.patternAlfa)
                            .confReference(EHeaderMetadataSharedLkbt.R006.getObject()))),

    PENGELOLAAN_NAMA_MANAJER_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(19, null, "Pengelolaan Nama Manajer Investasi",
                    sv(C, 1, 250, freeText)
            )),

    KETERANGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(20, null, "Keterangan",
                    sv(C, 1, 250, freeText))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7030Sukuk.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7030Sukuk.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataPpipk.R7030Sukuk.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataPpipm.R7030Sukuk.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0030Sukuk> FIELD_METADATA = new LbltMetadataField<>(Dppk0030Sukuk.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan SUKUK_FORM = EFormLaporanBulananTahunan.LTLB_SUKUK;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(SUKUK_FORM.getCode())
                .name(SUKUK_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(reportCode)
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

        BaseMetadataValidation<E7030SukukValidationsConfig> metadataValidation = null;

        switch (programType) {
            case PPMPK:
                metadataValidation = E7030SukukValidationsConfig.VALIDATION_METADATA_PPMPK;
                break;
            case PPMPM:
                metadataValidation = E7030SukukValidationsConfig.VALIDATION_METADATA_PPMPM;
                break;
            case PPIPK:
                metadataValidation = E7030SukukValidationsConfig.VALIDATION_METADATA_PPIPK;
                break;
            case PPIPM:
                metadataValidation = E7030SukukValidationsConfig.VALIDATION_METADATA_PPIPM;
                break;
            default:
                throw new IllegalStateException();
        }

        return new SubmissionConfig(programType.toString())
                .config()
                .setReferenceConfigs(ER7030PosLtlbDppkSukuk.Configs.REF_CONFIG)
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType.toString()))
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