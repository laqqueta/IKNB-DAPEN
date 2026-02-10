package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0041PROP extends BaseMetadata {

    public Ltlb0041PROP(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_PROP;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null, null, null);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 10, 10, all)));
        fs.add(sf(2, null, "Jenis Objek (Tanah/Bangunan/Tanah&Bangunan)", sv(M, 1, 8, alfaNumeric)));
        fs.add(sf(3, null, "Alamat Lengkap", sv(M, 1, 250, alfaNumeric)));
        fs.add(sf(4, null, "Luas(m2)", sv(M, 1, 10, numeric)));
        fs.add(sf(5, null, "Jenis Bukti Kepemilikan", sv(M, 1, 8, alfaNumeric)));
        fs.add(sf(6, null, "Nomor Surat Kepemilikan", sv(M, 1, 20, alfaNumeric)));
        fs.add(sf(7, null, "Tanggal Perolehan", sv(M, 8, 8, date)));
        fs.add(sf(8, null, "Nilai Perolehan", sv(M, 1, 18, numeric)));
        fs.add(sf(9, null, "Akumulasi Penyusutan", sv(M, 1, 18, numeric)));
        fs.add(sf(10, null, "Nilai Buku", sv(M, 1, 18, numeric)));
        fs.add(sf(11, null, "Nilai Appraisal/ Nilai Wajar", sv(M, 1, 18, numeric)));
        fs.add(sf(12, null, "Tanggal Appraisal", sv(M, 8, 8, date)));
        fs.add(sf(13, null, "Nama Penilai Publik/Independen", sv(M, 1, 100, alfaNumeric)));
        fs.add(sf(14, null, "Nama KJPP", sv(M, 1, 100, alfaNumeric)));
        fs.add(sf(15, null, "Selisih Penilaian Investasi Nilai", sv(M, 1, 18, numeric)));
        fs.add(sf(16, null, "Selisih Penilaian Investasi %", sv(M, 2, 5, numericDot)));
        fs.add(sf(17, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain", sv(M, 1, 6, alfaNumeric)));
        fs.add(sf(18, null, "Pendapatan Sewa", sv(M, 1, 18, numeric)));
        fs.add(sf(19, null, "Keterangan", sv(O, 1, 250, freeText)));

        return res;
    }
}
