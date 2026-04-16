package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.module.lblt.dppk.reference.ER7013PosLtlbDppkInsp;
import id.go.ojk.module.lblt.dppk.validations.E7013InspValidationsConfig;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.constants.SectorType;
import id.go.ojk.util.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.util.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.util.metadata.submission.SubmissionConfig;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.EnumSet;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.freeText;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;
import static id.go.ojk.util.FieldUtil.*;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0013Insp implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01"))
    ),
    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen", sv(O, 10, 10, refTable)
                    .confReference(EHeaderMetadataPpmpk.R7013Insp.getObject())
                    .confRegex(SimpleValidation.patternAlfaNumeric))
    ),
    NAMA_PIHAK(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(2, null, "Nama Pihak", sv(O, 1, 100, freeText)
                    .confConditionalRequired(E7013InspValidationsConfig.CR_EXIST_POS_M))
    ),
    INVESTASI_JENIS(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(3, null, "Investasi Jenis", sv(O, 1, 100, freeText)
                    .confConditionalRequired(E7013InspValidationsConfig.CR_EXIST_POS_M))
    ),
    INVESTASI_JUMLAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(4, null, "Investasi Jumlah", sv(O, 1, 18, numeric))
    ),
    INVESTASI_PERSENTASE_TERHADAP_TOTAL_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(5, null, "Investasi Persentase Terhadap Total Investasi", sv(O, 4, 6, numericDot)
                    .confConditionalRequired(E7013InspValidationsConfig.CR_EXIST_POS_M))
    ),
    BATASAN_DALAM_ARAHAN_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(6, null, "Batasan Dalam Arahan Investasi", sv(O, 1, 18, numeric)
                    .confConditionalRequired(E7013InspValidationsConfig.CR_EXIST_POS_M))
    ),
    BATASAN_INVESTASI_SESUAI_KETENTUAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(7, null, "Batasan Investasi Sesuai Ketentuan", sv(O, 1, 18, numeric)
                    .confConditionalRequired(E7013InspValidationsConfig.CR_EXIST_POS_O))
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

    public static final LbltMetadataField<Dppk0013Insp> FIELD_KONVEN = new LbltMetadataField<>(Dppk0013Insp.class, KONVENSIONAL);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan INSP_FORM = EFormLaporanBulananTahunan.LTLB_INSP;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(INSP_FORM.getCode())
                .name(INSP_FORM.getName())
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
                .setReferenceConfigs(ER7013PosLtlbDppkInsp.Configs.REF_CONFIG_PPMPK)
                .setSubmissionFormat(getSubmissionFormatConfig(KONVENSIONAL, reportCode))
                .setSubmissionField(FIELD_KONVEN.getFields())
                .setSegmentValidations(E7013InspValidationsConfig.VALIDATION_METADATA)
                .build()
                .get();
    }
}