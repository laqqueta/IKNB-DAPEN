package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

public class Ltlb0008KUP extends BaseMetadata {

    public Ltlb0008KUP(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_KUP;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 13, 13, all)));
        fs.add(sf(2, null, "Uraian Tambahan", sv(C, 1, 100, alfaNumeric)));
        fs.add(sf(3, null, "Nilai Program Manfaat Pensiun", sv(M, 2, 18, numeric)));
        fs.add(sf(4, null, "Nilai Program Manfaat Pensiun Lainnya", sv(M, 2, 18, numeric)));
        fs.add(sf(5, null, "Nilai Program Manfaat Lain", sv(M, 2, 18, numeric)));

        return res;
    }
}
