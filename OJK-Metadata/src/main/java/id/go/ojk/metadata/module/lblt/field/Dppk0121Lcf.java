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
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataLkdpDplk;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataLkdpPpipm;
import id.go.ojk.metadata.module.lblt.header.EHeaderMetadataLkdpPpmpppipk;
import id.go.ojk.metadata.module.lblt.reference.ER7201PosLtlbDppkLcf;
import id.go.ojk.metadata.module.lblt.validations.E7201LcfValidationsConfig;
import id.go.ojk.metadata.module.lblt.validations.gabungan.E7201LcfGabunganValidationsConfig;
import id.go.ojk.metadata.submission.SubmissionConfig;
import id.go.ojk.metadata.submission.base.BaseSubmissionConfig;
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
public enum Dppk0121Lcf implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK, PPMPPPIPK),
            sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric)
                    .confConstant("D01"))),

    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK),
            sf(1, null, "Kode Komponen", sv(M, 13, 13, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
                    .confUnique(UniqueType.U)),

    KODE_KOMPONEN_GABUNGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
            sf(1, null, "Kode Komponen", sv(M, 13, 13, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))),

    JUMLAH_PESERTA(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK, PPMPPPIPK),
            sf(2, null, "Jumlah Peserta", sv(C, 1, 18, numeric))),

    HASIL_INVESTASI_TERLEASISASI(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK, PPMPPPIPK),
            sf(3, null, "Hasil Investasi yang Terealisasi", sv(C, 1, 18, numeric))),

    HASIL_INVESTASI_BELUM_TERLEASISASI(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK, PPMPPPIPK),
            sf(4, null, "Hasil Investasi yang belum Terealisasi", sv(C, 1, 18, numeric))),

    BEBAN_INVESATASI(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK, PPMPPPIPK),
            sf(5, null, "Beban Invesatsi", sv(C, 1, 18, numeric))),

    HASIL_INVESTASI_BERSIH(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK, PPMPPPIPK),
            sf(6, null, "Hasil Investasi Bersih", sv(C, 1, 18, numericNegatif))),

    RATA_RATA_INVESTASI(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK, PPMPPPIPK),
            sf(7, null, "Rata - Rata Investasi", sv(C, 1, 18, numeric))),

    ROI(sectors(KONVENSIONAL, SYARIAH), programs(PPIPM, DPLK, PPMPPPIPK),
            sf(8, null, "ROI", sv(C, 1, 18, numeric))),

    /* Gabungan Additional Field */

    JENIS_PROGRAM(sectors(KONVENSIONAL, SYARIAH), programs(PPMPPPIPK),
            sf(1000, null, "Jenis Program", sv(M, 4, 4, alfa)
                    .confConstant("PPMP|PPIP"))),

    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPIPM, EHeaderMetadataLkdpPpipm.R7099Lcf.getObject()),
            new AbstractMap.SimpleEntry<>(DPLK, EHeaderMetadataLkdpDplk.R7099Lcf.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPPPIPK, EHeaderMetadataLkdpPpmpppipk.R7009Lcf.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private static final LbltMetadataField<Dppk0121Lcf> FIELD_METADATA = new LbltMetadataField<>(Dppk0121Lcf.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    private static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, ProgramType programType) {
        EFormLaporanBulananTahunan form = EFormLaporanBulananTahunan.LTLB_LCF;
        int rowSize = ER7201PosLtlbDppkLcf.getRowSize(programType);
        return SubmissionFormatBuilder.builder()
                .code(form.getCode())
                .name(form.getName())
                .extension(ExtensionType.TXT)
                .reportCode(programType.toString())
                .maxRow(rowSize)
                .minRow(rowSize)
                .fields(new ArrayList<>())
                .build();
    }

    public static SubmissionFormat formMetadata(SectorType sectorType, ProgramType programType) {
        FIELD_METADATA.setProgramType(programType);

        BaseMetadataValidation<?> metadataValidation = E7201LcfValidationsConfig.getValidationMetadata(programType);
        ReferenceConfig referenceConfig = ER7201PosLtlbDppkLcf.getRefConfig(programType);
        BaseSubmissionConfig.Config<?> submissionConfig = new SubmissionConfig(programType)
                .config()
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(sectorType, programType))
                .setReferenceConfigs(referenceConfig)
                .setSubmissionField(FIELD_METADATA.getFields(metadataValidation.getFieldValidations()))
                .setSegmentValidations(metadataValidation);

        if (programType.equals(PPMPPPIPK)) {
            List<Integer> gabunganFields = Arrays.asList(0, 1, 1000, 2, 3, 4, 5, 6, 7, 8);
            metadataValidation = E7201LcfGabunganValidationsConfig.VALIDATION_METADATA_PPMPPPIPK;
            submissionConfig
                    .setReferenceConfigs(referenceConfig)
                    .setSubmissionField(FIELD_METADATA.getReindexFields(gabunganFields, metadataValidation.getFieldValidations()))
                    .setSegmentValidations(metadataValidation);
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