package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataShared;
import id.go.ojk.module.lblt.dppk.validations.E7032RksdValidationsConfig;
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
public enum Dppk0032Rksd implements ILbltFieldMetadata {

    FLAG(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(0, null, "Flag",
                    sv(M, 3, 3, alfaNumeric)
                            .confConstant("D01"))),

    KODE_KOMPONEN(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen",
                    sv(M, 10, 10, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataPpmpk.R7032Rksd.getObject()))),

    KODE(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(2, null, "Kode",
                    sv(C, 1, 20, alfaNumeric)
                            .confConditionalRequired(E7032RksdValidationsConfig))),

    NAMA_PRODUK(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(3, null, "Nama Produk",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7032RksdValidationsConfig))),

    JENIS_REKSA_DANA(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(4, null, "Jenis Reksa Dana *)",
                    sv(C, 1, 6, alfaNumeric)
                            .confConditionalRequired(E7032RksdValidationsConfig))),

    MANAJER_INVESTASI(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(5, null, "Manajer Investasi",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7032RksdValidationsConfig))),

    TANGGAL_PEROLEHAN(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(6, null, "Tanggal Perolehan",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7032RksdValidationsConfig))),

    JUMLAH_UNIT(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(7, null, "Jumlah Unit",
                    sv(M, 1, 13, numeric))),

    NILAI_PEROLEHAN(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(8, null, "Nilai Perolehan",
                    sv(M, 1, 18, numeric))),

    NILAI_WAJAR(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(9, null, "Nilai Wajar",
                    sv(M, 1, 18, numeric))),

    SELISIH_PENILAIAN_INVESTASI_NILAI(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(10, null, "Selisih Penilaian Investasi Nilai",
                    sv(M, 1, 18, numeric))
                    .addFieldValidations(E7032RksdValidationsConfig)),

    SELISIH_PENILAIAN_INVESTASI_PERSEN(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(11, null, "Selisih Penilaian Investasi %",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7032RksdValidationsConfig))
                    .addFieldValidations(E7032RksdValidationsConfig)),

    MANFAAT_PENSIUN_MANFAAT_PENSIUN_LAINNYA_MANFAAT_LAIN(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(12, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7032RksdValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R009.getObject()))),

    PENGELOLAAN_SWAKELOLA_KPD(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(13, null, "Pengelolaan Swakelola/ KPD",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7032RksdValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfa)
                            .confReference(EHeaderMetadataShared.R006.getObject()))),

    PENGELOLAAN_NAMA_MANAJER_INVESTASI(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(14, null, "Pengelolaan Nama Manajer Investasi",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7032RksdValidationsConfig)
                            .confConditionalRequired(E7032RksdValidationsConfig))),

    KETERANGAN(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(15, null, "Keterangan",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7032RksdValidationsConfig)));

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    @Override
    public SubmissionField getField() { return field; }

    @Override
    public EnumSet<SectorType> getSectorType() { return sectorType; }

    @Override
    public EnumSet<ProgramType> getProgramType() { return programType; }

    public static final BaseMetadataField<Dppk0032Rksd> FIELD_PPMPK = new LbltMetadataField<>(Dppk0032Rksd.class, PPMPK);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(String reportCode, SectorType sectorType) {
        EFormLaporanBulananTahunan FORM = EFormLaporanBulananTahunan.LTLB_RKSD;

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