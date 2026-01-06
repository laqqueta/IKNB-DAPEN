package id.go.ojk.client;

import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.module.tpp.EReportGroupTpp;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.client.vc.*;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import javafx.scene.layout.BorderPane;

public class FormTpp extends BaseCustomForm {
	private Tupple2<BorderPane, HomeMetroTppController> home;

	private Tupple2<BorderPane, PreparationAndSendingTppController> penilaian;
	private Tupple2<BorderPane, PreparationAndSendingTppController> rencana;
	private Tupple2<BorderPane, PreparationAndSendingTppController> realisasi;

	public FormTpp(ApplicationContext appContext, MainApplication mainApplication) {
		super(appContext, mainApplication);
	}

	@Override
	protected void init() {
	}

	public Tupple2<BorderPane, HomeMetroTppController> getHome(UserSession userSession) {
		if (home == null) {
			showHome(userSession);
		}
		return home;
	}

//	public Tupple2<BorderPane, HomeMetroTppController> getHome3(UserSession userSession) {
//		if (home3 == null) {
//			showHome(userSession);
//		}
//		return home3;
//	}

	public void cleanUp() {
		home = null;
//		home3 = null;
	}

	public Tupple2<BorderPane, PreparationAndSendingTppController> getPenilaian() {
		return penilaian;
	}

	public Tupple2<BorderPane, PreparationAndSendingTppController> getRencana() {
		return rencana;
	}

	public Tupple2<BorderPane, PreparationAndSendingTppController> getRealisasi() {
		return realisasi;
	}

	public void showHome(UserSession userSession) {
		String reportCode = userSession != null ? userSession.getReportCode() : "";
		String fxml = getHomeFxml(reportCode);

		home = UtilForm.initAndShowPane(mainApplication, fxml, home, null, null, null);
	}
	
	private String getHomeFxml(String reportCode) {
		return "vc/HomeMetroTpp.fxml";
	}

	public void showPenilaianResiko() {
		penilaian = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingTpp.fxml", penilaian,
				DisplayScene.penilaianPreprationTpp,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_TPP, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupTpp.PENILAIAN_RESIKO_RUTIN.getMenuCode()),
				null);
	}

	public void showRencana() {
		rencana = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingTpp.fxml", rencana,
				DisplayScene.rencanaPrepartionTpp,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_TPP, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupTpp.RENCANA_RUTIN.getMenuCode()),
				null);
	}

	public void showRealisasi() {
		realisasi = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingTpp.fxml", realisasi,
				DisplayScene.realisasiPreprationTpp,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_TPP, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupTpp.REALISASI_RUTIN.getMenuCode()),
				null);
	}

	public void progressSegment(ProgressSegment progressSegment, int reportFormGroupCode) {
		switch (reportFormGroupCode) {
		case 1:
		case 2:
			rencana.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		case 3:
		case 4:
			realisasi.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		case 5:
		case 6:
			penilaian.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		default:
			break;
		}
	}
}
