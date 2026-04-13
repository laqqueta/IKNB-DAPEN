package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataShared;
import id.go.ojk.module.lblt.dppk.reference.ER7041PosLtlbDppkKasb;
import id.go.ojk.module.lblt.dppk.validations.E7041KasbValidationsConfig;
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
public enum Dppk0041Kasb implements ILbltFieldMetadata {

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
                            .confReference(EHeaderMetadataPpmpk.R7041Kasb.getObject()))
    ),
    NAMA_BANK(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(2, null, "Nama Bank",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7041KasbValidationsConfig))
    ),
    KODE_BANK(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(3, null, "Kode Bank",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7041KasbValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R011.getObject()))
    ),
    CABANG(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(4, null, "Cabang",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7041KasbValidationsConfig))
    ),
    NO_REKENING(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(5, null, "No Rekening",
                    sv(C, 1, 20, alfaNumeric)
                            .confConditionalRequired(E7041KasbValidationsConfig))
    ),
    NOMINAL(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(6, null, "Nominal",
                    sv(M, 1, 18, numeric))
    ),
    MANFAAT_PENSIUN_LAINNYA_LAIN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(7, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7041KasbValidationsConfig)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataShared.R009.getObject()))
    ),
    KETERANGAN_TUJUAN_PENGGUNAAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK, PPMPM),
            sf(8, null, "Keterangan (Tujuan penggunaan)",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7041KasbValidationsConfig))
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

    public static final LbltMetadataField<Dppk0041Kasb> FIELD_KONVEN = new LbltMetadataField<>(Dppk0041Kasb.class, KONVENSIONAL);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan KASB_FORM = EFormLaporanBulananTahunan.LTLB_KASB;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(KASB_FORM.getCode())
                .name(KASB_FORM.getName())
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
                .setRequiredPos(ER7041PosLtlbDppkKasb.getRequiredPos())
                .setSubmissionFormat(getSubmissionFormatConfig(KONVENSIONAL, reportCode))
                .setSubmissionField(FIELD_KONVEN.getFields())
                .setSegmentValidations(E7041KasbValidationsConfig.VALIDATION_METADATA)
                .build()
                .get();
    }
}