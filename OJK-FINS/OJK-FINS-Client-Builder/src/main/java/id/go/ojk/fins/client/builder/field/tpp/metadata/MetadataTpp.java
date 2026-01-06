package id.go.ojk.fins.client.builder.field.tpp.metadata;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.tpp.EReportTpp;
import id.go.ojk.fins.client.builder.field.tpp.EFormTpp;

import java.util.ArrayList;
import java.util.List;

public class MetadataTpp {

    public static List<SubmissionFormat> getMetadata() {

        String rencana = EReportTpp.FNS_RENCANA_RUTIN.getReportTypeCode();
        String realisasi = EReportTpp.FNS_REALISASI_RUTIN.getReportTypeCode();
        String penilaianResiko = EReportTpp.FNS_PENILAIAN_RESIKO_RUTIN.getReportTypeCode();

        List<SubmissionFormat> mtd = new ArrayList<>();

        mtd.add(new TppForm101(rencana).get());
        mtd.add(new TppForm99(rencana, EFormTpp.TPP_199).get());

        mtd.add(new TppForm201(realisasi).get());
        mtd.add(new TppForm99(realisasi, EFormTpp.TPP_299).get());

        mtd.add(new TppForm301(penilaianResiko).get());
        mtd.add(new TppForm99(penilaianResiko, EFormTpp.TPP_399).get());

        return mtd;
    }

}
