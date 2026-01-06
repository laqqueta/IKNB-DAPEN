package id.go.ojk.client;

import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.module.sa.EReportGroupSa;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.client.vc.HomeMetroSaController;
import id.go.ojk.client.vc.PreparationAndSendingSaController;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import javafx.scene.layout.BorderPane;

public class FormSa extends BaseCustomForm {
	private Tupple2<BorderPane, HomeMetroSaController> home;
	private Tupple2<BorderPane, PreparationAndSendingSaController> pelaporan;
	private Tupple2<BorderPane, PreparationAndSendingSaController> pelaporanKoreksi;
	private Tupple2<BorderPane, PreparationAndSendingSaController> pengkinian;
	private Tupple2<BorderPane, PreparationAndSendingSaController> pengkinianKoreksi;

	public FormSa(ApplicationContext appContext, MainApplication mainApplication) {
		super(appContext, mainApplication);
	}

	@Override
	protected void init() {
	}

	public Tupple2<BorderPane, HomeMetroSaController> getHome() {
		if (home == null) {
			showHome();
		}
		return home;
	}
	
	public void cleanUp() {
		home = null;
	}
	
	public Tupple2<BorderPane, PreparationAndSendingSaController> getPelaporan() {
		return pelaporan;
	}
	
	public Tupple2<BorderPane, PreparationAndSendingSaController> getPelaporanKoreksi() {
		return pelaporanKoreksi;
	}
	
	public Tupple2<BorderPane, PreparationAndSendingSaController> getPengkinian() {
		return pengkinian;
	}
	
	public Tupple2<BorderPane, PreparationAndSendingSaController> getPengkinianKoreksi() {
		return pengkinianKoreksi;
	}
	
	public void showHome() {
		home = UtilForm.initAndShowPane(mainApplication, "vc/HomeMetroSa.fxml", home, null, null, null);
	}

	public void showPelaporan() {
		pelaporan = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingSa.fxml", pelaporan,
				DisplayScene.pelaporanPreparationSa,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_SA1, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupSa.PELAPORAN.getMenuCode()),
				null);
	}

	public void showPelaporanKoreksi() {
		pelaporanKoreksi = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingSa.fxml", pelaporanKoreksi,
				DisplayScene.pelaporanKoreksiPreparationSa,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_SA1, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupSa.PELAPORAN_KOREKSI.getMenuCode()),
				null);
	}

	public void showPengkinian() {
		pengkinian = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingSa.fxml", pengkinian,
				DisplayScene.pengkinianPreparationSa,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_SA2, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupSa.PENGKINIAN.getMenuCode()),
				null);
	}

	public void showPengkinianKoreksi() {
		pengkinianKoreksi = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingSa.fxml", pengkinianKoreksi,
				DisplayScene.pengkinianKoreksiPreparationSa,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_SA2, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupSa.PENGKINIAN_KOREKSI.getMenuCode()),
				null);
	}

	public void progressSegment(ProgressSegment progressSegment, int reportFormGroupCode) {
		switch (reportFormGroupCode) {
		case 1:
			pelaporan.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		case 2:
			pelaporanKoreksi.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		default:
			break;
		}
	}
}
