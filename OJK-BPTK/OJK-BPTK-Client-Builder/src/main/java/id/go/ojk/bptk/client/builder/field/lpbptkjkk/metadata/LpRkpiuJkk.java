package id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.IForm;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.reference.EHeaderMetadataLpbptkjkk;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.reference.ER5904RKPIU;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LpRkpiuJkk extends BaseMetadata {

  private final IForm form;

  public LpRkpiuJkk(IForm form) {
    super(form.getReportCode(), ".txt");
    this.form = form;
  }

  @Override
  public SubmissionFormat get() {
    SubmissionFormat res = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(),
        extension, 46, 46); // semua baris detail

    res.setRequiredPos(ER5904RKPIU.genRequiredPos());
    res.setUniquePos(ER5904RKPIU.genUniquePos());
    res.setSavePos(ER5904RKPIU.genFieldSave());

    res.addSegmentValidations(ER5904RKPIU.genLengthValidation20());
    res.addSegmentValidations(ER5904RKPIU.genLengthValidation23());
    res.addSegmentValidations(ER5904RKPIU.genRegexValidationNumeric());
    res.addSegmentValidations(ER5904RKPIU.genRegexValidationNumericDotNegative());

    res.addSegmentValidations(ER5904RKPIU.genValidationTotalKelompokUsaha());
    res.addSegmentValidations(ER5904RKPIU.genValidationTotalJenisKelamin());
    res.addSegmentValidations(ER5904RKPIU.genValidationTotalKelompokUmur());
    res.addSegmentValidations(ER5904RKPIU.genValidationTotalKewarganegaraan());
    res.addSegmentValidations(ER5904RKPIU.genValidationTotalKelompokUpah());
    res.addSegmentValidations(ER5904RKPIU.genValidationTotalIuran());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5904RKPIU.genValidatonFormTotalKelompokUsahaA());
    res.addSegmentValidations(ER5904RKPIU.genValidatonFormTotalKelompokUsahaB());
    res.addSegmentValidations(ER5904RKPIU.genValidatonFormTotalJenisKelamin());
    res.addSegmentValidations(ER5904RKPIU.genValidatonFormTotalKelompokUmur());
    res.addSegmentValidations(ER5904RKPIU.genValidatonFormTotalKewarganegaraan());
    res.addSegmentValidations(ER5904RKPIU.genValidatonFormTotalKelompokUpah());
    res.addSegmentValidations(ER5904RKPIU.genValidatonFormTotalIuran());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 15, 20, refTable /*Huruf Angka*/)
        .confRegex(patternAlfaNumeric)
        .confReference(EHeaderMetadataLpbptkjkk.R5904RKPIU.getObject())));
    fs.add(sf(2, null, "Pemberi Kerja Penerima Upah", sv(M, 1, Integer.MAX_VALUE, all2)));
    fs.add(sf(3, null, "Peserta Penerima Upah", sv(M, 1, Integer.MAX_VALUE, all2)));
    fs.add(sf(4, null, "Wadah / Mitra Usaha Bukan Penerima Upah", sv(M, 1, Integer.MAX_VALUE, all2)));
    fs.add(sf(5, null, "Peserta Bukan Penerima Upah", sv(M, 1, Integer.MAX_VALUE, all2)));
    fs.add(sf(6, null, "Proyek Jasa Konstruksi", sv(M, 1, Integer.MAX_VALUE, all2)));
    fs.add(sf(7, null, "Peserta Jasa Konstruksi", sv(M, 1, Integer.MAX_VALUE, all2)));
    fs.add(sf(8, null, "Total Pemberi Kerja / Wadah / Proyek", sv(M, 1, Integer.MAX_VALUE, all2))
        .addFieldValidations(ER5904RKPIU.genValidationTotalPemberiKerja()));
    fs.add(sf(9, null, "Total Peserta", sv(M, 1, Integer.MAX_VALUE, all2))
        .addFieldValidations(ER5904RKPIU.genValidationTotalPeserta()));
    return res;
  }
}
