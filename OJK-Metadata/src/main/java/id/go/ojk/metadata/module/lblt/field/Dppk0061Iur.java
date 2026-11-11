package id.go.ojk.metadata.module.lblt.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.header.*;
import id.go.ojk.metadata.module.lblt.reference.ER7061PosLtlbDppkIur;
import id.go.ojk.metadata.module.lblt.validations.E7061IurValidationsConfig;
import id.go.ojk.metadata.submission.SubmissionConfig;
import id.go.ojk.metadata.submission.base.BaseSubmissionConfig;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.util.constants.SectorType;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FilenameUtils;

import javax.print.attribute.standard.PagesPerMinute;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0061Iur implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(1, null, "Kode Komponen", sv(M, 9, 9, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))),

    NAMA_PENDIRI_MITRA_PENDIRI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(2, null, "Nama Pendiri/Mitra Pendiri", sv(C, 1, 100, freeText))),

    PHDP(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(3, null, "PhDP", sv(C, 1, 100, freeText))),

    IURAN_JATUH_TEMPO_NORMAL_PESERTA_PERSEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, PPMPPPIPK),
            sf(4, null, "Iuran Jatuh Tempo - Iuran Normal Peserta %", sv(C, 4, 18, numericDot))),

    IURAN_JATUH_TEMPO_NORMAL_PESERTA_JUMLAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, PPMPPPIPK),
            sf(5, null, "Iuran Jatuh Tempo - Iuran Normal Peserta Jumlah", sv(M, 1, 18, numeric))),

    IURAN_JATUH_TEMPO_NORMAL_PEMBERI_KERJA_PERSEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, PPMPPPIPK),
            sf(6, null, "Iuran Jatuh Tempo - Iuran Normal Pemberi Kerja %", sv(C, 4, 6, numericDot))),

    IURAN_JATUH_TEMPO_NORMAL_PEMBERI_KERJA_JUMLAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, PPMPPPIPK),
            sf(7, null, "Iuran Jatuh Tempo - Iuran Normal Pemberi Kerja Jumlah", sv(M, 1, 18, numeric))),

    IURAN_JATUH_TEMPO_SUKARELA_PESERTA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPMPPPIPK),
            sf(8, null, "Iuran Jatuh Tempo - Iuran Sukarela Peserta", sv(M, 1, 18, numeric))),

    IURAN_JATUH_TEMPO_TAMBAHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPMPPPIPK),
            sf(9, null, "Iuran Jatuh Tempo - Iuran Tambahan", sv(M, 1, 18, numeric))),

    PENERIMAAN_IURAN_NORMAL_PESERTA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(10, null, "Penerimaan Iuran - Iuran Normal Peserta", sv(M, 1, 18, numeric))),

    PENERIMAAN_IURAN_NORMAL_PEMBERI_KERJA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(11, null, "Penerimaan Iuran - Iuran Normal Pemberi Kerja", sv(M, 1, 18, numeric))),

    PENERIMAAN_IURAN_TAMBAHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPMPPPIPK),
            sf(12, null, "Penerimaan Iuran - Iuran Tambahan", sv(M, 1, 18, numeric))),

    PENERIMAAN_IURAN_SUKARELA_PESERTA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(13, null, "Penerimaan Iuran - Iuran Sukarela Peserta", sv(M, 1, 18, numeric))),

    KURANG_LEBIH_BAYAR_NORMAL_PESERTA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, PPMPPPIPK),
            sf(14, null, "Kurang/Lebih bayar - Iuran Normal Peserta", sv(M, 1, 18, numeric))),

    KURANG_LEBIH_BAYAR_NORMAL_PEMBERI_KERJA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, PPMPPPIPK),
            sf(15, null, "Kurang/Lebih bayar - Iuran Normal Pemberi Kerja", sv(M, 1, 18, numericNegatif))),

    KURANG_LEBIH_BAYAR_TAMBAHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPMPPPIPK),
            sf(16, null, "Kurang/Lebih bayar - Iuran Tambahan", sv(M, 1, 18, numericNegatif))),

    /* Jenis Manfaat field ref */

    MANFAAT_PENSIUN_LAINNYA_LAIN_LCF_PPMPK(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK),
            sf(17, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF", sv(C, 1, 6, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataSharedLblt.R024.getObject()))),

    MANFAAT_PENSIUN_LAINNYA_LAIN_LCF_PPMPM(sectors(KONVENSIONAL, SYARIAH), programs(PPMPM),
            sf(17, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF", sv(C, 1, 6, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataSharedLblt.R025.getObject()))),

    MANFAAT_PENSIUN_LAINNYA_LAIN_LCF_PPIPK(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK),
            sf(17, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF", sv(C, 1, 6, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataSharedLblt.R026.getObject()))),

    MANFAAT_PENSIUN_LAINNYA_LAIN_LCF_PPIPM(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM),
            sf(17, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF", sv(C, 1, 6, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataSharedLblt.R027.getObject()))),

    MANFAAT_PENSIUN_LAINNYA_LAIN(sectors(KONVENSIONAL, SYARIAH), programs(DPLK, PPMPPPIPK),
            sf(17, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF", sv(C, 1, 6, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataSharedLblt.R009.getObject()))),

    KETERANGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(18, null, "Keterangan", sv(C, 1, 250, freeText))),

    /* Gabungan Additional Field */

    JENIS_PROGRAM(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
            sf(1000, null, "Jenis Program", sv(M, 4, 4, alfa)
                    .confConstant("PPMP|PPIP"))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

        private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataLkdpPpmpk.R7061Iur.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataLkdpPpmpm.R7061Iur.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataLkdpPpipk.R7061Iur.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataLkdpPpipm.R7061Iur.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkdpDplk.R7061Iur.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPPPIPK, EHeaderMetadataLkdpPpmpppipk.R7067Iur.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0061Iur> FIELD_METADATA = new LbltMetadataField<>(Dppk0061Iur.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan IUR_FORM = EFormLaporanBulananTahunan.LTLB_IUR;
        return SubmissionFormatBuilder.builder()
                .code(IUR_FORM.getCode())
                .name(IUR_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(programType.toString())
                .maxRow(null)
                .minRow(0)
                .fields(new ArrayList<>())
                .build();
    }

    public static SubmissionFormat formMetadata(SectorType sectorType, ProgramType programType) {
        FIELD_METADATA.setProgramType(programType);

        BaseMetadataValidation<?> metadataValidation = E7061IurValidationsConfig.getSegmentValidation(programType);
        BaseSubmissionConfig.Config<?> submissionConfig = new SubmissionConfig(programType).config()
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType))
                .setReferenceConfigs(ER7061PosLtlbDppkIur.getRefConfig(programType));

        switch (programType) {
            case PPMPK:
            case PPMPM:
                submissionConfig
                        .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
                        .setSegmentValidations(metadataValidation);
                break;
            case PPIPK:
            case PPIPM:
                List<Integer> ppipFields = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 10, 11, 13, 14, 15, 17, 18);
                submissionConfig
                        .setSubmissionField(FIELD_METADATA.getReindexFields(ppipFields, metadataValidation.getFieldValidations()))
                        .setSegmentValidations(metadataValidation);
                break;
            case DPLK:
                List<Integer> dplkFields = Arrays.asList(0, 1, 2, 3, 10, 11, 13, 17, 18);
                submissionConfig
                        .setSubmissionField(FIELD_METADATA.getReindexFields(dplkFields, metadataValidation.getFieldValidations()))
                        .setSegmentValidations(metadataValidation);
                break;
            case PPMPPPIPK:
                List<Integer> gabunganFields = Arrays.asList(0, 1, 1000, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);
                submissionConfig
                        .setSubmissionField(FIELD_METADATA.getReindexFields(gabunganFields, metadataValidation.getFieldValidations()))
                        .setSegmentValidations(metadataValidation);
                break;
            default:
                throw new IllegalStateException();
        }

        return submissionConfig.build().get();
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