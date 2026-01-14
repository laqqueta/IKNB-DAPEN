package id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata;

import java.util.ArrayList;

import id.go.ojk.bptk.client.builder.field.IForm;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.reference.EHeaderMetadataLpbptkjkk;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.reference.ER5905RKPMF;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

import static id.go.ojk.client.model.config.SimpleValidation.*;
import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;
import java.util.List;
import id.go.ojk.client.model.config.SubmissionField;

public class LpRkpmfJkk extends BaseMetadata {

  private final IForm form;

  public LpRkpmfJkk(IForm form) {
    super(form.getReportCode(), ".txt");
    this.form = form;
  }

  @Override
  public SubmissionFormat get() {
    SubmissionFormat res = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(),
        extension, 16, 16);

    res.setRequiredPos(ER5905RKPMF.genRequiredPos());
    res.setUniquePos(ER5905RKPMF.genUniquePos());
    res.setSavePos(ER5905RKPMF.genFieldSave());

    res.addSegmentValidations(ER5905RKPMF.genValidationTotalJenisManfaat());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER5905RKPMF.genValidatonFormTotalJenisManfaat());
    res.addSegmentValidations(ER5905RKPMF.genValidatonFormJumlahDiajukan());
    res.addSegmentValidations(ER5905RKPMF.genValidatonFormNilaiDiajukan());
    res.addSegmentValidations(ER5905RKPMF.genValidatonFormJumlahDitetapkan());
    res.addSegmentValidations(ER5905RKPMF.genValidatonFormNilaiDitetapkan());
    res.addSegmentValidations(ER5905RKPMF.genValidatonFormJumlahDitolak());
    res.addSegmentValidations(ER5905RKPMF.genValidatonFormNilaiDitolak());
    res.addSegmentValidations(ER5905RKPMF.genValidatonFormJumlahDibayarkan());
    res.addSegmentValidations(ER5905RKPMF.genValidatonFormNilaiDibayarkan());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen", sv(M, 15, 20, refTable /*Huruf Angka*/)
        .confRegex(patternAlfaNumeric)
        .confReference(EHeaderMetadataLpbptkjkk.R5905RKPMF.getObject())));
    fs.add(sf(2, null, "Pemberi Kerja Penerima Upah", sv(M, 1, 20, numeric)));
    fs.add(sf(3, null, "Peserta Penerima Upah", sv(M, 1, 20, numeric)));
    fs.add(sf(4, null, "Wadah / Mitra Usaha Bukan Penerima Upah", sv(M, 1, 20, numeric)));
    fs.add(sf(5, null, "Peserta Bukan Penerima Upah", sv(M, 1, 20, numeric)));
    fs.add(sf(6, null, "Proyek Jasa Konstruksi", sv(M, 1, 20, numeric)));
    fs.add(sf(7, null, "Peserta Jasa Konstruksi", sv(M, 1, 20, numeric)));
    fs.add(sf(8, null, "Total Pemberi Kerja / Wadah / Proyek", sv(M, 1, 20, numeric))
        .addFieldValidations(ER5905RKPMF.genValidationTotalPemberiKerja()));
    fs.add(sf(9, null, "Total Peserta", sv(M, 1, 20, numeric))
        .addFieldValidations(ER5905RKPMF.genValidationTotalPeserta()));
    return res;
  }
}
