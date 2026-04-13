package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataShared;
import id.go.ojk.module.lblt.dppk.reference.ER7024PosLtlbDppkDpjkv;
import id.go.ojk.module.lblt.dppk.validations.E7024DpjkvValidationsConfig;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.constants.SectorType;
import id.go.ojk.util.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.util.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.util.metadata.submission.SubmissionConfig;
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
public enum Dppk0024Dpjkv implements ILbltFieldMetadata {

    FLAG(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(0, null, "Flag",
                    sv(M, 3, 3, alfaNumeric)
                            .confConstant("D01"))
    ),
    KODE_KOMPONEN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen",
                    sv(M, 11, 11, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataPpmpk.R7024Dpjkv.getObject()))
    ),
    NAMA_BANK(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(2, null, "Nama Bank",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7024DpjkvValidationsConfig))
    ),
    KODE_BANK(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(3, null, "Kode Bank",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7024DpjkvValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R011.getObject()))
    ),
    CABANG(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(4, null, "Cabang",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7024DpjkvValidationsConfig))
    ),
    TANGGAL_PEROLEHAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(5, null, "Tanggal Perolehan",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7024DpjkvValidationsConfig))
    ),
    NILAI_NOMINAL(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(6, null, "Nilai Nominal",
                    sv(M, 1, 18, numeric))
    ),
    NILAI_WAJAR(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(7, null, "Nilai Wajar",
                    sv(M, 1, 18, numeric))
    ),
    SELISIH_PENILAIAN_INVESTASI_NILAI(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(8, null, "Selisih Penilaian Investasi Nilai",
                    sv(M, 1, 18, numeric))
                    .addFieldValidations(E7024DpjkvValidationsConfig)
    ),
    SELISIH_PENILAIAN_INVESTASI_PERSEN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(9, null, "Selisih Penilaian Investasi %",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7024DpjkvValidationsConfig))
                    .addFieldValidations(E7024DpjkvValidationsConfig)
    ),
    JANGKA_WAKTU_HARI(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(10, null, "Jangka Waktu (Hari)",
                    sv(C, 1, 3, numeric)
                            .confConditionalRequired(E7024DpjkvValidationsConfig))
    ),
    TINGKAT_BUNGA_NISBAH(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(11, null, "Tingkat Bunga/Nisbah (%)",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7024DpjkvValidationsConfig))
    ),
    MANFAAT_PENSIUN_LAINNYA_LAIN_LCF(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(12, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7024DpjkvValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R009.getObject()))
    ),
    PENGELOLAAN_SWAKELOLA_KPD(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(13, null, "Pengelolaan Swakelola/ KPD",
                    sv(C, 1, 6, refTable)
                            .confRegex(SimpleValidation.patternAlfa)
                            .confConditionalRequired(E7024DpjkvValidationsConfig)
                            .confReference(EHeaderMetadataShared.R006.getObject()))
    ),
    PENGELOLAAN_NAMA_MANAJER_INVESTASI(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(14, null, "Pengelolaan Nama Manajer Investasi",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7024DpjkvValidationsConfig)
                            .confConditionalRequired(E7024DpjkvValidationsConfig))
    ),
    JENIS_MATA_UANG(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(15, null, "Jenis Mata Uang",
                    sv(C, 1, 8, refTable)
                            .confConditionalRequired(E7024DpjkvValidationsConfig)
                            .confRegex(SimpleValidation.PATTERN_REFERENCE_3)
                            .confReference(EHeaderMetadataShared.R010.getObject()))
    ),
    KETERANGAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(16, null, "Keterangan",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7024DpjkvValidationsConfig))
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
    public EnumSet<SectorType> getSectorTypes() {
        return sectorType;
    }

    @Override
    public EnumSet<ProgramType> getProgramType() {
        return programType;
    }

    public static final LbltMetadataField<Dppk0024Dpjkv> FIELD_KONVEN = new LbltMetadataField<>(Dppk0024Dpjkv.class, KONVENSIONAL);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan DPJKV_FORM = EFormLaporanBulananTahunan.LTLB_DPJKV;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(DPJKV_FORM.getCode())
                .name(DPJKV_FORM.getName())
                .extension(ExtensionType.TXT)
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

    public static SubmissionFormat ppmpkKonvensionalFormMetadata(String reportCode) {
        FIELD_KONVEN.setProgramType(ProgramType.PPMPK);
        return new SubmissionConfig(reportCode)
                .config()
                .setRequiredPos(ER7024PosLtlbDppkDpjkv.getRequiredPos())
                .setSubmissionFormat(getSubmissionFormatConfig(KONVENSIONAL, reportCode))
                .setSubmissionField(FIELD_KONVEN.getFields())
                .setSegmentValidations(E7024DpjkvValidationsConfig.VALIDATION_METADATA)
                .build()
                .get();
    }
}