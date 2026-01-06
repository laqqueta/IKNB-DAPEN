package id.go.ojk.client;

import id.go.ojk.client.constant.EReport;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.client.vc.HomeMetroBpjsControllerLABPTK;
import id.go.ojk.client.vc.HomeMetroBpjsControllerLKBPTK;
import id.go.ojk.client.vc.HomeMetroBpjsControllerLPBPTK;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.DisplayScene;
import id.go.ojk.lib.client.model.security.UserSession;
import id.go.ojk.lib.client.service.context.ApplicationContext;
import javafx.scene.layout.BorderPane;

public class FormBpjsTk extends BaseCustomForm {
  private final String LBBPTK = "LBBPTK"; // LK bulanan
  private final String LTBPTK = "LTBPTK"; // LK tahunan
  private final String LPBPTK = "LPBPTK"; // LPP
  private final String LABPTK = "LABPTK"; // Aktuaria

  private FormBpjsTkBase<HomeMetroBpjsControllerLKBPTK> formLb;
  private FormBpjsTkBase<HomeMetroBpjsControllerLPBPTK> formLp;
  private FormBpjsTkBase<HomeMetroBpjsControllerLABPTK> formLa;

  public FormBpjsTk(ApplicationContext appContext, MainApplication mainApplication) {
    super(appContext, mainApplication);
    formLb = new FormBpjsTkBase<HomeMetroBpjsControllerLKBPTK>(appContext, mainApplication,
        "vc/HomeMetroBpjsLKBPTK.fxml");
    formLp = new FormBpjsTkBase<HomeMetroBpjsControllerLPBPTK>(appContext, mainApplication,
        "vc/HomeMetroBpjsLPBPTK.fxml");
    formLa = new FormBpjsTkBase<HomeMetroBpjsControllerLABPTK>(appContext, mainApplication,
        "vc/HomeMetroBpjsLABPTK.fxml");
    init();
  }

  @Override
  void init() {
    formLb.init();
    formLp.init();
    formLa.init();
  }

  public void initHome(UserSession userSession) {
    String reportCode = userSession.getReportCode();
    if (reportCode.equals(EReport.BPTKLB.getCode()) || reportCode.equals(EReport.BPTKLT.getCode())) {
      formLb.initHome();
    } else if (reportCode.equals(EReport.BPTKLP.getCode())) {
      formLp.initHome();
    } else if (reportCode.equals(EReport.BPTKLA.getCode())) {
      formLa.initHome();
    } else {
      throw new SlikException("Tidak dapat menemukan Home UI untuk report code " + reportCode);
    }
  }

  public Tupple2<BorderPane, ?> getHome(String reportCode) {
    if (reportCode.equals(EReport.BPTKLB.getCode()) || reportCode.equals(EReport.BPTKLT.getCode())) {
      return formLb.getHome();
    } else if (reportCode.equals(EReport.BPTKLP.getCode())) {
      return formLp.getHome();
    } else if (reportCode.equals(EReport.BPTKLA.getCode())) {
      return formLa.getHome();
    } else {
      String errMsg = "Tidak dapat menemukan Home UI untuk report code " + reportCode;
      AlertUtil.showError(errMsg, null);
      throw new SlikException(errMsg);
    }
  }

  public void cleanUp() {
    formLb.dispose();
    formLp.dispose();
    formLa.dispose();
  }

  public void ensureVisibleScrollPane(ProgressSegment progressSegment, int menuCode) {
    formLb.ensureVisibleScrollPane(progressSegment);
    formLp.ensureVisibleScrollPane(progressSegment);
    formLa.ensureVisibleScrollPane(progressSegment);
  }

  public void showForm(DisplayScene scene) {
    if (scene.toString().startsWith(LBBPTK) || scene.toString().startsWith(LTBPTK)) {
      formLb.showForm(scene);
    } else if (scene.toString().startsWith(LPBPTK)) {
      formLp.showForm(scene);
    } else if (scene.toString().startsWith(LABPTK)) {
      formLa.showForm(scene);
    }
//    String errMsg = "Tidak dapat menemukan Home UI untuk " + scene;
//    AlertUtil.showError(errMsg, null);
//    throw new SlikException(errMsg);
  }
}
