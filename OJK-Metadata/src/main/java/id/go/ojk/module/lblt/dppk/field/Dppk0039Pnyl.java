package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.shared.header.EHeaderMetadataShared;
import id.go.ojk.util.constants.ExtensionType;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.constants.SectorType;
import id.go.ojk.util.metadata.field.base.BaseMetadataField;
import id.go.ojk.util.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.util.metadata.field.lblt.LbltMetadataField;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.EnumSet;

import static id.go.ojk.util.FieldUtil.*;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0039Pnyl implements ILbltFieldMetadata {
    FLAG(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(0, null, "Flag",
                    sv(M, 3, 3, alfaNumeric)
                            .confConstant("D01"))),
    KODE_KOMPONEN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen",
                    sv(M, 10, 10, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataPpmpk.R7039Pnyl.getObject()))),
    NAMA_PERUSAHAAN_1(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(2, null, "Nama Perusahaan(1)",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal()))),
    PERWAKILAN_DANA_PENSIUN_NAMA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(3, null, "Perwakilan Dana Pensiun Nama",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationNamaPerusahaan()))),
    PERWAKILAN_DANA_PENSIUN_JABATAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(4, null, "Perwakilan Dana Pensiun Jabatan",
                    sv(C, 1, 50, alfaNumeric)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationNamaPerusahaan()))),
    KATEGORI_PENYERTAAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(5, null, "Kategori Penyertaan*)",
                    sv(C, 1, 8, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R019.getObject())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationNamaPerusahaan()))),
    TANGGAL_PEROLEHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(6, null, "Tanggal Perolehan",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationNamaPerusahaan()))),
    PENEMPATAN_AWAL_TANGGAL(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(7, null, "Penempatan Awal Tanggal",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationNamaPerusahaan()))),
    PENEMPATAN_AWAL_PERSEN_KEPEMILIKAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(8, null, "Penempatan Awal % Kepemilikan",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationNamaPerusahaan()))),
    PENEMPATAN_AWAL_TOTAL(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(9, null, "Penempatan Awal Total",
                    sv(M, 1, 18, numeric))),
    NILAI_PEROLEHAN_PER_TANGGAL_LAPORAN_PERSEN_KEPEMILIKAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(10, null, "Nilai Perolehan Per tanggal laporan % Kepemilikan",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationNamaPerusahaan()))),
    NILAI_PEROLEHAN_PER_TANGGAL_LAPORAN_TOTAL(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(11, null, "Nilai Perolehan Per tanggal laporan Total",
                    sv(M, 1, 18, numeric))),
    NILAI_APPRASIAL_WAJAR_NAMA_PENILAI_PUBLIK_INDEPENDEN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(12, null, "Nilai Apprasial/wajar Nama Penilai Publik/Independen",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationNamaPerusahaan()))),
    NILAI_APPRASIAL_WAJAR_TANGGAL(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(13, null, "Nilai Apprasial/wajar Tanggal",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationNamaPerusahaan()))),
    NILAI_APPRASIAL_WAJAR_PERSEN_KEPEMILIKAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(14, null, "Nilai Apprasial/wajar % Kepemilikan",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationNamaPerusahaan()))),
    NILAI_APPRASIAL_WAJAR_TOTAL(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(15, null, "Nilai Apprasial/wajar Total",
                    sv(M, 1, 18, numeric))),
    SELISIH_PENILAIAN_INVESTASI_NILAI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(16, null, "Selisih Penilaian Investasi Nilai",
                    sv(M, 1, 18, numeric))
                    .addFieldValidations(E7039PnylValidationsConfig.genFieldValidationNilai())),
    SELISIH_PENILAIAN_INVESTASI_PERSEN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(17, null, "Selisih Penilaian Investasi %",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationNamaPerusahaan()))
                    .addFieldValidations(E7039PnylValidationsConfig.genFieldValidationRatio())),
    SEKTOR_EKONOMI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(18, null, "Sektor Ekonomi",
                    sv(C, 1, 8, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R007.getObject())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationNamaPerusahaan()))),
    MANFAAT_PENSIUN_MANFAAT_PENSIUN_LAINNYA_MANFAAT_LAIN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(19, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                    sv(C, 1, 6, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R009.getObject())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationNamaPerusahaan()))),
    KETERANGAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(20, null, "Keterangan",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal()))),
    TOTAL_MODAL_DISETOR(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(21, null, "Total Modal Disetor",
                    sv(M, 1, 18, numeric))),
    PRESENTASE_KEPEMILIKAN_V_PENDIRI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(22, null, "Presentase kepemilikan (v) Pendiri",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal()))),
    PRESENTASE_KEPEMILIKAN_V_DANA_PENSIUN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(23, null, "Presentase kepemilikan (v) Dana Pensiun",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal()))),
    PRESENTASE_KEPEMILIKAN_V_MITRA_PENDIRI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(24, null, "Presentase kepemilikan (v) Mitra Pendiri",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal()))),
    PRESENTASE_KEPEMILIKAN_V_PENGURUS(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(25, null, "Presentase kepemilikan (v) Pengurus",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal()))),
    PRESENTASE_KEPEMILIKAN_V_PENERIMA_TITIPAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(26, null, "Presentase kepemilikan (v) Penerima titipan",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal()))),
    PRESENTASE_KEPEMILIKAN_V_SERIKAT_KERJA_YANG_ANGGOTANYA_MERUPAKAN_PESERTA_DP(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(27, null, "Presentase kepemilikan (v) Serikat Kerja yang Anggotanya Merupakan Peserta DP",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal()))),
    PRESENTASE_KEPEMILIKAN_V_LAINNYA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(28, null, "Presentase kepemilikan (v) Lainnya",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal()))
                    .addFieldValidations(E7039PnylValidationsConfig.genValidationFixedPersentaseV())),
    ANAK_PERUSAHAAN_DARI_PENYERTAAN_LANGSUNG_2(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(29, null, "Anak Perusahaan dari Penyertaan Langsung(2)",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationNamaPerusahaan()))),
    TOTAL_MODAL_DISETOR_ANAK_PERUSAHAAN_DARI_PENYERTAAN_LANGSUNG(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(30, null, "Total Modal Disetor Anak Perusahaan dari Penyertaan Langsung",
                    sv(C, 1, 18, numeric)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationAnakPerushaan2()))),
    PRESENTASE_KEPEMILIKAN_E1_PENDIRI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(31, null, "Presentase Kepemilikan (e1) Pendiri",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationAnakPerushaan()))),
    PRESENTASE_KEPEMILIKAN_E1_MITRA_PENDIRI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(32, null, "Presentase Kepemilikan (e1) Mitra Pendiri",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationAnakPerushaan()))),
    PRESENTASE_KEPEMILIKAN_E1_PENGURUS(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(33, null, "Presentase Kepemilikan (e1) Pengurus",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationAnakPerushaan()))),
    PRESENTASE_KEPEMILIKAN_E1_PENERIMA_TITIPAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(34, null, "Presentase Kepemilikan (e1) Penerima Titipan",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationAnakPerushaan()))),
    PRESENTASE_KEPEMILIKAN_E1_SERIKAT_KERJA_YANG_ANGGOTANYA_MERUPAKAN_PESERTA_DP(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(35, null, "Presentase Kepemilikan (e1) Serikat Kerja yang Anggotanya Merupakan Peserta DP",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationAnakPerushaan()))),
    PRESENTASE_KEPEMILIKAN_E1_LAINNYA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(36, null, "Presentase Kepemilikan (e1) Lainnya",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationAnakPerushaan()))
                    .addFieldValidations(E7039PnylValidationsConfig.genValidationFixedPersentaseE1())),
    PRESENTASE_KEPEMILIKAN_E1_DIVIDEN_ANAK_PERUSAHAAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(37, null, "Presentase Kepemilikan (e1) Dividen Anak Perusahaan",
                    sv(C, 1, 18, numeric)
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7039PnylValidationsConfig.genConditionValidationAnakPerushaan())));

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    @Override
    public SubmissionField getField() { return field; }

    @Override
    public EnumSet<SectorType> getSectorType() { return sectorType; }

    @Override
    public EnumSet<ProgramType> getProgramType() { return programType; }

    public static final BaseMetadataField<Dppk0039Pnyl> FIELD_PPMPK = new LbltMetadataField<>(Dppk0039Pnyl.class, PPMPK);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan FORM = EFormLaporanBulananTahunan.LTLB_PNYL;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(FORM.getCode())
                .name(FORM.getName())
                .extension(ExtensionType.TXT.getExtension())
                .reportCode(reportCode)
                .maxRow(null)
                .fields(new ArrayList<>())
                .build();

        if (sectorType.equals(KONVENSIONAL)) {
            sfConfig.setMinRow(0);
            return sfConfig;
        } else if (sectorType.equals(SYARIAH)) {
            sfConfig.setMinRow(9999);
            return sfConfig;
        }

        throw new IllegalArgumentException("Unknown sector type: " + sectorType);
    }
}