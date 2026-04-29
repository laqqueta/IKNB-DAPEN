package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpm;
import id.go.ojk.module.lblt.dppk.reference.ER7008PosLtlbDppkRekinv;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.constants.SectorType;
import id.go.ojk.util.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.util.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.util.metadata.submission.SubmissionConfig;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;
import static id.go.ojk.util.FieldUtil.*;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0008Rekinv implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01"))
    ),
    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen", sv(O, 16, 16, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
                    .confUnique(UniqueType.U)
    ),
    JAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(2, null, "Jan", sv(O, 1, 18, numeric))
    ),
    FEB(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(3, null, "Feb", sv(O, 1, 18, numeric))
    ),
    MAR(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(4, null, "Mar", sv(O, 1, 18, numeric))
    ),
    APR(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(5, null, "Apr", sv(O, 1, 18, numeric))
    ),
    MEI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(6, null, "Mei", sv(O, 1, 18, numeric))
    ),
    JUN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(7, null, "Jun", sv(O, 1, 18, numeric))
    ),
    JUL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(8, null, "Jul", sv(O, 1, 18, numeric))
    ),
    AGU(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(9, null, "Agu", sv(O, 1, 18, numeric))
    ),
    SEP(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(10, null, "Sep", sv(O, 1, 18, numeric))
    ),
    OKT(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(11, null, "Okt", sv(O, 1, 18, numeric))
    ),
    NOV(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(12, null, "Nov", sv(O, 1, 18, numeric))
    ),
    DES(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(13, null, "Des", sv(O, 1, 18, numeric))
    ),
    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7008Rekinv.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7008Rekinv.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0008Rekinv> FIELD_KONVEN = new LbltMetadataField<>(Dppk0008Rekinv.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan REKINV_FORM = EFormLaporanBulananTahunan.LTLB_REKINV;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(REKINV_FORM.getCode())
                .name(REKINV_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(reportCode)
                .maxRow(24)
                .fields(new ArrayList<>())
                .build();

        if (sectorType.equals(KONVENSIONAL) || sectorType.equals(SYARIAH)) {
            sfConfig.setMinRow(24);
            return sfConfig;
        }

        throw new IllegalArgumentException("Unknown sector type: " + sectorType);
    }

    public static SubmissionFormat ppmpKonvensionalFormMetadata(ProgramType programType) {
        FIELD_KONVEN.setProgramType(programType);

        SubmissionFormatBuilder submissionFormatBuilder = getPpmpSubmissionFormatConfig(KONVENSIONAL, programType.toString());
        int minMaxRow = 9999;

        if (programType.equals(PPMPM)) {
            System.out.println("test");
        }

        switch (programType) {
            case PPMPK:
                minMaxRow = 24;
                break;
            case PPMPM:
                minMaxRow = 22;
                break;
        }

        submissionFormatBuilder.setMinRow(minMaxRow);
        submissionFormatBuilder.setMaxRow(minMaxRow);

        return new SubmissionConfig(programType.toString())
                .config()
                .setReferenceConfigs(getRefConfigs(programType))
                .setSubmissionFormat(submissionFormatBuilder)
                .setSubmissionField(FIELD_KONVEN.getClearedFields())
                //                .setSegmentValidations(E7008RekinvValidationsConfig.VALIDATION_METADATA)
                .setSegmentValidations()
                .build()
                .get();
    }

    private static ER7008PosLtlbDppkRekinv.Configs getRefConfigs(ProgramType programType) {
        switch (programType) {
            case PPMPK:
                return ER7008PosLtlbDppkRekinv.Configs.REF_CONFIG_PPMPK;
            case PPMPM:
                return ER7008PosLtlbDppkRekinv.Configs.REF_CONFIG_PPMPM;
            default:
                throw new IllegalStateException();
        }
    }

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
}
