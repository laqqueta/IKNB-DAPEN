package id.go.ojk.bptk.client.builder.field.lbbptkbdn.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.EHeaderMetadataLbbptkbdn;
import id.go.ojk.bptk.client.builder.field.lbbptkbdn.reference.ER5306HAI;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbHai extends BaseMetadata {
  public LbHai(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbptkbdn eEnum = EFormLbbptkbdn.HAI;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 36, 36);

    res.setRequiredPos(ER5306HAI.genRequiredPos());
    res.setUniquePos(ER5306HAI.genUniquePos());
    res.setSavePos(ER5306HAI.genFieldSave());

    res.addSegmentValidations(ER5306HAI.genRowValidation02());
    res.addSegmentValidations(ER5306HAI.genRowValidation06());
    res.addSegmentValidations(ER5306HAI.genRowValidation18());
    res.addSegmentValidations(ER5306HAI.genRowValidation29());
    res.addSegmentValidations(ER5306HAI.genRowValidation32());
    res.addSegmentValidations(ER5306HAI.genRowValidation37());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbptkbdn.R5306HAI.getObject())
        .confRegex(patternAlfaNumeric))
        .confUnique(U));
    fs.add(sf(2, null, "Hasil Investasi Neto", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(3, null, "Saldo Awal Investasi", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(4, null, "Saldo Akhir Investasi", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(5, null, "Rata-Rata Investasi", sv(M, 1, 23, numericDotNegatif))
        .addFieldValidations(ER5306HAI.genFieldValidation6()));
    fs.add(sf(6, null, "Rasio Hasil Investasi", sv(M, 1, 6, numericDotNegatif))
        .addFieldValidations(ER5306HAI.genFieldValidation07()));
    return res;
  }
}
