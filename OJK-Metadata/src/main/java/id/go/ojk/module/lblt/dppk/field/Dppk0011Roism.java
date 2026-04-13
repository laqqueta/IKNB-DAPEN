package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.reference.ER7011PosLtlbDppkRoism;
import id.go.ojk.module.lblt.dppk.validations.E7011RoismValidationsConfig;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.constants.SectorType;
import id.go.ojk.util.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.util.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.util.metadata.submission.SubmissionConfig;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.EnumSet;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;
import static id.go.ojk.util.FieldUtil.*;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0011Roism implements ILbltFieldMetadata {

    FLAG(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01"))
    ),
    KODE_KOMPONEN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen", sv(O, 15, 15, refTable)
                    .confReference(EHeaderMetadataPpmpk.R7011Roism.getObject())
                    .confRegex(SimpleValidation.patternAlfaNumeric))
                    .confUnique(UniqueType.U)
    ),
    HASIL_INVESTASI_TEREALISASI_BUNGA_BAGI_HASIL(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(2, null, "Hasil investasi yang terealisasi Bunga/ Bagi Hasil", sv(O, 1, 18, numeric))
    ),
    HASIL_INVESTASI_TEREALISASI_DIVIDEN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(3, null, "Hasil investasi yang terealisasi Dividen", sv(O, 1, 18, numeric))
    ),
    HASIL_INVESTASI_TEREALISASI_SEWA(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(4, null, "Hasil investasi yang terealisasi Sewa", sv(O, 1, 18, numeric))
    ),
    HASIL_INVESTASI_TEREALISASI_LABA_RUGI_PELEPASAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(5, null, "Hasil investasi yang terealisasi Laba/Rugi Pelepasan", sv(O, 1, 18, numeric))
    ),
    HASIL_INVESTASI_TEREALISASI_LAINNYA(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(6, null, "Hasil investasi yang terealisasi Lainnya", sv(O, 1, 18, numeric))
    ),
    HASIL_INVESTASI_BELUM_TEREALISASI(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(7, null, "Hasil Investasi yang Belum Terealisasi", sv(O, 1, 18, numeric))
    ),
    BEBAN_INVESTASI(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(8, null, "Beban Investasi", sv(O, 1, 18, numeric))
    ),
    HASIL_INVESTASI_BERSIH(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(9, null, "Hasil investasi bersih", sv(O, 1, 18, numeric))
                    .addFieldValidations(E7011RoismValidationsConfig)
    ),
    RATA_RATA_INVESTASI(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(10, null, "Rata-rata Investasi", sv(O, 1, 18, numeric))
    ),
    ROI(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(11, null, "ROI", sv(O, 3, 18, numericDot))
                    .addFieldValidations(E7011RoismValidationsConfig)
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

    public static final LbltMetadataField<Dppk0011Roism> FIELD_KONVEN = new LbltMetadataField<>(Dppk0011Roism.class, KONVENSIONAL);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan ROISM_FORM = EFormLaporanBulananTahunan.LTLB_ROI_S_M;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(ROISM_FORM.getCode())
                .name(ROISM_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(reportCode)
                .maxRow(21)
                .fields(new ArrayList<>())
                .build();

        if (sectorType.equals(KONVENSIONAL)) {
            sfConfig.setMinRow(21);
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
                .setRequiredPos(ER7011PosLtlbDppkRoism.getRequiredPos())
                .setSubmissionFormat(getSubmissionFormatConfig(KONVENSIONAL, reportCode))
                .setSubmissionField(FIELD_KONVEN.getFields())
                .setSegmentValidations(E7011RoismValidationsConfig.VALIDATION_METADATA)
                .build()
                .get();
    }
}
