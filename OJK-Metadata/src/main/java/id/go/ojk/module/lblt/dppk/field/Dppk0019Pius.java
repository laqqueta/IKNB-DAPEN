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
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;
import static id.go.ojk.util.FieldUtil.*;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0019Pius implements ILbltFieldMetadata {

    FLAG(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01"))
    ),
    KODE_KOMPONEN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen", sv(O, 14, 14, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataPpmpk.R7019Pius.getObject()))
    ),
    JUMLAH_PESERTA_IURAN_SUKARELA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(2, null, "Jumlah Peserta Iuran Sukarela", sv(O, 1, 18, numeric))
    ),
    SALDO_AKUMULASI_IURAN_SUKARELA_BULAN_SEBELUMNYA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(3, null, "Saldo Akumulasi Iuran Sukarela bulan sebelumnya", sv(O, 1, 18, numeric))
    ),
    PENAMBAHAN_IURAN_SUKARELA_BULAN_BERJALAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(4, null, "Penambahan iuran sukarela bulan berjalan", sv(O, 1, 18, numeric))
    ),
    DISTRIBUSI_HASIL_PENGEMBANGAN_DANA_IURAN_SUKARELA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(5, null, "Distribusi Hasil Pengembangan Dana Iuran Sukarela", sv(O, 1, 18, numeric))
    ),
    TOTAL_SALDO_AKUMULASI_IURAN_SUKARELA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(6, null, "Total Saldo akumulasi iuran sukarela", sv(O, 1, 18, numeric))
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

    public static final BaseMetadataField<Dppk0019Pius> FIELD_PPMPK = new LbltMetadataField<>(Dppk0019Pius.class, PPMPK);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan PIUS_FORM = EFormLaporanBulananTahunan.LTLB_PIUS;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(PIUS_FORM.getCode())
                .name(PIUS_FORM.getName())
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