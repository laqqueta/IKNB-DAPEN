package id.go.ojk.bptk.client.builder.field.lpbptkjp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_4;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.IForm;
import id.go.ojk.bptk.client.builder.field.lpbptkjp.reference.EHeaderMetadataLpbptkjp;
import id.go.ojk.bptk.client.builder.field.lpbptkjp.reference.ER6301RKPST;
import id.go.ojk.bptk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LpRkpstJp extends BaseMetadata {
  private final IForm form;

  public LpRkpstJp(IForm form) {
    super(form.getReportCode(), ".txt");
    this.form = form;
  }

  @Override
  public SubmissionFormat get() {
    SubmissionFormat res = new SubmissionFormat(form.getCode(), form.getName(), reportCode, new ArrayList<>(),
        extension, 1, null);

    res.setRequiredPos(ER6301RKPST.genRequiredPos());
    res.setUniquePos(ER6301RKPST.genUniquePos());
    res.setSavePos(ER6301RKPST.genFieldSave());
    res.setSavePosForm(ER6301RKPST.genFieldSaveForm());

    res.addSegmentValidations(ER6301RKPST.genValidationTotal());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen", sv(M, 15, 20, refTable /*Huruf Angka*/).confRegex(patternAlfaNumeric)
        .confReference(EHeaderMetadataLpbptkjp.R6301RKPST.getObject())));
    fs.add(sf(2, null, "Kode Kantor Wilayah", sv(C, 1, 100, all)
        .confConditionalRequired(ER6301RKPST.genConditionalExistA())));
    fs.add(sf(3, null, "Kantor Wilayah", sv(C, 1, 100, all)
        .confConditionalRequired(ER6301RKPST.genConditionalExistA())));
    fs.add(sf(4, null, "Kode Kantor Cabang", sv(C, 1, 100, all)
        .confConditionalRequired(ER6301RKPST.genConditionalExistA())));
    fs.add(sf(5, null, "Kantor Cabang", sv(C, 1, 100, all)
        .confConditionalRequired(ER6301RKPST.genConditionalExistA())));
    fs.add(sf(6, null, "Lokasi DATI II", sv(C, 1, 8, refTable /*Huruf Angka :*/)
        .confRegex(PATTERN_REFERENCE_1)
        .confReference(EHeaderMetadataShared.LOKASI_DATI_2.getObject())
        .confConditionalRequired(ER6301RKPST.genConditionalExistA())));
    fs.add(sf(7, null, "Lokasi DATI I", sv(C, 1, 8, refTable /*Huruf Angka :*/)
        .confRegex(PATTERN_REFERENCE_1)
        .confReference(EHeaderMetadataShared.LOKASI_DATI_1.getObject())
        .confConditionalRequired(ER6301RKPST.genConditionalExistA())));
    fs.add(sf(8, null, "Pemberi Kerja Penerima Upah", sv(M, 1, 10, numeric)));
    fs.add(sf(9, null, "Peserta Penerima Upah", sv(M, 1, 10, numeric)));
    fs.add(sf(10, null, "Segmen Peserta", sv(C, 1, 10, refTable /*Huruf Angka .*/)
        .confRegex(PATTERN_REFERENCE_4)
        .confReference(EHeaderMetadataShared.SEGMEN_PESERTA_LPP.getObject())
        .confConditionalRequired(ER6301RKPST.genConditionalExistA())));
    fs.add(sf(11, null, "Target Pemberi Kerja", sv(M, 1, 10, numeric)));
    fs.add(sf(12, null, "Lapangan Usaha/Counterparty 1", sv(M, 1, 10, numeric)));
    fs.add(sf(13, null, "Lapangan Usaha/Counterparty 2", sv(M, 1, 10, numeric)));
    fs.add(sf(14, null, "Lapangan Usaha/Counterparty 3", sv(M, 1, 10, numeric)));
    fs.add(sf(15, null, "Lapangan Usaha/Counterparty 4", sv(M, 1, 10, numeric)));
    fs.add(sf(16, null, "Lapangan Usaha/Counterparty 5", sv(M, 1, 10, numeric)));
    fs.add(sf(17, null, "Lapangan Usaha/Counterparty 6", sv(M, 1, 10, numeric)));
    fs.add(sf(18, null, "Lapangan Usaha/Counterparty 7", sv(M, 1, 10, numeric)));
    fs.add(sf(19, null, "Lapangan Usaha/Counterparty 8", sv(M, 1, 10, numeric)));
    fs.add(sf(20, null, "Lapangan Usaha/Counterparty 9", sv(M, 1, 10, numeric)));
    fs.add(sf(21, null, "Total Lapangan Usaha/Counterparty", sv(M, 1, 10, numeric))
        .addFieldValidations(ER6301RKPST.genValidationTotalLapanganUsaha()));
    fs.add(sf(22, null, "Jenis Kelamin Laki-laki", sv(M, 1, 10, numeric)));
    fs.add(sf(23, null, "Jenis Kelamin Perempuan", sv(M, 1, 10, numeric)));
    fs.add(sf(24, null, "Total Jenis Kelamin", sv(M, 1, 10, numeric))
        .addFieldValidations(ER6301RKPST.genValidationTotalJenisKelaminA())
        .addFieldValidations(ER6301RKPST.genValidationTotalJenisKelaminB()));
    fs.add(sf(25, null, "Peserta Masuk", sv(M, 1, 10, numeric)));
    fs.add(sf(26, null, "Peserta Keluar", sv(M, 1, 10, numeric)));
    fs.add(sf(27, null, "Peserta Aktif", sv(M, 1, 10, numeric)));
    fs.add(sf(28, null, "Peserta Nonaktif", sv(M, 1, 10, numeric)));
    fs.add(sf(29, null, "Total Peserta", sv(M, 1, 10, numeric))
        .addFieldValidations(ER6301RKPST.genValidationTotalPeserta()));
    fs.add(sf(30, null, "Kelompok Umur 1", sv(M, 1, 10, numeric)));
    fs.add(sf(31, null, "Kelompok Umur 2", sv(M, 1, 10, numeric)));
    fs.add(sf(32, null, "Kelompok Umur 3", sv(M, 1, 10, numeric)));
    fs.add(sf(33, null, "Kelompok Umur 4", sv(M, 1, 10, numeric)));
    fs.add(sf(34, null, "Kelompok Umur 5", sv(M, 1, 10, numeric)));
    fs.add(sf(35, null, "Kelompok Umur 6", sv(M, 1, 10, numeric)));
    fs.add(sf(36, null, "Kelompok Umur 7", sv(M, 1, 10, numeric)));
    fs.add(sf(37, null, "Kelompok Umur 8", sv(M, 1, 10, numeric)));
    fs.add(sf(38, null, "Kelompok Umur 9", sv(M, 1, 10, numeric)));
    fs.add(sf(39, null, "Kelompok Umur 10", sv(M, 1, 10, numeric)));
    fs.add(sf(40, null, "Kelompok Umur 11", sv(M, 1, 10, numeric)));
    fs.add(sf(41, null, "Kelompok Umur 12", sv(M, 1, 10, numeric)));
    fs.add(sf(42, null, "Kelompok Umur 13", sv(M, 1, 10, numeric)));
    fs.add(sf(43, null, "Total Kelompok Umur", sv(M, 1, 10, numeric))
        .addFieldValidations(ER6301RKPST.genValidationTotalKelompokUmurA())
        .addFieldValidations(ER6301RKPST.genValidationTotalKelompokUmurB()));
    fs.add(sf(44, null, "Kewarganegaraan WNI", sv(M, 1, 10, numeric)));
    fs.add(sf(45, null, "Kewarganegaraan WNA", sv(M, 1, 10, numeric)));
    fs.add(sf(46, null, "Total Kewarganegaraan", sv(M, 1, 10, numeric))
        .addFieldValidations(ER6301RKPST.genValidationTotalKewarganegaraan()));
    fs.add(sf(47, null, "Target Peserta", sv(M, 1, 10, numeric)));
    return res;
  }

}
