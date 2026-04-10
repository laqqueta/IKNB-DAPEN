package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataShared;
import id.go.ojk.module.lblt.dppk.validations.E7028ShmValidationsConfig;
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
public enum Dppk0028Shm implements ILbltFieldMetadata {

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
                    sv(M, 9, 9, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataPpmpk.R7028Shm.getObject()))
    ),
    KODE_SAHAM(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(2, null, "Kode Saham",
                    sv(C, 1, 4, alfaNumeric)
                            .confConditionalRequired(E7028ShmValidationsConfig))
    ),
    NAMA_EMITEN_PENERBIT(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(3, null, "Nama Emiten /Penerbit",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7028ShmValidationsConfig))
    ),
    TANGGAL_PEROLEHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(4, null, "Tanggal Perolehan",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7028ShmValidationsConfig))
    ),
    JUMLAH_SAHAM(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(5, null, "Jumlah Saham",
                    sv(M, 1, 13, numeric))
    ),
    NILAI_PEROLEHAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(6, null, "Nilai Perolehan",
                    sv(M, 1, 18, numeric))
    ),
    NILAI_PASAR(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(7, null, "Nilai Pasar",
                    sv(M, 1, 18, numeric))
    ),
    SELISIH_PENILAIAN_INVESTASI_NILAI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(8, null, "Selisih Penilaian Investasi Nilai",
                    sv(M, 1, 18, numeric))
                    .addFieldValidations(E7028ShmValidationsConfig)
    ),
    SELISIH_PENILAIAN_INVESTASI_PERSEN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(9, null, "Selisih Penilaian Investasi %",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7028ShmValidationsConfig))
                    .addFieldValidations(E7028ShmValidationsConfig)
    ),
    SEKTOR_EKONOMI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(10, null, "Sektor Ekonomi",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7028ShmValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R007.getObject()))
    ),
    MANFAAT_PENSIUN_LAINNYA_LAIN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(11, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7028ShmValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R009.getObject()))
    ),
    PENGELOLAAN_SWAKELOLA_KPD(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(12, null, "Pengelolaan Swakelola/ KPD",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7028ShmValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfa)
                            .confReference(EHeaderMetadataShared.R006.getObject()))
    ),
    PENGELOLAAN_NAMA_MANAJER_INVESTASI(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(13, null, "Pengelolaan Nama Manajer Investasi",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7028ShmValidationsConfig)
                            .confConditionalRequired(E7028ShmValidationsConfig))
    ),
    KETERANGAN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(14, null, "Keterangan",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7028ShmValidationsConfig))
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

    public static final BaseMetadataField<Dppk0028Shm> FIELD_PPMPK = new LbltMetadataField<>(Dppk0028Shm.class, PPMPK);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan SHM_FORM = EFormLaporanBulananTahunan.LTLB_SHM;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(SHM_FORM.getCode())
                .name(SHM_FORM.getName())
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