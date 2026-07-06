package id.go.ojk.metadata.module.lblt.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.metadata.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataLkbtDplk;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataPpipm;
import id.go.ojk.metadata.module.lblt.reference.ER7201PosLtlbDppkLcf;
import id.go.ojk.metadata.module.lblt.validations.E7201LcfValidationsConfig;
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
import static id.go.ojk.metadata.util.constants.ProgramType.DPLK;
import static id.go.ojk.metadata.util.constants.ProgramType.PPIPM;
import static id.go.ojk.metadata.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.metadata.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0121Lcf implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric)
                    .confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK),
            sf(1, null, "Kode Komponen", sv(M, 13, 13, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
                    .confUnique(UniqueType.U)),

    JUMLAH_PESERTA(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK),
            sf(2, null, "Jumlah Peserta", sv(C, 1, 18, numeric))),

    HASIL_INVESTASI_TERLEASISASI(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK),
            sf(3, null, "Hasil Investasi yang Terealisasi", sv(C, 1, 18, numeric))),

    HASIL_INVESTASI_BELUM_TERLEASISASI(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK),
            sf(4, null, "Hasil Investasi yang belum Terealisasi", sv(C, 1, 18, numeric))),

    BEBAN_INVESATASI(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK),
            sf(5, null, "Beban Invesatsi", sv(C, 1, 18, numeric))),

    HASIL_INVESTASI_BERSIH(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK),
            sf(6, null, "Hasil Investasi Bersih", sv(C, 1, 18, numeric))),

    RATA_RATA_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK),
            sf(7, null, "Rata - Rata Investasi", sv(C, 1, 18, numeric))),

    ROI(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK),
            sf(8, null, "ROI", sv(C, 1, 18, numeric))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataPpipm.R7099Lcf.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkbtDplk.R7099Lcf.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private static final LbltMetadataField<Dppk0121Lcf> FIELD_METADATA = new LbltMetadataField<>(Dppk0121Lcf.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    private static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan form = EFormLaporanBulananTahunan.LTLB_LCF;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(form.getCode())
                .name(form.getName())
                .extension(ExtensionType.TXT)
                .reportCode(programType.toString())
                .maxRow(7)
                .minRow(7)
                .fields(new ArrayList<>())
                .build();

        if (sectorType.equals(KONVENSIONAL) || sectorType.equals(SYARIAH)) {
            return sfConfig;
        }


        throw new IllegalArgumentException("Unknown sector type: " + sectorType);
    }

    public static SubmissionFormat formMetadata(SectorType sectorType, ProgramType programType) {
        FIELD_METADATA.setProgramType(programType);

        BaseMetadataValidation<E7201LcfValidationsConfig> metadataValidation = null;

        switch (programType) {
            case PPIPM:
                metadataValidation = E7201LcfValidationsConfig.VALIDATION_METADATA_PPIPM;
                break;
            case DPLK:
                break;
            default:
                throw new IllegalStateException();
        }

        return new SubmissionConfig(programType)
                .config()
                .setReferenceConfigs(ER7201PosLtlbDppkLcf.Configs.REF_CONFIG)
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType))
                .setSubmissionField(FIELD_METADATA.getClearedFields())
                .setSegmentValidations()
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