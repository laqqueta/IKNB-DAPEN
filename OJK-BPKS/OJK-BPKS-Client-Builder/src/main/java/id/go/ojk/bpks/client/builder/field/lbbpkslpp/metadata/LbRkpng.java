package id.go.ojk.bpks.client.builder.field.lbbpkslpp.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_NAME;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.bpks.client.builder.field.EFormLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.EHeaderMetadataLbbpkslpp;
import id.go.ojk.bpks.client.builder.field.lbbpkslpp.reference.ER5211RKPNG;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class LbRkpng extends BaseMetadata {
  public LbRkpng(String reportCode) {
    super(reportCode, ".txt");
  }

  @Override
  public SubmissionFormat get() {
    EFormLbbpkslpp eEnum = EFormLbbpkslpp.RKPNG;
    SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
        extension, 1, null);

    res.setRequiredPos(ER5211RKPNG.genRequiredPos());
    res.setUniquePos(ER5211RKPNG.genUniquePos());
    res.setSavePos(ER5211RKPNG.genFieldSave());

    res.addSegmentValidations(ER5211RKPNG.genValidationTotal());

    List<SubmissionField> fs = res.getFields();
    fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
    fs.add(sf(1, null, "Kode Komponen/Baris", sv(M, 15, 15, refTable)
        .confReference(EHeaderMetadataLbbpkslpp.R5211RKPNG.getObject())
        .confRegex(patternAlfaNumeric)));
    fs.add(sf(2, null, "Unit Kerja", sv(C, 1, 50, all)
        .confRegex(PATTERN_NAME)
        .confConditionalRequired(ER5211RKPNG.genConditionalExistA())));
    fs.add(sf(3, null, "Pengaduan Disampaikan Melalui - Tatap Muka - Customer Service", sv(M, 1, 10, numeric)));
    fs.add(sf(4, null, "Pengaduan Disampaikan Melalui - Suara - Telepon Reguler", sv(M, 1, 10, numeric)));
    fs.add(sf(5, null, "Pengaduan Disampaikan Melalui - Suara - BPJS Kesehatan Care Center 165 ", sv(M, 1, 10, numeric)));
    fs.add(sf(6, null, "Pengaduan Disampaikan Melalui - Tertulis - Website", sv(M, 1, 10, numeric)));
    fs.add(sf(7, null, "Pengaduan Disampaikan Melalui - Tertulis - Email", sv(M, 1, 10, numeric)));
    fs.add(sf(8, null, "Pengaduan Disampaikan Melalui - Tertulis - SMS", sv(M, 1, 10, numeric)));
    fs.add(sf(9, null, "Pengaduan Disampaikan Melalui - Tertulis - Mobile JKN", sv(M, 1, 10, numeric)));
    fs.add(sf(10, null, "Pengaduan Disampaikan Melalui - Publik - Media Cetak", sv(M, 1, 10, numeric)));
    fs.add(sf(11, null, "Pengaduan Disampaikan Melalui - Publik - Instagram", sv(M, 1, 10, numeric)));
    fs.add(sf(12, null, "Pengaduan Disampaikan Melalui - Publik - Twitter", sv(M, 1, 10, numeric)));
    fs.add(sf(13, null, "Pengaduan Disampaikan Melalui - Publik - Facebook", sv(M, 1, 10, numeric)));
    fs.add(sf(14, null, "Pengaduan Disampaikan Melalui - Publik - Chatbot", sv(M, 1, 10, numeric)));
    fs.add(sf(15, null, "Pengaduan Disampaikan Melalui - Lainnya", sv(M, 1, 10, numeric)));
    fs.add(sf(16, null, "Pengaduan Disampaikan Melalui - Jumlah Pengaduan", sv(M, 1, 10, numeric))
        .addFieldValidations(ER5211RKPNG.genFieldValidation17()));
    fs.add(sf(17, null, "Pokok Masalah Pengaduan - Pelayanan Administrasi Pendaftaran", sv(M, 1, 10, numeric)));
    fs.add(sf(18, null, "Pokok Masalah Pengaduan - Iuran", sv(M, 1, 10, numeric)));
    fs.add(sf(19, null, "Pokok Masalah Pengaduan - Pelayanan Kesehatan", sv(M, 1, 10, numeric)));
    fs.add(sf(20, null, "Pokok Masalah Pengaduan - Pelayanan Obat", sv(M, 1, 10, numeric)));
    fs.add(sf(21, null, "Pokok Masalah Pengaduan - Lainnya", sv(M, 1, 10, numeric)));
    fs.add(sf(22, null, "Pokok Masalah Pengaduan - Jumlah Pengaduan", sv(M, 1, 10, numeric))
        .addFieldValidations(ER5211RKPNG.genFieldValidation23()));
    fs.add(sf(23, null, "Penyelesaian Pengaduan - Proses Penyelesaian Pengaduan - Belum Direspon", sv(M, 1, 10, numeric)));
    fs.add(sf(24, null, "Penyelesaian Pengaduan - Proses Penyelesaian Pengaduan - On process", sv(M, 1, 10, numeric)));
    fs.add(sf(25, null, "Penyelesaian Pengaduan - Proses Penyelesaian Pengaduan - Selesai", sv(M, 1, 10, numeric)));
    fs.add(sf(26, null, "Penyelesaian Pengaduan - Jumlah Pengaduan", sv(M, 1, 10, numeric))
        .addFieldValidations(ER5211RKPNG.genFieldValidation27()));
    fs.add(sf(27, null, "Penyelesaian Pengaduan - Waktu Penyelesaian Pengaduan - 1 s.d 3 hari kerja", sv(M, 1, 10, numeric)));
    fs.add(sf(28, null, "Penyelesaian Pengaduan - Waktu Penyelesaian Pengaduan - 4 s.d 5 hari kerja", sv(M, 1, 10, numeric)));
    fs.add(sf(29, null, "Penyelesaian Pengaduan - Waktu Penyelesaian Pengaduan - > 5 hari kerja", sv(M, 1, 10, numeric)));
    fs.add(sf(30, null, "Penyelesaian Pengaduan - Jumlah Pengaduan Selesai", sv(M, 1, 10, numeric))
        .addFieldValidations(ER5211RKPNG.genFieldValidation31()));
    return res;
  }
}
