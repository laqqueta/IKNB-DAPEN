package id.go.ojk.bptk.client.builder.field.lbbptkjht.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjht;
import id.go.ojk.bptk.client.builder.field.lbbptkjht.reference.EHeaderMetadataLbbptkjht;
import id.go.ojk.bptk.client.builder.field.lbbptkjht.reference.ER5612ANT;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbAnt extends BaseMetadata {
  public LbAnt(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjht eEnum = EFormLbbptkjht.ANT;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 20, 20);

    res.setRequiredPos(ER5612ANT.genRequiredPos());
    res.setUniquePos(ER5612ANT.genUniquePos());
    res.setSavePos(ER5612ANT.genFieldSave());

    res.addSegmentValidations(ER5612ANT.genRegexValidation01());
    res.addSegmentValidations(ER5612ANT.genRegexValidation02());

    res.addSegmentValidations(ER5612ANT.genRowValidation04());
    res.addSegmentValidations(ER5612ANT.genRowValidation08());
    res.addSegmentValidations(ER5612ANT.genRowValidation10());
    res.addSegmentValidations(ER5612ANT.genRowValidation14());
    res.addSegmentValidations(ER5612ANT.genRowValidation17());
    res.addSegmentValidations(ER5612ANT.genRowValidation18());
    res.addSegmentValidations(ER5612ANT.genRowValidation19());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkjht.R5612ANT.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Periode Bulan Laporan", sv(M, 1, 20, all2)));
    fs.add(sf(3, null, "Desember tahun x-1", sv(M, 1, 20, all2)));
    return res;
  }
}
