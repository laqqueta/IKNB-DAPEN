package id.go.ojk.dppkk.client.builder.field.ltlb.metadata;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

public class Ltlb0001DTUM extends BaseMetadata {

    public Ltlb0001DTUM(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_DTUM;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null, null, null);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(O, 0, 100, all)));
        fs.add(sf(1, null, "Kode Komponen", sv(O, 0, 100, all)));
        fs.add(sf(2, null, "Field", sv(O, 0, 100, all)));
        fs.add(sf(3, null, "Keterangan", sv(O, 0, 100, all)));

        return res;
    }
}
