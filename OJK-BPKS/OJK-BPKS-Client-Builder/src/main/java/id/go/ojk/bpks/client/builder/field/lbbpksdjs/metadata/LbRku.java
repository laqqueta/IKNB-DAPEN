package id.go.ojk.bpks.client.builder.field.lbbpksdjs.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpksdjs;
import id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference.EHeaderMetadataLbbpksdjs;
import id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference.ER5106RKU;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbRku extends BaseMetadata {
  public LbRku(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpksdjs eEnum = EFormLbbpksdjs.RKU;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 28, 28);

    res.setRequiredPos(ER5106RKU.genRequiredPos());
    res.setUniquePos(ER5106RKU.genUniquePos());
    res.setSavePos(ER5106RKU.genFieldSave());

    res.addSegmentValidations(ER5106RKU.genValidationTypeNumericNegative());
    res.addSegmentValidations(ER5106RKU.genValidationTypeNumericDotNegative());
    res.addSegmentValidations(ER5106RKU.genValidationLength06());
    res.addSegmentValidations(ER5106RKU.genValidationLength20());

    res.addSegmentValidations(ER5106RKU.genRowValidation04());
    res.addSegmentValidations(ER5106RKU.genRowValidation08());
    res.addSegmentValidations(ER5106RKU.genRowValidation11());
    res.addSegmentValidations(ER5106RKU.genRowValidation14());
    res.addSegmentValidations(ER5106RKU.genRowValidation17());
    res.addSegmentValidations(ER5106RKU.genRowValidation20());
    res.addSegmentValidations(ER5106RKU.genRowValidation23());
    res.addSegmentValidations(ER5106RKU.genRowValidation26());
    res.addSegmentValidations(ER5106RKU.genRowValidation27());
    res.addSegmentValidations(ER5106RKU.genRowValidation29());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5106RKU.genRowValidation02());
//    res.addSegmentValidations(ER5106RKU.genRowValidation03()); // UAT #26
    res.addSegmentValidations(ER5106RKU.genRowValidation05());
    res.addSegmentValidations(ER5106RKU.genRowValidation06());
    res.addSegmentValidations(ER5106RKU.genRowValidation07());
    res.addSegmentValidations(ER5106RKU.genRowValidation09());
    res.addSegmentValidations(ER5106RKU.genRowValidation10());
    res.addSegmentValidations(ER5106RKU.genRowValidation12());
    res.addSegmentValidations(ER5106RKU.genRowValidation13());
    res.addSegmentValidations(ER5106RKU.genRowValidation18());
    res.addSegmentValidations(ER5106RKU.genRowValidation19());
    res.addSegmentValidations(ER5106RKU.genRowValidation22());
    res.addSegmentValidations(ER5106RKU.genRowValidation24());
    res.addSegmentValidations(ER5106RKU.genRowValidation25());

    //UAT 
    res.addSegmentValidations(ER5106RKU.genRowValidation02b());
    res.addSegmentValidations(ER5106RKU.genRowValidation05b());
    res.addSegmentValidations(ER5106RKU.genRowValidation09b());
    res.addSegmentValidations(ER5106RKU.genRowValidation10b());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpksdjs.R5106RKU.getObject()).confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, Integer.MAX_VALUE, all2)));
    return res;
  }
}
