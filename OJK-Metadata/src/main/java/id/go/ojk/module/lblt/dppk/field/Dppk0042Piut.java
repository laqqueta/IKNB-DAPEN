package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataShared;
import id.go.ojk.module.lblt.dppk.reference.ER7042PosLtlbDppkPiut;
import id.go.ojk.module.lblt.dppk.validations.E7042PiutValidationsConfig;
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
public enum Dppk0042Piut implements ILbltFieldMetadata {

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
                    sv(M, 10, 10, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataPpmpk.R7042Piut.getObject()))
    ),
    NAMA_PEMBERI_KERJA(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(2, null, "Nama Pemberi Kerja(Pendiri/Mitra Pendiri)",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7042PiutValidationsConfig))
    ),
    PIUTANG_IURAN_PEMBERI_KERJA_LTE_1_BULAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(3, null, "Piutang Iuran Pemberi Kerja Usia Piutang <=1 Bulan",
                    sv(M, 1, 18, numeric))
    ),
    PIUTANG_IURAN_PEMBERI_KERJA_GT_1_BULAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(4, null, "Piutang Iuran Pemberi Kerja Usia Piutang >1 Bulan",
                    sv(M, 1, 18, numeric))
    ),
    PIUTANG_IURAN_PEMBERI_KERJA_TOTAL(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(5, null, "Piutang Iuran Pemberi Kerja Total",
                    sv(M, 1, 18, numeric))
                    .addFieldValidations(E7042PiutValidationsConfig)
    ),
    PIUTANG_IURAN_PESERTA_LTE_1_BULAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(6, null, "Piutang Iuran Peserta Usia Piutang <=1 Bulan",
                    sv(M, 1, 18, numeric))
    ),
    PIUTANG_IURAN_PESERTA_GT_1_BULAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(7, null, "Piutang Iuran Peserta Usia Piutang >1 Bulan",
                    sv(M, 1, 18, numeric))
    ),
    PIUTANG_IURAN_PESERTA_TOTAL(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(8, null, "Piutang Iuran Peserta Total",
                    sv(M, 1, 18, numeric))
                    .addFieldValidations(E7042PiutValidationsConfig)
    ),
    PIUTANG_IURAN_TAMBAHAN_LTE_1_BULAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(9, null, "Piutang Iuran Tambahan Usia Piutang <=1 Bulan",
                    sv(M, 1, 18, numeric))
    ),
    PIUTANG_IURAN_TAMBAHAN_GT_1_BULAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(10, null, "Piutang Iuran Tambahan Usia Piutang >1 Bulan",
                    sv(M, 1, 18, numeric))
    ),
    PIUTANG_IURAN_TAMBAHAN_TOTAL(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(11, null, "Piutang Iuran Tambahan Total",
                    sv(M, 1, 18, numeric))
                    .addFieldValidations(E7042PiutValidationsConfig)
    ),
    PIUTANG_IURAN_SUKARELA_PESERTA(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(12, null, "Piutang Iuran Sukarela Peserta",
                    sv(M, 1, 18, numeric))
    ),
    MANFAAT_PENSIUN_LAINNYA_LAIN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(13, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7042PiutValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R009.getObject()))
    ),
    KETERANGAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(14, null, "Keterangan",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7042PiutValidationsConfig))
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

    public static final LbltMetadataField<Dppk0042Piut> FIELD_KONVEN = new LbltMetadataField<>(Dppk0042Piut.class, KONVENSIONAL);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan PIUT_FORM = EFormLaporanBulananTahunan.LTLB_PIUT;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(PIUT_FORM.getCode())
                .name(PIUT_FORM.getName())
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
                .setRequiredPos(ER7042PosLtlbDppkPiut.getRequiredPos())
                .setSubmissionFormat(getSubmissionFormatConfig(KONVENSIONAL, reportCode))
                .setSubmissionField(FIELD_KONVEN.getFields())
                .setSegmentValidations(E7042PiutValidationsConfig.VALIDATION_METADATA)
                .build()
                .get();
    }
}