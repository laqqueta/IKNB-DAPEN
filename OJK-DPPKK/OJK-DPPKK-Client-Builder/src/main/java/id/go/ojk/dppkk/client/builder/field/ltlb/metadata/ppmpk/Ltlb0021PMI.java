package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0021PMI extends BaseMetadata {

    public Ltlb0021PMI(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_PMI;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null, null, null);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 9, 9, all)));
        fs.add(sf(2, null, "Nama Manajer Investasi", sv(M, 1, 100, alfaNumeric)));
        fs.add(sf(3, null, "Nomor Kontrak", sv(M, 1, 100, alfaNumeric)));
        fs.add(sf(4, null, "Tanggal Kontrak", sv(M, 8, 8, numeric)));
        fs.add(sf(5, null, "Masa Perjanjian", sv(M, 1, 18, numeric)));
        fs.add(sf(6, null, "Jenis Investasi", sv(M, 1, 100, alfa)));
        fs.add(sf(7, null, "Jumlah Nilai Wajar Dana Kelolaan (Rp)", sv(M, 1, 18, numeric)));
        fs.add(sf(8, null, "Nilai Perolehan (yang dikelola Manajer Investasi)", sv(M, 1, 18, numeric)));
        fs.add(sf(9, null, "Selisih Penilaian Investasi", sv(M, 1, 18, numeric)));
        fs.add(sf(10, null, "Return (%)", sv(M, 2, 5, numericDot)));
        fs.add(sf(11, null, "Tingkat Hasil Investasi Bersih (Rp)", sv(M, 1, 18, numeric)));
        fs.add(sf(12, null, "Jumlah Biaya Pengelolaan yang dibebankan (Rp)", sv(M, 1, 18, numeric)));
        fs.add(sf(13, null, "Terafiliasi dengan Dana Pensiun (Ya/Tidak)", sv(M, 1, 10, alfa)));

        return res;
    }
}
