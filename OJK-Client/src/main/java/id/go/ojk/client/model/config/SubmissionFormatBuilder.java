package id.go.ojk.client.model.config;

import id.go.ojk.client.constant.ExtensionType;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class SubmissionFormatBuilder {
    private String code;
    private String name;
    private String reportCode;
    private List<SubmissionField> fields;
    private ExtensionType extension;
    private Integer minRow;
    private Integer maxRow;

    public List<SubmissionField> getFields() {
        if (fields == null) {
            fields = new ArrayList<>();
        }

        return fields;
    }
}
