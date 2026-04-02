package id.go.ojk.module.lblt.dppk.metadata;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.module.lblt.EFormLaporanBulananTahunan;
import id.go.ojk.util.IFieldMetadata;
import id.go.ojk.util.MetadataField;
import id.go.ojk.util.constants.ExtensionType;
import id.go.ojk.util.constants.SectorType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.EnumSet;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.freeText;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;
import static id.go.ojk.util.FieldBuilder.*;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk001Dtum implements IFieldMetadata {

    FLAG(sectors(KONVENSIONAL, SYARIAH),
            sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01"))),
    KODE_KOMPONEN(sectors(KONVENSIONAL, SYARIAH),
            sf(1, null, "Kode Komponen", sv(O, 10, 10, freeText)
                    .confRegex(SimpleValidation.patternAlfaNumeric)
                    /*.confReference(EHeaderMetadataPpmpk.R7000Dtum.getObject())*/)),
    KETERANGAN(sectors(KONVENSIONAL, SYARIAH),
            sf(2, null, "Keterangan", sv(O, 1, 1000, freeText))),

    ;

    @Getter
    private final EnumSet<SectorType> sectorType;

    @Getter
    private final SubmissionField field;

    public static final MetadataField<Dppk001Dtum> METADATA = new MetadataField<>(Dppk001Dtum.class);

    public static SubmissionFormatBuilder getSubmissionFormatConfig(SectorType sectorType, String reportCode) {
        EFormLaporanBulananTahunan DTUM_FORM = EFormLaporanBulananTahunan.LTLB_DTUM;

        if (sectorType.equals(SYARIAH)) {
            return SubmissionFormatBuilder.builder()
                    .code(DTUM_FORM.getCode())
                    .name(DTUM_FORM.getName())
                    .extension(ExtensionType.TXT.getExtension())
                    .reportCode(reportCode)
                    .minRow(25)
                    .maxRow(null)
                    .fields(new ArrayList<>())
                    .build();
        } else if (sectorType.equals(KONVENSIONAL)) {
            return SubmissionFormatBuilder.builder()
                    .code(DTUM_FORM.getCode())
                    .name(DTUM_FORM.getName())
                    .extension(ExtensionType.TXT.getExtension())
                    .reportCode(reportCode)
                    .minRow(99)
                    .maxRow(null)
                    .fields(new ArrayList<>())
                    .build();
        }

        throw new IllegalArgumentException("Unknown sector type: " + sectorType);
    }
}
