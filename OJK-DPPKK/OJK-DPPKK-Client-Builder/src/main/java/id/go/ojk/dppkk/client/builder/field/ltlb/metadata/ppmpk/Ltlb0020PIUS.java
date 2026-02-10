package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0020PIUS extends BaseMetadata {

    public Ltlb0020PIUS(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_PIUS;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null, null, null);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 14, 14, all)));
        fs.add(sf(2, null, "Jumlah Peserta Iuran Sukarela", sv(M, 1, 18, numeric)));
        fs.add(sf(3, null, "Saldo Akumulasi Iuran Sukarela bulan sebelumnya", sv(M, 1, 18, numeric)));
        fs.add(sf(4, null, "Penambahan iuran sukarela bulan berjalan", sv(M, 1, 18, numeric)));
        fs.add(sf(5, null, "Distribusi Hasil Pengembangan Dana Iuran Sukarela", sv(M, 1, 18, numeric)));
        fs.add(sf(6, null, "Total Saldo akumulasi iuran sukarela", sv(M, 1, 18, numeric)));

        return res;
    }
}
