package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.validations.ppmpk.E7002LpanValidationsConfig;
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
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;
import static id.go.ojk.util.FieldUtil.sf;
import static id.go.ojk.util.FieldUtil.sv;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0002Lpan implements ILbltFieldMetadata {

    FLAG(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01"))
    ),
    KODE_KOMPONEN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen",
                    sv(O, 14, 14, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataPpmpk.R7002Lpan.getObject()))
                    .confUnique(UniqueType.U)
    ),
    MANFAAT_PENSIUN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(2, null, "Manfaat Pensiun", sv(O, 1, 18, numericNegatif))
    ),
    MANFAAT_PENSIUN_LAINNYA_MANFAAT_TAMBAHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(3, null, "Manfaat Pensiun Lainnya Manfaat Tambahan", sv(O, 1, 18, numericNegatif))
    ),
    MANFAAT_PENSIUN_LAINNYA_KOMPENSASI_PASCAKERJA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(4, null, "Manfaat Pensiun Lainnya Kompensasi Pascakerja", sv(O, 1, 18, numericNegatif))
    ),
    MANFAAT_PENSIUN_LAINNYA_LAINNYA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(5, null, "Manfaat Pensiun Lainnya Lainnya", sv(O, 1, 18, numericNegatif))
    ),
    MANFAAT_LAIN_KOMPENSASI_PASCAKERJA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(6, null, "Manfaat Lain Kompensasi Pascakerja", sv(O, 1, 18, numericNegatif))
    ),
    MANFAAT_LAIN_KESEHATAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(7, null, "Manfaat Lain Kesehatan", sv(O, 1, 18, numericNegatif))
    ),
    MANFAAT_LAIN_SANTUNAN_KEMATIAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(8, null, "Manfaat Lain Santunan Kematian", sv(O, 1, 18, numericNegatif))
    ),
    MANFAAT_LAIN_IBADAH_KEAGAMAAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(9, null, "Manfaat Lain Ibadah Keagamaan", sv(O, 1, 18, numericNegatif))
    ),
    MANFAAT_LAIN_PENDIDIKAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(10, null, "Manfaat Lain Pendidikan", sv(O, 1, 18, numericNegatif))
    ),
    MANFAAT_LAIN_LAINNYA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(11, null, "Manfaat Lain Lainnya", sv(O, 1, 18, numericNegatif))
    ),
    GABUNGAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(12, null, "Gabungan", sv(O, 1, 18, numericNegatif))
                    .addFieldValidations(E7002LpanValidationsConfig)
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

    public static final BaseMetadataField<Dppk0002Lpan> FIELD_PPMPK = new LbltMetadataField<>(Dppk0002Lpan.class, PPMPK);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan LPAN_FORM = EFormLaporanBulananTahunan.LTLB_LPAN;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(LPAN_FORM.getCode())
                .name(LPAN_FORM.getName())
                .extension(ExtensionType.TXT.getExtension())
                .reportCode(reportCode)
                .maxRow(25)
                .fields(new ArrayList<>())
                .build();

        if (sectorType.equals(KONVENSIONAL)) {
            sfConfig.setMinRow(25);
            return sfConfig;
        } else if (sectorType.equals(SYARIAH)) {
            sfConfig.setMinRow(9999);
            return sfConfig;
        }

        throw new IllegalArgumentException("Unknown sector type: " + sectorType);
    }
}