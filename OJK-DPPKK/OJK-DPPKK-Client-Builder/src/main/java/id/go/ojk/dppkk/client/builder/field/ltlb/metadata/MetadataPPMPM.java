package id.go.ojk.dppkk.client.builder.field.ltlb.metadata;

import id.go.ojk.client.model.config.SubmissionFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataPPMPM {

    @Getter
    private static final List<SubmissionFormat> metadata = getFormMetadata();

    private static List<SubmissionFormat> getFormMetadata() {
        String REPORT_CODE = "PPMPM";
        return Arrays.asList(
                new Ltlb0001Dtum(REPORT_CODE).get()
        );
    }

}
