package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataShared;
import id.go.ojk.module.lblt.dppk.validations.E7025SrdpValidationsConfig;
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
public enum Dppk0025Srdp implements ILbltFieldMetadata {

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
                            .confReference(EHeaderMetadataPpmpk.R7025Srdp.getObject()))
    ),
    NAMA_BANK(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(2, null, "Nama Bank",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7025SrdpValidationsConfig))
    ),
    KODE_BANK(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(3, null, "Kode Bank",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7025SrdpValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R011.getObject()))
    ),
    CABANG(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(4, null, "Cabang",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7025SrdpValidationsConfig))
    ),
    TANGGAL_PEROLEHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(5, null, "Tanggal Perolehan",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7025SrdpValidationsConfig))
    ),
    NILAI_NOMINAL(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(6, null, "Nilai Nominal",
                    sv(M, 1, 18, numeric))
    ),
    JANGKA_WAKTU_HARI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(7, null, "Jangka Waktu (Hari)",
                    sv(C, 1, 3, numeric)
                            .confConditionalRequired(E7025SrdpValidationsConfig))
    ),
    TINGKAT_BUNGA_NISBAH(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(8, null, "Tingkat Bunga/Nisbah (%)",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7025SrdpValidationsConfig))
    ),
    MANFAAT_PENSIUN_LAINNYA_LAIN_LCF(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(9, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7025SrdpValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R009.getObject()))
    ),
    PENGELOLAAN_SWAKELOLA_KPD(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(10, null, "Pengelolaan Swakelola/ KPD",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7025SrdpValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfa)
                            .confReference(EHeaderMetadataShared.R006.getObject()))
    ),
    PENGELOLAAN_NAMA_MANAJER_INVESTASI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(11, null, "Pengelolaan Nama Manajer Investasi",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7025SrdpValidationsConfig)
                            .confConditionalRequired(E7025SrdpValidationsConfig))
    ),
    KETERANGAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(12, null, "Keterangan",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7025SrdpValidationsConfig))
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

    public static final BaseMetadataField<Dppk0025Srdp> FIELD_PPMPK = new LbltMetadataField<>(Dppk0025Srdp.class, PPMPK);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan SRDP_FORM = EFormLaporanBulananTahunan.LTLB_SRDP;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(SRDP_FORM.getCode())
                .name(SRDP_FORM.getName())
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