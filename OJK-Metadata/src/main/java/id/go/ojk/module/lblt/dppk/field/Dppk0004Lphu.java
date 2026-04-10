package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.validations.ppmpk.E7004LphuValidationsConfig;
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
public enum Dppk0004Lphu implements ILbltFieldMetadata {

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
                    .confReference(EHeaderMetadataPpmpk.R7004Lphu.getObject()))
                    .confUnique(UniqueType.U)
    ),
    AKUMULASI_MANFAAT_PENSIUN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(2, null, "Akumulasi s.d DD-MM-YYYY Manfaat Pensiun", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_PENSIUN_LAINNYA_MANFAAT_TAMBAHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(3, null, "Akumulasi s.d DD-MM-YYYY Manfaat Pensiun Lainnya Manfaat Tambahan", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_PENSIUN_LAINNYA_KOMPENSASI_PASCAKERJA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(4, null, "Akumulasi s.d DD-MM-YYYY Manfaat Pensiun Lainnya Kompensasi Pascakerja", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_PENSIUN_LAINNYA_LAINNYA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(5, null, "Akumulasi s.d DD-MM-YYYY Manfaat Pensiun Lainnya Lainnya", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_LAIN_KOMPENSASI_PASCAKERJA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(6, null, "Akumulasi s.d DD-MM-YYYY Manfaat Lain Kompensasi Pascakerja", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_LAIN_KESEHATAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(7, null, "Akumulasi s.d DD-MM-YYYY Manfaat Lain Kesehatan", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_LAIN_SANTUNAN_KEMATIAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(8, null, "Akumulasi s.d DD-MM-YYYY Manfaat Lain Santunan Kematian", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_LAIN_IBADAH_KEAGAMAAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(9, null, "Akumulasi s.d DD-MM-YYYY Manfaat Lain Ibadah Keagamaan", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_LAIN_PENDIDIKAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(10, null, "Akumulasi s.d DD-MM-YYYY Manfaat Lain Pendidikan", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_LAIN_LAINNYA(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(11, null, "Akumulasi s.d DD-MM-YYYY Manfaat Lain Lainnya", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_GABUNGAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(12, null, "Akumulasi s.d DD-MM-YYYY Gabungan", sv(O, 1, 18, numericNegatif))
                    .addFieldValidations(E7004LphuValidationsConfig)
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

    public static final BaseMetadataField<Dppk0004Lphu> FIELD_PPMPK = new LbltMetadataField<>(Dppk0004Lphu.class, PPMPK);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan LPHU_FORM = EFormLaporanBulananTahunan.LTLB_LPHU;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(LPHU_FORM.getCode())
                .name(LPHU_FORM.getName())
                .extension(ExtensionType.TXT.getExtension())
                .reportCode(reportCode)
                .maxRow(31)
                .fields(new ArrayList<>())
                .build();

        if (sectorType.equals(KONVENSIONAL)) {
            sfConfig.setMinRow(31);
            return sfConfig;
        } else if (sectorType.equals(SYARIAH)) {
            sfConfig.setMinRow(9999);
            return sfConfig;
        }

        throw new IllegalArgumentException("Unknown sector type: " + sectorType);
    }
}