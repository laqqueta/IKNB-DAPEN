package id.go.ojk.bpks.client.builder.field.lbbpksdjs.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpksdjs;
import id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference.EHeaderMetadataLbbpksdjs;
import id.go.ojk.bpks.client.builder.field.lbbpksdjs.reference.ER5105HIN;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbHin extends BaseMetadata {
  public LbHin(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpksdjs eEnum = EFormLbbpksdjs.HIN;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 5, 5);

    res.setRequiredPos(ER5105HIN.genRequiredPos());
    res.setUniquePos(ER5105HIN.genUniquePos());
    res.setSavePos(ER5105HIN.genFieldSave());
    res.setSavePosForm(ER5105HIN.genFieldSaveForm());

    res.addSegmentValidations(ER5105HIN.genRowValidation06());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5105HIN.genRowValidation03());
    res.addSegmentValidations(ER5105HIN.genRowValidation04());
    res.addSegmentValidations(ER5105HIN.genRowValidation06b());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpksdjs.R5105HIN.getObject()).confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Hasil Investasi Neto", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(3, null, "Saldo Awal Investasi", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(4, null, "Saldo Akhir Investasi", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(5, null, "Rata-Rata Investasi", sv(M, 1, 23, numericDotNegatif))
        .addFieldValidations(ER5105HIN.genFieldValidation6()));
    fs.add(sf(6, null, "Rasio Hasil Investasi", sv(M, 1, 8, numericDotNegatif))
        .addFieldValidations(ER5105HIN.genFieldValidation7()));
    return res;
  }
}
