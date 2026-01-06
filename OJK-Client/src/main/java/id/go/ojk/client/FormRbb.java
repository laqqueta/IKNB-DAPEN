package id.go.ojk.client;

import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.module.rb.EReportGroupRb;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.client.vc.HomeMetroRbbController;
import id.go.ojk.client.vc.PreparationAndSendingRbbController;
import id.go.ojk.client.vc.PreparationAndSendingRbbPelaporanController;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import javafx.scene.layout.BorderPane;

public class FormRbb extends BaseCustomForm {
	private Tupple2<BorderPane, HomeMetroRbbController> home;
	private Tupple2<BorderPane, PreparationAndSendingRbbPelaporanController> pelaporan;
	private Tupple2<BorderPane, PreparationAndSendingRbbController> realisasi;
	private Tupple2<BorderPane, PreparationAndSendingRbbController> pengawasan;

	public FormRbb(ApplicationContext appContext, MainApplication mainApplication) {
		super(appContext, mainApplication);
		init();
	}

	@Override
	protected void init() {
	}

	public Tupple2<BorderPane, HomeMetroRbbController> getHome() {
		if (home == null) {
			showHome();
		}
		return home;
	}
	
	public void cleanUp() {
		home = null;
	}
	
	public Tupple2<BorderPane, PreparationAndSendingRbbPelaporanController> getPelaporan() {
		return pelaporan;
	}
	
	public Tupple2<BorderPane, PreparationAndSendingRbbController> getRealisasi() {
		return realisasi;
	}
	
	public Tupple2<BorderPane, PreparationAndSendingRbbController> getPengawasan() {
		return pengawasan;
	}
	
	public void showHome() {
		home = UtilForm.initAndShowPane(mainApplication, "vc/HomeMetroRbb.fxml", home, null, null, null);
	}

	public void showPelaporanData() {
		pelaporan = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingRbbPelaporan.fxml",
				pelaporan, DisplayScene.pelaporanPreparationRbb,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_RBB1, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupRb.PELAPORAN.getMenuCode()),
				null);
	}

	public void showRealisasiData() {
		realisasi = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingRbb.fxml",
				realisasi, DisplayScene.realisasiPreparationRbb,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_RBB2, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupRb.REALISASI.getMenuCode()),
				null);
	}

	public void showPengawasanData() {
		pengawasan = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingRbb.fxml",
				pengawasan, DisplayScene.pengawasanPreparationRbb,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_RBB3, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupRb.PENGAWASAN.getMenuCode()),
				null);
	}

	public void progressSegment(ProgressSegment progressSegment, int reportFormGroupCode) {
		switch (reportFormGroupCode) {
		case 1:
		case 2:
		case 3:
			pelaporan.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		case 4:
			realisasi.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		case 5:
			pengawasan.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		default:
			break;
		}
	}
}
