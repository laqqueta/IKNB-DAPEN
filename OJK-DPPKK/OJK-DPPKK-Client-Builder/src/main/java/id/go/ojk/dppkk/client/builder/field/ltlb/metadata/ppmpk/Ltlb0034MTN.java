package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0034MTN extends BaseMetadata {

    public Ltlb0034MTN(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_MTN;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null, null, null);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 9, 9, all)));
        fs.add(sf(2, null, "Kode", sv(M, 1, 30, alfaNumeric)));
        fs.add(sf(3, null, "Nama Produk", sv(M, 1, 100, alfaNumeric)));
        fs.add(sf(4, null, "Nama Penerbit", sv(M, 1, 100, alfaNumeric)));
        fs.add(sf(5, null, "Tanggal Perolehan", sv(M, 8, 8, date)));
        fs.add(sf(6, null, "Nilai Nominal", sv(M, 1, 18, numeric)));
        fs.add(sf(7, null, "Kupon (%)", sv(M, 2, 5, numericDot)));
        fs.add(sf(8, null, "Tanggal Jatuh Tempo", sv(M, 8, 8, date)));
        fs.add(sf(9, null, "Peringkat Awal", sv(M, 1, 10, alfaNumeric)));
        fs.add(sf(10, null, "Peringkat Akhir", sv(M, 1, 10, alfaNumeric)));
        fs.add(sf(11, null, "Nilai Perolehan", sv(M, 1, 18, numeric)));
        fs.add(sf(12, null, "Nilai Wajar", sv(M, 1, 18, numeric)));
        fs.add(sf(13, null, "Selisih Penilaian Investasi Nilai", sv(M, 1, 18, numeric)));
        fs.add(sf(14, null, "Selisih Penilaian Investasi %", sv(M, 2, 5, numericDot)));
        fs.add(sf(15, null, "Sektor Ekonomi", sv(M, 1, 8, alfa)));
        fs.add(sf(16, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain", sv(M, 1, 6, alfaNumeric)));
        fs.add(sf(17, null, "Pengelolaan Swakelola/ KPD", sv(M, 1, 6, alfaNumeric)));
        fs.add(sf(18, null, "Pengelolaan Nama Manajer Investasi", sv(C, 1, 250, alfa)));
        fs.add(sf(19, null, "Keterangan", sv(O, 1, 250, freeText)));

        return res;
    }
}
