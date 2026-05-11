package id.go.ojk.metadata.module.lblt.dppk.field;

import id.go.ojk.client.constant.ExtensionType;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionFormatBuilder;
import id.go.ojk.metadata.module.lblt.dppk.EFormLaporanBulananTahunan;
import id.go.ojk.metadata.util.constants.ProgramType;
import id.go.ojk.metadata.submission.SubmissionConfig;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Dppk0099Cover {

    ;

    private static SubmissionFormatBuilder getPpmpSubmissionFormatConfig(String reportCode) {
        EFormLaporanBulananTahunan COVER_FORM = EFormLaporanBulananTahunan.LTLB_COVER;

        return SubmissionFormatBuilder.builder()
                .code(COVER_FORM.getCode())
                .name(COVER_FORM.getName())
                .extension(ExtensionType.PDF)
                .reportCode(reportCode)
                .build();
    }

    public static SubmissionFormat getFormMetadata(String reportCode) {
        return new SubmissionConfig(reportCode, ExtensionType.PDF)
                .config()
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(reportCode))
                .build()
                .get();
    }

    public static SubmissionFormat getFormMetadata(ProgramType programType) {
        return new SubmissionConfig(programType.toString(), ExtensionType.PDF)
                .config()
                .setSubmissionFormat(getPpmpSubmissionFormatConfig(programType.toString()))
                .build()
                .get();
    }
}