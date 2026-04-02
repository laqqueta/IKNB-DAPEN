package id.go.ojk.client.model.config;

import com.google.common.collect.Lists;
import lombok.*;

import java.util.List;

@Data
@Builder
public class SubmissionFormatBuilder {
    private String code;
    private String name;
    private String reportCode;
    private List<SubmissionField> fields;
    private String extension;
    private Integer minRow;
    private Integer maxRow;
}
