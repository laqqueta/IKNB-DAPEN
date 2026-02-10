package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.config.DataType.alfa;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.freeText;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0026SRDP extends BaseMetadata {

    public Ltlb0026SRDP(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_SRDP;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null, null, null);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 11, 11, all)));
        fs.add(sf(2, null, "Nama Bank", sv(M, 1, 32, alfaNumeric)));
        fs.add(sf(3, null, "Cabang", sv(O, 1, 100, alfaNumeric)));
        fs.add(sf(4, null, "Kode Bank", sv(M, 1, 6, numeric)));
        fs.add(sf(5, null, "Tanggal Perolehan", sv(M, 8, 8, date)));
        fs.add(sf(6, null, "Nilai Nominal", sv(M, 1, 18, numeric)));
        fs.add(sf(7, null, "Jangka Waktu (Hari)", sv(M, 1, 3, numeric)));
        fs.add(sf(8, null, "Tingkat Bunga/Nisbah (%)", sv(M, 2, 5, numericDot)));
        fs.add(sf(9, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain/LCF", sv(M, 1, 6, alfaNumeric)));
        fs.add(sf(10, null, "Pengelolaan Swakelola/ KPD", sv(M, 1, 6, alfaNumeric)));
        fs.add(sf(11, null, "Pengelolaan Nama Manajer Investasi", sv(C, 1, 250, alfa)));
        fs.add(sf(12, null, "Keterangan", sv(O, 1, 250, freeText)));

        return res;
    }
}
