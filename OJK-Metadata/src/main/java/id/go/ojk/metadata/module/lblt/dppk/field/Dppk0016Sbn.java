package id.go.ojk.metadata.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.metadata.module.lblt.dppk.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.dppk.header.EHeaderMetadataPpipk;
import id.go.ojk.metadata.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.metadata.module.lblt.dppk.header.EHeaderMetadataPpmpm;
import id.go.ojk.metadata.module.lblt.dppk.header.EHeaderMetadataSharedLkbt;
import id.go.ojk.metadata.module.lblt.dppk.reference.ER7016PosLtlbDppkSbn;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.util.constants.SectorType;
import id.go.ojk.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.metadata.submission.SubmissionConfig;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.metadata.validation.lblt.ILbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;
import static id.go.ojk.metadata.module.lblt.dppk.validations.ppipik.E7016SbnKValidationsConfig.VALIDATION_METADATA_PPIPK;
import static id.go.ojk.metadata.module.lblt.dppk.validations.ppmpk.E7016SbnKValidationsConfig.VALIDATION_METADATA_PPMPK;
import static id.go.ojk.metadata.module.lblt.dppk.validations.ppmpm.E7016SbnMValidationsConfig.VALIDATION_METADATA_PPMPM;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0016Sbn implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01"))
    ),
    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(1, null, "Kode Komponen", sv(M, 9, 9, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
    ),
    JENIS_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(2, null, "Jenis Investasi", sv(C, 1, 6, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataSharedLkbt.R022.getObject())
                    /*.confConditionalRequired(E7016SbnValidationsConfig.CR_FOR_TOTAL)*/)
    ),
    NAMA_JENIS_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(3, null, "Nama Jenis Investasi", sv(C, 1, 100, freeText)
                    /*.confConditionalRequired(E7016SbnValidationsConfig.CR_FOR_TOTAL)*/)
    ),
    SERI_EFEK(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(4, null, "Seri Efek", sv(C, 1, 100, freeText)
                    /*.confConditionalRequired(E7016SbnValidationsConfig.CR_JENIS_INVESTASI_VALUE_OBLIGASI)*/)
    ),
    JENIS_KEPEMILIKAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(5, null, "Jenis Kepemilikan", sv(C, 1, 100, freeText)
                    /*.confConditionalRequired(E7016SbnValidationsConfig.CR_JENIS_INVESTASI_VALUE_OBLIGASI)*/)
    ),
    RATING(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(6, null, "Rating", sv(C, 1, 100, freeText)
                    /*.confConditionalRequired(E7016SbnValidationsConfig.CR_JENIS_INVESTASI_VALUE_OBLIGASI)*/)
    ),
    MENAJER_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(7, null, "Menajer Investasi", sv(C, 1, 100, freeText)
                    /*.confConditionalRequired(E7016SbnValidationsConfig.CR_JENIS_INVESTASI_VALUE_SBN)*/)
    ),
    NILAI_WAJAR(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(8, null, "Nilai Wajar", sv(C, 1, 18, numeric)
                    /*.confConditionalRequired(E7016SbnValidationsConfig.CR_FOR_TOTAL)*/)
    ),
    PERSEN_SBN_DALAM_REKSADANA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(9, null, "% SBN dalam Reksadana", sv(C, 4, 6, numericDot)
                    /*.confConditionalRequired(E7016SbnValidationsConfig.CR_FOR_SBN)*/)
    ),
    SALDO(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(10, null, "Saldo", sv(C, 1, 18, numeric)
                    /*.confConditionalRequired(E7016SbnValidationsConfig.CR_FOR_SALDO)*/)
    ),
    EMITEN_PENERIMA_DANA_PROJECT(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(11, null, "Emiten Penerima Dana/Project", sv(O, 1, 100, alfa)
                    /*.confConditionalRequired(E7016SbnValidationsConfig.CR_JENIS_INVESTASI_VALUE_REKSADANA)*/)
    ),
    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7016Sbn.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7016Sbn.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataPpipk.R7016Sbn.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0016Sbn> FIELD_METADATA = new LbltMetadataField<>(
            Dppk0016Sbn.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(/*  */SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan SBN_FORM = EFormLaporanBulananTahunan.LTLB_SBN;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(SBN_FORM.getCode())
                .name(SBN_FORM.getName())
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

        ReferenceConfig referenceConfig = null;
        BaseMetadataValidation<? extends ILbltMetadataValidation> metadataValidation = null;

        switch (programType) {
            case PPMPK:
                metadataValidation = VALIDATION_METADATA_PPMPK;
                referenceConfig = ER7016PosLtlbDppkSbn.Configs.REF_CONFIG_PPMPK_PPMPM;
                break;
            case PPMPM:
                referenceConfig = ER7016PosLtlbDppkSbn.Configs.REF_CONFIG_PPMPK_PPMPM;
                metadataValidation = VALIDATION_METADATA_PPMPM;
                break;
            case PPIPK:
                referenceConfig = ER7016PosLtlbDppkSbn.Configs.REF_CONFIG_PPIPK_PPIPM;
                metadataValidation = VALIDATION_METADATA_PPIPK;
                break;
            default:
                throw new IllegalStateException();
        }

        return new SubmissionConfig(programType.toString())
                .config()
                .setReferenceConfigs(referenceConfig)
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