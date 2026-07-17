package id.go.ojk.metadata.module.lblt.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.client.service.ReferenceConfig;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.header.*;
import id.go.ojk.metadata.module.lblt.reference.ER7005PosLtlbDppkLak;
import id.go.ojk.metadata.module.lblt.reference.ER7006PosLtlbDppkPst;
import id.go.ojk.metadata.submission.SubmissionConfig;
import id.go.ojk.metadata.submission.base.BaseSubmissionConfig;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.util.constants.SectorType;
import id.go.ojk.metadata.validation.base.BaseMetadataValidation;
import id.go.ojk.metadata.validation.lblt.ILbltMetadataValidation;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.metadata.module.lblt.validations.dplk.E7006PstKValidationsConfig.VALIDATION_METADATA_DPLK;
import static id.go.ojk.metadata.module.lblt.validations.ppipik.E7006PstKValidationsConfig.VALIDATION_METADATA_PPIPK;
import static id.go.ojk.metadata.module.lblt.validations.ppipm.E7006PstMValidationsConfig.VALIDATION_METADATA_PPIPM;
import static id.go.ojk.metadata.module.lblt.validations.ppmpk.E7006PstKValidationsConfig.VALIDATION_METADATA_PPMPK;
import static id.go.ojk.metadata.module.lblt.validations.ppmpm.E7006PstMValidationsConfig.VALIDATION_METADATA_PPMPM;
import static id.go.ojk.metadata.util.FieldUtil.*;
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0006Pst implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(1, null, "Kode Komponen", sv(M, 13, 13, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
                    .confUnique(UniqueType.U)),

    MANFAAT_PENSIUN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK, PPIPM, DPLK),
            sf(2, null, "Manfaat Pensiun", sv(M, 1, 18, numeric))),

    MANFAAT_PENSIUN_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK),
            sf(3, null, "Manfaat Pensiun Lainnya", sv(M, 1, 18, numeric))),

    MANFAAT_LAIN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK),
            sf(4, null, "Manfaat  lain", sv(M, 1, 18, numeric))),

    JUMLAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPIPK, DPLK),
            sf(5, null, "Jumlah", sv(M, 1, 18, numeric))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7006Pst.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7006Pst.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataPpipk.R7006Pst.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataPpipm.R7006Pst.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkbtDplk.R7006Pst.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0006Pst> FIELD_METADATA = new LbltMetadataField<>(Dppk0006Pst.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan PST_FORM = EFormLaporanBulananTahunan.LTLB_PST;
        return SubmissionFormatBuilder.builder()
                .code(PST_FORM.getCode())
                .name(PST_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(programType.toString())
                .maxRow(ER7006PosLtlbDppkPst.getRowSize(programType))
                .minRow(ER7006PosLtlbDppkPst.getRowSize(programType))
                .fields(new ArrayList<>())
                .build();
    }

    public static SubmissionFormat formMetadata(SectorType sectorType, ProgramType programType) {
        FIELD_METADATA.setProgramType(programType);

        BaseMetadataValidation<? extends ILbltMetadataValidation> metadataValidation = null;
        ReferenceConfig referenceConfig = ER7006PosLtlbDppkPst.getRefConfig(programType);

        switch (programType) {
            case PPMPK:
                metadataValidation = VALIDATION_METADATA_PPMPK;
                break;
            case PPMPM:
                metadataValidation = VALIDATION_METADATA_PPMPM;
                break;
            case PPIPK:
                metadataValidation = VALIDATION_METADATA_PPIPK;
                break;
            case PPIPM:
                metadataValidation = VALIDATION_METADATA_PPIPM;
                break;
            case DPLK:
                metadataValidation = VALIDATION_METADATA_DPLK;
                break;
            default:
                throw new IllegalStateException();
        }

        BaseSubmissionConfig.Config<?> submissionConfig = new SubmissionConfig(programType).config()
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType))
                .setReferenceConfigs(referenceConfig)
                .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
                .setSegmentValidations(metadataValidation);

//        if (programType == DPLK) {
//            submissionConfig
//                    .setSubmissionField(FIELD_METADATA.getClearedFields())
//                    .setSegmentValidations();
//        } else {
//            submissionConfig
//                    .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
//                    .setSegmentValidations(metadataValidation);
//        }

        return submissionConfig.build().get();

//        return new SubmissionConfig(programType)
//                .config()
//                .setReferenceConfigs(referenceConfig)
//                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType))
//                .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
//                .setSegmentValidations(metadataValidation).build()
//                .get();
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