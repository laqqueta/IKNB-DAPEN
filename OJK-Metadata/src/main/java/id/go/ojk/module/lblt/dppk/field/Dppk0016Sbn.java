package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataShared;
import id.go.ojk.module.lblt.dppk.reference.ER7016PosLtlbDppkSbn;
import id.go.ojk.module.lblt.dppk.validations.E7016SbnValidationsConfig;
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
public enum Dppk0016Sbn implements ILbltFieldMetadata {

    FLAG(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01"))
    ),
    KODE_KOMPONEN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen", sv(O, 9, 9, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataPpmpk.R7016Sbn.getObject()))
    ),
    JENIS_INVESTASI(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(2, null, "Jenis Investasi", sv(O, 1, 6, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataShared.R022.getObject())
                    .confConditionalRequired(E7016SbnValidationsConfig))
    ),
    NAMA_JENIS_INVESTASI(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(3, null, "Nama Jenis Investasi", sv(O, 1, 100, freeText)
                    .confConditionalRequired(E7016SbnValidationsConfig))
    ),
    SERI_EFEK(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(4, null, "Seri Efek", sv(O, 1, 100, freeText)
                    .confConditionalRequired(E7016SbnValidationsConfig))
    ),
    JENIS_KEPEMILIKAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(5, null, "Jenis Kepemilikan", sv(O, 1, 100, freeText)
                    .confConditionalRequired(E7016SbnValidationsConfig))
    ),
    RATING(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(6, null, "Rating", sv(O, 1, 100, freeText)
                    .confConditionalRequired(E7016SbnValidationsConfig))
    ),
    MENAJER_INVESTASI(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(7, null, "Menajer Investasi", sv(O, 1, 100, freeText)
                    .confConditionalRequired(E7016SbnValidationsConfig))
    ),
    NILAI_WAJAR(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(8, null, "Nilai Wajar", sv(O, 1, 18, numeric)
                    .confConditionalRequired(E7016SbnValidationsConfig))
    ),
    PERSEN_SBN_DALAM_REKSADANA(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(9, null, "% SBN dalam Reksadana", sv(O, 4, 6, numericDot)
                    .confConditionalRequired(E7016SbnValidationsConfig))
    ),
    SALDO(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(10, null, "Saldo", sv(O, 1, 18, numeric)
                    .confConditionalRequired(E7016SbnValidationsConfig))
    ),
    EMITEN_PENERIMA_DANA_PROJECT(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(11, null, "Emiten Penerima Dana/Project", sv(O, 1, 100, alfa)
                    .confConditionalRequired(E7016SbnValidationsConfig))
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

    public static final LbltMetadataField<Dppk0016Sbn> FIELD_KONVEN = new LbltMetadataField<>(Dppk0016Sbn.class, KONVENSIONAL);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan SBN_FORM = EFormLaporanBulananTahunan.LTLB_SBN;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(SBN_FORM.getCode())
                .name(SBN_FORM.getName())
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
                .setRequiredPos(ER7016PosLtlbDppkSbn.getRequiredPos())
                .setSubmissionFormat(getSubmissionFormatConfig(KONVENSIONAL, reportCode))
                .setSubmissionField(FIELD_KONVEN.getFields())
                .setSegmentValidations(E7016SbnValidationsConfig.VALIDATION_METADATA)
                .build()
                .get();
    }
}