package id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.EHeaderMetadataLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.ER5305AI;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbAi extends BaseMetadata {
  public LbAi(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkbdn eEnum = EFormLbbptkbdn.AI;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 36, 36);

    res.setRequiredPos(ER5305AI.genRequiredPos());
    res.setUniquePos(ER5305AI.genUniquePos());
    res.setSavePos(ER5305AI.genFieldSave());
    res.setSavePosForm(ER5305AI.genFieldSave());

    res.addSegmentValidations(ER5305AI.genRowValidation02());
    res.addSegmentValidations(ER5305AI.genRowValidation06());
    res.addSegmentValidations(ER5305AI.genRowValidation18());
    res.addSegmentValidations(ER5305AI.genRowValidation29());
    res.addSegmentValidations(ER5305AI.genRowValidation32());
    res.addSegmentValidations(ER5305AI.genRowValidation37());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
        .confReference(EHeaderMetadataLbbptkbdn.R5305AI.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
