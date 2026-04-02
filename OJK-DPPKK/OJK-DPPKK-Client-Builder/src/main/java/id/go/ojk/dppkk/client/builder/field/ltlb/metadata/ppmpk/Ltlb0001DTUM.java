package id.go.ojk.dppkk.client.builder.field.ltlb.metadata.ppmpk;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.ltlb.reference.ppmpk.ER7000PosLtlbDppkDtum;
import id.go.ojk.module.lblt.dppk.metadata.Dppk001Dtum;
import id.go.ojk.util.constants.SectorType;

import java.util.ArrayList;
import java.util.List;

public class Ltlb0001DTUM extends BaseMetadata {

    public Ltlb0001DTUM(String reportCode) {
        super(reportCode, ".txt");
    }

    @Override
    public SubmissionFormat get() {

        SubmissionFormatBuilder konvenSubmissionFormat = Dppk001Dtum.KONVENSIONAL_SUBMISSION_FORMAT_CONFIG;
        konvenSubmissionFormat.setReportCode(reportCode);
        konvenSubmissionFormat.setFields(new ArrayList<>());

        SubmissionFormat res = new SubmissionFormat(konvenSubmissionFormat);

        res.setRequiredPos(ER7000PosLtlbDppkDtum.getRequiredPos());

//        ER7000PosLtlbDppkDtum.SEGMENT_VALIDATIONS.forEach(res::addSegmentValidations);

        List<SubmissionField> fs = res.getFields();

        fs.addAll(Dppk001Dtum.METADATA_FIELD.getFields(SectorType.KONVENSIONAL));

        return res;
    }
}
