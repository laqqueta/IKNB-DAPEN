package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0040PNYL extends BaseMetadata {

    public Ltlb0040PNYL(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_PNYL;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null, null, null);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 10, 10, all)));
        fs.add(sf(2, null, "Nama Perusahaan(1)", sv(M, 1, 100, alfaNumeric)));
        fs.add(sf(3, null, "Perwakilan Dana Pensiun Nama", sv(M, 1, 100, alfa)));
        fs.add(sf(4, null, "Perwakilan Dana Pensiun Jabatan", sv(M, 1, 50, alfaNumeric)));
        fs.add(sf(5, null, "Kategori Penyertaan*)", sv(M, 1, 8, alfaNumeric)));
        fs.add(sf(6, null, "Tanggal Perolehan", sv(M, 8, 8, date)));
        fs.add(sf(7, null, "Penempatan Awal Tanggal", sv(M, 8, 8, date)));
        fs.add(sf(8, null, "Penempatan Awal % Kepemilikan", sv(M, 2, 5, numericDot)));
        fs.add(sf(9, null, "Penempatan Awal Total", sv(M, 1, 18, numeric)));
        fs.add(sf(10, null, "Nilai Perolehan Per tanggal laporan % Kepemilikan", sv(M, 2, 5, numericDot)));
        fs.add(sf(11, null, "Nilai Perolehan Per tanggal laporan Total", sv(M, 1, 18, numeric)));
        fs.add(sf(12, null, "Nilai Apprasial/wajar Nama Penilai Publik/Independen", sv(M, 1, 100, alfa)));
        fs.add(sf(13, null, "Nilai Apprasial/wajar Tanggal", sv(M, 8, 8, date)));
        fs.add(sf(14, null, "Nilai Apprasial/wajar % Kepemilikan", sv(M, 2, 5, numericDot)));
        fs.add(sf(15, null, "Nilai Apprasial/wajar Total", sv(M, 1, 18, numeric)));
        fs.add(sf(16, null, "Selisih Penilaian Investasi Nilai", sv(M, 1, 18, numeric)));
        fs.add(sf(17, null, "Selisih Penilaian Investasi %", sv(M, 2, 5, numericDot)));
        fs.add(sf(18, null, "Sektor Ekonomi", sv(M, 1, 8, alfa)));
        fs.add(sf(19, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain", sv(M, 1, 6, alfaNumeric)));
        fs.add(sf(20, null, "Keterangan", sv(M, 1, 250, freeText)));
        fs.add(sf(21, null, "Total Modal Disetor", sv(M, 1, 18, numeric)));
        fs.add(sf(22, null, "Presentase kepemilikan (v) Pendiri", sv(M, 2, 5, numericDot)));
        fs.add(sf(23, null, "Presentase kepemilikan (v) Dana Pensiun", sv(M, 2, 5, numericDot)));
        fs.add(sf(24, null, "Presentase kepemilikan (v) Mitra Pendiri", sv(M, 2, 5, numericDot)));
        fs.add(sf(25, null, "Presentase kepemilikan (v) Pengurus", sv(M, 2, 5, numericDot)));
        fs.add(sf(26, null, "Presentase kepemilikan (v) Penerima titipan", sv(M, 2, 5, numericDot)));
        fs.add(sf(27, null, "Presentase kepemilikan (v) Serikat Kerja yang Anggotanya Merupakan Peserta DP", sv(M, 2, 5, numericDot)));
        fs.add(sf(28, null, "Presentase kepemilikan (v) Lainnya", sv(M, 2, 5, numericDot)));
        fs.add(sf(29, null, "Anak Perusahaan dari Penyertaan Langsung(2)", sv(C, 1, 100, freeText)));
        fs.add(sf(30, null, "Total Modal Disetor Anak Perusahaan dari Penyertaan Langsung", sv(C, 1, 18, numeric)));
        fs.add(sf(31, null, "Presentase Kepemilikan (e1) Pendiri", sv(C, 2, 5, numericDot)));
        fs.add(sf(32, null, "Presentase Kepemilikan (e1) Mitra Pendiri", sv(C, 2, 5, numericDot)));
        fs.add(sf(33, null, "Presentase Kepemilikan (e1) Pengurus", sv(C, 2, 5, numericDot)));
        fs.add(sf(34, null, "Presentase Kepemilikan (e1) Penerima Titipan", sv(C, 2, 5, numericDot)));
        fs.add(sf(35, null, "Presentase Kepemilikan (e1) Serikat Kerja yang Anggotanya Merupakan Peserta DP", sv(C, 2, 5, numericDot)));
        fs.add(sf(36, null, "Presentase Kepemilikan (e1) Lainnya", sv(C, 2, 5, numericDot)));
        fs.add(sf(37, null, "Presentase Kepemilikan (e1) Dividen Anak Perusahaan", sv(C, 1, 18, numeric)));

        return res;
    }
}
