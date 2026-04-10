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

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.freeText;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.util.FieldUtil.*;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0048Tnbg implements ILbltFieldMetadata {

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
                    sv(M, 10, 10, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataPpmpk.R7048Tnbg.getObject()))
    ),
    JENIS_OBJEK(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(2, null, "Jenis Objek (Tanah/Bangunan/Tanah & Bangunan)",
                    sv(C, 1, 8, refTable)
                            .confRegex(SimpleValidation.patternNumeric)
                            .confReference(EHeaderMetadataShared.R004.getObject())
                            .confConditionalRequired(E7048TnbgValidationsConfig))
    ),
    NOMOR_SERTIFIKAT(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(3, null, "Nomor Sertifikat",
                    sv(C, 1, 20, alfaNumeric)
                            .confConditionalRequired(E7048TnbgValidationsConfig))
    ),
    ALAMAT_LOKASI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(4, null, "Alamat Lokasi",
                    sv(C, 1, 250, alfaNumeric)
                            .confConditionalRequired(E7048TnbgValidationsConfig))
    ),
    TANGGAL_PEROLEHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(5, null, "Tanggal Perolehan",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7048TnbgValidationsConfig))
    ),
    NILAI_PEROLEHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(6, null, "Nilai Perolehan",
                    sv(M, 1, 18, numeric))
    ),
    AKUMULASI_PENYUSUTAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(7, null, "Akumulasi Penyusutan",
                    sv(M, 1, 18, numeric))
    ),
    NILAI_BUKU(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(8, null, "Nilai Buku",
                    sv(M, 1, 18, numeric))
                    .addFieldValidations(E7048TnbgValidationsConfig)
    ),
    NILAI_PEROLEHAN_PADA_TANGGAL_LAPORAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(9, null, "Nilai Perolehan Pada Tanggal Laporan",
                    sv(M, 1, 18, numeric))
    ),
    KETERANGAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(10, null, "Keterangan",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7048TnbgValidationsConfig))
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

    public static final BaseMetadataField<Dppk0048Tnbg> FIELD_PPMPK = new LbltMetadataField<>(Dppk0048Tnbg.class, PPMPK);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan TNBG_FORM = EFormLaporanBulananTahunan.LTLB_TNBG;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(TNBG_FORM.getCode())
                .name(TNBG_FORM.getName())
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