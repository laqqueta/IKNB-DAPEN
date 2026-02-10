package id.go.ojk.bptk.client.builder.field.lpbptkjht.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.IForm;
import id.go.ojk.bptk.client.builder.field.lpbptkjht.reference.EHeaderMetadataLpbptkjht;
import id.go.ojk.bptk.client.builder.field.lpbptkjht.reference.ER6106RKPMF;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LpRkpmfJht extends BaseMetadata {

  private final IForm form;

  public LpRkpmfJht(IForm form) {
    super(form.getReportCode(), ".txt");
    this.form = form;
  }

  @Override
  public SubmissionFormat get() {
    SubmissionFormat res = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(),
        extension, 17, 17);
    
    res.setRequiredPos(ER6106RKPMF.genRequiredPos());
    res.setUniquePos(ER6106RKPMF.genUniquePos());
    res.setSavePos(ER6106RKPMF.genFieldSave());

    res.addSegmentValidations(ER6106RKPMF.genValidationTotalJenisKlaim());

    /* -- ANTAR FORM -- */
    res.addSegmentValidations(ER6106RKPMF.genValidatonFormTotalJenisManfaat());
    res.addSegmentValidations(ER6106RKPMF.genValidatonFormJumlahDiajukan());
    res.addSegmentValidations(ER6106RKPMF.genValidatonFormNilaiDiajukan());
    res.addSegmentValidations(ER6106RKPMF.genValidatonFormJumlahDitetapkan());
    res.addSegmentValidations(ER6106RKPMF.genValidatonFormNilaiDitetapkan());
    res.addSegmentValidations(ER6106RKPMF.genValidatonFormJumlahDitolak());
    res.addSegmentValidations(ER6106RKPMF.genValidatonFormNilaiDitolak());
    res.addSegmentValidations(ER6106RKPMF.genValidatonFormJumlahDibayarkan());
    res.addSegmentValidations(ER6106RKPMF.genValidatonFormNilaiDibayarkan());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen", sv(M, 15, 20, refTable /*Huruf Angka*/)
        .confRegex(patternAlfaNumeric)
        .confReference(EHeaderMetadataLpbptkjht.R6106RKPMF.getObject())));
    fs.add(sf(2, null, "Pemberi Kerja Penerima Upah", sv(M, 1, 20, numeric)));
    fs.add(sf(3, null, "Peserta Penerima Upah", sv(M, 1, 20, numeric)));
    fs.add(sf(4, null, "Wadah / Mitra Usaha Bukan Penerima Upah", sv(M, 1, 20, numeric)));
    fs.add(sf(5, null, "Peserta Bukan Penerima Upah", sv(M, 1, 20, numeric)));
    fs.add(sf(6, null, "Proyek Jasa Konstruksi", sv(M, 1, 20, numeric)));
    fs.add(sf(7, null, "Peserta Jasa Konstruksi", sv(M, 1, 20, numeric)));
    fs.add(sf(8, null, "Total Pemberi Kerja / Wadah / Proyek", sv(M, 1, 20, numeric))
        .addFieldValidations(ER6106RKPMF.genValidationTotalJenisKlaimPemberiKerja()));
    fs.add(sf(9, null, "Total Peserta", sv(M, 1, 20, numeric))
        .addFieldValidations(ER6106RKPMF.genValidationTotalJenisKlaimPeserta()));
    return res;
  }
}
