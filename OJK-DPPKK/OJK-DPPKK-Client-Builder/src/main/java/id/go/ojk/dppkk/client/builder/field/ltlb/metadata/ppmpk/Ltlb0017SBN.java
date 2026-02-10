package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Ltlb0017SBN extends BaseMetadata {

    public Ltlb0017SBN(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_SBN;
        SubmissionFormat res = new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, new ArrayList<>(),
                extension, 0, null, null, null);

        List<SubmissionField> fs = res.getFields();

        fs.add(sf(0, null, "Flag", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
        fs.add(sf(1, null, "Kode Komponen", sv(M, 9, 9, all)));
        fs.add(sf(2, null, "Jenis Investasi", sv(M, 1, 100, alfaNumeric)));
        fs.add(sf(3, null, "Nama Jenis Investasi", sv(M, 1, 100, alfaNumeric)));
        fs.add(sf(4, null, "Seri Efek", sv(C, 1, 100, alfaNumeric)));
        fs.add(sf(5, null, "Jenis Kepemilikan", sv(C, 1, 100, alfa)));
        fs.add(sf(6, null, "Rating", sv(C, 1, 100, alfaNumeric)));
        fs.add(sf(7, null, "Menajer Investasi", sv(C, 1, 100, alfaNumeric)));
        fs.add(sf(8, null, "Nilai Wajar", sv(C, 1, 18, alfa)));
        fs.add(sf(9, null, "% SBN dalam Reksadana", sv(C, 2, 5, numericDot)));
        fs.add(sf(10, null, "Saldo", sv(M, 1, 18, numeric)));
        fs.add(sf(11, null, "Emiten Penerima Dana/Project", sv(C, 1, 100, alfa)));

        return res;
    }
}
