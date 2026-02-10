package id.go.ojk.bpks.client.builder.field.lbbpkslpp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_NAME;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.EHeaderMetadataLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.ER5207RKPS;
import id.go.ojk.bpks.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbRkps extends BaseMetadata {
  public LbRkps(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslpp eEnum = EFormLbbpkslpp.RKPS;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 1, null);

    res.setRequiredPos(ER5207RKPS.genRequiredPos());
    res.setUniquePos(ER5207RKPS.genUniquePos());
    res.setSavePos(ER5207RKPS.genFieldSave());

    res.addSegmentValidations(ER5207RKPS.genValidationTotal());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 14, 14, refTable)
        .confReference(EHeaderMetadataLbbpkslpp.R5207RKPS.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Sandi Lokasi", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.LOKASI_DATI_2.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5207RKPS.genConditionalExistA())));
    fs.add(sf(3, null, "Nama Lokasi", sv(C, 1, 100, all)
        .confRegex(PATTERN_NAME)
        .confConditionalRequired(ER5207RKPS.genConditionalExistA())));
    fs.add(sf(4, null, "Segmen Peserta", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.SEGMEN_PESERTA.getObject())
        .confRegex(patternAlfaNumeric)
        .confConditionalRequired(ER5207RKPS.genConditionalExistA())));
    fs.add(sf(5, null, "Kewarganegaraan", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.KEWARGANEGARAAN.getObject())
        .confRegex(patternAlfaNumeric)
        .confConditionalRequired(ER5207RKPS.genConditionalExistA())));
    fs.add(sf(6, null, "Status Tanggungan", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.STATUS_TANGGUNGAN.getObject())
        .confRegex(patternAlfaNumeric)
        .confConditionalRequired(ER5207RKPS.genConditionalExistA())));
    fs.add(sf(7, null, "Kelas Peserta", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.KELAS_PESERTA_PROGRAM_JAMINAN.getObject())
        .confRegex(patternAlfaNumeric)
        .confConditionalRequired(ER5207RKPS.genConditionalExistA())));
    fs.add(sf(8, null, "Peserta Baru", sv(M, 1, 10, numeric)));
    fs.add(sf(9, null, "Peserta Keluar", sv(M, 1, 10, numeric)));
    fs.add(sf(10, null, "Jumlah Peserta - Aktif", sv(M, 1, 10, numeric)));
    fs.add(sf(11, null, "Jumlah Peserta - Tidak Aktif", sv(M, 1, 10, numeric)));
    fs.add(sf(12, null, "Jumlah Peserta - Total", sv(M, 1, 10, numeric))
        .addFieldValidations(ER5207RKPS.genFieldValidation13()));
    return res;
  }
}
