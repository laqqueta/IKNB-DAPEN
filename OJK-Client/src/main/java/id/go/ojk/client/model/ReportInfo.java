package id.go.ojk.client.model;

import java.io.Serializable;

import id.go.ojk.client.constant.EReport;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class ReportInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String reportTypeCode;
	private ReportGroup reportGroup;
	private EReport report;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReportTypeCode() {
		return reportTypeCode;
	}

	public void setReportTypeCode(String reportTypeCode) {
		this.reportTypeCode = reportTypeCode;
	}

	public ReportGroup getReportGroup() {
		return reportGroup;
	}

	public void setReportGroup(ReportGroup reportGroup) {
		this.reportGroup = reportGroup;
	}

	public EReport getReport() {
		return report;
	}

	public void setReport(EReport report) {
		this.report = report;
	}
}
