package id.go.ojk.client;

import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.module.lb.EReportGroupLb;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.client.vc.HomeMetroLbController;
import id.go.ojk.client.vc.PreparationAndSendingLbController;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import javafx.scene.layout.BorderPane;

public class FormLb extends BaseCustomForm {
	private Tupple2<BorderPane, HomeMetroLbController> home;
	private Tupple2<BorderPane, PreparationAndSendingLbController> pelaporan;
	private Tupple2<BorderPane, PreparationAndSendingLbController> perubahan;
	private Tupple2<BorderPane, PreparationAndSendingLbController> penyesuaian;
	private Tupple2<BorderPane, PreparationAndSendingLbController> penyesuaianKap;

	public FormLb(ApplicationContext appContext, MainApplication mainApplication) {
		super(appContext, mainApplication);
	}

	@Override
	protected void init() {
	}

	public Tupple2<BorderPane, HomeMetroLbController> getHome(UserSession userSession) {
		if (home == null) {
			showHome(userSession);
		}
		return home;
	}

	public void cleanUp() {
		home = null;
	}

	public Tupple2<BorderPane, PreparationAndSendingLbController> getPelaporan() {
		return pelaporan;
	}

	public Tupple2<BorderPane, PreparationAndSendingLbController> getPerubahan() {
		return perubahan;
	}

	public Tupple2<BorderPane, PreparationAndSendingLbController> getPenyesuaian() {
		return penyesuaian;
	}

	public Tupple2<BorderPane, PreparationAndSendingLbController> getPenyesuaianKap() {
		return penyesuaianKap;
	}

	public void showHome(UserSession userSession) {
		String reportCode = userSession != null ? userSession.getReportCode() : "";
		String fxml = "vc/HomeMetroLb.fxml";
		if (reportCode.equals(EReport.LB_PPIK.getCode()) || reportCode.equals(EReport.LB_PPIU.getCode())
				|| reportCode.equals(EReport.LB_PPIS.getCode()) || reportCode.equals(EReport.LB_PNJK.getCode()) ||
				reportCode.equals(EReport.LB_PNJU.getCode()) || reportCode.equals(EReport.LB_PNJS.getCode())) {
			fxml = "vc/HomeMetroLb2.fxml";
		} else if (reportCode.equals(EReport.LB_PNMK.getCode()) || reportCode.equals(EReport.LB_PNMU.getCode())) {
			fxml = "vc/HomeMetroLb3.fxml";

		} else if (reportCode.equals(EReport.LB_LPEIG.getCode()) || reportCode.equals(EReport.LB_LPEIU.getCode())) {
			fxml = "vc/HomeMetroLb4.fxml";
		}
		home = UtilForm.initAndShowPane(mainApplication, fxml, home, null, null, null);
	}

	public void showPelaporan() {
		pelaporan = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingLb.fxml", pelaporan,
				DisplayScene.rutinPreparationLb,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_LB1, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupLb.PELAPORAN.getMenuCode()),
				null);
	}

	public void showPerubahan() {
		perubahan = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingLb.fxml", perubahan,
				DisplayScene.perubahanPreparationLb,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_LB1, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupLb.PERUBAHAN.getMenuCode()),
				null);
	}

	public void showPenyesuaian() {
		penyesuaian = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingLb.fxml", penyesuaian,
				DisplayScene.penyesuaianPreparationLb,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_LB1, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupLb.PENYESUAIAN.getMenuCode()),
				null);
	}

	public void showPenyesuaian2() {
		penyesuaian = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingLb.fxml", penyesuaian,
				DisplayScene.penyesuaianPreparationLb2,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_LB1, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupLb.PENYESUAIAN_2.getMenuCode()),
				null);
	}

	public void showPenyesuaianKap() {
		penyesuaianKap = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingLb.fxml", penyesuaianKap,
				DisplayScene.penyesuaianKapPreparationLb,
				ui -> ui.getB().setServiceAndBind(
						appContext.getService(ClientConstant.SUBMISSIION_SERVICE_LB1, SubmissionService.class),
						ConfigService.submissionSourceDir, EReportGroupLb.PENYESUAIAN_KAP.getMenuCode()),
				null);
	}

	public void progressSegment(ProgressSegment progressSegment, int reportFormGroupCode) {
		switch (reportFormGroupCode) {
		case 1:
			pelaporan.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		case 2:
			perubahan.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		case 3:
			penyesuaian.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		case 4:
			penyesuaianKap.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
			break;
		default:
			break;
		}
	}
}
