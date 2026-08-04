package id.go.ojk.metadata.module.lblt.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.header.*;
import id.go.ojk.metadata.module.lblt.reference.ER7040PosLtlbDppkProp;
import id.go.ojk.metadata.module.lblt.validations.E7040PropValidationsConfig;
import id.go.ojk.metadata.submission.SubmissionConfig;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.util.constants.SectorType;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import lombok.AllArgsConstructor;

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
public enum Dppk0040Prop implements ILbltFieldMetadata {
    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric)
                    .confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(1, null, "Kode Komponen", sv(M, 10, 10, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))),

    JENIS_OBJEK_TANAH_BANGUNAN_TANAH_BANGUNAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(2, null, "Jenis Objek (Tanah/Bangunan/Tanah&Bangunan)", sv(C, 1, 8, refTable)
                    .confRegex(SimpleValidation.patternNumeric)
                    .confReference(EHeaderMetadataSharedLblt.R004.getObject()))),

    ALAMAT_LENGKAP(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(3, null, "Alamat Lengkap", sv(C, 1, 250, freeText))),

    LUAS_M2(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(4, null, "Luas(m2)", sv(C, 1, 10, numeric))),

    JENIS_BUKTI_KEPEMILIKAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(5, null, "Jenis Bukti Kepemilikan", sv(C, 1, 8, refTable)
                    .confRegex(SimpleValidation.patternAlfa)
                    .confReference(EHeaderMetadataSharedLblt.R016.getObject()))),

    NOMOR_SURAT_KEPEMILIKAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(6, null, "Nomor Surat Kepemilikan", sv(C, 1, 20, alfaNumeric))),

    TANGGAL_PEROLEHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(7, null, "Tanggal Perolehan", sv(C, 8, 8, date))),

    NILAI_PEROLEHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(8, null, "Nilai Perolehan", sv(M, 1, 18, numeric))),

    AKUMULASI_PENYUSUTAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(9, null, "Akumulasi Penyusutan", sv(M, 1, 18, numeric))),

    NILAI_BUKU(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(10, null, "Nilai Buku", sv(M, 1, 18, numeric))),

    NILAI_APPRAISAL_NILAI_WAJAR(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(11, null, "Nilai Appraisal/ Nilai Wajar", sv(M, 1, 18, numeric))),

    TANGGAL_APPRAISAL(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(12, null, "Tanggal Appraisal", sv(C, 8, 8, date))),

    NAMA_PENILAI_PUBLIK_INDEPENDEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(13, null, "Nama Penilai Publik/Independen", sv(C, 1, 100, freeText))),

    NAMA_KJPP(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(14, null, "Nama KJPP", sv(C, 1, 100, freeText))),

    SELISIH_PENILAIAN_INVESTASI_NILAI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(15, null, "Selisih Penilaian Investasi Nilai", sv(M, 1, 18, numeric))),

    SELISIH_PENILAIAN_INVESTASI_PERSEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(16, null, "Selisih Penilaian Investasi %", sv(C, 4, 6, numericDot))),

    MANFAAT_PENSIUN_MANFAAT_PENSIUN_LAINNYA_MANFAAT_LAIN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(17, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain", sv(C, 1, 6, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    .confReference(EHeaderMetadataSharedLblt.R009.getObject()))),

    PENDAPATAN_SEWA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(18, null, "Pendapatan Sewa", sv(C, 1, 18, numeric))),

    KETERANGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK, PPMPPPIPK),
            sf(19, null, "Keterangan", sv(C, 1, 250, freeText)))

    /* Gabungan Additional Field */

    JENIS_PROGRAM(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
    sf(1000, null, "Jenis Program", sv(M, 5, 5, alfa))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataLkdpPpmpk.R7040Prop.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataLkdpPpmpm.R7040Prop.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataLkdpPpipk.R7040Prop.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataLkdpPpipm.R7040Prop.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkdpDplk.R7040Prop.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0040Prop> FIELD_METADATA = new LbltMetadataField<>(Dppk0040Prop.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan FORM = EFormLaporanBulananTahunan.LTLB_PROP;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(FORM.getCode())
                .name(FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(programType.toString())
                .maxRow(null)
                .fields(new ArrayList<>())
                .build();

        if (sectorType.equals(KONVENSIONAL) || sectorType.equals(SYARIAH)) {
            sfConfig.setMinRow(0);
            return sfConfig;
        }


        throw new IllegalArgumentException("Unknown sector type: " + sectorType);
    }

    public static SubmissionFormat formMetadata(SectorType sectorType, ProgramType programType) {
        FIELD_METADATA.setProgramType(programType);

        BaseMetadataValidation<E7040PropValidationsConfig> metadataValidation = null;

        switch (programType) {
            case PPMPK:
                metadataValidation = E7040PropValidationsConfig.VALIDATION_METADATA_PPMPK;
                break;
            case PPMPM:
                metadataValidation = E7040PropValidationsConfig.VALIDATION_METADATA_PPMPM;
                break;
            case PPIPK:
                metadataValidation = E7040PropValidationsConfig.VALIDATION_METADATA_PPIPK;
                break;
            case PPIPM:
                metadataValidation = E7040PropValidationsConfig.VALIDATION_METADATA_PPIPM;
                break;
            case DPLK:
                metadataValidation = E7040PropValidationsConfig.VALIDATION_METADATA_DPLK;
                break;
            default:
                throw new IllegalStateException();
        }

        return new SubmissionConfig(programType)
                .config()
                .setReferenceConfigs(ER7040PosLtlbDppkProp.Configs.REF_CONFIG)
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType))
                .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
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