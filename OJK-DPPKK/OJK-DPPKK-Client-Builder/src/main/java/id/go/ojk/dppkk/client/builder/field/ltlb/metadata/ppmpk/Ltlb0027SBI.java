package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0027SBI extends BaseMetadata {

    public Ltlb0027SBI(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_SBI;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null, null, null);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 9, 9, all)));
        fs.add(sf(2, null, "Kode Surat Berharga", sv(M, 1, 50, freeText)));
        fs.add(sf(3, null, "Tanggal Perolehan", sv(M, 8, 8, date)));
        fs.add(sf(4, null, "Nilai Nominal", sv(M, 1, 18, numeric)));
        fs.add(sf(5, null, "Kupon (%)", sv(M, 2, 5, numericDot)));
        fs.add(sf(6, null, "Tanggal Jatuh Tempo", sv(M, 8, 8, date)));
        fs.add(sf(7, null, "Nilai Perolehan", sv(M, 1, 18, numeric)));
        fs.add(sf(8, null, "Nilai Wajar", sv(M, 1, 18, numeric)));
        fs.add(sf(9, null, "Selisih Penilaian Investasi Nilai", sv(M, 1, 18, numeric)));
        fs.add(sf(10, null, "Selisih Penilaian Investasi %", sv(M, 2, 5, numericDot)));
        fs.add(sf(11, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain", sv(M, 1, 6, alfaNumeric)));
        fs.add(sf(12, null, "Pengelolaan Swakelola/ KPD", sv(M, 1, 6, alfaNumeric)));
        fs.add(sf(13, null, "Pengelolaan Nama Manajer Investasi", sv(C, 1, 250, alfa)));
        fs.add(sf(14, null, "Keterangan", sv(O, 1, 250, freeText)));

        return res;
    }
}
