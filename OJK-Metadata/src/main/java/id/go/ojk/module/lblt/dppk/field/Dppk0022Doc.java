package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataShared;
import id.go.ojk.module.lblt.dppk.validations.E7022DocValidationsConfig;
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
import static id.go.ojk.util.FieldUtil.*;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0022Doc implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric)
                    .confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen", sv(M, 9, 9, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataPpmpk.R7022Doc.getObject()))),

    NAMA_BANK(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(2, null, "Nama Bank", sv(C, 1, 100, freeText)
                    .confConditionalRequired(E7022DocValidationsConfig))),

    KODE_BANK(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(3, null, "Kode Bank", sv(C, 1, 6, refTable)
                    .confConditionalRequired(E7022DocValidationsConfig)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataShared.R011.getObject()))),

    CABANG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(4, null, "Cabang", sv(C, 1, 100, freeText)
                    .confConditionalRequired(E7022DocValidationsConfig))),

    TANGGAL_PEROLEHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(5, null, "Tanggal Perolehan", sv(C, 8, 8, date)
                    .confConditionalRequired(E7022DocValidationsConfig))),

    NILAI_NOMINAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(6, null, "Nilai Nominal", sv(M, 1, 18, numeric))),

    JANGKA_WAKTU_HARI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(7, null, "Jangka Waktu (Hari)", sv(C, 1, 3, numeric)
                    .confConditionalRequired(E7022DocValidationsConfig))),

    TINGKAT_BUNGA_NISBAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(8, null, "Tingkat Bunga/Nisbah (%)", sv(C, 4, 6, numericDot)
                    .confConditionalRequired(E7022DocValidationsConfig))),

    MANFAAT_PENSIUN_LAINNYA_LAIN_LCF(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(9, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF", sv(C, 1, 6, refTable)
                    .confConditionalRequired(E7022DocValidationsConfig)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataShared.R009.getObject()))),

    PENGELOLAAN_SWAKELOLA_KPD(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(10, null, "Pengelolaan Swakelola/ KPD, Not gound", sv(C, 1, 6, refTable)
                    .confRegex(SimpleValidation.patternAlfa)
                    .confConditionalRequired(E7022DocValidationsConfig)
                    .confReference(EHeaderMetadataShared.R006.getObject()))),

    PENGELOLAAN_NAMA_MANAJER_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(11, null, "Pengelolaan Nama Manajer Investasi", sv(C, 1, 250, freeText)
                    .confConditionalRequired(E7022DocValidationsConfig)
                    .confConditionalRequired(E7022DocValidationsConfig))),

    KETERANGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(12, null, "Keterangan", sv(C, 1, 250, freeText)
                    .confConditionalRequired(E7022DocValidationsConfig))),

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

    public static final BaseMetadataField<Dppk0022Doc> FIELD_PPMPK = new LbltMetadataField<>(Dppk0022Doc.class, PPMPK);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan DOC_FORM = EFormLaporanBulananTahunan.LTLB_DOC;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(DOC_FORM.getCode())
                .name(DOC_FORM.getName())
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