package id.go.ojk.client.module;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.validation.BaseValidationFile;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;
import id.go.ojk.lib.client.model.MonthDate;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

public class ValidationFileName2 extends BaseValidationFile<ValidFile> {
	private final Logger logger = LoggerFactory.getLogger(ValidationFileName2.class);
	protected List<ValidFile> files;
	protected ReportInfo reportInfo;
	protected String memberCode;
	protected String memberTypeCode;
	protected ProgressPreparationAndSending childProgress;
	protected List<ValidFile> listFile = new ArrayList<>();

	public ValidationFileName2(List<ValidFile> files, ReportInfo reportInfo, String memberCode,
			String memberTypeCode) {
		this.files = files;
		this.reportInfo = reportInfo;
		this.memberCode = memberCode;
		this.memberTypeCode = memberTypeCode;
	}

	public ValidationFileName2(List<ValidFile> files, ReportInfo reportInfo, String memberCode, String memberTypeCode,
			ProgressPreparationAndSending childProgress, ReadSubmissionDirModel readDirModel) {
		this(files, reportInfo, memberCode, memberTypeCode);
		this.childProgress = childProgress;
		this.readDirModel = readDirModel;
	}

	@Override
	public List<ValidFile> getListFile() {
		return this.listFile;
	}

	@Override
	public boolean validate() {
		logger.info("Validator=" + this.getClass().getName());
		if (files != null && !files.isEmpty()) {
			ValidFile firstValidFile = files.get(0);
			String firstPeriodReport = firstValidFile.getPart(4);
			MonthDate firstMonthDate = getMonthDate(firstPeriodReport);
			for (int i = 0; i < files.size(); i++) {
				List<String> listError = new ArrayList<>();
				ValidFile file = files.get(i);
				validatePart0(file, listError);
				validatePart2(file, listError);
				validatePart3(file, listError);
				validatePart4(file, firstPeriodReport, firstMonthDate, listError);
				validatePart5(file, listError);
				validatePart6(file, listError);
				if (listError.isEmpty()) {
					addFile(file);
				} else {
					String error = "Nama File '" + file.getFullFileName() + "', kesalahan : \n\t"
							+ listError.stream().collect(Collectors.joining("\n\t"));
					logError(new ValidationError(null, ValidationErrorCode.E01_05_INVALID_FILE, error));
				}
			}
		}
		boolean res = getListValidationError().isEmpty();
		if (!res) {
			logger.error("Validation failed!!!");
		}
		return res;
	}

	protected void addFile(ValidFile file) {
		if (childProgress != null) {
			String part = file.getPart(4);
			childProgress.getSubmissionData().setDataYearMonth(part.substring(0, 4), part.substring(4, 6));
		}
		listFile.add(file);
	}

	protected boolean validatePart0(ValidFile file, List<String> listError) {
		String part = file.getPart(0);
		String reportTypeCode = reportInfo.getReportTypeCode();
		boolean res = part.equals(reportTypeCode);
		if (!res) {
			listError.add("Nama file '" + file.getFullFileName() + "', harus berawalan '" + reportTypeCode + "'");
		}
		return res;
	}

	protected boolean validatePart2(ValidFile file, List<String> listError) {
		String part = file.getPart(2);
		String deliveryCode = reportInfo.getReportGroup().getDeliveryCode();
		boolean res = part.equals(deliveryCode);
		if (!res) {
			listError.add("Nama file '" + file.getFullFileName() + "', Kode Rutin/Koreksi harus " + deliveryCode);
		}
		return res;
	}

	protected boolean validatePart3(ValidFile file, List<String> listError) {
		String part = file.getPart(3);
		String period = reportInfo.getReportGroup().getPeriod();
		boolean res = part.equals(period);
		if (!res) {
			listError.add("Nama file '" + file.getFullFileName() + "', Kode Jenis Periode harus " + period);
		}
		return res;
	}

	protected boolean validatePart4(ValidFile file, String firstPeriodReport, MonthDate firstMonthDate,
			List<String> listError) {
		boolean res = false;
		String part = file.getPart(4);
		String fileName = file.getFullFileName();
		if (part.length() != 8) {
			listError.add("Nama file '" + fileName + "', Periode Data Pelaporan '" + part
					+ "' tidak valid. Gunakan format YYYYMMDD" + "");
		} else if (!firstPeriodReport.equals(part)) {
			listError.add(
					"Nama file '" + fileName + "', Periode Data Pelaporan tidak boleh berbeda dengan lainnya" + "");
		} else if (!firstMonthDate.yearsIsNumeric()) {
			listError.add("Nama file '" + fileName + "', Tahun Data Pelaporan '" + part
					+ "' tidak valid. Gunakan format YYYYMMDD" + "");
		} else {
			String month = part.substring(4, 6);
			if (!firstMonthDate.getMapMonthDate().containsKey(month)) {
				listError.add("Nama file '" + fileName + "', Bulan Data Pelaporan '" + part
						+ "' tidak valid. Gunakan format YYYYMMDD" + "");
			} else if (!part.substring(6, 8).equals(firstMonthDate.getMapMonthDate().get(month))) {
				listError.add("Nama file '" + fileName + "', Tanggal Periode Data Pelaporan '" + part
						+ "' tidak valid. Posisi tanggal harus sesuai dengan tanggal pada akhir bulan periode pelaporan");
			} else {
				String period = reportInfo.getReportGroup().getPeriod();
				if (period.equals("A") && !part.endsWith("1231")) {
					listError.add("Nama file '" + fileName + "', Tanggal Periode Data Pelaporan '" + part
							+ "' tidak valid. Posisi tanggal harus tanggal 31 bulan Desember");
				} else if (period.equals("S") && !(part.endsWith("0630") || part.endsWith("1231"))) {
					listError.add("Nama file '" + fileName + "', Tanggal Periode Data Pelaporan '" + part
							+ "' tidak valid. Posisi tanggal harus tanggal 30 Juni atau 31 Desember");
				} else {
					res = true;
				}
			}
		}
		return res;
	}

	protected boolean validatePart5(ValidFile file, List<String> listError) {
		String part = file.getPart(5);
		boolean res = part.equals(memberCode);
		if (!res) {
			listError.add("Nama file '" + file.getFullFileName() + "', Kode LJK harus " + memberCode + "");
		}
		return res;
	}

	protected boolean validatePart6(ValidFile file, List<String> listError) {
		String part = file.getPart(6);
		boolean res = part.equals(memberTypeCode);
		if (!res) {
			listError.add("Nama file '" + file.getFullFileName() + "', Kode Sektor LJK harus " + memberTypeCode + "");
		}
		return res;
	}

	protected MonthDate getMonthDate(String periodReport) {
		MonthDate monthDate = null;
		if (StringUtils.isNotEmpty(periodReport) && periodReport.length() == 8) {
			monthDate = new MonthDate(periodReport.substring(0, 4));
		} else {
			monthDate = new MonthDate("");
		}
		return monthDate;
	}
}
