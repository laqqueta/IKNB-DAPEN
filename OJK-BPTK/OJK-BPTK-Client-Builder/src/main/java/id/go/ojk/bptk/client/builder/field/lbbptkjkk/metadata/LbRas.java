package id.go.ojk.bptk.client.builder.field.lbbptkjkk.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjkk;
import id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference.EHeaderMetadataLbbptkjkk;
import id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference.ER5407RAS;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbRas extends BaseMetadata {
  public LbRas(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjkk eEnum = EFormLbbptkjkk.RAS;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 25, 25);

    res.setRequiredPos(ER5407RAS.genRequiredPos());
    res.setUniquePos(ER5407RAS.genUniquePos());
    res.setSavePos(ER5407RAS.genFieldSave());

    res.addSegmentValidations(ER5407RAS.genRegexValidation01());
    res.addSegmentValidations(ER5407RAS.genRegexValidation02());
    res.addSegmentValidations(ER5407RAS.genMaxLengthValidation());
    res.addSegmentValidations(ER5407RAS.genMaxLengthValidation2());

    res.addSegmentValidations(ER5407RAS.genRowValidation04());
    res.addSegmentValidations(ER5407RAS.genRowValidation08());
    res.addSegmentValidations(ER5407RAS.genRowValidation11());
    res.addSegmentValidations(ER5407RAS.genRowValidation14());
    res.addSegmentValidations(ER5407RAS.genRowValidation17());
    res.addSegmentValidations(ER5407RAS.genRowValidation20(reportCode));
    res.addSegmentValidations(ER5407RAS.genRowValidation23());
    res.addSegmentValidations(ER5407RAS.genRowValidation26());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5407RAS.genRowValidation02());
    res.addSegmentValidations(ER5407RAS.genRowValidation03());
    res.addSegmentValidations(ER5407RAS.genRowValidation05());
    res.addSegmentValidations(ER5407RAS.genRowValidation06());
    res.addSegmentValidations(ER5407RAS.genRowValidation07());
    res.addSegmentValidations(ER5407RAS.genRowValidation09());
    res.addSegmentValidations(ER5407RAS.genRowValidation10());
    res.addSegmentValidations(ER5407RAS.genRowValidation18());
    res.addSegmentValidations(ER5407RAS.genRowValidation21());
    res.addSegmentValidations(ER5407RAS.genRowValidation24());
    res.addSegmentValidations(ER5407RAS.genRowValidation25());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkjkk.R5407RAS.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Rasio", sv(M, 1, Integer.MAX_VALUE, all2)));
    return res;
  }
}
