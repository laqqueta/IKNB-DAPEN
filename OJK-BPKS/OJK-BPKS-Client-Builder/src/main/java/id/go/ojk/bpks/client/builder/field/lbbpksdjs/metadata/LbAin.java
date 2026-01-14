package id.go.ojk.bpks.client.builder.field.lbbpksdjs.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpksdjs;
import id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference.EHeaderMetadataLbbpksdjs;
import id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference.ER5104AIN;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbAin extends BaseMetadata {
  public LbAin(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpksdjs eEnum = EFormLbbpksdjs.AIN;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 5, 5);

    res.setRequiredPos(ER5104AIN.genRequiredPos());
    res.setUniquePos(ER5104AIN.genUniquePos());
    res.setSavePos(ER5104AIN.genFieldSave());
    res.setSavePosForm(ER5104AIN.genFieldSave());

    res.addSegmentValidations(ER5104AIN.genRowValidation06());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5104AIN.genRowValidation03());
    res.addSegmentValidations(ER5104AIN.genRowValidation04());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpksdjs.R5104AIN.getObject()).confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Saldo", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
