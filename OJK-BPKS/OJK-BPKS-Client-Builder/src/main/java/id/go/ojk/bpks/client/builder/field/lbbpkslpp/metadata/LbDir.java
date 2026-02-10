package id.go.ojk.bpks.client.builder.field.lbbpkslpp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_NAME_7;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.EHeaderMetadataLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.ER5202DIR;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbDir extends BaseMetadata {
  public LbDir(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslpp eEnum = EFormLbbpkslpp.DIR;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 0, null);

    res.setSavePosForm(ER5202DIR.genFieldSave());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpkslpp.R5202DIR.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Nama Dewan Direksi", sv(M, 1, 100, all).confRegex(PATTERN_NAME_7)));
    fs.add(sf(3, null, "Nomenklatur Jabatan", sv(M, 1, 50, all)));
    fs.add(sf(4, null, "Tanggal Mulai Menjabat", sv(O, 8, 8, date)));
    fs.add(sf(5, null, "Nomor SK Pengangkatan", sv(M, 1, 100, all)));
    fs.add(sf(6, null, "Tanggal SK", sv(O, 8, 8, date)));
    fs.add(sf(7, null, "Perihal SK", sv(M, 1, 250, all)));
    return res;
  }
}
