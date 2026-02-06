package id.go.ojk.bptk.client.builder.field.lpbptkjp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.IForm;
import id.go.ojk.bptk.client.builder.field.lpbptkjp.reference.EHeaderMetadataLpbptkjp;
import id.go.ojk.bptk.client.builder.field.lpbptkjp.reference.ER6305RKPIU;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LpRkpiuJp extends BaseMetadata {

  private final IForm form;

  public LpRkpiuJp(IForm form) {
    super(form.getReportCode(), ".txt");
    this.form = form;
  }

  @Override
  public SubmissionFormat get() {
    SubmissionFormat res = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(),
        extension, 52, 52); // semua baris detail

    res.setRequiredPos(ER6305RKPIU.genRequiredPos());
    res.setUniquePos(ER6305RKPIU.genUniquePos());
    res.setSavePos(ER6305RKPIU.genFieldSave());

    res.addSegmentValidations(ER6305RKPIU.genValidationTotalKelompokUsaha());
    res.addSegmentValidations(ER6305RKPIU.genValidationTotalJenisKelamin());
    res.addSegmentValidations(ER6305RKPIU.genValidationTotalKelompokUmur());
    res.addSegmentValidations(ER6305RKPIU.genValidationTotalKewarganegaraan());
    res.addSegmentValidations(ER6305RKPIU.genValidationTotalKelompokUpah());
    res.addSegmentValidations(ER6305RKPIU.genValidationTotalIuran());
    res.addSegmentValidations(ER6305RKPIU.genValidationTotalRekapDanaJp());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER6305RKPIU.genValidatonFormTotalKelompokUsahaA());
    res.addSegmentValidations(ER6305RKPIU.genValidatonFormTotalKelompokUsahaB());
    res.addSegmentValidations(ER6305RKPIU.genValidatonFormTotalJenisKelamin());
    res.addSegmentValidations(ER6305RKPIU.genValidatonFormTotalKelompokUmur());
    res.addSegmentValidations(ER6305RKPIU.genValidatonFormTotalKewarganegaraan());
    res.addSegmentValidations(ER6305RKPIU.genValidatonFormTotalKelompokUpah());
    res.addSegmentValidations(ER6305RKPIU.genValidatonFormTotalIuran());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 15, 20, refTable /*Huruf Angka*/)
        .confRegex(patternAlfaNumeric)
        .confReference(EHeaderMetadataLpbptkjp.R6305RKPIU.getObject())));
    fs.add(sf(2, null, "Pemberi Kerja Penerima Upah", sv(M, 1, 20, numeric)));
    fs.add(sf(3, null, "Peserta Penerima Upah", sv(M, 1, 20, numeric)));
    return res;
  }
}
