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

import java.util.EnumSet;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.freeText;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;
import static id.go.ojk.util.FieldBuilder.*;
import static id.go.ojk.util.constants.SectorType.KONVENSIONAL;
import static id.go.ojk.util.constants.SectorType.SYARIAH;

@AllArgsConstructor
public enum Dppk001Dtum implements IFieldMetadata {

    FLAG(sf(0, null, "Flag", sv(O, 3, 3, alfaNumeric).confConstant("D01")),
            sectors(KONVENSIONAL, SYARIAH)),
    KODE_KOMPONEN(sf(1, null, "Kode Komponen", sv(O, 10, 10, freeText)
            .confRegex(SimpleValidation.patternAlfaNumeric)
            /*.confReference(EHeaderMetadataPpmpk.R7000Dtum.getObject())*/),
            sectors(KONVENSIONAL, SYARIAH)),
    KETERANGAN(sf(2, null, "Keterangan", sv(O, 1, 1000, freeText)),
            sectors(KONVENSIONAL, SYARIAH)),

    ;

    @Getter
    private final SubmissionField field;

    @Getter
    private final EnumSet<SectorType> sectorType;

    private static final EFormLaporanBulananTahunan DTUM_FORM = EFormLaporanBulananTahunan.LTLB_DTUM;

    public static final SubmissionFormatBuilder KONVENSIONAL_SUBMISSION_FORMAT_CONFIG = SubmissionFormatBuilder.builder()
            .code(DTUM_FORM.getCode())
            .name(DTUM_FORM.getName())
            .extension(ExtensionType.TXT.getExtension())
            .minRow(25)
            .maxRow(null)
            .build();

    public static final SubmissionFormatBuilder SYARIAH_SUBMISSION_FORMAT_CONFIG = SubmissionFormatBuilder.builder()
            .code(DTUM_FORM.getCode())
            .name(DTUM_FORM.getName())
            .extension(ExtensionType.TXT.getExtension())
            .minRow(25)
            .maxRow(null)
            .build();

    public static final MetadataField<Dppk001Dtum> METADATA_FIELD =
            new MetadataField<>(Dppk001Dtum.class);


}
