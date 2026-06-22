package id.go.ojk.metadata.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.metadata.module.lblt.dppk.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.dppk.header.*;
import id.go.ojk.metadata.module.lblt.dppk.reference.ER7048PosLtlbDppkTnbg;
import id.go.ojk.metadata.module.lblt.dppk.validations.E7048TnbgValidationsConfig;
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
public enum Dppk0048Tnbg implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric)
                    .confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(1, null, "Kode Komponen", sv(M, 10, 10, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))),

    JENIS_OBJEK(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(2, null, "Jenis Objek (Tanah/Bangunan/Tanah & Bangunan)", sv(C, 1, 8, refTable)
                    .confRegex(SimpleValidation.patternNumeric)
                    .confReference(EHeaderMetadataSharedLkbt.R004.getObject()))),

    NOMOR_SERTIFIKAT(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(3, null, "Nomor Sertifikat", sv(C, 1, 20, alfaNumeric))),

    ALAMAT_LOKASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(4, null, "Alamat Lokasi", sv(C, 1, 250, alfaNumeric))),

    TANGGAL_PEROLEHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(5, null, "Tanggal Perolehan", sv(C, 8, 8, date))),

    NILAI_PEROLEHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(6, null, "Nilai Perolehan", sv(M, 1, 18, numeric))),

    AKUMULASI_PENYUSUTAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(7, null, "Akumulasi Penyusutan", sv(M, 1, 18, numeric))),

    NILAI_BUKU(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(8, null, "Nilai Buku", sv(M, 1, 18, numeric))),

    NILAI_PEROLEHAN_PADA_TANGGAL_LAPORAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(9, null, "Nilai Perolehan Pada Tanggal Laporan", sv(M, 1, 18, numeric))),

    KETERANGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM),
            sf(10, null, "Keterangan", sv(C, 1, 250, freeText))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7048Tnbg.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7048Tnbg.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataPpipk.R7048Tnbg.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataPpipm.R7048Tnbg.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0048Tnbg> FIELD_METADATA = new LbltMetadataField<>(Dppk0048Tnbg.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan TNBG_FORM = EFormLaporanBulananTahunan.LTLB_TNBG;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(TNBG_FORM.getCode())
                .name(TNBG_FORM.getName())
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

    public static SubmissionFormat formMetadata(SectorType sectorType, ProgramType programType) {
        FIELD_METADATA.setProgramType(programType);

        BaseMetadataValidation<E7048TnbgValidationsConfig> metadataValidation = null;

        switch (programType) {
            case PPMPK:
                metadataValidation = E7048TnbgValidationsConfig.VALIDATION_METADATA_PPMPK;
                break;
            case PPMPM:
                metadataValidation = E7048TnbgValidationsConfig.VALIDATION_METADATA_PPMPM;
                break;
            case PPIPK:
                metadataValidation = E7048TnbgValidationsConfig.VALIDATION_METADATA_PPIPK;
                break;
            case PPIPM:
                metadataValidation = E7048TnbgValidationsConfig.VALIDATION_METADATA_PPIPM;
                break;
            default:
                throw new IllegalStateException();
        }

        return new SubmissionConfig(programType.toString())
                .config()
                .setReferenceConfigs(ER7048PosLtlbDppkTnbg.Configs.REF_CONFIG_PPMP)
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType.toString()))
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