package id.go.ojk.metadata.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.metadata.module.lblt.dppk.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.dppk.header.EHeaderMetadataPpipk;
import id.go.ojk.metadata.module.lblt.dppk.header.EHeaderMetadataPpipm;
import id.go.ojk.metadata.module.lblt.dppk.reference.ER7105PosLtlbDppkPmbk;
import id.go.ojk.metadata.module.lblt.dppk.validations.E7105PmbkValidationsConfig;
import id.go.ojk.metadata.submission.SubmissionConfig;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.util.constants.SectorType;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.PPIPK;
import static id.go.ojk.metadata.util.constants.ProgramType.PPIPM;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0105Pmbk implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric)
                    .confConstant("D01"))
    ),
    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM),
            sf(1, null, "Kode Komponen", sv(M, 10, 10, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))),

    JUMLAH_PESERTA_MP_BERKALA(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM),
            sf(2, null, "Jumlah Peserta MP Berkala",
                    sv(M, 1, 18, numeric))),

    JUMLAH_PEMBAYARAN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM),
            sf(3, null, "Jumlah Pembayaran",
                    sv(M, 1, 18, numeric))),

    AKUMULASI_DANA_SALDO(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM),
            sf(4, null, "Akumulasi Dana Manfaat Berkala - Saldo Peserta",
                    sv(M, 1, 18, numeric))),

    AKUMULASI_DANA_TOTAL_PENGEMBANGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM),
            sf(5, null, "Akumulasi Dana Manfaat Berkala - Hasil Pengembangan",
                    sv(M, 1, 18, numeric))),

    AKUMULASI_DANA_TOTAL(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM),
            sf(6, null, "Akumulasi Dana Manfaat Berkala - Total",
                    sv(M, 1, 18, numeric))),

    KETERANGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPK, PPIPM),
            sf(7, null, "Keterangan",
                    sv(O, 1, 256, freeText))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataPpipk.R7023Pmbk.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataPpipm.R7023Pmbk.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private static final LbltMetadataField<Dppk0105Pmbk> FIELD_METADATA = new LbltMetadataField<>(Dppk0105Pmbk.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    private static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan form = EFormLaporanBulananTahunan.LTLB_PMBK;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(form.getCode())
                .name(form.getName())
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

        BaseMetadataValidation<E7105PmbkValidationsConfig> metadataValidation = null;

        switch (programType) {
            case PPIPK:
                metadataValidation = E7105PmbkValidationsConfig.VALIDATION_METADATA_PPIPK;
                break;
            case PPIPM:
                metadataValidation = E7105PmbkValidationsConfig.VALIDATION_METADATA_PPIPM;
                break;
            default:
                throw new IllegalStateException();
        }

        return new SubmissionConfig(programType.toString())
                .config()
                .setReferenceConfigs(ER7105PosLtlbDppkPmbk.Configs.REF_CONFIG_PPIP)
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