package id.go.ojk.bpks.client.builder.field.lbbpkslk.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.EHeaderMetadataLbbpkslk;
import id.go.ojk.bpks.client.builder.field.lbbpkslk.reference.ER5005HIN;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbHin extends BaseMetadata {
  public LbHin(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslk eEnum = EFormLbbpkslk.HIN;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 35, 35);

    res.setRequiredPos(ER5005HIN.genRequiredPos());
    res.setUniquePos(ER5005HIN.genUniquePos());
    res.setSavePos(ER5005HIN.genFieldSave());
    res.setSavePosForm(ER5005HIN.genFieldSaveForm());

    res.addSegmentValidations(ER5005HIN.genRowValidation05());
    res.addSegmentValidations(ER5005HIN.genRowValidation17());
    res.addSegmentValidations(ER5005HIN.genRowValidation28());
    res.addSegmentValidations(ER5005HIN.genRowValidation31());
    res.addSegmentValidations(ER5005HIN.genRowValidation35());
    res.addSegmentValidations(ER5005HIN.genRowValidation36());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 13, 13, refTable)
        .confReference(EHeaderMetadataLbbpkslk.R5005HIN.getObject()).confRegex(patternAlfaNumeric)).confUnique(U));
    fs.add(sf(2, null, "Hasil Investasi Neto", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(3, null, "Saldo Awal Investasi", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(4, null, "Saldo Akhir Investasi", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(5, null, "Rata-Rata Investasi", sv(M, 1, 23, numericDotNegatif))
        .addFieldValidations(ER5005HIN.genFieldValidation6()));
    fs.add(sf(6, null, "Rasio Hasil Investasi", sv(M, 1, 8, numericDotNegatif))
        .addFieldValidations(ER5005HIN.genFieldValidation7()));
    return res;
  }
}
