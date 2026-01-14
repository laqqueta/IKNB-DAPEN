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
import id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference.ER5101LAV;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLav extends BaseMetadata {
  public LbLav(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpksdjs eEnum = EFormLbbpksdjs.LAV;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 23, 23);

    res.setRequiredPos(ER5101LAV.genRequiredPos());
    res.setUniquePos(ER5101LAV.genUniquePos());
    res.setSavePos(ER5101LAV.genFieldSave());
    res.setSavePosForm(ER5101LAV.genFieldSave());

    res.addSegmentValidations(ER5101LAV.genRowValidation11());
    res.addSegmentValidations(ER5101LAV.genRowValidation13());
    res.addSegmentValidations(ER5101LAV.genRowValidation21());
    res.addSegmentValidations(ER5101LAV.genRowValidation22());
    res.addSegmentValidations(ER5101LAV.genRowValidation24());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpksdjs.R5101LAV.getObject()).confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Saldo", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
