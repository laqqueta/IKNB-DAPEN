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
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.ER5301LPK;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLpk extends BaseMetadata {
  public LbLpk(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkbdn eEnum = EFormLbbptkbdn.LPK;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 82, 82);

    res.setRequiredPos(ER5301LPK.genRequiredPos());
    res.setUniquePos(ER5301LPK.genUniquePos());
    res.setSavePos(ER5301LPK.genFieldSave());
    res.setSavePosForm(ER5301LPK.genFieldSave());

    res.addSegmentValidations(ER5301LPK.genRowValidation03());
    res.addSegmentValidations(ER5301LPK.genRowValidation14a());
    res.addSegmentValidations(ER5301LPK.genRowValidation28());
    res.addSegmentValidations(ER5301LPK.genRowValidation29());
    res.addSegmentValidations(ER5301LPK.genRowValidation44());
    res.addSegmentValidations(ER5301LPK.genRowValidation45());
    res.addSegmentValidations(ER5301LPK.genRowValidation49());
    res.addSegmentValidations(ER5301LPK.genRowValidation61());
    res.addSegmentValidations(ER5301LPK.genRowValidation66());
    res.addSegmentValidations(ER5301LPK.genRowValidation67());
    res.addSegmentValidations(ER5301LPK.genRowValidation68());
    res.addSegmentValidations(ER5301LPK.genRowValidation73());
    res.addSegmentValidations(ER5301LPK.genRowValidation80());
    res.addSegmentValidations(ER5301LPK.genRowValidation82());
    res.addSegmentValidations(ER5301LPK.genRowValidation83());
    
    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5301LPK.genRowValidation14b());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkbdn.R5301LPK.getObject()).confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Jumlah", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
