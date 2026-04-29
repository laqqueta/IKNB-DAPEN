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
import id.go.ojk.module.lblt.dppk.reference.ER7030PosLtlbDppkSukuk;
import id.go.ojk.module.lblt.dppk.validations.E7030SukukValidationsConfig;
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
public enum Dppk0030Sukuk implements ILbltFieldMetadata {

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
    NAMA_PENERBIT(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(2, null, "Nama Penerbit",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7030SukukValidationsConfig.CR_EXISTS_POS_M))
    ),
    KODE_SUKUK(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(3, null, "Kode Sukuk",
                    sv(C, 1, 30, alfaNumeric)
                            .confConditionalRequired(E7030SukukValidationsConfig.CR_EXISTS_POS_M))
    ),
    NAMA_SUKUK(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(4, null, "Nama Sukuk",
                    sv(C, 1, 100, freeText)
                            .confConditionalRequired(E7030SukukValidationsConfig.CR_EXISTS_POS_M))
    ),
    TANGGAL_PEROLEHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(5, null, "Tanggal Perolehan",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7030SukukValidationsConfig.CR_EXISTS_POS_M))
    ),
    NILAI_NOMINAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(6, null, "Nilai Nominal",
                    sv(M, 1, 18, numeric))
    ),
    KUPON(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(7, null, "Kupon (%)",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7030SukukValidationsConfig.CR_EXISTS_POS_M))
    ),
    TANGGAL_JATUH_TEMPO(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(8, null, "Tanggal Jatuh Tempo",
                    sv(C, 8, 8, date)
                            .confConditionalRequired(E7030SukukValidationsConfig.CR_EXISTS_POS_M))
                    .addFieldValidations(E7030SukukValidationsConfig.FV_DATE_GREATER)
    ),
    PERINGKAT_AWAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(9, null, "Peringkat Awal",
                    sv(C, 1, 10, alfaNumeric)
                            .confConditionalRequired(E7030SukukValidationsConfig.CR_EXISTS_POS_M))
    ),
    PERINGKAT_AKHIR(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(10, null, "Peringkat Akhir",
                    sv(C, 1, 10, alfaNumeric)
                            .confConditionalRequired(E7030SukukValidationsConfig.CR_EXISTS_POS_M))
    ),
    NILAI_PEROLEHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(11, null, "Nilai Perolehan",
                    sv(M, 1, 18, numeric))
    ),
    NILAI_WAJAR(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(12, null, "Nilai Wajar",
                    sv(M, 1, 18, numeric))
    ),
    SELISIH_PENILAIAN_INVESTASI_NILAI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(13, null, "Selisih Penilaian Investasi Nilai",
                    sv(M, 1, 18, numeric))
                    .addFieldValidations(E7030SukukValidationsConfig.FV_EQUAL_NILAI_INVESTASI)
    ),
    SELISIH_PENILAIAN_INVESTASI_PERSEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(14, null, "Selisih Penilaian Investasi %",
                    sv(C, 4, 6, numericDot)
                            .confConditionalRequired(E7030SukukValidationsConfig.CR_EXISTS_POS_M))
                    .addFieldValidations(E7030SukukValidationsConfig.FV_EQUAL_PERSENTASE_INVESTASI)
    ),
    SEKTOR_EKONOMI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(15, null, "Sektor Ekonomi",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7030SukukValidationsConfig.CR_EXISTS_POS_M)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataSharedLkbt.R007.getObject()))
    ),
    MANFAAT_PENSIUN_LAINNYA_LAIN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(16, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7030SukukValidationsConfig.CR_EXISTS_POS_M)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataSharedLkbt.R009.getObject()))
    ),
    METODE_PENCATATAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(17, null, "Metode Pencatatan",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7030SukukValidationsConfig.CR_EXISTS_POS_M)
                            .confRegex(SimpleValidation.patternAlfa)
                            .confReference(EHeaderMetadataSharedLkbt.R005.getObject()))
    ),
    PENGELOLAAN_SWAKELOLA_KPD(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(18, null, "Pengelolaan Swakelola/ KPD",
                    sv(C, 1, 6, refTable)
                            .confConditionalRequired(E7030SukukValidationsConfig.CR_EXISTS_POS_M)
                            .confRegex(SimpleValidation.patternAlfa)
                            .confReference(EHeaderMetadataSharedLkbt.R006.getObject()))
    ),
    PENGELOLAAN_NAMA_MANAJER_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(19, null, "Pengelolaan Nama Manajer Investasi",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7030SukukValidationsConfig.CR_EXISTS_POS_M)
                            .confConditionalRequired(E7030SukukValidationsConfig.CR_NAMA_PENGELOLA))
    ),
    KETERANGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(20, null, "Keterangan",
                    sv(C, 1, 250, freeText)
                            .confConditionalRequired(E7030SukukValidationsConfig.CR_EXISTS_POS_O))
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
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7030Sukuk.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7030Sukuk.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0030Sukuk> FIELD_KONVEN = new LbltMetadataField<>(Dppk0030Sukuk.class, KONVENSIONAL, KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan SUKUK_FORM = EFormLaporanBulananTahunan.LTLB_SUKUK;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(SUKUK_FORM.getCode())
                .name(SUKUK_FORM.getName())
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
                .setReferenceConfigs(ER7030PosLtlbDppkSukuk.Configs.REF_CONFIG_PPMP)
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(KONVENSIONAL, programType.toString()))
                .setSubmissionField(FIELD_KONVEN.getFields())
                .setSegmentValidations(E7030SukukValidationsConfig.VALIDATION_METADATA)
                .build()
                .get();
    }
}