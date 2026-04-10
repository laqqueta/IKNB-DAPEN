package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.util.constants.ExtensionType;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.constants.SectorType;
import id.go.ojk.util.metadata.field.base.BaseMetadataField;
import id.go.ojk.util.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.util.metadata.field.lblt.LbltMetadataField;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.EnumSet;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.freeText;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.util.FieldUtil.*;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0061Iur implements ILbltFieldMetadata {

    FLAG(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01"))
    ),
    KODE_KOMPONEN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen", sv(M, 9, 9, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataPpmpk.R7061Iur.getObject()))
    ),
    NAMA_PENDIRI_MITRA_PENDIRI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(2, null, "Nama Pendiri/Mitra Pendiri",
                    sv(C, 1, 100, alfaNumeric)
                            .confConditionalRequired(E7061IurValidationsConfig))
    ),
    PHDP(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(3, null, "PhDP", sv(C, 4, 6, numericDot)
                    .confConditionalRequired(E7061IurValidationsConfig))
    ),
    IURAN_JATUH_TEMPO_NORMAL_PESERTA_PERSEN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(4, null, "Iuran Jatuh Tempo - Iuran Normal Peserta %",
                    sv(C, 1, 18, numeric)
                            .confConditionalRequired(E7061IurValidationsConfig))
    ),
    IURAN_JATUH_TEMPO_NORMAL_PESERTA_JUMLAH(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(5, null, "Iuran Jatuh Tempo - Iuran Normal Peserta Jumlah", sv(M, 1, 18, numeric))
    ),
    IURAN_JATUH_TEMPO_NORMAL_PEMBERI_KERJA_PERSEN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(6, null, "Iuran Jatuh Tempo - Iuran Normal Pemberi Kerja %",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7061IurValidationsConfig))
    ),
    IURAN_JATUH_TEMPO_NORMAL_PEMBERI_KERJA_JUMLAH(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(7, null, "Iuran Jatuh Tempo - Iuran Normal Pemberi Kerja Jumlah", sv(M, 4, 6, numericDot))
    ),
    IURAN_JATUH_TEMPO_SUKARELA_PESERTA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(8, null, "Iuran Jatuh Tempo - Iuran Sukarela Peserta", sv(M, 1, 18, numeric))
    ),
    IURAN_JATUH_TEMPO_TAMBAHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(9, null, "Iuran Jatuh Tempo - Iuran Tambahan", sv(M, 1, 18, numeric))
    ),
    PENERIMAAN_IURAN_NORMAL_PESERTA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(10, null, "Penerimaan Iuran - Iuran Normal Peserta", sv(M, 1, 18, numeric))
    ),
    PENERIMAAN_IURAN_NORMAL_PEMBERI_KERJA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(11, null, "Penerimaan Iuran - Iuran Normal Pemberi Kerja", sv(M, 1, 18, numeric))
    ),
    PENERIMAAN_IURAN_TAMBAHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(12, null, "Penerimaan Iuran - Iuran Tambahan", sv(M, 1, 18, numeric))
    ),
    PENERIMAAN_IURAN_SUKARELA_PESERTA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(13, null, "Penerimaan Iuran - Iuran Sukarela Peserta", sv(M, 1, 18, numeric))
    ),
    KURANG_LEBIH_BAYAR_NORMAL_PESERTA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(14, null, "Kurang/Lebih bayar - Iuran Normal Peserta", sv(M, 1, 18, numeric))
    ),
    KURANG_LEBIH_BAYAR_NORMAL_PEMBERI_KERJA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(15, null, "Kurang/Lebih bayar - Iuran Normal Pemberi Kerja", sv(M, 1, 18, numeric))
    ),
    KURANG_LEBIH_BAYAR_TAMBAHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(16, null, "Kurang/Lebih bayar - Iuran Tambahan", sv(M, 1, 18, numeric))
    ),
    MANFAAT_PENSIUN_LAINNYA_LAIN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(17, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                    sv(C, 1, 6, alfaNumeric)
                            .confConditionalRequired(E7061IurValidationsConfig))
    ),
    KETERANGAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(18, null, "Keterangan",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7061IurValidationsConfig))
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

    public static final BaseMetadataField<Dppk0061Iur> FIELD_PPMPK = new LbltMetadataField<>(Dppk0061Iur.class, PPMPK);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan IUR_FORM = EFormLaporanBulananTahunan.LTLB_IUR;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(IUR_FORM.getCode())
                .name(IUR_FORM.getName())
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