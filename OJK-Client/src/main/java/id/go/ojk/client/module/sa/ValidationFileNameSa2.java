package id.go.ojk.client.module.sa;

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
import id.go.ojk.client.module.ValidationFileName2;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;
import id.go.ojk.lib.client.model.MonthDate;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

public class ValidationFileNameSa2 extends ValidationFileName2 {
	private final Logger logger = LoggerFactory.getLogger(ValidationFileNameSa2.class);

	public ValidationFileNameSa2(List<ValidFile> files, ReportInfo reportInfo, String memberCode,
			String memberTypeCode) {
		super(files, reportInfo, memberCode, memberTypeCode);
	}

	public ValidationFileNameSa2(List<ValidFile> files, ReportInfo reportInfo, String memberCode, String memberTypeCode,
			ProgressPreparationAndSending childProgress, ReadSubmissionDirModel readDirModel) {
		super(files, reportInfo, memberCode, memberTypeCode, childProgress, readDirModel);
	}

	@Override
	public boolean validate() {
		logger.info("Validator=" + this.getClass().getName());
		if (files != null && !files.isEmpty()) {
			ValidFile firstValidFile = files.get(0);
			String firstPeriodType = firstValidFile.getPart(3);
			String firstPeriodReport = firstValidFile.getPart(4);
			MonthDate firstMonthDate = getMontDate(firstPeriodReport);
			for (int i = 0; i < files.size(); i++) {
				List<String> listError = new ArrayList<>();
				ValidFile file = files.get(i);
				validatePart0(file, listError);
				validatePart2(file, listError);
				validatePart3(file, firstPeriodType, listError);
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

	protected boolean validatePart3(ValidFile file, String firstPeriodType, List<String> listError) {
		String part = file.getPart(3);
		String periode = reportInfo.getReportGroup().getPeriod();
		boolean res = periode.contains(part);
		if (!res) {
			listError.add("Nama file '" + file.getFullFileName() + "', Kode Jenis Periode harus "
					+ StringUtils.replace(periode, "|", " atau "));
		} else if (!part.equals(firstPeriodType)) {
			listError.add("Nama file '" + file.getFullFileName()
					+ "', Kode Jenis Periode Data Pelaporan tidak boleh berbeda dengan lainnya" + "");
			res = false;
		}
		return res;
	}

	@Override
	protected boolean validatePart4(ValidFile file, String firstPeriodReport, MonthDate firstMonthDate,
			List<String> listError) {
		boolean res = false;
		String periodeType = reportInfo.getReportGroup().getPeriod();
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
			} else {
				if (periodeType.equals("A")) {
					if (!part.endsWith("1231")) {
						listError.add("Nama file '" + fileName + "', Tanggal Periode Data Pelaporan '" + part
								+ "' tidak valid. Posisi tanggal harus tanggal 31 bulan Desember");
					} else {
						res = true;
					}
				}
			}
		}
		return res;
	}

	private MonthDate getMontDate(String periodReport) {
		MonthDate monthDate = null;
		if (StringUtils.isNotEmpty(periodReport) && periodReport.length() == 8) {
			monthDate = new MonthDate(periodReport.substring(0, 4));
		} else {
			monthDate = new MonthDate("");
		}
		return monthDate;
	}
}
