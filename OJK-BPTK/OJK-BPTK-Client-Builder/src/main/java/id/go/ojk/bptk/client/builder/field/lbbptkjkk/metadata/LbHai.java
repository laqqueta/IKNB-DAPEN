package id.go.ojk.bptk.client.builder.field.lbbptkjkk.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjkk;
import id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference.EHeaderMetadataLbbptkjkk;
import id.go.ojk.bptk.client.builder.field.lbbptkjkk.reference.ER5406HAI;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbHai extends BaseMetadata {
  public LbHai(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjkk eEnum = EFormLbbptkjkk.HAI;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 11, 11);

    res.setRequiredPos(ER5406HAI.genRequiredPos());
    res.setUniquePos(ER5406HAI.genUniquePos());
    res.setSavePos(ER5406HAI.genFieldSave());
    res.setSavePosForm(ER5406HAI.genFieldSave());

    res.addSegmentValidations(ER5406HAI.genRowValidation12a());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkjkk.R5406HAI.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Hasil Investasi Neto", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(3, null, "Saldo Awal Investasi", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(4, null, "Saldo Akhir Investasi", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(5, null, "Rata-Rata Investasi", sv(M, 1, 23, numericDotNegatif))
        .addFieldValidations(ER5406HAI.genFieldValidation06()));
    fs.add(sf(6, null, "Rasio Hasil Investasi", sv(M, 1, 6, numericDotNegatif))
        .addFieldValidations(ER5406HAI.genFieldValidation07()));
    return res;
  }
}
