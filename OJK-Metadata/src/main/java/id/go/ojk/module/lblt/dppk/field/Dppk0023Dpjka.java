package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpm;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataSharedLkbt;
import id.go.ojk.module.lblt.dppk.reference.ER7023PosLtlbDppkDpjka;
import id.go.ojk.module.lblt.dppk.validations.E7023DpjkaValidationsConfig;
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
public enum Dppk0023Dpjka implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(0, null, "Flag",
                    sv(M, 3, 3, alfaNumeric)
                            .confConstant("D01"))
    ),
    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen",
                    sv(M, 11, 11, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric))
    ),
    NAMA_BANK(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(2, null, "Nama Bank",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7023DpjkaValidationsConfig.CR_EXISTS_DPJKA000000_O))
    ),
    CABANG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(3, null, "Cabang",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7023DpjkaValidationsConfig.CR_EXISTS_DPJKA000000_O))
    ),
    KODE_BANK(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(4, null, "Kode Bank",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7023DpjkaValidationsConfig.CR_EXISTS_DPJKA000000_O)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataSharedLkbt.R011.getObject()))
    ),
    TANGGAL_PEROLEHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(5, null, "Tanggal Perolehan",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7023DpjkaValidationsConfig.CR_EXISTS_DPJKA000000_M))
    ),
    NILAI_NOMINAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(6, null, "Nilai Nominal",
                    sv(M, 1, 18, numeric))
    ),
    JANGKA_WAKTU_HARI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(7, null, "Jangka Waktu (Hari)",
                    sv(C, 1, 3, numeric)
                            .confConditionalRequired(E7023DpjkaValidationsConfig.CR_EXISTS_DPJKA000000_M))
    ),
    TINGKAT_BUNGA_NISBAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(8, null, "Tingkat Bunga/Nisbah (%)",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7023DpjkaValidationsConfig.CR_EXISTS_DPJKA000000_M))
    ),
    MANFAAT_PENSIUN_LAINNYA_LAIN_LCF(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(9, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7023DpjkaValidationsConfig.CR_EXISTS_DPJKA000000_M)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataSharedLkbt.R009.getObject()))
    ),
    PENGELOLAAN_SWAKELOLA_KPD(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(10, null, "Pengelolaan Swakelola/ KPD",
                    sv(C, 1, 6, refTable)
                            .confRegex(SimpleValidation.patternAlfa)
                            .confConditionalRequired(E7023DpjkaValidationsConfig.CR_EXISTS_DPJKA000000_M)
                            .confReference(EHeaderMetadataSharedLkbt.R006.getObject()))
    ),
    PENGELOLAAN_NAMA_MANAJER_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(11, null, "Pengelolaan Nama Manajer Investasi",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7023DpjkaValidationsConfig.CR_EXISTS_DPJKA000000_M)
                            .confConditionalRequired(E7023DpjkaValidationsConfig.CR_EQUAL_EXCEPT_DPJKA000000))
    ),
    KETERANGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(12, null, "Keterangan",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7023DpjkaValidationsConfig.CR_EXISTS_DPJKA000000_M))
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
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7023Dpjka.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7023Dpjka.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0023Dpjka> FIELD_KONVEN = new LbltMetadataField<>(Dppk0023Dpjka.class, KONVENSIONAL, KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan DPJKA_FORM = EFormLaporanBulananTahunan.LTLB_DPJKA;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(DPJKA_FORM.getCode())
                .name(DPJKA_FORM.getName())
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
                .setReferenceConfigs(ER7023PosLtlbDppkDpjka.Configs.REF_CONFIG_PPMP)
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(KONVENSIONAL, programType.toString()))
                .setSubmissionField(FIELD_KONVEN.getFields())
                .setSegmentValidations(E7023DpjkaValidationsConfig.VALIDATION_METADATA)
                .build()
                .get();
    }
}