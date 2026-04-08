package id.go.ojk.bptk.client.builder.field.lbbptkjht.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjht;
import id.go.ojk.bptk.client.builder.field.lbbptkjht.reference.EHeaderMetadataLbbptkjht;
import id.go.ojk.bptk.client.builder.field.lbbptkjht.reference.ER5605RAS;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbRas extends BaseMetadata {
  public LbRas(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjht eEnum = EFormLbbptkjht.RAS;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 38, 38);

    res.setRequiredPos(ER5605RAS.genRequiredPos());
    res.setUniquePos(ER5605RAS.genUniquePos());
    res.setSavePos(ER5605RAS.genFieldSave());

    res.addSegmentValidations(ER5605RAS.genRegexValidation01());
    res.addSegmentValidations(ER5605RAS.genRegexValidation02());
    res.addSegmentValidations(ER5605RAS.genMaxLengthValidation());
    res.addSegmentValidations(ER5605RAS.genMaxLengthValidation2());

    res.addSegmentValidations(ER5605RAS.genRowValidation04());
    res.addSegmentValidations(ER5605RAS.genRowValidation09());
    res.addSegmentValidations(ER5605RAS.genRowValidation12());
    res.addSegmentValidations(ER5605RAS.genRowValidation14());
    res.addSegmentValidations(ER5605RAS.genRowValidation18());
    res.addSegmentValidations(ER5605RAS.genRowValidation21());
    res.addSegmentValidations(ER5605RAS.genRowValidation24());
    res.addSegmentValidations(ER5605RAS.genRowValidation30());
    res.addSegmentValidations(ER5605RAS.genRowValidation33());
    res.addSegmentValidations(ER5605RAS.genRowValidation36());
    res.addSegmentValidations(ER5605RAS.genRowValidation39());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkjht.R5605RAS.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Nilai Rasio", sv(M, 1, Integer.MAX_VALUE, all2)));
    return res;
  }
}
