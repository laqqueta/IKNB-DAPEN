package id.go.ojk.metadata.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.metadata.module.lblt.dppk.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.dppk.header.*;
import id.go.ojk.metadata.module.lblt.dppk.reference.ER7067PosLtlbDppkPph;
import id.go.ojk.metadata.module.lblt.dppk.validations.E7067PphValidationsConfig;
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
import static id.go.ojk.metadata.util.constants.ProgramType.*;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0067Pph implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(0, null, "Flag",
                    sv(M, 3, 3, alfaNumeric)
                            .confConstant("D01"))
    ),
    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(1, null, "Kode Komponen",
                    sv(M, 9, 9, refTable)
                            .confRegex(SimpleValidation.patternAlfaNumeric))
    ),
    JENIS_PAJAK_PENGHASILAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(2, null, "Jenis Pajak Penghasilan",
                    sv(C, 1, 100, freeText)
                    /*.confConditionalRequired(E7067PphValidationsConfig.CR_EXISTS_POS_M)*/)
    ),
    JUMLAH(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(3, null, "Jumlah",
                    sv(M, 1, 18, numeric))
    ),
    MANFAAT_PENSIUN_LAINNYA_LAIN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(4, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain",
                    sv(C, 1, 6, refTable)
                            /*.confConditionalRequired(E7067PphValidationsConfig.CR_EXISTS_POS_M)*/
                            .confRegex(SimpleValidation.patternAlfaNumeric)
                            .confReference(EHeaderMetadataSharedLkbt.R009.getObject()))
    ),
    KETERANGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM, PPIPK),
            sf(5, null, "Keterangan",
                    sv(C, 1, 250, freeText)
                    /*.confConditionalRequired(E7067PphValidationsConfig.CR_EXISTS_POS_O)*/)
    ),
    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7067Pph.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7067Pph.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPK, EHeaderMetadataPpipk.R7067Pph.getObject()),
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataPpipm.R7067Pph.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0067Pph> FIELD_METADATA = new LbltMetadataField<>(Dppk0067Pph.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan PPH_FORM = EFormLaporanBulananTahunan.LTLB_PPH;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(PPH_FORM.getCode())
                .name(PPH_FORM.getName())
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

        BaseMetadataValidation<E7067PphValidationsConfig> metadataValidation = null;

        switch (programType) {
            case PPMPK:
                metadataValidation = E7067PphValidationsConfig.VALIDATION_METADATA_PPMPK;
                break;
            case PPMPM:
                metadataValidation = E7067PphValidationsConfig.VALIDATION_METADATA_PPMPM;
                break;
            case PPIPK:
                metadataValidation = E7067PphValidationsConfig.VALIDATION_METADATA_PPIPK;
                break;
            case PPIPM:
                metadataValidation = E7067PphValidationsConfig.VALIDATION_METADATA_PPIPM;
                break;
            default:
                throw new IllegalStateException();
        }

        return new SubmissionConfig(programType.toString())
                .config()
                .setReferenceConfigs(ER7067PosLtlbDppkPph.Configs.REF_CONFIG_PPMP)
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