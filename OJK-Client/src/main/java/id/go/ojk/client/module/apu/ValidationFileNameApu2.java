package id.go.ojk.client.module.apu;

import java.util.List;

import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.module.ValidationFileName2;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;
import id.go.ojk.lib.client.model.MonthDate;

public class ValidationFileNameApu2 extends ValidationFileName2 {

	public ValidationFileNameApu2(List<ValidFile> files, ReportInfo reportInfo, String memberCode,
			String memberTypeCode) {
		super(files, reportInfo, memberCode, memberTypeCode);
	}

	public ValidationFileNameApu2(List<ValidFile> files, ReportInfo reportInfo, String memberCode, String memberTypeCode,
			ProgressPreparationAndSending childProgress, ReadSubmissionDirModel readDirModel) {
		super(files, reportInfo, memberCode, memberTypeCode, childProgress, readDirModel);
	}

	@Override
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
			} else {
				if (!part.endsWith("1231")) {
					listError.add("Nama file '" + fileName + "', Tanggal Periode Data Pelaporan '" + part
							+ "' tidak valid. Posisi tanggal harus tanggal 31 bulan Desember");
				} else {
					res = true;
				}
			}
		}
		return res;
	}
}
