package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpm;
import id.go.ojk.module.lblt.dppk.reference.ER7007PosLtlbDppkKup;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.constants.SectorType;
import id.go.ojk.util.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.util.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.util.metadata.submission.SubmissionConfig;
import lombok.AllArgsConstructor;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.freeText;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;
import static id.go.ojk.util.FieldUtil.*;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0007Kup implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01"))
    ),
    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen", sv(O, 13, 13, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
    ),
    URAIAN_TAMBAHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(2, null, "Uraian Tambahan", sv(O, 1, 100, freeText))
    ),
    NILAI_PROGRAM_MANFAAT_PENSIUN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(3, null, "Nilai Program Manfaat Pensiun", sv(O, 1, 18, freeText))
    ),
    NILAI_PROGRAM_MANFAAT_PENSIUN_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(4, null, "Nilai Program Manfaat Pensiun Lainnya", sv(O, 1, 18, freeText))
    ),
    NILAI_PROGRAM_MANFAAT_LAIN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(5, null, "Nilai Program Manfaat Lain", sv(O, 1, 18, freeText))
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

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7007Kup.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7007Kup.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0007Kup> FIELD_KONVEN = new LbltMetadataField<>(Dppk0007Kup.class, KONVENSIONAL, KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan KUP_FORM = EFormLaporanBulananTahunan.LTLB_KUP;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(KUP_FORM.getCode())
                .name(KUP_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(reportCode)
                .maxRow(null)
                .fields(new ArrayList<>())
                .build();

        if (sectorType.equals(KONVENSIONAL) || sectorType.equals(SYARIAH)) {
            sfConfig.setMinRow(0);
            return sfConfig;
        }


        throw new IllegalArgumentException("Unknown sector type: " + sectorType);
    }

    public static SubmissionFormat ppmpKonvensionalFormMetadata(ProgramType programType) {
        FIELD_KONVEN.setProgramType(programType);
        return new SubmissionConfig(programType.toString())
                .config()
                .setReferenceConfigs(ER7007PosLtlbDppkKup.Configs.REF_CONFIG_PPMPK)
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(KONVENSIONAL, programType.toString()))
                .setSubmissionField(FIELD_KONVEN.getClearedFields())
                //                .setSegmentValidations(E7007KupValidationsConfig.VALIDATION_METADATA)
                .setSegmentValidations()
                .build()
                .get();
    }
}
