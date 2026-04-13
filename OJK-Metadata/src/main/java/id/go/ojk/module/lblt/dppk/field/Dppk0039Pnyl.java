package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataShared;
import id.go.ojk.module.lblt.dppk.reference.ER7039PosLtlbDppkPnyl;
import id.go.ojk.module.lblt.dppk.validations.E7039PnylValidationsConfig;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.constants.SectorType;
import id.go.ojk.util.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.util.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.util.metadata.submission.SubmissionConfig;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.EnumSet;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.util.FieldUtil.*;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0039Pnyl implements ILbltFieldMetadata {
    FLAG(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(0, null, "Flag",
                    sv(M, 3, 3, alfaNumeric)
                            .confConstant("D01"))),
    KODE_KOMPONEN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen",
                    sv(M, 10, 10, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataPpmpk.R7039Pnyl.getObject()))),
    NAMA_PERUSAHAAN_1(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(2, null, "Nama Perusahaan(1)",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    PERWAKILAN_DANA_PENSIUN_NAMA(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(3, null, "Perwakilan Dana Pensiun Nama",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    PERWAKILAN_DANA_PENSIUN_JABATAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(4, null, "Perwakilan Dana Pensiun Jabatan",
                    sv(C, 1, 50, alfaNumeric)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    KATEGORI_PENYERTAAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(5, null, "Kategori Penyertaan*)",
                    sv(C, 1, 8, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R019.getObject())
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    TANGGAL_PEROLEHAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(6, null, "Tanggal Perolehan",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    PENEMPATAN_AWAL_TANGGAL(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(7, null, "Penempatan Awal Tanggal",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    PENEMPATAN_AWAL_PERSEN_KEPEMILIKAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(8, null, "Penempatan Awal % Kepemilikan",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    PENEMPATAN_AWAL_TOTAL(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(9, null, "Penempatan Awal Total",
                    sv(M, 1, 18, numeric))),
    NILAI_PEROLEHAN_PER_TANGGAL_LAPORAN_PERSEN_KEPEMILIKAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(10, null, "Nilai Perolehan Per tanggal laporan % Kepemilikan",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    NILAI_PEROLEHAN_PER_TANGGAL_LAPORAN_TOTAL(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(11, null, "Nilai Perolehan Per tanggal laporan Total",
                    sv(M, 1, 18, numeric))),
    NILAI_APPRASIAL_WAJAR_NAMA_PENILAI_PUBLIK_INDEPENDEN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(12, null, "Nilai Apprasial/wajar Nama Penilai Publik/Independen",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    NILAI_APPRASIAL_WAJAR_TANGGAL(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(13, null, "Nilai Apprasial/wajar Tanggal",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    NILAI_APPRASIAL_WAJAR_PERSEN_KEPEMILIKAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(14, null, "Nilai Apprasial/wajar % Kepemilikan",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    NILAI_APPRASIAL_WAJAR_TOTAL(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(15, null, "Nilai Apprasial/wajar Total",
                    sv(M, 1, 18, numeric))),
    SELISIH_PENILAIAN_INVESTASI_NILAI(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(16, null, "Selisih Penilaian Investasi Nilai",
                    sv(M, 1, 18, numeric))
                    .addFieldValidations(E7039PnylValidationsConfig)),
    SELISIH_PENILAIAN_INVESTASI_PERSEN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(17, null, "Selisih Penilaian Investasi %",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))
                    .addFieldValidations(E7039PnylValidationsConfig)),
    SEKTOR_EKONOMI(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(18, null, "Sektor Ekonomi",
                    sv(C, 1, 8, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R007.getObject())
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    MANFAAT_PENSIUN_MANFAAT_PENSIUN_LAINNYA_MANFAAT_LAIN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(19, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                    sv(C, 1, 6, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R009.getObject())
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    KETERANGAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(20, null, "Keterangan",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    TOTAL_MODAL_DISETOR(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(21, null, "Total Modal Disetor",
                    sv(M, 1, 18, numeric))),
    PRESENTASE_KEPEMILIKAN_V_PENDIRI(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(22, null, "Presentase kepemilikan (v) Pendiri",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    PRESENTASE_KEPEMILIKAN_V_DANA_PENSIUN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(23, null, "Presentase kepemilikan (v) Dana Pensiun",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    PRESENTASE_KEPEMILIKAN_V_MITRA_PENDIRI(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(24, null, "Presentase kepemilikan (v) Mitra Pendiri",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    PRESENTASE_KEPEMILIKAN_V_PENGURUS(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(25, null, "Presentase kepemilikan (v) Pengurus",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    PRESENTASE_KEPEMILIKAN_V_PENERIMA_TITIPAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(26, null, "Presentase kepemilikan (v) Penerima titipan",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    PRESENTASE_KEPEMILIKAN_V_SERIKAT_KERJA_YANG_ANGGOTANYA_MERUPAKAN_PESERTA_DP(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(27, null, "Presentase kepemilikan (v) Serikat Kerja yang Anggotanya Merupakan Peserta DP",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    PRESENTASE_KEPEMILIKAN_V_LAINNYA(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(28, null, "Presentase kepemilikan (v) Lainnya",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig))
                    .addFieldValidations(E7039PnylValidationsConfig)),
    ANAK_PERUSAHAAN_DARI_PENYERTAAN_LANGSUNG_2(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(29, null, "Anak Perusahaan dari Penyertaan Langsung(2)",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    TOTAL_MODAL_DISETOR_ANAK_PERUSAHAAN_DARI_PENYERTAAN_LANGSUNG(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(30, null, "Total Modal Disetor Anak Perusahaan dari Penyertaan Langsung",
                    sv(C, 1, 18, numeric)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    PRESENTASE_KEPEMILIKAN_E1_PENDIRI(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(31, null, "Presentase Kepemilikan (e1) Pendiri",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    PRESENTASE_KEPEMILIKAN_E1_MITRA_PENDIRI(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(32, null, "Presentase Kepemilikan (e1) Mitra Pendiri",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    PRESENTASE_KEPEMILIKAN_E1_PENGURUS(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(33, null, "Presentase Kepemilikan (e1) Pengurus",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    PRESENTASE_KEPEMILIKAN_E1_PENERIMA_TITIPAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(34, null, "Presentase Kepemilikan (e1) Penerima Titipan",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    PRESENTASE_KEPEMILIKAN_E1_SERIKAT_KERJA_YANG_ANGGOTANYA_MERUPAKAN_PESERTA_DP(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(35, null, "Presentase Kepemilikan (e1) Serikat Kerja yang Anggotanya Merupakan Peserta DP",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))),
    PRESENTASE_KEPEMILIKAN_E1_LAINNYA(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(36, null, "Presentase Kepemilikan (e1) Lainnya",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig))
                    .addFieldValidations(E7039PnylValidationsConfig)),
    PRESENTASE_KEPEMILIKAN_E1_DIVIDEN_ANAK_PERUSAHAAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(37, null, "Presentase Kepemilikan (e1) Dividen Anak Perusahaan",
                    sv(C, 1, 18, numeric)
                            .confConditionalRequired(E7039PnylValidationsConfig)
                            .confConditionalRequired(E7039PnylValidationsConfig)));

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    @Override
    public SubmissionField getField() { return field; }

    @Override
    public EnumSet<SectorType> getSectorTypes() { return sectorType; }

    @Override
    public EnumSet<ProgramType> getProgramType() { return programType; }

    public static final LbltMetadataField<Dppk0039Pnyl> FIELD_KONVEN = new LbltMetadataField<>(Dppk0039Pnyl.class, KONVENSIONAL);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan FORM = EFormLaporanBulananTahunan.LTLB_PNYL;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(FORM.getCode())
                .name(FORM.getName())
                .extension(ExtensionType.TXT)
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

    public static SubmissionFormat ppmpkKonvensionalFormMetadata(String reportCode) {
        FIELD_KONVEN.setProgramType(ProgramType.PPMPK);
        return new SubmissionConfig(reportCode)
                .config()
                .setRequiredPos(ER7039PosLtlbDppkPnyl.getRequiredPos())
                .setSubmissionFormat(getSubmissionFormatConfig(KONVENSIONAL, reportCode))
                .setSubmissionField(FIELD_KONVEN.getFields())
                .setSegmentValidations(E7039PnylValidationsConfig.VALIDATION_METADATA)
                .build()
                .get();
    }
}