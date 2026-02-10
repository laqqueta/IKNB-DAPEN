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
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.ER5004AI;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbAi extends BaseMetadata {
  public LbAi(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslk eEnum = EFormLbbpkslk.AI;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 35, 35);

    res.setRequiredPos(ER5004AI.genRequiredPos());
    res.setUniquePos(ER5004AI.genUniquePos());
    res.setSavePos(ER5004AI.genFieldSave());

    res.addSegmentValidations(ER5004AI.genRowValidation5());
    res.addSegmentValidations(ER5004AI.genRowValidation17());
    res.addSegmentValidations(ER5004AI.genRowValidation28());
    res.addSegmentValidations(ER5004AI.genRowValidation31());
    res.addSegmentValidations(ER5004AI.genRowValidation35());
    res.addSegmentValidations(ER5004AI.genRowValidation36());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5004AI.genRowValidation17b());
    res.addSegmentValidations(ER5004AI.genRowValidation28b());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 12, 12, refTable)
        .confReference(EHeaderMetadataLbbpkslk.R5004AI.getObject()).confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
