package id.go.ojk.bpks.client.builder.field.lbbpkslk.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.EHeaderMetadataLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.ER5007RKE;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbRke extends BaseMetadata {
  public LbRke(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslk eEnum = EFormLbbpkslk.RKE;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 27, 27);

    res.setRequiredPos(ER5007RKE.genRequiredPos());
    res.setUniquePos(ER5007RKE.genUniquePos());
    res.setSavePos(ER5007RKE.genFieldSave());

    res.addSegmentValidations(ER5007RKE.genValidationTypeNumericNegative());
    res.addSegmentValidations(ER5007RKE.genValidationTypeNumericDotNegative());
    res.addSegmentValidations(ER5007RKE.genValidationLength20());

    res.addSegmentValidations(ER5007RKE.genRowValidation04());
    res.addSegmentValidations(ER5007RKE.genRowValidation05());
    res.addSegmentValidations(ER5007RKE.genRowValidation06());
    res.addSegmentValidations(ER5007RKE.genRowValidation08());
    res.addSegmentValidations(ER5007RKE.genRowValidation11());
    res.addSegmentValidations(ER5007RKE.genRowValidation14());
    res.addSegmentValidations(ER5007RKE.genRowValidation15());
    res.addSegmentValidations(ER5007RKE.genRowValidation17());
    res.addSegmentValidations(ER5007RKE.genRowValidation20());
    res.addSegmentValidations(ER5007RKE.genRowValidation21());
    res.addSegmentValidations(ER5007RKE.genRowValidation22());
    res.addSegmentValidations(ER5007RKE.genRowValidation23());
    res.addSegmentValidations(ER5007RKE.genRowValidation25());
    res.addSegmentValidations(ER5007RKE.genRowValidation27());
    res.addSegmentValidations(ER5007RKE.genRowValidation28());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5007RKE.genRowValidation02());
    res.addSegmentValidations(ER5007RKE.genRowValidation03());
    res.addSegmentValidations(ER5007RKE.genRowValidation07());
    res.addSegmentValidations(ER5007RKE.genRowValidation09());
    res.addSegmentValidations(ER5007RKE.genRowValidation10());
    res.addSegmentValidations(ER5007RKE.genRowValidation12());
    res.addSegmentValidations(ER5007RKE.genRowValidation13());
    res.addSegmentValidations(ER5007RKE.genRowValidation16());
    res.addSegmentValidations(ER5007RKE.genRowValidation18());
    res.addSegmentValidations(ER5007RKE.genRowValidation19());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpkslk.R5007RKE.getObject()).confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, Integer.MAX_VALUE, all2)));
    return res;
  }
}
