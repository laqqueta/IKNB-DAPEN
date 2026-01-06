package id.go.ojk.client;

import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.module.pls.EReportGroupPls;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.client.vc.HomeMetroPlsController;
import id.go.ojk.client.vc.PreparationAndSendingPlsController;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import javafx.scene.layout.BorderPane;

public class FormPls extends BaseCustomForm {
	private Tupple2<BorderPane, HomeMetroPlsController> home;
	private Tupple2<BorderPane, PreparationAndSendingPlsController> pelaporan;
	private Tupple2<BorderPane, PreparationAndSendingPlsController> koreksi;

	public FormPls(ApplicationContext appContext, MainApplication mainApplication) {
		super(appContext, mainApplication);
	}

	@Override
	protected void init() {
	}

	public Tupple2<BorderPane, HomeMetroPlsController> getHome(UserSession userSession) {
		if (home == null) {
			showHome(userSession);
		}
		return home;
	}

	public void cleanUp() {
		home = null;
	}

	public Tupple2<BorderPane, PreparationAndSendingPlsController> getPelaporan() {
		return pelaporan;
	}

	public Tupple2<BorderPane, PreparationAndSendingPlsController> getPenyesuaian() {
		return koreksi;
	}

	public void showHome(UserSession userSession) {
		String fxml = "vc/HomeMetroPls.fxml";
		home = UtilForm.initAndShowPane(mainApplication, fxml, home, null, null, null);
	}

	public void showPelaporan() {
		pelaporan = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingPls.fxml", pelaporan,
				DisplayScene.pelaporanPreparationPls,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_PLS, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupPls.PELAPORAN.getMenuCode()),
				null);
	}

	public void showKoreksi() {
		koreksi = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingPls.fxml", koreksi,
				DisplayScene.koreksiPreparationPls,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_PLS, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupPls.PELAPORAN_KOREKSI.getMenuCode()),
				null);
	}

	public void progressSegment(ProgressSegment progressSegment, int reportFormGroupCode) {
		switch (reportFormGroupCode) {
		case 0:
			pelaporan.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		case 1:
			koreksi.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		default:
			break;
		}
	}
}
