package id.go.ojk.client;

import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.module.lbk.EReportGroupLbk;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.client.vc.HomeMetroLbkController;
import id.go.ojk.client.vc.PreparationAndSendingLbkController;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import javafx.scene.layout.BorderPane;

public class FormLbk extends BaseCustomForm {
	private Tupple2<BorderPane, HomeMetroLbkController> home;
	private Tupple2<BorderPane, PreparationAndSendingLbkController> bulanan;
	private Tupple2<BorderPane, PreparationAndSendingLbkController> tahunan;

	public FormLbk(ApplicationContext appContext, MainApplication mainApplication) {
		super(appContext, mainApplication);
	}

	@Override
	protected void init() {
	}

	public Tupple2<BorderPane, HomeMetroLbkController> getHome(UserSession userSession) {
		if (home == null) {
			showHome(userSession);
		}
		return home;
	}

	public void cleanUp() {
		home = null;
	}

	public Tupple2<BorderPane, PreparationAndSendingLbkController> getPelaporanBulanan() {
		return bulanan;
	}

	public Tupple2<BorderPane, PreparationAndSendingLbkController> getPelaporanTahunan() {
		return tahunan;
	}

	public void showHome(UserSession userSession) {
		String fxml = "vc/HomeMetroLbk.fxml";
		home = UtilForm.initAndShowPane(mainApplication, fxml, home, null, null, null);
	}

	public void showPelaporanBulanan() {
		bulanan = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingLbk.fxml", bulanan,
				DisplayScene.lbkBulananPreparation,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_LT1, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupLbk.PELAPORAN_BULANAN.getMenuCode()),
				null);
	}

	public void showPelaporanTahunan() {
		tahunan = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingLbk.fxml", tahunan,
				DisplayScene.lbkTahunanPreparation,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_LT1, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupLbk.PELAPORAN_TAHUNAN.getMenuCode()),
				null);
	}

	public void progressSegment(ProgressSegment progressSegment, int reportFormGroupCode) {
		switch (reportFormGroupCode) {
		case 1:
			bulanan.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		case 3:
			tahunan.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		default:
			break;
		}
	}
}
