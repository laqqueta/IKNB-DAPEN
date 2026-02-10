package id.go.ojk.bptk.client.builder.field.lbbptkjkm.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjkm;
import id.go.ojk.bptk.client.builder.field.lbbptkjkm.reference.EHeaderMetadataLbbptkjkm;
import id.go.ojk.bptk.client.builder.field.lbbptkjkm.reference.ER5507RAS;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbRas extends BaseMetadata {
  public LbRas(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjkm eEnum = EFormLbbptkjkm.RAS;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 25, 25);

    res.setRequiredPos(ER5507RAS.genRequiredPos());
    res.setUniquePos(ER5507RAS.genUniquePos());
    res.setSavePos(ER5507RAS.genFieldSave());

    res.addSegmentValidations(ER5507RAS.genRegexValidation01());
    res.addSegmentValidations(ER5507RAS.genRegexValidation02());
    res.addSegmentValidations(ER5507RAS.genMaxLengthValidation());
    res.addSegmentValidations(ER5507RAS.genMaxLengthValidation2());

    res.addSegmentValidations(ER5507RAS.genRowValidation04());
    res.addSegmentValidations(ER5507RAS.genRowValidation08());
    res.addSegmentValidations(ER5507RAS.genRowValidation11());
    res.addSegmentValidations(ER5507RAS.genRowValidation14());
    res.addSegmentValidations(ER5507RAS.genRowValidation17());
    res.addSegmentValidations(ER5507RAS.genRowValidation20());
    res.addSegmentValidations(ER5507RAS.genRowValidation23());
    res.addSegmentValidations(ER5507RAS.genRowValidation26());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5507RAS.genRowValidation02());
    res.addSegmentValidations(ER5507RAS.genRowValidation03());
    res.addSegmentValidations(ER5507RAS.genRowValidation05());
    res.addSegmentValidations(ER5507RAS.genRowValidation06());
    res.addSegmentValidations(ER5507RAS.genRowValidation07());
    res.addSegmentValidations(ER5507RAS.genRowValidation09());
    res.addSegmentValidations(ER5507RAS.genRowValidation10());
    res.addSegmentValidations(ER5507RAS.genRowValidation18());
    res.addSegmentValidations(ER5507RAS.genRowValidation19());
    res.addSegmentValidations(ER5507RAS.genRowValidation24());
    res.addSegmentValidations(ER5507RAS.genRowValidation25());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkjkm.R5507RAS.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Rasio", sv(M, 1, Integer.MAX_VALUE, all2)));
    return res;
  }
}
