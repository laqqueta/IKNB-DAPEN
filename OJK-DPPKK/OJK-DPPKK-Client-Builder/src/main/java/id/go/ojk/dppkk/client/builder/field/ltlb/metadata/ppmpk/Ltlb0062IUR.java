package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.freeText;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0062IUR extends BaseMetadata {

    /*
    *
    * NOT YET USED
    *
    * */

    public Ltlb0062IUR(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_LAN;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null, null, null);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 10, 10, all)));
        fs.add(sf(2, null, "No.", sv(M, 1, 100, alfaNumeric)));
        fs.add(sf(3, null, "Nama Pendiri/Mitra Pendiri", sv(M, 1, 100, alfaNumeric)));
        fs.add(sf(4, null, "PhDP", sv(M, 2, 5, numericDot)));
        fs.add(sf(5, null, "PhDP %", sv(M, 1, 18, numeric)));
        fs.add(sf(6, null, "PhDP Jumlah", sv(M, 2, 5, numericDot)));
        fs.add(sf(7, null, "PhDP %", sv(M, 1, 18, numeric)));
        fs.add(sf(8, null, "PhDP", sv(M, 1, 18, numeric)));
        fs.add(sf(9, null, "PhDP Iuran Sukarela Peserta", sv(M, 1, 18, numeric)));
        fs.add(sf(10, null, "Iuran Tambahan", sv(M, 1, 18, numeric)));
        fs.add(sf(11, null, "Iuran Normal Peserta", sv(M, 1, 18, numeric)));
        fs.add(sf(12, null, "Iuran Normal Pemberi Kerja", sv(M, 1, 18, numeric)));
        fs.add(sf(13, null, "Iuran Tambahan", sv(M, 1, 18, numeric)));
        fs.add(sf(14, null, "Iuran Sukarela Peserta", sv(M, 1, 18, numeric)));
        fs.add(sf(15, null, "Iuran Normal Peserta", sv(M, 1, 18, numeric)));
        fs.add(sf(16, null, "Iuran Normal Pemberi Kerja", sv(M, 1, 18, numeric)));
        fs.add(sf(17, null, "Manfaat Pensiun/Manfaat Pensiun Lainnya/Manfaat Lain", sv(M, 1, 6, alfaNumeric)));
        fs.add(sf(18, null, "Keterangan", sv(M, 1, 250, freeText)));

        return res;
    }
}
