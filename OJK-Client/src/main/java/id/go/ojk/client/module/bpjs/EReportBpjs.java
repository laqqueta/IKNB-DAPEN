package id.go.ojk.client.module.bpjs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReportBpjs {
  /* --- BPKS KS --- */
  LBBPKSLK_RUTIN("LBBPKSLK", EReportGroupBpjs.LBBPKSLK_RUTIN, EReport.BPKSLB),
  LBBPKSLK_KOREKSI("LBBPKSLK", EReportGroupBpjs.LBBPKSLK_KOREKSI, EReport.BPKSLB),
  LBBPKSLK_KOREKSI_PENGAWAS("LBBPKSLK", EReportGroupBpjs.LBBPKSLK_KOREKSI_PENGAWAS, EReport.BPKSLB),
  LBBPKSDJS_RUTIN("LBBPKSDJS", EReportGroupBpjs.LBBPKSDJS_RUTIN, EReport.BPKSLB),
  LBBPKSDJS_KOREKSI("LBBPKSDJS", EReportGroupBpjs.LBBPKSDJS_KOREKSI, EReport.BPKSLB),
  LBBPKSDJS_KOREKSI_PENGAWAS("LBBPKSDJS", EReportGroupBpjs.LBBPKSDJS_KOREKSI_PENGAWAS, EReport.BPKSLB),
  LBBPKSLPP_RUTIN("LBBPKSLPP", EReportGroupBpjs.LBBPKSLPP_RUTIN, EReport.BPKSLB),
  LBBPKSLPP_KOREKSI("LBBPKSLPP", EReportGroupBpjs.LBBPKSLPP_KOREKSI, EReport.BPKSLB),
  LBBPKSLPP_KOREKSI_PENGAWAS("LBBPKSLPP", EReportGroupBpjs.LBBPKSLPP_KOREKSI_PENGAWAS, EReport.BPKSLB),

  /* --- BPKS TK --- */
  LBBPTKBDN_RUTIN("LBBPTKBDN", EReportGroupBpjs.LBBPTKBDN_RUTIN, EReport.BPTKLB),
  LBBPTKBDN_KOREKSI("LBBPTKBDN", EReportGroupBpjs.LBBPTKBDN_KOREKSI, EReport.BPTKLB),
  LBBPTKBDN_KOREKSI_PENGAWAS("LBBPTKBDN", EReportGroupBpjs.LBBPTKBDN_KOREKSI_PENGAWAS, EReport.BPTKLB),
  LBBPTKJKK_RUTIN("LBBPTKJKK", EReportGroupBpjs.LBBPTKJKK_RUTIN, EReport.BPTKLB),
  LBBPTKJKK_KOREKSI("LBBPTKJKK", EReportGroupBpjs.LBBPTKJKK_KOREKSI, EReport.BPTKLB),
  LBBPTKJKK_KOREKSI_PENGAWAS("LBBPTKJKK", EReportGroupBpjs.LBBPTKJKK_KOREKSI_PENGAWAS, EReport.BPTKLB),
  LBBPTKJK_RUTIN("LBBPTKJK", EReportGroupBpjs.LBBPTKJK_RUTIN, EReport.BPTKLB),
  LBBPTKJK_KOREKSI("LBBPTKJK", EReportGroupBpjs.LBBPTKJK_KOREKSI, EReport.BPTKLB),
  LBBPTKJK_KOREKSI_PENGAWAS("LBBPTKJK", EReportGroupBpjs.LBBPTKJK_KOREKSI_PENGAWAS, EReport.BPTKLB),
  LBBPTKJHT_RUTIN("LBBPTKJHT", EReportGroupBpjs.LBBPTKJHT_RUTIN, EReport.BPTKLB),
  LBBPTKJHT_KOREKSI("LBBPTKJHT", EReportGroupBpjs.LBBPTKJHT_KOREKSI, EReport.BPTKLB),
  LBBPTKJHT_KOREKSI_PENGAWAS("LBBPTKJHT", EReportGroupBpjs.LBBPTKJHT_KOREKSI_PENGAWAS, EReport.BPTKLB),
  LBBPTKJKP_RUTIN("LBBPTKJKP", EReportGroupBpjs.LBBPTKJKP_RUTIN, EReport.BPTKLB),
  LBBPTKJKP_KOREKSI("LBBPTKJKP", EReportGroupBpjs.LBBPTKJKP_KOREKSI, EReport.BPTKLB),
  LBBPTKJKP_KOREKSI_PENGAWAS("LBBPTKJKP", EReportGroupBpjs.LBBPTKJKP_KOREKSI_PENGAWAS, EReport.BPTKLB),
  LBBPTKJP_RUTIN("LBBPTKJP", EReportGroupBpjs.LBBPTKJP_RUTIN, EReport.BPTKLB),
  LBBPTKJP_KOREKSI("LBBPTKJP", EReportGroupBpjs.LBBPTKJP_KOREKSI, EReport.BPTKLB),
  LBBPTKJP_KOREKSI_PENGAWAS("LBBPTKJP", EReportGroupBpjs.LBBPTKJP_KOREKSI_PENGAWAS, EReport.BPTKLB),
  LPBPTKJKK_RUTIN("LPBPTKJKK", EReportGroupBpjs.LPBPTKJKK_RUTIN, EReport.BPTKLP),
  LPBPTKJKK_KOREKSI("LPBPTKJKK", EReportGroupBpjs.LPBPTKJKK_KOREKSI, EReport.BPTKLP),
  LPBPTKJKK_KOREKSI_PENGAWAS("LPBPTKJKK", EReportGroupBpjs.LPBPTKJKK_KOREKSI_PENGAWAS, EReport.BPTKLP),
  LPBPTKJK_RUTIN("LPBPTKJK", EReportGroupBpjs.LPBPTKJK_RUTIN, EReport.BPTKLP),
  LPBPTKJK_KOREKSI("LPBPTKJK", EReportGroupBpjs.LPBPTKJK_KOREKSI, EReport.BPTKLP),
  LPBPTKJK_KOREKSI_PENGAWAS("LPBPTKJK", EReportGroupBpjs.LPBPTKJK_KOREKSI_PENGAWAS, EReport.BPTKLP),
  LPBPTKJHT_RUTIN("LPBPTKJHT", EReportGroupBpjs.LPBPTKJHT_RUTIN, EReport.BPTKLP),
  LPBPTKJHT_KOREKSI("LPBPTKJHT", EReportGroupBpjs.LPBPTKJHT_KOREKSI, EReport.BPTKLP),
  LPBPTKJHT_KOREKSI_PENGAWAS("LPBPTKJHT", EReportGroupBpjs.LPBPTKJHT_KOREKSI_PENGAWAS, EReport.BPTKLP),
  LPBPTKJKP_RUTIN("LPBPTKJKP", EReportGroupBpjs.LPBPTKJKP_RUTIN, EReport.BPTKLP),
  LPBPTKJKP_KOREKSI("LPBPTKJKP", EReportGroupBpjs.LPBPTKJKP_KOREKSI, EReport.BPTKLP),
  LPBPTKJKP_KOREKSI_PENGAWAS("LPBPTKJKP", EReportGroupBpjs.LPBPTKJKP_KOREKSI_PENGAWAS, EReport.BPTKLP),
  LPBPTKJP_RUTIN("LPBPTKJP", EReportGroupBpjs.LPBPTKJP_RUTIN, EReport.BPTKLP),
  LPBPTKJP_KOREKSI("LPBPTKJP", EReportGroupBpjs.LPBPTKJP_KOREKSI, EReport.BPTKLP),
  LPBPTKJP_KOREKSI_PENGAWAS("LPBPTKJP", EReportGroupBpjs.LPBPTKJP_KOREKSI_PENGAWAS, EReport.BPTKLP),
  LTBPTKBDN_RUTIN("LTBPTKBDN", EReportGroupBpjs.LTBPTKBDN_RUTIN, EReport.BPTKLT),
  LTBPTKBDN_KOREKSI("LTBPTKBDN", EReportGroupBpjs.LTBPTKBDN_KOREKSI, EReport.BPTKLT),
  LTBPTKBDN_KOREKSI_PENGAWAS("LTBPTKBDN", EReportGroupBpjs.LTBPTKBDN_KOREKSI_PENGAWAS, EReport.BPTKLT),
  LTBPTKJKK_RUTIN("LTBPTKJKK", EReportGroupBpjs.LTBPTKJKK_RUTIN, EReport.BPTKLT),
  LTBPTKJKK_KOREKSI("LTBPTKJKK", EReportGroupBpjs.LTBPTKJKK_KOREKSI, EReport.BPTKLT),
  LTBPTKJKK_KOREKSI_PENGAWAS("LTBPTKJKK", EReportGroupBpjs.LTBPTKJKK_KOREKSI_PENGAWAS, EReport.BPTKLT),
  LTBPTKJK_RUTIN("LTBPTKJK", EReportGroupBpjs.LTBPTKJK_RUTIN, EReport.BPTKLT),
  LTBPTKJK_KOREKSI("LTBPTKJK", EReportGroupBpjs.LTBPTKJK_KOREKSI, EReport.BPTKLT),
  LTBPTKJK_KOREKSI_PENGAWAS("LTBPTKJK", EReportGroupBpjs.LTBPTKJK_KOREKSI_PENGAWAS, EReport.BPTKLT),
  LTBPTKJHT_RUTIN("LTBPTKJHT", EReportGroupBpjs.LTBPTKJHT_RUTIN, EReport.BPTKLT),
  LTBPTKJHT_KOREKSI("LTBPTKJHT", EReportGroupBpjs.LTBPTKJHT_KOREKSI, EReport.BPTKLT),
  LTBPTKJHT_KOREKSI_PENGAWAS("LTBPTKJHT", EReportGroupBpjs.LTBPTKJHT_KOREKSI_PENGAWAS, EReport.BPTKLT),
  LTBPTKJKP_RUTIN("LTBPTKJKP", EReportGroupBpjs.LTBPTKJKP_RUTIN, EReport.BPTKLT),
  LTBPTKJKP_KOREKSI("LTBPTKJKP", EReportGroupBpjs.LTBPTKJKP_KOREKSI, EReport.BPTKLT),
  LTBPTKJKP_KOREKSI_PENGAWAS("LTBPTKJKP", EReportGroupBpjs.LTBPTKJKP_KOREKSI_PENGAWAS, EReport.BPTKLT),
  LTBPTKJP_RUTIN("LTBPTKJP", EReportGroupBpjs.LTBPTKJP_RUTIN, EReport.BPTKLT),
  LTBPTKJP_KOREKSI("LTBPTKJP", EReportGroupBpjs.LTBPTKJP_KOREKSI, EReport.BPTKLT),
  LTBPTKJP_KOREKSI_PENGAWAS("LTBPTKJP", EReportGroupBpjs.LTBPTKJP_KOREKSI_PENGAWAS, EReport.BPTKLT),
  LABPTKJKK_RUTIN("LABPTKJKK", EReportGroupBpjs.LABPTKJKK_RUTIN, EReport.BPTKLA),
  LABPTKJKK_KOREKSI("LABPTKJKK", EReportGroupBpjs.LABPTKJKK_KOREKSI, EReport.BPTKLA),
  LABPTKJKK_KOREKSI_PENGAWAS("LABPTKJKK", EReportGroupBpjs.LABPTKJKK_KOREKSI_PENGAWAS, EReport.BPTKLA),
  LABPTKJK_RUTIN("LABPTKJK", EReportGroupBpjs.LABPTKJK_RUTIN, EReport.BPTKLA),
  LABPTKJK_KOREKSI("LABPTKJK", EReportGroupBpjs.LABPTKJK_KOREKSI, EReport.BPTKLA),
  LABPTKJK_KOREKSI_PENGAWAS("LABPTKJK", EReportGroupBpjs.LABPTKJK_KOREKSI_PENGAWAS, EReport.BPTKLA),
  LABPTKJHT_RUTIN("LABPTKJHT", EReportGroupBpjs.LABPTKJHT_RUTIN, EReport.BPTKLA),
  LABPTKJHT_KOREKSI("LABPTKJHT", EReportGroupBpjs.LABPTKJHT_KOREKSI, EReport.BPTKLA),
  LABPTKJHT_KOREKSI_PENGAWAS("LABPTKJHT", EReportGroupBpjs.LABPTKJHT_KOREKSI_PENGAWAS, EReport.BPTKLA),
  LABPTKJKP_RUTIN("LABPTKJKP", EReportGroupBpjs.LABPTKJKP_RUTIN, EReport.BPTKLA),
  LABPTKJKP_KOREKSI("LABPTKJKP", EReportGroupBpjs.LABPTKJKP_KOREKSI, EReport.BPTKLA),
  LABPTKJKP_KOREKSI_PENGAWAS("LABPTKJKP", EReportGroupBpjs.LABPTKJKP_KOREKSI_PENGAWAS, EReport.BPTKLA),
  LABPTKJP_RUTIN("LABPTKJP", EReportGroupBpjs.LABPTKJP_RUTIN, EReport.BPTKLA),
  LABPTKJP_KOREKSI("LABPTKJP", EReportGroupBpjs.LABPTKJP_KOREKSI, EReport.BPTKLA),
  LABPTKJP_KOREKSI_PENGAWAS("LABPTKJP", EReportGroupBpjs.LABPTKJP_KOREKSI_PENGAWAS, EReport.BPTKLA),
  ;

  @Getter
  private String reportTypeCode;
  @Getter
  private EReportGroupBpjs reportGroup;
  @Getter
  private EReport report;

  //12/11/2025 - Usulan UAT #49 BPJS Kesehatan
  private static final Pattern OP_PATTERN;
  static {
    // Build regex untuk split error message berdasarkan Comparation
    String patterns = Arrays.stream(Comparation.values())
            .filter(c -> c.getCode() != null && !c.getCode().isEmpty())
            .flatMap(c -> Arrays.asList(c.getCode(), c.getDesc()).stream())
            .map(Pattern::quote) // escape regex special chars
            .sorted((a, b) -> Integer.compare(b.length(), a.length())) // harus long-first
            .collect(Collectors.joining("|"));

    OP_PATTERN = Pattern.compile("\\s*(" + patterns + ")\\s*", Pattern.CASE_INSENSITIVE);
}

  public static ReportInfo getReportInfo(String reportCode, int reportMenuCode) {
    ReportInfo res = new ReportInfo();
    for (EReportBpjs eEnum : EReportBpjs.values()) {
      EReport eReport = eEnum.getReport();
      if (eReport.getCode().equals(reportCode) && eEnum.reportGroup.getMenuCode() == reportMenuCode) {
        res.setId(eEnum.name());
        res.setReport(eReport);
        res.setReportTypeCode(eEnum.getReportTypeCode());
        res.setReportGroup(eEnum.reportGroup.getObject());
        break;
      }
    }
    return res;
  }

  public static List<EReportBpjs> getByReport(List<EReport> reports) {
    List<EReportBpjs> result = new ArrayList<EReportBpjs>();
    for (EReportBpjs ereport : EReportBpjs.values()) {
      if (reports.contains(ereport.report))
        result.add(ereport);
    }
    return result;
  }

  public static EReportBpjs getByReportCode(String reportCode) {
    for (EReportBpjs eEnum : EReportBpjs.values()) {
      if (eEnum.getReportTypeCode().equals(reportCode)) {
        return eEnum;
      }
    }
    return null;
  }

  //12/11/2025 - Usulan UAT #49 BPJS Kesehatan
  public String formatErrorMessage(ValidationError validationError, ValidationErrorCode validationErrorCode) {
    if(validationErrorCode != ValidationErrorCode.E50_02_FORMULA) {
      return validationError.description;
    }

    Object[] args = validationError.getErrorArgs();
    if(args == null || args.length != 2) {
      return validationError.description;
    }

    if(args[0] == null || args[1] == null) {
      return validationError.description;
    }

    String[] argsAsString = split3(args[1].toString());

    if(argsAsString == null)
      return validationError.description;
    return String.format("nilai %s harus %s %s", argsAsString[0], argsAsString[1], argsAsString[2]);
  }

  private static String[] split3(String input) {
    Matcher m = OP_PATTERN.matcher(input);
    if (m.find()) {
      String op = m.group(1);
      String left = input.substring(0, m.start()).trim();
      String right = input.substring(m.end()).trim();
      return new String[] { left, op, right };
    }
    return null;
  }
}
