package id.go.ojk.client;

import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.module.bpjs.EReportGroupBpjs;
import id.go.ojk.client.service.ConfigService;
import id.go.ojk.client.service.SubmissionService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.client.vc.HomeMetroBpjsControllerLBBPKS;
import id.go.ojk.client.vc.PreparationAndSendingBpjsController;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import javafx.scene.layout.BorderPane;

public class FormBpjsKs extends BaseCustomForm {
  private Tupple2<BorderPane, HomeMetroBpjsControllerLBBPKS> homeLBBPKS;
  private Tupple2<BorderPane, PreparationAndSendingBpjsController> lbbpkslkPreparation;
  private Tupple2<BorderPane, PreparationAndSendingBpjsController> lbbpksdjsPreparation;
  private Tupple2<BorderPane, PreparationAndSendingBpjsController> lbbpkslppPreparation;

  public FormBpjsKs(ApplicationContext appContext, MainApplication mainApplication) {
    super(appContext, mainApplication);
    init();
  }

  @Override
  void init() {
  }

  // LBBPKS
  public Tupple2<BorderPane, HomeMetroBpjsControllerLBBPKS> getHomeLBBPKS() {
    if (homeLBBPKS == null) {
      initHomeLBBPKS();
    }
    return homeLBBPKS;
  }

  public void showHome(UserSession userSession) {
    String reportCode = userSession.getReportCode();
    if (isHomeLBBPKS(reportCode)) {
      initHomeLBBPKS();
    } else {
      AlertUtil.showErrorSafe("Tidak dapat menemukan Home UI untuk " + reportCode, "");
    }
  }

  public boolean isHomeLBBPKS(String reportCode) {
    return reportCode.equals(EReport.BPKSLB.getCode());
  }

  private void initHomeLBBPKS() {
    homeLBBPKS = UtilForm.initAndShowPane(mainApplication, "vc/HomeMetroBpjsLBBPKS.fxml", homeLBBPKS, null, null, null);
  }

  public void cleanUp() {
    if (homeLBBPKS != null) {
      homeLBBPKS.getB().logout();
      homeLBBPKS = null;
    }
  }

  public void progressSegment(ProgressSegment progressSegment, int menuCode) {
    if (menuCode >= 1 && menuCode <= 3) {
      lbbpkslkPreparation.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
    } else if (menuCode >= 4 && menuCode <= 6) {
      lbbpksdjsPreparation.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
    } else if (menuCode >= 7 && menuCode <= 9) {
      lbbpkslppPreparation.getB().ensureVisibleDetailFileScrollPane(progressSegment.getPane());
    }
  }

  public void showLBBPKSLK() {
    lbbpkslkPreparation = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingBpjs.fxml",
        lbbpkslkPreparation, DisplayScene.LBBPKSLK, null, null);
    lbbpkslkPreparation.getB().setServiceAndBind(
        appContext.getService(ClientConstant.SUBMISSIION_SERVICE_BPJS, SubmissionService.class),
        ConfigService.submissionSourceDir, EReportGroupBpjs.LBBPKSLK_RUTIN.getMenuCode());
  }

  public void showLBBPKSDJS() {
    lbbpksdjsPreparation = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingBpjs.fxml",
        lbbpksdjsPreparation, DisplayScene.LBBPKSDJS, null, null);
    lbbpksdjsPreparation.getB().setServiceAndBind(
        appContext.getService(ClientConstant.SUBMISSIION_SERVICE_BPJS, SubmissionService.class),
        ConfigService.submissionSourceDir, EReportGroupBpjs.LBBPKSDJS_RUTIN.getMenuCode());
  }

  public void showLBBPKSLPP() {
    lbbpkslppPreparation = UtilForm.initAndShowPane(mainApplication, "vc/PreparationAndSendingBpjs.fxml",
        lbbpkslppPreparation, DisplayScene.LBBPKSLPP, null, null);
    lbbpkslppPreparation.getB().setServiceAndBind(
        appContext.getService(ClientConstant.SUBMISSIION_SERVICE_BPJS, SubmissionService.class),
        ConfigService.submissionSourceDir, EReportGroupBpjs.LBBPKSLPP_RUTIN.getMenuCode());
  }
}
