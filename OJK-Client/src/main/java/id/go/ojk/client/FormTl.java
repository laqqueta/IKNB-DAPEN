package id.go.ojk.client;

import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.module.tl.EReportGroupTl;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.client.vc.HomeMetroTlController;
import id.go.ojk.client.vc.PreparationAndSendingTlController;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import javafx.scene.layout.BorderPane;

public class FormTl extends BaseCustomForm {
	private Tupple2<BorderPane, HomeMetroTlController> home;
	private Tupple2<BorderPane, PreparationAndSendingTlController> pelaporan;
	private Tupple2<BorderPane, PreparationAndSendingTlController> penyesuaian;

	public FormTl(ApplicationContext appContext, MainApplication mainApplication) {
		super(appContext, mainApplication);
	}

	@Override
	protected void init() {
	}

	public Tupple2<BorderPane, HomeMetroTlController> getHome(UserSession userSession) {
		if (home == null) {
			showHome(userSession);
		}
		return home;
	}

	public void cleanUp() {
		home = null;
	}

	public Tupple2<BorderPane, PreparationAndSendingTlController> getPelaporan() {
		return pelaporan;
	}

	public Tupple2<BorderPane, PreparationAndSendingTlController> getPenyesuaian() {
		return penyesuaian;
	}

	public void showHome(UserSession userSession) {
		String fxml = "vc/HomeMetroTl.fxml";
		home = UtilForm.initAndShowPane(mainApplication, fxml, home, null, null, null);
	}

	public void showPelaporan() {
		pelaporan = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingTl.fxml", pelaporan,
				DisplayScene.pelaporanPreparationTl,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_TL1, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupTl.PELAPORAN.getMenuCode()),
				null);
	}

	public void showPenyesuaian() {
		penyesuaian = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingTl.fxml", penyesuaian,
				DisplayScene.koreksiPreparationTl,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_TL1, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupTl.PELAPORAN_KOREKSI.getMenuCode()),
				null);
	}

	public void progressSegment(ProgressSegment progressSegment, int reportFormGroupCode) {
		switch (reportFormGroupCode) {
		case 0:
			pelaporan.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		case 1:
			penyesuaian.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		default:
			break;
		}
	}
}
