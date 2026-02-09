package id.go.ojk.bptk.client.builder.field.lbbptkjkp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjkp;
import id.go.ojk.bptk.client.builder.field.lbbptkjkp.reference.EHeaderMetadataLbbptkjkp;
import id.go.ojk.bptk.client.builder.field.lbbptkjkp.reference.ER5707RAS;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbRas extends BaseMetadata {
  public LbRas(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjkp eEnum = EFormLbbptkjkp.RAS;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 25, 25);

    res.setRequiredPos(ER5707RAS.genRequiredPos());
    res.setUniquePos(ER5707RAS.genUniquePos());
    res.setSavePos(ER5707RAS.genFieldSave());

    res.addSegmentValidations(ER5707RAS.genRegexValidation01());
    res.addSegmentValidations(ER5707RAS.genRegexValidation02());
    res.addSegmentValidations(ER5707RAS.genMaxLengthValidation());
    res.addSegmentValidations(ER5707RAS.genMaxLengthValidation2());

    res.addSegmentValidations(ER5707RAS.genRowValidation04());
    res.addSegmentValidations(ER5707RAS.genRowValidation08());
    res.addSegmentValidations(ER5707RAS.genRowValidation11());
    res.addSegmentValidations(ER5707RAS.genRowValidation14());
    res.addSegmentValidations(ER5707RAS.genRowValidation17());
    res.addSegmentValidations(ER5707RAS.genRowValidation20());
    res.addSegmentValidations(ER5707RAS.genRowValidation23());
    res.addSegmentValidations(ER5707RAS.genRowValidation26());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5707RAS.genRowValidation02());
    res.addSegmentValidations(ER5707RAS.genRowValidation03());
    res.addSegmentValidations(ER5707RAS.genRowValidation05());
    res.addSegmentValidations(ER5707RAS.genRowValidation06());
    res.addSegmentValidations(ER5707RAS.genRowValidation07());
    res.addSegmentValidations(ER5707RAS.genRowValidation09());
    res.addSegmentValidations(ER5707RAS.genRowValidation10());
    res.addSegmentValidations(ER5707RAS.genRowValidation18());
    res.addSegmentValidations(ER5707RAS.genRowValidation19());
    res.addSegmentValidations(ER5707RAS.genRowValidation21());
    res.addSegmentValidations(ER5707RAS.genRowValidation24());
    res.addSegmentValidations(ER5707RAS.genRowValidation25());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkjkp.R5707RAS.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Nilai Rasio", sv(M, 1, Integer.MAX_VALUE, all2)));
    return res;
  }
}
