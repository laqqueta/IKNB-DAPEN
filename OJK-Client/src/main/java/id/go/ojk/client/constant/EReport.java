package id.go.ojk.client.constant;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReport {
	RB_ASRJK ("5897", "RBAJK", EReportGroup.RB, ESector.ASRJK),
	RB_ASRUK ("5896", "RBAUK", EReportGroup.RB, ESector.ASRUK),
	RB_REASK ("5900", "RBRAK", EReportGroup.RB, ESector.REASK),
	RB_PPK ("1001", "LRBPPK", EReportGroup.RB, ESector.PPK),
	RB_DPPKK ("1002", "RBDPK", EReportGroup.RB, ESector.DPPKK),
	RB_DPLKK ("1003", "RBDLK", EReportGroup.RB, ESector.DPLKK),
	RB_PMVK ("1004", "RBPVK", EReportGroup.RB, ESector.PMVK),
	RB_ASRJS ("1005", "RBAJS", EReportGroup.RB, ESector.ASRJS),
	RB_ASRUS ("1006", "RBAUS", EReportGroup.RB, ESector.ASRUS),
	RB_REASS ("1007", "RBRAS", EReportGroup.RB, ESector.REASS),
	RB_PPS ("1008", "LRBPPS", EReportGroup.RB, ESector.PPS),
	RB_PPU ("1009", "LRBPPU", EReportGroup.RB, ESector.PPU),
	RB_DPPKS ("1010", "RBDPS", EReportGroup.RB, ESector.DPPKS),
	RB_DPLKS ("1011", "RBDLS", EReportGroup.RB, ESector.DPLKS),
	RB_PMVS ("1012", "RBPVS", EReportGroup.RB, ESector.PMVS),
	RB_PMVU ("1013", "RBPVU", EReportGroup.RB, ESector.PMVU),
	RB_ASRJU ("1014", "RBAJUS", EReportGroup.RB, ESector.ASRJU),
	RB_ASRUU ("1015", "RBAUUS", EReportGroup.RB, ESector.ASRUU),
	RB_REASU ("1016", "RBRAUS", EReportGroup.RB, ESector.REASU),
	RB_DPPKU ("1017", "RBDPU", EReportGroup.RB, ESector.DPPKU),
	LB_ASRJK ("2010", "LBAJK", EReportGroup.LB, ESector.ASRJK),
	LB_ASRUK ("2011", "LBAUK", EReportGroup.LB, ESector.ASRUK),
	LB_REASK ("2012", "LBRAK", EReportGroup.LB, ESector.REASK),
	LB_ASRJS ("2013", "LBAJS", EReportGroup.LB, ESector.ASRJS),
	LB_ASRUS ("2014", "LBAUS", EReportGroup.LB, ESector.ASRUS),
	LB_REASS ("2015", "LBRAS", EReportGroup.LB, ESector.REASS),
	LB_PPIK ("2016", "LBPIK", EReportGroup.LB, ESector.PPIK),
	LB_PPIU ("2017", "LBPIU", EReportGroup.LB, ESector.PPIU),
	LB_PPIS ("2018", "LBPIS", EReportGroup.LB, ESector.PPIS),
	LB_PNMK ("2019", "LBPNK", EReportGroup.LB, ESector.PNMK),
	LB_PNMU ("2020", "LBPNU", EReportGroup.LB, ESector.PNMU),
	LB_LPEIG ("2023", "LBLPIG", EReportGroup.LB, ESector.LPEIG),
	LB_LPEIU ("2024", "LBLPIU", EReportGroup.LB, ESector.LPEIU),
	LB_PNJK ("2025", "LBPNJK", EReportGroup.LB, ESector.PNJK),
	LB_PNJU ("2026", "LBPNJU", EReportGroup.LB, ESector.PNJU),
	LB_PNJS ("2027", "LBPNJS", EReportGroup.LB, ESector.PNJS),
	SA_ASRJK ("3016", "SAJK", EReportGroup.SA, ESector.ASRJK),
	SA_ASRUK ("3017", "SAUK", EReportGroup.SA, ESector.ASRUK),
	SA_REASK ("3018", "SARK", EReportGroup.SA, ESector.REASK),
	SA_ASRJU ("3019", "SAJU", EReportGroup.SA, ESector.ASRJU),
	SA_ASRUU ("3020", "SAUU", EReportGroup.SA, ESector.ASRUU),
	SA_REASU ("3021", "SARU", EReportGroup.SA, ESector.REASU),
	SA_ASRJS ("3022", "SAJS", EReportGroup.SA, ESector.ASRJS),
	SA_ASRUS ("3023", "SAUS", EReportGroup.SA, ESector.ASRUS),
	SA_REASS ("3024", "SARS", EReportGroup.SA, ESector.REASS),
	SA_DPPKK ("3025", "SDPK", EReportGroup.SA, ESector.DPPKK),
	SA_DPLKK ("3026", "SDLK", EReportGroup.SA, ESector.DPLKK),
	SA_DPPKU ("3027", "SDPU", EReportGroup.SA, ESector.DPPKU),
	SA_DPPKS ("3028", "SDPS", EReportGroup.SA, ESector.DPPKS),
	SA_DPLKS ("3029", "SDLS", EReportGroup.SA, ESector.DPLKS),
	SA_PPK ("3030", "SPPK", EReportGroup.SA, ESector.PPK),
	SA_PPU ("3031", "SPPU", EReportGroup.SA, ESector.PPU),
	SA_PPS ("3032", "SPPS", EReportGroup.SA, ESector.PPS),
	SA_PPIK("3033", "SPPIG", EReportGroup.SA, ESector.PPIK),
	SA_PPIS("3034", "SPPIS", EReportGroup.SA, ESector.PPIS),
	SA_PPIU("3035", "SPPIU", EReportGroup.SA, ESector.PPIU),
	APU_ASRJK ("4000", "APUAJK", EReportGroup.APU, ESector.ASRJK),
	APU_ASRUK ("4001", "APUAUK", EReportGroup.APU, ESector.ASRUK),
	APU_REASK ("4002", "APUARK", EReportGroup.APU, ESector.REASK),
	APU_ASRJS ("4003", "APUAJS", EReportGroup.APU, ESector.ASRJS),
	APU_ASRUS ("4004", "APUAUS", EReportGroup.APU, ESector.ASRUS),
	APU_REASS ("4005", "APUARS", EReportGroup.APU, ESector.REASS),
	APU_DPLKK ("4006", "APUDLK", EReportGroup.APU, ESector.DPLKK),
	APU_DPLKS ("4007", "APUDLS", EReportGroup.APU, ESector.DPLKS),
	APU_PPK ("4008", "APUPPK", EReportGroup.APU, ESector.PPK),
	APU_PPS ("4009", "APUPPS", EReportGroup.APU, ESector.PPS),
	APU_PMVK ("4010", "APUPVK", EReportGroup.APU, ESector.PMVK),
	APU_PMVS ("4011", "APUPVS", EReportGroup.APU, ESector.PMVS),
	APU_GDK ("4012", "APUGDK", EReportGroup.APU, ESector.GDK),
	APU_GDS ("4013", "APUGDS", EReportGroup.APU, ESector.GDS),
	APU_FINK ("4014", "APUFNK", EReportGroup.APU, ESector.LFINK),
	APU_FINS ("4015", "APUFNS", EReportGroup.APU, ESector.LFINS),
	LFINK ("5000", "LFINK", EReportGroup.LBK, ESector.LFINK),
	LFINS ("5001", "LFINS", EReportGroup.LBK, ESector.LFINS),
	TPP_FINK("5010", "TPPFNK", EReportGroup.TPP, ESector.LFINK),
	TPP_FINS("5011", "TPPFNS", EReportGroup.TPP, ESector.LFINS),
	TPP_PA("5020", "TPPPA", EReportGroup.TPP, ESector.PA),
	TL_DPPKK ("6000", "TLRDPK", EReportGroup.TL, ESector.DPPKK),
	TL_DPPKU ("6001", "TLRDPU", EReportGroup.TL, ESector.DPPKU),
	TL_DPPKS ("6002", "TLRDPS", EReportGroup.TL, ESector.DPPKS),
	TL_DPLKK ("6003", "TLRDLK", EReportGroup.TL, ESector.DPLKK),
	TL_DPLKS ("6004", "TLRDLS", EReportGroup.TL, ESector.DPLKS),
	PLS_ASRJK ("7001", "PLSAJK", EReportGroup.PLS, ESector.ASRJK),
	PLS_ASRJU ("7002", "PLSAJU", EReportGroup.PLS, ESector.ASRJU),
	PLS_ASRJS ("7003", "PLSAJS", EReportGroup.PLS, ESector.ASRJS),
	PLS_ASRUK ("7004", "PLSAUK", EReportGroup.PLS, ESector.ASRUK),
	PLS_ASRUU ("7005", "PLSAUU", EReportGroup.PLS, ESector.ASRUU),
	PLS_ASRUS ("7006", "PLSAUS", EReportGroup.PLS, ESector.ASRUS),
	BPKSLB ("7100", "LBBPKS", EReportGroup.BPKSLB, ESector.BPKS),
	BPTKLP ("7130", "LPBPTK", EReportGroup.BPTKLPP, ESector.BPTK),
	BPTKLB ("7120", "LBBPTK", EReportGroup.BPTKLKB, ESector.BPTK),
	BPTKLT ("7140", "LTBPTK", EReportGroup.BPTKLKT, ESector.BPTK),
	BPTKLA ("7150", "LABPTK", EReportGroup.BPTKLAT, ESector.BPTK),
    LKTB_DPPKK("7510", "LKDPK", EReportGroup.LKTB, ESector.DPPKK),
    LKTB_DPPKS("7520", "LKDPS", EReportGroup.LKTB, ESector.DPPKS),
    LKTB_DPLKK("7530", "LKDLK", EReportGroup.LKTB, ESector.DPLKK),
    LKTB_DPLKS("7540", "LKDLS", EReportGroup.LKTB, ESector.DPLKS),

	;
	
	@Getter
	private String id;
	@Getter
	private String code;
	@Getter
	private EReportGroup reportGroup;
	@Getter
	private ESector sector;
	
	public static Map<String, String> getMap() {
		Map<String, String> res = new HashMap<>();
		for (EReport eEnum : EReport.values()) {
			String key = eEnum.id + "|" + eEnum.code;
			res.put(key, eEnum.reportGroup.getName() + " " + eEnum.getSector().getName());
		}
		return res;
	}
	
	public static EReport getReportByCode(String reportCode) {
		EReport res = null;
		for (EReport eEnum : EReport.values()) {
			if (eEnum.code.equals(reportCode)) {
				res = eEnum;
				break;
			}
		}
		return res;
	}
	
	public static boolean isRb(String reportCode) {
		EReport eEnum = getReportByCode(reportCode);
		return eEnum != null && eEnum.getReportGroup() == EReportGroup.RB;
	}
	
	public static boolean isLb(String reportCode) {
		EReport eEnum = getReportByCode(reportCode);
		return eEnum != null && eEnum.getReportGroup() == EReportGroup.LB;
	}
	
	public static boolean isLt(String reportCode) {
		EReport eEnum = getReportByCode(reportCode);
		return eEnum != null && eEnum.getReportGroup() == EReportGroup.LT;
	}
	
	public static boolean isLbk(String reportCode) {
		EReport eEnum = getReportByCode(reportCode);
		return eEnum != null && eEnum.getReportGroup() == EReportGroup.LBK;
	}
	
	public static boolean isSa(String reportCode) {
		EReport eEnum = getReportByCode(reportCode);
		return eEnum != null && eEnum.getReportGroup() == EReportGroup.SA;
	}
	
	public static boolean isApu(String reportCode) {
		EReport eEnum = getReportByCode(reportCode);
		return eEnum != null && eEnum.getReportGroup() == EReportGroup.APU;
	}

	public static boolean isTl(String reportCode) {
		EReport eEnum = getReportByCode(reportCode);
		return eEnum != null && eEnum.getReportGroup() == EReportGroup.TL;
	}

	public static boolean isPls(String reportCode) {
		EReport eEnum = getReportByCode(reportCode);
		return eEnum != null && eEnum.getReportGroup() == EReportGroup.PLS;
	}

	public static boolean isTpp(String reportCode) {
		EReport eEnum = getReportByCode(reportCode);
		return eEnum != null && eEnum.getReportGroup() == EReportGroup.TPP;
	}

	public static boolean isUus(String reportCode) {
		EReport eEnum = getReportByCode(reportCode);
		return eEnum != null && eEnum.getSector().getType().equals(ESectorType.UUS);
	}
	
	public static boolean isPnm(String reportCode) {
		EReport eEnum = getReportByCode(reportCode);
		return eEnum != null && (eEnum.getSector().equals(ESector.PNMK) || eEnum.getSector().equals(ESector.PNMU));
	}
	
	public static boolean isPnj(String reportCode) {
		EReport eEnum = getReportByCode(reportCode);
		return eEnum != null && (eEnum.getSector().equals(ESector.PNJK) || eEnum.getSector().equals(ESector.PNJS) ||
				eEnum.getSector().equals(ESector.PNJU));
	}
	
	public static boolean isFin(String reportCode) {
		EReport eEnum = getReportByCode(reportCode);
		return eEnum != null && (eEnum.getSector().equals(ESector.LFINK) || eEnum.getSector().equals(ESector.LFINS));
	}
	
	public static boolean isApuFin(String reportCode) {
		return reportCode.equals(APU_FINK.getCode()) || reportCode.equals(APU_FINS.getCode());
	}
	
	public static boolean isLbPnj(String reportCode) {
		return reportCode.equals(LB_PNJK.getCode()) || reportCode.equals(LB_PNJS.getCode()) || reportCode.equals(LB_PNJU.getCode());
	}
	
	public static boolean isBpjsKs(String reportCode) {
	  return reportCode.equals(BPKSLB.getCode());
	}
	
  public static boolean isBpjsTk(String reportCode) {
    return reportCode.equals(BPTKLB.getCode()) || reportCode.equals(BPTKLP.getCode()) || 
        reportCode.equals(BPTKLA.getCode()) || reportCode.equals(BPTKLT.getCode());
  }
    public static boolean isLktb(String reportCode) {
        return reportCode.equals(LKTB_DPPKK.getCode()) || reportCode.equals(LKTB_DPPKS.getCode()) ||
                reportCode.equals(LKTB_DPLKK.getCode()) || reportCode.equals(LKTB_DPLKS.getCode());
    }

	public static boolean useApi(String reportCode) {
		String tmp = reportCode;
		if (reportCode.contains("|")) {
			tmp = StringUtils.split(reportCode, '|')[1];
		}
		for (EReport eEnum : EReport.values()) {
			if (eEnum.getCode().equals(tmp) && eEnum.getReportGroup().equals(EReportGroup.PLS)) {
				return true;
			} else if (eEnum.getCode().equals(tmp) && (eEnum.getReportGroup().equals(EReportGroup.BPKSLB)
			    || eEnum.getReportGroup().equals(EReportGroup.BPTKLKB)
			    || eEnum.getReportGroup().equals(EReportGroup.BPTKLKT)
			    || eEnum.getReportGroup().equals(EReportGroup.BPTKLPP)
          || eEnum.getReportGroup().equals(EReportGroup.BPTKLAT))) {
			  return true;
			}
		}
		return false;
	}
}
