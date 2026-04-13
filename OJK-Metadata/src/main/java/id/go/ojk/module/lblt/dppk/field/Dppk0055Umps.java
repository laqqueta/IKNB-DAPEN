package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.reference.ER7055PosLtlbDppkUmps;
import id.go.ojk.module.lblt.dppk.validations.E7055UmpsValidationsConfig;
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
public enum Dppk0055Umps implements ILbltFieldMetadata {

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
                            .confReference(EHeaderMetadataPpmpk.R7055Umps.getObject()))
    ),
    JUMLAH_LTE_1_TAHUN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(2, null, "Jumlah <= 1 tahun",
                    sv(M, 1, 18, numeric))
    ),
    JUMLAH_GT_1_TAHUN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(3, null, "Jumlah > 1 tahun",
                    sv(M, 1, 18, numeric))
    ),
    JUMLAH_TOTAL(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(4, null, "Jumlah Total",
                    sv(M, 1, 18, numeric))
                    .addFieldValidations(E7055UmpsValidationsConfig)
    ),
    KETERANGAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(5, null, "Keterangan",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7055UmpsValidationsConfig))
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

    public static final LbltMetadataField<Dppk0055Umps> FIELD_KONVEN = new LbltMetadataField<>(Dppk0055Umps.class, KONVENSIONAL);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan UMPS_FORM = EFormLaporanBulananTahunan.LTLB_UMPS;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(UMPS_FORM.getCode())
                .name(UMPS_FORM.getName())
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
                .setRequiredPos(ER7055PosLtlbDppkUmps.getRequiredPos())
                .setSubmissionFormat(getSubmissionFormatConfig(KONVENSIONAL, reportCode))
                .setSubmissionField(FIELD_KONVEN.getFields())
                .setSegmentValidations(E7055UmpsValidationsConfig.VALIDATION_METADATA)
                .build()
                .get();
    }
}