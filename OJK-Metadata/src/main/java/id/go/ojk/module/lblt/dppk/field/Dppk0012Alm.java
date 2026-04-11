package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.constants.SectorType;
import id.go.ojk.util.metadata.field.base.BaseMetadataField;
import id.go.ojk.util.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.util.metadata.field.lblt.LbltMetadataField;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.EnumSet;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;
import static id.go.ojk.util.FieldUtil.*;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0012Alm implements ILbltFieldMetadata {

    FLAG(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01"))
    ),
    KODE_KOMPONEN(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen", sv(O, 17, 17, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataPpmpk.R7012Alm.getObject()))
                    .confUnique(UniqueType.U)
    ),
    JT_LT_1_TAHUN_RUPIAH(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(2, null, "Jatuh tempo < 1 tahun - Rupiah", sv(O, 1, 18, numeric))
    ),
    JT_LT_1_TAHUN_NON_RUPIAH(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(3, null, "Jatuh tempo < 1 tahun - Non Rupiah", sv(O, 1, 18, numeric))
    ),
    JT_LT_1_TAHUN_TOTAL(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(4, null, "Jatuh tempo < 1 tahun - Total", sv(O, 1, 18, numeric)
                    .confConditionalRequired(E7012AlmValidationsConfig))
                    .addFieldValidations(E7012AlmValidationsConfig)
    ),
    JT_1_5_TAHUN_RUPIAH(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(5, null, "1 tahun <= jatuh tempo < 5 tahun - Rupiah", sv(O, 1, 18, numeric))
    ),
    JT_1_5_TAHUN_NON_RUPIAH(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(6, null, "1 tahun <= jatuh tempo < 5 tahun - Non Rupiah", sv(O, 1, 18, numeric))
    ),
    JT_1_5_TAHUN_TOTAL(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(7, null, "1 tahun <= jatuh tempo < 5 tahun - Total", sv(O, 1, 18, numeric)
                    .confConditionalRequired(E7012AlmValidationsConfig))
                    .addFieldValidations(E7012AlmValidationsConfig)
    ),
    JT_5_10_TAHUN_RUPIAH(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(8, null, "5 tahun <= jatuh tempo < 10 tahun - Rupiah", sv(O, 1, 18, numeric))
    ),
    JT_5_10_TAHUN_NON_RUPIAH(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(9, null, "5 tahun <= jatuh tempo < 10 tahun - Non Rupiah", sv(O, 1, 18, numeric))
    ),
    JT_5_10_TAHUN_TOTAL(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(10, null, "5 tahun <= jatuh tempo < 10 tahun - Total", sv(O, 1, 18, numeric)
                    .confConditionalRequired(E7012AlmValidationsConfig))
                    .addFieldValidations(E7012AlmValidationsConfig)
    ),
    JT_GTE_10_TAHUN_RUPIAH(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(11, null, "Jatuh Tempo >= 10 Tahun - Rupiah", sv(O, 1, 18, numeric))
    ),
    JT_GTE_10_TAHUN_NON_RUPIAH(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(12, null, "Jatuh Tempo >= 10 - Non Rupiah", sv(O, 1, 18, numeric))
    ),
    JT_GTE_10_TAHUN_TOTAL(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(13, null, "Jatuh Tempo >= 10 - Total", sv(O, 1, 18, numeric)
                    .confConditionalRequired(E7012AlmValidationsConfig))
                    .addFieldValidations(E7012AlmValidationsConfig)
    ),
    TOTAL_RUPIAH(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(14, null, "Total - Rupiah", sv(O, 1, 18, numeric))
                    .addFieldValidations(E7012AlmValidationsConfig)
    ),
    TOTAL_NON_RUPIAH(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(15, null, "Total - Non Rupiah", sv(O, 1, 18, numeric))
                    .addFieldValidations(E7012AlmValidationsConfig)
    ),
    TOTAL_TOTAL(
            EnumSet.of(KONVENSIONAL, SYARIAH),
            EnumSet.of(PPMPK, PPMPM),
            sf(16, null, "Total - Total", sv(O, 1, 18, numeric)
                    .confConditionalRequired(E7012AlmValidationsConfig))
                    .addFieldValidations(E7012AlmValidationsConfig)
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

    public static final BaseMetadataField<Dppk0012Alm> FIELD_PPMPK = new LbltMetadataField<>(Dppk0012Alm.class, PPMPK);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan ALM_FORM = EFormLaporanBulananTahunan.LTLB_ALM;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(ALM_FORM.getCode())
                .name(ALM_FORM.getName())
                .extension(ExtensionType.TXT.getType())
                .reportCode(reportCode)
                .maxRow(52)
                .fields(new ArrayList<>())
                .build();

        if (sectorType.equals(KONVENSIONAL)) {
            sfConfig.setMinRow(52);
            return sfConfig;
        } else if (sectorType.equals(SYARIAH)) {
            sfConfig.setMinRow(9999);
            return sfConfig;
        }

        throw new IllegalArgumentException("Unknown sector type: " + sectorType);
    }
}