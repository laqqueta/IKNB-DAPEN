package id.go.ojk.bptk.client.builder.field.lpbptkjht.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all2;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.IForm;
import id.go.ojk.bptk.client.builder.field.lpbptkjht.reference.EHeaderMetadataLpbptkjht;
import id.go.ojk.bptk.client.builder.field.lpbptkjht.reference.ER6105RKPIU;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LpRkpiuJht extends BaseMetadata {

  private final IForm form;

  public LpRkpiuJht(IForm form) {
    super(form.getReportCode(), ".txt");
    this.form = form;
  }

  @Override
  public SubmissionFormat get() {
    SubmissionFormat res = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(),
        extension, 52, 52); // semua baris detail

    res.setRequiredPos(ER6105RKPIU.genRequiredPos());
    res.setUniquePos(ER6105RKPIU.genUniquePos());
    res.setSavePos(ER6105RKPIU.genFieldSave());

    res.addSegmentValidations(ER6105RKPIU.genRegexValidationNumeric());
    res.addSegmentValidations(ER6105RKPIU.genRegexValidationNumericNegative());

    res.addSegmentValidations(ER6105RKPIU.genValidationTotalKelompokUsaha());
    res.addSegmentValidations(ER6105RKPIU.genValidationTotalJenisKelamin());
    res.addSegmentValidations(ER6105RKPIU.genValidationTotalKelompokUmur());
    res.addSegmentValidations(ER6105RKPIU.genValidationTotalKewarganegaraan());
    res.addSegmentValidations(ER6105RKPIU.genValidationTotalKelompokUpah());
    res.addSegmentValidations(ER6105RKPIU.genValidationTotalIuran());
    res.addSegmentValidations(ER6105RKPIU.genValidationTotalRekapDataJHT());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER6105RKPIU.genValidationFormRekapKepesertaanA());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormRekapKepesertaanB());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormRekapKepesertaanC());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormRekapKepesertaanD());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormKelompokUsahaA());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormKelompokUsahaB());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormKelompokUsahaC());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormKelompokUsahaD());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormKelompokUsahaE());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormKelompokUsahaF());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormKelompokUsahaG());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormKelompokUsahaH());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormKelompokUsahaI());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormTotalKelompokUsahaA());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormTotalKelompokUsahaB());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormTotalJenisKelamin());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormTotalKelompokUmur());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormTotalKewarganegaraan());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormTotalKelompokUpah());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormTotalIuran());
    res.addSegmentValidations(ER6105RKPIU.genValidationFormTotalRekapDataJHT());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 15, 20, refTable /*Huruf Angka*/)
        .confRegex(patternAlfaNumeric)
        .confReference(EHeaderMetadataLpbptkjht.R6105RKPIU.getObject())));
    fs.add(sf(2, null, "Pemberi Kerja Penerima Upah", sv(M, 1, 20, all2)));
    fs.add(sf(3, null, "Peserta Penerima Upah", sv(M, 1, 20, all2)));
    fs.add(sf(4, null, "Wadah / Mitra Usaha Bukan Penerima Upah", sv(M, 1, 20, all2)));
    fs.add(sf(5, null, "Peserta Bukan Penerima Upah", sv(M, 1, 20, all2)));
    fs.add(sf(6, null, "Total Pemberi Kerja / Wadah / Proyek", sv(M, 1, 20, all2))
        .addFieldValidations(ER6105RKPIU.genValidationTotalPemberiKerja()));
    fs.add(sf(7, null, "Total Peserta", sv(M, 1, 20, all2))
        .addFieldValidations(ER6105RKPIU.genValidationTotalPeserta()));
    return res;
  }
}
