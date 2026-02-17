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

public class Ltlb0018RAS1 extends BaseMetadata {

    public Ltlb0018RAS1(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_RAS_1;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 15, 15, all)));
        fs.add(sf(2, null, "Manfaat Pensiun", sv(M, 1, 18, numeric)));
        fs.add(sf(3, null, "Manfaat Pensiun Lainnya", sv(M, 1, 18, numeric)));
        fs.add(sf(4, null, "Manfaat lain", sv(M, 1, 18, numeric)));
        fs.add(sf(5, null, "Total", sv(M, 1, 18, numeric)));
        fs.add(sf(6, null, "Keterangan", sv(O, 1, 250, alfaNumeric)));

        return res;
    }
}
