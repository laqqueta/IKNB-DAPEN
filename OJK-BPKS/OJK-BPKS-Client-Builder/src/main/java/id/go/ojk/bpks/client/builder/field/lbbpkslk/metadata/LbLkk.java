package id.go.ojk.bpks.client.builder.field.lbbpkslk.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.EHeaderMetadataLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.ER5001LKK;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLkk extends BaseMetadata {
  public LbLkk(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslk eEnum = EFormLbbpkslk.LKK;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 22, 22);

    res.setRequiredPos(ER5001LKK.genRequiredPos());
    res.setUniquePos(ER5001LKK.genUniquePos());
    res.setSavePos(ER5001LKK.genFieldSave());
    res.setSavePosForm(ER5001LKK.genFieldSave());

    res.addSegmentValidations(ER5001LKK.genRowValidation3());
    res.addSegmentValidations(ER5001LKK.genRowValidation5());
    res.addSegmentValidations(ER5001LKK.genRowValidation6());
    res.addSegmentValidations(ER5001LKK.genRowValidation15());
    res.addSegmentValidations(ER5001LKK.genRowValidation16());
    res.addSegmentValidations(ER5001LKK.genRowValidation18());
    res.addSegmentValidations(ER5001LKK.genRowValidation22());
    res.addSegmentValidations(ER5001LKK.genRowValidation23());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpkslk.R5001LKK.getObject()).confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
