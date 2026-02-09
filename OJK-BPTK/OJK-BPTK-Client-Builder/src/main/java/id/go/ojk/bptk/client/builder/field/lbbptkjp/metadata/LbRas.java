package id.go.ojk.bptk.client.builder.field.lbbptkjp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjp;
import id.go.ojk.bptk.client.builder.field.lbbptkjp.reference.EHeaderMetadataLbbptkjp;
import id.go.ojk.bptk.client.builder.field.lbbptkjp.reference.ER5805RAS;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbRas extends BaseMetadata {
  public LbRas(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjp eEnum = EFormLbbptkjp.RAS;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 32, 32);

    res.setRequiredPos(ER5805RAS.genRequiredPos());
    res.setUniquePos(ER5805RAS.genUniquePos());
    res.setSavePos(ER5805RAS.genFieldSave());

    res.addSegmentValidations(ER5805RAS.genRegexValidation01());
    res.addSegmentValidations(ER5805RAS.genRegexValidation02());
    res.addSegmentValidations(ER5805RAS.genMaxLengthValidation());
    res.addSegmentValidations(ER5805RAS.genMaxLengthValidation2());

    res.addSegmentValidations(ER5805RAS.genRowValidation04());
    res.addSegmentValidations(ER5805RAS.genRowValidation07());
    res.addSegmentValidations(ER5805RAS.genRowValidation11());
    res.addSegmentValidations(ER5805RAS.genRowValidation14());
    res.addSegmentValidations(ER5805RAS.genRowValidation17());
    res.addSegmentValidations(ER5805RAS.genRowValidation20());
    res.addSegmentValidations(ER5805RAS.genRowValidation24());
    res.addSegmentValidations(ER5805RAS.genRowValidation27());
    res.addSegmentValidations(ER5805RAS.genRowValidation30());
    res.addSegmentValidations(ER5805RAS.genRowValidation33());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkjp.R5805RAS.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Nilai Rasio", sv(M, 1, Integer.MAX_VALUE, all2)));
    return res;
  }
}
