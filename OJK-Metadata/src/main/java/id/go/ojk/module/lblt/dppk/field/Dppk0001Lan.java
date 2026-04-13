package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.reference.ER7001PosLtlbDppkLan;
import id.go.ojk.module.lblt.dppk.validations.E7000DtumValidationsConfig;
import id.go.ojk.module.lblt.dppk.validations.ppmpk.E7001LanValidationsConfig;
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
public enum Dppk0001Lan implements ILbltFieldMetadata {

    FLAG(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01"))
    ),
    KODE_KOMPONEN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen",
                    sv(O, 13, 13, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataPpmpk.R7001Lan.getObject()))
                    .confUnique(UniqueType.U)
    ),
    PERSENTASE_INVESTASI(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(2, null, "Persentase Investasi", sv(O, 4, 6, numericDot))
    ),
    MANFAAT_PENSIUN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(3, null, "Manfaat Pensiun", sv(O, 1, 18, numeric))
    ),
    MANFAAT_PENSIUN_LAINNYA_MANFAAT_TAMBAHAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(4, null, "Manfaat Pensiun Lainnya Manfaat Tambahan", sv(O, 1, 18, numeric))
    ),
    MANFAAT_PENSIUN_LAINNYA_KOMPENSASI_PASCAKERJA(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(5, null, "Manfaat Pensiun Lainnya Kompensasi Pascakerja", sv(O, 1, 18, numeric))
    ),
    MANFAAT_PENSIUN_LAINNYA_LAINNYA(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(6, null, "Manfaat Pensiun Lainnya Lainnya", sv(O, 1, 18, numeric))
    ),
    MANFAAT_LAIN_KOMPENSASI_PASCAKERJA(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(7, null, "Manfaat Lain Kompensasi Pascakerja", sv(O, 1, 18, numeric))
    ),
    MANFAAT_LAIN_KESEHATAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(8, null, "Manfaat Lain Kesehatan", sv(O, 1, 18, numeric))
    ),
    MANFAAT_LAIN_SANTUNAN_KEMATIAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(9, null, "Manfaat Lain Santunan Kematian", sv(O, 1, 18, numeric))
    ),
    MANFAAT_LAIN_IBADAH_KEAGAMAAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(10, null, "Manfaat Lain Ibadah Keagamaan", sv(O, 1, 18, numeric))
    ),
    MANFAAT_LAIN_PENDIDIKAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(11, null, "Manfaat Lain Pendidikan", sv(O, 1, 18, numeric))
    ),
    MANFAAT_LAIN_LAINNYA(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(12, null, "Manfaat Lain Lainnya", sv(O, 1, 18, numeric))
    ),
    GABUNGAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(13, null, "Gabungan", sv(O, 1, 18, numeric))
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

    public static final LbltMetadataField<Dppk0001Lan> FIELD_METADATA = new LbltMetadataField<>(Dppk0001Lan.class, KONVENSIONAL);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan LAN_FORM = EFormLaporanBulananTahunan.LTLB_LAN;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(LAN_FORM.getCode())
                .name(LAN_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(reportCode)
                .maxRow(49)
                .fields(new ArrayList<>())
                .build();

        if (sectorType.equals(KONVENSIONAL)) {
            sfConfig.setMinRow(49);
            return sfConfig;
        } else if (sectorType.equals(SYARIAH)) {
            sfConfig.setMinRow(9999);
            return sfConfig;
        }

        throw new IllegalArgumentException("Unknown sector type: " + sectorType);
    }

    public static SubmissionFormat ppmpkKonvensionalFormMetadata(String reportCode) {
        FIELD_METADATA.setProgramType(ProgramType.PPMPK);
        return new SubmissionConfig(reportCode)
                .config()
                .setRequiredPos(ER7001PosLtlbDppkLan.getRequiredPos(ProgramType.PPMPK))
                .setSubmissionFormat(getSubmissionFormatConfig(KONVENSIONAL, reportCode))
                .setSubmissionField(FIELD_METADATA.getFields())
                .setSegmentValidations(E7001LanValidationsConfig.VALIDATION_METADATA)
                .build()
                .get();
    }
}