package id.go.ojk.bptk.client.builder.field.lpbptkjht.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_4;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.IForm;
import id.go.ojk.bptk.client.builder.field.lpbptkjht.reference.EHeaderMetadataLpbptkjht;
import id.go.ojk.bptk.client.builder.field.lpbptkjht.reference.ER6103RDJHT;
import id.go.ojk.bptk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LpRdjht extends BaseMetadata {
  private final IForm form;

  public LpRdjht(IForm form) {
    super(form.getReportCode(), ".txt");
    this.form = form;
  }

  @Override
  public SubmissionFormat get() {
    SubmissionFormat res = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(),
        extension, 1, null);

    res.setRequiredPos(ER6103RDJHT.genRequiredPos());
    res.setUniquePos(ER6103RDJHT.genUniquePos());
    res.setSavePos(ER6103RDJHT.genFieldSave());

    res.addSegmentValidations(ER6103RDJHT.genValidationTotal());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen", sv(M, 15, 20, refTable /*Huruf Angka*/).confRegex(patternAlfaNumeric)
        .confReference(EHeaderMetadataLpbptkjht.R6103RDJHT.getObject())));
    fs.add(sf(2, null, "Kode Kantor Wilayah", sv(C, 1, 100, all)
        .confConditionalRequired(ER6103RDJHT.genConditionalExistA())));
    fs.add(sf(3, null, "Kantor Wilayah", sv(C, 1, 100, all)
        .confConditionalRequired(ER6103RDJHT.genConditionalExistA())));
    fs.add(sf(4, null, "Kode Kantor Cabang", sv(C, 1, 100, all)
        .confConditionalRequired(ER6103RDJHT.genConditionalExistA())));
    fs.add(sf(5, null, "Kantor Cabang", sv(C, 1, 100, all)
        .confConditionalRequired(ER6103RDJHT.genConditionalExistA())));
    fs.add(sf(6, null, "Lokasi DATI II", sv(C, 1, 8, refTable /*Huruf Angka :*/)
        .confRegex(PATTERN_REFERENCE_1)
        .confReference(EHeaderMetadataShared.LOKASI_DATI_2.getObject())
        .confConditionalRequired(ER6103RDJHT.genConditionalExistA())));
    fs.add(sf(7, null, "Lokasi DATI I", sv(C, 1, 8, refTable /*Huruf Angka :*/)
        .confRegex(PATTERN_REFERENCE_1)
        .confReference(EHeaderMetadataShared.LOKASI_DATI_1.getObject())
        .confConditionalRequired(ER6103RDJHT.genConditionalExistA())));
    fs.add(sf(8, null, "Segmen Peserta", sv(C, 1, 10, refTable /*Huruf Angka .*/)
        .confRegex(PATTERN_REFERENCE_4)
        .confReference(EHeaderMetadataShared.SEGMEN_PESERTA_LPP.getObject())
        .confConditionalRequired(ER6103RDJHT.genConditionalExistA())));
    fs.add(sf(9, null, "Saldo Awal", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(10, null, "Iuran Tahun Berjalan", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(11, null, "Hasil Pengembangan", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(12, null, "Amalgamasi / Penyesuaian", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(13, null, "Klaim", sv(M, 1, 20, numericNegatif)));
    fs.add(sf(14, null, "Saldo Akhir", sv(M, 1, 20, numericNegatif))
        .addFieldValidations(ER6103RDJHT.genValidationSaldoAkhir()));
    return res;
  }

}
