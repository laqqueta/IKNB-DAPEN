package id.go.ojk.client.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EReportBySector {
	REPORT_RBASRJK (EReport.RB_ASRJK.getId(), Arrays.asList(ESector.ASRJK.getCode())),
	REPORT_RBASRUK (EReport.RB_ASRUK.getId(), Arrays.asList(ESector.ASRUK.getCode())),
	REPORT_RBREASK (EReport.RB_REASK.getId(), Arrays.asList(ESector.REASK.getCode())),
	REPORT_RBASRJU (EReport.RB_ASRJU.getId(), Arrays.asList(ESector.ASRJK.getCode())),
	REPORT_RBASRUU (EReport.RB_ASRUU.getId(), Arrays.asList(ESector.ASRUK.getCode())),
	REPORT_RBREASU (EReport.RB_REASU.getId(), Arrays.asList(ESector.REASK.getCode())),
	REPORT_RBPPK (EReport.RB_PPK.getId(), Arrays.asList(ESector.PPK.getCode())),
	REPORT_RBPPU (EReport.RB_PPU.getId(), Arrays.asList(ESector.PPK.getCode())),
	REPORT_RBDPPK (EReport.RB_DPPKK.getId(), Arrays.asList(ESector.DPPKK.getCode())),
	REPORT_RBDPPU (EReport.RB_DPPKU.getId(), Arrays.asList(ESector.DPPKK.getCode())),
	REPORT_RBDPLK (EReport.RB_DPLKK.getId(), Arrays.asList(ESector.DPLKK.getCode())),
	REPORT_RBPMVK (EReport.RB_PMVK.getId(), Arrays.asList(ESector.PMVK.getCode())),
	REPORT_RBPMVU (EReport.RB_PMVU.getId(), Arrays.asList(ESector.PMVK.getCode())),
	REPORT_RBASRJS (EReport.RB_ASRJS.getId(), Arrays.asList(ESector.ASRJS.getCode())),
	REPORT_RBREASS (EReport.RB_REASS.getId(), Arrays.asList(ESector.REASS.getCode())),
	REPORT_RBASRUS (EReport.RB_ASRUS.getId(), Arrays.asList(ESector.ASRUS.getCode())),
	REPORT_RBPPS (EReport.RB_PPS.getId(), Arrays.asList(ESector.PPS.getCode())),
	REPORT_RBDPPS (EReport.RB_DPPKS.getId(), Arrays.asList(ESector.DPPKS.getCode())),
	REPORT_RBDPLS (EReport.RB_DPLKS.getId(), Arrays.asList(ESector.DPLKS.getCode())),
	REPORT_RBPMVS (EReport.RB_PMVS.getId(), Arrays.asList(ESector.PMVS.getCode())),
	REPORT_LBASRJK (EReport.LB_ASRJK.getId(), Arrays.asList(ESector.ASRJK.getCode())),
	REPORT_LBASRUK (EReport.LB_ASRUK.getId(), Arrays.asList(ESector.ASRUK.getCode())),
	REPORT_LBREASK (EReport.LB_REASK.getId(), Arrays.asList(ESector.REASK.getCode())),
	REPORT_LBASRJS (EReport.LB_ASRJS.getId(), Arrays.asList(ESector.ASRJS.getCode())),
	REPORT_LBREASS (EReport.LB_REASS.getId(), Arrays.asList(ESector.REASS.getCode())),
	REPORT_LBASRUS (EReport.LB_ASRUS.getId(), Arrays.asList(ESector.ASRUS.getCode())),
	REPORT_LBPPIK (EReport.LB_PPIK.getId(), Arrays.asList(ESector.PPIK.getCode())),
	REPORT_LBPPIU (EReport.LB_PPIU.getId(), Arrays.asList(ESector.PPIU.getCode())),
	REPORT_LBPPIS (EReport.LB_PPIS.getId(), Arrays.asList(ESector.PPIS.getCode())),
	REPORT_LBPNMK (EReport.LB_PNMK.getId(), Arrays.asList(ESector.PNMK.getCode())),
	REPORT_LBPNMU (EReport.LB_PNMU.getId(), Arrays.asList(ESector.PNMU.getCode())),
	REPORT_LBPNJK (EReport.LB_PNJK.getId(), Arrays.asList(ESector.PNJK.getCode())),
	REPORT_LBPNJU (EReport.LB_PNJU.getId(), Arrays.asList(ESector.PNJU.getCode())),
	REPORT_LBPNJS (EReport.LB_PNJS.getId(), Arrays.asList(ESector.PNJS.getCode())),
	REPORT_SAASRJK (EReport.SA_ASRJK.getId(), Arrays.asList(ESector.ASRJK.getCode())),
	REPORT_SAASRJU (EReport.SA_ASRJU.getId(), Arrays.asList(ESector.ASRJK.getCode())),
	REPORT_SAASRUK (EReport.SA_ASRUK.getId(), Arrays.asList(ESector.ASRUK.getCode())),
	REPORT_SAASRUU (EReport.SA_ASRUU.getId(), Arrays.asList(ESector.ASRUK.getCode())),
	REPORT_SAREASK (EReport.SA_REASK.getId(), Arrays.asList(ESector.REASK.getCode())),
	REPORT_SAREASU (EReport.SA_REASU.getId(), Arrays.asList(ESector.REASK.getCode())),
	REPORT_SAPPK (EReport.SA_PPK.getId(), Arrays.asList(ESector.PPK.getCode())),
	REPORT_SAPPU (EReport.SA_PPU.getId(), Arrays.asList(ESector.PPK.getCode())),
	REPORT_SADPPK (EReport.SA_DPPKK.getId(), Arrays.asList(ESector.DPPKK.getCode())),
	REPORT_SADPPU (EReport.SA_DPPKU.getId(), Arrays.asList(ESector.DPPKK.getCode())),
	REPORT_SADPLK (EReport.SA_DPLKK.getId(), Arrays.asList(ESector.DPLKK.getCode())),
	REPORT_SAASRJS (EReport.SA_ASRJS.getId(), Arrays.asList(ESector.ASRJS.getCode())),
	REPORT_SAREASS (EReport.SA_REASS.getId(), Arrays.asList(ESector.REASS.getCode())),
	REPORT_SAASRUS (EReport.SA_ASRUS.getId(), Arrays.asList(ESector.ASRUS.getCode())),
	REPORT_SAPPS (EReport.SA_PPS.getId(), Arrays.asList(ESector.PPS.getCode())),
	REPORT_SADPPS (EReport.SA_DPPKS.getId(), Arrays.asList(ESector.DPPKS.getCode())),
	REPORT_SADPLS (EReport.SA_DPLKS.getId(), Arrays.asList(ESector.DPLKS.getCode())),
	REPORT_SAPPIK (EReport.SA_PPIK.getId(), Arrays.asList(ESector.PPIK.getCode())),
	REPORT_SAPPIS (EReport.SA_PPIS.getId(), Arrays.asList(ESector.PPIS.getCode())),
	REPORT_SAPPIU (EReport.SA_PPIU.getId(), Arrays.asList(ESector.PPIU.getCode())),
	REPORT_APUAJK (EReport.APU_ASRJK.getId(), Arrays.asList(ESector.ASRJK.getCode())),
	REPORT_APUAUK (EReport.APU_ASRUK.getId(), Arrays.asList(ESector.ASRUK.getCode())),
	REPORT_APUARK (EReport.APU_REASK.getId(), Arrays.asList(ESector.REASK.getCode())),
	REPORT_APUAJS (EReport.APU_ASRJS.getId(), Arrays.asList(ESector.ASRJS.getCode())),
	REPORT_APUAUS (EReport.APU_ASRUS.getId(), Arrays.asList(ESector.ASRUS.getCode())),
	REPORT_APUARS (EReport.APU_REASS.getId(), Arrays.asList(ESector.REASS.getCode())),
	REPORT_APUDLK (EReport.APU_DPLKK.getId(), Arrays.asList(ESector.DPLKK.getCode())),
	REPORT_APUDLS (EReport.APU_DPLKS.getId(), Arrays.asList(ESector.DPLKS.getCode())),
	REPORT_APUPPK (EReport.APU_PPK.getId(), Arrays.asList(ESector.PPK.getCode())),
	REPORT_APUPPS (EReport.APU_PPS.getId(), Arrays.asList(ESector.PPS.getCode())),
	REPORT_APUPVK (EReport.APU_PMVK.getId(), Arrays.asList(ESector.PMVK.getCode())),
	REPORT_APUPVS (EReport.APU_PMVS.getId(), Arrays.asList(ESector.PMVS.getCode())),
	REPORT_APUGDK (EReport.APU_GDK.getId(), Arrays.asList(ESector.GDK.getCode())),
	REPORT_APUGDS (EReport.APU_GDS.getId(), Arrays.asList(ESector.GDS.getCode())),
	REPORT_APUFINK (EReport.APU_FINK.getId(), Arrays.asList(ESector.LFINK.getCode())),
	REPORT_APUFINS (EReport.APU_FINS.getId(), Arrays.asList(ESector.LFINS.getCode())),
	REPORT_LFINK (EReport.LFINK.getId(), Arrays.asList(ESector.LFINK.getCode())),
	REPORT_LFINS (EReport.LFINS.getId(), Arrays.asList(ESector.LFINS.getCode())),
	REPORT_TPPFNK (EReport.TPP_FINK.getId(), Arrays.asList(ESector.LFINK.getCode())),
	REPORT_TPPFNS (EReport.TPP_FINS.getId(), Arrays.asList(ESector.LFINS.getCode())),
	REPORT_TPPPA (EReport.TPP_PA.getId(), Arrays.asList(ESector.PA.getCode())),
	REPORT_LBPEIK (EReport.LB_LPEIG.getId(), Arrays.asList(ESector.LPEIG.getCode())),
	REPORT_LBPEIU (EReport.LB_LPEIU.getId(), Arrays.asList(ESector.LPEIU.getCode())),
	REPORT_TLDPPKK (EReport.TL_DPPKK.getId(), Arrays.asList(ESector.DPPKK.getCode())),
	REPORT_TLDPPKU (EReport.TL_DPPKU.getId(), Arrays.asList(ESector.DPPKK.getCode())),
	REPORT_TLDPPKS (EReport.TL_DPPKS.getId(), Arrays.asList(ESector.DPPKS.getCode())),
	REPORT_TLDPLKK (EReport.TL_DPLKK.getId(), Arrays.asList(ESector.DPLKK.getCode())),
	REPORT_TLDPLKS (EReport.TL_DPLKS.getId(), Arrays.asList(ESector.DPLKS.getCode())),
	REPORT_PLSASRJK (EReport.PLS_ASRJK.getId(), Arrays.asList(ESector.ASRJK.getCode())),
	REPORT_PLSASRJU (EReport.PLS_ASRJU.getId(), Arrays.asList(ESector.ASRJU.getCode())),
	REPORT_PLSASRJS (EReport.PLS_ASRJS.getId(), Arrays.asList(ESector.ASRJS.getCode())),
	REPORT_PLSASRUK (EReport.PLS_ASRUK.getId(), Arrays.asList(ESector.ASRUK.getCode())),
	REPORT_PLSASRUU (EReport.PLS_ASRUU.getId(), Arrays.asList(ESector.ASRUU.getCode())),
	REPORT_PLSASRUS (EReport.PLS_ASRUS.getId(), Arrays.asList(ESector.ASRUS.getCode())),
	REPORT_LBBPKS (EReport.BPKSLB.getId(), Arrays.asList(ESector.BPKS.getCode())),
//	REPORT_LPBPTK (EReport.BPTKLP.getId(), Arrays.asList(ESector.BPTK.getCode())),
	REPORT_LBBPTK (EReport.BPTKLB.getId(), Arrays.asList(ESector.BPTK.getCode())),
//	REPORT_LTBPTK (EReport.BPTKLT.getId(), Arrays.asList(ESector.BPTK.getCode())),
//	REPORT_LABPTK (EReport.BPTKLA.getId(), Arrays.asList(ESector.BPTK.getCode())),
	;
	
	private String key;
	private List<String> value;
	
	public static Map<String, List<String>> getMap() {
		Map<String, List<String>> res = new HashMap<>();
		for (EReportBySector eEnum : EReportBySector.values()) {
			List<String> list = new ArrayList<>();
			list.addAll(eEnum.value);
			res.put(eEnum.key, list);
		}
		return res;
	}
}
