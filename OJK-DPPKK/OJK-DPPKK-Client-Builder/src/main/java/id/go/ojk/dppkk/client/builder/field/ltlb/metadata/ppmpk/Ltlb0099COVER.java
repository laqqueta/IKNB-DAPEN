package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormLaporanTahunanLaporanBulanan;

import java.util.ArrayList;

public class Ltlb0099COVER extends BaseMetadata {

    public Ltlb0099COVER(String reportCode) {
        super(reportCode, ".pdf");
    }

    @Override
    public SubmissionFormat get() {

        EFormLaporanTahunanLaporanBulanan eNum = EFormLaporanTahunanLaporanBulanan.LTLB_COVER;

        return new SubmissionFormat(eNum.getCode(), eNum.getName(), reportCode, extension);
    }
}
