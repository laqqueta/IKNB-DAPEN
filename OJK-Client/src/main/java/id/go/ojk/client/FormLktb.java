package id.go.ojk.client;

import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.module.lktb.EReportGroupLktb;
import id.go.ojk.client.module.tpp.EReportGroupTpp;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.client.vc.HomeMetroLktbController;
import id.go.ojk.client.vc.HomeMetroTppController;
import id.go.ojk.client.vc.PreparationAndSendingLktbController;
import id.go.ojk.client.vc.PreparationAndSendingTppController;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import javafx.scene.layout.BorderPane;
import lombok.Getter;

public class FormLktb extends BaseCustomForm {
	private Tupple2<BorderPane, HomeMetroLktbController> home;

	@Getter
    private Tupple2<BorderPane, PreparationAndSendingLktbController> tahunan;

    @Getter
	private Tupple2<BorderPane, PreparationAndSendingLktbController> bulanan;

	public FormLktb(ApplicationContext appContext, MainApplication mainApplication) {
		super(appContext, mainApplication);
	}

	@Override
	protected void init() {
	}

	public Tupple2<BorderPane, HomeMetroLktbController> getHome(UserSession userSession) {
		if (home == null) {
			showHome(userSession);
		}
		return home;
	}

	public void cleanUp() {
		home = null;
	}

	public void showHome(UserSession userSession) {
		String reportCode = userSession != null ? userSession.getReportCode() : "";

        if (!isFormAvailable(reportCode)) {
            AlertUtil.showErrorSafe("Tidak dapat menemukan Home UI untuk " + reportCode, "");
            return;
        }

        String fxml = "vc/HomeMetroLktb.fxml";
		home = UtilForm.initAndShowPane(mainApplication, fxml, home, null, null, null);
	}

    private boolean isFormAvailable(String reportCode) {
        return EReport.getReportByCode(reportCode) != null;
    }

	public void showTahunan() {
		tahunan = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingLktb.fxml", tahunan,
				DisplayScene.LKT_DP,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_LTLB, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupLktb.LKD_TAHUNAN_RUTIN.getMenuCode()),
				null);
	}

	public void showBulanan() {
		bulanan = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingLktb.fxml", bulanan,
                DisplayScene.LKB_DP,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_LTLB, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupLktb.LKD_BULANAN_RUTIN.getMenuCode()),
				null);
	}


	public void progressSegment(ProgressSegment progressSegment, int reportFormGroupCode) {
		switch (reportFormGroupCode) {
		case 1:
		case 2:
			tahunan.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		case 3:
		case 4:
			bulanan.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		default:
			break;
		}
	}
}
