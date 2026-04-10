package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataShared;
import id.go.ojk.module.lblt.dppk.validations.E7020PmiValidationsConfig;
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
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;
import static id.go.ojk.util.FieldUtil.sf;
import static id.go.ojk.util.FieldUtil.sv;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0020Pmi implements ILbltFieldMetadata {

    FLAG(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(0, null, "Flag",
                    sv(O, 3, 3, alfaNumeric)
                            .confConstant("D01"))
    ),
    KODE_KOMPONEN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen",
                    sv(O, 9, 9, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataPpmpk.R7020Pmi.getObject()))
    ),
    NAMA_MANAJER_INVESTASI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(2, null, "Nama Manajer Investasi",
                    sv(O, 1, 100, freeText)
                            .confConditionalRequired(E7020PmiValidationsConfig))
    ),
    NOMOR_KONTRAK(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(3, null, "Nomor Kontrak",
                    sv(O, 1, 100, freeText)
                            .confConditionalRequired(E7020PmiValidationsConfig))
    ),
    TANGGAL_KONTRAK(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(4, null, "Tanggal Kontrak",
                    sv(O, 8, 8, numeric)
                            .confConditionalRequired(E7020PmiValidationsConfig))
    ),
    MASA_PERJANJIAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(5, null, "Masa Perjanjian",
                    sv(O, 1, 18, numeric)
                            .confConditionalRequired(E7020PmiValidationsConfig))
    ),
    JENIS_INVESTASI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(6, null, "Jenis Investasi",
                    sv(O, 1, 6, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R022.getObject())
                            .confConditionalRequired(E7020PmiValidationsConfig))
    ),
    JUMLAH_NILAI_WAJAR_DANA_KELOLAAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(7, null, "Jumlah Nilai Wajar Dana Kelolaan (Rp)",
                    sv(O, 1, 18, numeric))
    ),
    NILAI_PEROLEHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(8, null, "Nilai Perolehan (yang dikelola Manajer Investasi)",
                    sv(O, 1, 18, numeric))
    ),
    SELISIH_PENILAIAN_INVESTASI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(9, null, "Selisih Penilaian Investasi",
                    sv(O, 1, 18, numeric))
                    .addFieldValidations(E7020PmiValidationsConfig)
    ),
    RETURN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(10, null, "Return (%)",
                    sv(O, 4, 6, numericDot)
                            .confConditionalRequired(E7020PmiValidationsConfig))
    ),
    TINGKAT_HASIL_INVESTASI_BERSIH(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(11, null, "Tingkat Hasil Investasi Bersih (Rp)",
                    sv(O, 1, 18, numeric))
    ),
    JUMLAH_BIAYA_PENGELOLAAN_YANG_DIBEBANKAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(12, null, "Jumlah Biaya Pengelolaan yang dibebankan (Rp)",
                    sv(O, 1, 18, numeric))
    ),
    TERAFILIASI_DENGAN_DANA_PENSIUN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(13, null, "Terafiliasi dengan Dana Pensiun (Ya/Tidak)",
                    sv(O, 1, 10, alfa)
                            .confConditionalRequired(E7020PmiValidationsConfig))
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

    public static final BaseMetadataField<Dppk0020Pmi> FIELD_PPMPK = new LbltMetadataField<>(Dppk0020Pmi.class, PPMPK);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan PMI_FORM = EFormLaporanBulananTahunan.LTLB_PMI;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(PMI_FORM.getCode())
                .name(PMI_FORM.getName())
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