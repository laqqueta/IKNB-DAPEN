package id.go.ojk.dppkk.client.builder.field.ltlb.metadata;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.module.lktb.EReportLktb;
import id.go.ojk.dppkk.client.builder.field.rb.metadata.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataPPMPK {

    @Getter
    private static final List<SubmissionFormat> metadata = getFormMetadata();

    private static List<SubmissionFormat> getFormMetadata() {
        String REPORT_CODE = "PPMPK";
        return Arrays.asList(
                new Ltlb0001Dtum(REPORT_CODE).get()
        );
    }
}
