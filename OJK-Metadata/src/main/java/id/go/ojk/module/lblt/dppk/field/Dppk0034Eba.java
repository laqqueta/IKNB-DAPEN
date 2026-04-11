package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataShared;
import id.go.ojk.client.constant.ExtensionType;
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
public enum Dppk0034Eba implements ILbltFieldMetadata {

    FLAG(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(0, null, "Flag",
                    sv(M, 3, 3, alfaNumeric)
                            .confConstant("D01"))),

    KODE_KOMPONEN(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen",
                    sv(M, 9, 9, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataPpmpk.R7034Eba.getObject()))),

    KODE(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(2, null, "Kode",
                    sv(C, 1, 20, alfaNumeric)
                            .confConditionalRequired(E7034EbaValidationsConfig))),

    NAMA_PRODUK(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(3, null, "Nama Produk",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7034EbaValidationsConfig))),

    NAMA_PENERBIT(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(4, null, "Nama Penerbit",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7034EbaValidationsConfig))),

    TANGGAL_PEROLEHAN(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(5, null, "Tanggal Perolehan",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7034EbaValidationsConfig))),

    NILAI_NOMINAL(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(6, null, "Nilai Nominal",
                    sv(M, 1, 18, numeric))),

    KUPON(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(7, null, "Kupon (%)",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7034EbaValidationsConfig))),

    TANGGAL_JATUH_TEMPO(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(8, null, "Tanggal Jatuh Tempo",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7034EbaValidationsConfig))
                    .addFieldValidations(E7034EbaValidationsConfig)),

    PERINGKAT_AWAL(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(9, null, "Peringkat Awal",
                    sv(C, 1, 10, alfaNumeric)
                            .confConditionalRequired(E7034EbaValidationsConfig))),

    PERINGKAT_AKHIR(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(10, null, "Peringkat Akhir",
                    sv(C, 1, 10, alfaNumeric)
                            .confConditionalRequired(E7034EbaValidationsConfig))),

    NILAI_PEROLEHAN(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(11, null, "Nilai Perolehan",
                    sv(M, 1, 18, numeric))),

    NILAI_WAJAR(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(12, null, "Nilai Wajar",
                    sv(M, 1, 18, numeric))),

    SELISIH_PENILAIAN_INVESTASI_NILAI(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(13, null, "Selisih Penilaian Investasi Nilai",
                    sv(M, 1, 18, numeric))
                    .addFieldValidations(E7034EbaValidationsConfig)),

    SELISIH_PENILAIAN_INVESTASI_PERSEN(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(14, null, "Selisih Penilaian Investasi %",
                    sv(M, 4, 6, numericDot))
                    .addFieldValidations(E7034EbaValidationsConfig)),

    SEKTOR_EKONOMI(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(15, null, "Sektor Ekonomi",
                    sv(C, 1, 8, refTable)
                            .confConditionalRequired(E7034EbaValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R007.getObject()))),

    MANFAAT_PENSIUN_MANFAAT_PENSIUN_LAINNYA_MANFAAT_LAIN(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(16, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7034EbaValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R009.getObject()))),

    PENGELOLAAN_SWAKELOLA_KPD(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(17, null, "Pengelolaan Swakelola/ KPD",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7034EbaValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfa)
                            .confReference(EHeaderMetadataShared.R006.getObject()))),

    PENGELOLAAN_NAMA_MANAJER_INVESTASI(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(18, null, "Pengelolaan Nama Manajer Investasi",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7034EbaValidationsConfig)
                            .confConditionalRequired(E7034EbaValidationsConfig))),

    KETERANGAN(EnumSet.of(KONVENSIONAL, SYARIAH), EnumSet.of(PPMPK, PPMPM),
            sf(19, null, "Keterangan",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7034EbaValidationsConfig)));

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    @Override
    public SubmissionField getField() { return field; }

    @Override
    public EnumSet<SectorType> getSectorTypes() { return sectorType; }

    @Override
    public EnumSet<ProgramType> getProgramType() { return programType; }

    public static final BaseMetadataField<Dppk0034Eba> FIELD_PPMPK = new LbltMetadataField<>(Dppk0034Eba.class, PPMPK);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan FORM = EFormLaporanBulananTahunan.LTLB_EBA;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(FORM.getCode())
                .name(FORM.getName())
                .extension(ExtensionType.TXT.getType())
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