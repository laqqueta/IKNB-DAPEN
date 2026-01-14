package id.go.ojk.bpks.client.builder.field.lbbpkslpp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.EHeaderMetadataLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.ER5205PDK;
import id.go.ojk.bpks.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbPdk extends BaseMetadata {
  public LbPdk(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslpp eEnum = EFormLbbpkslpp.PDK;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 1, null);

    res.setRequiredPos(ER5205PDK.genRequiredPos());
    res.setUniquePos(ER5205PDK.genUniquePos());
    res.setSavePos(ER5205PDK.genFieldSave());
    res.setSavePosForm(ER5205PDK.genFieldSaveForm());

    res.addSegmentValidations(ER5205PDK.genValidationTotal());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpkslpp.R5205PDK.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Tingkat Pendidikan", sv(C, 1, 10, alfaNumeric)
        .confConditionalRequired(ER5205PDK.genConditionalExistA())
        .confReference(EHeaderMetadataShared.TINGKAT_PENDIDIKAN.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(3, null, "Laki-Laki", sv(M, 1, 10, numeric)));
    fs.add(sf(4, null, "Perempuan", sv(M, 1, 10, numeric)));
    fs.add(sf(5, null, "Jumlah", sv(M, 1, 10, numeric))
        .addFieldValidations(ER5205PDK.genFieldValidation07()));
    return res;
  }
}
