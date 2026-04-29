package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpm;
import id.go.ojk.module.lblt.dppk.reference.ER7019PosLtlbDppkPius;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.constants.SectorType;
import id.go.ojk.util.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.util.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.util.metadata.submission.SubmissionConfig;
import lombok.AllArgsConstructor;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;
import static id.go.ojk.util.FieldUtil.*;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0019Pius implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01"))
    ),
    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen", sv(O, 14, 14, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
    ),
    JUMLAH_PESERTA_IURAN_SUKARELA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(2, null, "Jumlah Peserta Iuran Sukarela", sv(O, 1, 18, numeric))
    ),
    SALDO_AKUMULASI_IURAN_SUKARELA_BULAN_SEBELUMNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(3, null, "Saldo Akumulasi Iuran Sukarela bulan sebelumnya", sv(O, 1, 18, numeric))
    ),
    PENAMBAHAN_IURAN_SUKARELA_BULAN_BERJALAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(4, null, "Penambahan iuran sukarela bulan berjalan", sv(O, 1, 18, numeric))
    ),
    DISTRIBUSI_HASIL_PENGEMBANGAN_DANA_IURAN_SUKARELA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(5, null, "Distribusi Hasil Pengembangan Dana Iuran Sukarela", sv(O, 1, 18, numeric))
    ),
    TOTAL_SALDO_AKUMULASI_IURAN_SUKARELA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(6, null, "Total Saldo akumulasi iuran sukarela", sv(O, 1, 18, numeric))
    ),
    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

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

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7019Pius.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7019Pius.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final LbltMetadataField<Dppk0019Pius> FIELD_KONVEN = new LbltMetadataField<>(Dppk0019Pius.class, KONVENSIONAL, KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan PIUS_FORM = EFormLaporanBulananTahunan.LTLB_PIUS;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(PIUS_FORM.getCode())
                .name(PIUS_FORM.getName())
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

    public static SubmissionFormat ppmpKonvensionalFormMetadata(ProgramType programType) {
        FIELD_KONVEN.setProgramType(programType);
        return new SubmissionConfig(programType.toString())
                .config()
                .setReferenceConfigs(ER7019PosLtlbDppkPius.Configs.REF_CONFIG_PPMP)
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(KONVENSIONAL, programType.toString()))
                .setSubmissionField(FIELD_KONVEN.getClearedFields())
                //                .setSegmentValidations(E7019PiusValidationsConfig.VALIDATION_METADATA)
                .setSegmentValidations()
                .build()
                .get();
    }
}