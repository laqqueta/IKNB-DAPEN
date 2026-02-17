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

public class Ltlb0004NRC extends BaseMetadata {

    public Ltlb0004NRC(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_NERACA;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 13, 13, all)));
        fs.add(sf(2, null, "Manfaat Pensiun", sv(M, 1, 18, numeric)));
        fs.add(sf(3, null, "Manfaat Pensiun Lainnya Manfaat Tambahan", sv(M, 1, 18, numeric)));
        fs.add(sf(4, null, "Manfaat Pensiun Lainnya Kompensasi Pascakerja", sv(M, 1, 18, numeric)));
        fs.add(sf(5, null, "Manfaat Pensiun Lainnya Lainnya", sv(M, 1, 18, numeric)));
        fs.add(sf(6, null, "Manfaat Lain Kompensasi Pascakerja", sv(M, 1, 18, numeric)));
        fs.add(sf(7, null, "Manfaat Lain Kesehatan", sv(M, 1, 18, numeric)));
        fs.add(sf(8, null, "Manfaat Lain Santunan Kematian", sv(M, 1, 18, numeric)));
        fs.add(sf(9, null, "Manfaat Lain Ibadah Keagamaan", sv(M, 1, 18, numeric)));
        fs.add(sf(10, null, "Manfaat Lain Pendidikan", sv(M, 1, 18, numeric)));
        fs.add(sf(11, null, "Manfaat Lain Lainnya", sv(M, 1, 18, numeric)));
        fs.add(sf(12, null, "Gabungan", sv(M, 1, 18, numeric)));

        return res;
    }
}
