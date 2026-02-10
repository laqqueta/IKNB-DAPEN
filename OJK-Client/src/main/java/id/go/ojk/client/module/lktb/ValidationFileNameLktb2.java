package id.go.ojk.client.module.lktb;

import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.module.ValidationFileName2;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;
import id.go.ojk.lib.client.model.MonthDate;

import java.util.List;

public class ValidationFileNameLktb2 extends ValidationFileName2 {
  protected String lastValidPeriod = null;

  public ValidationFileNameLktb2(List<ValidFile> files, ReportInfo reportInfo, String memberCode,
                                 String memberTypeCode) {
    super(files, reportInfo, memberCode, memberTypeCode);
  }

  public ValidationFileNameLktb2(List<ValidFile> files, ReportInfo reportInfo, String memberCode, String memberTypeCode,
                                 ProgressPreparationAndSending childProgress, ReadSubmissionDirModel readDirModel) {
    super(files, reportInfo, memberCode, memberTypeCode, childProgress, readDirModel);
  }

  @Override
  protected boolean validatePart4(ValidFile file, String firstPeriodReport, MonthDate firstMonthDate, List<String> listError) {
    boolean res = false;
    String part = file.getPart(4);
    String fileName = file.getFullFileName();
    MonthDate monthDate = this.getMonthDate(part);
    if (part.length() != 8) {
      listError.add("Nama file '" + fileName + "', Periode Data Pelaporan '" + part
          + "' tidak valid. Gunakan format YYYYMMDD" + "");
    } else if (!monthDate.yearsIsNumeric()) {
      listError.add("Nama file '" + fileName + "', Tahun Data Pelaporan '" + part
          + "' tidak valid. Gunakan format YYYYMMDD" + "");
    } else {
      String month = part.substring(4, 6);
      if (!monthDate.getMapMonthDate().containsKey(month)) {
        listError.add("Nama file '" + fileName + "', Bulan Data Pelaporan '" + part
            + "' tidak valid. Gunakan format YYYYMMDD" + "");
      } else if (!part.substring(6, 8).equals(monthDate.getMapMonthDate().get(month))) {
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
        } else if (lastValidPeriod != null && !part.equals(lastValidPeriod)) {
          listError.add("Nama file '" + fileName + "', Periode Data Pelaporan tidak boleh berbeda dengan lainnya" + "");
        } else {
          lastValidPeriod = part;
          res = true;
        }
      }
    }
    return res;
  }
}
