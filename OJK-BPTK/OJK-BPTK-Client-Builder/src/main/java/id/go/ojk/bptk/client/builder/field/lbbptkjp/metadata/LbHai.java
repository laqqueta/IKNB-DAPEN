package id.go.ojk.bptk.client.builder.field.lbbptkjp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkjp;
import id.go.ojk.bptk.client.builder.field.lbbptkjp.reference.EHeaderMetadataLbbptkjp;
import id.go.ojk.bptk.client.builder.field.lbbptkjp.reference.ER5804HAI;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbHai extends BaseMetadata {
  public LbHai(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkjp eEnum = EFormLbbptkjp.HAI;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 14, 14);

    res.setRequiredPos(ER5804HAI.genRequiredPos());
    res.setUniquePos(ER5804HAI.genUniquePos());
    res.setSavePos(ER5804HAI.genFieldSave());
    res.setSavePosForm(ER5804HAI.genFieldSave());

    res.addSegmentValidations(ER5804HAI.genRowValidation15());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkjp.R5804HAI.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Hasil Investasi Neto", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(3, null, "Saldo Awal Investasi", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(4, null, "Saldo Akhir Investasi", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(5, null, "Rata-Rata Investasi", sv(M, 1, 23, numericDotNegatif))
        .addFieldValidations(ER5804HAI.genFieldValidation06()));
    fs.add(sf(6, null, "Rasio Hasil Investasi", sv(M, 1, 6, numericDotNegatif))
        .addFieldValidations(ER5804HAI.genFieldValidation07()));
    return res;
  }
}
