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
import id.go.ojk.metadata.module.lblt.reference.ER7039PosLtlbDppkPnyl;
import id.go.ojk.metadata.module.lblt.validations.E7039PnylValidationsConfig;
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
public enum Dppk0039Pnyl implements ILbltFieldMetadata {
    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric)
                    .confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(1, null, "Kode Komponen", sv(M, 10, 10, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))),

    NAMA_PERUSAHAAN_1(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(2, null, "Nama Perusahaan (1)", sv(C, 1, 100, freeText))),

    PERWAKILAN_DANA_PENSIUN_NAMA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(3, null, "Perwakilan Dana Pensiun Nama", sv(C, 1, 100, freeText))),

    PERWAKILAN_DANA_PENSIUN_JABATAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(4, null, "Perwakilan Dana Pensiun Jabatan", sv(C, 1, 50, alfaNumeric))),

    KATEGORI_PENYERTAAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(5, null, "Kategori Penyertaan*)", sv(C, 1, 8, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataSharedLblt.R019.getObject()))),

    TANGGAL_PEROLEHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(6, null, "Tanggal Perolehan", sv(C, 8, 8, date))),

    PENEMPATAN_AWAL_TANGGAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(7, null, "Penempatan Awal Tanggal", sv(C, 8, 8, date))),

    PENEMPATAN_AWAL_PERSEN_KEPEMILIKAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(8, null, "Penempatan Awal % Kepemilikan", sv(C, 4, 6, numericDot))),

    PENEMPATAN_AWAL_TOTAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(9, null, "Penempatan Awal Total", sv(M, 1, 18, numeric))),

    NILAI_PEROLEHAN_PER_TANGGAL_LAPORAN_PERSEN_KEPEMILIKAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(10, null, "Nilai Perolehan Per tanggal laporan % Kepemilikan", sv(C, 4, 6, numericDot))),

    NILAI_PEROLEHAN_PER_TANGGAL_LAPORAN_TOTAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(11, null, "Nilai Perolehan Per tanggal laporan Total", sv(M, 1, 18, numeric))),

    NILAI_APPRASIAL_WAJAR_NAMA_PENILAI_PUBLIK_INDEPENDEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(12, null, "Nilai Apprasial/wajar Nama Penilai Publik/Independen", sv(C, 1, 100, freeText))),

    NILAI_APPRASIAL_WAJAR_TANGGAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(13, null, "Nilai Apprasial/wajar Tanggal", sv(C, 8, 8, date))),

    NILAI_APPRASIAL_WAJAR_PERSEN_KEPEMILIKAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(14, null, "Nilai Apprasial/wajar % Kepemilikan", sv(C, 4, 6, numericDot))),

    NILAI_APPRASIAL_WAJAR_TOTAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(15, null, "Nilai Apprasial/wajar Total", sv(M, 1, 18, numeric))),

    SELISIH_PENILAIAN_INVESTASI_NILAI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(16, null, "Selisih Penilaian Investasi Nilai", sv(M, 1, 18, numeric))),

    SELISIH_PENILAIAN_INVESTASI_PERSEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(17, null, "Selisih Penilaian Investasi %", sv(C, 4, 6, numericDot))),

    SEKTOR_EKONOMI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(18, null, "Sektor Ekonomi", sv(C, 1, 8, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataSharedLblt.R007.getObject()))),

    MANFAAT_PENSIUN_MANFAAT_PENSIUN_LAINNYA_MANFAAT_LAIN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(19, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain", sv(C, 1, 6, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataSharedLblt.R009.getObject()))),

    KETERANGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(20, null, "Keterangan", sv(C, 1, 250, freeText))),

    TOTAL_MODAL_DISETOR(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(21, null, "Total Modal Disetor", sv(M, 1, 18, numeric))),

    PRESENTASE_KEPEMILIKAN_V_PENDIRI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(22, null, "Presentase kepemilikan (v) Pendiri", sv(C, 4, 6, numericDot))),

    PRESENTASE_KEPEMILIKAN_V_DANA_PENSIUN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(23, null, "Presentase kepemilikan (v) Dana Pensiun", sv(C, 4, 6, numericDot))),

    PRESENTASE_KEPEMILIKAN_V_MITRA_PENDIRI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(24, null, "Presentase kepemilikan (v) Mitra Pendiri", sv(C, 4, 6, numericDot))),

    PRESENTASE_KEPEMILIKAN_V_PENGURUS(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(25, null, "Presentase kepemilikan (v) Pengurus", sv(C, 4, 6, numericDot))),

    PRESENTASE_KEPEMILIKAN_V_PENERIMA_TITIPAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(26, null, "Presentase kepemilikan (v) Penerima titipan", sv(C, 4, 6, numericDot))),

    PRESENTASE_KEPEMILIKAN_V_SERIKAT_KERJA_YANG_ANGGOTANYA_MERUPAKAN_PESERTA_DP(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(27, null, "Presentase kepemilikan (v) Serikat Kerja yang Anggotanya Merupakan Peserta DP", sv(C, 4, 6, numericDot))),

    PRESENTASE_KEPEMILIKAN_V_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(28, null, "Presentase kepemilikan (v) Lainnya", sv(C, 4, 6, numericDot))),

    ANAK_PERUSAHAAN_DARI_PENYERTAAN_LANGSUNG_2(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(29, null, "Anak Perusahaan dari Penyertaan Langsung(2)", sv(C, 1, 100, freeText))),

    TOTAL_MODAL_DISETOR_ANAK_PERUSAHAAN_DARI_PENYERTAAN_LANGSUNG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(30, null, "Total Modal Disetor Anak Perusahaan dari Penyertaan Langsung", sv(M, 1, 18, numeric))),

    PRESENTASE_KEPEMILIKAN_E1_PENDIRI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(31, null, "Presentase Kepemilikan (e1) Pendiri", sv(C, 4, 6, numericDot))),

    PRESENTASE_KEPEMILIKAN_E1_MITRA_PENDIRI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(32, null, "Presentase Kepemilikan (e1) Mitra Pendiri", sv(C, 4, 6, numericDot))),

    PRESENTASE_KEPEMILIKAN_E1_PENGURUS(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(33, null, "Presentase Kepemilikan (e1) Pengurus", sv(C, 4, 6, numericDot))),

    PRESENTASE_KEPEMILIKAN_E1_PENERIMA_TITIPAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(34, null, "Presentase Kepemilikan (e1) Penerima Titipan", sv(C, 4, 6, numericDot))),

    PRESENTASE_KEPEMILIKAN_E1_SERIKAT_KERJA_YANG_ANGGOTANYA_MERUPAKAN_PESERTA_DP(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(35, null, "Presentase Kepemilikan (e1) Serikat Kerja yang Anggotanya Merupakan Peserta DP", sv(C, 4, 6, numericDot))),

    PRESENTASE_KEPEMILIKAN_E1_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(36, null, "Presentase Kepemilikan (e1) Lainnya", sv(C, 4, 6, numericDot))),

    PRESENTASE_KEPEMILIKAN_E1_DIVIDEN_ANAK_PERUSAHAAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(37, null, "Presentase Kepemilikan (e1) Dividen Anak Perusahaan", sv(C, 1, 18, numeric))),

    /* Gabungan Additional Field */

    JENIS_PROGRAM(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
            sf(1000, null, "Jenis Program", sv(M, 5, 5, alfa))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataLkdpPpmpk.R7039Pnyl.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataLkdpPpmpm.R7039Pnyl.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataLkdpPpipk.R7039Pnyl.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataLkdpPpipm.R7039Pnyl.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkdpDplk.R7039Pnyl.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0039Pnyl> FIELD_METADATA = new LbltMetadataField<>(Dppk0039Pnyl.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan FORM = EFormLaporanBulananTahunan.LTLB_PNYL;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(FORM.getCode())
                .name(FORM.getName())
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

        BaseMetadataValidation<E7039PnylValidationsConfig> metadataValidation = null;

        switch (programType) {
            case PPMPK:
                metadataValidation = E7039PnylValidationsConfig.VALIDATION_METADATA_PPMPK;
                break;
            case PPMPM:
                metadataValidation = E7039PnylValidationsConfig.VALIDATION_METADATA_PPMPM;
                break;
            case PPIPK:
                metadataValidation = E7039PnylValidationsConfig.VALIDATION_METADATA_PPIPK;
                break;
            case PPIPM:
                metadataValidation = E7039PnylValidationsConfig.VALIDATION_METADATA_PPIPM;
                break;
            case DPLK:
                metadataValidation = E7039PnylValidationsConfig.VALIDATION_METADATA_DPLK;
                break;
            default:
                throw new IllegalStateException();
        }

        return new SubmissionConfig(programType)
                .config()
                .setReferenceConfigs(ER7039PosLtlbDppkPnyl.Configs.REF_CONFIG)
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