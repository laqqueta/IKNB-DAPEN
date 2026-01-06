package id.go.ojk.client;

import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.module.apu.EReportGroupApu;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.client.vc.HomeMetroApuController;
import id.go.ojk.client.vc.HomeMetroApuController3;
import id.go.ojk.client.vc.PreparationAndSendingApuController;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import javafx.scene.layout.BorderPane;

public class FormApu extends BaseCustomForm {
	private Tupple2<BorderPane, HomeMetroApuController> home;
	private Tupple2<BorderPane, HomeMetroApuController3> home3;
	private Tupple2<BorderPane, PreparationAndSendingApuController> penilaian;
	private Tupple2<BorderPane, PreparationAndSendingApuController> rencana;
	private Tupple2<BorderPane, PreparationAndSendingApuController> realisasi;

	public FormApu(ApplicationContext appContext, MainApplication mainApplication) {
		super(appContext, mainApplication);
	}

	@Override
	protected void init() {
	}

	public Tupple2<BorderPane, HomeMetroApuController> getHome(UserSession userSession) {
		if (home == null) {
			showHome(userSession);
		}
		return home;
	}

	public Tupple2<BorderPane, HomeMetroApuController3> getHome3(UserSession userSession) {
		if (home3 == null) {
			showHome(userSession);
		}
		return home3;
	}

	public void cleanUp() {
		home = null;
		home3 = null;
	}

	public Tupple2<BorderPane, PreparationAndSendingApuController> getPenilaian() {
		return penilaian;
	}

	public Tupple2<BorderPane, PreparationAndSendingApuController> getRencana() {
		return rencana;
	}

	public Tupple2<BorderPane, PreparationAndSendingApuController> getRealisasi() {
		return realisasi;
	}

	public void showHome(UserSession userSession) {
		String reportCode = userSession != null ? userSession.getReportCode() : "";
		String fxml = getHomeFxml(reportCode);
		if (reportCode.equals(EReport.APU_FINK.getCode()) || reportCode.equals(EReport.APU_FINS.getCode())) {
			home3 = UtilForm.initAndShowPane(mainApplication, fxml, home3, null, null, null);
		} else {
			home = UtilForm.initAndShowPane(mainApplication, fxml, home, null, null, null);
		}
	}
	
	private String getHomeFxml(String reportCode) {
		String res = "vc/HomeMetroApu.fxml";
		if (reportCode.equals(EReport.APU_ASRUK.getCode()) || reportCode.equals(EReport.APU_ASRUS.getCode())) {
			res = "vc/HomeMetroApu2.fxml";
		} else if (reportCode.equals(EReport.APU_FINK.getCode()) || reportCode.equals(EReport.APU_FINS.getCode())) {
			res = "vc/HomeMetroApu3.fxml";
		}
		return res;
	}

	public void showPenilaian() {
		penilaian = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingApu.fxml", penilaian,
				DisplayScene.penilaianPreparationApu,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_APU1, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupApu.PENILAIAN_RUTIN.getMenuCode()),
				null);
	}

	public void showPenilaian2() {
		penilaian = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingApu2.fxml", penilaian,
				DisplayScene.penilaianPreparationApu2,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_APU1, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupApu.PENILAIAN_RUTIN_2.getMenuCode()),
				null);
	}

	public void showRencana() {
		rencana = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingApu.fxml", rencana,
				DisplayScene.rencanaPreparationApu,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_APU2, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupApu.RENCANA_RUTIN.getMenuCode()),
				null);
	}

	public void showRealisasi() {
		realisasi = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingApu.fxml", realisasi,
				DisplayScene.realisasiPreparationApu,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_APU3, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupApu.REALISASI_RUTIN.getMenuCode()),
				null);
	}

	public void progressSegment(ProgressSegment progressSegment, int reportFormGroupCode) {
		switch (reportFormGroupCode) {
		case 1:
		case 2:
			penilaian.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		case 3:
		case 4:
			rencana.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		case 5:
		case 6:
			realisasi.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		default:
			break;
		}
	}
}
