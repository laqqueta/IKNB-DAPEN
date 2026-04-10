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
public enum Dppk0040Prop implements ILbltFieldMetadata {
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
                            .confReference(EHeaderMetadataPpmpk.R7040Prop.getObject()))),
    JENIS_OBJEK_TANAH_BANGUNAN_TANAH_BANGUNAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(2, null, "Jenis Objek (Tanah/Bangunan/Tanah&Bangunan)",
                    sv(C, 1, 8, refTable)
                            .confConditionalRequired(E7040PropValidationsConfig.genConditionForTotal())
                            .confRegex(SimpleValidation.patternNumeric)
                            .confReference(EHeaderMetadataShared.R004.getObject()))),
    ALAMAT_LENGKAP(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(3, null, "Alamat Lengkap",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7040PropValidationsConfig.genConditionForTotal()))),
    LUAS_M2(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(4, null, "Luas(m2)",
                    sv(C, 1, 10, numeric)
                            .confConditionalRequired(E7040PropValidationsConfig.genConditionForTotal()))),
    JENIS_BUKTI_KEPEMILIKAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(5, null, "Jenis Bukti Kepemilikan",
                    sv(C, 1, 8, refTable)
                            .confConditionalRequired(E7040PropValidationsConfig.genConditionForTotal())
                            .confRegex(SimpleValidation.patternAlfa)
                            .confReference(EHeaderMetadataShared.R016.getObject()))),
    NOMOR_SURAT_KEPEMILIKAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(6, null, "Nomor Surat Kepemilikan",
                    sv(C, 1, 20, alfaNumeric)
                            .confConditionalRequired(E7040PropValidationsConfig.genConditionForTotal()))),
    TANGGAL_PEROLEHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(7, null, "Tanggal Perolehan",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7040PropValidationsConfig.genConditionForTotal()))),
    NILAI_PEROLEHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(8, null, "Nilai Perolehan",
                    sv(M, 1, 18, numeric))),
    AKUMULASI_PENYUSUTAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(9, null, "Akumulasi Penyusutan",
                    sv(M, 1, 18, numeric))),
    NILAI_BUKU(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(10, null, "Nilai Buku",
                    sv(M, 1, 18, numeric))
                    .addFieldValidations(E7040PropValidationsConfig.genFieldValidationNilaiBuku())),
    NILAI_APPRAISAL_NILAI_WAJAR(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(11, null, "Nilai Appraisal/ Nilai Wajar",
                    sv(M, 1, 18, numeric))),
    TANGGAL_APPRAISAL(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(12, null, "Tanggal Appraisal",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7040PropValidationsConfig.genConditionForTotal()))),
    NAMA_PENILAI_PUBLIK_INDEPENDEN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(13, null, "Nama Penilai Publik/Independen",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7040PropValidationsConfig.genConditionForTotal()))),
    NAMA_KJPP(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(14, null, "Nama KJPP",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7040PropValidationsConfig.genConditionForTotal()))),
    SELISIH_PENILAIAN_INVESTASI_NILAI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(15, null, "Selisih Penilaian Investasi Nilai",
                    sv(M, 1, 18, numeric))
                    .addFieldValidations(E7040PropValidationsConfig.genFieldValidationNilaiInvestasi())),
    SELISIH_PENILAIAN_INVESTASI_PERSEN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(16, null, "Selisih Penilaian Investasi %",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7040PropValidationsConfig.genConditionForTotal()))
                    .addFieldValidations(E7040PropValidationsConfig.genFieldValidationPersentaseInvestasi())),
    MANFAAT_PENSIUN_MANFAAT_PENSIUN_LAINNYA_MANFAAT_LAIN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(17, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7040PropValidationsConfig.genConditionForTotal())
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R009.getObject()))),
    PENDAPATAN_SEWA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(18, null, "Pendapatan Sewa",
                    sv(C, 1, 18, numeric)
                            .confConditionalRequired(E7040PropValidationsConfig.genConditionForTotal()))),
    KETERANGAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(19, null, "Keterangan",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7040PropValidationsConfig.genConditionForTotalOptional())));

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    @Override
    public SubmissionField getField() { return field; }

    @Override
    public EnumSet<SectorType> getSectorType() { return sectorType; }

    @Override
    public EnumSet<ProgramType> getProgramType() { return programType; }

    public static final BaseMetadataField<Dppk0040Prop> FIELD_PPMPK = new LbltMetadataField<>(Dppk0040Prop.class, PPMPK);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan FORM = EFormLaporanBulananTahunan.LTLB_PROP;
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