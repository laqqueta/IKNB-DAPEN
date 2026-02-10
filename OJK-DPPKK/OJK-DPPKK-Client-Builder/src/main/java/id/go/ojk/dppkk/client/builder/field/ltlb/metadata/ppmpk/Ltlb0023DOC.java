package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

public class Ltlb0023DOC extends BaseMetadata {

    public Ltlb0023DOC(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_DOC;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null, null, null);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 9, 9, all)));
        fs.add(sf(2, null, "Kode Bank", sv(M, 1, 6, alfaNumeric)));
        fs.add(sf(3, null, "Cabang", sv(O, 1, 100, alfaNumeric)));
        fs.add(sf(4, null, "Tanggal Perolehan", sv(M, 8, 8, date)));
        fs.add(sf(5, null, "Nilai Nominal", sv(M, 1, 18, numeric)));
        fs.add(sf(6, null, "Jangka Waktu (Hari)", sv(M, 1, 3, numeric)));
        fs.add(sf(7, null, "Tingkat Bunga/Nisbah (%)", sv(M, 2, 5, numericDot)));
        fs.add(sf(8, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF", sv(M, 1, 6, alfaNumeric)));
        fs.add(sf(9, null, "Pengelolaan - Swakelola/KPD", sv(M, 1, 100, alfaNumeric)));
        fs.add(sf(10, null, "Pengelolaan - Nama Manajer Investasi", sv(M, 1, 100, alfaNumeric)));
        fs.add(sf(11, null, "Keterangan", sv(O, 1, 250, freeText)));

        return res;
    }
}
