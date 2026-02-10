package id.go.ojk.bpks.client.builder.field.lbbpkslpp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.EHeaderMetadataLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.ER5200PRUM;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbPrum extends BaseMetadata {
  public LbPrum(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslpp eEnum = EFormLbbpkslpp.PRUM;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 29, 29);

    res.setRequiredPos(ER5200PRUM.genRequiredPos());
    res.setUniquePos(ER5200PRUM.genUniquePos());
    res.setSavePos(ER5200PRUM.genFieldSave());

    res.addSegmentValidations(ER5200PRUM.genValidationTypeNumeric());
    res.addSegmentValidations(ER5200PRUM.genValidationTypeReference());
    res.addSegmentValidations(ER5200PRUM.genValidationTypeAll());

    res.addSegmentValidations(ER5200PRUM.genLengthValidation05());
    res.addSegmentValidations(ER5200PRUM.genLengthValidation06());
    res.addSegmentValidations(ER5200PRUM.genLengthValidation10());
    res.addSegmentValidations(ER5200PRUM.genLengthValidation15());
    res.addSegmentValidations(ER5200PRUM.genLengthValidation15to16());
    res.addSegmentValidations(ER5200PRUM.genLengthValidation50());
    res.addSegmentValidations(ER5200PRUM.genLengthValidation100());
    res.addSegmentValidations(ER5200PRUM.genLengthValidation200());

    res.addSegmentValidations(ER5200PRUM.genReferenceValidationA());
    res.addSegmentValidations(ER5200PRUM.genReferenceValidationB());

    res.addSegmentValidations(ER5200PRUM.genRowValidation13());
    res.addSegmentValidations(ER5200PRUM.genRowValidation17a());
    res.addSegmentValidations(ER5200PRUM.genRowValidation21());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5200PRUM.genRowValidation17b());
    res.addSegmentValidations(ER5200PRUM.genRowValidation19());
    res.addSegmentValidations(ER5200PRUM.genRowValidation20());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
        .confReference(EHeaderMetadataLbbpkslpp.R5200PRUM.getObject()).confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Keterangan", sv(M, 1, Integer.MAX_VALUE, all2)));
    return res;
  }
}
