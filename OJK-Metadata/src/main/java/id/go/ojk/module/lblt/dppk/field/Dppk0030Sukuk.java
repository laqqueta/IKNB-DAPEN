package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataShared;
import id.go.ojk.module.lblt.dppk.validations.E7030SukukValidationsConfig;
import id.go.ojk.util.constants.ExtensionType;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.constants.SectorType;
import id.go.ojk.util.metadata.field.base.BaseMetadataField;
import id.go.ojk.util.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.util.metadata.field.lblt.LbltMetadataField;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.EnumSet;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.util.FieldUtil.sf;
import static id.go.ojk.util.FieldUtil.sv;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0030Sukuk implements ILbltFieldMetadata {

    FLAG(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(0, null, "Flag",
                    sv(M, 3, 3, alfaNumeric)
                            .confConstant("D01"))
    ),
    KODE_KOMPONEN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen",
                    sv(M, 11, 11, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataPpmpk.R7030Sukuk.getObject()))
    ),
    NAMA_PENERBIT(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(2, null, "Nama Penerbit",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7030SukukValidationsConfig))
    ),
    KODE_SUKUK(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(3, null, "Kode Sukuk",
                    sv(C, 1, 30, alfaNumeric)
                            .confConditionalRequired(E7030SukukValidationsConfig))
    ),
    NAMA_SUKUK(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(4, null, "Nama Sukuk",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7030SukukValidationsConfig))
    ),
    TANGGAL_PEROLEHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(5, null, "Tanggal Perolehan",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7030SukukValidationsConfig))
    ),
    NILAI_NOMINAL(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(6, null, "Nilai Nominal",
                    sv(M, 1, 18, numeric))
    ),
    KUPON(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(7, null, "Kupon (%)",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7030SukukValidationsConfig))
    ),
    TANGGAL_JATUH_TEMPO(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(8, null, "Tanggal Jatuh Tempo",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7030SukukValidationsConfig))
                    .addFieldValidations(E7030SukukValidationsConfig.FV_DATE_GREATER)
    ),
    PERINGKAT_AWAL(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(9, null, "Peringkat Awal",
                    sv(C, 1, 10, alfaNumeric)
                            .confConditionalRequired(E7030SukukValidationsConfig))
    ),
    PERINGKAT_AKHIR(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(10, null, "Peringkat Akhir",
                    sv(C, 1, 10, alfaNumeric)
                            .confConditionalRequired(E7030SukukValidationsConfig))
    ),
    NILAI_PEROLEHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(11, null, "Nilai Perolehan",
                    sv(M, 1, 18, numeric))
    ),
    NILAI_WAJAR(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(12, null, "Nilai Wajar",
                    sv(M, 1, 18, numeric))
    ),
    SELISIH_PENILAIAN_INVESTASI_NILAI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(13, null, "Selisih Penilaian Investasi Nilai",
                    sv(M, 1, 18, numeric))
                    .addFieldValidations(E7030SukukValidationsConfig.FV_EQUAL_NILAI_INVESTASI)
    ),
    SELISIH_PENILAIAN_INVESTASI_PERSEN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(14, null, "Selisih Penilaian Investasi %",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7030SukukValidationsConfig))
                    .addFieldValidations(E7030SukukValidationsConfig)
    ),
    SEKTOR_EKONOMI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(15, null, "Sektor Ekonomi",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7030SukukValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R007.getObject()))
    ),
    MANFAAT_PENSIUN_LAINNYA_LAIN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(16, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7030SukukValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R009.getObject()))
    ),
    METODE_PENCATATAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(17, null, "Metode Pencatatan",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7030SukukValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfa)
                            .confReference(EHeaderMetadataShared.R005.getObject()))
    ),
    PENGELOLAAN_SWAKELOLA_KPD(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(18, null, "Pengelolaan Swakelola/ KPD",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7030SukukValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfa)
                            .confReference(EHeaderMetadataShared.R006.getObject()))
    ),
    PENGELOLAAN_NAMA_MANAJER_INVESTASI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(19, null, "Pengelolaan Nama Manajer Investasi",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7030SukukValidationsConfig)
                            .confConditionalRequired(E7030SukukValidationsConfig))
    ),
    KETERANGAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(20, null, "Keterangan",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7030SukukValidationsConfig))
    ),
    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    @Override
    public SubmissionField getField() {
        return field;
    }

    @Override
    public EnumSet<SectorType> getSectorType() {
        return sectorType;
    }

    @Override
    public EnumSet<ProgramType> getProgramType() {
        return programType;
    }

    public static final BaseMetadataField<Dppk0030Sukuk> FIELD_PPMPK = new LbltMetadataField<>(Dppk0030Sukuk.class, PPMPK);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan SUKUK_FORM = EFormLaporanBulananTahunan.LTLB_SUKUK;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(SUKUK_FORM.getCode())
                .name(SUKUK_FORM.getName())
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