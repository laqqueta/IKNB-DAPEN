package id.go.ojk.metadata.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.metadata.module.lblt.dppk.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.metadata.module.lblt.dppk.header.EHeaderMetadataPpmpm;
import id.go.ojk.metadata.module.lblt.dppk.reference.ER7061PosLtlbDppkIur;
import id.go.ojk.metadata.module.lblt.dppk.validations.E7061IurValidationsConfig;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.util.constants.SectorType;
import id.go.ojk.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.metadata.submission.SubmissionConfig;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPK;
import static id.go.ojk.metadata.util.constants.ProgramType.PPMPM;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0061Iur implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01"))
    ),
    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen", sv(M, 9, 9, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
    ),
    NAMA_PENDIRI_MITRA_PENDIRI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(2, null, "Nama Pendiri/Mitra Pendiri",
                    sv(C, 1, 100, alfaNumeric)
                            /*.confConditionalRequired(E7061IurValidationsConfig.CR_EXISTS_POS_M)*/)
    ),
    PHDP(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(3, null, "PhDP", sv(C, 4, 6, numericDot)
                    /*.confConditionalRequired(E7061IurValidationsConfig.CR_EXISTS_POS_M)*/)
    ),
    IURAN_JATUH_TEMPO_NORMAL_PESERTA_PERSEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(4, null, "Iuran Jatuh Tempo - Iuran Normal Peserta %",
                    sv(C, 4, 18, numericDot)
                            /*.confConditionalRequired(E7061IurValidationsConfig.CR_EXISTS_POS_M)*/)
    ),
    IURAN_JATUH_TEMPO_NORMAL_PESERTA_JUMLAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(5, null, "Iuran Jatuh Tempo - Iuran Normal Peserta Jumlah", sv(M, 1, 18, numeric))
    ),
    IURAN_JATUH_TEMPO_NORMAL_PEMBERI_KERJA_PERSEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(6, null, "Iuran Jatuh Tempo - Iuran Normal Pemberi Kerja %",
                    sv(C, 4, 6, numericDot)
                            /*.confConditionalRequired(E7061IurValidationsConfig.CR_EXISTS_POS_M)*/)
    ),
    IURAN_JATUH_TEMPO_NORMAL_PEMBERI_KERJA_JUMLAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(7, null, "Iuran Jatuh Tempo - Iuran Normal Pemberi Kerja Jumlah", sv(M, 1, 18, numeric))
    ),
    IURAN_JATUH_TEMPO_SUKARELA_PESERTA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(8, null, "Iuran Jatuh Tempo - Iuran Sukarela Peserta", sv(M, 1, 18, numeric))
    ),
    IURAN_JATUH_TEMPO_TAMBAHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(9, null, "Iuran Jatuh Tempo - Iuran Tambahan", sv(M, 1, 18, numeric))
    ),
    PENERIMAAN_IURAN_NORMAL_PESERTA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(10, null, "Penerimaan Iuran - Iuran Normal Peserta", sv(M, 1, 18, numeric))
    ),
    PENERIMAAN_IURAN_NORMAL_PEMBERI_KERJA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(11, null, "Penerimaan Iuran - Iuran Normal Pemberi Kerja", sv(M, 1, 18, numeric))
    ),
    PENERIMAAN_IURAN_TAMBAHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(12, null, "Penerimaan Iuran - Iuran Tambahan", sv(M, 1, 18, numeric))
    ),
    PENERIMAAN_IURAN_SUKARELA_PESERTA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(13, null, "Penerimaan Iuran - Iuran Sukarela Peserta", sv(M, 1, 18, numeric))
    ),
    KURANG_LEBIH_BAYAR_NORMAL_PESERTA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(14, null, "Kurang/Lebih bayar - Iuran Normal Peserta", sv(M, 1, 18, numeric))
    ),
    KURANG_LEBIH_BAYAR_NORMAL_PEMBERI_KERJA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(15, null, "Kurang/Lebih bayar - Iuran Normal Pemberi Kerja", sv(M, 1, 18, numeric))
    ),
    KURANG_LEBIH_BAYAR_TAMBAHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(16, null, "Kurang/Lebih bayar - Iuran Tambahan", sv(M, 1, 18, numeric))
    ),
    MANFAAT_PENSIUN_LAINNYA_LAIN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(17, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                    sv(C, 1, 6, alfaNumeric)
                            /*.confConditionalRequired(E7061IurValidationsConfig.CR_EXISTS_POS_M)*/)
    ),
    KETERANGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(18, null, "Keterangan",
                    sv(C, 1, 250, freeText)
                            /*.confConditionalRequired(E7061IurValidationsConfig.CR_EXISTS_POS_O)*/)
    ),
    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7061Iur.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7061Iur.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0061Iur> FIELD_KONVEN = new LbltMetadataField<>(Dppk0061Iur.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan IUR_FORM = EFormLaporanBulananTahunan.LTLB_IUR;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(IUR_FORM.getCode())
                .name(IUR_FORM.getName())
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

    public static SubmissionFormat formMetadata(ProgramType programType) {
        FIELD_KONVEN.setProgramType(programType);

                BaseMetadataValidation<E7061IurValidationsConfig> metadataValidation;

        switch (programType) {
            case PPMPK:
                metadataValidation = E7061IurValidationsConfig.VALIDATION_METADATA_PPMPK;
                break;
            case PPMPM:
                metadataValidation = E7061IurValidationsConfig.VALIDATION_METADATA_PPMPM;
                break;
            default:
                throw new IllegalStateException();
        }

        return new SubmissionConfig(programType.toString())
                .config()
                .setReferenceConfigs(ER7061PosLtlbDppkIur.Configs.REF_CONFIG_PPMP)
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(KONVENSIONAL, programType.toString()))
                .setSubmissionField(FIELD_KONVEN.getFields(metadataValidation.getFieldValidations()))
                .setSegmentValidations(metadataValidation)
                .build()
                .get();
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