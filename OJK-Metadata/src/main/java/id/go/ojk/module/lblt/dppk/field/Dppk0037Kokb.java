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
public enum Dppk0037Kokb implements ILbltFieldMetadata {
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
                            .confReference(EHeaderMetadataPpmpk.R7037Kokb.getObject()))),
    NAMA_EMITEN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(2, null, "Nama Emiten",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7037KokbValidationsConfig.genConditionForTotal()))),
    NAMA_PEMBELI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(3, null, "Nama Pembeli",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7037KokbValidationsConfig.genConditionForTotal()))),
    TANGGAL_PEROLEHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(4, null, "Tanggal Perolehan",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7037KokbValidationsConfig.genConditionForTotal()))),
    JANGKA_WAKTU(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(5, null, "Jangka Waktu",
                    sv(C, 1, 5, numeric)
                            .confConditionalRequired(E7037KokbValidationsConfig.genConditionForTotal()))),
    NILAI_PEROLEHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(6, null, "Nilai Perolehan",
                    sv(M, 1, 18, numeric))),
    NILAI_WAJAR(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(7, null, "Nilai Wajar",
                    sv(M, 1, 18, numeric))),
    SELISIH_PENILAIAN_INVESTASI_NILAI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(8, null, "Selisih Penilaian Investasi Nilai",
                    sv(M, 1, 18, numeric))
                    .addFieldValidations(E7037KokbValidationsConfig.genFieldValidationNilaiInvestasi())),
    SELISIH_PENILAIAN_INVESTASI_PERSEN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(9, null, "Selisih Penilaian Investasi %",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7037KokbValidationsConfig.genConditionForTotal()))
                    .addFieldValidations(E7037KokbValidationsConfig.genFieldValidationPersentaseInvestasi())),
    MANFAAT_PENSIUN_MANFAAT_PENSIUN_LAINNYA_MANFAAT_LAIN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(10, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7037KokbValidationsConfig.genConditionForTotal())
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R009.getObject()))),
    PENGELOLAAN_SWAKELOLA_KPD(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(11, null, "Pengelolaan Swakelola/ KPD",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7037KokbValidationsConfig.genConditionForTotal())
                            .confRegex(SimpleValidation.patternAlfa)
                            .confReference(EHeaderMetadataShared.R006.getObject()))),
    PENGELOLAAN_NAMA_MANAJER_INVESTASI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(12, null, "Pengelolaan Nama Manajer Investasi",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7037KokbValidationsConfig.genConditionForTotal())
                            .confConditionalRequired(E7037KokbValidationsConfig.genConditionNamaPengelola()))),
    KETERANGAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(13, null, "Keterangan",
                    sv(O, 1, 250, freeText)
                            .confConditionalRequired(E7037KokbValidationsConfig.genConditionForTotalOptional())));

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    @Override
    public SubmissionField getField() { return field; }

    @Override
    public EnumSet<SectorType> getSectorType() { return sectorType; }

    @Override
    public EnumSet<ProgramType> getProgramType() { return programType; }

    public static final BaseMetadataField<Dppk0037Kokb> FIELD_PPMPK = new LbltMetadataField<>(Dppk0037Kokb.class, PPMPK);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan FORM = EFormLaporanBulananTahunan.LTLB_KOKB;
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