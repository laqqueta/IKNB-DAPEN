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
import id.go.ojk.module.lblt.dppk.reference.ER7001PosLtlbDppkLan;
import id.go.ojk.module.lblt.dppk.validations.ppmpk.E7001LanValidationsConfig;
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

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.util.FieldUtil.*;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0001Lan implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01"))
    ),
    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen",
                    sv(M, 13, 13, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric))
                    .confUnique(UniqueType.U)
    ),
    PERSENTASE_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(2, null, "Persentase Investasi",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7001LanValidationsConfig.CR_EXIST_POS_N_PERSENTASE_INVESTASI))
    ),
    MANFAAT_PENSIUN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(3, null, "Manfaat Pensiun", sv(M, 1, 18, numeric))
    ),

    MANFAAT_PENSIUN_LAINNYA_MANFAAT_TAMBAHAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK),
            sf(4, null, "Manfaat Pensiun Lainnya Manfaat Tambahan", sv(M, 1, 18, numeric))
    ),
    MANFAAT_PENSIUN_LAINNYA_KOMPENSASI_PASCAKERJA(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK),
            sf(5, null, "Manfaat Pensiun Lainnya Kompensasi Pascakerja", sv(M, 1, 18, numeric))
    ),
    MANFAAT_PENSIUN_LAINNYA_LAINNYA(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK),
            sf(6, null, "Manfaat Pensiun Lainnya Lainnya", sv(M, 1, 18, numeric))
    ),
    MANFAAT_LAIN_KOMPENSASI_PASCAKERJA(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK),
            sf(7, null, "Manfaat Lain Kompensasi Pascakerja", sv(M, 1, 18, numeric))
    ),
    MANFAAT_LAIN_KESEHATAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK),
            sf(8, null, "Manfaat Lain Kesehatan", sv(M, 1, 18, numeric))
    ),
    MANFAAT_LAIN_SANTUNAN_KEMATIAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK),
            sf(9, null, "Manfaat Lain Santunan Kematian", sv(M, 1, 18, numeric))
    ),
    MANFAAT_LAIN_IBADAH_KEAGAMAAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK),
            sf(10, null, "Manfaat Lain Ibadah Keagamaan", sv(M, 1, 18, numeric))
    ),
    MANFAAT_LAIN_PENDIDIKAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK),
            sf(11, null, "Manfaat Lain Pendidikan", sv(M, 1, 18, numeric))
    ),
    MANFAAT_LAIN_LAINNYA(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK),
            sf(12, null, "Manfaat Lain Lainnya", sv(M, 1, 18, numeric))
    ),
    GABUNGAN(
            sectors(KONVENSIONAL, SYARIAH),
            programs(PPMPK),
            sf(13, null, "Gabungan", sv(M, 1, 18, numeric))
                    .addFieldValidations(E7001LanValidationsConfig.FV_GABUNGAN_EQUALS_EXCEPT)
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
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7001Lan.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7001Lan.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0001Lan> FIELD_METADATA = new LbltMetadataField<>(Dppk0001Lan.class, KONVENSIONAL, KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan LAN_FORM = EFormLaporanBulananTahunan.LTLB_LAN;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(LAN_FORM.getCode())
                .name(LAN_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(reportCode)
                .maxRow(49)
                .fields(new ArrayList<>())
                .build();

        if (sectorType.equals(KONVENSIONAL) || sectorType.equals(SYARIAH)) {
            sfConfig.setMinRow(49);
            return sfConfig;
        }

        throw new IllegalArgumentException("Unknown sector type: " + sectorType);
    }

    public static SubmissionFormat ppmpKonvensionalFormMetadata(ProgramType programType) {
        FIELD_METADATA.setProgramType(programType);
        return new SubmissionConfig(programType.toString())
                .config()
                .setReferenceConfigs(ER7001PosLtlbDppkLan.Configs.REF_CONFIG_PPMPK)
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(KONVENSIONAL, programType.toString()))
                .setSubmissionField(FIELD_METADATA.getClearedFields())
//                .setSegmentValidations(E7001LanValidationsConfig.VALIDATION_METADATA, E7001LanValidationsConfig.testValidation)
                .setSegmentValidations()
                .build()
                .get();
    }
}