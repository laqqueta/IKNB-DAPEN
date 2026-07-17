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
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataLkbtDplk;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataPpipk;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataPpipm;
import id.go.ojk.metadata.module.lblt.reference.ER7104PosLtlbDppkMpbk;
import id.go.ojk.metadata.module.lblt.validations.E7104MpbkValidationsConfig;
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
public enum Dppk0104Mpbk implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric)
                    .confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(1, null, "Kode Komponen", sv(M, 10, 10, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))),

    NAMA_BANK(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(2, null, "Nama Bank/Nomor Seri SBN", sv(C, 1, 100, alfaNumericSpace))),

    DEPOSITO_NOMOR_BILYET(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(3, null, "Deposito - Nomor Bilyet", sv(C, 1, 50, alfaNumeric))),

    DEPOSITO_NOMINAL(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(4, null, "Deposito - Nominal", sv(M, 1, 18, numeric))),

    DEPOSITO_TANGGAL_JATUH_TEMPO(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(5, null, "Deposito - Tanggal Jatuh Tempo", sv(C, 8, 8, date))),

    SERTIFIKAT_DEPOSITO_NOMOR_BILYET(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(6, null, "Sertifikat Deposito - Nomor Bilyet", sv(C, 1, 50, alfaNumeric))),

    SERTIFIKAT_DEPOSITO_NOMINAL(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(7, null, "Sertifikat Deposito - Nominal", sv(M, 1, 18, numeric))),

    SERTIFIKAT_DEPOSITO_TANGGAL_JATUH_TEMPO(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(8, null, "Sertifikat Deposito - Tanggal Jatuh Tempo", sv(C, 8, 8, date))),

    SBI_NILAI_PEROLEHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(9, null, "SBI - Nilai Perolehan", sv(C, 1, 18, numeric))),

    SBI_NILAI_WAJAR(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(10, null, "SBI - Nilai Wajar", sv(C, 1, 18, numeric))),

    SBI_TANGGAL_JATUH_TEMPO(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(11, null, "SBI - Tanggal Jatuh Tempo", sv(C, 8, 8, date))),

    SBN_NILAI_PEROLEHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(12, null, "SBN - Nilai Perolehan", sv(C, 1, 18, numeric))),

    SBN_NILAI_WAJAR(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(13, null, "SBN - Nilai Wajar", sv(C, 1, 18, numeric))),

    SBN_TANGGAL_JATUH_TEMPO(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(14, null, "SBN - Tanggal Jatuh Tempo", sv(C, 8, 8, date))),

    TOTAL(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM, DPLK),
            sf(15, null, "TOTAL", sv(M, 1, 18, numeric))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataPpipk.R7022Mpbk.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataPpipm.R7022Mpbk.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkbtDplk.R7022Mpbk.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private static final LbltMetadataField<Dppk0104Mpbk> FIELD_METADATA = new LbltMetadataField<>(Dppk0104Mpbk.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    private static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan form = EFormLaporanBulananTahunan.LTLB_MPBK;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(form.getCode())
                .name(form.getName())
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

        BaseMetadataValidation<E7104MpbkValidationsConfig> metadataValidation = null;

        switch (programType) {
            case PPIPK:
                metadataValidation = E7104MpbkValidationsConfig.VALIDATION_METADATA_PPIPK;
                break;
            case PPIPM:
                metadataValidation = E7104MpbkValidationsConfig.VALIDATION_METADATA_PPIPM;
                break;
            case DPLK:
                metadataValidation = E7104MpbkValidationsConfig.VALIDATION_METADATA_DPLK;
                break;
            default:
                throw new IllegalStateException();
        }

        return new SubmissionConfig(programType)
                .config()
                .setReferenceConfigs(ER7104PosLtlbDppkMpbk.Configs.REF_CONFIG)
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