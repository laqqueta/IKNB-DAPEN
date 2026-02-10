package id.go.ojk.bpks.client.builder.field.lbbpksdjs.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpksdjs;
import id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference.EHeaderMetadataLbbpksdjs;
import id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference.ER5103LPAN;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbLpan extends BaseMetadata {
  public LbLpan(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpksdjs eEnum = EFormLbbpksdjs.LPAN;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 7, 7);

    res.setRequiredPos(ER5103LPAN.genRequiredPos());
    res.setUniquePos(ER5103LPAN.genUniquePos());
    res.setSavePos(ER5103LPAN.genFieldSave());
    res.setSavePosForm(ER5103LPAN.genFieldSave());

    res.addSegmentValidations(ER5103LPAN.genRowValidation04a());
    res.addSegmentValidations(ER5103LPAN.genRowValidation04b());
    res.addSegmentValidations(ER5103LPAN.genRowValidation07a());
    res.addSegmentValidations(ER5103LPAN.genRowValidation07b());
    res.addSegmentValidations(ER5103LPAN.genRowValidation08a());
    res.addSegmentValidations(ER5103LPAN.genRowValidation08b());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5103LPAN.genRowValidation04c());
    res.addSegmentValidations(ER5103LPAN.genRowValidation04d());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 14, 14, refTable)
        .confReference(EHeaderMetadataLbbpksdjs.R5103LPAN.getObject()).confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Realisasi sampai dengan Bulan Pelaporan", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(3, null, "Realisasi sampai dengan Bulan Pelaporan -1 ", sv(M, 1, 20, numericNegatif)));
    return res;
  }
}
