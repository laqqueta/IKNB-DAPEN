package id.go.ojk.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.module.lblt.dppk.form.EFormLaporanBulananTahunan;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpk;
import id.go.ojk.module.lblt.dppk.header.EHeaderMetadataPpmpm;
import id.go.ojk.module.lblt.dppk.reference.ER7004PosLtlbDppkLphu;
import id.go.ojk.module.lblt.dppk.validations.ppmpk.E7004LphuValidationsConfig;
import id.go.ojk.util.constants.ProgramType;
import id.go.ojk.util.constants.SectorType;
import id.go.ojk.util.metadata.field.lblt.ILbltFieldMetadata;
import id.go.ojk.util.metadata.field.lblt.LbltMetadataField;
import id.go.ojk.util.metadata.submission.SubmissionConfig;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;
import static id.go.ojk.util.FieldUtil.*;
import static id.go.ojk.util.constants.ProgramType.PPMPK;
import static id.go.ojk.util.constants.ProgramType.PPMPM;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk0004Lphu implements ILbltFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01"))
    ),
    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(1, null, "Kode Komponen", sv(O, 14, 14, refTable)
                    .confRegex(SimpleValidation.patternAlfaNumeric))
                    .confUnique(UniqueType.U)
    ),
    AKUMULASI_MANFAAT_PENSIUN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK, PPMPM),
            sf(2, null, "Akumulasi s.d DD-MM-YYYY Manfaat Pensiun", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_PENSIUN_LAINNYA_MANFAAT_TAMBAHAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK),
            sf(3, null, "Akumulasi s.d DD-MM-YYYY Manfaat Pensiun Lainnya Manfaat Tambahan", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_PENSIUN_LAINNYA_KOMPENSASI_PASCAKERJA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK),
            sf(4, null, "Akumulasi s.d DD-MM-YYYY Manfaat Pensiun Lainnya Kompensasi Pascakerja", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_PENSIUN_LAINNYA_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK),
            sf(5, null, "Akumulasi s.d DD-MM-YYYY Manfaat Pensiun Lainnya Lainnya", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_LAIN_KOMPENSASI_PASCAKERJA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK),
            sf(6, null, "Akumulasi s.d DD-MM-YYYY Manfaat Lain Kompensasi Pascakerja", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_LAIN_KESEHATAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK),
            sf(7, null, "Akumulasi s.d DD-MM-YYYY Manfaat Lain Kesehatan", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_LAIN_SANTUNAN_KEMATIAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK),
            sf(8, null, "Akumulasi s.d DD-MM-YYYY Manfaat Lain Santunan Kematian", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_LAIN_IBADAH_KEAGAMAAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK),
            sf(9, null, "Akumulasi s.d DD-MM-YYYY Manfaat Lain Ibadah Keagamaan", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_LAIN_PENDIDIKAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK),
            sf(10, null, "Akumulasi s.d DD-MM-YYYY Manfaat Lain Pendidikan", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_MANFAAT_LAIN_LAINNYA(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK),
            sf(11, null, "Akumulasi s.d DD-MM-YYYY Manfaat Lain Lainnya", sv(O, 1, 18, numericNegatif))
    ),
    AKUMULASI_GABUNGAN(sectors(KONVENSIONAL, SYARIAH), programs(PPMPK),
            sf(12, null, "Akumulasi s.d DD-MM-YYYY Gabungan", sv(O, 1, 18, numericNegatif))
                    .addFieldValidations(E7004LphuValidationsConfig.FV_EQUALS)
    ),
    ;

    private final EnumSet<SectorType> sectorType;
    private final EnumSet<ProgramType> programType;
    private final SubmissionField field;

    private static final Map<ProgramType, ReferenceMetadata> KODE_KOMPONEN_HEADERS = Stream.of(
            new AbstractMap.SimpleEntry<>(PPMPK, EHeaderMetadataPpmpk.R7004Lphu.getObject()),
            new AbstractMap.SimpleEntry<>(PPMPM, EHeaderMetadataPpmpm.R7004Lphu.getObject())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    public static final LbltMetadataField<Dppk0004Lphu> FIELD_KONVEN = new LbltMetadataField<>(Dppk0004Lphu.class, Arrays.asList(KONVENSIONAL, SYARIAH), KODE_KOMPONEN_HEADERS);

    public static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan LPHU_FORM = EFormLaporanBulananTahunan.LTLB_LPHU;
        SubmissionFormatBuilder sfConfig = SubmissionFormatBuilder.builder()
                .code(LPHU_FORM.getCode())
                .name(LPHU_FORM.getName())
                .extension(ExtensionType.TXT)
                .reportCode(reportCode)
                .maxRow(31)
                .fields(new ArrayList<>())
                .build();

        if (sectorType.equals(KONVENSIONAL) || sectorType.equals(SYARIAH)) {
            sfConfig.setMinRow(31);
            return sfConfig;
        }


        throw new IllegalArgumentException("Unknown sector type: " + sectorType);
    }

    public static SubmissionFormat ppmpKonvensionalFormMetadata(ProgramType programType) {
        FIELD_KONVEN.setProgramType(programType);
        return new SubmissionConfig(programType.toString())
                .config()
                .setReferenceConfigs(ER7004PosLtlbDppkLphu.Configs.REF_CONFIG_PPMPK)
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(KONVENSIONAL, programType.toString()))
                .setSubmissionField(FIELD_KONVEN.getClearedFields())
//                .setSegmentValidations(E7004LphuValidationsConfig.VALIDATION_METADATA)
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