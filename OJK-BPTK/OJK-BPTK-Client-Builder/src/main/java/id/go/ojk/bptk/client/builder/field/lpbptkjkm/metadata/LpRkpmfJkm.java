package id.go.ojk.bptk.client.builder.field.lpbptkjkm.metadata;

import java.util.ArrayList;

import id.go.ojk.bptk.client.builder.field.IForm;
import id.go.ojk.bptk.client.builder.field.lpbptkjkm.reference.EHeaderMetadataLpbptkjkm;
import id.go.ojk.bptk.client.builder.field.lpbptkjkm.reference.ER6005RKPMF;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

import static id.go.ojk.client.model.config.SimpleValidation.*;
import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;
import java.util.List;
import id.go.ojk.client.model.config.SubmissionField;

public class LpRkpmfJkm extends BaseMetadata {

  private final IForm form;

  public LpRkpmfJkm(IForm form) {
    super(form.getReportCode(), ".txt");
    this.form = form;
  }

  @Override
  public SubmissionFormat get() {
    SubmissionFormat res = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(),
        extension, 11, 11);
    
    res.setRequiredPos(ER6005RKPMF.genRequiredPos());
    res.setUniquePos(ER6005RKPMF.genUniquePos());
    res.setSavePos(ER6005RKPMF.genFieldSave());

    res.addSegmentValidations(ER6005RKPMF.genValidationTotalJenisKlaim());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen", sv(M, 15, 20, refTable /*Huruf Angka*/)
        .confRegex(patternAlfaNumeric)
        .confReference(EHeaderMetadataLpbptkjkm.R6005RKPMF.getObject())));
    fs.add(sf(2, null, "Pemberi Kerja Penerima Upah", sv(M, 1, 20, numeric)));
    fs.add(sf(3, null, "Peserta Penerima Upah", sv(M, 1, 20, numeric)));
    fs.add(sf(4, null, "Wadah / Mitra Usaha Bukan Penerima Upah", sv(M, 1, 20, numeric)));
    fs.add(sf(5, null, "Peserta Bukan Penerima Upah", sv(M, 1, 20, numeric)));
    fs.add(sf(6, null, "Proyek Jasa Konstruksi", sv(M, 1, 20, numeric)));
    fs.add(sf(7, null, "Peserta Jasa Konstruksi", sv(M, 1, 20, numeric)));
    fs.add(sf(8, null, "Total Pemberi Kerja / Wadah / Proyek", sv(M, 1, 20, numeric))
        .addFieldValidations(ER6005RKPMF.genValidationTotalJenisKlaimPemberiKerja()));
    fs.add(sf(9, null, "Total Peserta", sv(M, 1, 20, numeric))
        .addFieldValidations(ER6005RKPMF.genValidationTotalJenisKlaimPeserta()));
    return res;
  }
}
