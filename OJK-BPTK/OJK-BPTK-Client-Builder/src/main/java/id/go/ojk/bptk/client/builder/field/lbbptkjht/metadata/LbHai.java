package id.go.ojk.bptk.client.builder.field.lbbptkjht.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjht;
import id.go.ojk.bptk.client.builder.field.lbbptkjht.reference.EHeaderMetadataLbbptkjht;
import id.go.ojk.bptk.client.builder.field.lbbptkjht.reference.ER5604HAI;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbHai extends BaseMetadata {
  public LbHai(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjht eEnum = EFormLbbptkjht.HAI;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 14, 14);

    res.setRequiredPos(ER5604HAI.genRequiredPos());
    res.setUniquePos(ER5604HAI.genUniquePos());
    res.setSavePos(ER5604HAI.genFieldSave());
    res.setSavePosForm(ER5604HAI.genFieldSave());

    res.addSegmentValidations(ER5604HAI.genRowValidation15());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkjht.R5604HAI.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Hasil Investasi Neto", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(3, null, "Saldo Awal Investasi", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(4, null, "Saldo Akhir Investasi", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(5, null, "Rata-Rata Investasi", sv(M, 1, 23, numericDotNegatif))
        .addFieldValidations(ER5604HAI.genFieldValidation06()));
    fs.add(sf(6, null, "Rasio Hasil Investasi", sv(M, 1, 6, numericDotNegatif))
        .addFieldValidations(ER5604HAI.genFieldValidation07()));
    return res;
  }
}
