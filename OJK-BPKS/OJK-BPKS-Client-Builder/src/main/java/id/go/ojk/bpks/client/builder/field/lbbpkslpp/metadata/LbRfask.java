package id.go.ojk.bpks.client.builder.field.lbbpkslpp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.*;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.EHeaderMetadataLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.ER5210RFASK;
import id.go.ojk.bpks.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbRfask extends BaseMetadata {
  public LbRfask(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslpp eEnum = EFormLbbpkslpp.RFASK;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 1, null);

    res.setRequiredPos(ER5210RFASK.genRequiredPos());
    res.setUniquePos(ER5210RFASK.genUniquePos());
    res.setSavePos(ER5210RFASK.genFieldSave());

    res.addSegmentValidations(ER5210RFASK.genValidationTotal());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 15, 15, refTable)
        .confReference(EHeaderMetadataLbbpkslpp.R5210RFASK.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Sandi Lokasi", sv(C, 1, 10, refTable)
        .confReference(EHeaderMetadataShared.LOKASI_DATI_2.getObject())
        .confRegex(PATTERN_REFERENCE_1)
        .confConditionalRequired(ER5210RFASK.genConditionalExistA())));
    fs.add(sf(3, null, "Nama Lokasi", sv(C, 1, 100, all)
        .confRegex(PATTERN_NAME)
        .confConditionalRequired(ER5210RFASK.genConditionalExistA())));
    fs.add(sf(4, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 10", sv(M, 1, 10, numeric)));
    fs.add(sf(5, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 11", sv(M, 1, 10, numeric)));
    fs.add(sf(6, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 12", sv(M, 1, 10, numeric)));
    fs.add(sf(7, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 13", sv(M, 1, 10, numeric)));
    fs.add(sf(8, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 14", sv(M, 1, 10, numeric)));
    fs.add(sf(9, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 15", sv(M, 1, 10, numeric)));
    fs.add(sf(10, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 16", sv(M, 1, 10, numeric)));
    fs.add(sf(11, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 17", sv(M, 1, 10, numeric)));
    fs.add(sf(12, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 18", sv(M, 1, 10, numeric)));
    fs.add(sf(13, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 19", sv(M, 1, 10, numeric)));
    fs.add(sf(14, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 20", sv(M, 1, 10, numeric)));
    fs.add(sf(15, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 21", sv(M, 1, 10, numeric)));
    fs.add(sf(16, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 22", sv(M, 1, 10, numeric)));
    fs.add(sf(17, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 23", sv(M, 1, 10, numeric)));
    fs.add(sf(18, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 24", sv(M, 1, 10, numeric)));
    fs.add(sf(19, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 25", sv(M, 1, 10, numeric)));
    fs.add(sf(20, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 26", sv(M, 1, 10, numeric)));
    fs.add(sf(21, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 27", sv(M, 1, 10, numeric)));
    fs.add(sf(22, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 28", sv(M, 1, 10, numeric)));
    fs.add(sf(23, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 29", sv(M, 1, 10, numeric)));
    fs.add(sf(24, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 30", sv(M, 1, 10, numeric)));
    fs.add(sf(25, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 31", sv(M, 1, 10, numeric)));
    fs.add(sf(26, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 32", sv(M, 1, 10, numeric)));
    fs.add(sf(27, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 33", sv(M, 1, 10, numeric)));
    fs.add(sf(28, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 34", sv(M, 1, 10, numeric)));
    fs.add(sf(29, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 35", sv(M, 1, 10, numeric)));
    fs.add(sf(30, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 36", sv(M, 1, 10, numeric)));
    fs.add(sf(31, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - 37", sv(M, 1, 10, numeric)));
    fs.add(sf(32, null, "Jumlah Faskes per Jenis Fasilitas Kesehatan - Total", sv(M, 1, 10, numeric))
        .addFieldValidations(ER5210RFASK.genFieldValidation33()));
    return res;
  }
}
